-- ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени. Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;
select s.film_id, f.name, ss.film_id, ff.name, s."beginDate", s."endDate", ss."beginDate", ss."endDate" from session s
                                                                                                                 inner join  session ss on
        (ss."beginDate" > s."beginDate" and ss."beginDate" < s."endDate")
        or (ss."endDate" < s."beginDate" and ss."endDate" > s."beginDate")
            and s.id <> ss.id
                                                                                                                 left join film f on s.film_id = f.id
                                                                                                                 left join film ff on ss.film_id = ff.id
order by s."beginDate" asc



--     перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва. Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;

select f.name, s."beginDate", f.duration, ss."beginDate" nextfilm, (ss."beginDate" - s."endDate") as diff from session s
                                                                                                                   left join session ss on  ss."beginDate" > s."endDate" and s.id <> ss.id
                                                                                                                   left join film f on s.film_id = f.id
where  1=1 and abs(extract(epoch  from (ss."beginDate" - s."endDate"))) >= extract(epoch from interval '30 mins')
order by diff desc


--     список фильмов, для каждого — с указанием общего числа посетителей за все время, среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли). Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;


select fin.name, fin.customers, fin.avgCustPerSess, fin.summ  from (
                                                                       select ff.name,
                                                                              ff.cid     customers,
                                                                              case
                                                                                  when div(ff.cid, fc.sid) is null then 0
                                                                                  else div(ff.cid, fc.sid)
                                                                                  end as avgCustPerSess
                                                                               ,
                                                                              case
                                                                                  when ff.summ is null then 0
                                                                                  else ff.summ
                                                                                  end as summ
                                                                       from (
                                                                                select f.id, f.name, count(c.id) cid, sum(s.cost) summ
                                                                                from film f
                                                                                         left join session s on f.id = s.film_id
                                                                                         left join customer c on s.id = c.session_id
                                                                                group by f.id) ff
                                                                                left join (select s.film_id, count(s.id) sid from session s group by film_id) fc on ff.id = fc.film_id
                                                                       order by summ desc) fin
union all (
    select 'TOTAL' , itog.cid, div(itog.cid, ss.scount) avgCustPerSess, itog.summ
    from (select sum(s.cost) summ, count(c.id) cid
          from customer c
                   left join session s on c.session_id = s.id) itog
             left join (select count(s.id) scount from session s) ss on 1 = 1)





-- число посетителей и кассовые сборы,
-- сгруппированные по времени начала фильма:
-- с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.).


select *
from (
    select 'from 9:00 to 15:00' searchIntervalTime,  s."beginDate"::time beginTime,  count(c.id), sum(s.cost) from session s
                                                                                                                        left join customer c on s.id = c.session_id
    where s."beginDate"::time >= '9:00:00'::time and s."beginDate"::time < '15:00:00'::time
    group by beginTime) t1
union all (
    select 'from 15:00 to 18:00' searchIntervalTime, s."beginDate"::time beginTime,  count(c.id), sum(s.cost) from session s
                                                                                                                       left join customer c on s.id = c.session_id
    where s."beginDate"::time >= '15:00:00'::time and s."beginDate"::time < '18:00:00'::time
    group by beginTime
)
union all (
    select 'from 18:00 to 21:00' searchIntervalTime, s."beginDate"::time beginTime,  count(c.id), sum(s.cost) from session s
                                                                                                                       left join customer c on s.id = c.session_id
    where s."beginDate"::time >= '18:00:00'::time and s."beginDate"::time < '21:00:00'::time
    group by beginTime
)
union all (
    select 'from 21:00 to 00:00' searchIntervalTime, s."beginDate"::time beginTime,  count(c.id), sum(s.cost) from session s
                                                                                                                       left join customer c on s.id = c.session_id
    where s."beginDate"::time >= '21:00:00'::time and s."beginDate"::time < '23:59:59'::time
    group by beginTime
)

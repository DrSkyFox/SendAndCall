-- ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени. Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»

select s.film_id,
       f.name,
       ss.film_id,
       ff.name,
       s."beginDate",
       s."endDate",
       ss."beginDate",
       ss."endDate"
from session s
         inner join session ss on
        (ss."beginDate" > s."beginDate" and ss."beginDate" < s."endDate")
        or (ss."endDate" < s."beginDate" and ss."endDate" > s."beginDate")
            and s.id <> ss.id
         left join film f on s.film_id = f.id
         left join film ff on ss.film_id = ff.id
order by s."beginDate" asc


--     Перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва. Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;
select f.name, s."beginDate", f.duration, ss."beginDate" nextfilm, (ss."beginDate" - s."endDate") pauseDurations
from session s
         left join session ss on ss."beginDate" > s."endDate" and s.id <> ss.id
         left join film f on s.film_id = f.id
where 1 = 1
  and abs(extract(epoch from (ss."beginDate" - s."endDate"))) >= extract(epoch from interval '30 mins')
order by pauseDurations desc



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











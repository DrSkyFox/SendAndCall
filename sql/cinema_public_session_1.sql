create table session
(
    id          serial            not null
        constraint session_pk
            primary key,
    "beginDate" timestamp         not null,
    "endDate"   timestamp         not null,
    film_id     integer           not null
        constraint session_film_id_fk
            references film
            on delete set null,
    cost        integer default 0 not null
);

alter table session
    owner to postgres;

create index session_begindate_enddate_index
    on session ("beginDate", "endDate");

INSERT INTO public.session (id, "beginDate", "endDate", film_id, cost) VALUES (2, '2021-07-24 11:40:00.000000', '2021-07-24 15:30:00.000000', 2, 350);
INSERT INTO public.session (id, "beginDate", "endDate", film_id, cost) VALUES (3, '2021-07-24 15:35:00.000000', '2021-07-24 17:50:00.000000', 3, 350);
INSERT INTO public.session (id, "beginDate", "endDate", film_id, cost) VALUES (1, '2021-07-24 10:15:00.000000', '2021-07-24 11:45:00.000000', 1, 200);
INSERT INTO public.session (id, "beginDate", "endDate", film_id, cost) VALUES (4, '2021-07-24 17:55:00.000000', '2021-07-24 21:00:00.000000', 1, 400);
INSERT INTO public.session (id, "beginDate", "endDate", film_id, cost) VALUES (5, '2021-07-24 21:15:00.000000', '2021-07-24 23:50:00.000000', 6, 450);
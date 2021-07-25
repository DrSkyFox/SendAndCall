create table customer
(
    id         serial  not null
        constraint customer_pk
            primary key,
    session_id integer not null
        constraint customer_session_id_fk
            references session
            on delete set null
);

alter table customer
    owner to postgres;

create unique index customer_id_uindex
    on customer (id);

INSERT INTO public.customer (id, session_id) VALUES (1, 1);
INSERT INTO public.customer (id, session_id) VALUES (2, 3);
INSERT INTO public.customer (id, session_id) VALUES (3, 5);
INSERT INTO public.customer (id, session_id) VALUES (4, 5);
INSERT INTO public.customer (id, session_id) VALUES (5, 2);
INSERT INTO public.customer (id, session_id) VALUES (6, 2);
INSERT INTO public.customer (id, session_id) VALUES (7, 1);
INSERT INTO public.customer (id, session_id) VALUES (8, 1);
INSERT INTO public.customer (id, session_id) VALUES (9, 4);
INSERT INTO public.customer (id, session_id) VALUES (10, 4);
INSERT INTO public.customer (id, session_id) VALUES (11, 5);
INSERT INTO public.customer (id, session_id) VALUES (12, 2);
INSERT INTO public.customer (id, session_id) VALUES (13, 1);
INSERT INTO public.customer (id, session_id) VALUES (14, 3);
INSERT INTO public.customer (id, session_id) VALUES (15, 3);
INSERT INTO public.customer (id, session_id) VALUES (16, 3);
INSERT INTO public.customer (id, session_id) VALUES (17, 4);
INSERT INTO public.customer (id, session_id) VALUES (18, 3);
INSERT INTO public.customer (id, session_id) VALUES (19, 1);
INSERT INTO public.customer (id, session_id) VALUES (20, 1);
INSERT INTO public.customer (id, session_id) VALUES (21, 3);
INSERT INTO public.customer (id, session_id) VALUES (22, 2);
INSERT INTO public.customer (id, session_id) VALUES (23, 2);
INSERT INTO public.customer (id, session_id) VALUES (24, 2);
INSERT INTO public.customer (id, session_id) VALUES (25, 1);
INSERT INTO public.customer (id, session_id) VALUES (26, 5);
INSERT INTO public.customer (id, session_id) VALUES (27, 5);
INSERT INTO public.customer (id, session_id) VALUES (28, 4);
INSERT INTO public.customer (id, session_id) VALUES (29, 3);
INSERT INTO public.customer (id, session_id) VALUES (30, 2);
create table film
(
    id       serial      not null
        constraint film_pk
            primary key,
    name     varchar(64) not null,
    duration integer     not null
);

alter table film
    owner to postgres;

INSERT INTO public.film (id, name, duration) VALUES (1, 'Fairy Tail', 90);
INSERT INTO public.film (id, name, duration) VALUES (2, 'Harry Potter and Azbakan Runner ', 230);
INSERT INTO public.film (id, name, duration) VALUES (3, 'Spit', 118);
INSERT INTO public.film (id, name, duration) VALUES (4, 'LOTR', 240);
INSERT INTO public.film (id, name, duration) VALUES (5, 'Dark', 50);
INSERT INTO public.film (id, name, duration) VALUES (6, 'The Invisible', 140);
create table if not exists hotel.guest
(
    id         serial not null
        constraint guest_pk
            primary key,
    name       varchar,
    roomnumber integer,
    age        integer,
    idservice  integer
        constraint guest_service_id_fk
            references hotel.service
);

alter table hotel.guest
    owner to postgres;

create table if not exists hotel.service
(
	id serial not null
		constraint service_pk
			primary key,
	price integer,
	title varchar
);

alter table hotel.service owner to postgres;

alter table hotel.guest owner to postgres;

create table if not exists hotel.room
(
	idguest integer not null
		constraint room_fk
			references hotel.guest,
	number integer,
	price integer,
	status boolean default true,
	id serial not null
		constraint room_pk
			primary key
);

alter table hotel.room owner to postgres;

INSERT INTO hotel.guest (name, roomnumber, age, idservice)
values ('Гена', '111', '23', '5');

SELECT *
FROM hotel.guest
WHERE name NOT LIKE 'В%';

UPDATE hotel.guest
SET name = 'Иван',
    age  = 21
WHERE name LIKE 'В%';

DELETE
FROM hotel.guest
where age between 23 and 25;

SELECT number
FROM hotel.room
group by number
having number in (105, 115);

select case when age = 21 then 'Есть пользователи с возрастом 21' else '' end id, name, age
from hotel.guest;

select left(name, 2)
from hotel.guest
where age <> 21;

select g.id "id", g.roomnumber, g.age "age", s.id, s.title "title", s.price "price"
from hotel.service s
         left join hotel.guest g on g.idservice = s.id
union
select g.id "id", g.roomnumber, g.age "age", s.id, s.title "title", s.price "price"
from hotel.service s
         join hotel.guest g on g.idservice = s.id
ORDER BY age ASC, roomnumber DESC, title ASC
LIMIT 5
offset
3;

-- we don't know how to generate schema data (class Schema) :disappointed:
create table roles1111
(
    id bigint auto_increment,
    name varchar(255) not null,
    constraint id
        unique (id)
)
;

alter table roles1111
    add primary key (id)
;

create table users11111
(
    id bigint auto_increment,
    login varchar(150) null,
    firstname varchar(255) null,
    lastname varchar(255) null,
    password varchar(255) null,
    age mediumtext null,
    sex varchar(15) null,
    phone varchar(255) null,
    email varchar(255) null,
    constraint users_email_uindex
        unique (email),
    constraint users_id_uindex
        unique (id),
    constraint users_login_uindex
        unique (login),
    constraint users_phone_uindex
        unique (phone)
)
;

alter table users11111
    add primary key (id)
;

create table users_roles111
(
    user_id bigint not null,
    role_id bigint not null,
    constraint users_roles111_ibfk_1
        foreign key (user_id) references users11111 (id),
    constraint users_roles111_ibfk_2
        foreign key (role_id) references roles1111 (id)
)
;

create index role_id
    on users_roles111 (role_id)
;

create index user_id
    on users_roles111 (user_id)
;
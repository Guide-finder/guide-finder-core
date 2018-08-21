create table category
(
	id bigint auto_increment
		primary key,
	category varchar(255) not null,
	description varchar(255) null
)
;

create table country
(
	id bigint not null
		primary key,
	name varchar(128) not null
)
;

create table language
(
	id bigint auto_increment
		primary key,
	language varchar(70) null
)
;

create table region
(
	id bigint not null
		primary key,
	country_id bigint not null,
	name varchar(128) not null,
	constraint region_ibfk_1
		foreign key (country_id) references country (id)
			on delete cascade
)
;

create table city
(
	id bigint auto_increment
		primary key,
	region_id bigint not null,
	name varchar(128) not null,
	constraint city_id_uindex
		unique (id),
	constraint city_ibfk_1
		foreign key (region_id) references region (id)
			on delete cascade
)
;

create index region_id
	on city (region_id)
;

create index country_id
	on region (country_id)
;

create table user
(
	id bigint auto_increment
		primary key,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	password varchar(255) not null,
	phone bigint not null,
	email varchar(255) not null,
	sex int null,
	age int null,
	role int not null
)
;

create table commentary
(
	id bigint auto_increment
		primary key,
	author_id bigint not null,
	recipient_id bigint not null,
	message varchar(255) not null,
	rate bit null,
	constraint commentary_ibfk_1
		foreign key (author_id) references user (id),
	constraint commentary_ibfk_2
		foreign key (recipient_id) references user (id)
)
;

create index author_id
	on commentary (author_id)
;

create index recipient_id
	on commentary (recipient_id)
;

create table guide
(
	user_id bigint not null,
	city_id bigint null,
	description varchar(255) null,
	constraint guide_ibfk_1
		foreign key (user_id) references user (id),
	constraint guide_ibfk_2
		foreign key (city_id) references city (id)
)
;

create index city_id
	on guide (city_id)
;

create index user_id
	on guide (user_id)
;

create table socialcontact
(
	user_id bigint not null,
	vk varchar(255) null,
	ok varchar(225) null,
	fb varchar(255) null,
	tg varchar(255) null,
	constraint socialcontact_ibfk_1
		foreign key (user_id) references user (id)
)
;

create index user_id
	on socialcontact (user_id)
;

create table stuff
(
	user_id bigint not null,
	salary bigint null,
	constraint stuff_ibfk_1
		foreign key (user_id) references user (id)
)
;

create index user_id
	on stuff (user_id)
;

create table user_category
(
	user_id bigint not null,
	category_id bigint not null,
	constraint user_category_ibfk_1
		foreign key (user_id) references user (id),
	constraint user_category_ibfk_2
		foreign key (category_id) references category (id)
)
;

create index category_id
	on user_category (category_id)
;

create index user_id
	on user_category (user_id)
;

create table user_language
(
	user_id bigint not null,
	language_id bigint not null,
	constraint user_language_ibfk_1
		foreign key (user_id) references user (id),
	constraint user_language_ibfk_2
		foreign key (language_id) references language (id)
)
;

create index language_id
	on user_language (language_id)
;

create index user_id
	on user_language (user_id)
;


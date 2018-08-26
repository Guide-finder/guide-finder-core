/*
users
 */
INSERT INTO user (firstname, lastname, email, password, phone, age, sex)
VALUES ('Nick','Bondar','kol1@gmail.com','pass1','+72345678913',38,'MALE');
INSERT INTO user (firstname, lastname, email, password, phone, age, sex)
VALUES ('Nickolay','Bondarenko','kol2@gmail.com','pass2','+72345658913',28,'MALE');
INSERT INTO user (firstname, lastname, email, password, phone, age, sex)
VALUES ('Masha','Bond','masha@gmail.com','passMAsha','+73445678913',18,'FEMALE');
INSERT INTO user (firstname, lastname, email, password, phone, age, sex)
VALUES ('Ivan','Bondarenko','ivan@gmail.com','pass2ivan','+72341658913',48,'MALE');
INSERT INTO user (firstname, lastname, email, password, phone, age, sex)
VALUES ('Ira','Yo','ira@gmail.com','passIra','+77445678913',38,'FEMALE');
/*
category
 */
 INSERT INTO category (name, description) VALUES ('architecture','architectural tours');
 INSERT INTO category (name, description) VALUES ('restaurants','restaurant tours');
 INSERT INTO category (name, description) VALUES ('bars','bar tours');

/*
commentary
 */
INSERT INTO commentary (author_id, recipient_id, message) VALUES (2,3,'cool');
INSERT INTO commentary (author_id, recipient_id, message) VALUES (2,1,'sucks');
INSERT INTO commentary (author_id, recipient_id, message) VALUES (1,3,'very cool');
INSERT INTO commentary (author_id, recipient_id, message) VALUES (4,1,'sucks');
INSERT INTO commentary (author_id, recipient_id, message) VALUES (2,5,'very cool');

/*
language
 */
INSERT INTO language (name) VALUES ('eng');
INSERT INTO language (name) VALUES ('rus');
INSERT INTO language (name) VALUES ('fr');

/*
socials
 */
INSERT INTO socialcontact (user_id,vk, ok, fb, tg) VALUES (1,'vk_prof_1', 'ok_prof_1', 'fb_prof_1', 'fg_prof_1');
INSERT INTO socialcontact (user_id,vk, ok, fb, tg) VALUES (2,'vk_prof_2', 'ok_prof_2', 'fb_prof_2', 'fg_prof_2');
INSERT INTO socialcontact (user_id,vk, ok, fb, tg) VALUES (3,'vk_prof_3', 'ok_prof_3', 'fb_prof_3', 'fg_prof_3');
INSERT INTO socialcontact (user_id,vk, ok, fb, tg) VALUES (4,'vk_prof_4', 'ok_prof_4', 'fb_prof_4', 'fg_prof_4');
INSERT INTO socialcontact (user_id,vk, ok, fb, tg) VALUES (5,'vk_prof_5', 'ok_prof_5', 'fb_prof_5', 'fg_prof_5');
/*
stuff
 */
INSERT INTO staff(user_id, salary) VALUES (1, 150);
INSERT INTO staff(user_id, salary) VALUES (3, 125);

/*
user_category
 */
INSERT INTO user_category (user_id, category_id) VALUES (1,1);
INSERT INTO user_category (user_id, category_id) VALUES (2,2);
INSERT INTO user_category (user_id, category_id) VALUES (2,3);
INSERT INTO user_category (user_id, category_id) VALUES (3,1);
INSERT INTO user_category (user_id, category_id) VALUES (3,1);
INSERT INTO user_category (user_id, category_id) VALUES (4,2);
INSERT INTO user_category (user_id, category_id) VALUES (5,1);
INSERT INTO user_category (user_id, category_id) VALUES (5,2);
INSERT INTO user_category (user_id, category_id) VALUES (5,3);

/*
user_language
 */
INSERT INTO user_language(user_id, language_id) VALUES (1,1);
INSERT INTO user_language(user_id, language_id) VALUES (1,2);
INSERT INTO user_language(user_id, language_id) VALUES (2,2);
INSERT INTO user_language(user_id, language_id) VALUES (3,1);
INSERT INTO user_language(user_id, language_id) VALUES (3,2);
INSERT INTO user_language(user_id, language_id) VALUES (4,3);
INSERT INTO user_language(user_id, language_id) VALUES (5,2);

/*
country
 */
insert into country(id, name) values (1, 'Russia');
insert into country(id, name) values (2, 'Ukraine');
insert into country(id, name) values (3, 'Kazakhstan');

/*
region
 */
INSERT INTO region (id, country_id, name) VALUES (1,1, 'Center of Russia');
INSERT INTO region (id, country_id, name) VALUES (2,1, 'Siberia');
INSERT INTO region (id, country_id, name) VALUES (3,1, 'Far East');

INSERT INTO region (id, country_id, name) VALUES (4,2, 'KIev region');
INSERT INTO region (id, country_id, name) VALUES (5,2, 'Poltava region');
INSERT INTO region (id, country_id, name) VALUES (6,2, 'Vinnitsa region');

INSERT INTO region (id, country_id, name) VALUES (7,3, 'Astana region');
INSERT INTO region (id, country_id, name) VALUES (8,3, 'Almata region');
INSERT INTO region (id, country_id, name) VALUES (9,3, 'Karaganda region');
/*
city
 */
INSERT INTO city (region_id, name) VALUES (1, 'Moscow');
INSERT INTO city (region_id, name) VALUES (1, 'SPb');
INSERT INTO city (region_id, name) VALUES (2, 'Tomsk');
INSERT INTO city (region_id, name) VALUES (2, 'NSK');
INSERT INTO city (region_id, name) VALUES (3, 'Khabarovsk');
INSERT INTO city (region_id, name) VALUES (3, 'Vladivostok');

INSERT INTO city (region_id, name) VALUES (4, 'Kiev');
INSERT INTO city (region_id, name) VALUES (4, 'City in Kiev region');
INSERT INTO city (region_id, name) VALUES (5, 'Poltava');
INSERT INTO city (region_id, name) VALUES (5, 'City in Poltava region');
INSERT INTO city (region_id, name) VALUES (6, 'Vinnitsa');
INSERT INTO city (region_id, name) VALUES (6, 'City in Vinnitsa region');

INSERT INTO city (region_id, name) VALUES (7, 'Astana');
INSERT INTO city (region_id, name) VALUES (7, 'City in Astana region');
INSERT INTO city (region_id, name) VALUES (8, 'Almata');
INSERT INTO city (region_id, name) VALUES (8, 'City in Almata region');
INSERT INTO city (region_id, name) VALUES (9, 'Karaganda');
INSERT INTO city (region_id, name) VALUES (9, 'City in Karaganda region');
/*
role
 */
INSERT INTO role (id,name) VALUES (1, 'User');
INSERT INTO role (id,name) VALUES (2, 'Staff');
/*
guide
*/
insert into guide (user_id, city_id, description) VALUES (1,1,'Moscow guide');
insert into guide (user_id, city_id, description) VALUES (2,2,'SPb guide');
insert into guide (user_id, city_id, description) VALUES (3,7,'Kiev guide');
insert into guide (user_id, city_id, description) VALUES (4,9,'Poltava guide');
insert into guide (user_id, city_id, description) VALUES (5,15,'Almata guide');
/*
user_role
 */
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO user_role (user_id, role_id) VALUES (4, 1);
INSERT INTO user_role (user_id, role_id) VALUES (5, 2);

/*

 */
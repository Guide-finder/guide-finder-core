/*
users
 */
INSERT INTO user (firstname, lastname, password, phone, email, sex, age)  VALUES ('Nickolay','Bondarenko','123','+72345678913','kol@gmail.com','MALE',38);
INSERT INTO user (firstname, lastname, password, phone, email, sex, age)  VALUES ('Fedor','Emelyanenko','qwerty','+72345678815','fedya@gmail.com','MALE',40);
INSERT INTO user (firstname, lastname, password, phone, email, sex, age)  VALUES ('Bill','Klinton','dibil','+72888678913','billy@gmail.com','MALE',58);
INSERT INTO user (firstname, lastname, password, phone, email, sex, age)  VALUES ('Freddy','Klyuker','killthemall','+72345624313','kill@gmail.com','MALE',158);
INSERT INTO user (firstname, lastname, password, phone, email, sex, age)  VALUES ('Alla','Pugacheva','alla','+72341238913','alla@gmail.com','FEMALE',88);
INSERT INTO user (firstname, lastname, password, phone, email, sex, age)  VALUES ('Dmytro','K','098','+72889878913','dima@gmail.com','MALE',32);
INSERT INTO user (firstname, lastname, password, phone, email, sex, age)  VALUES ('Donald','Trump','alala','+72345699913','don@gmail.com','MALE',78);
INSERT INTO user (firstname, lastname, password, phone, email, sex, age)  VALUES ('Valentina','Tereshkova','valla','+72341234413','va@gmail.com','FEMALE',88);

/*
category
 */
INSERT INTO category (name, description) VALUES ('architecture','architectural tours');
INSERT INTO category (name, description) VALUES ('pubs','night life');
INSERT INTO category (name, description) VALUES ('restautants','cool meals');
INSERT INTO category (name, description) VALUES ('cinema','thriller');
INSERT INTO category (name, description) VALUES ('music','jazz');

/*
commentary
 */
INSERT INTO commentary (author_id, recipient_id, message, rate) VALUES (2,3,'cool', 1);

INSERT INTO commentary (author_id, recipient_id, message, rate) VALUES (1,3,'very cool', 1);


/*
language
 */
INSERT INTO language (name) VALUES ('eng');
INSERT INTO language (name) VALUES ('rus');
INSERT INTO language (name) VALUES ('fr');
INSERT INTO language (name) VALUES ('esp');
INSERT INTO language (name) VALUES ('ukr');

/*
socials
 */
INSERT INTO socialcontact (user_id, vk, ok, fb, tg) VALUES (1, 'vk_prof_1', 'ok_prof_1', 'fb_prof_1', 'fg_prof_1');
INSERT INTO socialcontact (user_id, vk, ok, fb, tg) VALUES (2, 'vk_prof_2', 'ok_prof_2', 'fb_prof_2', 'fg_prof_2');
INSERT INTO socialcontact (user_id, vk, ok, fb, tg) VALUES (3, 'vk_prof_3', 'ok_prof_3', 'fb_prof_3', 'fg_prof_3');



/*
stuff
 */
INSERT INTO staff(user_id, salary) VALUES (1, 150);
INSERT INTO staff(user_id, salary) VALUES (2, 120);
INSERT INTO staff(user_id, salary) VALUES (3, 125);

/*
user_category
 */
INSERT INTO user_category (user_id, category_id) VALUES (1,4);
INSERT INTO user_category (user_id, category_id) VALUES (1,5);
INSERT INTO user_category (user_id, category_id) VALUES (1,3);
INSERT INTO user_category (user_id, category_id) VALUES (3,5);
INSERT INTO user_category (user_id, category_id) VALUES (3,3);
INSERT INTO user_category (user_id, category_id) VALUES (2,4);
INSERT INTO user_category (user_id, category_id) VALUES (2,5);
INSERT INTO user_category (user_id, category_id) VALUES (7,4);
INSERT INTO user_category (user_id, category_id) VALUES (7,4);

/*
user_language
 */
INSERT INTO user_language(user_id, language_id) VALUES (6,1);
INSERT INTO user_language(user_id, language_id) VALUES (1,2);
INSERT INTO user_language(user_id, language_id) VALUES (1,4);
INSERT INTO user_language(user_id, language_id) VALUES (2,5);
INSERT INTO user_language(user_id, language_id) VALUES (2,4);
INSERT INTO user_language(user_id, language_id) VALUES (2,5);
INSERT INTO user_language(user_id, language_id) VALUES (3,1);
INSERT INTO user_language(user_id, language_id) VALUES (3,2);
INSERT INTO user_language(user_id, language_id) VALUES (3,3);

/*
users
 */
INSERT INTO user (first_name, last_name, password, phone, email, sex, age, role)  VALUES ('Nickolay','Bondarenko','123','+72345678913','kol@gmail.com',1,38,1);
INSERT INTO user (first_name, last_name, password, phone, email, sex, age, role)  VALUES ('Fedor','Emelyanenko','qwerty','+72345678815','fedya@gmail.com',1,40,1);
INSERT INTO user (first_name, last_name, password, phone, email, sex, age, role)  VALUES ('Bill','Klinton','dibil','+72888678913','billy@gmail.com',1,58,1);
INSERT INTO user (first_name, last_name, password, phone, email, sex, age, role)  VALUES ('Freddy','Klyuker','killthemall','+72345678913','kill@gmail.com',1,158,1);
INSERT INTO user (first_name, last_name, password, phone, email, sex, age, role)  VALUES ('Alla','Pugacheva','alla','+72341238913','alla@gmail.com',0,88,1);
INSERT INTO user (first_name, last_name, password, phone, email, sex, age, role)  VALUES ('Dmytro','K','098','+72889878913','dima@gmail.com',1,32,1);
INSERT INTO user (first_name, last_name, password, phone, email, sex, age, role)  VALUES ('Donald','Trump','alala','+72345699913','don@gmail.com',1,78,1);
INSERT INTO user (first_name, last_name, password, phone, email, sex, age, role)  VALUES ('Valentina','Tereshkova','valla','+72341234413','va@gmail.com',0,88,1);

/*
category
 */
INSERT INTO category (category, description) VALUES ('architecture','architectural tours');
INSERT INTO category (category, description) VALUES ('pubs','night life');
INSERT INTO category (category, description) VALUES ('restautants','cool meals');
INSERT INTO category (category, description) VALUES ('cinema','thriller');
INSERT INTO category (category, description) VALUES ('music','jazz');

/*
commentary
 */
INSERT INTO commentary (author_id, recipient_id, message, rate) VALUES (2,3,'cool', 1);
INSERT INTO commentary (author_id, recipient_id, message, rate) VALUES (2,4,'sucks', 0);
INSERT INTO commentary (author_id, recipient_id, message, rate) VALUES (1,3,'very cool', 1);
INSERT INTO commentary (author_id, recipient_id, message, rate) VALUES (2,6,'very good', 1);

/*
language
 */
INSERT INTO language (language) VALUES ('eng');
INSERT INTO language (language) VALUES ('rus');
INSERT INTO language (language) VALUES ('fr');
INSERT INTO language (language) VALUES ('esp');
INSERT INTO language (language) VALUES ('ukr');

/*
socials
 */
INSERT INTO socialcontact (user_id, vk, ok, fb, tg) VALUES (1, 'vk_prof_1', 'ok_prof_1', 'fb_prof_1', 'fg_prof_1');
INSERT INTO socialcontact (user_id, vk, ok, fb, tg) VALUES (2, 'vk_prof_2', 'ok_prof_2', 'fb_prof_2', 'fg_prof_2');
INSERT INTO socialcontact (user_id, vk, ok, fb, tg) VALUES (3, 'vk_prof_3', 'ok_prof_3', 'fb_prof_3', 'fg_prof_3');
INSERT INTO socialcontact (user_id, vk, ok, fb, tg) VALUES (4, 'vk_prof_4', 'ok_prof_4', 'fb_prof_4', 'fg_prof_4');
INSERT INTO socialcontact (user_id, vk, ok, fb, tg) VALUES (5, 'vk_prof_5', 'ok_prof_5', 'fb_prof_5', 'fg_prof_5');

/*
stuff
 */
INSERT INTO stuff(user_id, salary) VALUES (1, 150);
INSERT INTO stuff(user_id, salary) VALUES (2, 120);
INSERT INTO stuff(user_id, salary) VALUES (3, 125);

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
INSERT INTO user_language(user_id, language_id) VALUES (4,5);
INSERT INTO user_language(user_id, language_id) VALUES (4,4);
INSERT INTO user_language(user_id, language_id) VALUES (4,3);
INSERT INTO user_language(user_id, language_id) VALUES (6,2);
INSERT INTO user_language(user_id, language_id) VALUES (6,5);
INSERT INTO user_language(user_id, language_id) VALUES (8,4);
INSERT INTO user_language(user_id, language_id) VALUES (8,5);


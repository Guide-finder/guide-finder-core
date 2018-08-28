INSERT INTO guide_finder.category (id, name, description) VALUES (1, 'architecture', 'architectural tours');
INSERT INTO guide_finder.category (id, name, description) VALUES (2, 'pubs', 'night life');
INSERT INTO guide_finder.category (id, name, description) VALUES (3, 'restautants', 'cool meals');
INSERT INTO guide_finder.category (id, name, description) VALUES (4, 'cinema', 'thriller');
INSERT INTO guide_finder.category (id, name, description) VALUES (5, 'music', 'jazz');


INSERT INTO guide_finder.language (id, name) VALUES (1, 'eng');
INSERT INTO guide_finder.language (id, name) VALUES (2, 'rus');
INSERT INTO guide_finder.language (id, name) VALUES (3, 'fr');
INSERT INTO guide_finder.language (id, name) VALUES (4, 'esp');
INSERT INTO guide_finder.language (id, name) VALUES (5, 'ukr');

INSERT INTO guide_finder.role (id, name) VALUES (1, 'admin');
INSERT INTO guide_finder.role (id, name) VALUES (2, 'user');

INSERT INTO guide_finder.user (id, firstname, lastname, email, password, phone, age, sex) VALUES (1, 'Nickolay', 'Bondarenko', 'kol@gmail.com', '123', '+72345678913', 38, 'MAN');
INSERT INTO guide_finder.user (id, firstname, lastname, email, password, phone, age, sex) VALUES (3, 'Vasiliy', 'Petrov', 'vasiliy_p@gmail.com', 'passwd', '+72888678913', 58, 'MAN');
INSERT INTO guide_finder.user (id, firstname, lastname, email, password, phone, age, sex) VALUES (6, 'Петр', 'Дорохов', 'petr_dorohkov@gmail.com', 'killthemall', '+72345624313', 34, 'MAN');
INSERT INTO guide_finder.user (id, firstname, lastname, email, password, phone, age, sex) VALUES (7, 'Alla', 'Shitova', 'alla_sh@yandex.ru', 'alla', '+72341238913', 24, 'WOMAN');
INSERT INTO guide_finder.user (id, firstname, lastname, email, password, phone, age, sex) VALUES (8, 'Konstantin', 'Voronov', 'kostya_v@hotbox.ru', '098', '+72889878913', 32, 'MAN');
INSERT INTO guide_finder.user (id, firstname, lastname, email, password, phone, age, sex) VALUES (9, 'Donald', 'Trump', 'don@gmail.com', 'alala', '+72345699913', 43, 'MAN');
INSERT INTO guide_finder.user (id, firstname, lastname, email, password, phone, age, sex) VALUES (41, 'Didenko', 'Kuza', 'dikobob@gmail.com', 'qwer', '9268715230', 29, 'MAN');

INSERT INTO guide_finder.user_category (user_id, category_id) VALUES (1, 4);
INSERT INTO guide_finder.user_category (user_id, category_id) VALUES (1, 5);
INSERT INTO guide_finder.user_category (user_id, category_id) VALUES (1, 3);
INSERT INTO guide_finder.user_category (user_id, category_id) VALUES (3, 5);
INSERT INTO guide_finder.user_category (user_id, category_id) VALUES (3, 3);
INSERT INTO guide_finder.user_category (user_id, category_id) VALUES (7, 4);
INSERT INTO guide_finder.user_category (user_id, category_id) VALUES (7, 4);

INSERT INTO guide_finder.user_language (user_id, language_id) VALUES (6, 1);
INSERT INTO guide_finder.user_language (user_id, language_id) VALUES (1, 2);
INSERT INTO guide_finder.user_language (user_id, language_id) VALUES (1, 4);
INSERT INTO guide_finder.user_language (user_id, language_id) VALUES (3, 1);
INSERT INTO guide_finder.user_language (user_id, language_id) VALUES (3, 2);
INSERT INTO guide_finder.user_language (user_id, language_id) VALUES (3, 3);

INSERT INTO guide_finder.user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO guide_finder.user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO guide_finder.user_role (user_id, role_id) VALUES (6, 2);
INSERT INTO guide_finder.user_role (user_id, role_id) VALUES (7, 2);
INSERT INTO guide_finder.user_role (user_id, role_id) VALUES (8, 1);
INSERT INTO guide_finder.user_role (user_id, role_id) VALUES (9, 1);
INSERT INTO guide_finder.user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO guide_finder.user_role (user_id, role_id) VALUES (41, 2);
INSERT INTO guide_finder.user_role (user_id, role_id) VALUES (41, 1);

INSERT INTO guide_finder.commentary (id, author_id, recipient_id, message, rate) VALUES (5, 1, 3, 'very cool', true);

INSERT INTO guide_finder.socialcontact (user_id, vk, ok, fb, tg) VALUES (1, 'vk_prof_1', 'ok_prof_1', 'fb_prof_1', 'fg_prof_1');
INSERT INTO guide_finder.socialcontact (user_id, vk, ok, fb, tg) VALUES (3, 'vk_prof_3', 'ok_prof_3', 'fb_prof_3', 'fg_prof_3');

INSERT INTO guide_finder.staff (id, user_id, salary) VALUES (1, 1, 150);
INSERT INTO guide_finder.staff (id, user_id, salary) VALUES (3, 3, 125);

INSERT INTO guide_finder.guide (user_id, city_id, description) VALUES (1, 1, 'Прогулки по Москве');
INSERT INTO guide_finder.guide (user_id, city_id, description) VALUES (6, 173, 'Прогулки по Санкт-Петербургу');
INSERT INTO guide_finder.guide (user_id, city_id, description) VALUES (3, 70, 'Прогулки по Красногорск');

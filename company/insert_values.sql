INSERT INTO effect_zone(name)
VALUES ('Серце'),
       ('Нирки'),
       ('Легені'),
       ('Шлунок');

INSERT INTO post
VALUES ('Продавець'),
       ('Адміністратор');

INSERT INTO street
VALUES ('вул. Степана Бандери'),
       ('вул. Княгині Ольги');

INSERT INTO employee(name, surname, id_number, passport_number, experience, birthday, post, pharmacy_id)
VALUES ('Олег', 'Тест', '0013455450', '003452222', 2, '2000-11-12', 'Продавець', 1),
       ('Максим', 'Прізвище', '0013455430', '003456324', 3, '1999-05-10', 'Продавець', 2),
       ('Вадим', 'Прізвище', '0015255878', '028855488', 15, '1980-11-12', 'Адміністратор', 1);

INSERT INTO pharmacy(name, house_number, url, work_time_open, work_time_close, is_day_off_saturday, is_day_off_sunday,
                     street)
VALUES ('Аптека', 18, 'https://apteka.com', '10:00:00', '21:00:00', false, true, 'вул. Степана Бандери'),
       ('Сімейна аптека', 2, 'https://familiPharmacy.com.ua', '9:00:00', '24:00:00', false, false,
        'вул. Княгині Ольги');

INSERT INTO drug_list(name, code, need_receipt, is_narcotic, is_psychotropic)
VALUES ('Активоване вугілля', 'АБ-351-11', false, false, false),
       ('Ношпа', 'АБ-321-11', false, false, false),
       ('Магнікор', 'АБ-391-11', true, false, false);

INSERT INTO drug_zone_joint
VALUES (1, 4),
       (2, 3),
       (2, 4),
       (3, 1),
       (3, 2);

INSERT INTO pharmacy_drug_joint
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (2, 1),
       (2, 3),
       (2, 4);
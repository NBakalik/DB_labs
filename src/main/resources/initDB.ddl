SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

DROP SCHEMA IF EXISTS `bakalik_db`;
CREATE SCHEMA `bakalik_db` DEFAULT CHARACTER SET utf8;
use `bakalik_db`;

DROP TABLE IF EXISTS `bakalik_db`.`card_bonus`;
DROP TABLE IF EXISTS `bakalik_db`.`category`;
DROP TABLE IF EXISTS `bakalik_db`.`region`;
DROP TABLE IF EXISTS `bakalik_db`.`city`;
DROP TABLE IF EXISTS `bakalik_db`.`delivery`;
DROP TABLE IF EXISTS `bakalik_db`.`gender`;
DROP TABLE IF EXISTS `bakalik_db`.`item`;
DROP TABLE IF EXISTS `bakalik_db`.`order_status`;
DROP TABLE IF EXISTS `bakalik_db`.`user_card`;
DROP TABLE IF EXISTS `bakalik_db`.`user`;
DROP TABLE IF EXISTS `bakalik_db`.`order`;
DROP TABLE IF EXISTS `bakalik_db`.`order_has_item`;
DROP TABLE IF EXISTS `bakalik_db`.`sub_category`;
DROP TABLE IF EXISTS `bakalik_db`.`user_card_has_card_bonus`;

create TABLE `bakalik_db`.`card_bonus`
(
    `id`       INT            NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(45)    NOT NULL,
    `discount` DECIMAL(10, 0) NOT NULL,
    PRIMARY KEY (`id`)
);

create TABLE `bakalik_db`.`region`
(
    `id`     INT         NOT NULL AUTO_INCREMENT,
    `region` VARCHAR(35) NOT NULL,
    PRIMARY KEY (`id`)
);

create TABLE `bakalik_db`.`city`
(
    `id`        INT         NOT NULL AUTO_INCREMENT,
    `name`      VARCHAR(45) NOT NULL,
    `region_id` INT         NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_city_region1`
        FOREIGN KEY (`region_id`)
            REFERENCES `bakalik_db`.`region` (`id`) ON DELETE CASCADE
);

create INDEX `fk_city_region1_idx` ON `bakalik_db`.`city` (`region_id` ASC) VISIBLE;

create TABLE `bakalik_db`.`delivery`
(
    `id`   INT         NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);

create TABLE `bakalik_db`.`gender`
(
    `id`     INT         NOT NULL AUTO_INCREMENT,
    `gender` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
);

create TABLE `bakalik_db`.`category`
(
    `id`   INT         NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);

create TABLE IF NOT EXISTS `bakalik_db`.`sub_category`
(
    `id`          INT         NOT NULL AUTO_INCREMENT,
    `category_id` INT         NOT NULL,
    `name`        VARCHAR(35) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_sub_category_category1`
        FOREIGN KEY (`category_id`)
            REFERENCES `bakalik_db`.`category` (`id`) ON DELETE CASCADE
);

create INDEX `fk_sub_category_category1_idx` ON `bakalik_db`.`sub_category` (`category_id` ASC) VISIBLE;

create TABLE IF NOT EXISTS `bakalik_db`.`item`
(
    `id`              INT            NOT NULL AUTO_INCREMENT,
    `name`            VARCHAR(45)    NOT NULL,
    `description`     VARCHAR(45)    NOT NULL,
    `image`           VARCHAR(255)   NOT NULL,
    `brand`           VARCHAR(45)    NULL DEFAULT NULL,
    `model`           VARCHAR(45)    NULL DEFAULT NULL,
    `configuration`   VARCHAR(45)    NULL DEFAULT NULL,
    `price`           DECIMAL(10, 0) NOT NULL,
    `sub_category_id` INT            NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_item_sub_category1`
        FOREIGN KEY (`sub_category_id`)
            REFERENCES `bakalik_db`.`sub_category` (`id`) ON DELETE CASCADE
);

create INDEX `NameIndex` ON `bakalik_db`.`item` (`name` ASC) VISIBLE;

create TABLE `bakalik_db`.`order_status`
(
    `id`     INT         NOT NULL AUTO_INCREMENT,
    `status` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
);

create TABLE `bakalik_db`.`user_card`
(
    `id`   INT         NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);

create TABLE `bakalik_db`.`user`
(
    `id`             INT         NOT NULL AUTO_INCREMENT,
    `name`           VARCHAR(45) NOT NULL,
    `surname`        VARCHAR(45) NOT NULL,
    `birthday`       DATE        NULL DEFAULT NULL,
    `gender_id`      INT         NULL DEFAULT NULL,
    `city_id`        INT         NULL DEFAULT NULL,
    `street_address` VARCHAR(45) NULL DEFAULT NULL,
    `zip_code`       VARCHAR(5)  NULL DEFAULT NULL,
    `phone`          VARCHAR(15) NOT NULL,
    `email`          VARCHAR(45) NOT NULL,
    `registered_at`  DATETIME    NOT NULL,
    `user_card_id`   INT         NOT NULL,
    PRIMARY KEY (`id`, `name`, `surname`),
    CONSTRAINT `fk_user_city1`
        FOREIGN KEY (`city_id`)
            REFERENCES `bakalik_db`.`city` (`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_user_gender`
        FOREIGN KEY (`gender_id`)
            REFERENCES `bakalik_db`.`gender` (`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_user_user_card1`
        FOREIGN KEY (`user_card_id`)
            REFERENCES `bakalik_db`.`user_card` (`id`) ON DELETE CASCADE
);

create INDEX `fk_user_gender_idx` ON `bakalik_db`.`user` (`gender_id` ASC) VISIBLE;

create INDEX `fk_user_city1_idx` ON `bakalik_db`.`user` (`city_id` ASC) VISIBLE;

create INDEX `fk_user_user_card1_idx` ON `bakalik_db`.`user` (`user_card_id` ASC) VISIBLE;

create INDEX `NameSurnameIndex` ON `bakalik_db`.`user` (`name` ASC, `surname` ASC) VISIBLE;

create TABLE `bakalik_db`.`order`
(
    `id`           INT            NOT NULL AUTO_INCREMENT,
    `user_id`      INT            NOT NULL,
    `time`         DATETIME       NOT NULL,
    `city_id`      INT            NOT NULL,
    `delivery_id`  INT            NOT NULL,
    `total_price`  DECIMAL(10, 0) NOT NULL,
    `order_status` INT            NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_order_city1`
        FOREIGN KEY (`city_id`)
            REFERENCES `bakalik_db`.`city` (`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_order_delivery1`
        FOREIGN KEY (`delivery_id`)
            REFERENCES `bakalik_db`.`delivery` (`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_order_order_status1`
        FOREIGN KEY (`order_status`)
            REFERENCES `bakalik_db`.`order_status` (`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_order_user1`
        FOREIGN KEY (`user_id`)
            REFERENCES `bakalik_db`.`user` (`id`) ON DELETE CASCADE
);

create INDEX `fk_order_user1_idx` ON `bakalik_db`.`order` (`user_id` ASC) VISIBLE;

create INDEX `fk_order_city1_idx` ON `bakalik_db`.`order` (`city_id` ASC) VISIBLE;

create INDEX `fk_order_delivery1_idx` ON `bakalik_db`.`order` (`delivery_id` ASC) VISIBLE;

create INDEX `fk_order_order_status1_idx` ON `bakalik_db`.`order` (`order_status` ASC) VISIBLE;

create TABLE `bakalik_db`.`order_has_item`
(
    `order_id` INT NOT NULL,
    `item_id`  INT NOT NULL,
    `quantity` INT NOT NULL,
    PRIMARY KEY (`order_id`, `item_id`),
    CONSTRAINT `fk_order_has_item_item1`
        FOREIGN KEY (`item_id`)
            REFERENCES `bakalik_db`.`item` (`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_order_has_item_order1`
        FOREIGN KEY (`order_id`)
            REFERENCES `bakalik_db`.`order` (`id`) ON DELETE CASCADE
);

create INDEX `fk_order_has_item_item1_idx` ON `bakalik_db`.`order_has_item` (`item_id` ASC) VISIBLE;

create INDEX `fk_order_has_item_order1_idx` ON `bakalik_db`.`order_has_item` (`order_id` ASC) VISIBLE;

create TABLE `bakalik_db`.`user_card_has_card_bonus`
(
    `user_card_id`  INT NOT NULL,
    `card_bonus_id` INT NOT NULL,
    PRIMARY KEY (`user_card_id`, `card_bonus_id`),
    CONSTRAINT `fk_user_card_has_card_bonus_card_bonus1`
        FOREIGN KEY (`card_bonus_id`)
            REFERENCES `bakalik_db`.`card_bonus` (`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_user_card_has_card_bonus_user_card1`
        FOREIGN KEY (`user_card_id`)
            REFERENCES `bakalik_db`.`user_card` (`id`)
            ON DELETE CASCADE
);

create INDEX `fk_user_card_has_card_bonus_card_bonus1_idx` ON `bakalik_db`.`user_card_has_card_bonus` (`card_bonus_id` ASC) VISIBLE;

create INDEX `fk_user_card_has_card_bonus_user_card1_idx` ON `bakalik_db`.`user_card_has_card_bonus` (`user_card_id` ASC) VISIBLE;

SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;

insert into `card_bonus`
values (1, 'Чорна п\'ятниця', 3);
INSERT INTO `card_bonus`
VALUES (2, 'Особлива знижка для власників карти', 1);
INSERT INTO `card_bonus`
VALUES (3, 'Знижка для постійного клієнта', 5);

INSERT INTO `category`
VALUES (1, 'Ноутбуки та комп’ютери');
INSERT INTO `category`
VALUES (2, 'Смартфони, ТВ і електроніка');
INSERT INTO `category`
VALUES (3, 'Побутова техніка');
INSERT INTO `category`
VALUES (4, 'Товари для дому');
INSERT INTO `category`
VALUES (5, 'Інструменти та автотовари');
INSERT INTO `category`
VALUES (6, 'Сантехніка та ремонт');
INSERT INTO `category`
VALUES (7, 'Дача, сад і город');
INSERT INTO `category`
VALUES (8, 'Краса та здоров’я');
INSERT INTO `category`
VALUES (9, 'Алкогольні напої та продукти');
INSERT INTO `category`
VALUES (10, 'Одяг, взуття та прикраси');
INSERT INTO `category`
VALUES (11, 'Тури та відпочинок');

INSERT INTO `region`
VALUES (1, 'Івано-Франківська область');
INSERT INTO `region`
VALUES (2, 'Вінницька область');
INSERT INTO `region`
VALUES (3, 'Волинська область');
INSERT INTO `region`
VALUES (4, 'Дніпропетровська область');
INSERT INTO `region`
VALUES (5, 'Донецька область');
INSERT INTO `region`
VALUES (6, 'Житомирська область');
INSERT INTO `region`
VALUES (7, 'Закарпатська область');
INSERT INTO `region`
VALUES (8, 'Запорізька область');
INSERT INTO `region`
VALUES (9, 'Кіровоградська область');
INSERT INTO `region`
VALUES (10, 'Київська область');
INSERT INTO `region`
VALUES (11, 'Луганська область');
INSERT INTO `region`
VALUES (12, 'Львівська область');
INSERT INTO `region`
VALUES (13, 'Миколаївська область');
INSERT INTO `region`
VALUES (14, 'Одеська область');
INSERT INTO `region`
VALUES (15, 'Полтавська область');
INSERT INTO `region`
VALUES (16, 'Рівненська область');
INSERT INTO `region`
VALUES (17, 'Сумська область');

INSERT INTO `city`
VALUES (1, 'Львів', 12);
INSERT INTO `city`
VALUES (2, 'Київ', 10);
INSERT INTO `city`
VALUES (3, 'Дрогобич', 12);
INSERT INTO `city`
VALUES (4, 'Пустомити', 12);
INSERT INTO `city`
VALUES (5, 'Трускавець', 12);
INSERT INTO `city`
VALUES (6, 'Шацьк', 3);
INSERT INTO `city`
VALUES (7, 'Люблинець', 3);
INSERT INTO `city`
VALUES (8, 'Болехів', 1);
INSERT INTO `city`
VALUES (9, 'Надвірна', 1);
INSERT INTO `city`
VALUES (10, 'Яремче', 1);

INSERT INTO `delivery`
VALUES (1, 'Самовивіз');
INSERT INTO `delivery`
VALUES (2, 'Самовивіз з \"Нова пошта\"');
INSERT INTO `delivery`
VALUES (3, 'Кур\'єр \"Нова пошта\"');
insert into `delivery`
values (4, 'Самовивіз з \"Укр пошта\"');
insert into `delivery`
values (5, 'Кур\'єр \"Укр пошта\"');
INSERT INTO `delivery`
VALUES (6, '\"Justin\"');
INSERT INTO `delivery`
VALUES (7, '\"Meest express\"');

INSERT INTO `gender`
VALUES (1, 'чоловік');
INSERT INTO `gender`
VALUES (2, 'жінка');
INSERT INTO `gender`
VALUES (3, 'не визначено');

INSERT INTO `sub_category`
VALUES (1, 1, 'Аксесуари для ноутбуків і ПК');
INSERT INTO `sub_category`
VALUES (2, 1, 'Комплектуючi');
INSERT INTO `sub_category`
VALUES (3, 1, 'Ноутбуки');
INSERT INTO `sub_category`
VALUES (4, 2, 'Аксесуари до мобільних телефонів');
INSERT INTO `sub_category`
VALUES (5, 2, 'Телевізори та аксесуари');
INSERT INTO `sub_category`
VALUES (6, 4, 'Інвентар для дому та офісу');
INSERT INTO `sub_category`
VALUES (7, 5, 'Витратні матеріали та приладдя');
INSERT INTO `sub_category`
VALUES (8, 5, 'Електромонтажне обладнання');
INSERT INTO `sub_category`
VALUES (9, 7, 'Системи поливання');
INSERT INTO `sub_category`
VALUES (10, 9, 'Продукти');

INSERT INTO `item`
VALUES (1, 'Навушники', 'Безпровідні навушники', 'картинка', 'Xiaomi', 'AirDots', '-', 600, 4);
INSERT INTO `item`
VALUES (2, 'Смартфон', 'Смартфон Iphone 13', 'картинка', 'Iphone', '13', '-', 40000, 2);
INSERT INTO `item`
VALUES (3, 'Ноутбук', 'Геймерський ноутбук', 'картинка', 'Asus', 'Rog Strix G', '-', 27000, 3);
INSERT INTO `item`
VALUES (4, 'Віскі', 'Віскі WIlliam Lawson\'s 3 роки 0.5 л 40%', 'картинка', 'WIlliam Lawson\'s', '-', '-', 190, 10);
INSERT INTO `item`
VALUES (5, 'Шліфмашина', 'Ексцентрикова шліфмашина Intertool', 'картинка', 'Intertool Storm', 'WT-0541', '-', 625, 8);
INSERT INTO `item`
VALUES (6, 'Подушка', 'Набір подушок Sleepingg 50х70 2 шт.', 'картинка', 'Sleepingg ', '50х70', '-', 240, 6);
INSERT INTO `item`
VALUES (7, 'Ванна', 'ANTHEUS Duo Ванная кварил', 'картинка', 'ANTHEUS ', '1750x800', 'Duo', 184844, 6);
INSERT INTO `item`
VALUES (8, 'Кросівки', 'Кросівки Puma Wild Rider', 'картинка', 'Puma', 'Wild Rider', '-', 3200, 6);

INSERT INTO `order_status`
VALUES (1, 'В очікуванні');
INSERT INTO `order_status`
VALUES (2, 'Відправлений');
INSERT INTO `order_status`
VALUES (3, 'Завершено');
INSERT INTO `order_status`
VALUES (4, 'Комплектується');
INSERT INTO `order_status`
VALUES (5, 'Очікує оплати');
INSERT INTO `order_status`
VALUES (6, 'Повернення платежу');
INSERT INTO `order_status`
VALUES (7, 'Тимчасово затриманий');

INSERT INTO `user_card`
VALUES (1, 'Бронзова карта');
INSERT INTO `user_card`
VALUES (2, 'Срібна карта');
INSERT INTO `user_card`
VALUES (3, 'Золота карта');
INSERT INTO `user_card`
VALUES (4, 'Платинова карта');

INSERT INTO `user`
VALUES (2, 'Максим', 'Максим', '2020-03-01', 1, 1, 'вул. Шевченка', '79007', '0992233441', 'maksym@gmail.com',
        '2020-02-01 00:00:00', 1);
INSERT INTO `user`
VALUES (3, 'Олег', 'Петруняк', '2000-09-02', 1, 1, 'вул. Кульпарківська', '79068', '0995576121', 'oleg@gmail.com',
        '2019-10-11 12:34:23', 1);
INSERT INTO `user`
VALUES (4, 'Ольга', 'Войневич', '1980-09-02', 2, 3, 'вул. Шевченка 11/12', '00101', '0971274221', 'olga@gmail.com',
        '2019-10-11 11:47:32', 2);
INSERT INTO `user`
VALUES (5, 'Тарас', 'Терещук', '1979-10-11', 1, 7, 'вул. Франка 9/12', '12322', '0961345324', 'Taras@gmail.com',
        '2018-01-13 15:24:33', 2);
INSERT INTO `user`
VALUES (6, 'Макс', 'Боженко', '1980-12-12', 1, 6, 'вул. Лесі Українки 24/56', '54677', '0971456574', 'max@gmail.com',
        '2019-10-11 21:36:41', 2);
INSERT INTO `user`
VALUES (7, 'Саша', 'Семеніхін', '1960-10-24', 3, 5, 'вул. Герїв УПА 01/98', '23334', '0971546457', 'sasha@gmail.com',
        '2017-01-12 11:54:12', 3);
INSERT INTO `user`
VALUES (8, 'Віка', 'Скороход', '1975-05-12', 2, 1, 'вул. Городоцька 34/78', '82334', '0971289734', 'vika@mail.ru',
        '2019-10-11 18:41:13', 1);
INSERT INTO `user`
VALUES (9, 'Назар', 'Галайчук', '1997-01-27', 1, 3, 'вул. Шевченка 12/102', '65444', '0971735671', 'nazar@gmail.com',
        '2020-06-01 16:32:56', 1);
INSERT INTO `user`
VALUES (10, 'Олександр', 'Терещук', '1954-03-02', 1, 3, 'вул. Шевченка 11/12', '23111', '0989346341',
        'oleksandr@gmail.com', '2019-07-03 15:46:43', 4);

INSERT INTO `order`
VALUES (1, 2, '2020-02-01 00:00:00', 1, 2, 1000, 4);
INSERT INTO `order`
VALUES (2, 2, '2021-08-21 14:54:23', 1, 2, 230, 1);
INSERT INTO `order`
VALUES (3, 2, '2020-10-11 13:23:11', 1, 2, 2300, 2);
INSERT INTO `order`
VALUES (4, 3, '2020-11-03 23:32:10', 1, 3, 32000, 2);
INSERT INTO `order`
VALUES (5, 4, '2020-06-01 10:45:23', 3, 7, 1890, 6);
INSERT INTO `order`
VALUES (6, 5, '2020-02-01 13:44:23', 7, 3, 2346, 7);
INSERT INTO `order`
VALUES (7, 5, '2020-09-23 23:56:51', 7, 7, 2300, 5);
INSERT INTO `order`
VALUES (8, 6, '2020-12-21 10:12:56', 6, 4, 5400, 3);
INSERT INTO `order`
VALUES (9, 8, '2020-02-01 01:10:34', 1, 3, 420, 3);

INSERT INTO `order_has_item`
VALUES (1, 1, 1);
INSERT INTO `order_has_item`
VALUES (2, 3, 2);
INSERT INTO `order_has_item`
VALUES (3, 2, 1);
INSERT INTO `order_has_item`
VALUES (4, 4, 1);
INSERT INTO `order_has_item`
VALUES (4, 5, 2);
INSERT INTO `order_has_item`
VALUES (5, 8, 1);
INSERT INTO `order_has_item`
VALUES (6, 7, 1);
INSERT INTO `order_has_item`
VALUES (7, 8, 3);
INSERT INTO `order_has_item`
VALUES (8, 2, 1);
INSERT INTO `order_has_item`
VALUES (9, 1, 1);

INSERT INTO `user_card_has_card_bonus`
VALUES (1, 1);
INSERT INTO `user_card_has_card_bonus`
VALUES (2, 1);
INSERT INTO `user_card_has_card_bonus`
VALUES (3, 1);
INSERT INTO `user_card_has_card_bonus`
VALUES (4, 1);
INSERT INTO `user_card_has_card_bonus`
VALUES (3, 2);
INSERT INTO `user_card_has_card_bonus`
VALUES (4, 2);
INSERT INTO `user_card_has_card_bonus`
VALUES (4, 3);

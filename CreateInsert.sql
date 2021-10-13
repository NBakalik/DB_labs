-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bakalik_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bakalik_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bakalik_db` DEFAULT CHARACTER SET utf8 ;
USE `bakalik_db` ;

-- -----------------------------------------------------
-- Table `bakalik_db`.`card_bonus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bakalik_db`.`card_bonus` ;

CREATE TABLE IF NOT EXISTS `bakalik_db`.`card_bonus` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `discount` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bakalik_db`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bakalik_db`.`category` ;

CREATE TABLE IF NOT EXISTS `bakalik_db`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bakalik_db`.`region`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bakalik_db`.`region` ;

CREATE TABLE IF NOT EXISTS `bakalik_db`.`region` (
  `region` VARCHAR(35) NOT NULL,
  PRIMARY KEY (`region`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bakalik_db`.`city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bakalik_db`.`city` ;

CREATE TABLE IF NOT EXISTS `bakalik_db`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `region_region` VARCHAR(35) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_city_region1_idx` (`region_region` ASC) VISIBLE,
  CONSTRAINT `fk_city_region1`
    FOREIGN KEY (`region_region`)
    REFERENCES `bakalik_db`.`region` (`region`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bakalik_db`.`delivery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bakalik_db`.`delivery` ;

CREATE TABLE IF NOT EXISTS `bakalik_db`.`delivery` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bakalik_db`.`gender`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bakalik_db`.`gender` ;

CREATE TABLE IF NOT EXISTS `bakalik_db`.`gender` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `gender` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bakalik_db`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bakalik_db`.`item` ;

CREATE TABLE IF NOT EXISTS `bakalik_db`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `category_id` INT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `image` VARCHAR(255) NOT NULL,
  `brand` VARCHAR(45) NULL DEFAULT NULL,
  `model` VARCHAR(45) NULL DEFAULT NULL,
  `configuration` VARCHAR(45) NULL DEFAULT NULL,
  `price` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_item_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_item_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `bakalik_db`.`category` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bakalik_db`.`item_review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bakalik_db`.`item_review` ;

CREATE TABLE IF NOT EXISTS `bakalik_db`.`item_review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `item_id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `rating` INT NULL DEFAULT NULL,
  `published_at` DATETIME NOT NULL,
  `content` MEDIUMTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_item_review_item1_idx` (`item_id` ASC) VISIBLE,
  CONSTRAINT `fk_item_review_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `bakalik_db`.`item` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bakalik_db`.`order_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bakalik_db`.`order_status` ;

CREATE TABLE IF NOT EXISTS `bakalik_db`.`order_status` (
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`status`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bakalik_db`.`user_card`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bakalik_db`.`user_card` ;

CREATE TABLE IF NOT EXISTS `bakalik_db`.`user_card` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bakalik_db`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bakalik_db`.`user` ;

CREATE TABLE IF NOT EXISTS `bakalik_db`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `birthday` DATE NULL DEFAULT NULL,
  `gender_id` INT NULL DEFAULT NULL,
  `city_id` INT NULL DEFAULT NULL,
  `street_address` VARCHAR(45) NULL DEFAULT NULL,
  `zip_code` VARCHAR(5) NULL DEFAULT NULL,
  `phone` VARCHAR(15) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `registred_at` DATETIME NOT NULL,
  `last_login` DATETIME NULL DEFAULT NULL,
  `user_card_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_gender_idx` (`gender_id` ASC) VISIBLE,
  INDEX `fk_user_city1_idx` (`city_id` ASC) VISIBLE,
  INDEX `fk_user_user_card1_idx` (`user_card_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `bakalik_db`.`city` (`id`),
  CONSTRAINT `fk_user_gender`
    FOREIGN KEY (`gender_id`)
    REFERENCES `bakalik_db`.`gender` (`id`),
  CONSTRAINT `fk_user_user_card1`
    FOREIGN KEY (`user_card_id`)
    REFERENCES `bakalik_db`.`user_card` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bakalik_db`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bakalik_db`.`order` ;

CREATE TABLE IF NOT EXISTS `bakalik_db`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `time` DATETIME NOT NULL,
  `city_id` INT NOT NULL,
  `delivery_id` INT NOT NULL,
  `total_price` DECIMAL(10,0) NOT NULL,
  `order_status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_order_city1_idx` (`city_id` ASC) VISIBLE,
  INDEX `fk_order_delivery1_idx` (`delivery_id` ASC) VISIBLE,
  INDEX `fk_order_order_status1_idx` (`order_status` ASC) VISIBLE,
  CONSTRAINT `fk_order_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `bakalik_db`.`city` (`id`),
  CONSTRAINT `fk_order_delivery1`
    FOREIGN KEY (`delivery_id`)
    REFERENCES `bakalik_db`.`delivery` (`id`),
  CONSTRAINT `fk_order_order_status1`
    FOREIGN KEY (`order_status`)
    REFERENCES `bakalik_db`.`order_status` (`status`),
  CONSTRAINT `fk_order_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `bakalik_db`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bakalik_db`.`order_has_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bakalik_db`.`order_has_item` ;

CREATE TABLE IF NOT EXISTS `bakalik_db`.`order_has_item` (
  `order_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`order_id`, `item_id`),
  INDEX `fk_order_has_item_item1_idx` (`item_id` ASC) VISIBLE,
  INDEX `fk_order_has_item_order1_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_has_item_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `bakalik_db`.`item` (`id`),
  CONSTRAINT `fk_order_has_item_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `bakalik_db`.`order` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bakalik_db`.`sub_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bakalik_db`.`sub_category` ;

CREATE TABLE IF NOT EXISTS `bakalik_db`.`sub_category` (
  `category_id` INT NOT NULL,
  `name` VARCHAR(35) NOT NULL,
  PRIMARY KEY (`category_id`, `name`),
  INDEX `fk_sub_category_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_sub_category_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `bakalik_db`.`category` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bakalik_db`.`user_card_has_card_bonus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bakalik_db`.`user_card_has_card_bonus` ;

CREATE TABLE IF NOT EXISTS `bakalik_db`.`user_card_has_card_bonus` (
  `user_card_id` INT NOT NULL,
  `card_bonus_id` INT NOT NULL,
  PRIMARY KEY (`user_card_id`, `card_bonus_id`),
  INDEX `fk_user_card_has_card_bonus_card_bonus1_idx` (`card_bonus_id` ASC) VISIBLE,
  INDEX `fk_user_card_has_card_bonus_user_card1_idx` (`user_card_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_card_has_card_bonus_card_bonus1`
    FOREIGN KEY (`card_bonus_id`)
    REFERENCES `bakalik_db`.`card_bonus` (`id`),
  CONSTRAINT `fk_user_card_has_card_bonus_user_card1`
    FOREIGN KEY (`user_card_id`)
    REFERENCES `bakalik_db`.`user_card` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


INSERT INTO `card_bonus` VALUES (1,'Чорна п\'ятниця',3);
INSERT INTO `card_bonus` VALUES (2,'Особлива знижка для власників карти',1);
INSERT INTO `card_bonus` VALUES (3,'Знижка для постійного клієнта',5);

INSERT INTO `category` VALUES (1,'Ноутбуки та комп’ютери');
INSERT INTO `category` VALUES (2,'Смартфони, ТВ і електроніка');
INSERT INTO `category` VALUES (3,'Побутова техніка');
INSERT INTO `category` VALUES (4,'Товари для дому');
INSERT INTO `category` VALUES (5,'Інструменти та автотовари');
INSERT INTO `category` VALUES (6,'Сантехніка та ремонт');
INSERT INTO `category` VALUES (7,'Дача, сад і город');
INSERT INTO `category` VALUES (8,'Краса та здоров’я');
INSERT INTO `category` VALUES (9,'Алкогольні напої та продукти');
INSERT INTO `category` VALUES (10,'Одяг, взуття та прикраси');
INSERT INTO `category` VALUES (11,'Тури та відпочинок');

INSERT INTO `city` VALUES (1,'Львів','Львівська область');
INSERT INTO `city` VALUES (3,'Київ','Київська область');
INSERT INTO `city` VALUES (4,'Дрогобич','Львівська область');
INSERT INTO `city` VALUES (5,'Пустомити','Львівська область');
INSERT INTO `city` VALUES (6,'Трускавець','Львівська область');
INSERT INTO `city` VALUES (7,'Шацьк','Волинська область');
INSERT INTO `city` VALUES (8,'Люблинець','Волинська область');
INSERT INTO `city` VALUES (9,'Болехів','Івано-Франківська область');
INSERT INTO `city` VALUES (10,'Надвірна','Івано-Франківська область');
INSERT INTO `city` VALUES (11,'Яремче','Івано-Франківська область');

INSERT INTO `delivery` VALUES (1,'Самовивіз');
INSERT INTO `delivery` VALUES (2,'Самовивіз з \"Нова пошта\"');
INSERT INTO `delivery` VALUES (3,'Кур\'єр \"Нова пошта\"');
INSERT INTO `delivery` VALUES (4,'Самовивіз з \"Укр пошта\"');
INSERT INTO `delivery` VALUES (5,'Кур\'єр \"Укр пошта\"');
INSERT INTO `delivery` VALUES (6,'\"Justin\"');
INSERT INTO `delivery` VALUES (7,'\"Meest express\"');

INSERT INTO `gender` VALUES (1,'чоловік');
INSERT INTO `gender` VALUES (2,'жінка');
INSERT INTO `gender` VALUES (3,'не визначено');

INSERT INTO `item` VALUES (1,'Навушники',2,'Безпровідні навушники','картинка','Xiaomi','AirDots','-',600);
INSERT INTO `item` VALUES (2,'Смартфон',2,'Смартфон Iphone 13','картинка','Iphone','13','-',40000);
INSERT INTO `item` VALUES (3,'Ноутбук',1,'Геймерський ноутбук','картинка','Asus','Rog Strix G','-',27000);
INSERT INTO `item` VALUES (4,'Віскі',9,'Віскі WIlliam Lawson\'s 3 роки 0.5 л 40%','картинка','WIlliam Lawson\'s','-','-',190);
INSERT INTO `item` VALUES (5,'Шліфмашина',5,'Ексцентрикова шліфмашина Intertool','картинка','Intertool Storm','WT-0541','-',625);
INSERT INTO `item` VALUES (6,'Подушка',4,'Набір подушок Sleepingg 50х70 2 шт.','картинка','Sleepingg ','50х70','-',240);
INSERT INTO `item` VALUES (7,'Ванна',6,'ANTHEUS Duo Ванная кварил','картинка','ANTHEUS ','1750x800','Duo',184844);
INSERT INTO `item` VALUES (8,'Кросівки',10,'Кросівки Puma Wild Rider','картинка','Puma','Wild Rider','-',3200);

INSERT INTO `item_review` VALUES (2,1,'Андрій Беляк',5,'2020-02-01 00:00:00','Вдруге купую ці навушники. Якість відмінна!');
INSERT INTO `item_review` VALUES (3,1,'Сергей Избаш',4,'2021-08-04 00:00:00','Якість відмінна!');
INSERT INTO `item_review` VALUES (4,2,'Себастьян Перейро',4,'2021-03-06 12:05:34','Придбали на заміну iPhone SE (1st). Все чудово! Доставка Rozetka як завжди на висоті!');
INSERT INTO `item_review` VALUES (5,2,'Євген Кульчицький',4,'2021-03-02 21:01:32','Все чудово!');
INSERT INTO `item_review` VALUES (6,4,'Артем',4,'2021-01-06 12:05:34','Класс!');
INSERT INTO `item_review` VALUES (7,5,'Олег Александрович',5,'2021-09-01 16:05:19','Доставили вчасно)');
INSERT INTO `item_review` VALUES (8,5,'Юрий Титов',5,'2021-07-11 22:15:34','Відмінно!');
INSERT INTO `item_review` VALUES (9,7,'Роман',5,'2021-02-10 04:24:12','Все сподобалось)');
INSERT INTO `item_review` VALUES (10,8,'Артем Деркач',4,'2021-03-06 21:57:56','Доставка на висоті)');

INSERT INTO `order` VALUES (1,2,'2020-02-01 00:00:00',1,2,1000,'Завершено');
INSERT INTO `order` VALUES (2,2,'2021-08-21 14:54:23',1,2,230,'В очікуванні');
INSERT INTO `order` VALUES (3,2,'2020-10-11 13:23:11',1,2,2300,'Відправлений');
INSERT INTO `order` VALUES (4,3,'2020-11-03 23:32:10',1,3,32000,'Завершено');
INSERT INTO `order` VALUES (5,4,'2020-06-01 10:45:23',3,7,1890,'Відправлений');
INSERT INTO `order` VALUES (6,5,'2020-02-01 13:44:23',7,3,2346,'Комплектується');
INSERT INTO `order` VALUES (7,5,'2020-09-23 23:56:51',7,7,2300,'Очікує оплати');
INSERT INTO `order` VALUES (8,6,'2020-12-21 10:12:56',6,4,5400,'В очікуванні');
INSERT INTO `order` VALUES (9,8,'2020-02-01 01:10:34',1,3,420,'Відправлений');

INSERT INTO `order_has_item` VALUES (1,1,1);
INSERT INTO `order_has_item` VALUES (2,3,2);
INSERT INTO `order_has_item` VALUES (3,2,1);
INSERT INTO `order_has_item` VALUES (4,4,1);
INSERT INTO `order_has_item` VALUES (4,5,2);
INSERT INTO `order_has_item` VALUES (5,8,1);
INSERT INTO `order_has_item` VALUES (6,7,1);
INSERT INTO `order_has_item` VALUES (7,8,3);
INSERT INTO `order_has_item` VALUES (8,2,1);
INSERT INTO `order_has_item` VALUES (9,1,1);

INSERT INTO `order_status` VALUES ('В очікуванні');
INSERT INTO `order_status` VALUES ('Відправлений');
INSERT INTO `order_status` VALUES ('Завершено');
INSERT INTO `order_status` VALUES ('Комплектується');
INSERT INTO `order_status` VALUES ('Очікує оплати');
INSERT INTO `order_status` VALUES ('Повернення платежу');
INSERT INTO `order_status` VALUES ('Тимчасово затриманий');

INSERT INTO `region` VALUES ('Івано-Франківська область');
INSERT INTO `region` VALUES ('Вінницька область');
INSERT INTO `region` VALUES ('Волинська область');
INSERT INTO `region` VALUES ('Дніпропетровська область');
INSERT INTO `region` VALUES ('Донецька область');
INSERT INTO `region` VALUES ('Житомирська область');
INSERT INTO `region` VALUES ('Закарпатська область');
INSERT INTO `region` VALUES ('Запорізька область');
INSERT INTO `region` VALUES ('Кіровоградська область');
INSERT INTO `region` VALUES ('Київська область');
INSERT INTO `region` VALUES ('Луганська область');
INSERT INTO `region` VALUES ('Львівська область');
INSERT INTO `region` VALUES ('Миколаївська область');
INSERT INTO `region` VALUES ('Одеська область');
INSERT INTO `region` VALUES ('Полтавська область');
INSERT INTO `region` VALUES ('Рівненська область');
INSERT INTO `region` VALUES ('Сумська область');

INSERT INTO `sub_category` VALUES (1,'Аксесуари для ноутбуків і ПК');
INSERT INTO `sub_category` VALUES (1,'Комплектуючi');
INSERT INTO `sub_category` VALUES (1,'Ноутбуки');
INSERT INTO `sub_category` VALUES (2,'Аксесуари до мобільних телефонів');
INSERT INTO `sub_category` VALUES (2,'Телевізори та аксесуари');
INSERT INTO `sub_category` VALUES (4,'Інвентар для дому та офісу');
INSERT INTO `sub_category` VALUES (5,'Витратні матеріали та приладдя');
INSERT INTO `sub_category` VALUES (5,'Електромонтажне обладнання');
INSERT INTO `sub_category` VALUES (7,'Системи поливання');
INSERT INTO `sub_category` VALUES (9,'Продукти');

INSERT INTO `user` VALUES (2,'Максим','Максим','2020-03-01',1,1,'вул. Шевченка','79007','0992233441','maksym@gmail.com','2020-02-01 00:00:00','2020-02-01 10:00:00',1);
INSERT INTO `user` VALUES (3,'Олег','Петруняк','2000-09-02',1,1,'вул. Кульпарківська','79068','0995576121','oleg@gmail.com','2019-10-11 12:34:23','2020-09-11 11:14:59',1);
INSERT INTO `user` VALUES (4,'Ольга','Войневич','1980-09-02',2,3,'вул. Шевченка 11/12','00101','0971274221','olga@gmail.com','2019-10-11 11:47:32','2020-10-11 12:34:43',2);
INSERT INTO `user` VALUES (5,'Тарас','Терещук','1979-10-11',1,7,'вул. Франка 9/12','12322','0961345324','Taras@gmail.com','2018-01-13 15:24:33','2018-01-13 15:24:33',2);
INSERT INTO `user` VALUES (6,'Макс','Боженко','1980-12-12',1,6,'вул. Лесі Українки 24/56','54677','0971456574','max@gmail.com','2019-10-11 21:36:41','2020-10-11 20:36:41',2);
INSERT INTO `user` VALUES (7,'Саша','Семеніхін','1960-10-24',3,5,'вул. Герїв УПА 01/98','23334','0971546457','sasha@gmail.com','2017-01-12 11:54:12','2017-11-12 13:54:12',3);
INSERT INTO `user` VALUES (8,'Віка','Скороход','1975-05-12',2,1,'вул. Городоцька 34/78','82334','0971289734','vika@mail.ru','2019-10-11 18:41:13','2019-11-11 13:41:13',1);
INSERT INTO `user` VALUES (9,'Назар','Галайчук','1997-01-27',1,3,'вул. Шевченка 12/102','65444','0971735671','nazar@gmail.com','2020-06-01 16:32:56','2021-07-03 15:46:43',1);
INSERT INTO `user` VALUES (10,'Олександр','Терещук','1954-03-02',1,3,'вул. Шевченка 11/12','23111','0989346341','oleksandr@gmail.com','2019-07-03 15:46:43','2019-07-03 15:46:43',4);

INSERT INTO `user_card` VALUES (1,'Бронзова карта');
INSERT INTO `user_card` VALUES (2,'Срібна карта');
INSERT INTO `user_card` VALUES (3,'Золота карта');
INSERT INTO `user_card` VALUES (4,'Платинова карта');

INSERT INTO `user_card_has_card_bonus` VALUES (1,1);
INSERT INTO `user_card_has_card_bonus` VALUES (2,1);
INSERT INTO `user_card_has_card_bonus` VALUES (3,1);
INSERT INTO `user_card_has_card_bonus` VALUES (4,1);
INSERT INTO `user_card_has_card_bonus` VALUES (3,2);
INSERT INTO `user_card_has_card_bonus` VALUES (4,2);
INSERT INTO `user_card_has_card_bonus` VALUES (4,3);
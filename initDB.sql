-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bakalik_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bakalik_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bakalik_db` DEFAULT CHARACTER SET utf8 ;
USE `bakalik_db` ;

-- -----------------------------------------------------
-- Table `bakalik_db`.`gender`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bakalik_db`.`gender` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `gender` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bakalik_db`.`region`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bakalik_db`.`region` (
  `region` VARCHAR(35) NOT NULL,
  PRIMARY KEY (`region`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bakalik_db`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bakalik_db`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `region_region` VARCHAR(35) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_city_region1_idx` (`region_region` ASC) VISIBLE,
  CONSTRAINT `fk_city_region1`
    FOREIGN KEY (`region_region`)
    REFERENCES `bakalik_db`.`region` (`region`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bakalik_db`.`user_card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bakalik_db`.`user_card` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bakalik_db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bakalik_db`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `birthday` DATE NULL,
  `gender_id` INT NULL,
  `city_id` INT NULL,
  `street_address` VARCHAR(45) NULL,
  `zip_code` VARCHAR(5) NULL,
  `phone` VARCHAR(15) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `registred_at` DATETIME NOT NULL,
  `last_login` DATETIME NULL,
  `user_card_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_gender_idx` (`gender_id` ASC) VISIBLE,
  INDEX `fk_user_city1_idx` (`city_id` ASC) VISIBLE,
  INDEX `fk_user_user_card1_idx` (`user_card_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_gender`
    FOREIGN KEY (`gender_id`)
    REFERENCES `bakalik_db`.`gender` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `bakalik_db`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_user_card1`
    FOREIGN KEY (`user_card_id`)
    REFERENCES `bakalik_db`.`user_card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bakalik_db`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bakalik_db`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bakalik_db`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bakalik_db`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `category_id` INT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `image` VARCHAR(255) NOT NULL,
  `brand` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  `configuration` VARCHAR(45) NULL,
  `price` DECIMAL NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_item_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_item_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `bakalik_db`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bakalik_db`.`sub_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bakalik_db`.`sub_category` (
  `category_id` INT NOT NULL,
  `name` VARCHAR(35) NOT NULL,
  PRIMARY KEY (`category_id`, `name`),
  INDEX `fk_sub_category_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_sub_category_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `bakalik_db`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bakalik_db`.`delivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bakalik_db`.`delivery` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bakalik_db`.`order_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bakalik_db`.`order_status` (
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`status`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bakalik_db`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bakalik_db`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `time` DATETIME NOT NULL,
  `city_id` INT NOT NULL,
  `delivery_id` INT NOT NULL,
  `total_price` DECIMAL NOT NULL,
  `order_status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_order_city1_idx` (`city_id` ASC) VISIBLE,
  INDEX `fk_order_delivery1_idx` (`delivery_id` ASC) VISIBLE,
  INDEX `fk_order_order_status1_idx` (`order_status` ASC) VISIBLE,
  CONSTRAINT `fk_order_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `bakalik_db`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `bakalik_db`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_delivery1`
    FOREIGN KEY (`delivery_id`)
    REFERENCES `bakalik_db`.`delivery` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_order_status1`
    FOREIGN KEY (`order_status`)
    REFERENCES `bakalik_db`.`order_status` (`status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bakalik_db`.`order_has_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bakalik_db`.`order_has_item` (
  `order_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`order_id`, `item_id`),
  INDEX `fk_order_has_item_item1_idx` (`item_id` ASC) VISIBLE,
  INDEX `fk_order_has_item_order1_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `fk_order_has_item_order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `bakalik_db`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_has_item_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `bakalik_db`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bakalik_db`.`item_review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bakalik_db`.`item_review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `item_id` INT NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `rating` INT NULL,
  `published_at` DATETIME NOT NULL,
  `content` MEDIUMTEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_item_review_item1_idx` (`item_id` ASC) VISIBLE,
  CONSTRAINT `fk_item_review_item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `bakalik_db`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bakalik_db`.`card_bonus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bakalik_db`.`card_bonus` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `discount` DECIMAL NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bakalik_db`.`user_card_has_card_bonus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bakalik_db`.`user_card_has_card_bonus` (
  `user_card_id` INT NOT NULL,
  `card_bonus_id` INT NOT NULL,
  PRIMARY KEY (`user_card_id`, `card_bonus_id`),
  INDEX `fk_user_card_has_card_bonus_card_bonus1_idx` (`card_bonus_id` ASC) VISIBLE,
  INDEX `fk_user_card_has_card_bonus_user_card1_idx` (`user_card_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_card_has_card_bonus_user_card1`
    FOREIGN KEY (`user_card_id`)
    REFERENCES `bakalik_db`.`user_card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_card_has_card_bonus_card_bonus1`
    FOREIGN KEY (`card_bonus_id`)
    REFERENCES `bakalik_db`.`card_bonus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

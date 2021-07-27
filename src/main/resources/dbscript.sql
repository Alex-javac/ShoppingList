CREATE SCHEMA IF NOT EXISTS `shopping_list` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `shopping_list` ;

CREATE TABLE IF NOT EXISTS `shopping_list`.`fam` (
                                                     `id` INT NOT NULL AUTO_INCREMENT,
                                                     `name` VARCHAR(60) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `shopping_list`.`lists` (
                                                       `id` INT NOT NULL AUTO_INCREMENT,
                                                       `name` VARCHAR(100) NOT NULL,
    `create_update` TIMESTAMP(2) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `shopping_list`.`product_type` (
                                                              `id` INT NOT NULL AUTO_INCREMENT,
                                                              `name` VARCHAR(60) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `shopping_list`.`products` (
                                                          `id` INT NOT NULL AUTO_INCREMENT,
                                                          `name` VARCHAR(100) NOT NULL,
    `price` FLOAT UNSIGNED NULL,
    `product_type_id` INT NOT NULL,
    `create_update` TIMESTAMP(2) NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_products_types_products_idx` (`product_type_id` ASC) VISIBLE,
    CONSTRAINT `fk_products_types_products`
    FOREIGN KEY (`product_type_id`)
    REFERENCES `shopping_list`.`product_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `shopping_list`.`lists_products` (
                                                                `lists_id` INT NOT NULL,
                                                                `products_id` INT NOT NULL,
                                                                PRIMARY KEY (`lists_id`, `products_id`),
    INDEX `fk_lists_products_products1_idx` (`products_id` ASC) VISIBLE,
    INDEX `fk_lists_products_lists1_idx` (`lists_id` ASC) VISIBLE,
    CONSTRAINT `fk_lists_products_lists1`
    FOREIGN KEY (`lists_id`)
    REFERENCES `shopping_list`.`lists` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_lists_products_products1`
    FOREIGN KEY (`products_id`)
    REFERENCES `shopping_list`.`products` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `shopping_list`.`role` (
                                                      `id` INT NOT NULL AUTO_INCREMENT,
                                                      `role` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `shopping_list`.`fam_lists` (
                                                           `fam_id` INT NOT NULL,
                                                           `lists_id` INT NOT NULL,
                                                           PRIMARY KEY (`fam_id`, `lists_id`),
    INDEX `fk_fam_has_lists_lists1_idx` (`lists_id` ASC) VISIBLE,
    INDEX `fk_fam_has_lists_fam1_idx` (`fam_id` ASC) VISIBLE,
    CONSTRAINT `fk_fam_lists_fam1`
    FOREIGN KEY (`fam_id`)
    REFERENCES `shopping_list`.`fam` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_fam_lists_lists1`
    FOREIGN KEY (`lists_id`)
    REFERENCES `shopping_list`.`lists` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;

USE `shopping_list` ;

CREATE TABLE IF NOT EXISTS `shopping_list`.`users` (
                                                       `id` INT NOT NULL AUTO_INCREMENT,
                                                       `email` VARCHAR(100) NOT NULL,
    `login` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `first_name` VARCHAR(45) NULL,
    `last_name` VARCHAR(45) NULL,
    `nickname` VARCHAR(45) NOT NULL,
    `picture` VARCHAR(45) NULL,
    `create_update` TIMESTAMP(2) NOT NULL,
    `fam_id` INT NOT NULL,
    `role_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE,
    UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
    UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE,
    INDEX `fk_users_fam_idx` (`fam_id` ASC) VISIBLE,
    INDEX `fk_users_role1_idx` (`role_id` ASC) VISIBLE,
    CONSTRAINT `fk_users_fam`
    FOREIGN KEY (`fam_id`)
    REFERENCES `shopping_list`.`fam` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_users_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `shopping_list`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


INSERT INTO role(role) VALUES ('ROLE_USER');
INSERT INTO role(role) VALUES ('ROLE_ADMIN');


insert into fam(name) values ('MyFirstList');
INSERT INTO users(email, login, password, first_name, last_name, nickname,  create_update, fam_id, role_id )
values ('alex@mail.ru','alex','123456','Alexander','Alex','nik', now(), (select id from fam where name = 'MyFirstList'), (select id from role where role = 'ROLE_USER'));

insert into fam(name) values ('MyFirstList2');
INSERT INTO users(email, login, password, first_name, last_name, nickname,  create_update, fam_id, role_id )
values ('serg@mail.ru','nikola','123456','Koliya','Serg', 'alkoNikolko', now(), (select id from fam where name = 'MyFirstList2'), (select id from role where role = 'ROLE_ADMIN'));




CREATE SCHEMA IF NOT EXISTS `shopping_list` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `shopping_list` ;

CREATE TABLE IF NOT EXISTS `shopping_list`.`group` (
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

CREATE TABLE IF NOT EXISTS `shopping_list`.`user_data` (
                                                           `id` INT NOT NULL AUTO_INCREMENT,
                                                           `email` VARCHAR(100) NOT NULL,
                                                           `first_name` VARCHAR(45) NULL,
                                                           `last_name` VARCHAR(45) NULL,
                                                           `picture` VARCHAR(1000) NULL,
                                                           `create_update` TIMESTAMP(2) NOT NULL,
                                                           PRIMARY KEY (`id`),
                                                           UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `shopping_list`.`group_lists` (
                                                             `group_id` INT NOT NULL,
                                                             `lists_id` INT NOT NULL,
                                                             PRIMARY KEY (`group_id`, `lists_id`),
                                                             INDEX `fk_group_lists_lists1_idx` (`lists_id` ASC) VISIBLE,
                                                             INDEX `fk_group_lists_group1_idx` (`group_id` ASC) VISIBLE,
                                                             CONSTRAINT `fk_group_lists_group1`
                                                                 FOREIGN KEY (`group_id`)
                                                                     REFERENCES `shopping_list`.`group` (`id`)
                                                                     ON DELETE NO ACTION
                                                                     ON UPDATE NO ACTION,
                                                             CONSTRAINT `fk_group_lists_lists1`
                                                                 FOREIGN KEY (`lists_id`)
                                                                     REFERENCES `shopping_list`.`lists` (`id`)
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

CREATE TABLE IF NOT EXISTS `shopping_list`.`users` (
                                                       `id` INT NOT NULL AUTO_INCREMENT,
                                                       `nickname` VARCHAR(45) NOT NULL,
                                                       `login` VARCHAR(45) NOT NULL,
                                                       `password` VARCHAR(45) NOT NULL,
                                                       `group_id` INT NULL,
                                                       `user_data_id` INT NOT NULL,
                                                       `create_update` TIMESTAMP(2) NOT NULL,
                                                       `role_id` INT NOT NULL,
                                                       PRIMARY KEY (`id`),
                                                       INDEX `fk_Users_families_idx` (`group_id` ASC) VISIBLE,
                                                       INDEX `fk_Users_user_data1_idx` (`user_data_id` ASC) VISIBLE,
                                                       UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE,
                                                       UNIQUE INDEX `Nick_name_UNIQUE` (`nickname` ASC) VISIBLE,
                                                       INDEX `fk_users_role1_idx` (`role_id` ASC) VISIBLE,
                                                       CONSTRAINT `fk_Users_families`
                                                           FOREIGN KEY (`group_id`)
                                                               REFERENCES `shopping_list`.`group` (`id`)
                                                               ON DELETE NO ACTION
                                                               ON UPDATE NO ACTION,
                                                       CONSTRAINT `fk_Users_user_data1`
                                                           FOREIGN KEY (`user_data_id`)
                                                               REFERENCES `shopping_list`.`user_data` (`id`)
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




INSERT IGNORE user_data(email, create_update) values ('alex@mail.ru', now());
UPDATE user_data SET first_name = 'Alexander', last_name ='Alex' where email = 'alex@mail.ru';
INSERT  fam (name) VALUES ('myNewGroup');
INSERT INTO role(role) VALUES ('USER');
INSERT INTO users(login, password, nickname, user_data_id, create_update, group_id, role_id )
values ('alex','123456','nik',(Select id from user_data where email= 'alex@mail.ru'), now(), (Select id from fam where name ='myNewGroup'), (select id from role where role = 'USER'));






INSERT IGNORE user_data(email, create_update) values ('serg@mail.ru', now());
UPDATE user_data SET first_name = 'Koliya', last_name ='Serg' where email = 'serg@mail.ru';
INSERT  fam (name) VALUES ('myNewGroup2');
INSERT INTO role(role) VALUES ('ADMIN');
INSERT INTO users(login, password, nickname, user_data_id, create_update, group_id, role_id )
values ('nikola','123456','nikola',(Select id from user_data where email= 'serg@mail.ru'), now(), (Select id from fam where name ='myNewGroup2'), (select id from role where role = 'ADMIN'));
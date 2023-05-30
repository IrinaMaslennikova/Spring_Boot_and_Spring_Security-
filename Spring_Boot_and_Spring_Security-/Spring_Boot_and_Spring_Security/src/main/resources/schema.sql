DROP TABLE IF EXISTS `security_app_which_sql`.`users`;
DROP TABLE IF EXISTS `security_app_which_sql`.`roles`;
DROP TABLE IF EXISTS `security_app_which_sql`.`users_roles`;

CREATE TABLE `security_app_which_sql`.`users` (
                                                  `id` INT NOT NULL AUTO_INCREMENT,
                                                  `username` VARCHAR(45) NULL,
                                                  `firstname` VARCHAR(45) NULL,
                                                  `lastname` VARCHAR(45) NULL,
                                                  `password` VARCHAR(100) NULL,
                                                  `Email` VARCHAR(45) NULL,
                                                  PRIMARY KEY (`id`));

CREATE TABLE `security_app_which_sql`.`roles` (
                                                  `id` INT NOT NULL AUTO_INCREMENT,
                                                  `name` VARCHAR(45) NULL,
                                                  PRIMARY KEY (`id`));

CREATE TABLE `security_app_which_sql`.`users_roles` (
                                               `user_id` INT NOT NULL,
                                               `role_id` INT NOT NULL,
                                               PRIMARY KEY (`user_id`, `role_id`));

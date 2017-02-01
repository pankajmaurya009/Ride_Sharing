CREATE TABLE `cars` (
  `id`      INT                      NOT NULL  AUTO_INCREMENT,
  `version` INT                      NOT NULL  DEFAULT 0,
  `name`    VARCHAR(45)              NOT NULL,
  `type`    ENUM('LUX', 'BASIC')     NOT NULL,
  `make`    VARCHAR(45)              NULL,
  `model`   VARCHAR(45)              NOT NULL,
  `year`    INT                     NULL,
  `created` TIMESTAMP                NOT NULL  DEFAULT NOW(),
  `modified`TIMESTAMP                NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));
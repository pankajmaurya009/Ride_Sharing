CREATE TABLE `passengers` (
  `id`                INT                   NOT NULL  AUTO_INCREMENT,
  `version`           INT                   NOT NULL  DEFAULT 0,
  `name`              VARCHAR(45)           NOT NULL,
  `age`               INT                           ,
  `gender`            ENUM('M','F')         NOT NULL,
  `credit_balance`    DOUBLE                NOT NULL,
  `isban`             ENUM('Y','N')         NOT NULL,
  `created`           TIMESTAMP             NOT NULL  DEFAULT NOW(),
  `modified`          TIMESTAMP             NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));

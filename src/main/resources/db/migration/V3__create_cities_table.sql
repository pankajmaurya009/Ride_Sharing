CREATE TABLE `cities` (
  `id`                INT                   NOT NULL  AUTO_INCREMENT,
  `version`           INT                   NOT NULL  DEFAULT 0,
  `name`              VARCHAR(45)           NOT NULL,
  `state`             VARCHAR(45)           NOT NULL,
  `is_Night`          BOOLEAN               NOT NULL  DEFAULT FALSE ,
  `day_rate_per_km`   DOUBLE                NOT NULL ,
  `night_rate_per_km` DOUBLE                NOT NULL ,
  `created`           TIMESTAMP             NOT NULL  DEFAULT NOW(),
  `modified`          TIMESTAMP             NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));

CREATE TABLE `drivers` (
  `id`        INT              NOT NULL AUTO_INCREMENT,
  `version`   INT              NOT NULL DEFAULT 0,
  `name`      VARCHAR(45)      NOT NULL,
  `age`       INT              NULL,
  `gender`    ENUM('M', 'F')   NOT NULL,
  `tickets`   INT              NOT NULL DEFAULT 0,
  `isban`     ENUM('Y','N')    NOT NULL,
  `created`   TIMESTAMP        NOT NULL  DEFAULT NOW(),
  `modified`  TIMESTAMP        NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));

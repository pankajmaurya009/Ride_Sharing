CREATE TABLE `drivers_city_map` (
  `drivr_id`  INT            NOT NULL,
  `city_id`    INT            NOT NULL,

  CONSTRAINT `fk_drivr_id`
FOREIGN KEY (`drivr_id`)
REFERENCES `drivers` (`id`),

CONSTRAINT `fk_city_id`
FOREIGN KEY (`city_id`)
REFERENCES `cities` (`id`));
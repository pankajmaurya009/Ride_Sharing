CREATE TABLE `trips` (
  `id`                INT                   NOT NULL  AUTO_INCREMENT,
  `version`           INT                   NOT NULL  DEFAULT 0,
  `started_at`        TIMESTAMP             NOT NULL DEFAULT NOW(),
  `ended_at`          TIMESTAMP             NOT NULL DEFAULT NOW(),
  `duration`          INT                   NULL ,
  `city_id1`           INT                   NOT NULL ,
  `car_id1`            INT                   NOT NULL ,
  `driver_id1`         INT                   NOT NULL ,
  `passenger_id1`      INT                   NOT NULL ,
  `trip_distance`     DOUBLE                NOT NULL,
  `travel_cost`       DOUBLE                NULL,
  `tip_percent`       DOUBLE                NOT NULL DEFAULT 0.0,
  `total_cost`        DOUBLE                NULL,
  `was_successfull`   ENUM('Y','N')         NOT NULL,
  `created`           TIMESTAMP             NOT NULL  DEFAULT NOW(),
  `modified`          TIMESTAMP             NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`),

  CONSTRAINT `fk_city_id1`
  FOREIGN KEY (`city_id1`)
  REFERENCES `cities` (`id`),


  CONSTRAINT `fk_car_id1`
  FOREIGN KEY (`car_id1`)
  REFERENCES `cars` (`id`),

  CONSTRAINT `fk_driverr_id1`
  FOREIGN KEY (`driver_id1`)
  REFERENCES `drivers` (`id`),

  CONSTRAINT `fk_passenger_id1`
  FOREIGN KEY (`passenger_id1`)
  REFERENCES `passengers` (`id`));

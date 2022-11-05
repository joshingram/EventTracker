-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema jeepTripsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `jeepTripsdb` ;

-- -----------------------------------------------------
-- Schema jeepTripsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jeepTripsdb` DEFAULT CHARACTER SET utf8 ;
USE `jeepTripsdb` ;

-- -----------------------------------------------------
-- Table `trail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `trail` ;

CREATE TABLE IF NOT EXISTS `trail` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `length` DOUBLE NULL,
  `date_completed` DATE NULL,
  `image_url` VARCHAR(200) NULL,
  `entrance_latitude` DOUBLE NULL,
  `entrance_longitude` DOUBLE NULL,
  `highest_elevation` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS jeeper@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'jeeper'@'localhost' IDENTIFIED BY 'jeeper';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'jeeper'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `trail`
-- -----------------------------------------------------
START TRANSACTION;
USE `jeepTripsdb`;
INSERT INTO `trail` (`id`, `name`, `length`, `date_completed`, `image_url`, `entrance_latitude`, `entrance_longitude`, `highest_elevation`) VALUES (1, 'Rubicon Trail', 22, '2022-08-01', 'http://www.jeepingoffroad.com/_Media/9009ec5b-f112-422e-bc9a_med_hr.jpeg', 39.0033583333333333, -120.31158166666667, 7050);
INSERT INTO `trail` (`id`, `name`, `length`, `date_completed`, `image_url`, `entrance_latitude`, `entrance_longitude`, `highest_elevation`) VALUES (2, 'Holy Cross City', 4.4, '2022-08-20', 'http://www.jeepingoffroad.com/_Media/img_3582_med.jpeg', 39.40321779441507, -106.44359583101377, 11500);
INSERT INTO `trail` (`id`, `name`, `length`, `date_completed`, `image_url`, `entrance_latitude`, `entrance_longitude`, `highest_elevation`) VALUES (3, 'Red Cone', 6, '2021-08-01', 'https://wildatv.com/wp-content/uploads/2020/09/Webster-Pass-Red-Cone-696x393.jpg', 39.48339458331419, -105.80385489509197, 12800);

COMMIT;


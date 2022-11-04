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
  `name` VARCHAR(100) NULL,
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
INSERT INTO `trail` (`id`, `name`) VALUES (1, 'Rubicon Trail');

COMMIT;


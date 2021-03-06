-- MySQL Script generated by MySQL Workbench
-- Fri May 11 01:49:03 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tompethouse
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tompethouse
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tompethouse` ;
USE `tompethouse` ;

-- -----------------------------------------------------
-- Table `tompethouse`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tompethouse`.`User` (
  `userID` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(40) NOT NULL,
  `password` VARCHAR(15) NOT NULL,
  `name` VARCHAR(15) NULL,
  `home_addr` VARCHAR(40) NULL,
  `mobile_number` VARCHAR(10) NULL,
  `home_number` VARCHAR(10) NULL,
  `work_number` VARCHAR(10) NULL,
  PRIMARY KEY (`userID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tompethouse`.`Dog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tompethouse`.`Dog` (
  `dogID` INT NOT NULL AUTO_INCREMENT,
  `userID` INT NOT NULL,
  `name` VARCHAR(15) NOT NULL,
  `breed` VARCHAR(15) NOT NULL,
  `DoB` DATE NOT NULL,
  PRIMARY KEY (`dogID`),
  INDEX `userID_idx` (`userID` ASC),
  CONSTRAINT `userID`
    FOREIGN KEY (`userID`)
    REFERENCES `tompethouse`.`User` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tompethouse`.`Option`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tompethouse`.`myoption` (
  `optionID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`optionID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tompethouse`.`Appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tompethouse`.`Appointment` (
  `appointmentID` INT NOT NULL AUTO_INCREMENT,
  `appuserID` INT NOT NULL,
  `appdogID` INT NOT NULL,
  `time` DATETIME NOT NULL,
  `appoptionID` INT NOT NULL,
  `comment` TINYTEXT NULL,
  PRIMARY KEY (`appointmentID`),
  INDEX `appuserID_idx` (`appuserID` ASC),
  INDEX `appdogID_idx` (`appdogID` ASC),
  INDEX `appoptionID_idx` (`appoptionID` ASC),
  CONSTRAINT `appuserID`
    FOREIGN KEY (`appuserID`)
    REFERENCES `tompethouse`.`User` (`userID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `appdogID`
    FOREIGN KEY (`appdogID`)
    REFERENCES `tompethouse`.`Dog` (`dogID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `appoptionID`
    FOREIGN KEY (`appoptionID`)
    REFERENCES `tompethouse`.`myoption` (`optionID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

insert into User(userID,email,`password`,`name`,home_addr,mobile_number,home_number,work_number) values
(1,'wenge907@gmail.com','sergey123',null,null,null,null,null),
(2,'361583983@qq.com','12345ww',null,null,null,null,null),
(3,'yingh5@student.unimelb.edu.au','qwerty','Ying Hu','8/234 Cardigan St, Melbourne VIC 3053','834626167','1233166',null),
(4,'changna@yahoo.com','zxc123','Na Chang','680-682 Swanston St, Carlton VIC 3053','513135131','1361153','13551');

insert into dog(dogID,userID,name,breed,DoB) values
(1,2,'Crab Stick','Shiba Inu','2007-03-04'),
(2,2,'Kibou','Akita','2012-07-07'),
(3,4,'AAAA','Akita','2012-07-07');

insert into `myoption`(optionID,`name`) values
(1,'Parasite Control'),
(2,'Bathing & Drying'),
(3,'Nail Clipping'),
(4,'Hair Clipping'),
(5,'Ear Cleaning');

insert into appointment(appointmentID,appuserID,appdogID,time,`appoptionID`,comment) values
(1,2,1,'2018-05-12 09:00:00',2,'strong'),
(2,2,2,'2018-05-12 10:30:00',2,'strong'),
(3,4,3,'2018-05-15 10:30:00',2,'strong'),
(4,2,2,'2018-03-15 10:30:00',2,'strong'),
(5,2,1,'2018-05-14 10:30:00',2,'strong'),
(6,2,1,'2018-05-15 10:30:00',2,'strong'),
(7,2,1,'2018-05-16 15:30:00',2,'strong');



CREATE OR REPLACE
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `combineappointment` AS
    SELECT 
        `a`.`appointmentID` AS `ID`,
        `a`.`appuserID` AS `userID`,
        `a`.`appdogID` AS `dogID`,
        `a`.`time` AS `time`,
        `a`.`appoptionID` AS `option`,
        `a`.`comment` AS `comment`,
        `d`.`name` AS `dog_name`,
        `o`.`name` AS `option_name`
    FROM
        ((`appointment` `a`
        JOIN `dog` `d`)
        JOIN `myoption` `o`)
    WHERE
        ((`a`.`appdogID` = `d`.`dogID`)
            AND (`a`.`appoptionID` = `o`.`optionID`))
	ORDER BY a.time DESC
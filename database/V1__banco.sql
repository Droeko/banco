SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`EntidadBancaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EntidadBancaria` (
  `idEntidad` INT NOT NULL,
  `codigoEntidad` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `cif` VARCHAR(45) NULL,
  `TipoEntidadBancaria` VARCHAR(45) NULL,
  PRIMARY KEY (`idEntidad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`SucursalBancaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`SucursalBancaria` (
  `idSucursalBancaria` INT NOT NULL,
  `entidadBancaria` INT NULL,
  `codigoSucursal` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idSucursalBancaria`),
  INDEX `entidadBancaria_idx` (`entidadBancaria` ASC),
  CONSTRAINT `entidadBancaria`
    FOREIGN KEY (`entidadBancaria`)
    REFERENCES `mydb`.`EntidadBancaria` (`idEntidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `entidad`
    FOREIGN KEY (`entidadBancaria`)
    REFERENCES `mydb`.`EntidadBancaria` (`idEntidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CuentaBancaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CuentaBancaria` (
  `idCuentaBancaria` INT NOT NULL,
  `sucursalBancaria` INT NULL,
  `numeroCuenta` VARCHAR(45) NULL,
  `dc` INT NULL,
  `saldo` DECIMAL NULL,
  `cif` VARCHAR(45) NULL,
  PRIMARY KEY (`idCuentaBancaria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MovimientoBancario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`MovimientoBancario` (
  `idMovimientoBancario` INT NOT NULL,
  `TipoMovimientoBancario` VARCHAR(45) NULL,
  `importe` DECIMAL NULL,
  `fecha` VARCHAR(45) NULL,
  `saldoTotal` DECIMAL NULL,
  `concepto` VARCHAR(45) NULL,
  `sucursalBancaria` INT NULL,
  PRIMARY KEY (`idMovimientoBancario`),
  INDEX `movimiento_idx` (`sucursalBancaria` ASC),
  CONSTRAINT `movimiento`
    FOREIGN KEY (`sucursalBancaria`)
    REFERENCES `mydb`.`SucursalBancaria` (`idSucursalBancaria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

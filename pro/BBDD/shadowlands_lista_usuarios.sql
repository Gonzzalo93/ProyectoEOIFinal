<<<<<<< HEAD
=======
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: shadowlands
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentas` (
  `idCuentas` int NOT NULL AUTO_INCREMENT,
  `Nick` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Direccion` varchar(45) NOT NULL,
  `Pais` varchar(45) NOT NULL,
  `Nacimiento` date NOT NULL,
  `TipoCuenta` varchar(45) NOT NULL,
  PRIMARY KEY (`idCuentas`,`Nick`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario` (
  `idTienda` int NOT NULL,
  `Personajes_idPersonajes` int NOT NULL,
  `NombreObjeto` varchar(45) NOT NULL,
  `DmgExtra` int NOT NULL,
  `DefExtra` int DEFAULT NULL,
  `SaludExtra` int NOT NULL,
  `Cantidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTienda`),
  KEY `fk_Inventario_Personajes1_idx` (`Personajes_idPersonajes`),
  CONSTRAINT `fk_Inventario_Personajes1` FOREIGN KEY (`Personajes_idPersonajes`) REFERENCES `personajes` (`idPersonajes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personajes`
--

DROP TABLE IF EXISTS `personajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personajes` (
  `idPersonajes` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Clase` varchar(45) NOT NULL,
  `Inventario` varchar(45) DEFAULT NULL,
  `Dinero` int DEFAULT NULL,
  `ArmaEquipada` varchar(45) DEFAULT NULL,
  `Experiencia` varchar(45) DEFAULT NULL,
  `ExpRequerida` varchar(45) NOT NULL,
  `Cuentas_idCuentas` int NOT NULL,
  `Cuentas_Nick` varchar(45) NOT NULL,
  PRIMARY KEY (`idPersonajes`),
  UNIQUE KEY `Nombre_UNIQUE` (`Nombre`),
  KEY `fk_Personajes_Cuentas_idx` (`Cuentas_idCuentas`,`Cuentas_Nick`),
  CONSTRAINT `fk_Personajes_Cuentas` FOREIGN KEY (`Cuentas_idCuentas`, `Cuentas_Nick`) REFERENCES `cuentas` (`idCuentas`, `Nick`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personajes`
--

LOCK TABLES `personajes` WRITE;
/*!40000 ALTER TABLE `personajes` DISABLE KEYS */;
/*!40000 ALTER TABLE `personajes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-26 18:23:39
>>>>>>> master

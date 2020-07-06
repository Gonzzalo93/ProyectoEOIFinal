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
-- Table structure for table `consultas`
--

DROP TABLE IF EXISTS `consultas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consultas` (
  `cuentas_idCuentas` int NOT NULL,
  `idConsultas` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Categoria` varchar(45) NOT NULL,
  `Comentarios` varchar(300) NOT NULL,
  `Estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idConsultas`),
  KEY `fk_consultas_cuentas1_idx` (`cuentas_idCuentas`),
  CONSTRAINT `fk_consultas_cuentas1` FOREIGN KEY (`cuentas_idCuentas`) REFERENCES `cuentas` (`idCuentas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultas`
--

LOCK TABLES `consultas` WRITE;
/*!40000 ALTER TABLE `consultas` DISABLE KEYS */;
/*!40000 ALTER TABLE `consultas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentas` (
  `idCuentas` int NOT NULL AUTO_INCREMENT,
  `Nick` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Direccion` varchar(45) NOT NULL,
  `Pais` varchar(45) NOT NULL,
  `Nacimiento` date NOT NULL,
  `TipoCuenta` varchar(45) DEFAULT 'Normal',
  PRIMARY KEY (`idCuentas`),
  UNIQUE KEY `Email_UNIQUE` (`Email`),
  UNIQUE KEY `Nick_UNIQUE` (`Nick`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` VALUES (1,'Drizzt','miguel_mgarrido@hotmail.com','GameMaster11','Mi casa','Spain','1998-08-15','Normal');
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habilidades`
--

DROP TABLE IF EXISTS `habilidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habilidades` (
  `personajes_idPersonajes` int NOT NULL,
  `idHabilidades` int NOT NULL AUTO_INCREMENT,
  `NombreHabilidad` varchar(45) NOT NULL,
  `SkillDmg` int NOT NULL,
  `SkillHeal` int NOT NULL DEFAULT '0',
  `CosteMp` int NOT NULL,
  `Elemento` varchar(45) NOT NULL DEFAULT 'Ninguno',
  `Clase` varchar(45) NOT NULL,
  PRIMARY KEY (`idHabilidades`),
  UNIQUE KEY `NombreHabilidad_UNIQUE` (`NombreHabilidad`),
  KEY `fk_habilidades_personajes1_idx` (`personajes_idPersonajes`),
  CONSTRAINT `fk_habilidades_personajes1` FOREIGN KEY (`personajes_idPersonajes`) REFERENCES `personajes` (`idPersonajes`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habilidades`
--

LOCK TABLES `habilidades` WRITE;
/*!40000 ALTER TABLE `habilidades` DISABLE KEYS */;
/*!40000 ALTER TABLE `habilidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personajes`
--

DROP TABLE IF EXISTS `personajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personajes` (
  `cuentas_idCuentas` int NOT NULL,
  `idPersonajes` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Nivel` int NOT NULL DEFAULT '1',
  `Clase` varchar(45) NOT NULL,
  `Dmg` int NOT NULL,
  `CritDmg` int NOT NULL DEFAULT '0',
  `Def` int NOT NULL,
  `Evasion` int NOT NULL,
  `Hp` int NOT NULL,
  `Mp` int NOT NULL,
  `Experiencia` int NOT NULL DEFAULT '0',
  `Dinero` int NOT NULL DEFAULT '0',
  `ArmaEquipada` varchar(45) NOT NULL DEFAULT 'Nada',
  `ArmaduraEquipada` varchar(45) NOT NULL DEFAULT 'Nada',
  `Progreso` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`idPersonajes`),
  UNIQUE KEY `Nombre_UNIQUE` (`Nombre`),
  KEY `fk_personajes_cuentas1_idx` (`cuentas_idCuentas`),
  CONSTRAINT `fk_personajes_cuentas1` FOREIGN KEY (`cuentas_idCuentas`) REFERENCES `cuentas` (`idCuentas`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personajes`
--

LOCK TABLES `personajes` WRITE;
/*!40000 ALTER TABLE `personajes` DISABLE KEYS */;
INSERT INTO `personajes` VALUES (1,10,'LionHit',1,'Guerrero',8,150,14,3,140,24,0,0,'Nada','Nada',0);
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

-- Dump completed on 2020-07-06 15:20:41

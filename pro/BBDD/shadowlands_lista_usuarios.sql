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
  `cuentas_Nick` varchar(45) NOT NULL,
  `idConsultas` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Categoria` varchar(45) NOT NULL,
  `Comentarios` varchar(300) NOT NULL,
  `Estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idConsultas`),
  KEY `fk_Consultas_cuentas1_idx` (`cuentas_idCuentas`,`cuentas_Nick`),
  CONSTRAINT `fk_Consultas_cuentas1` FOREIGN KEY (`cuentas_idCuentas`, `cuentas_Nick`) REFERENCES `cuentas` (`idCuentas`, `Nick`)
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
  `Password` varchar(45) NOT NULL,
  `Direccion` varchar(45) NOT NULL,
  `Pais` varchar(45) NOT NULL,
  `Nacimiento` date NOT NULL,
  `TipoCuenta` varchar(45) NOT NULL,
  PRIMARY KEY (`idCuentas`,`Nick`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` VALUES (1,'Drizzt','elcapo12','Alicante','España','1998-08-15','GameMaster');
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario` (
  `personajes_idPersonajes` int NOT NULL,
  `personajes_Nombre` varchar(45) NOT NULL,
  `idTienda` int NOT NULL,
  `NombreObjeto` varchar(45) NOT NULL,
  `DmgExtra` int NOT NULL,
  `DefExtra` int DEFAULT NULL,
  `SaludExtra` int NOT NULL,
  `Cantidad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTienda`,`NombreObjeto`),
  KEY `fk_inventario_personajes1_idx` (`personajes_idPersonajes`,`personajes_Nombre`),
  CONSTRAINT `fk_inventario_personajes1` FOREIGN KEY (`personajes_idPersonajes`, `personajes_Nombre`) REFERENCES `personajes` (`idPersonajes`, `Nombre`)
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
-- Table structure for table `lista_usuarios`
--

DROP TABLE IF EXISTS `lista_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lista_usuarios` (
  `id_Usuarios` int NOT NULL AUTO_INCREMENT,
  `Usuario` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`id_Usuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista_usuarios`
--

LOCK TABLES `lista_usuarios` WRITE;
/*!40000 ALTER TABLE `lista_usuarios` DISABLE KEYS */;
INSERT INTO `lista_usuarios` VALUES (1,'Drizzt','Admin1234'),(2,'Santymmr','Pray4Shai');
/*!40000 ALTER TABLE `lista_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personajes`
--

DROP TABLE IF EXISTS `personajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personajes` (
  `cuentas_idCuentas` int NOT NULL,
  `cuentas_Nick` varchar(45) NOT NULL,
  `idPersonajes` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Nivel` int NOT NULL,
  `Clase` varchar(45) NOT NULL,
  `Dmg` int NOT NULL,
  `Hp` int NOT NULL,
  `Experiencia` varchar(45) NOT NULL,
  `Dinero` int DEFAULT NULL,
  `ArmaEquipada` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPersonajes`,`Nombre`),
  UNIQUE KEY `Nombre_UNIQUE` (`Nombre`),
  KEY `fk_personajes_cuentas1_idx` (`cuentas_idCuentas`,`cuentas_Nick`),
  CONSTRAINT `fk_personajes_cuentas1` FOREIGN KEY (`cuentas_idCuentas`, `cuentas_Nick`) REFERENCES `cuentas` (`idCuentas`, `Nick`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personajes`
--

LOCK TABLES `personajes` WRITE;
/*!40000 ALTER TABLE `personajes` DISABLE KEYS */;
INSERT INTO `personajes` VALUES (1,'Drizzt',1,'LionHit',1,'Guerrero',8,300,'0',NULL,NULL);
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

-- Dump completed on 2020-07-02 19:05:46

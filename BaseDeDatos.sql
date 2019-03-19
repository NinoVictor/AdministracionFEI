-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: pruebajavafx
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alumnos` (
  `matricula` varchar(20) DEFAULT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `paterno` varchar(20) DEFAULT NULL,
  `materno` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES ('S17013000','Victor ','Niño','Martinez'),('S17204050','Kevin Misael','Hernandez','Júarez'),('S17022900','Alan','Gonzalez ','Heredia');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horarios`
--

DROP TABLE IF EXISTS `horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `horarios` (
  `idhorario` int(11) NOT NULL AUTO_INCREMENT,
  `academico` varchar(40) DEFAULT NULL,
  `salon` varchar(10) DEFAULT NULL,
  `cupo` int(5) DEFAULT NULL,
  `nrc` int(10) DEFAULT NULL,
  `lunes` varchar(11) DEFAULT NULL,
  `martes` varchar(11) DEFAULT NULL,
  `miercoles` varchar(11) DEFAULT NULL,
  `jueves` varchar(11) DEFAULT NULL,
  `viernes` varchar(11) DEFAULT NULL,
  `sabado` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`idhorario`),
  KEY `nrc` (`nrc`),
  CONSTRAINT `horarios_ibfk_1` FOREIGN KEY (`nrc`) REFERENCES `materias` (`nrc`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarios`
--

LOCK TABLES `horarios` WRITE;
/*!40000 ALTER TABLE `horarios` DISABLE KEYS */;
INSERT INTO `horarios` VALUES (10,'Castañeda Sanchez Fredy','F103',35,12345,'NULL','07:00-08:59','NULL','07:00-08:59','09:00-10:59','NULL'),(11,'Cortes Verdin Maria Karen','F105',35,12346,'11:00-12:59','NULL','11:00-12:59','NULL','11:00-12:59','NULL'),(12,'Benitez Guerrero Edgard Ivan','F108',40,12347,'09:00-10:59','NULL','09:00-10:59','09:00-10:59','NULL','NULL');
/*!40000 ALTER TABLE `horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materias`
--

DROP TABLE IF EXISTS `materias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `materias` (
  `nrc` int(10) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `creditos` int(4) DEFAULT NULL,
  `horasPracticas` varchar(3) DEFAULT NULL,
  `horasTeoricas` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`nrc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materias`
--

LOCK TABLES `materias` WRITE;
/*!40000 ALTER TABLE `materias` DISABLE KEYS */;
INSERT INTO `materias` VALUES (12345,'Principios de Construccion',10,'15','10'),(12346,'Principios de Diseño',10,'20','15'),(12347,'Paradigmas de Programación',9,'15','12'),(12348,'Bases de datos',9,'28','16'),(12349,'Procesos para la IS',9,'10','16');
/*!40000 ALTER TABLE `materias` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-19 15:00:45

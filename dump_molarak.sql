-- MySQL dump 10.13  Distrib 8.0.35, for Linux (x86_64)
--
-- Host: localhost    Database: molarak
-- ------------------------------------------------------
-- Server version	8.0.35-0ubuntu0.23.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alcoholic_drinks`
--

DROP TABLE IF EXISTS `alcoholic_drinks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alcoholic_drinks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `brand` varchar(50) NOT NULL,
  `category` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `imageUrl` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alcoholic_drinks`
--

LOCK TABLES `alcoholic_drinks` WRITE;
/*!40000 ALTER TABLE `alcoholic_drinks` DISABLE KEYS */;
/*!40000 ALTER TABLE `alcoholic_drinks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alcoholic_drinks_volumes`
--

DROP TABLE IF EXISTS `alcoholic_drinks_volumes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alcoholic_drinks_volumes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `alcoholic_drinks_id` int NOT NULL,
  `volume` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `alcoholic_drinks_id` (`alcoholic_drinks_id`),
  CONSTRAINT `alcoholic_drinks_volumes_ibfk_1` FOREIGN KEY (`alcoholic_drinks_id`) REFERENCES `alcoholic_drinks` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alcoholic_drinks_volumes`
--

LOCK TABLES `alcoholic_drinks_volumes` WRITE;
/*!40000 ALTER TABLE `alcoholic_drinks_volumes` DISABLE KEYS */;
/*!40000 ALTER TABLE `alcoholic_drinks_volumes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comparison`
--

DROP TABLE IF EXISTS `comparison`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comparison` (
  `id` int NOT NULL AUTO_INCREMENT,
  `alcoholic_drinks_volumes_id` int NOT NULL,
  `website_name` varchar(100) NOT NULL,
  `website_url` varchar(255) NOT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `alcoholic_drinks_volumes_id` (`alcoholic_drinks_volumes_id`),
  CONSTRAINT `comparison_ibfk_1` FOREIGN KEY (`alcoholic_drinks_volumes_id`) REFERENCES `alcoholic_drinks_volumes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comparison`
--

LOCK TABLES `comparison` WRITE;
/*!40000 ALTER TABLE `comparison` DISABLE KEYS */;
/*!40000 ALTER TABLE `comparison` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-12 16:02:53

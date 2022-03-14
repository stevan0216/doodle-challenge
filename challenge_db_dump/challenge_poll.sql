-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: challenge
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `poll`
--

DROP TABLE IF EXISTS `poll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poll` (
  `admin_key` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `latest_change` bigint DEFAULT NULL,
  `initiated` bigint DEFAULT NULL,
  `type` enum('TEXT','DATE') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `hidden` tinyint(1) DEFAULT NULL,
  `preferences_type` enum('YESNO','YESNOIFNEEDBE') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `state` enum('OPEN','CLOSE') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `locale` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `initiator` int DEFAULT NULL,
  `device` enum('WEB') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `levels` enum('YESNO','YESNOIFNEEDBE') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `location` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `id_poll` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_poll`),
  KEY `id_initiator_idx` (`initiator`),
  KEY `location_id_idx` (`location`),
  CONSTRAINT `id_initiator` FOREIGN KEY (`initiator`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `location_id` FOREIGN KEY (`location`) REFERENCES `location` (`id_location`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poll`
--

LOCK TABLES `poll` WRITE;
/*!40000 ALTER TABLE `poll` DISABLE KEYS */;
INSERT INTO `poll` VALUES ('wyemiw4y',1485521573489,1485388243056,'DATE',0,'YESNO','OPEN','en','123小伊两岁',1,'WEB','YESNO','0','h75eeaudhf3tf3v3','让我们去滑雪几天在阿尔卑斯山。你什么时候会推出？'),('wyemiw4y',1485521573489,1485388243056,'DATE',0,'YESNO','OPEN','en','小杰伊两岁！',1,'WEB','YESNO','0','h75eeaudhf3tf3v4','可爱的宝宝世界会变成2岁的1月12日时间过得真快。你什么时候有时间和我们一起庆祝？'),('wyemiw4y',1485521573489,1485388243056,'DATE',0,'YESNO','OPEN','en','小杰伊两岁！',1,'WEB','YESNO','0','h75eeaudhf3tf3v5','لم تتحول 2 سنة على 12. يناير الوقت الذباب. متى يكون ل'),('sp4xfrkr',1485521573504,1485477127056,'DATE',0,'YESNO','OPEN','fr_CH','Petit Jay va avoir DEUX ANS! Déjà \\o/',1,'WEB','YESNO','0','ps5878bwv3eyxkzm',NULL),('wyemiw4y',1485521573489,1485388243056,'DATE',0,'YESNO','OPEN','en','小杰伊两岁12345',1,'WEB','YESNO','0','userh75eef3tf3v6','لم تتحول 2 سنة على 12. يناير الوقت الذباب. متى يكون ل'),('r44d7piq',1485521573482,1485521569056,'TEXT',1,'YESNO','OPEN','fr_CH','Qui sont les superhéros Marvel les plus oufs?',1,'WEB','YESNO','0','xsd4cv89t5f5um4b','Le bébé le plus adorable au monde va avoir 2 ans le 12 janvier. Le temps passe vite. Quand auriez-vous du temps pour fêter avec nous?');
/*!40000 ALTER TABLE `poll` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-15  0:33:55

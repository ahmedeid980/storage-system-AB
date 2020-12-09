-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: storagesystem
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `bill_products`
--

DROP TABLE IF EXISTS `bill_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `bill_id` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `notes` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_billProduct_bill_idx` (`bill_id`),
  KEY `fk_category_idx` (`category_id`),
  CONSTRAINT `fk_billProduct_bill` FOREIGN KEY (`bill_id`) REFERENCES `bills` (`id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_products`
--

LOCK TABLES `bill_products` WRITE;
/*!40000 ALTER TABLE `bill_products` DISABLE KEYS */;
INSERT INTO `bill_products` VALUES (1,23124,13,1,'plh]m'),(2,34234,14,1,'ahmed eid'),(3,333,14,2,'ahmed eid and radwa'),(4,213,15,1,'fgrttr'),(5,213,16,1,'hamada'),(6,213,16,2,'aaa'),(7,213,17,1,'hamada'),(8,213,17,2,'aaa'),(9,213,18,1,'hamada'),(10,213,18,2,'aaa'),(11,213,19,1,'hamada'),(12,213,19,2,'aaa'),(13,213,20,1,'hamada'),(14,213,20,2,'aaa'),(15,23124,21,1,NULL),(16,213,22,1,'dfdssfd s s'),(17,333,23,1,NULL),(18,12,24,1,'ddfsdfsdf dsf sd'),(19,123,25,1,'hamada');
/*!40000 ALTER TABLE `bill_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_type`
--

DROP TABLE IF EXISTS `bill_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `decription` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_type`
--

LOCK TABLES `bill_type` WRITE;
/*!40000 ALTER TABLE `bill_type` DISABLE KEYS */;
INSERT INTO `bill_type` VALUES (1,'وارد'),(2,'صادر'),(3,'تحويل'),(4,'مرتجع');
/*!40000 ALTER TABLE `bill_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bills`
--

DROP TABLE IF EXISTS `bills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bills` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code_generation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `incoming_company_id` int DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `bill_type_id` int DEFAULT NULL,
  `project_id` int DEFAULT NULL,
  `store_id_to` int DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_incoming_company_idx` (`incoming_company_id`),
  KEY `fk_storeId_idx` (`store_id`),
  KEY `fk_bill_type_idx` (`bill_type_id`),
  KEY `fk_proId_idx` (`project_id`),
  KEY `fk_storeIdTo_idx` (`store_id_to`),
  CONSTRAINT `fk_bill_type` FOREIGN KEY (`bill_type_id`) REFERENCES `bill_type` (`id`),
  CONSTRAINT `fk_incoming_company` FOREIGN KEY (`incoming_company_id`) REFERENCES `incoming_companies` (`id`),
  CONSTRAINT `fk_proId` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`),
  CONSTRAINT `fk_storeId` FOREIGN KEY (`store_id`) REFERENCES `stores` (`id`),
  CONSTRAINT `fk_storeIdTo` FOREIGN KEY (`store_id_to`) REFERENCES `stores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bills`
--

LOCK TABLES `bills` WRITE;
/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` VALUES (1,'0001',1,1,1,NULL,NULL,'2020-12-02 09:24:27'),(2,'0001',1,1,1,NULL,NULL,'2020-12-02 09:26:24'),(3,'0001',1,1,1,NULL,NULL,'2020-12-02 11:22:49'),(4,'0001',1,1,1,NULL,NULL,'2020-12-02 11:24:38'),(5,'0001',1,1,1,NULL,NULL,'2020-12-02 13:43:00'),(6,'0003',1,1,1,NULL,NULL,'2020-12-02 16:23:55'),(7,'0001',1,1,1,NULL,NULL,'2020-12-02 16:30:18'),(8,'1234',1,1,1,NULL,NULL,'2020-12-02 16:33:44'),(9,'0001',1,1,1,NULL,NULL,'2020-12-02 17:25:27'),(10,'324234',1,1,1,NULL,NULL,'2020-12-02 17:29:46'),(11,'1224',1,1,1,NULL,NULL,'2020-12-02 17:36:27'),(12,'4154',1,1,1,NULL,NULL,'2020-12-02 17:40:25'),(13,'2000',1,1,1,NULL,NULL,'2020-12-02 20:11:16'),(14,'3000',1,1,1,NULL,NULL,'2020-12-02 20:38:04'),(15,'5454',1,1,1,NULL,NULL,'2020-12-04 09:50:16'),(16,'3002',NULL,1,2,1,NULL,'2020-12-08 19:45:38'),(17,'3002',NULL,1,2,1,NULL,'2020-12-08 19:49:35'),(18,'3002',NULL,1,2,1,NULL,'2020-12-08 19:54:50'),(19,'3002',NULL,1,2,1,NULL,'2020-12-08 19:59:13'),(20,'3002',NULL,1,2,1,NULL,'2020-12-08 20:00:39'),(21,'3221',NULL,1,2,1,NULL,'2020-12-08 20:04:42'),(22,'22232',NULL,1,3,NULL,2,'2020-12-08 21:14:11'),(23,'1515',NULL,1,3,NULL,2,'2020-12-08 21:52:08'),(24,'10009',NULL,1,3,NULL,2,'2020-12-09 19:21:33'),(25,'20022',NULL,1,4,1,NULL,'2020-12-09 20:45:22');
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `decription` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unit_id` int DEFAULT NULL,
  `store_type_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_unit_idx` (`unit_id`),
  KEY `fk_store_type_idx` (`store_type_id`),
  CONSTRAINT `fk_store_type` FOREIGN KEY (`store_type_id`) REFERENCES `store_type` (`id`),
  CONSTRAINT `fk_unit` FOREIGN KEY (`unit_id`) REFERENCES `units` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'حديد تسليح',1,1),(2,'مواسر مياة',2,3);
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incoming_companies`
--

DROP TABLE IF EXISTS `incoming_companies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incoming_companies` (
  `id` int NOT NULL AUTO_INCREMENT,
  `decription` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incoming_companies`
--

LOCK TABLES `incoming_companies` WRITE;
/*!40000 ALTER TABLE `incoming_companies` DISABLE KEYS */;
INSERT INTO `incoming_companies` VALUES (1,'شركة الشرق للمياة','مصر الجديدة',1035425875);
/*!40000 ALTER TABLE `incoming_companies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projects` (
  `id` int NOT NULL AUTO_INCREMENT,
  `decription` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pro_store_idx` (`store_id`),
  KEY `fk_userIds_idx` (`user_id`),
  CONSTRAINT `fk_pro_store` FOREIGN KEY (`store_id`) REFERENCES `stores` (`id`),
  CONSTRAINT `fk_userIds` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,'كبرى المنصة','العباسية',1,1);
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `decription` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'أمين مخزن'),(2,'مدير عام');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_type`
--

DROP TABLE IF EXISTS `store_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `decription` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `location` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_store_idx` (`store_id`),
  CONSTRAINT `fk_store` FOREIGN KEY (`store_id`) REFERENCES `stores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_type`
--

LOCK TABLES `store_type` WRITE;
/*!40000 ALTER TABLE `store_type` DISABLE KEYS */;
INSERT INTO `store_type` VALUES (1,'تسليح',NULL,1),(2,'كهرباء',NULL,1),(3,'مياه',NULL,1);
/*!40000 ALTER TABLE `store_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stores`
--

DROP TABLE IF EXISTS `stores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `decription` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `location` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userId_idx` (`user_id`),
  CONSTRAINT `fk_userId` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stores`
--

LOCK TABLES `stores` WRITE;
/*!40000 ALTER TABLE `stores` DISABLE KEYS */;
INSERT INTO `stores` VALUES (1,'العاشر من رمضان','العاشر',1),(2,'قنا للكهرباء','قنا',2);
/*!40000 ALTER TABLE `stores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_gender`
--

DROP TABLE IF EXISTS `sys_gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_gender` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gender` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_gender`
--

LOCK TABLES `sys_gender` WRITE;
/*!40000 ALTER TABLE `sys_gender` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `units`
--

DROP TABLE IF EXISTS `units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `units` (
  `id` int NOT NULL AUTO_INCREMENT,
  `decription` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `units`
--

LOCK TABLES `units` WRITE;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
INSERT INTO `units` VALUES (1,'ك/ج'),(2,'م/ط'),(3,'سم');
/*!40000 ALTER TABLE `units` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` mediumtext,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  `date_modify` datetime DEFAULT NULL,
  `modified_by` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_role_idx` (`role_id`),
  CONSTRAINT `fk_role` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'1605779651762','ahmed','ahmed@gmail.com','$2a$10$Uo1QOOkkwPK7spNUbyFTburP9GixYqIiaHJVamk/x9iPtC5RLOyoS',NULL,0,1,'2020-11-19 11:54:09',0),(2,'1605779651763','bassam','bassam@gmail.com','$2a$10$Uo1QOOkkwPK7spNUbyFTburP9GixYqIiaHJVamk/x9iPtC5RLOyoS',NULL,0,1,'2020-11-19 11:54:09',1),(3,'1605779651764','ashraf','ashraf@gmail.com','$2a$10$Uo1QOOkkwPK7spNUbyFTburP9GixYqIiaHJVamk/x9iPtC5RLOyoS',NULL,0,2,'2020-11-19 11:54:09',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-09 23:53:07

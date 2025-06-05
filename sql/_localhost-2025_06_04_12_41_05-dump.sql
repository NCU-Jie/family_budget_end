-- MySQL dump 10.13  Distrib 8.4.4, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: family_budget
-- ------------------------------------------------------
-- Server version	8.4.4

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '记录ID（主键）',
  `category_id` bigint NOT NULL COMMENT '收支分类ID（逻辑关联分类表）',
  `member_id` bigint NOT NULL COMMENT '成员ID（逻辑关联成员表）',
  `money` decimal(19,2) NOT NULL COMMENT '收支金额（精确到分）',
  `description` varchar(255) DEFAULT NULL COMMENT '描述信息',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user` bigint NOT NULL COMMENT '创建人ID',
  `update_user` bigint NOT NULL COMMENT '最后修改人ID',
  `family_id` bigint NOT NULL COMMENT '家庭id',
  `member_name` varchar(32) NOT NULL COMMENT '成员姓名',
  `account_date` date NOT NULL,
  `type_id` bigint NOT NULL COMMENT '收支类型',
  PRIMARY KEY (`id`),
  KEY `idx_category_id` (`category_id`),
  KEY `idx_create_time` (`create_time`),
  KEY `idx_member_id` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='收支记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (13,18,43,200.00,'12恶的','2025-06-01 11:10:43','2025-06-03 15:06:37',0,0,0,'爸爸','2025-05-07',1),(14,21,43,200.00,'水果','2025-06-01 11:13:34','2025-06-01 11:13:34',0,0,0,'爸爸','2025-06-01',1),(15,20,45,3000.00,'小学开学','2025-06-01 11:14:30','2025-06-01 11:14:30',0,0,0,'大儿子','2025-06-01',1),(16,11,45,0.01,'放大发','2025-06-01 11:27:08','2025-06-01 11:27:08',0,0,0,'大儿子','2025-06-01',1),(18,20,0,5000.00,'给hi哦固然好','2025-06-01 11:33:37','2025-06-03 16:43:07',0,0,0,'管理员','2025-06-01',1),(19,23,0,7000.00,'给hi哦固然好','2025-06-01 13:57:01','2025-06-01 13:57:01',0,0,0,'管理员','2025-06-01',0),(20,21,41,200.00,'12恶的','2025-06-01 13:58:38','2025-06-01 13:58:38',0,0,0,'妈妈','2025-06-01',1),(21,18,43,200.00,'12恶的','2025-06-01 14:51:16','2025-06-01 14:51:16',0,0,0,'爸爸','2025-06-01',1),(22,18,43,200.00,'12恶的','2025-06-01 14:51:28','2025-06-01 14:51:28',0,0,0,'爸爸','2025-06-01',1),(23,18,43,200.00,'12恶的','2025-06-01 14:51:34','2025-06-01 14:51:34',0,0,0,'爸爸','2025-06-01',1),(24,18,43,200.00,'12恶的','2025-06-01 14:53:43','2025-06-01 14:53:43',0,0,0,'爸爸','2025-06-01',1),(25,18,43,200.00,'12恶的','2025-06-01 14:53:48','2025-06-01 14:53:48',0,0,0,'爸爸','2025-06-01',1),(26,18,43,200.00,'12恶的','2025-06-01 14:53:50','2025-06-01 14:53:50',0,0,0,'爸爸','2025-06-01',1),(27,18,43,200.00,'12恶的','2025-06-01 14:53:53','2025-06-01 14:53:53',0,0,0,'爸爸','2025-06-01',1),(28,20,43,200.00,'12恶的','2025-06-01 14:54:44','2025-06-01 14:54:44',0,0,0,'爸爸','2025-06-01',1),(29,21,43,200.00,'12恶的','2025-06-01 14:54:49','2025-06-01 14:54:49',0,0,0,'爸爸','2025-06-01',1),(30,22,41,0.01,NULL,'2025-06-01 15:43:50','2025-06-01 15:43:50',0,0,0,'妈妈','2025-06-01',0),(31,23,0,7000.00,'给hi哦固然好','2025-06-03 14:47:21','2025-06-03 14:47:21',41,41,0,'管理员','2024-06-04',0),(32,18,43,200.00,'12恶的','2025-06-03 14:47:42','2025-06-03 14:47:42',41,41,0,'爸爸','2025-05-07',1),(33,20,51,200.00,NULL,'2025-06-03 15:06:57','2025-06-03 15:06:57',41,41,0,'小女','2025-03-04',1),(34,24,41,300.00,'的发放','2025-06-03 15:10:51','2025-06-03 15:10:51',41,41,0,'妈妈','2025-05-21',1),(35,18,45,200.00,NULL,'2025-06-03 15:15:10','2025-06-03 15:15:10',41,41,0,'大儿','2025-06-09',1),(36,18,0,100.00,'爱发电','2025-06-03 15:21:50','2025-06-03 15:21:50',41,41,0,'管理员','2025-06-02',1),(37,19,45,0.01,'给法国','2025-06-03 15:22:06','2025-06-03 15:22:06',41,41,0,'大儿','2025-06-03',1),(38,22,45,2000.00,NULL,'2025-06-03 16:45:06','2025-06-03 16:45:06',0,0,0,'大儿','2025-06-02',0),(40,20,41,10210.00,NULL,'2025-06-03 18:04:08','2025-06-03 18:04:08',0,0,0,'妈妈','2026-06-11',1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `name` varchar(255) NOT NULL COMMENT '分类名称',
  `type_id` int NOT NULL COMMENT '收支id',
  `family_id` bigint NOT NULL COMMENT '家庭id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_user` bigint DEFAULT NULL,
  `update_user` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='收支分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (18,'娱乐',1,0,'2025-05-30 16:14:08','2025-05-30 16:14:08',0,0),(19,'房租',1,0,'2025-05-30 16:14:12','2025-05-30 16:14:12',0,0),(20,'学费',1,0,'2025-05-30 16:14:16','2025-05-30 16:14:16',0,0),(21,'过节礼品',1,0,'2025-05-30 16:14:29','2025-05-30 16:14:29',0,0),(22,'工资收入',0,0,'2025-05-30 17:55:13','2025-05-30 17:55:13',0,0),(23,'回礼',0,0,'2025-06-01 13:56:43','2025-06-01 13:56:43',0,0),(24,'文具',1,0,'2025-06-01 17:02:10','2025-06-01 17:02:10',0,0),(25,'旅游',1,0,'2025-06-01 17:02:16','2025-06-01 17:02:16',0,0);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) COLLATE utf8mb3_bin NOT NULL COMMENT '姓名',
  `username` varchar(32) COLLATE utf8mb3_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) COLLATE utf8mb3_bin DEFAULT NULL COMMENT '密码',
  `sex` varchar(2) COLLATE utf8mb3_bin NOT NULL COMMENT '性别',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_user` bigint DEFAULT NULL COMMENT '创建人',
  `update_user` bigint DEFAULT NULL COMMENT '修改人',
  `family_id` bigint NOT NULL COMMENT '家庭id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='成员信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (0,'管理员','admin','e10adc3949ba59abbe56e057f20f883e','0','2025-06-01 17:08:56','2025-06-01 17:08:56',41,41,0),(41,'妈妈','mama','e10adc3949ba59abbe56e057f20f883e','1','2025-05-29 09:32:37','2025-05-29 09:32:37',1,1,0),(45,'大儿',NULL,NULL,'0','2025-06-01 11:14:04','2025-06-01 11:14:04',0,0,0),(51,'小女',NULL,NULL,'1','2025-06-01 17:11:48','2025-06-01 17:11:48',41,41,0);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-04 12:41:06

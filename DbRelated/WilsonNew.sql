-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
--
-- Host: localhost    Database: practicesql
-- ------------------------------------------------------
-- Server version	5.6.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classes` (
  `ClassID` int(11) NOT NULL AUTO_INCREMENT,
  `ClassName` varchar(250) NOT NULL,
  `Credits` int(11) NOT NULL,
  `TeacherID` int(11) NOT NULL,
  PRIMARY KEY (`ClassID`),
  UNIQUE KEY `ClassID` (`ClassID`),
  KEY `FK_TeacherID_TeacherID` (`TeacherID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (1,'	BasicChemistry	',10,1),(2,'	AdvancedChemistry	',20,1),(3,'	BasicBiology	',10,3),(4,'	AdvancedBiology	',20,4),(5,'	BasicProgramming	',10,5),(6,'	AdvancedProgramming	',20,6),(7,'	Basic C#	',10,1),(8,'	Advanced C#	',20,1),(9,'	Basic VB	',10,1),(10,'	AdvanceVB	',20,10),(11,'	BasicJava	',10,11),(12,'	AdvancedJava	',20,12),(13,'	OracleJava	',20,13),(14,'	OracleSQL	',20,14),(15,'	Microsoft SQL	',20,15),(16,'	MySQL	',20,16),(17,'	Mongo	',30,17),(18,'	Django	',10,18),(19,'	PHP	',20,19),(20,'	YII	',10,20);
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `StudentID` int(11) NOT NULL,
  `FirstName` varchar(250) NOT NULL,
  `LastName` varchar(250) NOT NULL,
  `DOB` date NOT NULL,
  `Year` int(11) NOT NULL,
  PRIMARY KEY (`StudentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'	Woody	','	John	','1999-06-06',2000),(2,'	Buzz	','	Amber	','1970-01-01',2015),(3,'	DinoBot	','	Jack	','1950-04-06',2012),(4,'	Alan	','	Iwp	','1932-07-05',2013),(5,'	Grant	','	Yoghurt	','1999-02-01',2013),(6,'	Tim	','	Imagination	','1992-05-02',2013),(7,'	Bell	','	Magic	','1956-05-09',2013),(8,'	Simon	','	HighWire	','1920-01-01',2013),(9,'	Jones	','	Time	','1981-05-05',2013),(10,'	Wendy	','	Scarlette	','1987-02-06',2013),(11,'	Scrooge	','	Josh	','1988-01-01',2013),(12,'	Ned	','	Dumb	','1977-07-07',2013),(13,'	Ted	','	Smart	','1966-06-06',2013),(14,'	Sed	','	Heavy 	','1932-03-04',2009),(15,'	Humoud	','	Light	','1987-05-04',2009),(16,'	Daffy	','	Test	','1978-04-06',2009),(17,'	John	','	Non	','1953-02-05',2009),(18,'	Aron	','	NAN	','1954-02-06',2009),(19,'	Liam	','	Pod	','1957-03-05',2008),(20,'	Homer	','	Excel	','1977-01-02',2008);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentclasses`
--

DROP TABLE IF EXISTS `studentclasses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentclasses` (
  `StudentId` int(11) DEFAULT NULL,
  `ClassId` int(11) DEFAULT NULL,
  KEY `fk_ClassID_idx` (`ClassId`),
  KEY `fk_StudentID_idx` (`StudentId`),
  CONSTRAINT `fk_ClassID` FOREIGN KEY (`ClassId`) REFERENCES `classes` (`ClassID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_StudentID` FOREIGN KEY (`StudentId`) REFERENCES `student` (`StudentID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentclasses`
--

LOCK TABLES `studentclasses` WRITE;
/*!40000 ALTER TABLE `studentclasses` DISABLE KEYS */;
INSERT INTO `studentclasses` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(2,6),(2,7),(2,8),(2,9),(3,1),(3,2),(3,3),(3,4),(3,5),(3,6),(3,7),(3,8);
/*!40000 ALTER TABLE `studentclasses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `TeacherID` int(11) NOT NULL AUTO_INCREMENT,
  `RecordDate` date NOT NULL,
  `FirstName` varchar(250) NOT NULL,
  `LastName` varchar(250) NOT NULL,
  `SpecialSubject` varchar(250) NOT NULL,
  PRIMARY KEY (`TeacherID`),
  UNIQUE KEY `TeacherID_UNIQUE` (`TeacherID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'2015-01-01','			John	','		Time 	','		PHP	'),(2,'2015-01-01','			Amber	','		High	','		PHP	'),(3,'2015-01-01','			Jack	','		Low	','		PHP	'),(4,'2015-01-01','			Iwp	','		Swind	','		PHP	'),(5,'2015-01-01','			Yoghurt	','		Wig	','		PHP	'),(6,'2015-01-01','			Imagination	','		Shod	','		PHP	'),(7,'2015-01-01','			Magic	','		Timing	','		PHP	'),(8,'2015-01-01','			HighWire	','		Server	','		PHP	'),(9,'2015-01-01','			Time	','		Web	','		PHP	'),(10,'2015-01-01','			Scarlette	','		Hilly	','		PHP	'),(11,'2015-01-01','			Josh	','		Timley	','		PHP	'),(12,'2015-01-01','			Dumb	','		Hopes	','		PHP	'),(13,'2015-01-01','			Smart	','		Dreams	','		PHP	'),(14,'2015-01-01','			Heavy 	','		Hear	','		PHP	'),(15,'2015-01-01','			Light	','		Wind	','		JavaAdvanced	'),(16,'2015-01-01','			Test	','		Pop	','		JavaAdvanced	'),(17,'2015-01-01','			Non	','		Pope	','		JavaAdvanced	'),(18,'2015-01-01','			NAN	','		Shidley	','		JavaAdvanced	'),(19,'2015-01-01','			Pod	','		Racer	','		JavaAdvanced	'),(20,'2015-01-01','			Excel	','		Exert	','		MySQL	');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacherclasses`
--

DROP TABLE IF EXISTS `teacherclasses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacherclasses` (
  `TeacherId` int(11) DEFAULT NULL,
  `ClassId` int(11) DEFAULT NULL,
  KEY `fk_Class_idx` (`ClassId`),
  KEY `fk_Teacher_idx` (`TeacherId`),
  CONSTRAINT `fk_Class` FOREIGN KEY (`ClassId`) REFERENCES `classes` (`ClassID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Teacher` FOREIGN KEY (`TeacherId`) REFERENCES `teacher` (`TeacherID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacherclasses`
--

LOCK TABLES `teacherclasses` WRITE;
/*!40000 ALTER TABLE `teacherclasses` DISABLE KEYS */;
INSERT INTO `teacherclasses` VALUES (1,2);
/*!40000 ALTER TABLE `teacherclasses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(252) DEFAULT NULL,
  `UserPassword` varchar(251) NOT NULL,
  `Administer` tinyint(1) NOT NULL,
  `StudentId` varchar(251) DEFAULT NULL,
  `TeacherId` varchar(251) DEFAULT NULL,
  `LastLogin` date DEFAULT NULL,
  `SessionID` varchar(251) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'User1','Password',1,'3','1','2015-09-05','0.6231585879052292'),(2,'User2','Password',0,NULL,NULL,'2015-08-26','0.4043977337255027');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitors`
--

DROP TABLE IF EXISTS `visitors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visitors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ipAddress` varchar(255) NOT NULL,
  `PasswordSubmitted` varchar(251) DEFAULT NULL,
  `LoginName` varchar(251) DEFAULT NULL,
  `LastRequested` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitors`
--

LOCK TABLES `visitors` WRITE;
/*!40000 ALTER TABLE `visitors` DISABLE KEYS */;
INSERT INTO `visitors` VALUES (1,'0:0:0:0:0:0:0:1','me','poop',NULL),(2,'0:0:0:0:0:0:0:1','me','Hi',NULL),(3,'0:0:0:0:0:0:0:1','Password','User1',NULL),(4,'0:0:0:0:0:0:0:1','me','Teach',NULL),(5,'0:0:0:0:0:0:0:1','Password','User1',NULL),(6,'0:0:0:0:0:0:0:1','There','Hi',NULL),(7,'0:0:0:0:0:0:0:1','me','Time',NULL),(8,'0:0:0:0:0:0:0:1','see','Boob',NULL),(9,'0:0:0:0:0:0:0:1','e','tocken',NULL),(10,'0:0:0:0:0:0:0:1','s','tocken',NULL),(11,'0:0:0:0:0:0:0:1','ne','tine','2015-07-28'),(12,'0:0:0:0:0:0:0:1','me','mem','2015-07-28'),(13,'0:0:0:0:0:0:0:1','s','Hilpo','2015-07-28'),(14,'0:0:0:0:0:0:0:1','me','Melt','2015-07-28'),(15,'0:0:0:0:0:0:0:1','No','GoOn','2015-07-28'),(16,'0:0:0:0:0:0:0:1','Password','User','2015-07-28'),(17,'0:0:0:0:0:0:0:1','','User','2015-07-28'),(18,'0:0:0:0:0:0:0:1','','User','2015-07-28'),(19,'0:0:0:0:0:0:0:1','Tab','User1','2015-07-28'),(20,'0:0:0:0:0:0:0:1','d','d','2015-07-28'),(21,'0:0:0:0:0:0:0:1','h','Tme','2015-07-28'),(22,'0:0:0:0:0:0:0:1','Pasword','User1','2015-07-28'),(23,'0:0:0:0:0:0:0:1','li','wilson','2015-07-28'),(24,'0:0:0:0:0:0:0:1','d','padd','2015-07-31'),(25,'0:0:0:0:0:0:0:1','s','s','2015-07-31'),(26,'0:0:0:0:0:0:0:1','o','Tome','2015-07-31'),(27,'0:0:0:0:0:0:0:1','s','s','2015-07-31'),(28,'0:0:0:0:0:0:0:1','hi','This is somthing','2015-07-31'),(29,'0:0:0:0:0:0:0:1','TDST','ggT','2015-07-31'),(30,'0:0:0:0:0:0:0:1','password','User1','2015-07-31'),(31,'0:0:0:0:0:0:0:1','Li','wilson','2015-07-31'),(32,'0:0:0:0:0:0:0:1','h','Time','2015-08-03'),(33,'0:0:0:0:0:0:0:1','s','s','2015-08-03'),(34,'0:0:0:0:0:0:0:1','x','x','2015-08-03'),(35,'0:0:0:0:0:0:0:1','a','a','2015-08-03'),(36,'0:0:0:0:0:0:0:1','Passowrd','User1','2015-08-03'),(37,'0:0:0:0:0:0:0:1','s','User1','2015-08-05'),(38,'0:0:0:0:0:0:0:1','','User1','2015-08-05'),(39,'0:0:0:0:0:0:0:1','s','User1','2015-08-11'),(40,'0:0:0:0:0:0:0:1','s','User1','2015-08-11'),(41,'0:0:0:0:0:0:0:1','p','User1','2015-08-11'),(42,'0:0:0:0:0:0:0:1','password','User1','2015-08-11'),(43,'0:0:0:0:0:0:0:1','User1','Password1','2015-08-15'),(44,'0:0:0:0:0:0:0:1','User1','Password1','2015-08-15'),(45,'0:0:0:0:0:0:0:1','user1','password','2015-08-16'),(46,'0:0:0:0:0:0:0:1','user1','Password','2015-08-16'),(47,'0:0:0:0:0:0:0:1','User1','Passowrd','2015-08-16'),(48,'0:0:0:0:0:0:0:1','User1','1','2015-08-16'),(49,'0:0:0:0:0:0:0:1','User2','s','2015-08-23'),(50,'0:0:0:0:0:0:0:1','User2','password','2015-08-26');
/*!40000 ALTER TABLE `visitors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-09-08 20:43:58

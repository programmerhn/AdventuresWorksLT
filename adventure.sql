-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: AdvernturesWorksLT
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `audilog`
--

DROP TABLE IF EXISTS `audilog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `audilog` (
  `audiLogID` int NOT NULL AUTO_INCREMENT,
  `eventDate` datetime NOT NULL,
  `description` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userID` int NOT NULL,
  `eventTypeID` int NOT NULL,
  PRIMARY KEY (`audiLogID`),
  KEY `fk_audiLog_user1_idx` (`userID`),
  KEY `fk_audiLog_eventType1_idx` (`eventTypeID`),
  CONSTRAINT `fk_audiLog_eventType1` FOREIGN KEY (`eventTypeID`) REFERENCES `eventtype` (`eventTypeID`),
  CONSTRAINT `fk_audiLog_user1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `audilog`
--

LOCK TABLES `audilog` WRITE;
/*!40000 ALTER TABLE `audilog` DISABLE KEYS */;
INSERT INTO `audilog` VALUES (2,'2020-02-27 17:59:27','A record was inserted in salesOrderHeader3',1,3),(3,'2020-02-28 17:29:01','A record was inserted in salesOrderHeader4',1,3),(4,'2020-02-28 17:35:04','A record was deleted in salesOrderHeader 3',1,5);
/*!40000 ALTER TABLE `audilog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `color` (
  `colorID` int NOT NULL AUTO_INCREMENT,
  `colorName` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`colorID`),
  UNIQUE KEY `colorName_UNIQUE` (`colorName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (3,'Black'),(4,'White');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companyname`
--

DROP TABLE IF EXISTS `companyname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companyname` (
  `companyNameID` int NOT NULL AUTO_INCREMENT,
  `companyName` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`companyNameID`),
  UNIQUE KEY `companyName_UNIQUE` (`companyName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companyname`
--

LOCK TABLES `companyname` WRITE;
/*!40000 ALTER TABLE `companyname` DISABLE KEYS */;
INSERT INTO `companyname` VALUES (2,'Ultra Entregas');
/*!40000 ALTER TABLE `companyname` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customerID` int NOT NULL AUTO_INCREMENT,
  `title` char(8) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `firstName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `middleName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `lastName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `emailAddress` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` char(9) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `companyNameID` int NOT NULL,
  PRIMARY KEY (`customerID`),
  KEY `fk_customer_companyName_idx` (`companyNameID`),
  CONSTRAINT `fk_customer_companyName` FOREIGN KEY (`companyNameID`) REFERENCES `companyname` (`companyNameID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Mr.','Arvin','Joel','Rodas','arvin@gmail.com','9999-9999',2);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventtype`
--

DROP TABLE IF EXISTS `eventtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eventtype` (
  `eventTypeID` int NOT NULL AUTO_INCREMENT,
  `eventType` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`eventTypeID`),
  UNIQUE KEY `eventType_UNIQUE` (`eventType`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventtype`
--

LOCK TABLES `eventtype` WRITE;
/*!40000 ALTER TABLE `eventtype` DISABLE KEYS */;
INSERT INTO `eventtype` VALUES (5,'Delete'),(3,'Insert'),(4,'Update');
/*!40000 ALTER TABLE `eventtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paytype`
--

DROP TABLE IF EXISTS `paytype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paytype` (
  `payTypeID` int NOT NULL AUTO_INCREMENT,
  `payName` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`payTypeID`),
  UNIQUE KEY `payName_UNIQUE` (`payName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paytype`
--

LOCK TABLES `paytype` WRITE;
/*!40000 ALTER TABLE `paytype` DISABLE KEYS */;
INSERT INTO `paytype` VALUES (1,'Cash'),(3,'Credit'),(2,'Credit Card');
/*!40000 ALTER TABLE `paytype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `productID` int NOT NULL AUTO_INCREMENT,
  `productName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `productNumber` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `standarCost` decimal(7,2) NOT NULL,
  `listPrice` decimal(7,2) NOT NULL,
  `size` char(5) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `weight` decimal(8,2) NOT NULL,
  `colorID` int NOT NULL,
  `productCategoryID` int NOT NULL,
  `productModelID` int NOT NULL,
  PRIMARY KEY (`productID`),
  UNIQUE KEY `productNumber_UNIQUE` (`productNumber`),
  KEY `fk_product_color1_idx` (`colorID`),
  KEY `fk_product_productCategory1_idx` (`productCategoryID`),
  KEY `fk_product_productModel1_idx` (`productModelID`),
  CONSTRAINT `fk_product_color1` FOREIGN KEY (`colorID`) REFERENCES `color` (`colorID`),
  CONSTRAINT `fk_product_productCategory1` FOREIGN KEY (`productCategoryID`) REFERENCES `productcategory` (`productCategoryID`),
  CONSTRAINT `fk_product_productModel1` FOREIGN KEY (`productModelID`) REFERENCES `productmodel` (`productModelID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productcategory`
--

DROP TABLE IF EXISTS `productcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productcategory` (
  `productCategoryID` int NOT NULL AUTO_INCREMENT,
  `productCategoryName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`productCategoryID`),
  UNIQUE KEY `productName_UNIQUE` (`productCategoryName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcategory`
--

LOCK TABLES `productcategory` WRITE;
/*!40000 ALTER TABLE `productcategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `productcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productmodel`
--

DROP TABLE IF EXISTS `productmodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productmodel` (
  `productModelID` int NOT NULL AUTO_INCREMENT,
  `productModelName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`productModelID`),
  UNIQUE KEY `productModelName_UNIQUE` (`productModelName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productmodel`
--

LOCK TABLES `productmodel` WRITE;
/*!40000 ALTER TABLE `productmodel` DISABLE KEYS */;
/*!40000 ALTER TABLE `productmodel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesorderdetail`
--

DROP TABLE IF EXISTS `salesorderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salesorderdetail` (
  `salesOrderID` int NOT NULL,
  `productID` int NOT NULL,
  `orderQty` int NOT NULL,
  `unitPrice` decimal(7,2) NOT NULL,
  `unitPriceDiscount` decimal(4,2) NOT NULL,
  PRIMARY KEY (`salesOrderID`,`productID`),
  KEY `fk_salesOrderHeader_has_product_product1_idx` (`productID`),
  KEY `fk_salesOrderHeader_has_product_salesOrderHeader1_idx` (`salesOrderID`),
  CONSTRAINT `fk_salesOrderHeader_has_product_product1` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`),
  CONSTRAINT `fk_salesOrderHeader_has_product_salesOrderHeader1` FOREIGN KEY (`salesOrderID`) REFERENCES `salesorderheader` (`salesOrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesorderdetail`
--

LOCK TABLES `salesorderdetail` WRITE;
/*!40000 ALTER TABLE `salesorderdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `salesorderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salesorderheader`
--

DROP TABLE IF EXISTS `salesorderheader`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salesorderheader` (
  `salesOrderID` int NOT NULL AUTO_INCREMENT,
  `orderDate` datetime NOT NULL,
  `dueDate` datetime NOT NULL,
  `shipDate` datetime DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `creditCardNumber` decimal(16,0) NOT NULL,
  `payTypeID` int NOT NULL,
  `customerID` int NOT NULL,
  `userID` int NOT NULL,
  PRIMARY KEY (`salesOrderID`),
  KEY `fk_salesOrderHeader_payType1_idx` (`payTypeID`),
  KEY `fk_salesOrderHeader_customer1_idx` (`customerID`),
  KEY `fk_salesOrderHeader_user1_idx` (`userID`),
  CONSTRAINT `fk_salesOrderHeader_customer1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`),
  CONSTRAINT `fk_salesOrderHeader_payType1` FOREIGN KEY (`payTypeID`) REFERENCES `paytype` (`payTypeID`),
  CONSTRAINT `fk_salesOrderHeader_user1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salesorderheader`
--

LOCK TABLES `salesorderheader` WRITE;
/*!40000 ALTER TABLE `salesorderheader` DISABLE KEYS */;
/*!40000 ALTER TABLE `salesorderheader` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tx_afterInsertSalesOrderHeader` AFTER INSERT ON `salesorderheader` FOR EACH ROW BEGIN
	INSERT INTO audilog(eventDate, 
						description, 
						userID, 
                        eventTypeID)
    VALUE(now(), 
		  CONCAT('A record was inserted in salesOrderHeader', '' ,NEW.salesOrderID),
          NEW.userID, 
          3);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tx_afertUpdateSalesOrderHeader` AFTER UPDATE ON `salesorderheader` FOR EACH ROW BEGIN
	INSERT INTO audilog(eventDate, 
						description, 
						userID, 
                        eventTypeID)
    VALUE(now(), 
		  CONCAT('A record was updated in salesOrderHeader', ' ' , NEW.salesOrderID),
          NEW.userID, 
          4);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tx_afertDeleteSalesOrderHeader` AFTER DELETE ON `salesorderheader` FOR EACH ROW BEGIN
	INSERT INTO audilog(eventDate, 
						description, 
						userID, 
                        eventTypeID)
    VALUE(now(), 
		  CONCAT('A record was deleted in salesOrderHeader', ' ' , OLD.salesOrderID),
          OLD.userID, 
          5);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lastName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` char(9) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `adress` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userName` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Maryuri','Peralta','9999-9999','Res. Montecarlo','mperalta','123'),(2,'Sergio','Rios','9976-8079','Col. Montecarlo','srios','123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-25 17:38:01

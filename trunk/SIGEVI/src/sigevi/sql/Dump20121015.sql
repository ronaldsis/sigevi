CREATE DATABASE  IF NOT EXISTS `vidrieria` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `vidrieria`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: vidrieria
-- ------------------------------------------------------
-- Server version	5.5.27

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `codCat` int(11) NOT NULL,
  `nomCat` varchar(45) DEFAULT NULL,
  `desCat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codCat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'VIDRIOS','VIDRIOS EN GENERAL'),(2,'ALUMINIO','VARILLAS DE ALUMINIO '),(3,'RANURADO','RANURADOS EN GENERAL'),(4,'MOLDURA','MOLDURAS EN GENERAL'),(5,'ACRILICOS','ACRILICOS EN GENERAL');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `codPrv` int(10) unsigned NOT NULL,
  `tipPrv` varchar(20) DEFAULT NULL,
  `nomPrv` varchar(255) DEFAULT NULL,
  `docPrv` varchar(20) DEFAULT NULL,
  `dirPrv` varchar(255) DEFAULT NULL,
  `telPrv` varchar(20) DEFAULT NULL,
  `celPrv` varchar(20) DEFAULT NULL,
  `emaPrv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codPrv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'EMPRESA','PROVEEDOR ABC','2040714336','AV PERU 123','4315439','989547885','abc@hotmail.com'),(2,'EMPRESA','PROVEEDOR XYZ','20123456784','AV JUNIO 123','4312121','989999222','xyz6@hotmail.com');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulo`
--

DROP TABLE IF EXISTS `modulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modulo` (
  `codMod` int(10) unsigned NOT NULL,
  `nomMod` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codMod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulo`
--

LOCK TABLES `modulo` WRITE;
/*!40000 ALTER TABLE `modulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_medida`
--

DROP TABLE IF EXISTS `producto_medida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto_medida` (
  `codProMed` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `producto_codPro` int(10) unsigned NOT NULL,
  `medida_codMed` int(10) unsigned NOT NULL,
  PRIMARY KEY (`codProMed`),
  KEY `producto_medida_FKIndex1` (`producto_codPro`),
  KEY `producto_medida_FKIndex2` (`medida_codMed`),
  CONSTRAINT `producto_medida_ibfk_1` FOREIGN KEY (`producto_codPro`) REFERENCES `producto` (`codPro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `producto_medida_ibfk_2` FOREIGN KEY (`medida_codMed`) REFERENCES `medida` (`codMed`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_medida`
--

LOCK TABLES `producto_medida` WRITE;
/*!40000 ALTER TABLE `producto_medida` DISABLE KEYS */;
INSERT INTO `producto_medida` VALUES (1,1,10),(2,2,9),(3,3,10),(4,4,10),(5,5,9),(6,6,6),(7,7,5),(8,8,11),(9,9,10),(10,10,10),(11,11,7),(12,12,2),(13,13,9),(14,14,10),(15,15,10),(16,16,10),(17,17,1),(18,18,1),(19,19,4),(20,20,3),(21,21,3),(22,22,3),(23,23,3),(24,24,8),(25,25,8),(26,26,8),(27,27,4),(28,28,2),(29,29,12),(30,30,12),(31,31,12),(32,32,12),(33,33,12),(34,34,12),(35,35,12),(36,36,12),(37,37,12),(38,38,12);
/*!40000 ALTER TABLE `producto_medida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_venta`
--

DROP TABLE IF EXISTS `detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_venta` (
  `nroDet` int(10) unsigned NOT NULL,
  `canDet` double DEFAULT NULL,
  `preDet` double DEFAULT NULL,
  `producto_codPro` int(10) unsigned NOT NULL,
  `venta_nroVen` int(10) unsigned NOT NULL,
  PRIMARY KEY (`nroDet`),
  KEY `detalleventa_FKIndex1` (`producto_codPro`),
  KEY `detalleventa_FKIndex2` (`venta_nroVen`),
  CONSTRAINT `detalle_venta_ibfk_1` FOREIGN KEY (`producto_codPro`) REFERENCES `producto` (`codPro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `detalle_venta_ibfk_2` FOREIGN KEY (`venta_nroVen`) REFERENCES `venta` (`nroVen`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_venta`
--

LOCK TABLES `detalle_venta` WRITE;
/*!40000 ALTER TABLE `detalle_venta` DISABLE KEYS */;
INSERT INTO `detalle_venta` VALUES (1,350,1,1,1),(2,64.8,3,1,1),(3,350,3,1,2),(4,360,3,1,3),(5,350,1,1,3);
/*!40000 ALTER TABLE `detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `nroCop` int(10) unsigned NOT NULL,
  `nroCom` varchar(20) DEFAULT NULL,
  `tipCom` varchar(20) DEFAULT NULL,
  `fecCom` datetime DEFAULT NULL,
  `usuario_codUsu` int(10) unsigned NOT NULL,
  `proveedor_codPrv` int(10) unsigned NOT NULL,
  PRIMARY KEY (`nroCop`),
  KEY `compra_FKIndex1` (`proveedor_codPrv`),
  KEY `compra_FKIndex2` (`usuario_codUsu`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`proveedor_codPrv`) REFERENCES `proveedor` (`codPrv`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`usuario_codUsu`) REFERENCES `usuario` (`codUsu`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,'123123','FACTURA','2012-10-14 00:00:00',1,1);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medida`
--

DROP TABLE IF EXISTS `medida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medida` (
  `codMed` int(10) unsigned NOT NULL,
  `nomMed` varchar(20) DEFAULT NULL,
  `ancMed` int(11) DEFAULT NULL,
  `larMed` int(11) DEFAULT NULL,
  `simMed` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codMed`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medida`
--

LOCK TABLES `medida` WRITE;
/*!40000 ALTER TABLE `medida` DISABLE KEYS */;
INSERT INTO `medida` VALUES (1,'214 * 168',214,168,'CM'),(2,'220 * 180',220,180,'CM'),(3,'240 * 130',240,130,'CM'),(4,'240 * 150',240,150,'CM'),(5,'240 * 160 ',240,160,'CM'),(6,'240 * 200 ',240,200,'CM'),(7,'244 * 183',244,183,'CM'),(8,'250 * 160',250,160,'CM'),(9,'321 * 214',321,214,'CM'),(10,'330 * 214',330,214,'CM'),(11,'360 * 214',360,214,'CM'),(12,'VARILLA',0,0,'VAR');
/*!40000 ALTER TABLE `medida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `codUsu` int(10) unsigned NOT NULL,
  `logUsu` varchar(20) DEFAULT NULL,
  `nomUsu` varchar(45) DEFAULT NULL,
  `apeUsu` varchar(255) DEFAULT NULL,
  `pasUsu` varchar(20) DEFAULT NULL,
  `perfil_codPer` int(10) unsigned NOT NULL,
  PRIMARY KEY (`codUsu`),
  KEY `tbUsuario_FKIndex1` (`perfil_codPer`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`perfil_codPer`) REFERENCES `perfil` (`codPer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'ccasti','CARLOS','CASTILLO','tastingo',1),(2,'jwatan','JAVIER ','WATANABE','123',1),(3,'lloo','LOGAN','LOO','carlos',1),(4,'sdelga','SILVIA','DELGADO','123',2),(5,'mrojas','MARCO','ROJAS','123',1),(6,'kcasti','KATHERINE','CASTILLO','logan',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `codPro` int(10) unsigned NOT NULL,
  `nomPro` varchar(255) DEFAULT NULL,
  `desPro` varchar(255) DEFAULT NULL,
  `stoPro` double DEFAULT NULL,
  `preCom` double DEFAULT NULL,
  `preVen` double DEFAULT NULL,
  `categoria_codCat` int(11) NOT NULL,
  PRIMARY KEY (`codPro`),
  KEY `producto_FKIndex2` (`categoria_codCat`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`categoria_codCat`) REFERENCES `categoria` (`codCat`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'POLARIZADO BRONCE 8MM','',20,300,350,1),(2,'POLARIZADO GRIS 8MM','',0,320,370,1),(3,'POLARIZADO GRIS  5.5MM','',0,210,235,1),(4,'POLARIZADO BRONCE 5.5MM',' ',0,210,240,1),(5,'POLARIZADO AZUL 5.5MM',' ',0,210,235,1),(6,'POLARIZADO BRONCE 4MM',' ',0,80,110,1),(7,'POLARIZADO BRONCE 3MM',' ',0,70,90,1),(8,'TRANSPARENTE 8MM',' ',0,330,370,1),(9,'TRANSPARENTE 5.5MM',' ',0,170,200,1),(10,'TRANSPARENTE 4MM',' ',0,150,180,1),(11,'TRANSPARENTE 3MM',' ',0,67,77,1),(12,'TRANSPARENTE 2MM',' ',0,45,55,1),(13,'REFLEJANTE BRONCE 5.5MM',' ',0,270,300,1),(14,'REFLEJANTE PAPIRO 5.5MM',' ',0,270,300,1),(15,'REFLEJANTE VERDE 5.5MM',' ',0,270,290,1),(16,'REFLEJANTE AZUL CHINO 5.5.MM',' ',0,270,290,1),(17,'CATEDRAL KARATECHI  3MM',' ',0,48,60,1),(18,'CATEDRAL CUADRICULADO 3MM',' ',0,45,60,1),(19,'CATEDRAL SILECIA 3MM',' ',0,49,60,1),(20,'CATEDRAL BOTÓN 3MM',' ',0,42,52,1),(21,'CATEDRAL PIRÁMIDE 3MM',' ',0,42,52,1),(22,'CATEDRAL RAMA 3MM',' ',0,42,52,1),(23,'CATEDRAL BOREAL 3MM',' ',0,42,52,1),(24,'CATEDRAL VERDE 3MM',' ',0,90,105,1),(25,'CATEDRAL AZUL 3MM',' ',0,90,105,1),(26,'CATEDRAL ÁMBAR 3MM',' ',0,90,105,1),(27,'CATEDRAL LLOVIZNA BRONCE 3MM',' ',0,75,95,1),(28,'ESPEJO  MIREX 2MM',' ',0,85,100,1),(29,'CANALETA ALTA  NATURAL',' ',0,6,9.5,2),(30,'CANALETA BAJA NATURAL',' ',0,5,8.5,2),(31,'PARANTE DE HOJA ECONOMICO NATURAL',' ',0,21,28,2),(32,'PARANTE DE HOJA ECONOMICO NEGRO',' ',0,25.5,29,2),(33,'TUBO CUAD. 1 1/2 * 1 1/2  NEGRO',' ',0,23.5,28,2),(34,'TUBO CUAD. 1 1/2 * 1 1/2 DORADO',' ',0,33.7,40,2),(35,'TUBO 3 1/4 * 1 1/2 PAFLON NATURAL',' ',0,45.5,58,2),(36,'T NEGRO',' ',0,15.5,19,2),(37,'U 1/2 * 1/2 NEGRO',' ',0,6.6,9,2),(38,'U 3/4 * 1/2 NEGRO',' ',0,9.5,13,2),(39,'PANEL 30 * 113 DE 1/32 PESADO','GRIS',0,12.3,18,3),(40,'PANEL 30 * 90 DE 1/32 PESADO','GRIS',0,10.8,16,3),(41,'PANEL 30 * 113 DE 1/40','GRIS',0,9.8,13,3),(42,'PANEL 30 * 90 DE 1/40','GRIS',0,8.8,12,3),(43,'ANGULOS LISOS DE 1.0MM','NEGRO',0,5.5,7,3),(44,'2 1/4 SINDI WOSH',' ',0,6,7.3,4),(45,'2\" PALMERA ','DORADO',0,4.5,5.8,4),(46,'1 1/2 PALMERA','DORADO',0,3.5,4.2,4),(47,'1 1/2 CONCABO','COBRIZO',0,3.5,4.2,4),(48,'1 1/2  SOMBRERITO','',0,3.5,4.2,4),(49,'1 1/4 MOSTRITO ','FONDO BLANCO',0,1.8,2.8,4),(50,'1 1/4 WAFER ','BLANCO Y CREMA',0,1.8,2.6,4),(51,'1 1/4 BASTIDOR','ROJO, VERDE, BLANCO',0,2,2.7,4),(52,'1 1/4  MELCOCHA PLANA','PURPURINA Y NEGRO',0,2,2.7,4),(53,'1 1/4 ESCAMA SICODELICO','PLATEADO',0,3.5,4.5,4),(54,'1 1/4 CLAVEL ENVEJECIDO','DORADO',0,4,5.5,4),(55,'1\" SOMBRERITO',' ',0,2,2.7,4),(56,'1\" CAÑA GASPEADA','CAOBA',0,2.2,3,4),(57,'1\" MEDIA LUNA',' ',0,NULL,NULL,4),(58,'POLICARBONATO','INCOLORO',0,NULL,NULL,5),(59,'POLIETILENO GAVIOTA AZUL','AZUL',0,NULL,NULL,5),(60,'POLIETILENO GAVIOTA CHAMPANG','CHAMPANG',0,NULL,NULL,5),(61,'POLIETILENO  LLOVISNA CHAMPANG','CHAMPANG',0,NULL,NULL,5),(62,'POLIETILENO GAVIOTA SALMON','SALMON',0,NULL,NULL,5),(63,'PLANCHAS ACRILICO SIMPLE 2MM GRIS','GRIS',0,NULL,NULL,5),(64,'PLANCHAS ACRILICO SIMPLE 2MM TRANS','TRANPARENTE',0,NULL,NULL,5),(65,'PLANCHAS ACRILICO SIMPLE 3MM','TRANPARENTE',0,NULL,NULL,5),(66,'PLANCHAS ACRILICO SIMPLE 5MM','TRANPARENTE',0,NULL,NULL,5);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil_modulo`
--

DROP TABLE IF EXISTS `perfil_modulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil_modulo` (
  `codPerMod` int(10) unsigned NOT NULL,
  `visible` tinyint(1) DEFAULT NULL,
  `modulo_codMod` int(10) unsigned NOT NULL,
  `perfil_codPer` int(10) unsigned NOT NULL,
  PRIMARY KEY (`codPerMod`),
  KEY `perfil_modulo_FKIndex1` (`perfil_codPer`),
  KEY `perfil_modulo_FKIndex2` (`modulo_codMod`),
  CONSTRAINT `perfil_modulo_ibfk_1` FOREIGN KEY (`perfil_codPer`) REFERENCES `perfil` (`codPer`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `perfil_modulo_ibfk_2` FOREIGN KEY (`modulo_codMod`) REFERENCES `modulo` (`codMod`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil_modulo`
--

LOCK TABLES `perfil_modulo` WRITE;
/*!40000 ALTER TABLE `perfil_modulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `perfil_modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `nroVen` int(10) unsigned NOT NULL,
  `nroCom` varchar(20) DEFAULT NULL,
  `tipCom` varchar(20) DEFAULT NULL,
  `fecVen` datetime DEFAULT NULL,
  `usuario_codUsu` int(10) unsigned NOT NULL,
  `cliente_codCli` int(10) unsigned NOT NULL,
  PRIMARY KEY (`nroVen`),
  KEY `venta_FKIndex1` (`usuario_codUsu`),
  KEY `venta_FKIndex2` (`cliente_codCli`),
  CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`usuario_codUsu`) REFERENCES `usuario` (`codUsu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`cliente_codCli`) REFERENCES `cliente` (`codCli`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,'1','FACTURA','2012-02-10 00:00:00',1,3),(2,'1234','BOLETA','2012-02-10 00:00:00',1,1),(3,'123123','FACTURA','2012-03-10 00:00:00',1,1);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_despacho`
--

DROP TABLE IF EXISTS `producto_despacho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto_despacho` (
  `codProDes` int(10) unsigned NOT NULL,
  `producto_codPro` int(10) unsigned NOT NULL,
  `despacho_codDes` int(10) unsigned NOT NULL,
  PRIMARY KEY (`codProDes`),
  KEY `producto_tipoprecio_FKIndex1` (`producto_codPro`),
  KEY `producto_despacho_FKIndex2` (`despacho_codDes`),
  CONSTRAINT `producto_despacho_ibfk_1` FOREIGN KEY (`producto_codPro`) REFERENCES `producto` (`codPro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `producto_despacho_ibfk_2` FOREIGN KEY (`despacho_codDes`) REFERENCES `despacho` (`codDes`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_despacho`
--

LOCK TABLES `producto_despacho` WRITE;
/*!40000 ALTER TABLE `producto_despacho` DISABLE KEYS */;
INSERT INTO `producto_despacho` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,2,1),(7,2,2),(8,2,3),(9,2,4),(10,2,5),(11,3,1),(12,3,2),(13,3,3),(14,3,4),(15,3,5),(16,4,1),(17,4,2),(18,4,3),(19,4,4),(20,4,5),(21,5,1),(22,5,2),(23,5,3),(24,5,4),(25,5,5),(26,6,1),(27,6,2),(28,6,3),(29,6,4),(30,6,5),(31,7,1),(32,7,2),(33,7,3),(34,7,4),(35,7,5),(36,8,1),(37,8,2),(38,8,3),(39,8,4),(40,8,5),(41,9,1),(42,9,2),(43,9,3),(44,9,4),(45,9,5),(46,10,1),(47,10,2),(48,10,3),(49,10,4),(50,10,5),(51,11,1),(52,11,2),(53,11,3),(54,11,4),(55,11,5),(56,12,1),(57,12,2),(58,12,3),(59,12,4),(60,12,5),(61,13,1),(62,13,2),(63,13,3),(64,13,4),(65,13,5),(66,14,1),(67,14,2),(68,14,3),(69,14,4),(70,14,5),(71,15,1),(72,15,2),(73,15,3),(74,15,4),(75,15,5),(76,16,1),(77,16,2),(78,16,3),(79,16,4),(80,16,5),(81,17,1),(82,17,2),(83,17,3),(84,17,4),(85,17,5),(86,18,1),(87,18,2),(88,18,3),(89,18,4),(90,18,5),(91,19,1),(92,19,2),(93,19,3),(94,19,4),(95,19,5),(96,20,1),(97,20,2),(98,20,3),(99,20,4),(100,20,5),(101,21,1),(102,21,2),(103,21,3),(104,21,4),(105,21,5),(106,22,1),(107,22,2),(108,22,3),(109,22,4),(110,22,5),(111,23,1),(112,23,2),(113,23,3),(114,23,4),(115,23,5),(116,24,1),(117,24,2),(118,24,3),(119,24,4),(120,24,5),(121,25,1),(122,25,2),(123,25,3),(124,25,4),(125,25,5),(126,26,1),(127,26,2),(128,26,3),(129,26,4),(130,26,5),(131,27,1),(132,27,2),(133,27,3),(134,27,4),(135,27,5),(136,28,1),(137,28,2),(138,28,3),(139,28,4),(140,28,5),(141,29,7),(142,29,6),(143,30,7),(144,30,6),(145,31,7),(146,31,6),(147,32,7),(148,32,6),(149,33,7),(150,33,6),(151,34,7),(152,34,6),(153,35,7),(154,35,6),(155,36,7),(156,36,6),(157,37,7),(158,37,6),(159,38,7),(160,38,6);
/*!40000 ALTER TABLE `producto_despacho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `codCli` int(10) unsigned NOT NULL,
  `tipCli` varchar(20) DEFAULT NULL,
  `nomCli` varchar(255) DEFAULT NULL,
  `docCli` varchar(20) DEFAULT NULL,
  `dirCli` varchar(255) DEFAULT NULL,
  `telCli` varchar(20) DEFAULT NULL,
  `celCli` varchar(20) DEFAULT NULL,
  `emaCli` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codCli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'PERSONA','MARCO CASTILLO','40714334','PERU 123','4315439','989547220','mcastillo@hotmail.com'),(2,'PERSONA','MARCO RAMIREZ','40714336','PERU 123','4315444','98999922','mramirez@hotmail.com'),(3,'PERSONA','CARLOS CASTILLO','40714338','PERU 123','5551212','989547111','ccastillo@hotmail.com');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `codPer` int(10) unsigned NOT NULL,
  `nomPer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codPer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (1,'ADMINISTRADOR'),(2,'VENDEDOR'),(3,'OPERARIO');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `despacho`
--

DROP TABLE IF EXISTS `despacho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `despacho` (
  `codDes` int(10) unsigned NOT NULL,
  `nomDes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codDes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `despacho`
--

LOCK TABLES `despacho` WRITE;
/*!40000 ALTER TABLE `despacho` DISABLE KEYS */;
INSERT INTO `despacho` VALUES (1,'PLANCHA'),(2,'3/4 PLANCHA'),(3,'1/2 PLANCHA'),(4,'1/4 PLANCHA'),(5,'PIE'),(6,'METRO'),(7,'VARILLA');
/*!40000 ALTER TABLE `despacho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_compra`
--

DROP TABLE IF EXISTS `detalle_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_compra` (
  `nroDet` int(10) unsigned NOT NULL,
  `canDet` double DEFAULT NULL,
  `preDet` double DEFAULT NULL,
  `compra_nroCop` int(10) unsigned NOT NULL,
  `producto_codPro` int(10) unsigned NOT NULL,
  PRIMARY KEY (`nroDet`),
  KEY `detallecompra_FKIndex1` (`compra_nroCop`),
  KEY `detallecompra_FKIndex2` (`producto_codPro`),
  CONSTRAINT `detalle_compra_ibfk_1` FOREIGN KEY (`compra_nroCop`) REFERENCES `compra` (`nroCop`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `detalle_compra_ibfk_2` FOREIGN KEY (`producto_codPro`) REFERENCES `producto` (`codPro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_compra`
--

LOCK TABLES `detalle_compra` WRITE;
/*!40000 ALTER TABLE `detalle_compra` DISABLE KEYS */;
INSERT INTO `detalle_compra` VALUES (1,24,12,1,1),(2,60,12,1,1),(3,60,5,1,4);
/*!40000 ALTER TABLE `detalle_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_precio`
--

DROP TABLE IF EXISTS `producto_precio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto_precio` (
  `codProPre` int(10) unsigned NOT NULL,
  `producto_codPro` int(10) unsigned NOT NULL,
  `producto_medida_codProMed` int(10) unsigned NOT NULL,
  `producto_despacho_codProDes` int(10) unsigned NOT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`codProPre`),
  KEY `producto_precio_FKIndex1` (`producto_codPro`),
  KEY `producto_precio_FKIndex2` (`producto_despacho_codProDes`),
  KEY `producto_precio_FKIndex3` (`producto_medida_codProMed`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_precio`
--

LOCK TABLES `producto_precio` WRITE;
/*!40000 ALTER TABLE `producto_precio` DISABLE KEYS */;
INSERT INTO `producto_precio` VALUES (1,1,10,1,350),(2,1,10,2,262.5),(3,1,10,3,175),(4,1,10,4,87.5),(5,1,10,5,6),(6,2,9,1,370),(7,2,9,2,277.5),(8,2,9,3,185),(9,2,9,4,92.5),(10,2,9,5,6.6),(11,3,10,1,235),(12,3,10,2,176.25),(13,3,10,3,117.5),(14,3,10,4,58.75),(15,3,10,5,3.5),(16,4,10,1,240),(17,4,10,2,180),(18,4,10,3,120),(19,4,10,4,60),(20,4,10,5,3.5),(21,5,9,1,235),(22,5,9,2,176.25),(23,5,9,3,117.5),(24,5,9,4,58.75),(25,5,9,5,3.5),(26,6,6,1,110),(27,6,6,2,82.5),(28,6,6,3,55),(29,6,6,4,27.5),(30,6,6,5,3),(31,7,5,1,90),(32,7,5,2,67.5),(33,7,5,3,45),(34,7,5,4,22.5),(35,7,5,5,2.3),(36,8,11,1,370),(37,8,11,2,277.5),(38,8,11,3,185),(39,8,11,4,92.5),(40,8,11,5,6),(41,9,10,1,200),(42,9,10,2,150),(43,9,10,3,100),(44,9,10,4,50),(45,9,10,5,3),(46,10,10,1,180),(47,10,10,2,135),(48,10,10,3,90),(49,10,10,4,45),(50,10,10,5,2.3),(51,11,7,1,77),(52,11,7,2,57.75),(53,11,7,3,38.5),(54,11,7,4,19.25),(55,11,7,5,1.8),(56,12,2,1,55),(57,12,2,2,41.25),(58,12,2,3,27.5),(59,12,2,4,13.75),(60,12,2,5,1.5),(61,13,9,1,300),(62,13,9,2,225),(63,13,9,3,150),(64,13,9,4,75),(65,13,9,5,5.5),(66,14,10,1,300),(67,14,10,2,225),(68,14,10,3,150),(69,14,10,4,75),(70,14,10,5,5.5),(71,15,10,1,290),(72,15,10,2,217.5),(73,15,10,3,145),(74,15,10,4,72.5),(75,15,10,5,5.5),(76,16,10,1,290),(77,16,10,2,217.5),(78,16,10,3,145),(79,16,10,4,72.5),(80,16,10,5,5),(81,17,1,1,60),(82,17,1,2,45),(83,17,1,3,30),(84,17,1,4,15),(85,17,1,5,1.8),(86,18,1,1,60),(87,18,1,2,45),(88,18,1,3,30),(89,18,1,4,15),(90,18,1,5,1.9),(91,19,4,1,60),(92,19,4,2,45),(93,19,4,3,30),(94,19,4,4,15),(95,19,4,5,1.8),(96,20,3,1,52),(97,20,3,2,39),(98,20,3,3,26),(99,20,3,4,13),(100,20,3,5,1.8),(101,21,3,1,52),(102,21,3,2,39),(103,21,3,3,26),(104,21,3,4,13),(105,21,3,5,1.8),(106,22,3,1,52),(107,22,3,2,39),(108,22,3,3,26),(109,22,3,4,13),(110,22,3,5,1.8),(111,23,3,1,52),(112,23,3,2,39),(113,23,3,3,26),(114,23,3,4,13),(115,23,3,5,1.8),(116,24,8,1,105),(117,24,8,2,78.75),(118,24,8,3,52.5),(119,24,8,4,26.25),(120,24,8,5,2.5),(121,25,8,1,105),(122,25,8,2,78.75),(123,25,8,3,52.5),(124,25,8,4,26.25),(125,25,8,5,2.5),(126,26,8,1,105),(127,26,8,2,78.75),(128,26,8,3,52.5),(129,26,8,4,26.25),(130,26,8,5,2.5),(131,27,4,1,95),(132,27,4,2,71.25),(133,27,4,3,47.5),(134,27,4,4,23.75),(135,27,4,5,2.5),(136,28,2,1,100),(137,28,2,2,75),(138,28,2,3,50),(139,28,2,4,25),(140,28,2,5,2.4),(141,29,12,7,9.5),(142,29,12,6,2),(143,30,12,7,8.5),(144,30,12,6,2),(145,31,12,7,28),(146,31,12,6,6),(147,32,12,7,29),(148,32,12,6,6),(149,33,12,7,28),(150,33,12,6,6),(151,34,12,7,40),(152,34,12,6,8),(153,35,12,7,58),(154,35,12,6,11),(155,36,12,7,19),(156,36,12,6,4.5),(157,37,12,7,9),(158,37,12,6,2),(159,38,12,7,13),(160,38,12,6,3);
/*!40000 ALTER TABLE `producto_precio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-10-15  5:17:16

CREATE DATABASE  IF NOT EXISTS `DB_SGRPM` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `DB_SGRPM`;
-- MySQL dump 10.13  Distrib 5.5.38, for debian-linux-gnu (i686)
--
-- Host: 127.0.0.1    Database: DB_SGRPM
-- ------------------------------------------------------
-- Server version	5.5.38-0ubuntu0.12.04.1

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
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cliente` (
  `id_cli` int(11) NOT NULL AUTO_INCREMENT,
  `email_cli` varchar(45) DEFAULT NULL,
  `rg_cli` varchar(45) DEFAULT NULL,
  `nome_cli` varchar(45) DEFAULT NULL,
  `tel_cli` varchar(45) DEFAULT NULL,
  `cpf_cli` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_cli`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES (20,'joaomarcusdeoliveira@hotmail.com','55.227.866-0','Joao Marcus de Oliveira','(14)9608-6391','449.075.228-86'),(21,'andersonipaussu@outlook.com','33.445.233-5','Anderson fernandes Cardoso','(14)9601-6446','431.542.418-84'),(22,'rafadam.gama@gmail.com','38.926.701-6','Rafael Damasceno Gama','(14)9986-4796','439.903.368-19'),(25,'                                       ','  .   .   - ','                                     ','(  )    -    ','431.989.218-64');
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Funcionario`
--

DROP TABLE IF EXISTS `Funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Funcionario` (
  `id_fun` int(11) NOT NULL AUTO_INCREMENT,
  `cargo_fun` varchar(45) DEFAULT NULL,
  `rg_fun` varchar(16) DEFAULT NULL,
  `nome_fun` varchar(60) DEFAULT NULL,
  `tel_fun` varchar(45) DEFAULT NULL,
  `cpf_fun` varchar(15) DEFAULT NULL,
  `sexo_fun` varchar(9) DEFAULT NULL,
  `log_fun` varchar(60) DEFAULT NULL,
  `num_fun` varchar(5) DEFAULT NULL,
  `bairro_fun` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_fun`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Funcionario`
--

LOCK TABLES `Funcionario` WRITE;
/*!40000 ALTER TABLE `Funcionario` DISABLE KEYS */;
INSERT INTO `Funcionario` VALUES (12,'Gerente','44.553.467-6','João Marcus de Oliveira','(14)9608-6391','449.075.228-86','Masculino','Rua Jose','104','Jardim dos Eucalipto'),(13,'Funcionario','38.926.701-6','Rafael Damasceno Gama','(14)9864-7902','439.903.368-19','Masculino','Garcia braga','383','centro');
/*!40000 ALTER TABLE `Funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Item_Pedido`
--

DROP TABLE IF EXISTS `Item_Pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Item_Pedido` (
  `id_IP` int(11) NOT NULL AUTO_INCREMENT,
  `id_ped` int(11) DEFAULT NULL,
  `id_prod` int(11) DEFAULT NULL,
  `quant_IP` int(11) DEFAULT NULL,
  `preco_IP` float(6,2) DEFAULT NULL,
  PRIMARY KEY (`id_IP`),
  KEY `id_ped_idx` (`id_ped`),
  KEY `id_prod_idx` (`id_prod`),
  CONSTRAINT `id_ped` FOREIGN KEY (`id_ped`) REFERENCES `Pedidos` (`id_ped`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_prod` FOREIGN KEY (`id_prod`) REFERENCES `Produto` (`id_prod`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Item_Pedido`
--

LOCK TABLES `Item_Pedido` WRITE;
/*!40000 ALTER TABLE `Item_Pedido` DISABLE KEYS */;
INSERT INTO `Item_Pedido` VALUES (30,7,16,1,12.00),(31,7,16,1,12.00),(32,13,16,1,12.00),(33,13,13,1,3.00),(34,12,13,1,3.00),(35,4,13,1,3.00),(36,4,13,1,3.00);
/*!40000 ALTER TABLE `Item_Pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Login`
--

DROP TABLE IF EXISTS `Login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Login` (
  `id_log` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `nivel_acesso` varchar(45) DEFAULT NULL,
  `cod_barra` bigint(20) NOT NULL,
  PRIMARY KEY (`id_log`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Login`
--

LOCK TABLES `Login` WRITE;
/*!40000 ALTER TABLE `Login` DISABLE KEYS */;
INSERT INTO `Login` VALUES (1,'JoaoMarcus','1234','Administrador',7898549361538),(2,'Jota','12345','Gerente',44907522886),(3,'RGama','macaco','Funcionario',43990336819);
/*!40000 ALTER TABLE `Login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Mesa`
--

DROP TABLE IF EXISTS `Mesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Mesa` (
  `id_Mesa` int(11) NOT NULL,
  `situa_mesa` varchar(45) DEFAULT NULL,
  `num_mesa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_Mesa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Mesa`
--

LOCK TABLES `Mesa` WRITE;
/*!40000 ALTER TABLE `Mesa` DISABLE KEYS */;
INSERT INTO `Mesa` VALUES (1,'fechado',1),(2,'fechado',2),(3,'fechado',3),(4,'aberto',4),(5,'fechado',5),(6,NULL,6),(7,'aberto',7),(8,NULL,7),(9,NULL,8),(10,NULL,9),(11,NULL,10),(12,'aberto',11),(13,'aberto',12),(14,NULL,14),(15,NULL,15),(16,NULL,16),(17,'aberto',17),(18,NULL,18),(19,NULL,19),(20,NULL,20),(21,'aberto',21),(22,NULL,22),(23,NULL,23),(24,NULL,24),(25,NULL,25),(26,'aberto',26),(27,NULL,27),(28,'aberto',28),(29,NULL,29),(30,NULL,30);
/*!40000 ALTER TABLE `Mesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pedidos`
--

DROP TABLE IF EXISTS `Pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Pedidos` (
  `id_ped` int(11) NOT NULL,
  `hora_ped` varchar(30) DEFAULT NULL,
  `data_ped` varchar(15) DEFAULT NULL,
  `status_ped` varchar(8) DEFAULT NULL,
  `id_Mesa` int(11) DEFAULT NULL,
  `obs_ped` varchar(45) DEFAULT NULL,
  `Total_ped` float(6,2) DEFAULT NULL,
  PRIMARY KEY (`id_ped`),
  KEY `id_Mesa_idx` (`id_Mesa`),
  CONSTRAINT `id_Mesa` FOREIGN KEY (`id_Mesa`) REFERENCES `Mesa` (`id_Mesa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pedidos`
--

LOCK TABLES `Pedidos` WRITE;
/*!40000 ALTER TABLE `Pedidos` DISABLE KEYS */;
INSERT INTO `Pedidos` VALUES (1,'','',NULL,1,'',0.00),(2,'','',NULL,2,'',0.00),(3,'','',NULL,3,'',9.00),(4,'20:55:36','17/02/2015',NULL,4,'nada',6.00),(5,'','',NULL,5,'',30.00),(6,NULL,NULL,NULL,6,NULL,0.00),(7,'20:18:12','04/06/2014',NULL,7,'nenhum copo',24.00),(8,NULL,NULL,NULL,8,NULL,0.00),(9,NULL,NULL,NULL,9,NULL,0.00),(10,NULL,NULL,NULL,10,NULL,0.00),(11,NULL,NULL,NULL,11,NULL,0.00),(12,'18:55:17','20/06/2014',NULL,12,'2 copos',3.00),(13,'21:07:51','10/06/2014',NULL,13,'copo 1 pessoa',15.00),(14,NULL,NULL,NULL,14,NULL,0.00),(15,NULL,NULL,NULL,15,NULL,0.00),(16,NULL,NULL,NULL,16,NULL,0.00),(17,NULL,NULL,NULL,17,NULL,0.00),(18,NULL,NULL,NULL,18,NULL,0.00),(19,NULL,NULL,NULL,19,NULL,0.00),(20,NULL,NULL,NULL,20,NULL,0.00),(21,NULL,NULL,NULL,21,NULL,0.00),(22,NULL,NULL,NULL,22,NULL,0.00),(23,NULL,NULL,NULL,23,NULL,0.00),(24,NULL,NULL,NULL,24,NULL,0.00),(25,NULL,NULL,NULL,25,NULL,0.00),(26,NULL,NULL,NULL,26,NULL,0.00),(27,NULL,NULL,NULL,27,NULL,0.00),(28,NULL,NULL,NULL,28,NULL,0.00),(29,NULL,NULL,NULL,29,NULL,0.00),(30,NULL,NULL,NULL,30,NULL,0.00);
/*!40000 ALTER TABLE `Pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Produto`
--

DROP TABLE IF EXISTS `Produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Produto` (
  `id_prod` int(11) NOT NULL AUTO_INCREMENT,
  `desc_prod` varchar(45) DEFAULT NULL,
  `cat_prod` varchar(45) DEFAULT NULL,
  `preco_prod` float(8,2) DEFAULT NULL,
  `foto_prod` longtext,
  `nomefoto_prod` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_prod`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Produto`
--

LOCK TABLES `Produto` WRITE;
/*!40000 ALTER TABLE `Produto` DISABLE KEYS */;
INSERT INTO `Produto` VALUES (13,'COCA COLA LT 350 ML','Bebidas',3.00,'/var/www/SGMPRWeb/imagens/CocaCola.jpg','CocaCola.jpg'),(16,'PORÇÂO DE BATATA FRITA ','Comidas',12.00,'/home/victor/Imagens/download.jpg','download.jpg'),(17,'SUKITA 350 ML LATA ','Bebidas',3.00,'/var/www/SGMPRWeb/imagens/402.jpg','402.jpg'),(18,'COCA COLA 2 LT','Bebidas',6.00,'/var/www/SGMPRWeb/imagens/coca-cola-2-litros.jpg','coca-cola-2-litros.jpg'),(19,'Bolo napolitano','Sobremesas',12.00,'/var/www/SGMPRWeb/imagens/sobremesas-requintadas-torta.jpg','sobremesas-requintadas-torta.jpg'),(20,'BOLO DE MORANGO ','Sobremesas',20.00,'/var/www/SGMPRWeb/imagens/Panfleteria_NettySobremesasFinas_foto09.jpg','Panfleteria_NettySobremesasFinas_foto09.jpg'),(21,'MISTO QUENTE FRITO','Comidas',20.00,'/var/www/SGMPRWeb/imagens/canudossalgadinhos.jpg','canudossalgadinhos.jpg'),(22,'SANDUICHE DE PERNIL','Comidas',22.00,'/var/www/SGMPRWeb/imagens/receita-sanduiche-de-pernil.jpg','receita-sanduiche-de-pernil.jpg'),(23,'TORTA DE MORANGO E BRIGADEIRO','Sobremesas',9.00,'/var/www/SGMPRWeb/imagens/morangos.jpg','morangos.jpg'),(24,'PAVE DE SORVETTE ','Sobremesas',9.90,'/var/www/SGMPRWeb/imagens/78da0b93-fdc6-45ae-947f-b206cd764136.jpg','78da0b93-fdc6-45ae-947f-b206cd764136.jpg'),(25,'MISTO QUENTE ','Comidas',4.30,'/var/www/SGMPRWeb/imagens/Ponto-Chic-450-x-338.jpg','Ponto-Chic-450-x-338.jpg'),(26,'PIZZA DE CALABRESA','Comidas',12.50,'/var/www/SGMPRWeb/imagens/123.jpg','123.jpg'),(27,'PRODUTO ','Comidas',0.12,'/home/victor/Imagens/van/P9160100.JPG','P9160100.JPG');
/*!40000 ALTER TABLE `Produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'DB_SGRPM'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-23 23:49:44

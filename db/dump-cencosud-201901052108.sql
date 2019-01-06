-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: localhost    Database: cencosud
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.18.04.1

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
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consulta` (
  `id_consulta` int(11) NOT NULL AUTO_INCREMENT,
  `cant_pacientes` int(11) NOT NULL,
  `nombre_especialista` varchar(300) DEFAULT NULL,
  `id_estado_consulta` int(11) NOT NULL,
  `id_tipo_consulta` int(11) NOT NULL,
  `id_hospital` int(11) NOT NULL,
  `id_paciente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_consulta`),
  KEY `consulta_estado_consulta_FK` (`id_estado_consulta`),
  KEY `consulta_tipo_consulta_FK` (`id_tipo_consulta`),
  KEY `consulta_hospital_FK` (`id_hospital`),
  KEY `consulta_paciente_FK` (`id_paciente`),
  CONSTRAINT `consulta_estado_consulta_FK` FOREIGN KEY (`id_estado_consulta`) REFERENCES `estado_consulta` (`id_estado_consulta`),
  CONSTRAINT `consulta_hospital_FK` FOREIGN KEY (`id_hospital`) REFERENCES `hospital` (`id_hospital`),
  CONSTRAINT `consulta_paciente_FK` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`),
  CONSTRAINT `consulta_tipo_consulta_FK` FOREIGN KEY (`id_tipo_consulta`) REFERENCES `tipo_consulta` (`id_tipo_consulta`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
INSERT INTO `consulta` VALUES (1,0,'tempor incididunt u',2,2,1,NULL),(2,0,'ur. Exce',2,3,2,NULL),(3,0,'in cul',2,1,2,NULL),(4,0,' in volup',2,1,1,NULL),(5,0,'aecat cupidat',2,2,2,NULL),(6,0,'quat.',2,1,2,NULL),(7,0,'Excepteur sint ',2,2,1,NULL),(8,0,'a',2,2,2,NULL),(9,0,'et, consec',2,1,1,NULL),(10,0,'t ',2,1,1,NULL);
/*!40000 ALTER TABLE `consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_consulta`
--

DROP TABLE IF EXISTS `estado_consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_consulta` (
  `id_estado_consulta` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(100) NOT NULL,
  PRIMARY KEY (`id_estado_consulta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_consulta`
--

LOCK TABLES `estado_consulta` WRITE;
/*!40000 ALTER TABLE `estado_consulta` DISABLE KEYS */;
INSERT INTO `estado_consulta` VALUES (1,'Ocupada'),(2,'En espera de atención al paciente');
/*!40000 ALTER TABLE `estado_consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospital` (
  `id_hospital` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_hospital`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES (1,'Hospital Central'),(2,'Clinica');
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `id_paciente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(300) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `nro_historia_clinica` int(11) DEFAULT NULL,
  `relacion_peso_estatura` int(11) DEFAULT NULL,
  `anios_fumando` int(11) DEFAULT NULL,
  `id_hospital` int(11) NOT NULL,
  `dieta` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id_paciente`),
  UNIQUE KEY `paciente_UN` (`nro_historia_clinica`),
  KEY `paciente_hospital_FK` (`id_hospital`),
  CONSTRAINT `paciente_hospital_FK` FOREIGN KEY (`id_hospital`) REFERENCES `hospital` (`id_hospital`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES (1,'aboris ni','2001-01-30',1,NULL,0,2,0),(2,'llamco ','1998-06-02',2,NULL,0,2,0),(3,'qui of','1951-10-17',3,NULL,NULL,1,0),(4,'g el','1999-11-26',4,NULL,0,1,0),(5,'at. Duis aute irur','2015-08-14',5,2,NULL,1,0),(6,'et, consectetur adip','2003-05-12',6,4,NULL,1,0),(7,'ore et dolore ma','1986-10-20',7,NULL,5,2,0),(8,'ru','2015-01-31',8,2,NULL,2,0),(9,'ed do e','1984-11-07',9,NULL,7,1,0),(10,' ex ea commodo co','1952-05-02',10,NULL,NULL,2,1);
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala_de_espera`
--

DROP TABLE IF EXISTS `sala_de_espera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sala_de_espera` (
  `id_paciente` int(11) NOT NULL,
  `id_consulta` int(11) NOT NULL,
  `llegada` date NOT NULL,
  `pendiente` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_paciente`,`id_consulta`),
  KEY `sala_de_espera_consulta_FK` (`id_consulta`),
  CONSTRAINT `sala_de_espera_consulta_FK` FOREIGN KEY (`id_consulta`) REFERENCES `consulta` (`id_consulta`),
  CONSTRAINT `sala_de_espera_paciente_FK` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala_de_espera`
--

LOCK TABLES `sala_de_espera` WRITE;
/*!40000 ALTER TABLE `sala_de_espera` DISABLE KEYS */;
/*!40000 ALTER TABLE `sala_de_espera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_consulta`
--

DROP TABLE IF EXISTS `tipo_consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_consulta` (
  `id_tipo_consulta` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_consulta` varchar(100) NOT NULL,
  PRIMARY KEY (`id_tipo_consulta`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_consulta`
--

LOCK TABLES `tipo_consulta` WRITE;
/*!40000 ALTER TABLE `tipo_consulta` DISABLE KEYS */;
INSERT INTO `tipo_consulta` VALUES (1,'Pediatría'),(2,'Urgencia'),(3,'Consulta General Integral');
/*!40000 ALTER TABLE `tipo_consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `view_paciente_edad`
--

DROP TABLE IF EXISTS `view_paciente_edad`;
/*!50001 DROP VIEW IF EXISTS `view_paciente_edad`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_paciente_edad` AS SELECT 
 1 AS `id_paciente`,
 1 AS `nombre`,
 1 AS `fecha_nacimiento`,
 1 AS `nro_historia_clinica`,
 1 AS `relacion_peso_estatura`,
 1 AS `anios_fumando`,
 1 AS `dieta`,
 1 AS `id_hospital`,
 1 AS `edad`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `view_paciente_edad_prioridad`
--

DROP TABLE IF EXISTS `view_paciente_edad_prioridad`;
/*!50001 DROP VIEW IF EXISTS `view_paciente_edad_prioridad`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_paciente_edad_prioridad` AS SELECT 
 1 AS `id_paciente`,
 1 AS `nombre`,
 1 AS `fecha_nacimiento`,
 1 AS `nro_historia_clinica`,
 1 AS `relacion_peso_estatura`,
 1 AS `anios_fumando`,
 1 AS `dieta`,
 1 AS `id_hospital`,
 1 AS `edad`,
 1 AS `prioridad`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `view_paciente_edad_prioridad_riesgo`
--

DROP TABLE IF EXISTS `view_paciente_edad_prioridad_riesgo`;
/*!50001 DROP VIEW IF EXISTS `view_paciente_edad_prioridad_riesgo`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_paciente_edad_prioridad_riesgo` AS SELECT 
 1 AS `id_paciente`,
 1 AS `nombre`,
 1 AS `fecha_nacimiento`,
 1 AS `nro_historia_clinica`,
 1 AS `relacion_peso_estatura`,
 1 AS `anios_fumando`,
 1 AS `dieta`,
 1 AS `id_hospital`,
 1 AS `edad`,
 1 AS `prioridad`,
 1 AS `riesgo`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'cencosud'
--

--
-- Final view structure for view `view_paciente_edad`
--

/*!50001 DROP VIEW IF EXISTS `view_paciente_edad`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_paciente_edad` AS select `paciente`.`id_paciente` AS `id_paciente`,`paciente`.`nombre` AS `nombre`,`paciente`.`fecha_nacimiento` AS `fecha_nacimiento`,`paciente`.`nro_historia_clinica` AS `nro_historia_clinica`,`paciente`.`relacion_peso_estatura` AS `relacion_peso_estatura`,`paciente`.`anios_fumando` AS `anios_fumando`,`paciente`.`dieta` AS `dieta`,`paciente`.`id_hospital` AS `id_hospital`,((year(curdate()) - year(`paciente`.`fecha_nacimiento`)) + if((date_format(curdate(),'%m-%d') > date_format(`paciente`.`fecha_nacimiento`,'%m-%d')),0,-(1))) AS `edad` from `paciente` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_paciente_edad_prioridad`
--

/*!50001 DROP VIEW IF EXISTS `view_paciente_edad_prioridad`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_paciente_edad_prioridad` AS select `view_paciente_edad`.`id_paciente` AS `id_paciente`,`view_paciente_edad`.`nombre` AS `nombre`,`view_paciente_edad`.`fecha_nacimiento` AS `fecha_nacimiento`,`view_paciente_edad`.`nro_historia_clinica` AS `nro_historia_clinica`,`view_paciente_edad`.`relacion_peso_estatura` AS `relacion_peso_estatura`,`view_paciente_edad`.`anios_fumando` AS `anios_fumando`,`view_paciente_edad`.`dieta` AS `dieta`,`view_paciente_edad`.`id_hospital` AS `id_hospital`,`view_paciente_edad`.`edad` AS `edad`,(case when (`view_paciente_edad`.`edad` < 6) then (`view_paciente_edad`.`relacion_peso_estatura` + 3) when ((`view_paciente_edad`.`edad` > 5) and (`view_paciente_edad`.`edad` < 13)) then (`view_paciente_edad`.`relacion_peso_estatura` + 2) when ((`view_paciente_edad`.`edad` > 12) and (`view_paciente_edad`.`edad` < 16)) then (`view_paciente_edad`.`relacion_peso_estatura` + 1) when ((`view_paciente_edad`.`edad` > 15) and (`view_paciente_edad`.`edad` < 41)) then if((`view_paciente_edad`.`anios_fumando` is not null),((`view_paciente_edad`.`anios_fumando` / 4) + 2),2) when ((`view_paciente_edad`.`edad` > 59) and (`view_paciente_edad`.`edad` < 101)) then if((`view_paciente_edad`.`dieta` is true),((`view_paciente_edad`.`edad` / 20) + 4),((`view_paciente_edad`.`edad` / 30) + 3)) end) AS `prioridad` from `view_paciente_edad` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_paciente_edad_prioridad_riesgo`
--

/*!50001 DROP VIEW IF EXISTS `view_paciente_edad_prioridad_riesgo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_paciente_edad_prioridad_riesgo` AS select `view_paciente_edad_prioridad`.`id_paciente` AS `id_paciente`,`view_paciente_edad_prioridad`.`nombre` AS `nombre`,`view_paciente_edad_prioridad`.`fecha_nacimiento` AS `fecha_nacimiento`,`view_paciente_edad_prioridad`.`nro_historia_clinica` AS `nro_historia_clinica`,`view_paciente_edad_prioridad`.`relacion_peso_estatura` AS `relacion_peso_estatura`,`view_paciente_edad_prioridad`.`anios_fumando` AS `anios_fumando`,`view_paciente_edad_prioridad`.`dieta` AS `dieta`,`view_paciente_edad_prioridad`.`id_hospital` AS `id_hospital`,`view_paciente_edad_prioridad`.`edad` AS `edad`,`view_paciente_edad_prioridad`.`prioridad` AS `prioridad`,(case when (`view_paciente_edad_prioridad`.`edad` < 41) then ((`view_paciente_edad_prioridad`.`edad` * `view_paciente_edad_prioridad`.`prioridad`) / 100) when (`view_paciente_edad_prioridad`.`edad` > 40) then (((`view_paciente_edad_prioridad`.`edad` * `view_paciente_edad_prioridad`.`prioridad`) / 100) + 5.3) end) AS `riesgo` from `view_paciente_edad_prioridad` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-05 21:08:23

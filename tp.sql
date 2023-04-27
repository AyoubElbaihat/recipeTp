-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: tp
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nameCategory` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Entrees'),(2,'Dishes'),(3,'Desserts'),(4,'Appetizers'),(5,'Sauces');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `recipeName` varchar(455) DEFAULT NULL,
  `description` varchar(455) DEFAULT NULL,
  `imageRecipe` varchar(455) DEFAULT NULL,
  `difficulty` varchar(45) DEFAULT NULL,
  `preparationTime` int DEFAULT NULL,
  `dateCreation` datetime DEFAULT NULL,
  `idCategory` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` VALUES (1,'Salade César','un classique délicieux, croustillant grâce à ses croûtons et gourmande grâce à sa tendre volaille.','https://assets.afcdn.com/recipe/20190704/94705_w1000h664c1cx2336cy1552cxb4672cyb3104.webp','Très facile',20,'2023-04-27 12:51:06',1),(2,'Oeufs mollets','sel, oeuf, oeuf, pain de campagne, beurre demi-sel','https://assets.afcdn.com/recipe/20190219/88020_w640h486c1cx1816cy2983cxb3738cyb5083.webp','Facile',8,'2023-04-27 12:51:06',1),(3,'Falafel','pois chiches, oignon, ail, persil, coriandre, cumin, piment fort, farine, sel, poivre, ail semoule, huile de friture, échalote, oeuf','https://assets.afcdn.com/recipe/20170124/571_w1000h667c1cx1500cy1000.webp','Moyenne',80,'2023-04-22 12:51:06',1),(4,'Gratin Dauphinois','pomme de terre, ail, beurre, lait, muscade, sel, poivre, crème','https://assets.afcdn.com/recipe/20201217/116563_w1000h601c1cx1116cy671cxb2232cyb1342.webp','Facile',85,'2023-04-22 12:51:06',2),(5,'Lasagnes à la bolognaise','lasagnes, oignon jaune, carotte, purée de tomate, eau, feuille de laurier, thym, fromage râpé, sel, poivre, farine, beurre, ail, céleri, boeuf haché, vin rouge, basilic, muscade, Parmesan, lait','https://assets.afcdn.com/recipe/20200408/109520_w1000h1500c1cx1866cy2800cxb3732cyb5600.webp','Moyenne',125,'2023-04-24 12:51:16',2),(6,'Rôti de boeuf','huile d\'olive, poivre, sel, rôti de boeuf, ail, eau, thym','https://assets.afcdn.com/recipe/20180621/79712_w1000h1333c1cx1944cy2592cxb3888cyb5184.webp','Facile',30,'2023-03-22 12:21:06',2),(7,'Pâte à crêpes','farine, sucre, huile, beurre, rhum, oeuf, lait','https://assets.afcdn.com/recipe/20211122/124598_w1000h667c1cx3176cy2107cxt1161cyt477cxb5347cyb3565.webp','Facile',10,'2023-02-22 10:51:06',3),(8,'Mousse au chocolat','chocolat noir, sucre vanillé, oeuf','https://assets.afcdn.com/recipe/20210311/118508_w600h337cx300cy168cxb600cyb337.webp','Très facile',15,'2023-04-23 12:27:06',3),(9,'Cookies maison','beurre tendre, sucre, vanille, farine, chocolat noir, sel, levure chimique, oeuf','https://assets.afcdn.com/recipe/20190529/93153_w1000h778c1cx2220cy1728cxb4441cyb3456.webp','Facile',25,'2023-04-25 12:21:06',3),(10,'Houmous (purée de pois chiches)','pois chiches, ail, feuille de laurier, citron, huile d\'olive, paprika, piment fort, olives noires','https://assets.afcdn.com/recipe/20200122/106817_w2000h1333c1cx2808cy1872cxb5616cyb3744.webp','Facile',180,'2023-04-25 12:31:06',4),(11,'Pavés de saumon au four facile','oignon, huile d\'olive, poivre, sel, saumon, citron, vin blanc, câpres','https://assets.afcdn.com/recipe/20200219/107897_w2000h1281c1cx4218cy1918cxb6000cyb3842.webp','Très facile',30,'2023-03-25 12:22:06',4),(12,'Gougères au fromage','gruyère râpé, farine, beurre, muscade, sel, poivre, oeuf','https://assets.afcdn.com/recipe/20160513/2643_w2000h2999c1cx1908cy2861.webp','Facile',45,'2023-04-27 22:01:06',4),(13,'Vinaigrette simple et rapide','moutarde, vinaigre, huile d\'olive, poivre, sel','https://assets.afcdn.com/recipe/20150831/4292_w2000h3000c1cx1694cy2542.webp','Très facile',2,'2023-04-27 22:01:05',5),(14,'Béchamel','farine, beurre, sel, poivre, lait, muscade','https://assets.afcdn.com/recipe/20130823/62932_w2000h3000c1cx1411cy3438cxb3840cyb5087.webp','Facile',15,'2023-04-27 22:02:02',5),(15,'Mayonnaise maison','1 Jaune d\'oeuf 1 cuil. à café Moutarde forte 20 cl Huile neutre (Tournesol) Sel Poivre 1 Citron pressé (quelques gouttes)','https://assets.afcdn.com/recipe/20220929/135542_w2000h1334c1cx1481cy709cxt436cyt282cxb2120cyb1210.webp','Très facile',10,'2023-04-20 22:01:06',5);
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `image` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'mmm','mmm','test','test','test'),(2,'u2','u2','user2','user22','img'),(3,'test','test','u3','u3','u3');
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

-- Dump completed on 2023-04-27 22:51:41

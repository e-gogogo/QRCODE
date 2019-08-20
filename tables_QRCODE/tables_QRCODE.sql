/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.25 : Database - tables_qrcode
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tables_qrcode` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tables_qrcode`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `Cid` char(4) NOT NULL,
  `Cname` varchar(20) NOT NULL,
  `Cpw` varchar(10) DEFAULT NULL,
  `Cmail` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`Cid`,`Cname`,`Cpw`,`Cmail`) values ('','',NULL,NULL),('1','',NULL,NULL);

/*Table structure for table `institution` */

DROP TABLE IF EXISTS `institution`;

CREATE TABLE `institution` (
  `Iid` char(4) NOT NULL,
  `Iname` varchar(20) NOT NULL,
  PRIMARY KEY (`Iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `institution` */

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `Mid` char(4) NOT NULL,
  `Mname` varchar(20) NOT NULL,
  `Miid` char(4) DEFAULT NULL,
  `Mpw` varchar(10) DEFAULT NULL,
  `Mtel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `manager` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `Pid` char(4) NOT NULL,
  `Pname` varchar(20) NOT NULL,
  `Pprice` decimal(10,2) DEFAULT NULL,
  `Pintro` text,
  PRIMARY KEY (`Pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product` */

/*Table structure for table `sales_list` */

DROP TABLE IF EXISTS `sales_list`;

CREATE TABLE `sales_list` (
  `Sid` char(4) NOT NULL,
  `Smid` char(4) DEFAULT NULL,
  `Scid` char(4) DEFAULT NULL,
  `Spid` char(4) DEFAULT NULL,
  `Snum` int(11) DEFAULT NULL,
  `Ssum` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Sid`),
  KEY `Smid` (`Smid`),
  KEY `Scid` (`Scid`),
  KEY `Spid` (`Spid`),
  CONSTRAINT `sales_list_ibfk_1` FOREIGN KEY (`Smid`) REFERENCES `manager` (`Mid`),
  CONSTRAINT `sales_list_ibfk_2` FOREIGN KEY (`Scid`) REFERENCES `customer` (`Cid`),
  CONSTRAINT `sales_list_ibfk_3` FOREIGN KEY (`Spid`) REFERENCES `product` (`Pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sales_list` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

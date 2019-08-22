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
  `Cid` int(11) NOT NULL AUTO_INCREMENT,
  `Cname` varchar(20) NOT NULL,
  `Cpw` varchar(10) DEFAULT NULL,
  `Cmail` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Cid`),
  UNIQUE KEY `Cname` (`Cname`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`Cid`,`Cname`,`Cpw`,`Cmail`) values (1,'何子拙',NULL,NULL),(2,'李嘉欢',NULL,NULL);

/*Table structure for table `institution` */

DROP TABLE IF EXISTS `institution`;

CREATE TABLE `institution` (
  `Iid` int(11) NOT NULL AUTO_INCREMENT,
  `Iname` varchar(20) NOT NULL,
  PRIMARY KEY (`Iid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `institution` */

insert  into `institution`(`Iid`,`Iname`) values (1,'业务一部'),(2,'业务二部');

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `Mid` int(11) NOT NULL AUTO_INCREMENT,
  `Mname` varchar(20) NOT NULL,
  `Miid` int(11) DEFAULT NULL,
  `Mpw` varchar(10) DEFAULT NULL,
  `Mtel` varchar(20) DEFAULT NULL,
  `Level` int(11) DEFAULT NULL,
  PRIMARY KEY (`Mid`),
  UNIQUE KEY `Mname` (`Mname`),
  KEY `mtoi` (`Miid`),
  CONSTRAINT `mtoi` FOREIGN KEY (`Miid`) REFERENCES `institution` (`Iid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `manager` */

insert  into `manager`(`Mid`,`Mname`,`Miid`,`Mpw`,`Mtel`,`Level`) values (1,'张三',1,NULL,NULL,NULL),(2,'李四',1,NULL,NULL,NULL),(3,'王五',2,NULL,NULL,NULL),(4,'赵六',2,NULL,NULL,NULL);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `Pid` int(11) NOT NULL AUTO_INCREMENT,
  `Pname` varchar(20) NOT NULL,
  `Pprice` decimal(10,2) DEFAULT NULL,
  `Pintro` text,
  PRIMARY KEY (`Pid`),
  UNIQUE KEY `Pname` (`Pname`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`Pid`,`Pname`,`Pprice`,`Pintro`) values (1,'天使之眼','2000.00',NULL),(2,'天使基金','5.00',NULL);

/*Table structure for table `sales_list` */

DROP TABLE IF EXISTS `sales_list`;

CREATE TABLE `sales_list` (
  `Sid` int(4) NOT NULL AUTO_INCREMENT,
  `Smid` int(11) DEFAULT NULL,
  `scid` int(11) DEFAULT NULL,
  `Spid` int(11) DEFAULT NULL,
  `Snum` int(11) DEFAULT NULL,
  `Ssum` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Sid`),
  KEY `Smid` (`Smid`),
  KEY `Spid` (`Spid`),
  KEY `scid` (`scid`),
  CONSTRAINT `sales_list_ibfk_1` FOREIGN KEY (`Smid`) REFERENCES `manager` (`Mid`),
  CONSTRAINT `sales_list_ibfk_2` FOREIGN KEY (`Spid`) REFERENCES `product` (`Pid`),
  CONSTRAINT `sales_list_ibfk_3` FOREIGN KEY (`scid`) REFERENCES `customer` (`Cid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `sales_list` */

insert  into `sales_list`(`Sid`,`Smid`,`scid`,`Spid`,`Snum`,`Ssum`) values (1,2,1,1,1,'2000.00'),(2,1,2,2,100,'500.00');

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `test` */

insert  into `test`(`id`,`money`) values (1,3000),(2,200),(3,1),(4,300),(5,300);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

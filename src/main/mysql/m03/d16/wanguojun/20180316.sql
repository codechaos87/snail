/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.17-log : Database - library
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`library` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `library`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bid` varchar(200) NOT NULL COMMENT '图书编号',
  `bName` varchar(200) DEFAULT NULL COMMENT '图书书名',
  `author` varchar(200) DEFAULT NULL COMMENT '作者姓名',
  `pubComp` varchar(200) DEFAULT NULL COMMENT '出版社',
  `pubDate` date DEFAULT '2018-03-16' COMMENT '出版日期',
  `bCount` int(11) DEFAULT NULL COMMENT '现存数量',
  `price` float(3,2) DEFAULT NULL COMMENT '单价',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

/*Table structure for table `borrow` */

DROP TABLE IF EXISTS `borrow`;

CREATE TABLE `borrow` (
  `rid` varchar(200) NOT NULL COMMENT '读者编号',
  `nif` varchar(200) NOT NULL COMMENT '图书编号',
  `lendDate` date NOT NULL DEFAULT '2018-03-16' COMMENT '借阅日期',
  `willDate` date DEFAULT '2018-03-16' COMMENT '应当归还期',
  `returnDate` date DEFAULT '2018-03-16' COMMENT '实际归还期',
  PRIMARY KEY (`rid`,`nif`,`lendDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `borrow` */

/*Table structure for table `penalty` */

DROP TABLE IF EXISTS `penalty`;

CREATE TABLE `penalty` (
  `rid` varchar(200) NOT NULL COMMENT '读者编号',
  `bid` varchar(200) NOT NULL COMMENT '图书编号',
  `pDate` date NOT NULL DEFAULT '2018-03-16' COMMENT '罚款日期',
  `pType` int(11) DEFAULT NULL COMMENT '罚款类型',
  `amount` float(3,1) DEFAULT NULL COMMENT '罚款金额',
  PRIMARY KEY (`rid`,`bid`,`pDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `penalty` */

/*Table structure for table `reader` */

DROP TABLE IF EXISTS `reader`;

CREATE TABLE `reader` (
  `rid` varchar(200) NOT NULL COMMENT '读者编号',
  `rName` varchar(200) DEFAULT NULL COMMENT '读者姓名',
  `lendNum` int(11) DEFAULT NULL COMMENT '已借书数量',
  `rAddress` varchar(200) DEFAULT NULL COMMENT '联系地址',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reader` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

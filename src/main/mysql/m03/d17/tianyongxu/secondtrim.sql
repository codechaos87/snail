<<<<<<< HEAD
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
  `bid` VARCHAR(20) NOT NULL,
  `bname` VARCHAR(200) NOT NULL,
  `author` VARCHAR(20) DEFAULT NULL,
  `pubcomp` VARCHAR(200) DEFAULT NULL,
  `pubDate` DATE DEFAULT NULL,
  `bcount` INT(11) DEFAULT NULL,
  `price` FLOAT DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

INSERT  INTO `book`(`bid`,`bname`,`author`,`pubcomp`,`pubDate`,`bcount`,`price`) VALUES ('0001','第一本书','我是作者','我是出版社','2017-08-03',10,100),('0002','第二本书','我是作者','我是出版社','2017-08-03',10,100),('0003','第三本书','我是作者','我是出版社','2017-08-03',10,100),('0004','第室本书','我是作者','我是出版社','2017-08-03',10,100),('0005','第五本书','我是作者','我是出版社','2017-08-03',10,100),('0006','红楼梦','曹雪芹','北京大学出版社','1762-10-01',197,50),('0007','西游记','吴承嗯','清华大学出版社','1627-02-02',102,20);

/*Table structure for table `borrow` */

DROP TABLE IF EXISTS `borrow`;

CREATE TABLE `borrow` (
  `rid` VARCHAR(20) NOT NULL,
  `nif` VARCHAR(20) NOT NULL,
  `lenddate` DATETIME NOT NULL,
  `willdate` DATETIME DEFAULT NULL,
  `returndate` DATETIME DEFAULT NULL,
  PRIMARY KEY (`rid`,`nif`,`lenddate`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `borrow` */

INSERT  INTO `borrow`(`rid`,`nif`,`lenddate`,`willdate`,`returndate`) VALUES ('0001','0001','2017-08-12 09:10:48','2017-08-08 00:00:00','2017-08-15 00:00:00'),('0001','0004','2017-08-12 09:11:19','2017-08-18 00:00:00','2017-08-15 00:00:00'),('0002','0002','2017-08-12 09:11:19','2017-08-08 00:00:00','2017-08-20 00:00:00'),('0003','0003','2017-08-12 09:11:19','2017-08-08 00:00:00','2017-08-21 00:00:00'),('0004','0004','2017-08-12 09:11:19','2017-09-22 09:18:01','2017-08-25 00:00:00'),('0005','0001','2017-08-12 09:11:19','2017-08-08 00:00:00','2017-08-16 09:12:16'),('0006','0002','2017-08-12 09:11:19','2018-09-22 09:20:06',NULL),('0007','0006','2017-10-06 17:27:35','2018-10-09 17:27:35',NULL),('0009','0007','2017-09-22 09:13:00','2017-09-30 09:13:07',NULL);

/*Table structure for table `penalty` */

DROP TABLE IF EXISTS `penalty`;

CREATE TABLE `penalty` (
  `rid` VARCHAR(20) NOT NULL,
  `bid` VARCHAR(20) NOT NULL,
  `pdate` DATETIME NOT NULL,
  `ptype` INT(4) DEFAULT '1',
  `amount` FLOAT DEFAULT NULL,
  PRIMARY KEY (`rid`,`bid`,`pdate`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `penalty` */

INSERT  INTO `penalty`(`rid`,`bid`,`pdate`,`ptype`,`amount`) VALUES ('0001','0001','2017-08-01 00:00:00',1,2),('0003','0001','2017-08-08 00:00:00',1,2),('0004','0001','2016-08-08 00:00:00',1,2),('0004','0001','2017-08-08 00:00:00',1,2),('0004','0001','2017-08-09 00:00:00',1,2),('0004','0002','2018-01-01 00:00:00',1,2),('0004','0003','2017-08-08 00:00:00',1,2),('0008','0007','2018-10-06 17:41:26',1,4.6);

/*Table structure for table `reader` */

DROP TABLE IF EXISTS `reader`;

CREATE TABLE `reader` (
  `rid` VARCHAR(20) NOT NULL,
  `rname` VARCHAR(50) NOT NULL,
  `lennum` INT(11) DEFAULT NULL,
  `raddress` VARCHAR(200) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `reader` */

INSERT  INTO `reader`(`rid`,`rname`,`lennum`,`raddress`) VALUES ('0001','吃撑',1,'横须贺'),('0002','加贺老师',1,'横须贺'),('0003','祥鹤太太',5,'横须贺'),('0004','瑞鹤小姨子',5,'横须贺'),('0005','飞龙骑脸',2,'横须贺'),('0006','苍龙',2,NULL),('0007','大凤',5,NULL),('0008','刘冰冰',0,NULL);

/*Table structure for table `vw_manager_01` */

DROP TABLE IF EXISTS `vw_manager_01`;

/*!50001 DROP VIEW IF EXISTS `vw_manager_01` */;
/*!50001 DROP TABLE IF EXISTS `vw_manager_01` */;

/*!50001 CREATE TABLE  `vw_manager_01`(
 `图书名称` varchar(200) ,
 `到期日期` datetime ,
 `读者姓名` varchar(50) 
)*/;

/*View structure for view vw_manager_01 */

/*!50001 DROP TABLE IF EXISTS `vw_manager_01` */;
/*!50001 DROP VIEW IF EXISTS `vw_manager_01` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_manager_01` AS select (select `book`.`bname` from `book` where (`a`.`nif` = `book`.`bid`)) AS `图书名称`,`a`.`willdate` AS `到期日期`,(select `reader`.`rname` from `reader` where (`a`.`rid` = `reader`.`rid`)) AS `读者姓名` from `borrow` `a` where `a`.`returndate` in (select `borrow`.`returndate` from `borrow` where ((to_days(now()) - to_days(`borrow`.`returndate`)) = 1)) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

SELECT * FROM book;
SELECT * FROM reader;
SELECT * FROM penalty;
SELECT * FROM borrow;
#nif在借阅表格里面 和 bid在图书信息表里   两个都为图书编号，这样就可以关联起来。
#先选择所有所有被借的书，然后关联到图书表里的书，最后不取这些！
SELECT b.`bid`,b.`bname`,b.`author`,b.`pubcomp`,b.`price` FROM book b WHERE bid NOT IN(
    SELECT bid FROM penalty WHERE rid IN(
        SELECT rid FROM borrow WHERE nif
    )
);
#先通过罚款清单获得读者的编号  还要通过rid获得读者的信息 +同时获得罚款日期和罚款金额；
  
SELECT  b.bname,
	r.rname,
	p.pdate,
	p.amount 
FROM penalty p 
INNER JOIN book b ON p.bid = b.bid 
INNER JOIN reader r ON p.rid = r.rid WHERE pdate>=(
   SELECT pdate FROM penalty WHERE bid=2
);
#选出地址为空的读者
 SELECT r.`rid`,
        r.`rname`,
        b.`bname`,
        bw.`lenddate`,
        bw.`returndate` 
 FROM borrow bw
 INNER JOIN reader r ON bw.`rid`=r.`rid`
 INNER JOIN book b ON bw.`nif`=b.`bid` 
 WHERE r.`raddress` IS NULL
 ORDER BY  r.`rid`,bw.`lenddate` DESC;
=======
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
  `bid` VARCHAR(20) NOT NULL,
  `bname` VARCHAR(200) NOT NULL,
  `author` VARCHAR(20) DEFAULT NULL,
  `pubcomp` VARCHAR(200) DEFAULT NULL,
  `pubDate` DATE DEFAULT NULL,
  `bcount` INT(11) DEFAULT NULL,
  `price` FLOAT DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `book` */

INSERT  INTO `book`(`bid`,`bname`,`author`,`pubcomp`,`pubDate`,`bcount`,`price`) VALUES ('0001','第一本书','我是作者','我是出版社','2017-08-03',10,100),('0002','第二本书','我是作者','我是出版社','2017-08-03',10,100),('0003','第三本书','我是作者','我是出版社','2017-08-03',10,100),('0004','第室本书','我是作者','我是出版社','2017-08-03',10,100),('0005','第五本书','我是作者','我是出版社','2017-08-03',10,100),('0006','红楼梦','曹雪芹','北京大学出版社','1762-10-01',197,50),('0007','西游记','吴承嗯','清华大学出版社','1627-02-02',102,20);

/*Table structure for table `borrow` */

DROP TABLE IF EXISTS `borrow`;

CREATE TABLE `borrow` (
  `rid` VARCHAR(20) NOT NULL,
  `nif` VARCHAR(20) NOT NULL,
  `lenddate` DATETIME NOT NULL,
  `willdate` DATETIME DEFAULT NULL,
  `returndate` DATETIME DEFAULT NULL,
  PRIMARY KEY (`rid`,`nif`,`lenddate`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `borrow` */

INSERT  INTO `borrow`(`rid`,`nif`,`lenddate`,`willdate`,`returndate`) VALUES ('0001','0001','2017-08-12 09:10:48','2017-08-08 00:00:00','2017-08-15 00:00:00'),('0001','0004','2017-08-12 09:11:19','2017-08-18 00:00:00','2017-08-15 00:00:00'),('0002','0002','2017-08-12 09:11:19','2017-08-08 00:00:00','2017-08-20 00:00:00'),('0003','0003','2017-08-12 09:11:19','2017-08-08 00:00:00','2017-08-21 00:00:00'),('0004','0004','2017-08-12 09:11:19','2017-09-22 09:18:01','2017-08-25 00:00:00'),('0005','0001','2017-08-12 09:11:19','2017-08-08 00:00:00','2017-08-16 09:12:16'),('0006','0002','2017-08-12 09:11:19','2018-09-22 09:20:06',NULL),('0007','0006','2017-10-06 17:27:35','2018-10-09 17:27:35',NULL),('0009','0007','2017-09-22 09:13:00','2017-09-30 09:13:07',NULL);

/*Table structure for table `penalty` */

DROP TABLE IF EXISTS `penalty`;

CREATE TABLE `penalty` (
  `rid` VARCHAR(20) NOT NULL,
  `bid` VARCHAR(20) NOT NULL,
  `pdate` DATETIME NOT NULL,
  `ptype` INT(4) DEFAULT '1',
  `amount` FLOAT DEFAULT NULL,
  PRIMARY KEY (`rid`,`bid`,`pdate`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `penalty` */

INSERT  INTO `penalty`(`rid`,`bid`,`pdate`,`ptype`,`amount`) VALUES ('0001','0001','2017-08-01 00:00:00',1,2),('0003','0001','2017-08-08 00:00:00',1,2),('0004','0001','2016-08-08 00:00:00',1,2),('0004','0001','2017-08-08 00:00:00',1,2),('0004','0001','2017-08-09 00:00:00',1,2),('0004','0002','2018-01-01 00:00:00',1,2),('0004','0003','2017-08-08 00:00:00',1,2),('0008','0007','2018-10-06 17:41:26',1,4.6);

/*Table structure for table `reader` */

DROP TABLE IF EXISTS `reader`;

CREATE TABLE `reader` (
  `rid` VARCHAR(20) NOT NULL,
  `rname` VARCHAR(50) NOT NULL,
  `lennum` INT(11) DEFAULT NULL,
  `raddress` VARCHAR(200) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `reader` */

INSERT  INTO `reader`(`rid`,`rname`,`lennum`,`raddress`) VALUES ('0001','吃撑',1,'横须贺'),('0002','加贺老师',1,'横须贺'),('0003','祥鹤太太',5,'横须贺'),('0004','瑞鹤小姨子',5,'横须贺'),('0005','飞龙骑脸',2,'横须贺'),('0006','苍龙',2,NULL),('0007','大凤',5,NULL),('0008','刘冰冰',0,NULL);

/*Table structure for table `vw_manager_01` */

DROP TABLE IF EXISTS `vw_manager_01`;

/*!50001 DROP VIEW IF EXISTS `vw_manager_01` */;
/*!50001 DROP TABLE IF EXISTS `vw_manager_01` */;

/*!50001 CREATE TABLE  `vw_manager_01`(
 `图书名称` varchar(200) ,
 `到期日期` datetime ,
 `读者姓名` varchar(50) 
)*/;

/*View structure for view vw_manager_01 */

/*!50001 DROP TABLE IF EXISTS `vw_manager_01` */;
/*!50001 DROP VIEW IF EXISTS `vw_manager_01` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_manager_01` AS select (select `book`.`bname` from `book` where (`a`.`nif` = `book`.`bid`)) AS `图书名称`,`a`.`willdate` AS `到期日期`,(select `reader`.`rname` from `reader` where (`a`.`rid` = `reader`.`rid`)) AS `读者姓名` from `borrow` `a` where `a`.`returndate` in (select `borrow`.`returndate` from `borrow` where ((to_days(now()) - to_days(`borrow`.`returndate`)) = 1)) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

SELECT * FROM book;
SELECT * FROM reader;
SELECT * FROM penalty;
SELECT * FROM borrow;
#nif在借阅表格里面 和 bid在图书信息表里   两个都为图书编号，这样就可以关联起来。
#先选择所有所有被借的书，然后关联到图书表里的书，最后不取这些！
SELECT b.`bid`,b.`bname`,b.`author`,b.`pubcomp`,b.`price` FROM book b WHERE bid NOT IN(
    SELECT bid FROM penalty WHERE rid IN(
        SELECT rid FROM borrow WHERE nif
    )
);
#先通过罚款清单获得读者的编号  还要通过rid获得读者的信息 +同时获得罚款日期和罚款金额；
  
SELECT  b.bname,
	r.rname,
	p.pdate,
	p.amount 
FROM penalty p 
INNER JOIN book b ON p.bid = b.bid 
INNER JOIN reader r ON p.rid = r.rid WHERE pdate>=(
   SELECT pdate FROM penalty WHERE bid=2
);
#选出地址为空的读者
 SELECT r.`rid`,
        r.`rname`,
        b.`bname`,
        bw.`lenddate`,
        bw.`returndate` 
 FROM borrow bw
 INNER JOIN reader r ON bw.`rid`=r.`rid`
 INNER JOIN book b ON bw.`nif`=b.`bid` 
 WHERE r.`raddress` IS NULL
 ORDER BY  r.`rid`,bw.`lenddate` DESC;
>>>>>>> refs/remotes/origin/master
 

/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.0.67-community-log : Database - studentmanagement
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`studentmanagement` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `studentmanagement`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(3) NOT NULL auto_increment,
  `username` char(20) NOT NULL,
  `account` char(20) NOT NULL,
  `password` char(20) NOT NULL,
  `avatar` char(50) default NULL,
  PRIMARY KEY  (`account`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`username`,`account`,`password`,`avatar`) values (1,'hyh','hyh','123456',NULL),(2,'zyh','zyh','123456',NULL);

/*Table structure for table `admininfo` */

DROP TABLE IF EXISTS `admininfo`;

CREATE TABLE `admininfo` (
  `account` char(20) NOT NULL,
  `sex` char(5) NOT NULL default '未设置',
  `bloodType` char(3) NOT NULL default '未设置',
  `age` char(3) NOT NULL default '未设置',
  `site` char(50) NOT NULL default '未设置',
  `qq` char(20) NOT NULL default '未设置',
  `constellation` char(10) NOT NULL default '未设置',
  `interest` char(50) NOT NULL default '未设置',
  PRIMARY KEY  (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admininfo` */

insert  into `admininfo`(`account`,`sex`,`bloodType`,`age`,`site`,`qq`,`constellation`,`interest`) values ('hyh','男','O','20','桂林','1564107979','金牛座','学习'),('zyh','男','AB','20','CS','892681347','双鱼','游泳');

/*Table structure for table `courses` */

DROP TABLE IF EXISTS `courses`;

CREATE TABLE `courses` (
  `courseName` char(20) NOT NULL,
  `courseDay` int(2) NOT NULL,
  `courseTime` int(2) NOT NULL,
  `color` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `courses` */

insert  into `courses`(`courseName`,`courseDay`,`courseTime`,`color`) values ('操作系统',2,1,'success'),('组成原理',4,2,'success'),('电子商务',5,3,'success'),('职业素养与规划',1,5,'success'),('马克思原理',7,4,'success'),('高数',2,1,'active');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(3) NOT NULL auto_increment,
  `username` char(20) NOT NULL,
  `account` char(20) NOT NULL,
  `password` char(20) NOT NULL,
  `sclass` char(20) NOT NULL,
  `avatar` char(50) default NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`username`,`account`,`password`,`sclass`,`avatar`) values (1,'zyh','zyh','123','1703',NULL),(2,'hyh','hyh','123','1703',NULL);

/*Table structure for table `studentcourse` */

DROP TABLE IF EXISTS `studentcourse`;

CREATE TABLE `studentcourse` (
  `account` char(20) default NULL,
  `courseName` char(20) default NULL,
  `grades` char(5) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `studentcourse` */

insert  into `studentcourse`(`account`,`courseName`,`grades`) values ('zyh','操作系统','96'),('zyh','组成原理','98'),('zyh','电子商务','90'),('zyh','职业素养与规划','99'),('zyh','马克思原理','99'),('zyh','高数','234');

/*Table structure for table `studentinfo` */

DROP TABLE IF EXISTS `studentinfo`;

CREATE TABLE `studentinfo` (
  `account` char(20) default NULL,
  `sex` char(5) default '未设置',
  `bloodType` char(3) default '未设置',
  `age` char(3) default '未设置',
  `site` char(50) default '未设置',
  `qq` char(20) default '未设置',
  `constellation` char(10) default '未设置',
  `interest` char(50) default '未设置'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `studentinfo` */

insert  into `studentinfo`(`account`,`sex`,`bloodType`,`age`,`site`,`qq`,`constellation`,`interest`) values ('zyh','男','男','20','湘潭','892681347','双鱼座','1234'),('hyh','未设置','未设置','未设置','未设置','未设置','未设置','未设置');

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `id` int(3) NOT NULL auto_increment,
  `username` char(20) NOT NULL,
  `account` char(20) NOT NULL,
  `password` char(20) NOT NULL,
  `tclass` char(20) NOT NULL,
  `avatar` char(50) default NULL,
  PRIMARY KEY  (`account`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`id`,`username`,`account`,`password`,`tclass`,`avatar`) values (3,'hyhs','hyhs','123456','1703',NULL),(1,'lms','lms','123','1703',NULL),(2,'lxq','lxq','123','203',NULL);

/*Table structure for table `teacherinfo` */

DROP TABLE IF EXISTS `teacherinfo`;

CREATE TABLE `teacherinfo` (
  `account` char(20) default NULL,
  `sex` char(5) default '未设置',
  `bloodType` char(3) default '未设置',
  `age` char(3) default '未设置',
  `site` char(50) default '未设置',
  `qq` char(20) default '未设置',
  `constellation` char(10) default '未设置',
  `interest` char(50) default '未设置'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacherinfo` */

insert  into `teacherinfo`(`account`,`sex`,`bloodType`,`age`,`site`,`qq`,`constellation`,`interest`) values ('lms','女','AB','35','未设置','未设置','未设置','未设置'),('lxq','未设置','未设置','未设置','未设置','未设置','未设置','未设置');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

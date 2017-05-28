/*
Navicat MySQL Data Transfer

Source Server         : link
Source Server Version : 50525
Source Host           : 127.0.0.1:3306
Source Database       : newbook

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2016-06-17 14:53:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookId` int(11) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(255) DEFAULT NULL,
  `bookAuthor` varchar(255) DEFAULT NULL,
  `bookPage` int(11) DEFAULT NULL,
  `bookPrice` double DEFAULT NULL,
  PRIMARY KEY (`bookId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('9', '飞鸟集', '泰戈尔', '500', '50');
INSERT INTO `book` VALUES ('10', '诛仙', '某某', '200', '150');
INSERT INTO `book` VALUES ('11', '西游记', '吴承恩', '100', '20');
INSERT INTO `book` VALUES ('12', '红楼梦', '曹雪芹', '100', '40');
INSERT INTO `book` VALUES ('13', '三国演义', '罗贯中', '300', '45');
INSERT INTO `book` VALUES ('15', '盗墓笔记', '南派三叔', '700', '58');

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `carId` int(11) NOT NULL AUTO_INCREMENT,
  `carNumber` int(11) NOT NULL,
  `carBookId` int(11) NOT NULL,
  `carUserId` int(11) NOT NULL,
  PRIMARY KEY (`carId`),
  KEY `carBookId` (`carBookId`),
  KEY `carUserId` (`carUserId`),
  CONSTRAINT `carBookId` FOREIGN KEY (`carBookId`) REFERENCES `book` (`bookId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `carUserId` FOREIGN KEY (`carUserId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of car
-- ----------------------------

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `collectId` int(11) NOT NULL AUTO_INCREMENT,
  `collectBookId` int(11) NOT NULL,
  `collectUserId` int(11) NOT NULL,
  PRIMARY KEY (`collectId`),
  KEY `collectBookId` (`collectBookId`),
  KEY `collectUserId` (`collectUserId`),
  CONSTRAINT `collectBookId` FOREIGN KEY (`collectBookId`) REFERENCES `book` (`bookId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `collectUserId` FOREIGN KEY (`collectUserId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('29', '9', '11');
INSERT INTO `collect` VALUES ('30', '10', '11');

-- ----------------------------
-- Table structure for consignee
-- ----------------------------
DROP TABLE IF EXISTS `consignee`;
CREATE TABLE `consignee` (
  `consigneeId` int(11) NOT NULL AUTO_INCREMENT,
  `consigneeZipcode` int(11) DEFAULT NULL,
  `consigneePhone` varchar(255) DEFAULT NULL,
  `consigneeAddress` varchar(255) DEFAULT NULL,
  `consigneeUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`consigneeId`),
  KEY `consigneeUserId` (`consigneeUserId`),
  CONSTRAINT `consigneeUserId` FOREIGN KEY (`consigneeUserId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of consignee
-- ----------------------------
INSERT INTO `consignee` VALUES ('14', '262100', '17862008253', '滨州学院', '11');
INSERT INTO `consignee` VALUES ('15', '256600', '17862008253', '彭李街道', '11');
INSERT INTO `consignee` VALUES ('17', '221000', '17862008253', '滨州', '11');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `orderTotal` double NOT NULL,
  `orderBook` varchar(255) NOT NULL,
  `orderConsigneeId` int(11) NOT NULL,
  PRIMARY KEY (`orderId`),
  KEY `FKC3DF62E5EFD48560` (`orderConsigneeId`),
  CONSTRAINT `FKC3DF62E5EFD48560` FOREIGN KEY (`orderConsigneeId`) REFERENCES `consignee` (`consigneeId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('19', '150', '诛仙;', '15');
INSERT INTO `orders` VALUES ('23', '200', '诛仙;飞鸟集;', '17');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `userPass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('7', 'wxy', '123456');
INSERT INTO `user` VALUES ('11', 'mmm', '111111');
INSERT INTO `user` VALUES ('17', '珂珂', '123456');
INSERT INTO `user` VALUES ('18', 'hello', '123456');
INSERT INTO `user` VALUES ('19', '张三', '123456');
INSERT INTO `user` VALUES ('20', '李四', '123456');
INSERT INTO `user` VALUES ('23', 'hellomvc', '111111');

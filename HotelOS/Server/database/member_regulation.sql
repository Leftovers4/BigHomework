/*
Navicat MySQL Data Transfer

Source Server         : Hiki
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : hotelos

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2016-11-18 14:19:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for member_regulation
-- ----------------------------
DROP TABLE IF EXISTS `member_regulation`;
CREATE TABLE `member_regulation` (
  `level` int(11) NOT NULL AUTO_INCREMENT,
  `credit` decimal(8,2) NOT NULL,
  `discount` double DEFAULT NULL,
  PRIMARY KEY (`level`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member_regulation
-- ----------------------------

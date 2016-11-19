/*
Navicat MySQL Data Transfer

Source Server         : Hiki
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : hotelos

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2016-11-18 14:19:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for promotion
-- ----------------------------
DROP TABLE IF EXISTS `promotion`;
CREATE TABLE `promotion` (
  `promotion_id` bigint(6) unsigned zerofill NOT NULL,
  `promotion_type` varchar(20) NOT NULL,
  `discount` double DEFAULT NULL,
  `least_rooms` int(10) unsigned DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `threshold` decimal(8,2) DEFAULT NULL,
  `reduction` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`promotion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of promotion
-- ----------------------------

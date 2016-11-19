/*
Navicat MySQL Data Transfer

Source Server         : Hiki
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : hotelos

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2016-11-18 14:19:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` bigint(6) NOT NULL AUTO_INCREMENT,
  `hotel_id` bigint(6) unsigned zerofill NOT NULL,
  `room_type` varchar(20) NOT NULL,
  `total` int(10) unsigned NOT NULL,
  `available` int(10) unsigned NOT NULL,
  `price` decimal(8,2) NOT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------

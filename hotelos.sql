/*
Navicat MySQL Data Transfer

Source Server         : Hiki
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : hotelos

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2016-12-05 16:11:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for credit_record
-- ----------------------------
DROP TABLE IF EXISTS `credit_record`;
CREATE TABLE `credit_record` (
  `record_id` bigint(6) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `current_credit` double(8,2) NOT NULL,
  `changed_credit` double(8,2) NOT NULL,
  `changed_time` datetime NOT NULL,
  `cause` varchar(20) NOT NULL DEFAULT '',
  `order_id` char(20) NOT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of credit_record
-- ----------------------------
INSERT INTO `credit_record` VALUES ('10000', 'leftovers01', '1.00', '0.10', '2016-01-01 11:11:11', 'Recharge', '52200020161111000');

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `hotel_id` int(6) unsigned zerofill NOT NULL,
  `hotel_name` char(60) NOT NULL,
  `star` mediumint(10) unsigned NOT NULL,
  `address` varchar(60) NOT NULL,
  `trading_area` varchar(40) NOT NULL,
  `description` text NOT NULL,
  `service` text NOT NULL,
  PRIMARY KEY (`hotel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel
-- ----------------------------
INSERT INTO `hotel` VALUES ('522000', '榕江大酒店', '5', '广东揭阳', '东山', '坐落于榕江左岸。', '有特殊服务');
INSERT INTO `hotel` VALUES ('522001', '榕江中酒店', '3', '广东潮汕', '东山', '包吃包住', '没有特殊服务');
INSERT INTO `hotel` VALUES ('522002', '榕江大酒店', '5', '广东揭阳', '东山', '包吃包住', '没有特殊服务');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `order_id` varchar(20) NOT NULL,
  `hotel_id` int(6) unsigned zerofill NOT NULL,
  `username` varchar(20) NOT NULL,
  `order_type` varchar(20) NOT NULL,
  `hotel_name` char(60) NOT NULL,
  `room_type` varchar(20) NOT NULL,
  `room_amount` smallint(10) unsigned NOT NULL,
  `room_number` varchar(20) NOT NULL DEFAULT '',
  `person_amount` smallint(10) unsigned NOT NULL,
  `with_children` tinyint(4) NOT NULL,
  `generate_time` datetime NOT NULL,
  `expected_checkin_time` datetime NOT NULL,
  `checkin_time` datetime NOT NULL,
  `expected_leave_time` datetime NOT NULL,
  `leave_time` datetime NOT NULL,
  `last_execute_time` datetime NOT NULL,
  `cancel_time` datetime NOT NULL,
  `original_price` double(8,2) NOT NULL,
  `actual_price` double(8,2) NOT NULL,
  `review_time` datetime NOT NULL,
  `rating` smallint(10) unsigned NOT NULL DEFAULT '0',
  `review` text NOT NULL,
  `ha_time` datetime NOT NULL,
  `ha_result` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('45454148498', '522000', 'Hiki', 'Abnormal', '榕江大酒店', 'Single', '1', '511', '2', '1', '2012-12-12 11:11:11', '2012-12-12 11:11:11', '2012-12-12 11:11:11', '2012-12-12 11:11:11', '2012-12-12 11:11:11', '2012-12-12 11:11:11', '2012-12-12 11:11:11', '100.00', '80.00', '2012-12-12 11:11:11', '1', 'Good', '2012-12-12 11:11:11', 'All');
INSERT INTO `order_info` VALUES ('52200020161111000', '522000', 'leftovers02', 'Abnormal', '榕江大酒店', 'Single', '2', '511', '2', '0', '2016-01-01 11:11:11', '2016-01-01 11:11:11', '2016-01-01 11:11:11', '2016-01-01 11:11:11', '2016-01-01 11:11:11', '2016-01-01 11:11:11', '2016-01-01 11:11:11', '100.00', '80.00', '2016-01-01 11:11:11', '4', '好', '2016-01-01 11:11:11', 'All');

-- ----------------------------
-- Table structure for personnel
-- ----------------------------
DROP TABLE IF EXISTS `personnel`;
CREATE TABLE `personnel` (
  `personnel_id` int(6) unsigned zerofill NOT NULL,
  `password` char(20) NOT NULL,
  `personnel_type` varchar(20) NOT NULL DEFAULT '',
  `name` varchar(20) NOT NULL DEFAULT '',
  `hotel_id` int(6) unsigned zerofill NOT NULL DEFAULT '000000',
  PRIMARY KEY (`personnel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of personnel
-- ----------------------------
INSERT INTO `personnel` VALUES ('100000', 'abc123456', 'HotelWorker', 'leftovers03', '522000');
INSERT INTO `personnel` VALUES ('119119', 'password', 'HotelWorker', '', '000000');
INSERT INTO `personnel` VALUES ('120110', 'password', 'HotelWorker', '', '000000');
INSERT INTO `personnel` VALUES ('120120', 'pass', 'HotelWorker', '', '000000');

-- ----------------------------
-- Table structure for promotion
-- ----------------------------
DROP TABLE IF EXISTS `promotion`;
CREATE TABLE `promotion` (
  `promotion_id` int(6) unsigned zerofill NOT NULL,
  `promotion_type` varchar(20) NOT NULL DEFAULT '',
  `hotel_id` bigint(6) NOT NULL,
  `discount` double NOT NULL DEFAULT '0',
  `least_rooms` smallint(10) unsigned NOT NULL DEFAULT '0',
  `begin_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `enterprise1` varchar(60) NOT NULL DEFAULT '',
  `enterprise2` varchar(60) NOT NULL DEFAULT '',
  `enterprise3` varchar(60) NOT NULL DEFAULT '',
  `enterprise4` varchar(60) NOT NULL DEFAULT '',
  `enterprise5` varchar(60) NOT NULL DEFAULT '',
  `trading_area1` varchar(40) NOT NULL DEFAULT '',
  `tra_discount1` double NOT NULL,
  `trading_area2` varchar(40) NOT NULL DEFAULT '',
  `tra_discount2` double NOT NULL,
  `trading_area3` varchar(40) NOT NULL DEFAULT '',
  `tra_discount3` double NOT NULL,
  `trading_area4` varchar(40) NOT NULL DEFAULT '',
  `tra_discount4` double NOT NULL,
  `trading_area5` varchar(40) NOT NULL DEFAULT '',
  `tra_discount5` double NOT NULL,
  `credit1` double(8,2) NOT NULL,
  `mem_discount1` double NOT NULL,
  `credit2` double(8,2) NOT NULL,
  `mem_discount2` double NOT NULL,
  `credit3` double(8,2) NOT NULL,
  `mem_discount3` double NOT NULL,
  `credit4` double(8,2) NOT NULL,
  `mem_discount4` double NOT NULL,
  `credit5` double(8,2) NOT NULL,
  `mem_discount5` double NOT NULL,
  `credit6` double(8,2) NOT NULL,
  `mem_discount6` double NOT NULL,
  PRIMARY KEY (`promotion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of promotion
-- ----------------------------
INSERT INTO `promotion` VALUES ('999999', 'BirthdayPromotion', '888888', '0.1', '4', '2016-01-01 11:11:11', '2016-01-01 11:11:11', '南京大学', '南京大学', '南京大学', '南京大学', '南京大学', '东山', '0.8', '东山', '0.8', '东山', '0.8', '东山', '0.8', '东山', '0.8', '1000.00', '0.7', '1000.00', '0.7', '1000.00', '0.7', '1000.00', '0.7', '1000.00', '0.7', '1000.00', '0.7');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` bigint(6) NOT NULL AUTO_INCREMENT,
  `hotel_id` int(6) unsigned zerofill NOT NULL,
  `room_type` varchar(20) NOT NULL,
  `total` smallint(10) unsigned NOT NULL,
  `available` smallint(10) unsigned NOT NULL,
  `price` double(8,2) NOT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=121122 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('121121', '522000', 'Single', '12', '11', '100.00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` char(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `gender` tinyint(4) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `member_type` varchar(20) NOT NULL,
  `level` smallint(10) unsigned NOT NULL,
  `birthday` date NOT NULL,
  `enterprise` char(80) NOT NULL DEFAULT '',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('Hiki', '123456', 'GHB', '0', '110', 'NONE', '1', '2016-11-19', '');
INSERT INTO `user` VALUES ('Hikii', '123456', 'GHB', '1', '110', 'NONE', '1', '2016-11-23', '');
INSERT INTO `user` VALUES ('Hikiii', '123456', 'GHB', '1', '110', 'None', '1', '2016-11-26', '');
INSERT INTO `user` VALUES ('leftovers01', 'abc123456', '哦', '1', '11011011010', 'Normal', '5', '2016-01-01', '南京大学');

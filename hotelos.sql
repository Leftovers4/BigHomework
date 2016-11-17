/*
Navicat MySQL Data Transfer

Source Server         : Hiki
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : hotelos

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2016-11-17 15:36:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(60) NOT NULL,
  `trading_area` varchar(40) NOT NULL,
  `discount` double DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for credit_record
-- ----------------------------
DROP TABLE IF EXISTS `credit_record`;
CREATE TABLE `credit_record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `current_credit` decimal(8,2) NOT NULL,
  `changed_credit` decimal(8,2) NOT NULL,
  `changed_time` datetime NOT NULL,
  `cause` int(11) NOT NULL,
  `order_id` char(20) NOT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of credit_record
-- ----------------------------

-- ----------------------------
-- Table structure for enterprise
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `match_id` int(11) NOT NULL AUTO_INCREMENT,
  `hotel_id` bigint(6) unsigned zerofill NOT NULL,
  `enterprise` char(60) NOT NULL,
  PRIMARY KEY (`match_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise
-- ----------------------------

-- ----------------------------
-- Table structure for hotel
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `hotel_id` bigint(6) unsigned zerofill NOT NULL,
  `hotel_name` char(60) NOT NULL,
  `star` int(10) unsigned NOT NULL,
  `address` varchar(60) NOT NULL,
  `trading_area` varchar(40) NOT NULL,
  `description` text,
  `service` text,
  PRIMARY KEY (`hotel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hotel
-- ----------------------------

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

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `order_id` varchar(20) NOT NULL,
  `hotel_id` bigint(6) unsigned zerofill NOT NULL,
  `username` varchar(20) NOT NULL,
  `order_type` tinyint(4) NOT NULL,
  `hotel_name` char(60) NOT NULL,
  `room_type` tinyint(4) NOT NULL,
  `room_amount` int(10) unsigned NOT NULL,
  `room_number` varchar(20) DEFAULT NULL,
  `person_amount` int(10) unsigned NOT NULL,
  `with_children` tinyint(4) NOT NULL,
  `generate_time` datetime NOT NULL,
  `expected_checkin_time` datetime NOT NULL,
  `checkin_time` datetime DEFAULT NULL,
  `expected_leave_time` datetime DEFAULT NULL,
  `actual_leave_time` datetime DEFAULT NULL,
  `last_execute_time` datetime NOT NULL,
  `cancel_time` datetime DEFAULT NULL,
  `original_price` decimal(8,2) NOT NULL,
  `actual_price` decimal(8,2) NOT NULL,
  `review_time` datetime DEFAULT NULL,
  `rating` int(10) unsigned DEFAULT NULL,
  `review` text,
  `hr_time` datetime DEFAULT NULL,
  `hr_type` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------

-- ----------------------------
-- Table structure for personnel
-- ----------------------------
DROP TABLE IF EXISTS `personnel`;
CREATE TABLE `personnel` (
  `personnel_id` bigint(6) unsigned zerofill NOT NULL,
  `password` char(20) NOT NULL,
  `hotel_id` bigint(6) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`personnel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of personnel
-- ----------------------------

-- ----------------------------
-- Table structure for promotion
-- ----------------------------
DROP TABLE IF EXISTS `promotion`;
CREATE TABLE `promotion` (
  `promotion_id` bigint(6) unsigned zerofill NOT NULL,
  `promotion_type` int(11) NOT NULL,
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

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` bigint(6) NOT NULL AUTO_INCREMENT,
  `hotel_id` bigint(6) unsigned zerofill NOT NULL,
  `room_type` tinyint(4) NOT NULL,
  `total` int(10) unsigned NOT NULL,
  `available` int(10) unsigned NOT NULL,
  `price` decimal(8,2) NOT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------

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
  `member_type` tinyint(4) NOT NULL,
  `level` int(10) unsigned NOT NULL,
  `birthday` date DEFAULT NULL,
  `enterprise` char(80) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

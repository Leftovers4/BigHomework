/*
Navicat MySQL Data Transfer

Source Server         : Hiki
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : hotelos

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2016-11-18 14:19:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `order_id` varchar(20) NOT NULL,
  `hotel_id` bigint(6) unsigned zerofill NOT NULL,
  `username` varchar(20) NOT NULL,
  `order_type` varchar(20) NOT NULL,
  `hotel_name` char(60) NOT NULL,
  `room_type` varchar(20) NOT NULL,
  `room_amount` int(10) unsigned NOT NULL,
  `room_number` varchar(20) DEFAULT NULL,
  `person_amount` int(10) unsigned NOT NULL,
  `with_children` tinyint(4) NOT NULL,
  `generate_time` datetime NOT NULL,
  `expected_checkin_time` datetime NOT NULL,
  `checkin_time` datetime DEFAULT NULL,
  `expected_leave_time` datetime DEFAULT NULL,
  `leave_time` datetime DEFAULT NULL,
  `last_execute_time` datetime NOT NULL,
  `cancel_time` datetime DEFAULT NULL,
  `original_price` decimal(8,2) NOT NULL,
  `actual_price` decimal(8,2) NOT NULL,
  `review_time` datetime DEFAULT NULL,
  `rating` int(10) unsigned DEFAULT NULL,
  `review` text,
  `ha_time` datetime DEFAULT NULL,
  `ha_result` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------

/*
Navicat MySQL Data Transfer

Source Server         : Hiki
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : hotelos

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2016-12-10 10:44:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `city` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `trading_area` varchar(20) CHARACTER SET utf8mb4 NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('南京市', '珠江路商圈');
INSERT INTO `address` VALUES ('南京市', '新街口商圈');
INSERT INTO `address` VALUES ('南京市', '江东门商圈');
INSERT INTO `address` VALUES ('南京市', '江北商圈');
INSERT INTO `address` VALUES ('南京市', '夫子庙商圈');
INSERT INTO `address` VALUES ('南京市', '河西商圈');
INSERT INTO `address` VALUES ('南京市', '仙林商圈');
INSERT INTO `address` VALUES ('南京市', '山西路商圈');
INSERT INTO `address` VALUES ('杭州市', '城北商圈');
INSERT INTO `address` VALUES ('杭州市', '吴山商圈');
INSERT INTO `address` VALUES ('杭州市', '武林商圈');
INSERT INTO `address` VALUES ('杭州市', '滨江商圈');
INSERT INTO `address` VALUES ('上海市', '淮海路商圈');
INSERT INTO `address` VALUES ('上海市', '徐家汇商圈');
INSERT INTO `address` VALUES ('上海市', '浦东商圈');
INSERT INTO `address` VALUES ('上海市', '五角场商圈');
INSERT INTO `address` VALUES ('上海市', '南京路商圈');
INSERT INTO `address` VALUES ('广州市', '珠江新城商圈');
INSERT INTO `address` VALUES ('广州市', '东山商圈');
INSERT INTO `address` VALUES ('广州市', '北京路商圈');
INSERT INTO `address` VALUES ('广州市', '小北商圈');
INSERT INTO `address` VALUES ('广州市', '番禺大北路商圈');
INSERT INTO `address` VALUES ('广州市', '天河商圈');
INSERT INTO `address` VALUES ('广州市', '流花商圈');
INSERT INTO `address` VALUES ('广州市', '西关商圈');
INSERT INTO `address` VALUES ('北京市', '望京商圈');
INSERT INTO `address` VALUES ('北京市', '北苑商圈');
INSERT INTO `address` VALUES ('北京市', '回龙观商圈');
INSERT INTO `address` VALUES ('北京市', '天通苑商圈');
INSERT INTO `address` VALUES ('北京市', '朝青商圈');
INSERT INTO `address` VALUES ('北京市', '亦庄商圈');
INSERT INTO `address` VALUES ('北京市', '清河商圈');
INSERT INTO `address` VALUES ('北京市', '亚运村商圈');
INSERT INTO `address` VALUES ('北京市', '黄村北商圈');

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
) ENGINE=InnoDB AUTO_INCREMENT=151512 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of credit_record
-- ----------------------------
INSERT INTO `credit_record` VALUES ('10000', '123456', '1.00', '1.00', '2016-01-01 11:11:11', 'Recharge', '52200020161111000');
INSERT INTO `credit_record` VALUES ('151511', '123456', '2.20', '1.20', '2016-01-02 11:11:11', 'ExecuteOrder', '52200020161111000');

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
INSERT INTO `hotel` VALUES ('156151', '万达酒店', '5', '北京市', '望京商圈', '帝都加成', '你想要的都有');
INSERT INTO `hotel` VALUES ('346436', '全季酒店', '5', '杭州市', '滨江商圈', '江畔', '西湖美景尽收眼底');
INSERT INTO `hotel` VALUES ('511454', '越台酒店', '2', '杭州市', '武林商圈', '在浙江大学附近', '前台大妈服务');
INSERT INTO `hotel` VALUES ('515765', '凯悦酒店', '5', '广州市', '天河商圈', '真正五星级', '只有你想不到的服务');
INSERT INTO `hotel` VALUES ('516515', '君亭酒店', '2', '杭州市', '武林商圈', '位于武林广场', '还行的服务');
INSERT INTO `hotel` VALUES ('522000', '榕江大酒店', '5', '南京市', '新街口商圈', '坐落于榕江左岸', '有特殊服务');
INSERT INTO `hotel` VALUES ('522001', '榕江中酒店', '3', '南京市', '夫子庙商圈', '包吃包住', '没有特殊服务');
INSERT INTO `hotel` VALUES ('522002', '榕江小酒店', '5', '南京市', '新街口商圈', '包吃包住', '没有特殊服务');
INSERT INTO `hotel` VALUES ('522003', '儒家酒店', '1', '上海市', '浦东商圈', '地势可以', '泳池');
INSERT INTO `hotel` VALUES ('522151', '凯乐酒店', '4', '上海市', '南京路商圈', '地势可以', '一流服务');
INSERT INTO `hotel` VALUES ('984512', '英尊酒店', '1', '南京市', '仙林商圈', '南大对面，很方柏霓', '普普通通');

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
  `promotion_type` varchar(20) NOT NULL DEFAULT '',
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
INSERT INTO `order_info` VALUES ('52200020161111000', '522000', 'leftovers02', 'Executed', '榕江大酒店', 'Single', '2', '511', '2', '0', '2016-01-01 11:11:11', '2016-01-01 11:11:11', '2016-01-01 11:11:11', '2016-01-01 11:11:11', '2016-01-01 11:11:11', '2016-01-01 11:11:11', '2016-01-01 11:11:11', '100.00', '80.00', '', '2016-01-03 11:11:11', '4', '好', '2016-01-01 11:11:11', 'All');

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
INSERT INTO `personnel` VALUES ('119119', 'password', 'HotelWorker', '啊', '522151');
INSERT INTO `personnel` VALUES ('120110', 'password', 'WebMarketer', '哦', '000000');
INSERT INTO `personnel` VALUES ('120120', 'pass', 'WebAdministrator', '呃', '000000');

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
INSERT INTO `room` VALUES ('522000', '522000', 'Single', '12', '11', '100.00');

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
INSERT INTO `user` VALUES ('ȹȺȻȼȽȾ', 'ɩɪɫȹȺȻȼȽȾ', '坂', '1', 'ȹȹȸȹȹȸȹȹȸȹȸ', '', '5', '0001-01-01', '南京大学');

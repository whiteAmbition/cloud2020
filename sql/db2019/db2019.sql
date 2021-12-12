/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : db2019

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2021-12-12 14:33:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `serial` varchar(200) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('1', '尚硅谷001');
INSERT INTO `payment` VALUES ('2', '尚硅谷002');
INSERT INTO `payment` VALUES ('3', '尚硅谷003');
INSERT INTO `payment` VALUES ('4', '尚硅谷004');
INSERT INTO `payment` VALUES ('5', null);
INSERT INTO `payment` VALUES ('6', null);
INSERT INTO `payment` VALUES ('7', '777');
INSERT INTO `payment` VALUES ('8', '222');

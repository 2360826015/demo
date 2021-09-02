/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 02/09/2021 15:14:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `org_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `e_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `salary` double(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (3, '2', '2', '1985-07-15', '宋嫣', 36, 2000.00);
INSERT INTO `employee` VALUES (4, '6', '1', '1975-08-21', '范澄', 45, 1500.01);
INSERT INTO `employee` VALUES (5, '4', '1', '1995-07-11', '程恒', 26, 4500.14);
INSERT INTO `employee` VALUES (6, '1', '1', '1985-01-01', '赵志铭', 36, 5000.00);
INSERT INTO `employee` VALUES (7, '5', '1', '1994-06-17', '张麻子', 27, 8000.16);
INSERT INTO `employee` VALUES (8, '2', '1', '1982-04-05', '马邦德', 39, 3200.00);
INSERT INTO `employee` VALUES (9, '1', '2', '2000-11-20', '司空千落', 20, 1800.00);
INSERT INTO `employee` VALUES (10, '6', '2', '2001-02-13', '晓月', 20, 1900.00);
INSERT INTO `employee` VALUES (11, '2', '1', '1985-07-23', '测试输入2', 36, 1700.23);
INSERT INTO `employee` VALUES (12, '3', '1', '1989-12-20', '测试输入1', 31, 9900.99);
INSERT INTO `employee` VALUES (14, '2', '1', '2000-01-01', '测试test', 21, 120000.23);

SET FOREIGN_KEY_CHECKS = 1;

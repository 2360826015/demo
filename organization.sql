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

 Date: 02/09/2021 15:15:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `org_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES (1, '四川供电所', NULL);
INSERT INTO `organization` VALUES (2, '成都供电所', 1);
INSERT INTO `organization` VALUES (3, '高新供电所', 2);
INSERT INTO `organization` VALUES (4, '武侯供电所', 2);
INSERT INTO `organization` VALUES (5, '都江堰供电所', 1);
INSERT INTO `organization` VALUES (6, '雅安供电所', 1);

SET FOREIGN_KEY_CHECKS = 1;

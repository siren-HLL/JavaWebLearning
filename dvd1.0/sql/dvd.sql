/*
 Navicat MySQL Data Transfer

 Source Server         : conn
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : dvd

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 05/05/2021 14:12:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dvd
-- ----------------------------
DROP TABLE IF EXISTS `dvd`;
CREATE TABLE `dvd`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `year` int(0) NULL DEFAULT NULL,
  `binder` int(0) NULL DEFAULT NULL,
  `page` int(0) NULL DEFAULT NULL,
  `slot` int(0) NULL DEFAULT NULL,
  `viewed` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dvd
-- ----------------------------
INSERT INTO `dvd` VALUES (1, '13 Gantry Row', 1998, 1, 1, 1, 'true');
INSERT INTO `dvd` VALUES (2, '2001: A Space Odyssey', 1968, 1, 1, 2, 'false');
INSERT INTO `dvd` VALUES (3, '28 Days Later', 2002, 1, 1, 3, 'true');
INSERT INTO `dvd` VALUES (4, 'A Nightmare on Elm Street', 1984, 1, 2, 1, 'true');
INSERT INTO `dvd` VALUES (5, 'Aelita', 1924, 1, 2, 2, 'true');
INSERT INTO `dvd` VALUES (6, 'Aenigma', 1987, 1, 2, 3, 'true');
INSERT INTO `dvd` VALUES (7, 'Aerobicide', 1986, 1, 3, 1, 'true');
INSERT INTO `dvd` VALUES (8, 'Alligator', 1980, 1, 3, 2, 'true');
INSERT INTO `dvd` VALUES (9, 'Alligator', 1980, 1, 3, 2, 'true');
INSERT INTO `dvd` VALUES (10, 'Basket Case', 1982, 1, 3, 3, 'false');
INSERT INTO `dvd` VALUES (11, 'Black Sabbath', 1963, 2, 1, 1, 'false');
INSERT INTO `dvd` VALUES (12, 'Black Sunday', 1977, 2, 1, 2, 'false');

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80029 (8.0.29)
 Source Host           : localhost:3306
 Source Schema         : student

 Target Server Type    : MySQL
 Target Server Version : 80029 (8.0.29)
 File Encoding         : 65001

 Date: 10/06/2024 23:02:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '班级名称',
  `year` int NULL DEFAULT NULL COMMENT '年份',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '班级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, '平面', 18, '2024-06-10 09:41:44', '2024-06-10 09:41:44');
INSERT INTO `class` VALUES (2, '高复', 18, '2024-06-10 09:41:44', '2024-06-10 09:41:44');

-- ----------------------------
-- Table structure for punishment
-- ----------------------------
DROP TABLE IF EXISTS `punishment`;
CREATE TABLE `punishment`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '处分名',
  `level` int NULL DEFAULT NULL COMMENT '处分等级',
  `sort` int NULL DEFAULT NULL COMMENT '排序字段',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '处分表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of punishment
-- ----------------------------
INSERT INTO `punishment` VALUES (1, '正常', 0, 1, '2024-06-10 09:48:22', '2024-06-10 09:48:22');
INSERT INTO `punishment` VALUES (2, '通报批评', 1, 2, '2024-06-10 09:48:22', '2024-06-10 09:48:22');
INSERT INTO `punishment` VALUES (3, '警告', 2, 3, '2024-06-10 09:48:22', '2024-06-10 09:48:22');
INSERT INTO `punishment` VALUES (4, '严重警告', 3, 4, '2024-06-10 09:48:22', '2024-06-10 09:48:22');
INSERT INTO `punishment` VALUES (5, '记过', 4, 5, '2024-06-10 09:48:22', '2024-06-10 09:48:22');
INSERT INTO `punishment` VALUES (6, '留校察看', 5, 6, '2024-06-10 09:48:22', '2024-06-10 09:48:22');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `student_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '学号',
  `level` int NULL DEFAULT NULL COMMENT '处分等级',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '张三', '男', '10001', 2, '2024-06-08 20:00:05', '2024-06-08 20:00:05');

-- ----------------------------
-- Table structure for student_class
-- ----------------------------
DROP TABLE IF EXISTS `student_class`;
CREATE TABLE `student_class`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `class_id` bigint NULL DEFAULT NULL COMMENT '班级id',
  `student_id` bigint NULL DEFAULT NULL COMMENT '学生id',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生班级关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_class
-- ----------------------------
INSERT INTO `student_class` VALUES (1, 1, 1, '2024-06-10 09:42:25', '2024-06-10 09:42:25');
INSERT INTO `student_class` VALUES (2, 2, 1, '2024-06-10 09:42:25', '2024-06-10 09:42:25');

-- ----------------------------
-- Table structure for student_punishment
-- ----------------------------
DROP TABLE IF EXISTS `student_punishment`;
CREATE TABLE `student_punishment`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `student_id` bigint NULL DEFAULT NULL COMMENT '学生id',
  `punishment_level` bigint NULL DEFAULT NULL COMMENT '处分等级',
  `criticism` int NULL DEFAULT 0 COMMENT '1:表示通报批评',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `year` int NULL DEFAULT NULL COMMENT '当前年份',
  `semester` int NULL DEFAULT NULL COMMENT '学期',
  `punishment_time` datetime NULL DEFAULT NULL COMMENT '处分时间',
  `change` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '变化(up down noChange)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '学生处分关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_punishment
-- ----------------------------
INSERT INTO `student_punishment` VALUES (1, 1, 2, 0, '上课玩手机', 18, 1, '2024-06-09 09:47:09', 'up', '2024-06-09 09:47:09', '2024-06-09 09:47:09');
INSERT INTO `student_punishment` VALUES (2, 1, 3, 0, '上课玩手机', 18, 1, '2024-06-10 09:47:09', 'up', '2024-06-10 09:47:09', '2024-06-10 09:47:09');
INSERT INTO `student_punishment` VALUES (3, 1, 2, 0, '表现良好', 18, 1, '2024-06-10 11:33:09', 'down', '2024-06-10 11:33:09', '2024-06-10 11:33:09');
INSERT INTO `student_punishment` VALUES (4, 1, 2, 1, '跑步不达标', 18, 1, '2024-06-10 11:39:23', 'noChange', '2024-06-10 11:39:23', '2024-06-10 11:39:23');
INSERT INTO `student_punishment` VALUES (5, 1, 3, 1, '跑步不达标', 18, 1, '2024-06-10 11:51:07', 'up', '2024-06-10 11:51:07', '2024-06-10 11:51:07');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `identity` int NULL DEFAULT NULL COMMENT '1:管理员 2:老师 3:学生 4:访客',
  `login_time` datetime NULL DEFAULT NULL COMMENT '登陆时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : api

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 03/06/2019 10:15:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment`  (
  `ATT_ID` bigint(20) NOT NULL,
  `REF_ID` bigint(20) NOT NULL COMMENT '关联id',
  `ATT_NAME` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件原名',
  `ATT_TYPE` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件类型',
  `ATT_SIZE` int(11) NULL DEFAULT NULL COMMENT '附件大小',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '上传时间',
  PRIMARY KEY (`ATT_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '附件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary`  (
  `DICT_ID` bigint(20) NOT NULL,
  `DICT_KEY` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '键',
  `DICT_VALUE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值',
  `DICT_ORDER` int(11) NULL DEFAULT NULL COMMENT '序号',
  `DICT_TYPE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类',
  `DICT_TYPE_EXPLANATION` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类说明',
  PRIMARY KEY (`DICT_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `MENU_ID` bigint(20) NOT NULL,
  `MENU_NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `MENU_URL` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单url',
  `PARENT_ID` bigint(20) NULL DEFAULT NULL COMMENT '上级菜单id',
  `MENU_ORDER` int(5) NULL DEFAULT NULL COMMENT '菜单排序',
  PRIMARY KEY (`MENU_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (45504500143751168, '用户管理', '/ums/user', NULL, 0);
INSERT INTO `menu` VALUES (45504950721052672, 'LEVEL_1', '/ums/level_1', NULL, 0);
INSERT INTO `menu` VALUES (45505110314319872, 'LEVEL_2_1', '', 45504950721052672, 0);
INSERT INTO `menu` VALUES (45505242921435136, 'LEVEL_2_2', '/ums/level_2_2', 45504950721052672, 1);
INSERT INTO `menu` VALUES (45505379114680320, 'LEVEL_3_1', '/ums/level_3_1', 45505110314319872, 0);

-- ----------------------------
-- Table structure for operation_log
-- ----------------------------
DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log`  (
  `LOG_ID` bigint(20) NOT NULL,
  `OPER_USER_ID` bigint(20) NULL DEFAULT NULL COMMENT '操作用户id',
  `OPER_CONTENT` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作内容',
  `OPER_CODE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作编码',
  `OPER_REF_ID` bigint(20) NULL DEFAULT NULL COMMENT '操作关联id',
  `OPER_MENU` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作菜单',
  `OPER_TIME` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '操作时间',
  `OPER_IP` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作ip',
  `OPER_LOCATION` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作地点',
  PRIMARY KEY (`LOG_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `PERMISSION_ID` bigint(20) NOT NULL,
  `PERMISSION_CODE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限编码',
  PRIMARY KEY (`PERMISSION_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (45504310443769856, 'query');
INSERT INTO `permission` VALUES (45504382661296128, 'edit');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `POST_ID` bigint(20) NOT NULL,
  `POST_NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职务名称',
  `POST_CODE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职务编码',
  PRIMARY KEY (`POST_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '职务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (45504004414767104, '首席执行官', 'ceo');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `ROLE_ID` bigint(20) NOT NULL,
  `ROLE_CODE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色编码',
  `ROLE_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (45503473357160448, 'ROLE_ADMIN', '管理员');
INSERT INTO `role` VALUES (46998914871590912, 'ROLE_USER', '普通用户');

-- ----------------------------
-- Table structure for role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_relation`;
CREATE TABLE `role_menu_relation`  (
  `RM_ID` bigint(20) NOT NULL,
  `ROLE_ID` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  `MENU_ID` bigint(20) NULL DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`RM_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu_relation
-- ----------------------------
INSERT INTO `role_menu_relation` VALUES (45505633323057152, 45503473357160448, 45504500143751168);
INSERT INTO `role_menu_relation` VALUES (45505787065270272, 45503473357160448, 45504950721052672);
INSERT INTO `role_menu_relation` VALUES (45505835228463104, 45503473357160448, 45505110314319872);
INSERT INTO `role_menu_relation` VALUES (45505877905506304, 45503473357160448, 45505242921435136);
INSERT INTO `role_menu_relation` VALUES (45505918829330432, 45503473357160448, 45505379114680320);

-- ----------------------------
-- Table structure for role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_relation`;
CREATE TABLE `role_permission_relation`  (
  `RP_ID` bigint(20) NOT NULL,
  `ROLE_ID` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  `PERMISSION_ID` bigint(20) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`RP_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_info
-- ----------------------------
DROP TABLE IF EXISTS `system_info`;
CREATE TABLE `system_info`  (
  `SYSTEM_ID` bigint(20) NOT NULL,
  `SYSTEM_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统名称',
  `SYSTEM_URL` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统url',
  `SYSTEM_ICON` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统图标',
  `SYSTEM_ORDER` int(4) NULL DEFAULT NULL,
  PRIMARY KEY (`SYSTEM_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_info
-- ----------------------------
INSERT INTO `system_info` VALUES (45502535728889856, '用户管理系统', '/ums/index', '/images/avatar/8.jpg', 1);
INSERT INTO `system_info` VALUES (45502535728889857, '用户管理系统2', NULL, NULL, 2);
INSERT INTO `system_info` VALUES (45502535728889858, '用户管理系统3', NULL, NULL, 6);
INSERT INTO `system_info` VALUES (45502535728889859, '用户管理系统4', NULL, NULL, 4);
INSERT INTO `system_info` VALUES (45502535728889860, '用户管理系统5', NULL, NULL, 3);
INSERT INTO `system_info` VALUES (45502535728889861, '用户管理系统6', NULL, NULL, 5);
INSERT INTO `system_info` VALUES (45502535728889862, '用户管理系统7', NULL, NULL, 8);
INSERT INTO `system_info` VALUES (45502535728889863, '用户管理系统8', NULL, NULL, 7);
INSERT INTO `system_info` VALUES (45502535728889864, '用户管理系统9', NULL, NULL, 9);

-- ----------------------------
-- Table structure for unit
-- ----------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit`  (
  `UNIT_ID` bigint(20) NOT NULL,
  `UNIT_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `UNIT_CODE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门编码',
  `PARENT_ID` bigint(20) NULL DEFAULT NULL COMMENT '上级部门id',
  `UNIT_LEVEL` int(2) NULL DEFAULT NULL COMMENT '部门级别',
  PRIMARY KEY (`UNIT_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of unit
-- ----------------------------
INSERT INTO `unit` VALUES (45498549948907520, '总裁办', 'zcb', NULL, 1);
INSERT INTO `unit` VALUES (45501559403970560, '行政中心', 'xzzx', 45498549948907520, 2);
INSERT INTO `unit` VALUES (45501586281070592, '行政人事部', 'xzrsb', 45501559403970560, 3);
INSERT INTO `unit` VALUES (45501808633708544, '人力资源部', 'rlzyb', 45501586281070592, 4);

-- ----------------------------
-- Table structure for unit_system_relation
-- ----------------------------
DROP TABLE IF EXISTS `unit_system_relation`;
CREATE TABLE `unit_system_relation`  (
  `US_ID` bigint(20) NOT NULL,
  `UNIT_ID` bigint(20) NULL DEFAULT NULL COMMENT '部门id',
  `SYSTEM_ID` bigint(20) NULL DEFAULT NULL COMMENT '系统id',
  PRIMARY KEY (`US_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门系统关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of unit_system_relation
-- ----------------------------
INSERT INTO `unit_system_relation` VALUES (45502962616762368, 45501808633708544, 45502535728889856);
INSERT INTO `unit_system_relation` VALUES (45502962616762369, 45501808633708544, 45502535728889857);
INSERT INTO `unit_system_relation` VALUES (45502962616762370, 45501808633708544, 45502535728889858);
INSERT INTO `unit_system_relation` VALUES (45502962616762371, 45501808633708544, 45502535728889859);
INSERT INTO `unit_system_relation` VALUES (45502962616762372, 45501808633708544, 45502535728889860);
INSERT INTO `unit_system_relation` VALUES (45502962616762373, 45501808633708544, 45502535728889861);
INSERT INTO `unit_system_relation` VALUES (45502962616762374, 45501808633708544, 45502535728889862);
INSERT INTO `unit_system_relation` VALUES (45502962616762375, 45501808633708544, 45502535728889863);
INSERT INTO `unit_system_relation` VALUES (45502962616762376, 45501808633708544, 45502535728889864);

-- ----------------------------
-- Table structure for unit_user_relation
-- ----------------------------
DROP TABLE IF EXISTS `unit_user_relation`;
CREATE TABLE `unit_user_relation`  (
  `UU_ID` bigint(20) NULL DEFAULT NULL COMMENT '关系id',
  `UNIT_ID` bigint(20) NULL DEFAULT NULL COMMENT '部门id',
  `USER_ID` bigint(20) NULL DEFAULT NULL COMMENT '用户id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门用户关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of unit_user_relation
-- ----------------------------
INSERT INTO `unit_user_relation` VALUES (45503107953590272, 45501808633708544, 45498185983983616);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `USER_ID` bigint(20) UNSIGNED ZEROFILL NOT NULL,
  `ACCOUNT` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `NICKNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `AVATAR` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `PASSWD` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `EMAIL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `MOBILE_PHONE` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `SALT` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录\"盐\"',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `DEL_FLAG` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标识 0 未删除 1 已删除',
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (00045498185983983616, 'es', 'es', NULL, '$2a$10$rtCY6ROvSU1kjbhsYIkrO.iPSxQ.LrPLIBTknBCF1nnV8/a13.Cia', NULL, NULL, NULL, '2019-05-11 13:53:13', '0');

-- ----------------------------
-- Table structure for user_post_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_post_relation`;
CREATE TABLE `user_post_relation`  (
  `UP_ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `POST_ID` bigint(20) NULL DEFAULT NULL COMMENT '职位id',
  PRIMARY KEY (`UP_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户职位关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_role_relation`;
CREATE TABLE `user_role_relation`  (
  `UR_ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `ROLE_ID` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`UR_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role_relation
-- ----------------------------
INSERT INTO `user_role_relation` VALUES (45503946667589632, 45498185983983616, 45503473357160448);
INSERT INTO `user_role_relation` VALUES (46999097890045952, 45498185983983616, 46998914871590912);

SET FOREIGN_KEY_CHECKS = 1;

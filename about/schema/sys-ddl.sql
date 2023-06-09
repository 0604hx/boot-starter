-- sys_export_log definition

CREATE TABLE `sys_export_log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uid` varchar(100) DEFAULT NULL,
  `uname` varchar(100) DEFAULT NULL,
  `filename` varchar(100) DEFAULT NULL,
  `size` int DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `data_count` int DEFAULT NULL,
  `entity` varchar(100) DEFAULT NULL,
  `summary` varchar(100) DEFAULT NULL,
  `add_date` varchar(100) DEFAULT NULL,
  `query` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


-- sys_import_log definition

CREATE TABLE `sys_import_log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `uid` varchar(100) DEFAULT NULL,
  `uname` varchar(100) DEFAULT NULL,
  `filename` varchar(100) DEFAULT NULL,
  `size` int DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `data_count` int DEFAULT NULL,
  `entity` varchar(100) DEFAULT NULL,
  `summary` varchar(100) DEFAULT NULL,
  `add_date` varchar(100) DEFAULT NULL,
  `insert_count` int DEFAULT NULL,
  `update_count` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);


-- sys_operation definition

CREATE TABLE `sys_operation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cls` varchar(100) DEFAULT NULL COMMENT '对象Class',
  `uuid` varchar(100) DEFAULT NULL COMMENT '对象ID',
  `user` varchar(100) DEFAULT NULL COMMENT '用户信息',
  `ip` varchar(100) DEFAULT NULL,
  `type` int DEFAULT NULL,
  `summary` varchar(100) DEFAULT NULL,
  `addDate` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=15;


-- sys_role definition

CREATE TABLE `sys_role` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `admin` tinyint NOT NULL DEFAULT '0',
  `urls` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
);


-- sys_role_link definition

CREATE TABLE `sys_role_link` (
  `id` varchar(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `dept` varchar(100) DEFAULT NULL,
  `ip` varchar(200) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


-- sys_schedule_log definition

CREATE TABLE `sys_schedule_log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(200) DEFAULT NULL,
  `duration` bigint DEFAULT '0',
  `msg` text,
  `error` tinyint NOT NULL DEFAULT '0',
  `trace` text,
  `runOn` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


-- sys_setting definition

CREATE TABLE `sys_setting` (
  `id` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `defaultContent` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `form` varchar(15) NOT NULL DEFAULT 'TEXT',
  `formValue` varchar(255) DEFAULT NULL,
  `category` varchar(30) DEFAULT NULL,
  `sort` int DEFAULT '0' COMMENT '排序，越小越靠前',
  PRIMARY KEY (`id`)
);
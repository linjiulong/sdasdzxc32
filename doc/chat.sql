/*
SQLyog Enterprise v12.2.6 (64 bit)
MySQL - 5.6.24 : Database - live_chat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`live_chat` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `live_chat`;

/*Table structure for table `chat_group` */

DROP TABLE IF EXISTS `chat_group`;

CREATE TABLE `chat_group` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) DEFAULT NULL COMMENT '群名',
  `data_id` varchar(100) DEFAULT NULL COMMENT '群号',
  `user_id` varchar(100) DEFAULT NULL COMMENT '群主ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `chat_group` */

/*Table structure for table `chat_record` */

DROP TABLE IF EXISTS `chat_record`;

CREATE TABLE `chat_record` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `group_id` int(100) DEFAULT NULL COMMENT '群号ID',
  `user_id` int(100) DEFAULT NULL COMMENT '用户ID',
  `c_time` date DEFAULT NULL COMMENT '发言时间',
  `nick` varchar(100) DEFAULT NULL COMMENT '昵称',
  `content` longtext COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `chat_record` */

/*Table structure for table `sys_config` */

DROP TABLE IF EXISTS `sys_config`;

CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

/*Data for the table `sys_config` */

/*Table structure for table `sys_dept` */

DROP TABLE IF EXISTS `sys_dept`;

CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级部门ID，一级部门为0',
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `del_flag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='部门管理';

/*Data for the table `sys_dept` */

insert  into `sys_dept`(`dept_id`,`parent_id`,`name`,`order_num`,`del_flag`) values 
(1,0,'人人开源集团',0,-1),
(2,1,'长沙分公司',1,-1),
(3,1,'上海分公司',2,-1),
(4,3,'技术部',0,-1),
(5,3,'销售部',1,-1),
(6,0,'effecia',0,-1),
(7,6,'风控部',0,-1),
(8,0,'推广部',0,0),
(9,0,'ttt',0,0);

/*Table structure for table `sys_log` */

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='系统日志';

/*Data for the table `sys_log` */

insert  into `sys_log`(`id`,`username`,`operation`,`method`,`params`,`time`,`ip`,`create_date`) values 
(1,'admin','删除定时任务','com.effecia.modules.job.controller.ScheduleJobController.delete()','[1,2]',424,'0:0:0:0:0:0:0:1','2017-10-03 09:25:41'),
(2,'admin','保存菜单','com.effecia.modules.sys.controller.SysMenuController.save()','{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"群组设置\",\"type\":0,\"orderNum\":0}',36,'0:0:0:0:0:0:0:1','2017-10-03 09:37:31'),
(3,'admin','修改菜单','com.effecia.modules.sys.controller.SysMenuController.update()','{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"群组管理\",\"type\":0,\"orderNum\":0}',217,'0:0:0:0:0:0:0:1','2017-10-03 09:38:04'),
(4,'admin','保存菜单','com.effecia.modules.sys.controller.SysMenuController.save()','{\"parentId\":36,\"parentName\":\"群组管理\",\"name\":\"新建群组\",\"url\":\"#\",\"type\":1,\"orderNum\":0}',55,'0:0:0:0:0:0:0:1','2017-10-03 09:38:53'),
(5,'admin','修改用户','com.effecia.modules.sys.controller.SysUserController.update()','{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@renren.io\",\"mobile\":\"13612345678\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":6,\"deptName\":\"effecia\"}',251,'0:0:0:0:0:0:0:1','2017-10-03 09:39:40'),
(6,'admin','修改用户','com.effecia.modules.sys.controller.SysUserController.update()','{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@suppport.net\",\"mobile\":\"13612345678\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":6,\"deptName\":\"effecia\"}',57,'0:0:0:0:0:0:0:1','2017-10-03 09:39:50'),
(7,'admin','修改用户','com.effecia.modules.sys.controller.SysUserController.update()','{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@suppport.net\",\"mobile\":\"11111111111\",\"status\":1,\"roleIdList\":[],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":6,\"deptName\":\"effecia\"}',64,'0:0:0:0:0:0:0:1','2017-10-03 09:39:58'),
(8,'admin','保存菜单','com.effecia.modules.sys.controller.SysMenuController.save()','{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"会员管理\",\"type\":0,\"orderNum\":0}',59,'0:0:0:0:0:0:0:1','2017-10-03 09:41:36'),
(9,'admin','保存菜单','com.effecia.modules.sys.controller.SysMenuController.save()','{\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"公告管理\",\"url\":\"#\",\"type\":1,\"orderNum\":0}',57,'0:0:0:0:0:0:0:1','2017-10-03 09:44:18'),
(10,'admin','修改菜单','com.effecia.modules.sys.controller.SysMenuController.update()','{\"menuId\":39,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"公告管理\",\"url\":\"#\",\"type\":0,\"orderNum\":0}',58,'0:0:0:0:0:0:0:1','2017-10-03 09:44:25'),
(11,'admin','保存菜单','com.effecia.modules.sys.controller.SysMenuController.save()','{\"parentId\":36,\"parentName\":\"群组管理\",\"name\":\"敏感词过滤\",\"url\":\"#\",\"type\":1,\"orderNum\":0}',62,'0:0:0:0:0:0:0:1','2017-10-03 09:51:23'),
(12,'admin','修改菜单','com.effecia.modules.sys.controller.SysMenuController.update()','{\"menuId\":36,\"parentId\":0,\"parentName\":\"一级菜单\",\"name\":\"群组设置\",\"type\":0,\"orderNum\":0}',52,'0:0:0:0:0:0:0:1','2017-10-03 09:51:45'),
(13,'admin','修改菜单','com.effecia.modules.sys.controller.SysMenuController.update()','{\"menuId\":37,\"parentId\":36,\"parentName\":\"群组设置\",\"name\":\"群组管理\",\"url\":\"#\",\"type\":1,\"orderNum\":0}',36,'0:0:0:0:0:0:0:1','2017-10-03 09:51:53'),
(14,'admin','保存菜单','com.effecia.modules.sys.controller.SysMenuController.save()','{\"parentId\":36,\"parentName\":\"群组设置\",\"name\":\"群级别设置\",\"url\":\"1\",\"type\":1,\"orderNum\":0}',40,'0:0:0:0:0:0:0:1','2017-10-03 09:58:57'),
(15,'admin','保存角色','com.effecia.modules.sys.controller.SysRoleController.save()','{\"roleId\":1,\"roleName\":\"推广部群主管理\",\"deptId\":8,\"deptName\":\"推广部\",\"menuIdList\":[36,37,40,41],\"deptIdList\":[],\"createTime\":\"Oct 3, 2017 11:58:15 AM\"}',134,'127.0.0.1','2017-10-03 11:58:16'),
(16,'admin','修改用户','com.effecia.modules.sys.controller.SysUserController.update()','{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@suppport.net\",\"mobile\":\"11111111111\",\"status\":1,\"roleIdList\":[1],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":8,\"deptName\":\"推广部\"}',110,'127.0.0.1','2017-10-03 11:58:29'),
(17,'admin','保存角色','com.effecia.modules.sys.controller.SysRoleController.save()','{\"roleId\":2,\"roleName\":\"2132\",\"remark\":\"23\",\"deptId\":9,\"deptName\":\"ttt\",\"menuIdList\":[39],\"deptIdList\":[],\"createTime\":\"Oct 3, 2017 4:32:02 PM\"}',85,'127.0.0.1','2017-10-03 16:32:03'),
(18,'admin','修改用户','com.effecia.modules.sys.controller.SysUserController.update()','{\"userId\":1,\"username\":\"admin\",\"salt\":\"YzcmCZNvbXocrsz9dm8e\",\"email\":\"root@suppport.net\",\"mobile\":\"11111111111\",\"status\":1,\"roleIdList\":[1,2],\"createTime\":\"Nov 11, 2016 11:11:11 AM\",\"deptId\":8,\"deptName\":\"推广部\"}',131,'127.0.0.1','2017-10-03 16:32:24'),
(19,'admin','保存用户','com.effecia.modules.sys.controller.SysUserController.save()','{\"userId\":2,\"username\":\"aaa\",\"password\":\"2eb92598497014786056849c8cebb403f615578d88b50874ccd1efbf57b3deb3\",\"salt\":\"hEvia1A2nqJfRhN4FPpi\",\"email\":\"asd@qq.q\",\"mobile\":\"11111111111\",\"status\":1,\"roleIdList\":[2],\"createTime\":\"Oct 3, 2017 4:33:23 PM\",\"deptId\":8,\"deptName\":\"推广部\"}',59,'127.0.0.1','2017-10-03 16:33:24'),
(20,'admin','修改菜单','com.effecia.modules.sys.controller.SysMenuController.update()','{\"menuId\":37,\"parentId\":36,\"parentName\":\"群组设置\",\"name\":\"群组管理\",\"url\":\"modules/chat/group.html\",\"type\":1,\"orderNum\":0}',58,'127.0.0.1','2017-10-04 13:45:31'),
(21,'admin','保存菜单','com.effecia.modules.sys.controller.SysMenuController.save()','{\"parentId\":37,\"parentName\":\"群组管理\",\"name\":\"查询\",\"perms\":\"group:list\",\"type\":2,\"orderNum\":0}',54,'127.0.0.1','2017-10-04 13:46:21'),
(22,'admin','保存菜单','com.effecia.modules.sys.controller.SysMenuController.save()','{\"parentId\":37,\"parentName\":\"群组管理\",\"name\":\"添加\",\"perms\":\"group:group:save\",\"type\":2,\"orderNum\":0}',57,'127.0.0.1','2017-10-04 13:47:50'),
(23,'admin','保存菜单','com.effecia.modules.sys.controller.SysMenuController.save()','{\"parentId\":37,\"parentName\":\"群组管理\",\"name\":\"删除\",\"perms\":\"group:delete\",\"type\":2,\"orderNum\":0}',43,'127.0.0.1','2017-10-04 13:49:03'),
(24,'admin','保存菜单','com.effecia.modules.sys.controller.SysMenuController.save()','{\"parentId\":37,\"parentName\":\"群组管理\",\"name\":\"修改\",\"perms\":\"group:update\",\"type\":2,\"orderNum\":0}',34,'127.0.0.1','2017-10-04 13:49:13'),
(25,'admin','保存菜单','com.effecia.modules.sys.controller.SysMenuController.save()','{\"parentId\":37,\"parentName\":\"群组管理\",\"name\":\"查看\",\"perms\":\"group:update\",\"type\":2,\"orderNum\":0}',61,'127.0.0.1','2017-10-04 13:50:20'),
(26,'admin','删除菜单','com.effecia.modules.sys.controller.SysMenuController.delete()','30',0,'127.0.0.1','2017-10-04 15:22:45'),
(27,'admin','删除菜单','com.effecia.modules.sys.controller.SysMenuController.delete()','30',0,'127.0.0.1','2017-10-04 15:22:49'),
(28,'admin','修改密码','com.effecia.modules.sys.controller.SysUserController.password()','\"admin\"',74,'127.0.0.1','2017-10-04 15:24:16');

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`menu_id`,`parent_id`,`name`,`url`,`perms`,`type`,`icon`,`order_num`) values 
(1,0,'系统管理',NULL,NULL,0,'fa fa-cog',0),
(2,1,'管理员管理','modules/sys/user.html',NULL,1,'fa fa-user',1),
(3,1,'角色管理','modules/sys/role.html',NULL,1,'fa fa-user-secret',2),
(4,1,'菜单管理','modules/sys/menu.html',NULL,1,'fa fa-th-list',3),
(5,1,'SQL监控','druid/sql.html',NULL,1,'fa fa-bug',4),
(15,2,'查看',NULL,'sys:user:list,sys:user:info',2,NULL,0),
(16,2,'新增',NULL,'sys:user:save,sys:role:select',2,NULL,0),
(17,2,'修改',NULL,'sys:user:update,sys:role:select',2,NULL,0),
(18,2,'删除',NULL,'sys:user:delete',2,NULL,0),
(19,3,'查看',NULL,'sys:role:list,sys:role:info',2,NULL,0),
(20,3,'新增',NULL,'sys:role:save,sys:menu:perms',2,NULL,0),
(21,3,'修改',NULL,'sys:role:update,sys:menu:perms',2,NULL,0),
(22,3,'删除',NULL,'sys:role:delete',2,NULL,0),
(23,4,'查看',NULL,'sys:menu:list,sys:menu:info',2,NULL,0),
(24,4,'新增',NULL,'sys:menu:save,sys:menu:select',2,NULL,0),
(25,4,'修改',NULL,'sys:menu:update,sys:menu:select',2,NULL,0),
(26,4,'删除',NULL,'sys:menu:delete',2,NULL,0),
(27,1,'参数管理','modules/sys/config.html','sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete',1,'fa fa-sun-o',6),
(28,1,'代码生成器','modules/gen/generator.html','sys:generator:list,sys:generator:code',1,'fa fa-rocket',8),
(29,1,'系统日志','modules/sys/log.html','sys:log:list',1,'fa fa-file-text-o',7),
(31,1,'部门管理','modules/sys/dept.html',NULL,1,'fa fa-file-code-o',1),
(32,31,'查看',NULL,'sys:dept:list,sys:dept:info',2,NULL,0),
(33,31,'新增',NULL,'sys:dept:save,sys:dept:select',2,NULL,0),
(34,31,'修改',NULL,'sys:dept:update,sys:dept:select',2,NULL,0),
(35,31,'删除',NULL,'sys:dept:delete',2,NULL,0),
(36,0,'群组设置',NULL,NULL,0,NULL,0),
(37,36,'群组管理','modules/chat/group.html',NULL,1,NULL,0),
(38,0,'会员管理',NULL,NULL,0,NULL,0),
(39,0,'公告管理','#',NULL,0,NULL,0),
(40,36,'敏感词过滤','#',NULL,1,NULL,0),
(41,36,'群级别设置','1',NULL,1,NULL,0),
(42,37,'查询',NULL,'group:list,group:info',2,NULL,0),
(43,37,'添加',NULL,'group:save',2,NULL,0),
(44,37,'删除',NULL,'group:delete,group:info',2,NULL,0),
(45,37,'修改',NULL,'group:update,group:info',2,NULL,0),
(46,37,'查看',NULL,'group:update',2,NULL,0);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色';

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_name`,`remark`,`dept_id`,`create_time`) values 
(1,'推广部群主管理',NULL,8,'2017-10-03 11:58:16'),
(2,'2132','23',9,'2017-10-03 16:32:03');

/*Table structure for table `sys_role_dept` */

DROP TABLE IF EXISTS `sys_role_dept`;

CREATE TABLE `sys_role_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与部门对应关系';

/*Data for the table `sys_role_dept` */

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`) values 
(1,1,36),
(2,1,37),
(3,1,40),
(4,1,41),
(5,2,39);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户';

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`username`,`password`,`salt`,`email`,`mobile`,`status`,`dept_id`,`create_time`) values 
(1,'admin','b7f8369a49830b06076e7f05b8d30d63788383b0ee0f0ae4f50da54a77cbb404','YzcmCZNvbXocrsz9dm8e','root@suppport.net','11111111111',1,8,'2016-11-11 11:11:11'),
(2,'aaa','2eb92598497014786056849c8cebb403f615578d88b50874ccd1efbf57b3deb3','hEvia1A2nqJfRhN4FPpi','asd@qq.q','11111111111',1,8,'2017-10-03 16:33:24');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`user_id`,`role_id`) values 
(2,1,1),
(3,1,2),
(4,2,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

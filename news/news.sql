/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : news

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2019-11-24 14:19:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(20) NOT NULL,
  `adminPassword` varchar(20) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin123', '18861173665', '2019-11-23 13:23:58');
INSERT INTO `admin` VALUES ('2', 'geng', '123', '11111111111', '2019-11-23 18:49:31');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `articleId` varchar(50) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `time` timestamp NULL DEFAULT NULL,
  `userId` varchar(50) NOT NULL,
  `classId` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  `imgs` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('4', '22fead5faf4b4a2ebadc2a84bee773a9', '会计师大后方扣税的', '网络110报警服务\n北京互联网违法Conveying meaning to assistive technologies\n为按钮添加不同的颜色只是一种视觉上的信息表达方式，但是，对于使用辅助技术 -- 例如屏幕阅读器 -- 的用户来说，颜色是不可见的。建议，确保通过颜色表达的信息或者通过内容自身表达出来（按钮上的文字），或者通过其他方式 -- 例如通过 .sr-only 类隐藏的额外文本 -- 表达出来。和不良信息举报中心\n中国互联网举报中心家长监护版权申诉', '2019-11-05 14:04:34', '6f5d888d2s123', '4', '1', '2-50-33.png::Snipaste_2019-11-05_12-51-04.png::');
INSERT INTO `article` VALUES ('8', '6cf700628ad447f1862026125de36568', '修改哈哈哈', 'Bootstrap 假定所有的图标字体文件全部位于 ../fonts/ 目录内，相对于预编译版 CSS 文件的目录。如果你修改了图标字体文件的位置，那么，你需要通过下面列出的任何一种方式来更新 CSS 文件：在 Less 源码文件中修改 @icon-font-path 和/或 @icon-font-name 变量。利用 Less 编译器提供的 相对 URL 地址选项。修改预编译 CSS 文件中的 url() 地址。根据你自身的情况选择一种方式即可。', '2019-11-08 13:32:27', 'be024fcdc9fe49a68bed3df5e763a48b', '4', '1', 'qinm.png::');
INSERT INTO `article` VALUES ('13', 'bf8845fb00e8483b82722efae0d1d629', 'java', '网站翻译_网页翻译_在线翻译网站\n当前位置:翻译首页 > 网站翻译语言:全部 繁体 英语...本功能适合实时翻译网站、网页,请输入您想翻译的网站...\ntran.httpcn.com/FanyiWeb/  - 百度快照\n英文翻译_在线翻译_汉译英_英译汉_fanyi_英文在线翻译_海词翻译\n把海词翻译 设为主页 | 添加到桌面 海词在线翻译提供免费英文在线翻译,英文翻译,汉译英,英译汉,fanyi,中文翻译、专业英语翻译学习指导,英文在线翻译。...\nhttps://fanyi.dict.cn/  - 百度快照 - 142条评价\n英汉翻译|汉英翻译|英日翻译|日英翻译_可可英语\n首页>翻译 请输入您要翻译的内容 支持中英、英中、中日、日英在线互译 支持网页翻译,在输入框输入网页地址即可 提供一键清空、复制功能、支持双语对照查看...\nfy.kekenet.com/  - 百度快照 - 评价', '2019-11-16 15:20:23', '6f5d888d2s123', '4', '1', 'Snipaste_2019-11-05_12-51-04.png::');
INSERT INTO `article` VALUES ('14', 'e6d8f0ce99a8493eaf4c890322595cfb', '测试分页', '测试分页测试分页测试分页测试分页测试分页测试分页123', '2019-11-17 14:22:43', 'f43c95efa1ed479f944dd7bd10a9679c', '6', '1', 'Snipaste_2019-11-17_14-22-17.png::');
INSERT INTO `article` VALUES ('15', '359b5b66de0141d09586b9272588e926', '测试分页002', '测试分页测试分页测试分页测试分页测试分页测试分页', '2019-11-17 14:22:52', 'f43c95efa1ed479f944dd7bd10a9679c', '6', '1', 'Snipaste_2019-11-17_14-21-47.png::');
INSERT INTO `article` VALUES ('16', 'd707d48ccfc84cf9a2f288374564cf53', '测试今日', '都是十分士大夫撒士大夫士大夫', '2019-11-23 11:59:36', '6f5d888d2s123', '7', '1', 'Snipaste_2019-11-17_14-21-47.png::');
INSERT INTO `article` VALUES ('18', 'eb0ddccd47c54cbbb4348da29f81008a', 'cce风格豆腐干', '梵蒂冈地方官', '2019-11-23 12:43:03', '6f5d888d2s123', '4', '1', 'Snipaste_2019-11-23_12-42-31.png::');

-- ----------------------------
-- Table structure for classify
-- ----------------------------
DROP TABLE IF EXISTS `classify`;
CREATE TABLE `classify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classify
-- ----------------------------
INSERT INTO `classify` VALUES ('1', '军事');
INSERT INTO `classify` VALUES ('3', '科技');
INSERT INTO `classify` VALUES ('4', '教育');
INSERT INTO `classify` VALUES ('6', '其他');
INSERT INTO `classify` VALUES ('7', '娱乐');

-- ----------------------------
-- Table structure for loginfo
-- ----------------------------
DROP TABLE IF EXISTS `loginfo`;
CREATE TABLE `loginfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `logId` varchar(50) NOT NULL,
  `descr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `logUrl` varchar(255) DEFAULT NULL,
  `logParam` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `logClassName` varchar(255) DEFAULT NULL,
  `logTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `userName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loginfo
-- ----------------------------
INSERT INTO `loginfo` VALUES ('37', 'd9713cdd1fd143f589a27967b74ecf3f', '删除分类', '/admin/deleteClassify', '[5]', 'com.java.news.controller.AdminController.deleteClassify()', '2019-11-16 15:04:17', '127.0.0.1');
INSERT INTO `loginfo` VALUES ('38', '4e8b0a39c3ef400ea43f4a199847538e', '删除分类', '/admin/deleteClassify', '[2]', 'com.java.news.controller.AdminController.deleteClassify()', '2019-11-16 15:05:01', '127.0.0.1');
INSERT INTO `loginfo` VALUES ('39', '898a33c124ac4a72b1e6895d89f6d9d1', '添加分类', '/admin/addClassify', '[\"军事\"]', 'com.java.news.controller.AdminController.addClassify()', '2019-11-16 15:18:15', '127.0.0.1');
INSERT INTO `loginfo` VALUES ('40', '877786fc3db94465b6ce910eefb03053', '添加分类', '/admin/addClassify', '[\"娱乐\"]', 'com.java.news.controller.AdminController.addClassify()', '2019-11-16 15:18:43', '127.0.0.1');
INSERT INTO `loginfo` VALUES ('41', '70944da126d5491ca7e67849370e5861', '添加分类', '/admin/addClassify', '[\"娱乐\"]', 'com.java.news.controller.AdminController.addClassify()', '2019-11-16 15:18:52', '127.0.0.1');
INSERT INTO `loginfo` VALUES ('43', '6d975013457d4e1889783b9aeba834ba', '删除用户', '/admin/batchDelete', '[\"9841935ea62843d0984486823384c56f\"]', 'com.java.news.controller.AdminController.batch()', '2019-11-17 12:50:47', '127.0.0.1');
INSERT INTO `loginfo` VALUES ('44', '3f60f1e05b1440a4a80ba83eef87cff7', '新闻通过审核', '/admin/setPass', '[\"bf8845fb00e8483b82722efae0d1d629\"]', 'com.java.news.controller.AdminController.setArticlePass()', '2019-11-17 14:05:54', '127.0.0.1');
INSERT INTO `loginfo` VALUES ('45', '64303dc9dff84f2196594a6e37cf8c96', '新闻通过审核', '/admin/setPass', '[\"e6d8f0ce99a8493eaf4c890322595cfb\"]', 'com.java.news.controller.AdminController.setArticlePass()', '2019-11-17 14:23:05', '127.0.0.1');
INSERT INTO `loginfo` VALUES ('46', '18ce4ef60038409ea3c32803a2e6f5bf', '新闻通过审核', '/admin/setPass', '[\"359b5b66de0141d09586b9272588e926\"]', 'com.java.news.controller.AdminController.setArticlePass()', '2019-11-17 14:23:20', '127.0.0.1');
INSERT INTO `loginfo` VALUES ('47', 'ce09ab113e354ca6979c732608da03da', '修改(审核)新闻', '/admin/updateArticle', '[\"e6d8f0ce99a8493eaf4c890322595cfb\",\"测试分页\",\"测试分页测试分页测试分页测试分页测试分页测试分页123\"]', 'com.java.news.controller.AdminController.updateArticle()', '2019-11-17 14:25:13', '127.0.0.1');
INSERT INTO `loginfo` VALUES ('48', 'f28b7bec626248c3a44b27804d1b0154', '新闻通过审核', '/admin/setPass', '[\"d707d48ccfc84cf9a2f288374564cf53\"]', 'com.java.news.controller.AdminController.setArticlePass()', '2019-11-23 12:01:27', '127.0.0.1');
INSERT INTO `loginfo` VALUES ('49', '3bf5da251a894aa7b6351e42fde86a20', '新闻通过审核', '/admin/setPass', '[\"44378aa4f84f406c8aadd803128564e7\"]', 'com.java.news.controller.AdminController.setArticlePass()', '2019-11-23 12:20:39', '127.0.0.1');
INSERT INTO `loginfo` VALUES ('50', 'b637f5ec5f10433d938faecd79031626', '删除新闻', '/admin/batchDeleteArticle', '[\"44378aa4f84f406c8aadd803128564e7,\"]', 'com.java.news.controller.AdminController.batchDeleteArticle()', '2019-11-23 12:41:54', '127.0.0.1');
INSERT INTO `loginfo` VALUES ('51', '1349cb2aed464840b56a82ab541bac39', '新闻通过审核', '/admin/setPass', '[\"eb0ddccd47c54cbbb4348da29f81008a\"]', 'com.java.news.controller.AdminController.setArticlePass()', '2019-11-23 12:43:13', '127.0.0.1');
INSERT INTO `loginfo` VALUES ('52', '6b6cf4d377bf473fb4f3b67377c79d30', '查看发布记录', '/article/histry', '[]', 'com.java.news.controller.ArticleController.myHistry()', '2019-11-23 12:43:38', 'geng');
INSERT INTO `loginfo` VALUES ('53', '89974a64d4b84394a60832d8765a4f2b', '查看发布记录', '/article/histry', '[]', 'com.java.news.controller.ArticleController.myHistry()', '2019-11-23 12:44:09', 'geng');
INSERT INTO `loginfo` VALUES ('54', 'a438151f7fc24c5a85376677643b4369', '查看发布记录', '/article/histry', '[]', 'com.java.news.controller.ArticleController.myHistry()', '2019-11-23 12:44:53', 'geng');
INSERT INTO `loginfo` VALUES ('55', '8f7317a9c3d4467ea7ca1306b6d83ad9', '删除登录日志', '/admin/deleteLoginInfoById', '[21]', 'com.java.news.controller.AdminController.deleteLoginInfoById()', '2019-11-23 14:33:31', 'null');
INSERT INTO `loginfo` VALUES ('56', '3cf6b3ae32fb4c28876ef12be4c7fb7f', '删除登录日志', '/admin/deleteLoginInfoById', '[22]', 'com.java.news.controller.AdminController.deleteLoginInfoById()', '2019-11-23 14:33:36', 'null');
INSERT INTO `loginfo` VALUES ('57', '74edcf37c99041c09d6874f78cb4d54b', '删除登录日志', '/admin/deleteLoginInfoById', '[19]', 'com.java.news.controller.AdminController.deleteLoginInfoById()', '2019-11-23 14:33:39', 'null');
INSERT INTO `loginfo` VALUES ('58', '601a1de524bc410abcfef257078e23f8', '删除登录日志', '/admin/deleteLoginInfoById', '[18]', 'com.java.news.controller.AdminController.deleteLoginInfoById()', '2019-11-23 14:34:02', 'null');
INSERT INTO `loginfo` VALUES ('59', '24783a969a8648e8acdcd5d1afca5333', '删除登录日志', '/admin/deleteLoginInfoById', '[20]', 'com.java.news.controller.AdminController.deleteLoginInfoById()', '2019-11-23 14:34:07', 'null');
INSERT INTO `loginfo` VALUES ('60', 'db4405b7c53b49db9406fe6e8a09a462', '删除登录日志', '/admin/deleteLoginInfoById', '[24]', 'com.java.news.controller.AdminController.deleteLoginInfoById()', '2019-11-23 14:34:10', 'null');
INSERT INTO `loginfo` VALUES ('61', '96e33a8082e94462a27f49ac8d076858', '修改个人信息', '/user/updateInfo', '[{\"birthday\":\"2019-11-23\",\"id\":0,\"password\":\"456\",\"phoneNumber\":\"18861173665\",\"userId\":\"6f5d888d2s123\",\"userName\":\"geng\"}]', 'com.java.news.controller.UserController.updateInfo()', '2019-11-23 14:42:16', 'geng');
INSERT INTO `loginfo` VALUES ('62', 'd513065b5f404c73a687730d24a3d078', '修改个人信息', '/user/updateInfo', '[{\"birthday\":\"2019-11-23\",\"id\":0,\"password\":\"456\",\"phoneNumber\":\"18861173665\",\"userId\":\"6f5d888d2s123\",\"userName\":\"geng\"}]', 'com.java.news.controller.UserController.updateInfo()', '2019-11-23 14:55:18', 'geng');
INSERT INTO `loginfo` VALUES ('63', 'dd2baa26b4894c929d3230e2de196e5e', '添加管理', '/admin/addAdmin', '[\"geng\",\"123\",\"11111111111\"]', 'com.java.news.controller.AdminController.adminRegist()', '2019-11-23 18:49:31', 'null');
INSERT INTO `loginfo` VALUES ('64', '0823670aa619413f90b25a1ccbc74ce1', '删除登录日志', '/admin/deleteLoginInfoById', '[14]', 'com.java.news.controller.AdminController.deleteLoginInfoById()', '2019-11-23 18:58:56', 'null');
INSERT INTO `loginfo` VALUES ('65', '99e1f2d7bd174d2aab1a0ac26ecee232', '删除登录日志', '/admin/deleteLoginInfoById', '[25]', 'com.java.news.controller.AdminController.deleteLoginInfoById()', '2019-11-23 18:58:59', 'null');
INSERT INTO `loginfo` VALUES ('66', '3b7755c9ee1344379c5c0a9f0875401b', '删除登录日志', '/admin/deleteLoginInfoById', '[28]', 'com.java.news.controller.AdminController.deleteLoginInfoById()', '2019-11-23 19:02:27', 'null');
INSERT INTO `loginfo` VALUES ('67', '2c27a9af6a8c4f868bf1fde7ca0604c1', '删除登录日志', '/admin/deleteLoginInfoById', '[30]', 'com.java.news.controller.AdminController.deleteLoginInfoById()', '2019-11-23 19:05:18', 'null');
INSERT INTO `loginfo` VALUES ('68', '422be30b6456446281addb41e5130dca', '查看发布记录', '/article/histry', '[]', 'com.java.news.controller.ArticleController.myHistry()', '2019-11-23 19:09:21', 'geng');
INSERT INTO `loginfo` VALUES ('71', '9f24585d564d4b39a35fbf969cf7fe5d', '删除操作日志', '/admin/deleteLogInfoById', '[\"b139b1945b974241bc8f80d3356653aa\"]', 'com.java.news.controller.AdminController.deleteLogInfoById()', '2019-11-23 19:15:30', 'admin');
INSERT INTO `loginfo` VALUES ('72', '75ff5631324a4423b3301baf18f6d83d', '删除操作日志', '/admin/deleteLogInfoById', '[\"6646479404904651b5db06aeb4ede9ed\"]', 'com.java.news.controller.AdminController.deleteLogInfoById()', '2019-11-23 19:15:35', 'admin');

-- ----------------------------
-- Table structure for logininfo
-- ----------------------------
DROP TABLE IF EXISTS `logininfo`;
CREATE TABLE `logininfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(50) NOT NULL,
  `loginIP` varchar(50) NOT NULL,
  `loginState` int(11) NOT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logininfo
-- ----------------------------
INSERT INTO `logininfo` VALUES ('9', 'geng', '0:0:0:0:0:0:0:1', '0', '', '2019-11-10 10:43:48', '1');
INSERT INTO `logininfo` VALUES ('10', 'geng', '0:0:0:0:0:0:0:1', '0', '', '2019-11-10 13:23:49', '1');
INSERT INTO `logininfo` VALUES ('11', 'geng', '0:0:0:0:0:0:0:1', '0', '', '2019-11-16 15:19:36', '1');
INSERT INTO `logininfo` VALUES ('12', 'geng', '0:0:0:0:0:0:0:1', '0', '', '2019-11-16 17:46:24', '1');
INSERT INTO `logininfo` VALUES ('13', 'geng', '0:0:0:0:0:0:0:1', '0', '', '2019-11-17 14:16:44', '1');
INSERT INTO `logininfo` VALUES ('15', 'geng', '0:0:0:0:0:0:0:1', '0', '', '2019-11-23 11:59:10', '1');
INSERT INTO `logininfo` VALUES ('16', 'geng', '0:0:0:0:0:0:0:1', '0', '', '2019-11-23 12:19:35', '1');
INSERT INTO `logininfo` VALUES ('17', 'geng', '0:0:0:0:0:0:0:1', '0', '', '2019-11-23 12:42:47', '1');
INSERT INTO `logininfo` VALUES ('23', 'geng', '127.0.0.1', '1', '用户名/密码错误！', '2019-11-23 14:32:45', '0');
INSERT INTO `logininfo` VALUES ('26', 'geng', '0:0:0:0:0:0:0:1', '0', '', '2019-11-23 14:41:35', '1');
INSERT INTO `logininfo` VALUES ('27', 'geng', '0:0:0:0:0:0:0:1', '1', '用户名/密码错误！', '2019-11-23 14:42:28', '1');
INSERT INTO `logininfo` VALUES ('29', 'geng', '0:0:0:0:0:0:0:1', '0', '', '2019-11-23 14:54:58', '1');
INSERT INTO `logininfo` VALUES ('31', 'admin', '127.0.0.1', '0', '', '2019-11-23 19:01:57', '0');
INSERT INTO `logininfo` VALUES ('32', 'admin', '127.0.0.1', '0', '', '2019-11-23 19:05:00', '0');
INSERT INTO `logininfo` VALUES ('33', 'geng', '0:0:0:0:0:0:0:1', '1', '用户名/密码错误！', '2019-11-23 19:09:12', '1');
INSERT INTO `logininfo` VALUES ('34', 'geng', '0:0:0:0:0:0:0:1', '0', '', '2019-11-23 19:09:17', '1');
INSERT INTO `logininfo` VALUES ('35', 'admin', '127.0.0.1', '0', '', '2019-11-23 19:13:14', '0');
INSERT INTO `logininfo` VALUES ('36', 'admin', '127.0.0.1', '1', '用户名/密码错误！', '2019-11-23 19:15:05', '0');
INSERT INTO `logininfo` VALUES ('37', 'admin', '127.0.0.1', '0', '', '2019-11-23 19:15:15', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(255) NOT NULL,
  `userName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phoneNumber` varchar(11) DEFAULT NULL,
  `birthday` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `registTime` timestamp NULL DEFAULT NULL,
  `updateTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `headImg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '6f5d888d2s123', 'geng', '456', '18861173665', '2019-11-23 00:00:00', '2019-11-04 14:09:02', '2019-11-23 14:55:18', 'qinm.png');
INSERT INTO `user` VALUES ('2', 'f43c95efa1ed479f944dd7bd10a9679c', 'zhang', '123', '1594901777', '2019-11-05 00:00:00', '2019-11-05 20:01:10', '2019-11-05 20:01:10', '2-50-33.png');
INSERT INTO `user` VALUES ('12', 'be024fcdc9fe49a68bed3df5e763a48b', 'Mr_清明', '123', '15240470145', '2019-11-08 00:00:00', '2019-11-08 13:30:39', '2019-11-08 13:30:39', 'Snipaste_2019-11-06_16-59-43.png');
INSERT INTO `user` VALUES ('13', '90411d2988f84145ac846537b2db4447', 'lisi', '123', '88888888', '2019-11-17 00:00:00', '2019-11-17 12:37:49', '2019-11-17 12:37:49', 'Snipaste_2019-11-05_12-51-04.png');
INSERT INTO `user` VALUES ('14', '998f8e7189854b9c916189700971739b', 'lisi2', '123', '88888888', '2019-11-17 00:00:00', '2019-11-17 12:38:00', '2019-11-17 12:38:00', '2-50-33.png');
INSERT INTO `user` VALUES ('15', '0eb8320f48e5403c8f524505e17e5c91', 'lisi3', '123', '88888888', '2019-11-17 00:00:00', '2019-11-17 12:38:22', '2019-11-17 12:38:22', 'Snipaste_2019-11-06_16-59-43.png');
INSERT INTO `user` VALUES ('18', '9f1ce9ebbcbf46a6a30533a8036ee36c', 'lisi4', '123', '22222222', '2019-11-17 00:00:00', '2019-11-17 12:50:57', '2019-11-17 12:50:57', 'qinm.png');

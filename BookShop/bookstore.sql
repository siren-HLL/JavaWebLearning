/*
 Navicat MySQL Data Transfer

 Source Server         : sirenDB
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : bookstore

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 06/16/2021 11:09:43 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `menus`
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `target` varchar(10) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `menus`
-- ----------------------------
BEGIN;
INSERT INTO `menus` VALUES ('1', '商品信息', '/admin/productInfo', 'self', null), ('2', '用户信息', '/admin/userInfo', 'self', null), ('3', '通知公告', '/admin/noticeInfo', 'self', null), ('4', '菜单信息', '/admin/menuInfo', 'self', null), ('5', '订单信息', '/admin/orderInfo', 'self', null), ('6', '订单详情', '/admin/orderItemInfo', 'self', null);
COMMIT;

-- ----------------------------
--  Table structure for `notices`
-- ----------------------------
DROP TABLE IF EXISTS `notices`;
CREATE TABLE `notices` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `notices`
-- ----------------------------
BEGIN;
INSERT INTO `notices` VALUES ('1', '白先勇《台北人》', '“美中不足的是，抬望眼，总看见园中西隅，剩下的那两棵意大利柏树中间，露出一块楞楞的空白来，缺口当中，映着湛湛青空，悠悠白云，那是一道女娲炼石也无法弥补的天裂。”', '2020-12-04 23:13:50', null), ('2', '《现代艺术150年：一个未完成的任务》', '“如果我们还能从一百五十多年前莫奈的《日出》、梵高的《星空》中，依稀辨认出艺术“原来”的模样，那么，一百五十年后安迪·沃霍尔的金汤宝罐头、达米恩·赫斯特的腌制鲨鱼，还有翠西·艾敏乱糟糟的床，足以让我们看到艺术的其他可能。回顾现代艺术一个半世纪的反叛之路，我们见证了一代又一代人如何变得愈发反叛、大胆、混乱。这背后，是艺术家对“何为艺术”的无尽追问，是他们对周遭世界的回应与抵抗。现代艺术的故事仍在继续，也许永远不会完成。”', '2020-12-24 13:16:15', null), ('3', '《存在主义咖啡馆：自由、存在和杏子鸡尾酒》', '“在本书中，英国著名作家莎拉·贝克韦尔将历史、传记与哲学结合在一起，以史诗般恢弘的视角，激情地讲述了一个充满了斗争、爱情、反抗与背叛的存在主义故事，深入探讨了在今天这个纷争不断、技术驱动的世界里，当我们每个人再次面对有关绝对自由、全球责任与人类真实性的问题时，曾经也受过它们困扰的存在主义者能告诉我们什么。”', '2020-12-30 21:17:51', null), ('4', '袁哲生《寂寞的游戏》', '“我从来没有看过那样一张完全没有表情的脸，和那么空洞的一双眼球，对我视而不见。\n那时，他望了好一会儿，然后才掉头走开。我还记得自己一直蹲在树上，痴痴地看着那双橘色的塑胶拖鞋慢慢离去，发出干燥的沙沙声。接着，我清清楚楚地看到自己蜷缩在树上，我看见自己用一种很陌生的姿势躲在一个阴暗寂寞的角落里，我哭了...”', '2021-01-01 23:20:48', null), ('5', '双雪涛《平原上的摩西》', '“我说，你准备好了吗？ 她说，我准备好了。 我把手伸进怀里，绕过我的手枪，掏出我的烟。那是我们的平原。上面的她，十一二岁，笑着，没穿袜子，看着半空。烟盒在水上漂着，上面那层塑料在阳光底下泛着光芒，北方午后的微风吹着她，向着岸边走去。”', '2021-01-30 09:22:15', null), ('6', '《麦田里的守望者》', '“对一个人来说，一辈子里注定会不时去寻找一些他们自身周围所不能提供的东西，要么他们以为自身的周围无法提供，所以放弃了寻找，他们甚至在还没有真正开始寻找前，就放弃了。 一个不成熟的人的标志是他愿意为了某个理由而轰轰烈烈地死去，而一个成熟的人的标志是他愿意为了某个理由而谦恭地活下去”', '2021-02-27 23:24:46', null), ('7', '《小王子》', '“我那时什么也不懂！我应该根据她的行为，而不是根据她的话来判断她。 她使我的生活芬芳多彩，我真不该离开她跑出来。我本应该猜出在她那令人爱怜 的花招后面所隐藏的温情。花是多么自相矛盾！我当时太年青，还不懂得爱她。”', '2021-03-30 23:29:40', null), ('11', 'test', 'test', null, null), ('16', 'xixi', 'siren', '2021-05-31 01:54:24', null), ('17', '贺正龙出新歌啦！', '我手下艺人真不错，再接再厉\r\n天啊\r\n龙龙快帮我签名', '2021-05-31 10:20:29', null);
COMMIT;

-- ----------------------------
--  Table structure for `notices_copy`
-- ----------------------------
DROP TABLE IF EXISTS `notices_copy`;
CREATE TABLE `notices_copy` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `notices_copy`
-- ----------------------------
BEGIN;
INSERT INTO `notices_copy` VALUES ('1', '白先勇《台北人》', '“美中不足的是，抬望眼，总看见园中西隅，剩下的那两棵意大利柏树中间，露出一块楞楞的空白来，缺口当中，映着湛湛青空，悠悠白云，那是一道女娲炼石也无法弥补的天裂。”', '2020-12-04 23:13:50', null), ('2', '《现代艺术150年：一个未完成的任务》', '“如果我们还能从一百五十多年前莫奈的《日出》、梵高的《星空》中，依稀辨认出艺术“原来”的模样，那么，一百五十年后安迪·沃霍尔的金汤宝罐头、达米恩·赫斯特的腌制鲨鱼，还有翠西·艾敏乱糟糟的床，足以让我们看到艺术的其他可能。回顾现代艺术一个半世纪的反叛之路，我们见证了一代又一代人如何变得愈发反叛、大胆、混乱。这背后，是艺术家对“何为艺术”的无尽追问，是他们对周遭世界的回应与抵抗。现代艺术的故事仍在继续，也许永远不会完成。”', '2020-12-24 13:16:15', null), ('3', '《存在主义咖啡馆：自由、存在和杏子鸡尾酒》', '“在本书中，英国著名作家莎拉·贝克韦尔将历史、传记与哲学结合在一起，以史诗般恢弘的视角，激情地讲述了一个充满了斗争、爱情、反抗与背叛的存在主义故事，深入探讨了在今天这个纷争不断、技术驱动的世界里，当我们每个人再次面对有关绝对自由、全球责任与人类真实性的问题时，曾经也受过它们困扰的存在主义者能告诉我们什么。”', '2020-12-30 21:17:51', null), ('4', '袁哲生《寂寞的游戏》', '“我从来没有看过那样一张完全没有表情的脸，和那么空洞的一双眼球，对我视而不见。\n那时，他望了好一会儿，然后才掉头走开。我还记得自己一直蹲在树上，痴痴地看着那双橘色的塑胶拖鞋慢慢离去，发出干燥的沙沙声。接着，我清清楚楚地看到自己蜷缩在树上，我看见自己用一种很陌生的姿势躲在一个阴暗寂寞的角落里，我哭了...”', '2021-01-01 23:20:48', null), ('5', '双雪涛《平原上的摩西》', '“我说，你准备好了吗？ 她说，我准备好了。 我把手伸进怀里，绕过我的手枪，掏出我的烟。那是我们的平原。上面的她，十一二岁，笑着，没穿袜子，看着半空。烟盒在水上漂着，上面那层塑料在阳光底下泛着光芒，北方午后的微风吹着她，向着岸边走去。”', '2021-01-30 09:22:15', null), ('6', '《麦田里的守望者》', '“对一个人来说，一辈子里注定会不时去寻找一些他们自身周围所不能提供的东西，要么他们以为自身的周围无法提供，所以放弃了寻找，他们甚至在还没有真正开始寻找前，就放弃了。 一个不成熟的人的标志是他愿意为了某个理由而轰轰烈烈地死去，而一个成熟的人的标志是他愿意为了某个理由而谦恭地活下去”', '2021-02-27 23:24:46', null), ('7', '《小王子》', '“我那时什么也不懂！我应该根据她的行为，而不是根据她的话来判断她。 她使我的生活芬芳多彩，我真不该离开她跑出来。我本应该猜出在她那令人爱怜 的花招后面所隐藏的温情。花是多么自相矛盾！我当时太年青，还不懂得爱她。”', '2021-03-30 23:29:40', null), ('11', 'test', 'test', null, null), ('16', 'xixi', 'siren', '2021-05-31 01:54:24', null), ('17', '龙龙出新歌啦！', 'test', '2021-05-31 10:20:29', null);
COMMIT;

-- ----------------------------
--  Table structure for `orderitems`
-- ----------------------------
DROP TABLE IF EXISTS `orderitems`;
CREATE TABLE `orderitems` (
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `buy_num` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `pay_state` int(11) DEFAULT NULL,
  `guest_name` varchar(50) DEFAULT NULL,
  `guest_address` varchar(200) DEFAULT NULL,
  `guest_phone` varchar(50) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `orders`
-- ----------------------------
BEGIN;
INSERT INTO `orders` VALUES ('1', '1', '33', '1', 'admin', '重庆', '18698575409', '2021-05-27 20:10:47', null), ('2', '1', '53', '1', 'admin', '重庆', '18698575409', '2021-05-27 21:11:37', null), ('3', '1', '200', '0', 'admin', '重大', '18698575409', '2021-05-27 22:30:00', null), ('4', '2', '200', '1', 'siren', '湖南省长沙市幸福疗养院', '19218076508', '2021-05-27 22:52:47', null), ('5', '2', '56', '1', 'siren', '湖南省长沙市幸福疗养院', '19218076508', '2021-05-27 22:54:35', null), ('6', '8', '100', '0', '蓝蓝', '四川省遂宁市大英首府', '15598372729', '2021-05-27 22:56:40', null), ('7', '8', '100', '1', '蓝蓝', '四川省遂宁市大英首府', '15598372729', '2021-05-27 23:09:13', null), ('12', null, '200', '0', 'nihao', '尖顶坡', '178943743095', '2021-05-30 20:57:57', null), ('13', null, '22', '1', 'nihao', '的轨顶风道', '1123455', '2021-05-30 20:48:24', null), ('14', null, '200', '1', 'yxf', '属地是否会浮动和', '178943743095', '2021-05-30 21:51:30', null);
COMMIT;

-- ----------------------------
--  Table structure for `products`
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `pnum` int(11) DEFAULT NULL,
  `imgurl` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `products`
-- ----------------------------
BEGIN;
INSERT INTO `products` VALUES ('1', 'Java程序设计', '33', '计算机', '5', '/resources/images/java.jpg', 'Java程序设计', null), ('2', 'Web前端开发', '20', '计算机', '4', '/resources/images/web.jpg', 'Web前端开发', null), ('3', 'Php开发', '36', '计算机', '5', '/resources/images/php.jpg', 'Php开发', null), ('4', '大数据技术', '40', '计算机', '9', '/resources/images/bigdata.jpg', '大数据技术', null), ('5', 'javascript程序开发', '56', '计算机', '8', '/resources/images/javascript.jpg', 'javascript', null), ('9', 'caibuc', '12', '测试', '34', '', '', null), ('10', 'caicai', '89', '测试', '12', '', '', null), ('11', 'pp', '12', '测试', '12', '', '', null), ('12', 'qqq', '23', '测试', '34', '', '', null), ('13', 'yyyy', '12', '测试', '34', '', '', null);
COMMIT;

-- ----------------------------
--  Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `introduce` varchar(100) DEFAULT NULL,
  `activecode` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `role` varchar(200) DEFAULT NULL,
  `registtime` datetime DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `users`
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('1', 'admin', '123456', '女', '1234@163.com', '18698575409', null, null, null, null, '2021-01-27 20:35:55', ''), ('2', 'siren', '001204', '女', 'siren_hll@gmail.com', '19118076508', null, null, null, null, '2021-05-12 12:43:56', null), ('3', '枫枫', '043845', '女', '11937728682@qq.com', '17874077431', null, null, null, null, '2021-05-13 08:44:28', null), ('4', 'poopman', '123456', '男', '514784460@qq.com', '13767754890', null, null, null, null, '2021-03-27 20:44:56', null), ('5', 'ricky', 'c13789', '男', '123453214@qq.com', '17799440034', null, null, null, null, '2021-05-04 15:10:12', null), ('6', '龙龙', '123456', '男', '190862682@163.com', '17823741855', null, null, null, null, '2021-04-11 19:05:43', null), ('7', '阳阳', '654321', '男', '189234703@qq.com', '18890443251', null, null, null, null, '2021-04-13 15:46:07', null), ('8', '蓝蓝', '235689', '女', 'lwysgdhr@163.com', '15456730985', null, null, null, null, '2021-05-07 08:47:00', null), ('9', '王五', '112086', '女', 'wyhsgdhr@163.com', '15598372729', null, null, null, null, '2021-05-27 22:52:31', null), ('12', 'testt', '123456', '男', 'Email@qq.com', '1234567899023', '', null, null, null, '2021-05-31 20:53:54', null), ('16', 'lss', '123456', '女', '1193772868@qq.com', '1234567899023', '', null, null, null, '2021-05-31 22:29:35', null), ('17', 'ans', '123456', '男', 'Email@qq.com', '1234567899023', '', null, null, null, '2021-05-31 22:38:36', null), ('18', 'pyy', 'pyypyy', '男', 'Emailpyy@qq.com', '18976305832', '大帅哥', null, null, null, '2021-05-31 22:43:04', null), ('19', '小菊', '520yxf', '女', 'zhouju@qq.com', '18224274604', '', null, null, null, '2021-06-01 14:09:34', null), ('21', '小芸', '123456', '女', 'Email@qq.com', '1234567899023', '', null, null, null, '2021-06-06 22:22:52', null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

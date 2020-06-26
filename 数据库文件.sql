/*
 Navicat Premium Data Transfer

 Source Server         : mysql_gzc
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : bookshop

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 01/06/2020 20:13:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '书籍编号',
  `category_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '书籍分类代码',
  `book_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '书籍名称',
  `isbn` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'ISBN',
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '作者',
  `press` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '出版社',
  `pub_date` date NOT NULL COMMENT '出版日期',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '书籍图片',
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '书籍描述',
  `price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT '书籍单价',
  `stock` int unsigned NOT NULL COMMENT '书籍库存',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上架时间',
  PRIMARY KEY (`book_id`) USING BTREE,
  UNIQUE INDEX `book_id`(`book_id`) USING BTREE,
  INDEX `category_code`(`category_code`) USING BTREE,
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`category_code`) REFERENCES `category` (`category_code`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic AUTO_INCREMENT=1000;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ( 'novel', '巴黎圣母院', '9787560575667', '[法]雨果 著 李玉民 译', '西安交通大学出版社', '2015-08-01', '24170734-1_l_4.jpg', '北大西语系翻译家李玉民全译本，“世界十大名著”“世界十大爱情故事”之一，读过后，更懂爱', 37.80, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('novel', '失乐园', '9787555257035', '渡边淳一[著]  林少华[译]', '青岛出版社', '2017-11-01', '25182491-1_l_6.jpg', '渡边淳一代表作，长期雄踞日本畅销书排行榜榜首，由黑木瞳、役所广司主演的电影引发“失乐园”热。此次的全新林少华译本，将带你体味不一样的渡边淳一，不一样的失乐园。', 45.00, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('novel', '假面之夜+假面饭店+假面前夜', '25286485', '东野圭吾', '南海出版公司', '2018-06-01', '25286485-1_l_2.jpg', '新系列新CP。富丽堂皇的五星级大酒店，各怀心事的客人。平静的表面下暗流汹涌。杀人凶手即将在此现身。新田尚美联手揭开假面。', 115.90, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('novel', '布隆夫曼脱单历险记', '9787559431394', '[美]丹尼尔·华莱士 著 宁蒙 译 时代华语', '江苏凤凰文艺出版社', '2019-04-01', '26916949-1_l_6.jpg', '为什么不结婚？为什么想恋爱却不主动？单身人士，可能是对自我和世界有着独特认知，对他们来说，脱单之旅，不止是一次成长冒险，更是与原生家庭的和解，与人类社会的碰撞。单身族群，比起伴侣，更需要的是找到自己。', 35.80, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('novel', '光与影', '9787555269397', '渡边淳一', '青岛出版社', '2018-05-25', '25283531-1_l_3.jpg', '渡边淳一文学的原点之作 日本文学奖直木奖获奖作品 关于命运和与人性 关于死亡与热爱 关于病痛与尊严 关于爱情与复仇', 32.00, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('novel', '三体：全三册', '23579654', '刘慈欣', '重庆出版社', '2010-11-01', '23579654-1_l_3.jpg', '刘慈欣代表作，亚洲首部“雨果奖”获奖作品！', 55.80, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('novel', '鲛在水中央', '9787540490645', '孙频', '湖南文艺出版社', '2017-08-01', '27855831-1_l_4.jpg', '阎连科、韩少功、苏童鼎力推荐。这个人世间，有谁不是在努力地活着。这是一本让你流着泪读完的书！那些孤独的、无奈的却又不向命运低头的人，都是生活的勇者。', 42.70, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ( 'manage', '彼得·林奇点评版股票作手回忆录', '9787515303628', '[美]杰西·利弗莫尔', '中国青年出版社', '2019-05-01', '27855149-1_l_3.jpg', ' 利弗莫尔，从5元本金到1亿资本额，这是每代股神都难以忽略的股市传奇。《彼得林奇点评版股票作手回忆录》是由彼得林奇点评，凯恩斯作序的经典之作', 32.20, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ( 'manage', '财务自由之路（全三册）', '26511903', '[德]博多·舍费尔', '现代出版社', '2019-02-20', '26511903-1_l_2.jpg', '理念指导+操作技巧 助力投资新手、投资高手！', 121.10, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('manage', '稻盛和夫阿米巴经营经典套装（理论+实践）', '9787520202824', '[日]稻盛和夫', '中国大百科全书出版社', '2018-05-01', '25288392-1_l_1.jpg', '日本经营之圣稻盛和夫亲笔撰写，首次全公开曾秘不外传的阿米巴经营要领！学习阿米巴经营的经典教材，畅销70万册', 74.70, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('manage', '斯坦福极简经济学', '24010635', '[美]泰勒', '湖南人民出版社', '2016-08-16', '24010635-1_l_6.jpg', '《斯坦福极简经济学》被评为2015年度经管类好书。斯坦福大学十分受欢迎的经济学教授给你36个经济法则关键词，带你看懂复杂世界的真实运作！', 45.50, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ( 'manage', '工匠精神：向价值型员工进化——精装典藏新版', '9787515814940', '付守永', '中华工商联合出版社', '2015-12-01', '23811600-1_l_1.jpg', '2016政府工作报告首倡工匠精神。精耕细作3年，销量近20万册，首部让精益求精、创新突破的工匠精神成为员工信仰的著作。移动互联时代更需要工匠精神！', 37.00, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ( 'manage', '高效能学习：思维力+学习力（套装共2册）', '26514401', '王世民', '电子工业出版社', '2019-02-19', '26514401-1_l_3.jpg', '思维力与学习力的碰撞，升级国民大脑，颠覆职场学习！', 101.40, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('manage', '谈判：如何在博弈中获得更多', '9787513918930', '[英] 盖温·肯尼迪 (Gavin Kennedy)', '民主与建设出版社', '2018-04-06', '25247638-1_l_1.jpg', '全球十余种版本累计销售超200万册，中国入世首席谈判官龙永图作序推荐，世界著名谈判专家盖温·肯尼迪畅销35年的谈判宝典全新增订，亿万富翁的枕边书', 40.50, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ( 'sheke', '曾国藩的正面与侧面', '27856398', '张宏杰', '岳麓出版社', '2018-04-06', '27856398-1_l_4.jpg', '知名历史学者张宏杰，百万畅销《曾国藩的正面与侧面》经典系列，郑重收官。三本书分别阐述了中国特色官场生存哲学、治家典范书以及曾国藩领导力，展现一个更加立体的曾国藩。', 134.60, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('sheke', '第二性（ⅠⅡ 全两册）', '23429879', '[法]西蒙娜德波伏瓦', '上海译文出版社', '2011-09-01', '23429879-1_l_5.jpg', '《第二性I》副标题为“事实与神话”，作者从生物学、精神分析学和历史唯物主义关于女性的观点出发，剖析女人变成“他者”的原因；随后，通过对人类历史的梳理，深刻地揭示了从原始社会到现今女性的命运；', 68.60, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('sheke', '易经杂说', '9787520707862', '南怀瑾', '东方出版社', '2019-04-01', '26914951-1_l_8.jpg', '南怀瑾先生生前亲笔签约授权，亲加审阅的定本，当当网独家定制，典藏必备。 ', 45.50, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('sheke', '中国文史哲大辞典（全六册）', '25282178', '郑天挺、谭其骧、钱仲联、章培恒、傅璇琮、张岱年等', '上海辞书出版社', '2018-08-15', '25282178-1_l_4.jpg', '研究中国历史、哲学、文学必备工具书（荣获第十一届国家图书奖、第三届国家辞书奖二等奖、上海市优秀图书奖一等奖、第五届国家图书奖提名奖、第四届中国辞书奖一等奖。） ', 945.60, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('life', '范志红健康日历', '9787122327475', '范志红', '化学工业出版社', '2019-12-01', '25343879-1_l_9.jpg', '本书为范志红教授的日历体新作。全书以2019年日历为时间顺序，分12个月12大健康关键词，对糖类、脂肪、蛋白质、维生素、减肥、运动、慢性病等营养健康热点进行通俗易懂的一句话解读，科学靠谱。', 70.50, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ( 'life', '闪电增肌', '9787121359552', '仰望尾迹云', '电子工业出版社', '2019-03-01', '26911042-1_l_2.jpg', '肌肉健美指南，运动解剖及增肌动作图解，器械健身+囚徒增肌+增肌营养+增肌补充剂+运动损伤修复与预防全书', 46.80, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('life', '你不懂茶', '9787559430076', '[日]三宅贵男', '江苏凤凰文艺出版社', '2019-09-01', '26910987-1_l_29.jpg', '茶文化入门必读经典，日本插画师精心手绘300余幅插图，时尚、有料、有趣的茶知识百科', 39.50, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('life', '男人这东西', '9787555269410', '渡边淳一', '青岛出版社', '2018-05-31', '25310942-1_l_3.jpg', '渡边淳一深度剖析男女两性价值观的异同，从男女性心理学角度撰写的两性关系读本', 39.00, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ( 'life', '孩子受益一生的思维力', '9787554613122', '杨瑜君 万玲', '古吴轩出版社', '2019-01-20', '26445780-1_l_3.jpg', '美国幼儿园和小学都在使用的学习工具。一看就懂、一学就能上手的八大思维导图，阅读、写作、演讲、课堂学习……处处都受用的思维方法，让摸不着看不见的思维过程直观呈现，帮助孩子学习…', 44.30, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('life', '刚刚好的养育：如何培养高情商的孩子', '9787555277750', '鱼爸 ', '青岛出版社', '2019-03-01', '25478869-1_l_24.jpg', '谢谢你，愿做我的孩子；孩子的高情商藏于父母的育儿思维里；看见孩子，共情养育，建立独立又亲密的亲子观 ', 40.10, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ( 'edu', '四大名著', '25111286', '[清]曹雪芹、[明]吴承恩、[明]罗贯中、[明]施耐庵', '民主与建设出版社', '2017-08-01', '25111286-1_l_10.jpg', '青少版插图本 新课标课外阅读 畅销5周年新版修订 好评如潮 三国演义 红楼梦 水浒传 西游记', 97.74, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('edu', '中华上下五千年', '9787570404506', '刘敬余主编', '北京教育出版社', '2019-02-20', '25536242-1_l_5.jpg', ' 青少彩图版(全4册)各类历史文化常识，让历史更有趣，清晰的历史路线图，丰富的彩色插图，让历史更鲜活。', 89.70, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('edu', '古史·文言·今论', '9787303227259', '杨洋', '北京师范大学出版社', '2018-05-01', '25168544-1_l_11.jpg', '《古史·文言·今论》赋予你征服高考文言文的能力！ 文言阅读、文化积累两手抓，为高中师生供文言文教和学的全新解决方案。', 65.30, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('edu', '星火英语六级真题试卷', '9787313086716', '汪开虎', '上海交通大学出版社', '2016-08-16', '26317585-1_l_8.jpg', '2019年6月全真试题+标准模拟（6级）刷题真题词汇写作听力口语', 36.80, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('edu', '现代汉语词典(第7版)', '9787100124508', '中国社会科学院语言研究所词典编辑室 ', '商务印书馆', '2015-12-01', '24039082-1_l_10.jpg', '一部久享盛誉的规范型词典：《现代汉语词典》;一个专业权威的学术机构：中国社会科学院语言研究所;一家百年历史的出版名社：商务印书馆', 93.00, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ( 'edu', '居里夫人传', '9787512655942', '[法]玛丽.居里', '团结出版社', '2019-02-19', '25193296-1_l_344.jpg', '教育部部编初中语文教材八年级上指定阅读图书，一位坚强、高尚的伟大女性，两次获得诺贝尔奖的女性科学家，著名翻译家陈筱卿授权经典全译本', 21.60, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('wenyi', '艺术的故事', '9787807463726', '[英] 贡布里希', '广西美术出版社', '2018-04-06', '20357456-1_l_5.jpg', '清华校长赠2017年本科新生——《艺术的故事》推荐理由：在艺术中获得人生乐趣！在艺术中回望历史 ！', 182.00, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('wenyi', '梵高：化世间痛苦为激情洋溢的美', '9787568041638', '[法]扬·布朗', '华中科技大学出版社', '2018-04-06', '25336743-1_l_3.jpg', '300幅珍贵的艺术作品完整、真实、系统地呈现梵高10年人生与艺术全貌、看尽天才疯子梵高的绘画理念进化全过程，普通人也能读懂的艺术著作，还原大师书信手稿，再诉梵高想要传达给世人却从未... ', 353.80, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('wenyi', '林徽因传：人生从来都靠自己成全', '9787202134948', '程碧', '河北人民出版社', '2011-09-01', '26514792-1_l_10.jpg', '畅销书作家程碧的林徽因传精装升级，平装本热销20万册）十点读书、中央人民广播电台《品味书香》专题推荐！', 51.60, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('wenyi', '三毛典藏全集', '9787530216545', '三毛 ', '北京十月文艺出版社', '2019-04-01', '25071464-1_l_3.jpg', '集结十四部传世经典 三十年写作成果全新呈现。', 336.00, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('wenyi', '雨夜短文', '9787545536829', '余秋雨', '天地出版社', '2018-08-15', '26922758-1_l_10.jpg', '余秋雨首部全新短篇散文重磅上市！用诙谐、讽刺的笔法直面流言蜚语的无奈与孤独，用智慧让谎言失重；用大白话使读者在有限的时间内读懂中国千年文化魂，用短文撬起一部文学史', 55.70, 100, '2020-06-01 20:12:00');
INSERT INTO `book`(category_code,book_name,isbn,author,press,pub_date,image,description,price,stock,create_time)  VALUES ('wenyi', '鲁迅全集', '9787547711101', '鲁迅', '北京日报出版社', '2019-03-01', '23473587-1_l_5.jpg', '全20卷，纪念鲁迅先生逝世80周年！', 457.50, 100, '2020-06-01 20:12:00');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类代码',
  `category_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '分类名称',
  PRIMARY KEY (`category_code`) USING BTREE,
  UNIQUE INDEX `category_code`(`category_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('edu', '教育');
INSERT INTO `category` VALUES ('life', '生活');
INSERT INTO `category` VALUES ('manage', '经营');
INSERT INTO `category` VALUES ('novel', '小说');
INSERT INTO `category` VALUES ('sheke', '社科');
INSERT INTO `category` VALUES ('wenyi', '文艺');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` int unsigned NOT NULL COMMENT '用户ID',
  `consignee_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '收货人姓名',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '收货地址',
  `zip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '邮政编号',
  `phone_number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '联系方式',
  `status` bit(1) NOT NULL DEFAULT b'0' COMMENT '审核状态',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `order_item_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '订单子项ID',
  `order_id` int unsigned NOT NULL COMMENT '订单ID',
  `book_id` int unsigned NOT NULL COMMENT '书籍ID',
  `price` decimal(10, 2) NOT NULL COMMENT '价格',
  `quantity` int unsigned NOT NULL COMMENT '购买数量',
  PRIMARY KEY (`order_item_id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  INDEX `book_id`(`book_id`) USING BTREE,
  CONSTRAINT `order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `order_item_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart`  (
  `cart_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '购物车ID',
  `user_id` int unsigned NOT NULL COMMENT '用户ID',
  `book_id` int unsigned NOT NULL COMMENT '书籍ID',
  `price` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '书籍价格',
  `quantity` int unsigned NOT NULL COMMENT '购买数量',
  PRIMARY KEY (`cart_id`) USING BTREE,
  UNIQUE INDEX `cart_id`(`cart_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `book_id`(`book_id`) USING BTREE,
  CONSTRAINT `shopping_cart_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `shopping_cart_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `email` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户邮箱',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户头像',
  `join_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2020001 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

# sprideDemo
	sprideDemo是一个基于crawler4j的网络爬虫的测试案例,此案例是针对京东商品的一个爬取案例。crawler4j是一个开源的Java网页爬虫，它提供了一个简单的界面
	爬网。 使用它，你可以在几分钟内设置一个多线程的网络爬虫。
### 配置文件
	在resource中的config.properties配置文件中配置初始化信息
* MaxCrawlNum :最大的抓取网页的数量
* MaxThreadNum :初始化线程数量
* PotionNum :抓取时间间隔
* MaxConnection :抓取最大的连接时间
* MaxConnectNum :最大的连接数量
* CrawlWebSit :抓取入口
* StorePos :文件二进制的存储的位置(断去的重新连接)
* CrawlDepth :抓取的深度
* IsEnabledLogin :启用认证
* Account :账号
* Password :密码
* db.enable : 启用数据库
* db.host :链接地址
* db.username :数据库用户名
* db.password :数据库密码
* db.name :数据库名称
* db.drive :数据库驱动
* db.url :数据库的地址

### 测试入口
	建立对应数据库的结构,根据配置文件的信息配置相应的数据库信息
	配置完成后
	项目入口 com.crawl.jd.Main 执行
	
	在数据库有相应的爬取数据

### 项目结构

	引入外部jar包,,案例的中的lib文件
```sql
	CREATE TABLE jdcustomdata (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `custom_id` varchar(200) NOT NULL,
  `brand_name` varchar(32) DEFAULT NULL,
  `custom_name` varchar(125) DEFAULT NULL,
  `custom_orgin` varchar(32) DEFAULT NULL,
  `custom_weight` varchar(32) DEFAULT NULL,
  `custom_price` varchar(125) DEFAULT NULL,
  `custom_comment_count` varchar(32) DEFAULT NULL,
  `custom_good_count` varchar(32) DEFAULT NULL,
  `custome_general_count` varchar(32) DEFAULT NULL,
  `custom_poor_count` varchar(32) DEFAULT NULL,
  `default_good_count` varchar(32) DEFAULT NULL,
  `custom_good_rate` varchar(32) DEFAULT NULL,
  `custom_image_listcount` varchar(32) DEFAULT NULL,
  `hot_comment_tag_Statistics` varchar(2000) DEFAULT NULL,
  `current_time` varchar(125) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
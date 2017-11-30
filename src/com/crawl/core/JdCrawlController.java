package com.crawl.core;

import com.crawl.util.Config;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * @author yhsh
 * @version1.0
 * @see
 *  web解析的入口文件
 * **/
public class JdCrawlController {
	
	//初始化配置文件
	public void InitConfigCrawl() throws Exception{
		
		Integer num = Config.MaxThreadNum;
		
		CrawlConfig config  = new CrawlConfig();
		
		config.setCrawlStorageFolder(Config.StorePostion);
		//config.setMaxDownloadSize(Config.MaxWebNum);
		config.setMaxPagesToFetch(Config.MaxWebNum);
		System.out.println(Config.MaxWebNum);
		config.setPolitenessDelay(Config.PotionNum);
		config.setMaxDepthOfCrawling(Config.CrawlDepth);
		
		 // 实例化爬虫控制器
	    PageFetcher pageFetcher = new PageFetcher(config); // 实例化页面获取器
	    RobotstxtConfig robotstxtConfig = new RobotstxtConfig(); // 实例化爬虫机器人配置 比如可以设置 user-agent
	     
	    // 实例化爬虫机器人对目标服务器的配置，每个网站都有一个robots.txt文件 规定了该网站哪些页面可以爬，哪些页面禁止爬，该类是对robots.txt规范的实现
	    RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
	     
	    // 实例化爬虫控制器
	    CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
	    
	    controller.addSeed(Config.CrawlWebSite);
	    
	 // 启动爬虫，爬虫从此刻开始执行爬虫任务，根据以上配置
	    controller.start(JdLocalDataController.class, num);
	}
	

}

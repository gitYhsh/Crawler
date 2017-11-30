package com.crawl.core;

import com.crawl.util.Config;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class TaocrawlerController {
	
	public void GetCrawlerData(){
		
		//初始化参数
		Integer MaxThread = Config.MaxThreadNum;
		//最大抓取深度
		Integer MaxDepth = Config.CrawlDepth;
		//抓取页面数量
		Integer MaxWebNum = Config.MaxWebNum;
		//页面抓取间隔
		Integer MaxWebDelay = Config.PotionNum;
		//抓取文件临时存储位置
		String PostionFile = Config.StorePostion;
		//抓取的入口
		String WebSite = Config.CrawlWebSite;
		
		CrawlConfig config = new CrawlConfig();
		//初始化文件内容
		config.setMaxPagesToFetch(MaxDepth);
		config.setMaxPagesToFetch(MaxWebNum);
		config.setCrawlStorageFolder(PostionFile);
		config.setPolitenessDelay(MaxWebDelay);
		
		//初始化控制器
		PageFetcher pagefetcher = new PageFetcher(config);
		//Robots.txt文件识别
		RobotstxtConfig robots = new RobotstxtConfig();
		
		RobotstxtServer roboSer = new RobotstxtServer(robots, pagefetcher);
		//抓取控制器
		
		try {
			CrawlController crawl = new CrawlController(config, pagefetcher, roboSer);
			
			crawl.addSeed(WebSite);
			crawl.start(TaocrawlerDataController.class, MaxThread);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}

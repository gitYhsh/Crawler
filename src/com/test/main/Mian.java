package com.test.main;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class Mian {

	public static void main(String[] args) {
		String crawlStorageFolder = "F:/spider";  
        int numberOfCrawlers = 10;  
  
        CrawlConfig config = new CrawlConfig();  
        config.setCrawlStorageFolder(crawlStorageFolder);  
        config.setFollowRedirects(true);  
        /* 
         * Instantiate the controller for this crawl. 
         */  
        PageFetcher pageFetcher = new PageFetcher(config);  
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();  
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);  
        CrawlController controller;
		try {
			controller = new CrawlController(config, pageFetcher, robotstxtServer);
			controller.addSeed("http://www.zhihu.com/question/20381470");  
	        controller.addSeed("http://www.zhihu.com/question/23049278#answer-4608421");  
	        controller.addSeed("http://www.zhihu.com/question/37667007");  
	        controller.addSeed("http://www.zhihu.com/question/21578177#answer-2649268");  
	        controller.addSeed("http://www.zhihu.com/question/20162455#answer-830100");  
	        controller.start(MyCrawler.class, numberOfCrawlers);  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
  
        
	}

}

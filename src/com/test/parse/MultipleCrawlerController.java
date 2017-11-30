package com.test.parse;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class MultipleCrawlerController {
	  
	  public static void main(String[] args) throws Exception {
	   
	    String crawlStorageFolder = "f:/crawl"; // 定义爬虫数据存储位置
	 
	    CrawlConfig config1 = new CrawlConfig(); // 爬虫配置实例1
	    //CrawlConfig config2 = new CrawlConfig(); // 爬虫配置实例2
	 
	    // 两个爬虫实例文件分别存储各种文件夹
	    config1.setCrawlStorageFolder(crawlStorageFolder + "/crawler1");
	    //config2.setCrawlStorageFolder(crawlStorageFolder + "/crawler2");
	 
	    config1.setPolitenessDelay(1000); // 设置1秒爬取一次
	    //config2.setPolitenessDelay(2000); // 设置2秒爬取一次
	 
	    config1.setMaxPagesToFetch(5); // 设置最大爬取页数5
	    //config2.setMaxPagesToFetch(6); // 设置最大爬取页数6
	 
	    // 使用两个PageFetcher实例
	    PageFetcher pageFetcher1 = new PageFetcher(config1);
	    //PageFetcher pageFetcher2 = new PageFetcher(config2);
	 
	    // 使用同一个RobotstxtServer实例
	    RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
	    RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher1);
	 
	    CrawlController controller1 = new CrawlController(config1, pageFetcher1, robotstxtServer);
	    //CrawlController controller2 = new CrawlController(config2, pageFetcher2, robotstxtServer);
	 
	    // 分别指定目标爬虫域名
	    String[] crawler1Domains = {"http://www.zuidaima.com/"}; 
	    //String[] crawler2Domains = {"http://www.java1234.com/"}; 
	 
	    // 设置自定义数据
	    controller1.setCustomData(crawler1Domains); 
	    //controller2.setCustomData(crawler2Domains);
	 
	    // 配置爬虫种子页面，就是规定的从哪里开始爬，可以配置多个种子页面
	    controller1.addSeed("http://www.zuidaima.com/");
	    controller1.addSeed("http://www.zuidaima.com/share/p1-s1.htm");
	 
	    //controller2.addSeed("http://www.java1234.com/");
	    //controller2.addSeed("http://www.java1234.com/a/bysj/javaweb/");
	 
	    // 启动爬虫，爬虫从此刻开始执行爬虫任务，根据以上配置  根据源码  这种启动是无阻塞的
	    controller1.startNonBlocking(BasicCrawler.class, 5);
	    //controller2.startNonBlocking(BasicCrawler.class, 7);
	 
	    controller1.waitUntilFinish(); // 直到完成
	    System.out.println("爬虫1任务结束");
	 
	    //controller2.waitUntilFinish();  // 直到完成
	    System.out.println("爬虫2任务结束");
	  }
	}

package com.test.local;

import java.util.List;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class LocalDataCollectorController {
	 
	  public static void main(String[] args) throws Exception {
	    
	 
	    String rootFolder = "f:/crawl"; // 定义爬虫数据存储位置
	    int numberOfCrawlers = 7; // 定义7个爬虫，也就是7个线程
	 
	    CrawlConfig config = new CrawlConfig(); // 定义爬虫配置
	    config.setCrawlStorageFolder(rootFolder); // 设置爬虫文件存储位置
	    config.setMaxPagesToFetch(10000);  // 设置最大页面获取数
	    config.setPolitenessDelay(100); // 设置爬取策略 1秒爬一次
	 
	    // 实例化爬虫控制器
	    PageFetcher pageFetcher = new PageFetcher(config); // 实例化页面获取器
	    RobotstxtConfig robotstxtConfig = new RobotstxtConfig(); // 实例化爬虫机器人配置 比如可以设置 user-agent
	     
	    // 实例化爬虫机器人对目标服务器的配置，每个网站都有一个robots.txt文件 规定了该网站哪些页面可以爬，哪些页面禁止爬，该类是对robots.txt规范的实现
	    RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
	     
	    // 实例化爬虫控制器
	    CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
	 
	    controller.addSeed("https://search.jd.com/search?keyword=%E7%94%B5%E8%84%91&enc=utf-8&qrst=1&rt=1&stop=1&vt=2&wq=%E7%94%B5%E8%84%91&ev=exbrand_%E6%88%B4%E5%B0%94%EF%BC%88DELL%EF%BC%89"); // 添加爬虫种子
	     
	    // 启动爬虫，爬虫从此刻开始执行爬虫任务，根据以上配置
	    controller.start(LocalDataCollectorCrawler.class, numberOfCrawlers);
	 
	    List<Object> crawlersLocalData = controller.getCrawlersLocalData(); // 当多个线程爬虫完成任务时，获取爬虫本地数据
	    long totalLinks = 0;
	    long totalTextSize = 0;
	    int totalProcessedPages = 0;
	    for (Object localData : crawlersLocalData) {
	      CrawlStat stat = (CrawlStat) localData;
	      totalLinks += stat.getTotalLinks();
	      totalTextSize += stat.getTotalTextSize();
	      totalProcessedPages += stat.getTotalProcessedPages();
	    }
	 
	    // 打印数据
	    System.out.println("统计数据：");
	    System.out.println("总处理页面："+totalProcessedPages);
	    System.out.println("总链接长度："+totalLinks);
	    System.out.println("总文本长度："+totalTextSize);
	  }
	}

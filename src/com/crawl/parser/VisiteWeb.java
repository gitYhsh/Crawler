package com.crawl.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.crawl.core.JdCrawlSubDataController;
import com.crawl.util.Config;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class VisiteWeb {
	/**
	 * 解析商品的id号，
	 * 此Id号作为商品详情页的url
	 * @throws Exception 
	 * **/
	public void GetParaseFile(Page page) throws Exception{
		
		String url = page.getWebURL().getURL(); 
		System.out.println(url);
        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData(); 
            String html = htmlParseData.getHtml();
            Document doc = Jsoup.parse(html);
            Elements eles1 = doc.select("ul.gl-warp");
            for(Element item : eles1){
            	String msg = item.select(".gl-item").attr("data-sku");
            	this.getDetailByCusId(msg);
            }
        }
	}
	
	/**
	 * 根据上层抓取的页面详情号
	 * 分析抓取子页面的内容
	 * @throws Exception 
	 * **/
	public void getDetailByCusId(String num) throws Exception{
		//实例化一个控制器，抓取子页面的相关信息
		Integer threadNum = Config.MaxThreadNum;
		//子控制器的抓取范围之抓取当前页的内容,只获取二级目录的商品
		CrawlConfig subConfig  = new CrawlConfig();
		subConfig.setMaxPagesToFetch(Config.MaxWebNum);
		subConfig.setCrawlStorageFolder("e://font");
		subConfig.setMaxDepthOfCrawling(Config.CrawlDepth);
		 // 实例化爬虫控制器
	    PageFetcher pageFetcher = new PageFetcher(subConfig); // 实例化页面获取器
	    RobotstxtConfig robotstxtConfig = new RobotstxtConfig(); // 实例化爬虫机器人配置 比如可以设置 user-agent
	     
	    // 实例化爬虫机器人对目标服务器的配置，每个网站都有一个robots.txt文件 规定了该网站哪些页面可以爬，哪些页面禁止爬，该类是对robots.txt规范的实现
	    RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
	     
	    // 实例化爬虫控制器
	    CrawlController controller = new CrawlController(subConfig, pageFetcher, robotstxtServer);
	    
	    controller.addSeed(Config.CrawlWebSite);
	    
	 // 启动爬虫，爬虫从此刻开始执行爬虫任务，根据以上配置
	    controller.start(JdCrawlSubDataController.class, threadNum);
		
		
	}

}

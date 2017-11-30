package com.test.main;

import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class MyCrawler extends WebCrawler{
	//private final static Pattern FILTERS = Pattern.compile("-\\d+");
	// 正则匹配指定的后缀文件
	private static final Pattern FILTERS = Pattern.compile(
		      ".*(\\.(css|js|bmp|gif|jpe?g" + "|png|tiff?|mid|mp2|mp3|mp4" + "|wav|avi|mov|mpeg|ram|m4v|pdf" +
		      "|rm|smil|wmv|swf|wma|zip|rar|gz))$");
	 private String[] myCrawlDomains; // 目标爬虫域名
	 
	  /**
	   * 爬虫实例启动前调用，一般是作用是初始化一些数据
	   */
	  @Override
	  public void onStart() {
	    myCrawlDomains = (String[]) myController.getCustomData(); // 获取自定义数据 目标爬虫域名  控制器类对象里会设置的
	  }    
    public boolean shouldVisit(Page referringPage, WebURL url) {  
    	String href = url.getURL().toLowerCase(); // 得到小写的url
	     
	    // 正则匹配，过掉一些指定后缀的文件
	    if (FILTERS.matcher(href).matches()) {
	      return false;
	    }
	 
	    // 遍历目标域名 指定目标爬虫域名
	    for (String crawlDomain : myCrawlDomains) {
	      if (href.startsWith(crawlDomain)) {
	        return true;
	      }
	    }
	 
	    return false;
    }  
    public void visit(Page page) {  
        String url = page.getWebURL().getURL();  
        if (page.getParseData() instanceof HtmlParseData) {  
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();  
            String html = htmlParseData.getHtml();  
            Document doc = Jsoup.parse(html);  
            zhUser zu = new zhUser();  
            Elements eles1 = doc.select("div.title-section");  
            zu.setName( eles1.select(".name").text());  
            zu.setSlogn(eles1.select(".bio").text());  
            Elements bodyEles = doc.select(".body");  
            for(Element item : bodyEles){  
                zu.setHeadImgUrl(item.select(".zm-profile-header-avatar-container img").attr("src"));  
                zu.setAddress(item.select(".info-wrap .location").attr("title"));  
                zu.setWork(item.select(".info-wrap .business").attr("title"));  
                zu.setSchool(item.select(".info-wrap .education").attr("title"));  
                zu.setMajor(item.select(".info-wrap .education-extra").attr("title"));  
            }  
            zu.setUserUrl(url); 
            System.out.println(zu);
            //insertUserToDB(zu);  
        }  
    }  
}

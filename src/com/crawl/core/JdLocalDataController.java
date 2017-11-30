package com.crawl.core;

import java.util.regex.Pattern;

import com.crawl.parser.VisiteWeb;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;

public class JdLocalDataController extends WebCrawler{
	 // 正则匹配后缀
	private static final Pattern FILTERS = Pattern.compile(
	      ".*(\\.(css|js|bmp|gif|jpe?g|png|tiff?|mid|mp2|mp3|mp4|wav|avi|mov|mpeg|ram|m4v|pdf" +
	      "|rm|smil|wmv|swf|wma|zip|rar|gz))$");
	  
	public boolean shouldVisit(Page page, WebURL url) {
		String href = url.getURL().toLowerCase(); // 获取url小写
		//简略的匹配规则
		/**
		 * 1：匹配所有的静态文件
		 * 2：匹配所有的包含jd.com的web类型
		 * **/
	    return !FILTERS.matcher(href).matches() && href.contains("jd.com"); //
	}
	/**
	 * 解析文件的入口处
	 * **/
	public void visit(Page page) {
		VisiteWeb vis = new VisiteWeb();
		try {
			vis.GetParaseFile(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int getMyId() {
		// TODO Auto-generated method stub
		return super.getMyId();
	}
	//当前抓取的时候退出执行入口
	public void onBeforeExit() {
		this.ShowResult();
	}
	
	public void ShowResult(){
	  int id = getMyId();
	  System.out.println("当前爬虫实例id:"+id);
	}
	
}

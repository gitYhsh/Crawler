package com.crawl.core;

import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class TaocrawlerDataController extends WebCrawler{

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
		    return !FILTERS.matcher(href).matches() ; //
		}
		/**
		 * 解析文件的入口处
		 * **/
		public void visit(Page page) {
			
			String url = page.getWebURL().getURL();
			System.out.println(url);
	        if (page.getParseData() instanceof HtmlParseData) {
	            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
	            String html = htmlParseData.getHtml();
	            Document doc = Jsoup.parse(html);
	            //String eles1 = doc.select("body").html();
	            //System.out.println(eles1);
	        }			
		}
}

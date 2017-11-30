package com.crawl.core;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.crawl.entity.BaseInfo;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class JdCrawlSubDataController extends WebCrawler{
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
		    return !FILTERS.matcher(href).matches() && href.startsWith("https://item.jd.com/"); //
		}
		/**
		 * 解析文件的入口处
		 * **/
		public void visit(Page page) {
			
			if (page.getParseData() instanceof HtmlParseData) {  
	            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
	            String html = htmlParseData.getHtml();
	            
	            Document doc = Jsoup.parse(html);
	            Elements eles1 = doc.select("div.p-parameter");
	            //Elements eles2 = doc.select("span.p-price");
	            
	            String price = "";
//	            for(Element items:eles2){
//	            	price = items.text();
//	            	
//	            }
	            
	            for(Element item : eles1){  
	            	String BrandName = item.select("ul#parameter-brand>li").attr("title");
	            	Elements custom = item.select("ul.parameter2>li");

	            	//System.out.println(custom);
	            	this.getCustomDetail(custom,BrandName,price);
	            }
	            
	        }
		}
		//获取详细信息
		public void getCustomDetail(Elements eln,String BrandName,String price){
			
			List<String> list = new ArrayList<String>();
			for(Element items : eln){
				String others =  items.attr("title");
				list.add(others);
				if(list.size()==4){
					break;
				}
			}			
			BaseInfo info = new BaseInfo();
			info.setBrandName(BrandName);
			info.setPrice(price);
			info.setOrginPlace(list.get(list.size()-1));
			info.setWeight(list.get(list.size()-2));
			info.setCustomName(list.get(0));
			info.setCustomId(list.get(1));
			System.out.println(info);
			DbSave.insertData(info);
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

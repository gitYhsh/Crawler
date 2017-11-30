package com.test;

import java.util.regex.Pattern;

import com.crawl.util.Config;

public class Test {

	public static void main(String[] args) {
		
		String ak = Config.CrawlWebSite;
		System.out.println(ak);
		
		
		 // 正则匹配后缀
		 Pattern p = Pattern.compile(
		      ".*(\\.(css|js|bmp|gif|jpe?g|png|tiff?|mid|mp2|mp3|mp4|wav|avi|mov|mpeg|ram|m4v|pdf" +
		      "|rm|smil|wmv|swf|wma|zip|rar|gz))$");
		 String url = "www.baidu.com.jpe";
		boolean ss =  p.matcher(url).matches();
		
		System.out.println(ss);
		  
	}

}

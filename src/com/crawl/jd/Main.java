package com.crawl.jd;

import com.crawl.core.JdCrawlController;
import com.crawl.core.TaocrawlerController;
public class Main {

	public static void main(String[] args) {
		JdCrawlController jd = new JdCrawlController();
		TaocrawlerController tb = new TaocrawlerController();
		try {
			jd.InitConfigCrawl();
			//tb.GetCrawlerData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

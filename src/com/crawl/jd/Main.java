package com.crawl.jd;

import com.crawl.core.JdCrawlController;

public class Main {

	public static void main(String[] args) {
		JdCrawlController jd = new JdCrawlController();
		
		try {
			jd.InitConfigCrawl();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

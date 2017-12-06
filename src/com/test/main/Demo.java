package com.test.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Demo {
	
	public  static void  main(String args[]){
		try {
			Element el = Jsoup.connect("https://item.jd.com/11547179906.html").get().body();
			Elements els= el.select("div#choose-attr-1").select("div.dd").select("div.item");
			for(Element ell:els){
				System.out.println(ell.attr("data-sku"));
				System.out.println(ell.attr("data-value"));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

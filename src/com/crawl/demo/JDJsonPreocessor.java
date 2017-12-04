package com.crawl.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class JDJsonPreocessor implements PageProcessor {
    static Map<String,String> maps = new HashMap<String, String>();
    
    
    public static Map<String,String> running(String url) {

        Spider.create(new JDJsonPreocessor()).addUrl(url).run();
        return maps;
    }

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public Site getSite() {
        return site;
    }

    public void process(Page page) {
        page.setSkip(true);
        String text = page.getRawText();
        int begin = text.indexOf("[");
        int end = text.indexOf("]");
        String substring = text.substring(begin, end + 1);
        String jsonName = "result:";
        String json = "{\"" + jsonName + "\":" + substring + "}";

        Map<String, Object> map = JsonUtil.jsonToMap(json);
        @SuppressWarnings("unchecked")
		List<Map<String, Object>> list = (List<Map<String, Object>>) map.get(jsonName);
        for (Map<String, Object> map1 : list) {
            String key = map1.get("id").toString();
            String value = map1.get("p").toString();
            maps.put(key, value);
        }
    }

	
}
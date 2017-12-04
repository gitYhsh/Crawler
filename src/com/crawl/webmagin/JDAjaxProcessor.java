package com.crawl.webmagin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class JDAjaxProcessor implements PageProcessor {
    public static final String URL_LIST = "http://list\\.jd\\.com/list\\.html\\?cat=9987,653,655&page=\\d+\\&go=0\\&JL=6_0_0";
    //用于存储{key：手机ID,value:手机名称}
    static Map<String,String> map = new HashMap<String, String>();
    static Set<String> uri = new HashSet<String>();
    public static void main(String[] args) {
        String list = "http://list.jd.com/list.html?cat=9987,653,655&page=1&go=0&JL=6_0_0";
        Spider.create(new JDAjaxProcessor()).addUrl(list)
         .addPipeline(new FilePipeline("D:\\webmagic\\"))
        .run();
        for (String s : map.values()) {
            System.out.println(s);
        }
        System.out.println("map-->" + map.size());
        System.out.println(map.get("10274956063"));
    }

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public Site getSite() {
        return site;
    }

    public void process(Page page) {
        if (page.getUrl().regex(URL_LIST).match()) {
//            page.setSkip(true);
            page.putField("id",page.getHtml().xpath("//div[@class='p-focus']/a/@data-sku").all());
            page.putField("name",page.getHtml().xpath("//div[@class='p-name']/a/em/text()").all());
            @SuppressWarnings("unchecked")
			List<String> ids = (List<String>) page.getResultItems().get("id");
            @SuppressWarnings("unchecked")
			List<String> name = (List<String>) page.getResultItems().get("name");
            String makerUrl = makerUrl(ids);
//            System.out.println("价格连接" + makerUrl);
            //key:id,value:price
            Map<String, String> running = JDJsonPreocessor.running(makerUrl);
            for (int i = 0; i < name.size(); i++) {
                String price = running.get("J_"+ids.get(i));
                map.put(ids.get(i), name.get(i) +"\t"+ price);
            }           
            page.addTargetRequests(page.getHtml().links().regex(URL_LIST).all());
        }
    }
    
    public String makerUrl(List<String> ids){
        StringBuffer sb = new StringBuffer();
        for (String id : ids) {
            sb.append("J_"+id+",");
        }
        String substring = sb.substring(0, sb.length()-1);
        System.out.println(substring);
        return "http://p.3.cn/prices/mgets?skuIds="+substring+"&callback=result";
    }
    public void writeFile(){
        
    }
}

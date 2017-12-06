package com.crawl.core;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crawl.entity.BaseInfo;
import com.crawl.entity.CustomColor;
import com.crawl.entity.CustomVersion;

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
	            Elements eles2 = doc.select("div#choose-attrs");
	            
	            String price = "";
	            for(Element item : eles1){  
	            	String BrandName = item.select("ul#parameter-brand>li").attr("title");
	            	Elements custom = item.select("ul.parameter2>li");
	            	try {
						String customId  = this.getCustomDetail(custom,BrandName,price);
						if (customId!=null){
							getCustomeColorOrVersion(eles2,customId);
							//获取当前商品的评论数量
							GetCurrentCustomData(customId);
						}
			            
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	            
	        }
		}
		//获取详细信息
		public String getCustomDetail(Elements eln,String BrandName,String price) throws Exception{
			
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
			
			CloseableHttpClient httpclient = HttpClientBuilder.create().build();
			//获取价格
			
			//设置代理
			
		    HttpPost postPrice = new HttpPost("http://p.3.cn/prices/mgets?skuIds=J_"+list.get(1));		    
            HttpResponse res = httpclient.execute(postPrice);
            
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                //System.out.println(result);
                info.setPrice(result);
                              
            } 
            //获取相关连的评论数
            /***
             * @parame
             * 	productId :商品Id
             *  sortType ：排序规则
             *  page  ：页数
             *  pageSize ：每页的显示数量
             */
            HttpGet postComment = new HttpGet("https://club.jd.com/comment/productPageComments.action?productId="+list.get(1)+"&score=0&sortType=0&page=0&pageSize=10");
            HttpResponse response = httpclient.execute(postComment);
            
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String result1 = EntityUtils.toString(response.getEntity());// 返回json格式           
                JSONObject ObjectStr = JSON.parseObject(JSON.parseObject(result1).getString("productCommentSummary"));
              //info.setCustomGoodRate(Str);
                //获取相应的信息
                //总的评论
                info.setCustomCommentCount(ObjectStr.getString("commentCount"));
                
                info.setCustomGoodCount(ObjectStr.getString("goodCount"));
                //一般评论
                info.setCustomeGeneralCount(ObjectStr.getString("generalCountStr"));
                //差评
                info.setCustomPoorCount(ObjectStr.getString("poorCountStr"));            
                //好评率
                info.setCustomGoodRate(ObjectStr.getString("goodRate"));
                //默认评价
                info.setDefaultGoodCount(ObjectStr.getString("defaultGoodCountStr"));
                //晒图评论
                info.setCustomImageListCount(JSON.parseObject(result1).getString("imageListCount"));
                //热点评论
                info.setHotCommentTagStatistics(JSON.parseObject(result1).getString("hotCommentTagStatistics"));
                Date utilDate=new  Date();
                SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");                
                String date = simple.format(utilDate);              
                info.setCurrentTime(date);
                
                System.out.println(info);
                DbSave.insertData(info); 
            } 
           
            
            return info.getCustomId();
		}
		
		//获取相关连的其他的信息		
		public void getCustomeColorOrVersion(Elements items,String customId){
			System.out.println(customId);
			for(Element els :items){
				Elements ellsColor = els.select("div#choose-attr-1").select("div.dd").select("div.item");
				Elements ellsVersion = els.select("div#choose-attr-2").select("div.dd").select("div.item");
				for (Element ellColor:ellsColor){
					String ColorId = ellColor.attr("data-sku");
					String colorName = ellColor.attr("data-value");
					CustomColor color =new  CustomColor();
					color.setCurrentCustomId(ColorId);
					color.setMainCustomId(customId);
					color.setCustomColor(colorName);
					DbSave.insertColorData(color);
				}
            	
				for (Element ellVersion:ellsVersion){
					String versionId = ellVersion.attr("data-sku");
					String versionName = ellVersion.attr("data-value");
					CustomVersion version = new CustomVersion();
					version.setMainCustomId(customId);
					version.setCurrentCustomId(versionId);
					version.setCustomVersion(versionName);
					DbSave.insertVersionData(version);
				}
            }
		}
		
		//获取当期的商品数量的评论
		public void GetCurrentCustomData(String currentId) throws Exception, IOException{
			
			CloseableHttpClient httpclient = HttpClientBuilder.create().build();
			
			HttpGet postComment = new HttpGet("https://club.jd.com/comment/skuProductPageComments.action?productId="+currentId+"&score=0&sortType=5&page=0&pageSize=10");
            HttpResponse response = httpclient.execute(postComment);
            BaseInfo info = new BaseInfo();
            info.setCustomId(currentId);
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String result1 = EntityUtils.toString(response.getEntity());// 返回json格式           
                JSONObject ObjectStr = JSON.parseObject(JSON.parseObject(result1).getString("productCommentSummary"));
              //info.setCustomGoodRate(Str);
                //获取相应的信息
                //总的评论
                info.setCurrCustomCommentCount(ObjectStr.getString("commentCount"));
                
                info.setCurrCustomGoodCount(ObjectStr.getString("goodCount"));
                //一般评论
                info.setCurrCustomeGeneralCount(ObjectStr.getString("generalCountStr"));
                //差评
                info.setCurrCustomPoorCount(ObjectStr.getString("poorCountStr"));            
                //好评率
                info.setCurrCustomGoodRate(ObjectStr.getString("goodRate"));
                //默认评价
                info.setCurrDefaultGoodCount(ObjectStr.getString("defaultGoodCountStr"));
                //晒图评论
                info.setCurrCustomImageListCount(JSON.parseObject(result1).getString("imageListCount"));
                //热点评论
                info.setCurrHotCommentTagStatistics(JSON.parseObject(result1).getString("hotCommentTagStatistics"));
                Date utilDate=new  Date();
                SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");                
                String date = simple.format(utilDate);         
                info.setCurrentTime(date);
                System.out.println(info);
                DbSave.insertCurrentData(info);
                
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

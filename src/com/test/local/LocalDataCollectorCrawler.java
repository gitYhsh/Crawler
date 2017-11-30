package com.test.local;

import java.io.UnsupportedEncodingException;
import java.util.Set;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class LocalDataCollectorCrawler extends WebCrawler {
	 
	  // 正则匹配后缀
	  private static final Pattern FILTERS = Pattern.compile(
	      ".*(\\.(css|js|bmp|gif|jpe?g|png|tiff?|mid|mp2|mp3|mp4|wav|avi|mov|mpeg|ram|m4v|pdf" +
	      "|rm|smil|wmv|swf|wma|zip|rar|gz))$");
	 
	  CrawlStat myCrawlStat; // 定义爬虫状态对象，用户统计和分析
	 
	  /**
	   * 构造方法
	   */
	  public LocalDataCollectorCrawler() {
	    myCrawlStat = new CrawlStat(); // 实例化爬虫状态对象
	  }
	  
	  /**
	   * 这个方法主要是决定哪些url我们需要抓取，返回true表示是我们需要的，返回false表示不是我们需要的Url
	   * 第一个参数referringPage封装了当前爬取的页面信息
	   * 第二个参数url封装了当前爬取的页面url信息
	   */
	  @Override
	  public boolean shouldVisit(Page referringPage, WebURL url) {
	    String href = url.getURL().toLowerCase(); // 获取url小写
	    return !FILTERS.matcher(href).matches() && href.startsWith("https://www.jd.com/"); //
	  }
	 
	  /**
	   * 当我们爬到我们需要的页面，这个方法会被调用，我们可以尽情的处理这个页面
	   * page参数封装了所有页面信息
	   */
	  @Override
	  public void visit(Page page) {
	    System.out.println("正在爬取页面："+page.getWebURL().getURL());
	    myCrawlStat.incProcessedPages(); // 处理页面加1
	 
	    if (page.getParseData() instanceof HtmlParseData) { // 假如是html数据
	      HtmlParseData parseData = (HtmlParseData) page.getParseData(); // 获取Html数据
	      Set<WebURL> links = parseData.getOutgoingUrls(); // 获取输出链接
	      myCrawlStat.incTotalLinks(links.size()); // 总链接加link.size个
	      try {
	        myCrawlStat.incTotalTextSize(parseData.getText().getBytes("UTF-8").length); // 文本长度增加
	      } catch (UnsupportedEncodingException ignored) {
	        // Do nothing
	      }
	    }
	    // 每获取3个页面数据 我们处理下数据
	    if ((myCrawlStat.getTotalProcessedPages() % 3) == 0) {
	      dumpMyData();
	    }
	  }
	 
	  /**
	   * 获取下爬虫状态
	   */
	  @Override
	  public Object getMyLocalData() {
	    return myCrawlStat;
	  }
	 
	  /**
	   * 当任务完成时调用
	   */
	  @Override
	  public void onBeforeExit() {
	    dumpMyData(); // 处理处理
	  }
	 
	  /**
	   * 处理数据
	   */
	  public void dumpMyData() {
	    int id = getMyId();
	    System.out.println("当前爬虫实例id:"+id);
	    System.out.println("总处理页面："+myCrawlStat.getTotalProcessedPages());
	    System.out.println("总链接长度："+myCrawlStat.getTotalLinks());
	    System.out.println("总文本长度："+myCrawlStat.getTotalTextSize());
	  }
	}

package com.test.local;

public class CrawlStat {
	  private int totalProcessedPages; //处理的页面总数
	  private long totalLinks; // 总链接数
	  private long totalTextSize; // 总文本长度
	 
	  public int getTotalProcessedPages() {
	    return totalProcessedPages;
	  }
	 
	  public void setTotalProcessedPages(int totalProcessedPages) {
	    this.totalProcessedPages = totalProcessedPages;
	  }
	 
	  /**
	   * 总处理页面数加1
	   */
	  public void incProcessedPages() {
	    this.totalProcessedPages++;
	  }
	 
	  public long getTotalLinks() {
	    return totalLinks;
	  }
	 
	  public void setTotalLinks(long totalLinks) {
	    this.totalLinks = totalLinks;
	  }
	 
	  public long getTotalTextSize() {
	    return totalTextSize;
	  }
	 
	  public void setTotalTextSize(long totalTextSize) {
	    this.totalTextSize = totalTextSize;
	  }
	 
	  /**
	   * 总链接数加count个
	   * @param count
	   */
	  public void incTotalLinks(int count) {
	    this.totalLinks += count;
	  }
	 
	  /**
	   * 总文本长度加total个
	   * @param count
	   */
	  public void incTotalTextSize(int count) {
	    this.totalTextSize += count;
	  }
	}

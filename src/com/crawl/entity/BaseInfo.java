package com.crawl.entity;

import java.io.Serializable;
import java.sql.Date;


public class BaseInfo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8290923777366235083L;
	
	/**
	 * 品牌
	 * **/
	private String BrandName;
	/**
	 * 商品名称
	 * **/
	private String CustomName;
	
	/**
	 * 商品编号
	 * **/
	
	private String CustomId;
	
	/**
	 * 商铺重量
	 * **/
	private String Weight;
	
	/**
	 * 产地
	 * **/
	private String OrginPlace;
	
	/**
	 * 价格
	 * **/
	private String Price;
	
	/****
	 * 商品评论数
	 */
	private String CustomCommentCount;
	
	/****
	 * 好评
	 */
	private String CustomGoodCount;
	/***
	 * 中评
	 * @return
	 */
	private String   CustomeGeneralCount;
	
	/***
	 * 差评
	 * @return
	 */	
	private String CustomPoorCount;
	
	/***
	 * 默认评论(用户没有评论,有系统自动默认的评论)
	 */
	private String DefaultGoodCount;
	
	/***
	 * 好评率
	 * @return
	 */
	private String CustomGoodRate;	
	/***
	 * 晒图评论
	 * @return
	 */
	private String  CustomImageListCount;
	/***
	 * 热点评论
	 * @return
	 */
	private String HotCommentTagStatistics;
	
	/****
	 * 当前抓取时间 暂以字符串处理，，方便操作
	 * @return
	 */
	
	private String CurrentTime;
	
	
	public String getCustomName() {
		return CustomName;
	}

	public void setCustomName(String customName) {
		CustomName = customName;
	}

	public String getBrandName() {
		return BrandName;
	}

	public void setBrandName(String brandName) {
		BrandName = brandName;
	}

	public String getCustomId() {
		return CustomId;
	}

	public void setCustomId(String customId) {
		CustomId = customId;
	}

	public String getWeight() {
		return Weight;
	}

	public void setWeight(String weight) {
		Weight = weight;
	}

	public String getOrginPlace() {
		return OrginPlace;
	}

	public void setOrginPlace(String orginPlace) {
		OrginPlace = orginPlace;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getCustomCommentCount() {
		return CustomCommentCount;
	}

	public void setCustomCommentCount(String customCommentCount) {
		CustomCommentCount = customCommentCount;
	}

	public String getCustomGoodCount() {
		return CustomGoodCount;
	}

	public void setCustomGoodCount(String customGoodCount) {
		CustomGoodCount = customGoodCount;
	}

	public String getCustomeGeneralCount() {
		return CustomeGeneralCount;
	}

	public void setCustomeGeneralCount(String customeGeneralCount) {
		CustomeGeneralCount = customeGeneralCount;
	}

	public String getCustomPoorCount() {
		return CustomPoorCount;
	}

	public void setCustomPoorCount(String customPoorCount) {
		CustomPoorCount = customPoorCount;
	}

	public String getDefaultGoodCount() {
		return DefaultGoodCount;
	}

	public void setDefaultGoodCount(String defaultGoodCount) {
		DefaultGoodCount = defaultGoodCount;
	}

	public String getCustomGoodRate() {
		return CustomGoodRate;
	}

	public void setCustomGoodRate(String customGoodRate) {
		CustomGoodRate = customGoodRate;
	}

	public String getCustomImageListCount() {
		return CustomImageListCount;
	}

	public void setCustomImageListCount(String customImageListCount) {
		CustomImageListCount = customImageListCount;
	}

	public String getHotCommentTagStatistics() {
		return HotCommentTagStatistics;
	}

	public void setHotCommentTagStatistics(String hotCommentTagStatistics) {
		HotCommentTagStatistics = hotCommentTagStatistics;
	}

	
	public String getCurrentTime() {
		return CurrentTime;
	}

	public void setCurrentTime(String currentTime) {
		CurrentTime = currentTime;
	}

	@Override
	public String toString() {
		return "BaseInfo [BrandName=" + BrandName + ", CustomName=" + CustomName + ", CustomId=" + CustomId
				+ ", Weight=" + Weight + ", OrginPlace=" + OrginPlace + ", Price=" + Price + ", CustomCommentCount="
				+ CustomCommentCount + ", CustomGoodCount=" + CustomGoodCount + ", CustomeGeneralCount="
				+ CustomeGeneralCount + ", CustomPoorCount=" + CustomPoorCount + ", DefaultGoodCount="
				+ DefaultGoodCount + ", CustomGoodRate=" + CustomGoodRate + ", CustomImageListCount="
				+ CustomImageListCount + ",CurrentTime =" +  CurrentTime+ "]";
	}

	
	
	

}

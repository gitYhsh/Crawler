package com.crawl.entity;

import java.io.Serializable;

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
	 * 商品评论数(所有的各种型号商品)
	 */
	private String CustomCommentCount;
	
	/****
	 * 好评(所有的各种型号商品)
	 */
	private String CustomGoodCount;
	/***
	 * 中评(所有的各种型号商品)
	 * @return
	 */
	private String   CustomeGeneralCount;
	
	/***
	 * 差评(所有的各种型号商品)
	 * @return
	 */	
	private String CustomPoorCount;
	
	/***
	 * 默认评论(用户没有评论,有系统自动默认的评论)(所有的各种型号商品)
	 */
	private String DefaultGoodCount;
	
	/***
	 * 好评率(所有的各种型号商品)
	 * @return
	 */
	private String CustomGoodRate;	
	/***
	 * 晒图评论(所有的各种型号商品)
	 * @return
	 */
	private String  CustomImageListCount;
	/***
	 * 热点评论(所有的各种型号商品)
	 * @return
	 */
	private String HotCommentTagStatistics;
		
	/****
	 * 商品评论数(当前型号商品)
	 */
	private String CurrCustomCommentCount;
	
	/****
	 * 好评(当前型号商品)
	 */
	private String CurrCustomGoodCount;
	/***
	 * 中评(当前型号商品)
	 * @return
	 */
	private String   CurrCustomeGeneralCount;
	
	/***
	 * 差评(当前型号商品)
	 * @return
	 */	
	private String CurrCustomPoorCount;
	
	/***
	 * 默认评论(用户没有评论,有系统自动默认的评论)(当前型号商品)
	 */
	private String CurrDefaultGoodCount;
	
	/***
	 * 好评率(当前型号商品)
	 * @return
	 */
	private String CurrCustomGoodRate;	
	/***
	 * 晒图评论(当前型号商品)
	 * @return
	 */
	private String  CurrCustomImageListCount;
	/***
	 * 热点评论(当前型号商品)
	 * @return
	 */
	private String CurrHotCommentTagStatistics;
		
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

	public String getCurrCustomCommentCount() {
		return CurrCustomCommentCount;
	}

	public void setCurrCustomCommentCount(String currCustomCommentCount) {
		CurrCustomCommentCount = currCustomCommentCount;
	}

	public String getCurrCustomGoodCount() {
		return CurrCustomGoodCount;
	}

	public void setCurrCustomGoodCount(String currCustomGoodCount) {
		CurrCustomGoodCount = currCustomGoodCount;
	}

	public String getCurrCustomeGeneralCount() {
		return CurrCustomeGeneralCount;
	}

	public void setCurrCustomeGeneralCount(String currCustomeGeneralCount) {
		CurrCustomeGeneralCount = currCustomeGeneralCount;
	}

	public String getCurrCustomPoorCount() {
		return CurrCustomPoorCount;
	}

	public void setCurrCustomPoorCount(String currCustomPoorCount) {
		CurrCustomPoorCount = currCustomPoorCount;
	}

	public String getCurrDefaultGoodCount() {
		return CurrDefaultGoodCount;
	}

	public void setCurrDefaultGoodCount(String currDefaultGoodCount) {
		CurrDefaultGoodCount = currDefaultGoodCount;
	}

	public String getCurrCustomGoodRate() {
		return CurrCustomGoodRate;
	}

	public void setCurrCustomGoodRate(String currCustomGoodRate) {
		CurrCustomGoodRate = currCustomGoodRate;
	}

	public String getCurrCustomImageListCount() {
		return CurrCustomImageListCount;
	}

	public void setCurrCustomImageListCount(String currCustomImageListCount) {
		CurrCustomImageListCount = currCustomImageListCount;
	}

	public String getCurrHotCommentTagStatistics() {
		return CurrHotCommentTagStatistics;
	}

	public void setCurrHotCommentTagStatistics(String currHotCommentTagStatistics) {
		CurrHotCommentTagStatistics = currHotCommentTagStatistics;
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

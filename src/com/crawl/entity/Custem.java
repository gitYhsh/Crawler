package com.crawl.entity;

import java.io.Serializable;

public class Custem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 390701803929381100L;
	
	/**
	 * 品牌名称Id--->jd的商品号
	 * **/
	private String  CustomeId;
	
	/**
	 * 品牌名称
	 * **/
	private String   BrandName;
	
	/**
	 * 商品名称
	 * **/
	private String CustomName;
	
	/**
	 * jd商品编号
	 * **/
	private String JdCudtomId;
	
	/**
	 * 显卡
	 * **/
	private String CustomGrap;
	
	/**
	 * 内存
	 * **/
	
	private String CustomMermy;
	
	/**
	 * 硬盘
	 * **/
	private String CustomHard;
	
	/**
	 * 屏幕尺寸
	 * **/
	private String CustomScreeSize;

	public String getCustomeId() {
		return CustomeId;
	}

	public void setCustomeId(String customeId) {
		CustomeId = customeId;
	}

	public String getBrandName() {
		return BrandName;
	}

	public void setBrandName(String brandName) {
		BrandName = brandName;
	}

	public String getCustomName() {
		return CustomName;
	}

	public void setCustomName(String customName) {
		CustomName = customName;
	}

	public String getJdCudtomId() {
		return JdCudtomId;
	}

	public void setJdCudtomId(String jdCudtomId) {
		JdCudtomId = jdCudtomId;
	}

	public String getCustomGrap() {
		return CustomGrap;
	}

	public void setCustomGrap(String customGrap) {
		CustomGrap = customGrap;
	}

	public String getCustomMermy() {
		return CustomMermy;
	}

	public void setCustomMermy(String customMermy) {
		CustomMermy = customMermy;
	}

	public String getCustomHard() {
		return CustomHard;
	}

	public void setCustomHard(String customHard) {
		CustomHard = customHard;
	}

	public String getCustomScreeSize() {
		return CustomScreeSize;
	}

	public void setCustomScreeSize(String customScreeSize) {
		CustomScreeSize = customScreeSize;
	}
	
	@Override
	public String toString() {
		return "Custem [CustomeId=" + CustomeId + ", BrandName=" + BrandName + ", CustomName=" + CustomName
				+ ", JdCudtomId=" + JdCudtomId + ", CustomGrap=" + CustomGrap + ", CustomMermy=" + CustomMermy
				+ ", CustomHard=" + CustomHard + ", CustomScreeSize=" + CustomScreeSize + "]";
	}


}

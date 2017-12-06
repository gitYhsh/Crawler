package com.crawl.entity;

import java.io.Serializable;

public class CustomVersion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 877228603031249545L;
	
	
	/***
	 * 所属母商品号Id
	 */
	private String MainCustomId;
	
	/****
	 * 当前商品的color
	 */
	private String CurrentCustomId;
	
	/****
	 * 所有商品颜色名称
	 */
	private String CustomVersion;
	
	
	public String getMainCustomId() {
		return MainCustomId;
	}

	public void setMainCustomId(String mainCustomId) {
		MainCustomId = mainCustomId;
	}

	public String getCurrentCustomId() {
		return CurrentCustomId;
	}

	public void setCurrentCustomId(String currentCustomId) {
		CurrentCustomId = currentCustomId;
	}

	public String getCustomVersion() {
		return CustomVersion;
	}

	public void setCustomVersion(String customVersion) {
		CustomVersion = customVersion;
	}

	@Override
	public String toString() {
		return "CustomVersion [MainCustomId=" + MainCustomId + ", CurrentCustomId=" + CurrentCustomId
				+ ", CustomVersion=" + CustomVersion + "]";
	}

}

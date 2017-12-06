package com.crawl.entity;

import java.io.Serializable;

public class CustomColor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1095560040139856080L;

	
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
	private String CustomColor;

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

	public String getCustomColor() {
		return CustomColor;
	}

	public void setCustomColor(String customColor) {
		CustomColor = customColor;
	}

	@Override
	public String toString() {
		return "CustomColor [MainCustomId=" + MainCustomId + ", CurrentCustomId=" + CurrentCustomId + ", CustomColor="
				+ CustomColor + "]";
	}
}

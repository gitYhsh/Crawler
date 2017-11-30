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

	@Override
	public String toString() {
		return "BaseInfo [BrandName=" + BrandName + ", CustomName=" + CustomName + ", CustomId=" + CustomId
				+ ", Weight=" + Weight + ", OrginPlace=" + OrginPlace + ", Price=" + Price + "]";
	}

	
	

}

package com.crawl.util;

import java.io.IOException;
import java.util.Properties;


/**
 * @author yhsh
 * @version 1.0
 * @since 2017-11-28
 * **/
public class Config {
	
	/**
		启用持久化存储
	**/
	public static boolean IsDbEnable;
	
	/**
	 * 最大线程
	 * **/
	public static Integer MaxThreadNum;
	
	/**
	 * 最大网页数量
	 * **/
	public static Integer MaxWebNum;
	
	/**
	 * 抓取入口JD
	 * **/
	public static String CrawlWebSite;
	
	/**
	 * 抓取入口TB
	 * **/
	
	/**
	 * 抓取深度
	 * **/
	public static Integer CrawlDepth;
	
	/**
	 * 存储位置
	 * **/
	public static  String StorePostion;
	
	/**
	 * 间隔时间
	 * **/
	public static Integer PotionNum;
	
	
	/**
	 * 数据库相关配置 驱动
	 * **/
	public static String DbHost;
	
	/**
	 * 数据库名称
	 * **/
	public static String DbName;
	
	/**
	 * 数据库用户名
	 * **/
	public static String UserName;
	
	/**
	 * 数据库的密码
	 * **/
	public static String password;
	
	
	 static {
        Properties p = new Properties();
        try {
            p.load(Config.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        MaxWebNum = Integer.valueOf(p.getProperty("MaxCrawlNum"));
        MaxThreadNum = Integer.valueOf(p.getProperty("MaxThreadNum"));
        CrawlWebSite = p.getProperty("CrawlWebSit");
        CrawlDepth = Integer.valueOf(p.getProperty("CrawlDepth"));
        StorePostion = p.getProperty("StorePos");
        PotionNum =Integer.valueOf(p.getProperty("PotionNum"));
        DbHost = p.getProperty("db.host");
        DbName = p.getProperty("db.name");
        UserName = p.getProperty("db.username");
        password = p.getProperty("db.password");
	 }
	
}

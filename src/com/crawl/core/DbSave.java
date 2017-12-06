package com.crawl.core;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.crawl.entity.BaseInfo;
import com.crawl.entity.CustomColor;
import com.crawl.entity.CustomVersion;
import com.crawl.util.ConnectionManager;


public class DbSave {
	
    private static Logger logger = LoggerFactory.getLogger(DbSave.class);
	
	 public synchronized static void insertData(BaseInfo info){
		 
		 try {
	            String column = "custom_id,brand_name,custom_name,custom_orgin,custom_weight,custom_price"
	            		+ ",custom_comment_count,custom_good_count,custome_general_count,"
	            		+ "custom_poor_count,default_good_count,custom_good_rate,"
	            		+ "custom_image_listcount,hot_comment_tag_Statistics,current_crawler_time";
	            
	            String values = "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
	            String sql = "insert into jdcustomdata (" + column + ") values(" +values+")";
	            PreparedStatement pstmt;
	            pstmt = ConnectionManager.getConnection().prepareStatement(sql);
	            
	            pstmt.setString(1, info.getCustomId());
	            pstmt.setString(2, info.getBrandName());
	            pstmt.setString(3, info.getCustomName());
	            pstmt.setString(4, info.getOrginPlace());
	            pstmt.setString(5, info.getWeight());
	            pstmt.setString(6, info.getPrice());
	            pstmt.setString(7, info.getCustomCommentCount());
	            pstmt.setString(8, info.getCustomGoodCount());
	            pstmt.setString(9, info.getCustomeGeneralCount());
	            pstmt.setString(10, info.getCustomPoorCount());
	            pstmt.setString(11, info.getDefaultGoodCount());
	            pstmt.setString(12, info.getCustomGoodRate());
	            pstmt.setString(13, info.getCustomImageListCount());
	            pstmt.setString(14, info.getHotCommentTagStatistics());
	            pstmt.setString(15, info.getCurrentTime());
	            System.out.println(pstmt);
	            pstmt.executeUpdate();
	            pstmt.close();
	            
	        } catch (SQLException e) {
	        	logger.error(e.toString());
	            e.printStackTrace();
	        } finally {
//	            ConnectionManager.close();
	        }
		 
	 }
	 
	 public synchronized static void insertColorData(CustomColor color){
		 
		 try {
	            String column = "main_custom_id,current_custom_id,custom_color";
	            
	            String values = "?,?,?";
	            String sql = "insert into jdcolordata (" + column + ") values(" +values+")";
	            PreparedStatement pstmt;
	            pstmt = ConnectionManager.getConnection().prepareStatement(sql);
	            
	            pstmt.setString(1, color.getMainCustomId());
	            pstmt.setString(2, color.getCurrentCustomId());
	            pstmt.setString(3, color.getCustomColor());
	           
	            System.out.println(pstmt);
	            pstmt.executeUpdate();
	            pstmt.close();
	            
	        } catch (SQLException e) {
	        	logger.error(e.toString());
	            e.printStackTrace();
	        } finally {
//	            ConnectionManager.close();
	        }
		 
	 }
	 
	 public synchronized static void insertVersionData(CustomVersion version){
		 
		 try {
	            String column = "main_custom_id,current_custom_id,custom_version";
	            
	            String values = "?,?,?";
	            String sql = "insert into jdversiondata (" + column + ") values(" +values+")";
	            PreparedStatement pstmt;
	            pstmt = ConnectionManager.getConnection().prepareStatement(sql);
	            
	            pstmt.setString(1, version.getMainCustomId());
	            pstmt.setString(2, version.getCurrentCustomId());
	            pstmt.setString(3, version.getCustomVersion());
	           
	            System.out.println(pstmt);
	            pstmt.executeUpdate();
	            pstmt.close();
	            
	        } catch (SQLException e) {
	        	logger.error(e.toString());
	            e.printStackTrace();
	        } finally {
//	            ConnectionManager.close();
	        }
		 
	 }
	 
	 //当前商品
	 public synchronized static void insertCurrentData(BaseInfo info){
		 
		 try {
	            String column = "curr_custom_id,curr_custom_comment_count,curr_custom_good_count,curr_custome_general_count,"
	            		+ "curr_custom_poor_count,curr_default_good_count,curr_custom_good_rate,curr_custom_image_listcount,"
	            		+ "curr_hot_comment_tag_Statistics,curr_current_crawler_time";
	            
	            String values = "?,?,?,?,?,?,?,?,?,?";
	            String sql = "insert into jdcurrentdata (" + column + ") values(" +values+")";
	            PreparedStatement pstmt;
	            pstmt = ConnectionManager.getConnection().prepareStatement(sql);
	            
	            pstmt.setString(1, info.getCustomId());
	            pstmt.setString(2, info.getCurrCustomCommentCount());
	            pstmt.setString(3, info.getCurrCustomGoodCount());
	            pstmt.setString(4, info.getCurrCustomeGeneralCount());
	            pstmt.setString(5, info.getCurrCustomPoorCount());
	            pstmt.setString(6, info.getCurrDefaultGoodCount());
	            pstmt.setString(7, info.getCurrCustomGoodRate());
	            pstmt.setString(8, info.getCurrCustomImageListCount());
	            pstmt.setString(9, info.getCurrHotCommentTagStatistics());
	            pstmt.setString(10, info.getCurrentTime());
	            
	           
	            System.out.println(pstmt);
	            pstmt.executeUpdate();
	            pstmt.close();
	            
	        } catch (SQLException e) {
	        	logger.error(e.toString());
	            e.printStackTrace();
	        } finally {
//	            ConnectionManager.close();
	        }
		 
	 }
}

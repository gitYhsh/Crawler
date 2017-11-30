package com.crawl.core;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.crawl.entity.BaseInfo;
import com.crawl.util.ConnectionManager;


public class DbSave {
	
    private static Logger logger = LoggerFactory.getLogger(DbSave.class);
	
	 public synchronized static void insertData(BaseInfo info){
		 
		 try {
	            String column = "custom_id,brand_name,custom_name,custom_orgin,custom_weight";
	            String values = "?,?,?,?,?";
	            String sql = "insert into data (" + column + ") values(" +values+")";
	            PreparedStatement pstmt;
	            pstmt = ConnectionManager.getConnection().prepareStatement(sql);
	            
	            pstmt.setString(1, info.getCustomId());
	            pstmt.setString(2, info.getBrandName());
	            pstmt.setString(3, info.getCustomName());
	            pstmt.setString(4, info.getOrginPlace());
	            pstmt.setString(5, info.getWeight());
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

package com.crawl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

public class ConnectionManager {
	private static Logger logger = LoggerFactory.getLogger(ConnectionManager.class);
	private static Connection conn;
	public static Connection getConnection(){
		//获取数据库连接
		try {
			if(conn == null || conn.isClosed()){
                conn = createConnection();
            }
            else{
                return conn;
            }
		} catch (SQLException e) {
			logger.error("SQLException",e);
		}
		return conn;
	}
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver") ;//加载驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	public static void close(){
		if(conn != null){
			logger.info("关闭连接中");
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static Connection createConnection(){
		String host = Config.DbHost;
		String user = Config.UserName;
		String password = Config.password;
		String dbName = Config.DbName;
		String url="jdbc:mysql://" + host + ":3306/" + dbName + "?characterEncoding=utf8";
		Connection con=null;
		try{
			con = DriverManager.getConnection(url,user,password);//建立mysql的连接
			
		} catch(MySQLSyntaxErrorException e){
			
			e.printStackTrace();
		} catch(SQLException e2){
			e2.printStackTrace();
		}
		return con;
	}
	
	public static void main(String [] args) throws Exception{
		getConnection();
		close();
	}
	
}

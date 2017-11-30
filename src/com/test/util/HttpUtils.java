package com.test.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class HttpUtils {
	
	public void get() {
			CloseableHttpClient httpclient = HttpClients.createDefault();  
		    try {  
		        // 创建httpget.    
		        HttpGet httpget = new HttpGet("https://s.taobao.com/search?initiative_id=tbindexz_20170306&ie=utf8&spm=a21bo.2017.201856-taobao-item.2&sourceId=tb.index&search_type=item&ssid=s5-e&commend=all&imgfile=&q=%E7%94%B5%E8%84%91&suggest=0_2&_input_charset=utf-8&wq=diannao&suggest_query=diannao&source=suggest");  
		        
		        System.out.println("executing request " + httpget.getURI());  
		        // 执行get请求.    
		        CloseableHttpResponse response = httpclient.execute(httpget);  
		       
		        try {  
		            // 获取响应实体    
		            HttpEntity entity = response.getEntity();  
		            System.out.println("--------------------------------------");  
		            // 打印响应状态    
		            System.out.println(response.getStatusLine());  
		            if (entity != null) {  
		                // 打印响应内容长度    
		                System.out.println("Response content length: " + entity.getContentLength());  
		                // 打印响应内容    
		                System.out.println("Response content: " + EntityUtils.toString(entity));  
		            }  
		            System.out.println("------------------------------------");  
		        } finally {  
		            response.close();  
		        }  
		    } catch (ClientProtocolException e) {  
		        e.printStackTrace();  
		    } catch (IOException e) {  
		        e.printStackTrace();  
		    } finally {  
		        // 关闭连接,释放资源    
		        try {  
		            httpclient.close();  
		        } catch (IOException e) {  
		            e.printStackTrace();  
		        }  
		    }  
		} 
}

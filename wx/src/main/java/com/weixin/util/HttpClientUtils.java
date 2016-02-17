package com.weixin.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientUtils {
              public  static String doGet(String url,Map<String,String> headers,Map<String,String> params){
            	  CloseableHttpClient  client =  HttpClientBuilder.create().build();
            	    HttpGet get = new HttpGet();
            	    if(headers==null){
            	   get.setHeader("Content-Type", "text/html;charset=utf-8");
            	    }else{
            	    	  for(String key:headers.keySet()){
            	    		    get.setHeader(key, headers.get(key));
            	    	  }
            	    }
            	    StringBuffer buffer = new StringBuffer(url);
            	    if(params!=null){
            	    	 buffer.append("?");
                 	    for(String key:params.keySet()){
         	    		     buffer.append(key).append("=").append(params.get(key)).append("&");
         	    	  }
                 	   if(buffer.lastIndexOf("&")!=-1){
                 		    buffer.deleteCharAt(buffer.lastIndexOf("&"));
                 	   }
            	    }
            	
            	   try {
					get.setURI(new URI(buffer.toString()));
					HttpResponse response = client.execute(get);
					return httpClientResponse(response);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						client.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
            	  return null;
              }
              
           
            public static String doPost(String url,Map<String,String> headers,Map<String,String> params,boolean isHttps){
             CloseableHttpClient  client =  isHttps?createSSLClientDefault():HttpClientBuilder.create().build();
           	    HttpPost post = new HttpPost(url);
           	    if(headers==null){
           	    	post.setHeader("Content-Type", "text/html;charset=utf-8");
           	    }else{
           	    	  for(String key:headers.keySet()){
           	    		post.setHeader(key, headers.get(key));
           	    	  }
           	    }
           	 List<NameValuePair> nvps = new ArrayList <NameValuePair>();  
        
             Set<String> keySet = params.keySet();  
             for(String key : keySet) {  
                 nvps.add(new BasicNameValuePair(key, params.get(key)));  
             }  
             try {
            	// UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvps, "UTF-8");
            	 HttpEntity entity=    EntityBuilder.create().setParameters(nvps).build();
            	  System.out.println(nvps.get(1).getValue());
            	 System.out.println(StringUtils.streamToStringReader(entity.getContent()));
				post.setEntity(entity);
				HttpResponse response  =client.execute(post);
				return httpClientResponse(response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}  
             return null;
            }
            
            private static String  httpClientResponse(HttpResponse response){
            	   InputStream is = null;
            	   BufferedReader reader =null;
            	 try {
    		        	StatusLine status = response.getStatusLine();
    		        	if(status.getStatusCode()==200){
    		        		 // 获取响应消息实体  
    		                HttpEntity entity = response.getEntity();  
    		                 is  = entity.getContent();
    		                reader = new BufferedReader(new InputStreamReader(is));
    		               StringBuffer buff= new StringBuffer();
    		               String s =null;
    		               while((s=reader.readLine())!=null){
    		            	   buff.append(s);
    		               }
    		               return buff.toString();
    		        	}
    				} catch (Exception e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				} finally {
    				 try {
    					 if(is!=null){
    						 is.close();
    					 }
 					if(reader!=null){
 						 reader.close();
 					}
 				} catch (IOException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
 				}
            	 
             	   return null;
            }
            
           public static String upload(String url,File file,Map<String,String> params,boolean isHttps ){
        	   CloseableHttpClient  client =  isHttps?createSSLClientDefault():isHttps?createSSLClientDefault():HttpClientBuilder.create().build();
          	    HttpPost post = new HttpPost(url);
          	  FileBody bin = new FileBody(file);  
          	MultipartEntityBuilder builder  = MultipartEntityBuilder.create();
        	Set<String> keySet = params.keySet();  
          	 for(String key : keySet) {  
             	builder.addTextBody(key, params.get(key));
             }  
          	 builder.addPart("media", bin);
            HttpEntity entity =  builder.build();
            post.setEntity(entity);
              try {
			  HttpResponse response = 	client.execute(post);
			  return httpClientResponse(response);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}finally {
				try {
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
             return null;
           }
           public static InputStream downLoad(String url,Map<String,String> params ){
        	   HttpClient  client =  HttpClients.createDefault();
       	    HttpGet get = new HttpGet();
       	   get.setHeader("Content-Type", "text/html;charset=utf-8");
       	    StringBuffer buffer = new StringBuffer(url);
       	    if(params!=null){
       	    	 buffer.append("?");
            	    for(String key:params.keySet()){
    	    		     buffer.append(key).append("=").append(params.get(key)).append("&");
    	    	  }
            	   if(buffer.lastIndexOf("&")!=-1){
            		    buffer.deleteCharAt(buffer.lastIndexOf("&"));
            	   }
       	    }
				try {
					get.setURI(new URI(buffer.toString()));
					HttpResponse response = client.execute(get);
					StatusLine status = response.getStatusLine();
		        	if(status.getStatusCode()==200){
		        		 // 获取响应消息实体  
		                HttpEntity entity = response.getEntity();    
					return entity.getContent();
		        	}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					
				}
				return null;
         
           }
           public static void main(String[] args) {
        	 /* File file= null;
		
				file = new File("C:\\Users\\angelwsin\\Downloads\\1418264418901.jpg");
			
        	   Map<String,String> params = new HashMap<String,String>();
        	   params.put("access_token", TokenService.acessToken());
        	   params.put("type", "image");
			   System.out.println(upload("https://api.weixin.qq.com/cgi-bin/media/upload", file, params,true));*/
        	   Map<String,String> params = new HashMap<String,String>();
        	   params.put("bankNum", "0321");
        	   params.put("userId", "owFQ-uBg7admIgc7wgcXzkiZa5Mk");
        	   params.put("sign", "N+YdEYPuuk2ef9WdjoiP9SpQpSnfs8u9MTvzBWib0cJqPo/60AZWeivzX8EElm6xLz/AVUgWGPLrspyWX8MAcrKWPHQh9pwquQWGyyPjSwIaFkbmE2Daitk5WI5ZBQdezq6Q17/E+gvqaOB9HTpCcoIq8X+eknJ0sKVW0vno6sE=");
        	   System.out.println(doPost("http://localhost:8080/wxhf/webHome.do?action=goHome", null,params , false));
        	
		}
           
           
           public static CloseableHttpClient createSSLClientDefault(){
        	   try {
        	                SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
        	                    //信任所有
        	                    public boolean isTrusted(X509Certificate[] chain,
        	                                    String authType) throws CertificateException {
        	                        return true;
        	                    }
        	                }).build();
        	                SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
        	                return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        	            } catch (KeyManagementException e) {
        	                e.printStackTrace();
        	            } catch (NoSuchAlgorithmException e) {
        	                e.printStackTrace();
        	            } catch (KeyStoreException e) {
        	                e.printStackTrace();
        	            }
        	            return  HttpClients.createDefault();
        	   }
}

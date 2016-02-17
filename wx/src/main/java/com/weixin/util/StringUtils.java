package com.weixin.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class StringUtils {
	
	  public static String Token ="angelwsin";
	public static boolean   wxCheckSignature(String signature,String  timestamp,String nonce,String token){
       /* if(isEmpty(signature)||isEmpty(timestamp)||isEmpty(nonce)||isEmpty(token)){
        	    throw new IllegalArgumentException("  参数 不正确");
        }*/
                String s[] = new String[]{timestamp,nonce,token};
                 Arrays.sort(s);
                 StringBuffer buff = new StringBuffer();
                   for(String str:s){
                   	   buff.append(str);
                   }
           if(signature.equals(SHA1.sha1(buff.toString()))){
           	return true;
           }
           return  false;
      }
	
	   public static boolean isEmpty(String s){
		              return s==null||s.length()==0;
	   }
	   
	   
	   public static String  streamToString(InputStream is)throws Exception{
		             byte[] b = new byte[1024];
		             StringBuffer buffer = new StringBuffer();
		             
		             int  index = -1;
		             while((index=is.read(b))!=-1){
		            	     buffer.append(new String(b, 0, index));
		             }
		             is.close();
		             return buffer.toString();
		             
		             
	   }
	   public static String  streamToStringReader(InputStream is)throws Exception{
         BufferedReader reader = new BufferedReader(new InputStreamReader(is));
           StringBuffer buffer = new StringBuffer();
           
           String   index = null;
           while((index=reader.readLine())!=null){
          	     buffer.append(index);
           }
           reader.close();
           is.close();
           return buffer.toString();
           
           
}

}

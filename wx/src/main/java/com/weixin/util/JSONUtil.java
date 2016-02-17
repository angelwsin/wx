package com.weixin.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class JSONUtil {
	
	
	 public static final String encode(Object object){
		
		 return JSON.toJSONString(object, new SerializerFeature[] { SerializerFeature.DisableCircularReferenceDetect });
	 }
	 public static final String encodePrettyFormat(Object object){
		 return JSON.toJSONString(object, new SerializerFeature[] {  SerializerFeature.PrettyFormat});
	 }
	 
	 public static <T> T getJsonT(String content,Class<T> clazz){
		    return   JSON.toJavaObject(JSON.parseObject(content), clazz);
	 }

}

package com.weixin.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.weixin.message.bean.WXMessage;
import com.weixin.message.bean.WXNewItmesMessage;
import com.weixin.message.bean.WXNewsRespMessage;
import com.weixin.message.bean.WXPicSysPhotoMessage;

public class WXMessageFactory {
	         public static Properties  MESSAGETYPE = new Properties();
	         public static final String XMLHEADER="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	       static{
	    	  InputStream is =  WXMessageFactory.class.getClassLoader().getResourceAsStream("MessageMap.properties");
	    	   try {
				MESSAGETYPE.load(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       }

	public static WXMessage getMessageInstance(InputStream is) {
		SAXReader reader = new SAXReader();
		BufferedReader r = null;
		StringBuffer buffer = null;
		try {
			r = new BufferedReader(new InputStreamReader(is));
			buffer = new StringBuffer(XMLHEADER);
			String t = null;
			while ((t = r.readLine()) != null) {
				buffer.append(t);
			}
			System.out.println(buffer.toString());
			Document doc = reader.read(new ByteArrayInputStream(buffer.toString().getBytes()));
			Element e = doc.getRootElement();
			String type = doc.selectSingleNode("/xml/MsgType").getText();
			Node node =  doc.selectSingleNode("/xml/Event");
			String event =node==null?"":"."+node.getText();
			e.setName(MESSAGETYPE.getProperty(type+event));
			XStream s = new XStream();
		Class<?> clazz = Class.forName(MESSAGETYPE.getProperty(type+event));
				// ClassLoader.class.getClassLoader().loadClass(MESSAGETYPE.getProperty(type+event));
		  listFields(clazz,s);
			WXMessage msg = (WXMessage) s.fromXML(e.asXML());
			is.close();
			r.close();
			return msg;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	
	public static <T>String getMessageToXml(T message,String[] alias, Class<?>[] clazz){
		     if(alias.length!=clazz.length){
		    	 throw new IllegalArgumentException("非法的参数");
		     }
		XStream s = new XStream();
		for(int i=0;i<alias.length;i++){
			s.alias(alias[i], clazz[i]);
		}
		return s.toXML(message);
	}
	public static <T>String getMessageToXml(T message, Class<?>[] clazz){
	   
	XStream s = new XStream();
	for(int i=0;i<clazz.length;i++){
		s.processAnnotations(clazz[i]);
	}
	return s.toXML(message);
}
	
	public static <T>String getMessageToXmlDefault(T message){
		     return getMessageToXml(message,new String[]{"xml"},new Class<?>[]{message.getClass()});
	}
	
	public static String getgetMessageToXmlWXNews(WXNewsRespMessage message){
		return getMessageToXml(message,new String[]{"xml","item"} ,new Class<?>[]{WXNewsRespMessage.class,WXNewItmesMessage.class});
	}
	
	public  static void listFields(Class<?> clazz,XStream s){
		  Field[] fields = clazz.getDeclaredFields();
		    if(fields.length==0){
		    	  return ;
		    }
		     for(int i=0;i<fields.length;i++){
		    	 if(fields[i].getType()==List.class){
		    		 ParameterizedType pt = (ParameterizedType) fields[i].getGenericType() ;
		    		 Class<?> clz = (Class<?>) pt.getActualTypeArguments()[0];
		    		 s.processAnnotations(clz);
		    	 }
		    	 listFields(fields[i].getType(),s);
		     }
		 
	}

	         public static void main(String[] args) throws Exception{
				
			/*	FileInputStream is = new FileInputStream("d:\\message.txt");
					  WXPicSysPhotoMessage msg =  (WXPicSysPhotoMessage) getMessageInstance(is);
					 System.out.println(msg.getSendPicsInfo().getPicList().get(0).getPicMd5Sum());*/
				   /*WXSendPicsInfoItem item1= new WXSendPicsInfoItem();
				   item1.setPicMd5Sum("0989ds");
				   WXSendPicsInfoItem item2= new WXSendPicsInfoItem();
				   item1.setPicMd5Sum("0989ds");
				   WXSendPicsInfoItems items1 = new WXSendPicsInfoItems();
				   WXSendPicsInfoItems items2 = new WXSendPicsInfoItems();
				   List<WXSendPicsInfoItem> items = new ArrayList<WXSendPicsInfoItem>();
				   items1.setItem(item1);
				   items2.setItem(item2);
				   items.add(item1);
				   items.add(item2);
				   WXSendPicsInfo info  = new WXSendPicsInfo();
				   info.setCount(2);
				   info.setPicList(items);
				   WXPicSysPhotoMessage msg1  = new WXPicSysPhotoMessage();
				   msg1.setSendPicsInfo(info);
				   System.out.println(getMessageToXml(msg1,new Class[]{WXSendPicsInfoItem.class}));*/
	        	 
	        	 WXNewsRespMessage resp = new WXNewsRespMessage();
	        	 resp.setArticleCount(1);
	        	 resp.setCreateTime(System.currentTimeMillis());
	        	 resp.setFromUserName("00");
	        	 resp.setMsgType("000");
	        	 resp.setToUserName("000");
	        	 WXNewItmesMessage nes = new WXNewItmesMessage();
	        	 nes.setDescription("000");
	        	 nes.setPicUrl("oood");
	        	 nes.setTitle("000");
	        	 nes.setUrl("999");
	        	 resp.addNewItmes(nes);
	        	   System.out.println(getgetMessageToXmlWXNews(resp));
	        	 
			}

}

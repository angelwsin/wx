package com.weixin.message.bean;

public class WXLocationEventMessage extends WXBaseEventMessage{
	/*Latitude	地理位置纬度
	Longitude	地理位置经度
	Precision	地理位置精度*/
	
	private  double Latitude;
	private double Longitude;
	private double Precision;
	public double getLatitude() {
		return Latitude;
	}
	public void setLatitude(double latitude) {
		Latitude = latitude;
	}
	public double getLongitude() {
		return Longitude;
	}
	public void setLongitude(double longitude) {
		Longitude = longitude;
	}
	public double getPrecision() {
		return Precision;
	}
	public void setPrecision(double precision) {
		Precision = precision;
	}
	
}

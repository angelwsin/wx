package com.weixin.message.bean;

public class WXSendLocationInfo {
	/*Location_X 	X坐标信息
	Location_Y 	Y坐标信息
	Scale 	精度，可理解为精度或者比例尺、越精细的话 scale越高
	Label 	地理位置的字符串信息
	Poiname 	朋友圈POI的名字，可能为空 */
	private double Location_X ;
	private double Location_Y;
	private String Scale;
	private String Label;
	private String Poiname;
	public double getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(double location_X) {
		Location_X = location_X;
	}
	public double getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(double location_Y) {
		Location_Y = location_Y;
	}
	public String getScale() {
		return Scale;
	}
	public void setScale(String scale) {
		Scale = scale;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	public String getPoiname() {
		return Poiname;
	}
	public void setPoiname(String poiname) {
		Poiname = poiname;
	}
	
	
}

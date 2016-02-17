package com.weixin.message.bean;

public class WXScanCodeInfo {
	/*ScanType 	扫描类型，一般是qrcode
	ScanResult 	扫描结果，即二维码对应的字符串信息 
*/
	private  String ScanType;
	private String ScanResult;
	public String getScanType() {
		return ScanType;
	}
	public void setScanType(String scanType) {
		ScanType = scanType;
	}
	public String getScanResult() {
		return ScanResult;
	}
	public void setScanResult(String scanResult) {
		ScanResult = scanResult;
	}
	
}

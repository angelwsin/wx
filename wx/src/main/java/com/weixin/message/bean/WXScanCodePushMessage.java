package com.weixin.message.bean;

public class WXScanCodePushMessage extends WXBaseEventMessage{
	/*ScanCodeInfo 	扫描信息
	ScanType 	扫描类型，一般是qrcode
	ScanResult 	扫描结果，即二维码对应的字符串信息 */
	private WXScanCodeInfo ScanCodeInfo;

	public WXScanCodeInfo getScanCodeInfo() {
		return ScanCodeInfo;
	}

	public void setScanCodeInfo(WXScanCodeInfo scanCodeInfo) {
		ScanCodeInfo = scanCodeInfo;
	}
	
	
	
	
}

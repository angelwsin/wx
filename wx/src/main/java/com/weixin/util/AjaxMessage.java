package com.weixin.util;


public class AjaxMessage {

		/** 响应状态，如果为"OK"则表示验证通过 */
		private String status;
		/** 提示消息，如果不为空则前台表单验证将提示该消息内容 */
		private String message;
		/** 备注信息 */
		private String remark;
		/** 回调函数的方法名称(例如:"refresh")，如果不为空则执行前台对应名称的回调函数 */
		private String callback;
		/** 跳转的URL，如果不为空，则跳转到对应的URL */
		private String url;
		private Object content;// 返回给IOS和Android的消息内容

		public AjaxMessage() {
		}

		public AjaxMessage(String message) {
			this.message = message;
		}

		public AjaxMessage(String message, String url) {
			this.message = message;
			this.url = url;
		}

		public AjaxMessage(String status, String message, String url) {
			this.status = status;
			this.message = message;
			this.url = url;
		}

		public AjaxMessage(String status, String message, String url, String callback) {
			this.status = status;
			this.message = message;
			this.url = url;
			this.callback = callback;
		}

		public String getStatus() {
			return status;
		}

		public AjaxMessage setStatus(String status) {
			this.status = status;
			return this;
		}

		public String getMessage() {
			return message;
		}

		public AjaxMessage setMessage(String message) {
			this.message = message;
			return this;
		}

		public String getCallback() {
			return callback;
		}

		public AjaxMessage setCallback(String callback) {
			this.callback = callback;
			return this;
		}

		public String getUrl() {
			return url;
		}

		public AjaxMessage setMessageAndCallback(String message, String callback) {
			this.message = message;
			this.callback = callback;
			return this;
		}

		public AjaxMessage setUrl(String url) {
			this.url = url;
			return this;
		}

		public String getRemark() {
			return remark;
		}

		public AjaxMessage setRemark(String remark) {
			this.remark = remark;
			return this;
		}

		public Object getContent() {
			return content;
		}

		public AjaxMessage setContent(Object content) {
			this.content = content;
			return this;
		}
}

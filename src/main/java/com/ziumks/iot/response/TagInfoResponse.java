package com.ziumks.iot.response;


public class TagInfoResponse {

	private String responseCode;
	private String responseMessage;
	private Object data;
	private TagInfoPageInfo pageInfo;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public TagInfoPageInfo getPageInfo() {
		return pageInfo;
	}
	public void setPageInfo(TagInfoPageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
}

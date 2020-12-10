package com.ziumks.iot.domain;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class SizeInfo implements Serializable{
	
	private static final long serialVersionUID = -4599939193176359668L;
	
	@Expose
	private String height;
	@Expose
	private String width;
	
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	
}

package com.ziumks.iot.domain;

import java.io.Serializable;

import com.google.gson.annotations.Expose;

public class PositionInfo implements Serializable{
	
	private static final long serialVersionUID = -3384729864168471445L;
	
	@Expose
	private String x;
	@Expose
	private String y;
	
	
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	
	
	
}

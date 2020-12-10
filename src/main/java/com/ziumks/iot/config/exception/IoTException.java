package com.ziumks.iot.config.exception;

//@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Not Found") //404
public class IoTException extends Exception {

	private static final long serialVersionUID = -4448927125683333257L;
	
	private String errorCode;
	
	public IoTException (String errCode, String errMessage){
		super(errMessage);
		this.errorCode = errCode;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}

package com.sarthak.restfult.webservices.social.media.centralizedExceptionHandling;

import java.time.LocalDateTime;

public class ErrorDetails {
	
	private LocalDateTime timestamp;
	
	private String errMsg;
	
	private String errDesc;

	public ErrorDetails() {
		super();
	}

	public ErrorDetails(LocalDateTime timestamp, String errMsg, String errDesc) {
		super();
		this.timestamp = timestamp;
		this.errMsg = errMsg;
		this.errDesc = errDesc;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrDesc() {
		return errDesc;
	}

	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}

	@Override
	public String toString() {
		return "ErrorDetails [timestamp=" + timestamp + ", errMsg=" + errMsg + ", errDesc=" + errDesc + "]";
	}
	
	

}

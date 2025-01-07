package com.project.main.Exception;

import org.springframework.stereotype.Component;

@Component
public class EmptyException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorName;
	
	
	public EmptyException(String errorCode, String errorName) {
		super();
		this.errorCode = errorCode;
		this.errorName = errorName;
	}
	public EmptyException() {
		super();
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorName() {
		return errorName;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
	
	
}

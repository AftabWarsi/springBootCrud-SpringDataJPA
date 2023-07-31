package com.luv2code.springBootDemo.springBootCrud3.exception;

public class ControllerException {

	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -3462634010876025851L;
	private String errorCode;
	private String errorMassege;

	public ControllerException() {
		super();
	}

	public ControllerException(String errorCode, String errorMassege) {
		super();
		this.errorCode = errorCode;
		this.errorMassege = errorMassege;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMassege() {
		return errorMassege;
	}

	public void setErrorMassege(String errorMassege) {
		this.errorMassege = errorMassege;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

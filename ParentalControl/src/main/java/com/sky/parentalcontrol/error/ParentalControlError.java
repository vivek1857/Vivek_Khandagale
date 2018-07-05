package com.sky.parentalcontrol.error;

public class ParentalControlError {

	private String error;
	private String errorMessage;
	
	public ParentalControlError(String error, String errorMessage) {
		this.error = error;
		this.errorMessage = errorMessage;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}

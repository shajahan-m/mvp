package com.mvp.error;

/**
 * pojo class for error codes.
 * @author techversant
 * @version 1.0
 * @since 2023
 */
public class ErrorCodes {

	private ErrorCodes() {

	}
	
	public static final int SUCCESS = 0;
	public static final int INVALID = 1;
	public static final int UPDATE_FAILED = 2;
	public static final int INSERT_FAILED = 3;
	public static final int NOT_FOUND = 4;
	public static final int API_ERROR = 5;
	
}

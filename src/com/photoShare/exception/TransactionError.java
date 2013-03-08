/**
 * 
 */
package com.photoShare.exception;

/**
 * @author Administrator
 *
 */
public class TransactionError extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	/** 错误码：参数为空 */
	public static final int ERROR_CODE_NULL_PARAMETER = -1;

	/** 错误码：参数超出了限制 <br> */
	public static final int ERROR_CODE_PARAMETER_EXTENDS_LIMIT = -2;

	/** 错误码：非法参数 */
	public static final int ERROR_CODE_ILLEGAL_PARAMETER = -3;

	/** 错误码：无法解析服务器响应字符串 */
	public static final int ERROR_CODE_UNABLE_PARSE_RESPONSE = -5;

	/** 错误码：未知错误 */
	public static final int ERROR_CODE_UNKNOWN_ERROR = -9;

	/** */
	public static final int ERROR_CODE_LOG_ERROR = -13;
	
	public static final int ERROR_CODE_GET_FOLLOW_INFO = -20;
	
	public static final int ERROR_CODE_START_FOLLOWING_SOMEONE = -27;
	
	public static final int ERROR_CODE_NO_LIKE_ITEMS = -42;
	
	public static final int ERROR_CODE_START_SHARING_PHOTOS = -56;
	
	public static final String ERROR_CODE = "error_code";
	
	public static final String ERROR_MESSAGE = "error_msg";
	
	public static final int ERROR_CODE_NO_COMMENTS = -88;
	/**
	 * 
	 */
	private int errorCode;

	/** 原始响应URL */
	private String orgRuntimeError;

	public TransactionError(){
		
	}
	
	public TransactionError(int errorCode){
		this.errorCode = errorCode;
	}
	
	public TransactionError(String errorMessage){
		super(errorMessage);
	}
	
	public TransactionError(int errorCode, String errorMessage){
		super(errorMessage);
		this.errorCode = errorCode;
	}
	
	public TransactionError(int errorCode, String errorMessage, String orgRuntimeError){
		super(errorMessage);
		this.errorCode = errorCode;
		this.orgRuntimeError = orgRuntimeError;
	}
	@Override
	public String toString() {
		return "errorCode:" + this.errorCode + "\nerrorMessage:"
				+ this.getMessage() + "\norgResponse:" + this.orgRuntimeError;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getOrgRuntimeError() {
		return orgRuntimeError;
	}

	public void setOrgRuntimeError(String orgRuntimeError) {
		this.orgRuntimeError = orgRuntimeError;
	}
	
	
	
}

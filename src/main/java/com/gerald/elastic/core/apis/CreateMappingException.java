package com.gerald.elastic.core.apis;

/**
 * 所有创建失败异常
 *
 */
public class CreateMappingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8847539986722721581L;

	public CreateMappingException(String message) {
		super(message);
	}
	
	public CreateMappingException(String message, Exception e) {
		super(message, e);
	}
}

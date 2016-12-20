package com.gerald.elastic.core.apis;

/**
 * 映射删除异常
 *
 */
public class DropMappingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3081653885284340498L;

	public DropMappingException(String message) {
		super(message);
	}
	
	public DropMappingException(String message, Exception e) {
		super(message, e);
	}
}

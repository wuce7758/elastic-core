package com.gerald.elastic.core.apis.exceptions;

/**
 * 所有创建失败异常
 *
 */
public class CreateIndexException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8847539986722721581L;

	public CreateIndexException(String index, String failMessage) {
		super("index = " + index + ", fail reason = " + failMessage);
	}
}

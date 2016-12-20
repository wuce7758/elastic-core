package com.gerald.elastic.core.apis;

public class DeleteDocException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6535925661251755418L;

	private Object id;
	
	public DeleteDocException(Object id, String message) {
		super("id = " + id + ", failure = " + message);
		
		this.id = id;
	}
	
	public Object getId() {
		return id;
	}
}

package com.gerald.elastic.core.meta.data.exception;

public class ConflictTypeConfig extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3675393293255860461L;

	private Class<?> entity1;
	
	private Class<?> entity2;
	
	public ConflictTypeConfig(Class<?> entity1, Class<?> entity2) {
		super("entity1 = " + entity1.getName() + ", entity2 = " + entity2.getName());
		
		this.entity1 = entity1;
		this.entity2 = entity2;
	}

	public Class<?> getEntity1() {
		return entity1;
	}

	public Class<?> getEntity2() {
		return entity2;
	}
}

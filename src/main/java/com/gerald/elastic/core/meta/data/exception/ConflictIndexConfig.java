package com.gerald.elastic.core.meta.data.exception;

public class ConflictIndexConfig extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1068554901153663245L;

	private Class<?> configSource1;
	
	private Class<?> configSource2;
	
	public ConflictIndexConfig(Class<?> configSource1, Class<?> configSource2) {
		super("configuration1 = " + configSource1.getName() + ", configuration2 = " + configSource2.getName());
		this.configSource1 = configSource1;
		this.configSource2 = configSource2;
	}

	public Class<?> getConfigSource1() {
		return configSource1;
	}

	public Class<?> getConfigSource2() {
		return configSource2;
	}
}

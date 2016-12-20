package com.gerald.elastic.core.annotations.defs;

public enum StringNullValue {
	NULL(null),
	EMPTY("");
	
	private String value;
	
	private StringNullValue(String value) {
		this.value = value;
	} 
	
	public String getValue() {
		return value;
	}
}

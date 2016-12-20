package com.gerald.elastic.core.annotations.defs;

public enum BooleanValue {
	TRUE(true),
	FALSE(false),
	NULL(null)
	;
	
	private Boolean value;
	
	private BooleanValue(Boolean value) {
		this.value = value;
	}
	
	public Boolean getValue() {
		return value;
	}
}

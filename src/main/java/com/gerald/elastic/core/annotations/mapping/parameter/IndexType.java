package com.gerald.elastic.core.annotations.mapping.parameter;

/**
 * 字段归档类型
 *
 */
public enum IndexType {
	/**
	 * 字段不可查询 
	 */
	NO("no"),
	/**
	 * 字段可查询，但是不会被analyzer解析
	 */
	NOT_ANALYZED("not_analyzed"),
	/**
	 * 字段可查询，并且会被analyzer解析。只能用于string类型
	 */
	ANALYZED("analyzed")
	;
	
	private String type;
	
	private IndexType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}

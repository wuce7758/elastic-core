package com.gerald.elastic.core.annotations.mapping.parameter;

public enum IndexOptions {
	/**
	 * 只会记录文档编号。因此只可查询一个文档是否包含一个短语
	 */
	DOCS("docs"),
	/**
	 * 记录文档编号和文档中短语出现的次数。次数越多，字段对短语的匹配性越高
	 */
	FREQS("freqs"),
	/**
	 * 记录文档编号、短语次数、短语位置。可用于proximity和phrase查询
	 */
	POSITIONS("positions"),
	/**
	 * 记录文档编号、短语次数、短语位置、起始/终止字符位置。可用于highlight
	 */
	OFFSET("offsets")
	;
	
	private String option;
	
	private IndexOptions(String option) {
		this.option = option;
	}
	
	public String getOption() {
		return option;
	}
}

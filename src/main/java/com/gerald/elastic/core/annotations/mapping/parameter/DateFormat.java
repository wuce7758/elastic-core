package com.gerald.elastic.core.annotations.mapping.parameter;

public enum DateFormat {
	/**
	 * 时间的毫秒表示，
	 */
	EPOCH_MILLIS("epoch_millis"),
	/**
	 * 数据库兼容格式，例如1970-01-01 01:05:30
	 */
	DB_FORMAT("strict_date_hour_minute_second");
	
	private String format;
	
	private DateFormat(String format) {
		this.format = format;
	}
	
	public String getFormat() {
		return format;
	}
}

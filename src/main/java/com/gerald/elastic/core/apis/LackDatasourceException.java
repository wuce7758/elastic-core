package com.gerald.elastic.core.apis;

/**
 * 数据模型没有配置数据源
 *
 */
public class LackDatasourceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8393244897268388988L;
	
	private Class<?> clazz;
	
	public LackDatasourceException(Class<?> clazz) {
		super("[" + clazz.getName() + "]" + " does not specify a data source");
		this.clazz = clazz;
	}
	
	public Class<?> getClazz() {
		return clazz;
	}
}

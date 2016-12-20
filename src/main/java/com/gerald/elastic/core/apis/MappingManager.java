package com.gerald.elastic.core.apis;

/**
 * 数据模型映射管理器
 *
 */
public interface MappingManager {
	/**
	 * 检测映射是否已经存在
	 * 
	 * @param clazz
	 * 			数据模型class
	 */
	void isModelMappingExisted(Class<? extends SearchModel<?>> clazz);
	
	/**
	 * 检测数据模型和映射是否匹配
	 * 
	 * @param clazz
	 */
	boolean isModelMappingMatching(Class<? extends SearchModel<?>> clazz);
	
	/**
	 * 创建映射
	 * 
	 * @param clazz
	 * 			数据模型class
	 * 
	 * @throws CreateMappingException 如果映射创建失败
	 */
	void createModelMapping(Class<? extends SearchModel<?>> clazz);
	
	/**
	 * 删除映射。同时会删除数据
	 * 
	 * @param clazz
	 * 			数据模型class
	 * 
	 * @throws DropMappingException 如果删除映射失败
	 */
	void dropModelMapping(Class<? extends SearchModel<?>> clazz);
}

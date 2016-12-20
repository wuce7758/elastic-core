package com.gerald.elastic.core.apis.index;

import java.util.Collection;

import com.gerald.elastic.core.apis.exceptions.CreateIndexException;
import com.gerald.elastic.core.apis.exceptions.DropMappingException;

/**
 * 数据模型映射管理器
 *
 */
public interface IndexManager {
	/**
	 * 获得所有配置的Index
	 * 
	 * @return 所有配置的index
	 */
	Collection<String> allIndices();
	
	/**
	 * 检测index是否已经创建
	 * 
	 * @param index
	 * 			index名字
	 */
	void isIndexCreated(String index);
	
	/**
	 * 检测index映射和定义是否一致
	 * 
	 * @param index
	 * 			index名字
	 */
	boolean isIndexMappingMatching(String index);
	
	/**
	 * 创建映射
	 * 
	 * @param index
	 * 			index名字
	 * 
	 * @throws CreateIndexException 如果映射创建失败
	 */
	void createIndex(String index);
	
	/**
	 * 删除映射。同时会删除数据
	 * 
	 * @param index
	 * 			index名字
	 * 
	 * @throws DropMappingException 如果删除映射失败
	 */
	void dropIndex(String index);
}

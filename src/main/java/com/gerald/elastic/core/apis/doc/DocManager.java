package com.gerald.elastic.core.apis.doc;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import com.gerald.elastic.core.apis.exceptions.LackDatasourceException;
import com.gerald.elastic.core.apis.exceptions.SyncDatasourceException;
import com.gerald.elastic.core.apis.type.SearchModel;

public interface DocManager {
	/**
	 * 根据数据模型id更新搜索数据。会使用数据模型指定的数据源获得数据
	 * 
	 * @param clazz
	 * 			数据模型
	 * @param id
	 * 			id
	 * 
	 * @throws LackDatasourceException 如果数据模型没有配置数据源
	 */
	void update(Class<? extends SearchModel<?>> clazz, Object id);
	
	/**
	 * 使用指定对象更新搜索数据
	 * 
	 * @param model
	 * 			数据模型对象
	 * 
	 */
	void update(SearchModel<?> model);
	
	/**
	 * 使用map中的<字段-数据>对部分更新搜索数据。map中不包含的字段不会被更新
	 * 
	 * @param clazz
	 * 			数据模型
	 * @param map
	 * 			<字段-数据>字典
	 * 
	 * @throws IllegalArgumentException 如果map的字段与数据模型不匹配
	 */
	void partialUpdate(Class<? extends SearchModel<?>> clazz, Map<String, Object> map);
	
	/**
	 * 使用指定对象部分更新搜索数据。根据元数据，忽略对象中可忽略的字段
	 * 
	 * @param model
	 * 			数据模型对象
	 * 
	 */
	void partialUpdate(SearchModel<?> model);
	
	/**
	 * 删除搜索数据
	 * 
	 * @param clazz
	 * 			数据模型
	 * @param id
	 * 			id
	 * 
	 */
	void delete(Class<? extends SearchModel<?>> clazz, Object id);
	
	/**
	 * 批量更新。会使用数据模型指定的数据源获得数据
	 * 
	 * @param clazz
	 * 			数据模型
	 * @param ids
	 * 			id数组
	 * 
	 */
	void batchUpdate(Class<? extends SearchModel<?>> clazz, Object... ids);
	
	/**
	 * 批量更新
	 * 
	 * @param models
	 * 			数据模型对象
	 */
	void batchUpdate(Collection<SearchModel<?>> models);
	
	/**
	 * 批量部分更新
	 * 
	 * @param clazz
	 * 			数据模型
	 * @param maps
	 * 			数据对象集合
	 * 
	 * @throws IllegalArgumentException 如果map的字段与数据模型不匹配
	 */
	void batchPartialUpdate(Class<? extends SearchModel<?>> clazz, Collection<Map<String, Object>> maps);
	
	/**
	 * 批量部分更新
	 * 
	 * @param models
	 * 			数据模型对象集合
	 */
	void batchPartialUpdate(Collection<SearchModel<?>> models);
	
	/**
	 * 批量删除
	 * 
	 * @param clazz
	 * 			数据模型
	 * @param ids
	 * 			id数组
	 */
	void batchDelete(Class<? extends SearchModel<?>> clazz, Object... ids);
	
	/**
	 * 同步数据源。会使用数据模型指定的数据源获得数据
	 * 
	 * @param clazz
	 * 			数据模型class
	 * @param start
	 * 			开始时间
	 * @param end
	 * 			结束时间
	 * 
	 * @throws LackDatasourceException 如果数据模型没有配置数据源
	 * @throws SyncDatasourceException 数据源同步失败
	 */
	void sync(Class<? extends SearchModel<?>> clazz, Date start, Date end);
}

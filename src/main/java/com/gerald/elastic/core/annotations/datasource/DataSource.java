package com.gerald.elastic.core.annotations.datasource;

import java.util.Date;
import java.util.Iterator;

/**
 * Elastic Search model数据源
 *
 * @param <T>
 * 			search model数据类型
 * @param <D>
 * 			id类型
 * 
 */
public interface DataSource<T,D> {
	/**
	 * 获得指定id的数据
	 * 
	 * @param id
	 * 			数据模型id
	 * 
	 * @return 数据模型
	 */
	T getItem(D id);
	
	/**
	 * 获得指定时间段的数据
	 * 
	 * @param start
	 * 			开始时间
	 * @param end
	 * 			结束时间
	 * 
	 * @return 指定时间段的数据模型迭代器
	 */
	Iterator<T> getItems(Date start, Date end);
	
	/**
	 * 获得一组id对应的数据模型
	 * 
	 * @param ids
	 * 			数据模型id
	 * 
	 * @return 数据模型迭代器
	 */
	Iterator<T> getItems(D... ids);
}

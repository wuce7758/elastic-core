package com.gerald.elastic.core.annotations.mapping.parameter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.gerald.elastic.core.annotations.defs.StringNullValue;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.LOCAL_VARIABLE)
public @interface SubStringType {
	/**
	 * 归档analyzer名称。空串表示null。归档analyzer的搜索规则是
	 * (1) 使用此配置，如果为null，则
	 * (2) 使用index analyzer，如果为null，则
	 * (3) 使用standard analyzer
	 * 
	 * @return 归档analyzer名称，默认为空
	 */
	String analyzer() default "";
	
	/**
	 * 评分权重。默认为1，一般不用更改
	 * 
	 * @return 评分权重
	 */
	double boost() default 1;
	
	/**
	 * 是否启用sorting/aggregation/scripting功能。默认启用，一般不用更改
	 * 
	 * @return true，启用；false，不启用
	 */
	boolean docValues() default true;
	
	/**
	 * 字段归档类型。默认是IndexType.ANALYZED
	 * 
	 * @return 字段归档类型
	 */
	IndexType index() default IndexType.ANALYZED;
	
	/**
	 * null替换值。默认是Null，可配置为空串
	 * 
	 * @return null替换值
	 */
	StringNullValue nullValue() default StringNullValue.NULL;
	
	/**
	 * 归档字符串数组时，在数组成员间插入虚假的term，避免短语查询跨成员成立
	 * 
	 * @return 虚假term的数量，默认是100
	 */
	int positionIncrementGap() default 100;
	
	/**
	 * 查询时，解析字段的analyzer。查询analyzer的搜索规则是
	 * (1) 使用full-text query中指定的analyzer
	 * (2) 使用该字段的配置
	 * (3) 使用analyzer字段的配置
	 * (4) 使用index配置的default_search
	 * (5) 使用index的default配置
	 * (6) 使用standard analyzer
	 * 
	 * @return search anaylzer配置。默认是空值，表示null
	 */
	String searchAnalyzer() default "";
}

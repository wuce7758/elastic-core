package com.gerald.elastic.core.annotations.types;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.gerald.elastic.core.annotations.defs.BooleanValue;
import com.gerald.elastic.core.annotations.handlers.extractors.types.BooleanExtractor;
import com.gerald.elastic.core.annotations.mapping.parameter.IndexType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@TypeMapping(javaType = Boolean.class, elasticType = "boolean", extractor = BooleanExtractor.class)
public @interface BooleanType {
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
	 * 字段归档类型。接受IndexType.NO或者IndexType.NOT_ANALYZED。默认是IndexType.NOT_ANALYZED
	 * 
	 * @return 字段归档类型
	 */
	IndexType index() default IndexType.NOT_ANALYZED;
	
	/**
	 * null的替换值。默认是BooleanNullValue.NULL，一般不用更改
	 * 
	 * @return null的替换值
	 */
	BooleanValue nullValue() default BooleanValue.NULL;
}

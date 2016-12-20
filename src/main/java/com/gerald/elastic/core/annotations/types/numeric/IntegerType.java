package com.gerald.elastic.core.annotations.types.numeric;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.gerald.elastic.core.annotations.handlers.extractors.types.numeric.IntegerExtractor;
import com.gerald.elastic.core.annotations.mapping.parameter.IndexType;
import com.gerald.elastic.core.annotations.types.TypeMapping;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@TypeMapping(javaType = Integer.class, elasticType = "integer", extractor = IntegerExtractor.class)
public @interface IntegerType {
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
	 * null替换值。如果是空串，表示null；其他值，将被转换为Integer，转换失败，将抛出IllegalArgumentException
	 * 
	 * @return null替换值
	 */
	String nullValue() default "";
}

package com.gerald.elastic.core.annotations.types;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.gerald.elastic.core.annotations.handlers.extractors.types.GeoPointExtractor;
import com.gerald.elastic.core.type.GeoPoint;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@TypeMapping(javaType = GeoPoint.class, elasticType = "geo_point", extractor = GeoPointExtractor.class)
public @interface GeoPointType {
	/**
	 * 对不在经/纬度不在[-180:180]/[-90:90]范围内的数值执行规范化。默认为false，错误的数值将被拒绝，导致归档失败
	 * 
	 * @return true，规范化；false，不规范化
	 */
	boolean coerce() default false;
	
	/**
	 * 是否启用sorting/aggregation/scripting功能。默认启用，一般不用更改
	 * 
	 * @return true，启用；false，不启用
	 */
	boolean docValues() default true;
}

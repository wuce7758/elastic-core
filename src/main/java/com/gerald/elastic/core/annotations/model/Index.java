package com.gerald.elastic.core.annotations.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Index {
	/**
	 * Index的名字，不能为空
	 * 
	 * @return Index的名字
	 */
	String name();
	
	/**
	 * index配置
	 * 
	 * @return index配置
	 */
	IndexSettings settings() default @IndexSettings;
}

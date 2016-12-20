package com.gerald.elastic.core.annotations.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Mapping {
	/**
	 * 当前类型的parent。parent和child必须具有相同的index。默认情况下，没有parent
	 * 
	 * @return 当前类型的parent
	 */
	String parent() default "";
	
	/**
	 * type名称。不能为空
	 * 
	 * @return type名称
	 */
	String type();
	
	/**
	 * index名字。不能为空
	 * 
	 * @return index名字
	 */
	String index();
}

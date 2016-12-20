package com.gerald.elastic.core.annotations.mapping.parameter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.LOCAL_VARIABLE)
public @interface FieldItem {
	/**
	 * 子映射的类型名字
	 * 
	 * @return 子映射的类型名字
	 */
	String subName();
	
	SubStringType mappingInfo();
}

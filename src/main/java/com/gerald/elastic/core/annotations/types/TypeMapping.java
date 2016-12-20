package com.gerald.elastic.core.annotations.types;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.gerald.elastic.core.annotations.handlers.extractors.types.FieldExtractor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface TypeMapping {
	Class<?> javaType();
	
	String elasticType();
	
	Class<? extends FieldExtractor<?>> extractor();
}

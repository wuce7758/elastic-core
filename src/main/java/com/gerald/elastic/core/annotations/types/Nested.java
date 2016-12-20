package com.gerald.elastic.core.annotations.types;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.gerald.elastic.core.annotations.handlers.extractors.types.NestedExtractor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@TypeMapping(javaType = Object.class, elasticType = "nested", extractor = NestedExtractor.class)
public @interface Nested {

}

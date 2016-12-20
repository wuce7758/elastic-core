package com.gerald.elastic.core.annotations.types;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.gerald.elastic.core.annotations.handlers.extractors.types.EmbeddedExtractor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@TypeMapping(javaType = Object.class, elasticType = "object", extractor = EmbeddedExtractor.class)
public @interface Embedded {

}

package com.gerald.elastic.core.annotations.handlers.extractors.types;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.gerald.elastic.core.annotations.handlers.models.FieldModel;

public interface FieldExtractor<T> {
	public FieldModel<T> extract(Annotation annotation, Class<?> javaType, Field field);
}

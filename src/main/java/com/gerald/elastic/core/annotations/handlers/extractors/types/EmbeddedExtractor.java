package com.gerald.elastic.core.annotations.handlers.extractors.types;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.gerald.elastic.core.annotations.handlers.exceptions.TypeMismatchException;
import com.gerald.elastic.core.annotations.handlers.models.DocType;
import com.gerald.elastic.core.annotations.handlers.models.FieldModel;
import com.gerald.elastic.core.annotations.types.Embeddable;
import com.gerald.elastic.core.util.ReflectionUtil;

public class EmbeddedExtractor implements FieldExtractor<Object> {

	@Override
	public FieldModel<Object> extract(Annotation annotation, Class<?> javaType, Field field) {
		if(!isValidJavaType(javaType)) {
			throw new TypeMismatchException(field);
		}
		
		return FieldModel.Builder.<Object>newInstance(javaType, DocType.OBJECT).build();
	}
	
	private boolean isValidJavaType(Class<?> javaType) {
		return ReflectionUtil.getAnnotation(javaType, Embeddable.class) != null;
	}

}

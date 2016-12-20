package com.gerald.elastic.core.annotations.handlers.extractors.types;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gerald.elastic.core.annotations.handlers.exceptions.TypeMismatchException;
import com.gerald.elastic.core.annotations.handlers.extractors.types.util.FieldLoggingUtil;
import com.gerald.elastic.core.annotations.handlers.models.DocType;
import com.gerald.elastic.core.annotations.handlers.models.FieldModel;
import com.gerald.elastic.core.annotations.types.Embeddable;
import com.gerald.elastic.core.util.ReflectionUtil;

public class EmbeddedExtractor implements FieldExtractor<Object> {
	private static final Logger logger = LogManager.getLogger(EmbeddedExtractor.class);

	@Override
	public FieldModel<Object> extract(Annotation annotation, Class<?> javaType, Field field) {
		if(!isValidJavaType(javaType)) {
			throw new TypeMismatchException(field);
		}
		
		FieldModel<Object> model = FieldModel.Builder.<Object>newInstance(javaType, DocType.OBJECT).build();
		
		FieldLoggingUtil.debug(model, field, logger);
		
		return model;
	}
	
	private boolean isValidJavaType(Class<?> javaType) {
		return ReflectionUtil.getAnnotation(javaType, Embeddable.class) != null;
	}

}

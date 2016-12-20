package com.gerald.elastic.core.annotations.handlers.extractors.types;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.gerald.elastic.core.annotations.handlers.exceptions.TypeMismatchException;
import com.gerald.elastic.core.annotations.handlers.models.DocType;
import com.gerald.elastic.core.annotations.handlers.models.FieldModel;
import com.gerald.elastic.core.annotations.types.BooleanType;

public class BooleanExtractor implements FieldExtractor<Boolean> {

	@Override
	public FieldModel<Boolean> extract(Annotation annotation, Class<?> javaType, Field field) {
		if(javaType != Boolean.class) {
			throw new TypeMismatchException(field);
		}
		
		BooleanType booleanType = (BooleanType)annotation;
		
		return FieldModel.Builder.newInstance(Boolean.class, DocType.BOOLEAN)
										.setBoost(booleanType.boost())
										.setIndexType(booleanType.index())
										.setDocValues(booleanType.docValues())
										.setNullValue(booleanType.nullValue().getValue())
										.build();
	}
}

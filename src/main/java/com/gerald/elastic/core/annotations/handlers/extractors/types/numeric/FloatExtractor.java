package com.gerald.elastic.core.annotations.handlers.extractors.types.numeric;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.commons.lang.StringUtils;

import com.gerald.elastic.core.annotations.handlers.exceptions.TypeMismatchException;
import com.gerald.elastic.core.annotations.handlers.extractors.types.FieldExtractor;
import com.gerald.elastic.core.annotations.handlers.models.DocType;
import com.gerald.elastic.core.annotations.handlers.models.FieldModel;
import com.gerald.elastic.core.annotations.types.numeric.FloatType;

public class FloatExtractor implements FieldExtractor<Float> {

	@Override
	public FieldModel<Float> extract(Annotation annotation, Class<?> javaType,
			Field field) {
		if(Float.class != javaType) {
			throw new TypeMismatchException(field);
		}
		
		FloatType type = (FloatType)annotation;
		
		Float nullValue = null;
		if(StringUtils.isNotEmpty(type.nullValue())) {
			nullValue = Float.valueOf(type.nullValue());
		}
		
		return FieldModel.Builder.newInstance(Float.class, DocType.FLOAT)
									.setBoost(type.boost())
									.setDocValues(type.docValues())
									.setIndexType(type.index())
									.setNullValue(nullValue)
									.build();
	}

}

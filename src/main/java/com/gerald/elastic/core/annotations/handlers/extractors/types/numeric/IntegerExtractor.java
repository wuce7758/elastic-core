package com.gerald.elastic.core.annotations.handlers.extractors.types.numeric;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.commons.lang.StringUtils;

import com.gerald.elastic.core.annotations.handlers.exceptions.TypeMismatchException;
import com.gerald.elastic.core.annotations.handlers.extractors.types.FieldExtractor;
import com.gerald.elastic.core.annotations.handlers.models.DocType;
import com.gerald.elastic.core.annotations.handlers.models.FieldModel;
import com.gerald.elastic.core.annotations.types.numeric.IntegerType;

public class IntegerExtractor implements FieldExtractor<Integer> {

	@Override
	public FieldModel<Integer> extract(Annotation annotation,
			Class<?> javaType, Field field) {
		if(Integer.class != javaType) {
			throw new TypeMismatchException(field);
		}
		
		IntegerType type = (IntegerType)annotation;
		
		Integer nullValue = null;
		if(StringUtils.isNotEmpty(type.nullValue())) {
			nullValue = Integer.valueOf(type.nullValue());
		}
		
		return FieldModel.Builder.newInstance(Integer.class, DocType.INTEGER)
									.setBoost(type.boost())
									.setDocValues(type.docValues())
									.setIndexType(type.index())
									.setNullValue(nullValue)
									.build();
	}

}

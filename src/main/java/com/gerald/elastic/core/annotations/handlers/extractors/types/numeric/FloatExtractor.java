package com.gerald.elastic.core.annotations.handlers.extractors.types.numeric;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gerald.elastic.core.annotations.handlers.exceptions.TypeMismatchException;
import com.gerald.elastic.core.annotations.handlers.extractors.types.FieldExtractor;
import com.gerald.elastic.core.annotations.handlers.extractors.types.util.FieldLoggingUtil;
import com.gerald.elastic.core.annotations.handlers.models.DocType;
import com.gerald.elastic.core.annotations.handlers.models.FieldModel;
import com.gerald.elastic.core.annotations.types.numeric.FloatType;

public class FloatExtractor implements FieldExtractor<Float> {
	private static final Logger logger = LogManager.getLogger(FloatExtractor.class);

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
		
		FieldModel<Float> model = FieldModel.Builder.newInstance(Float.class, DocType.FLOAT)
														.setBoost(type.boost())
														.setDocValues(type.docValues())
														.setIndexType(type.index())
														.setNullValue(nullValue)
														.build();
		
		FieldLoggingUtil.debug(model, field, logger);
		
		return model;
	}

}

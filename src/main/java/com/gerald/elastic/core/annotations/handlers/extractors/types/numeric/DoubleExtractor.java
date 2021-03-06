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
import com.gerald.elastic.core.annotations.types.numeric.DoubleType;

public class DoubleExtractor implements FieldExtractor<Double> {
	private static final Logger logger = LogManager.getLogger(DoubleExtractor.class);

	@Override
	public FieldModel<Double> extract(Annotation annotation, Class<?> javaType,
			Field field) {
		if(Double.class != javaType) {
			throw new TypeMismatchException(field);
		}
		
		DoubleType type = (DoubleType)annotation;
		
		Double nullValue = null;
		if(StringUtils.isNotEmpty(type.nullValue())) {
			nullValue = Double.valueOf(type.nullValue());
		}
		
		FieldModel<Double> model = FieldModel.Builder.newInstance(Double.class, DocType.DOUBLE)
														.setBoost(type.boost())
														.setDocValues(type.docValues())
														.setIndexType(type.index())
														.setNullValue(nullValue)
														.build();
		
		FieldLoggingUtil.debug(model, field, logger);
		
		return model;
	}

}

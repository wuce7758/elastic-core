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
import com.gerald.elastic.core.annotations.types.numeric.LongType;

public class LongExtractor implements FieldExtractor<Long> {
	private static final Logger logger = LogManager.getLogger(LongExtractor.class);
	
	@Override
	public FieldModel<Long> extract(Annotation annotation, Class<?> javaType,
			Field field) {
		if(Long.class != javaType) {
			throw new TypeMismatchException(field);
		}
		
		LongType type = (LongType)annotation;
		
		Long nullValue = null;
		if(StringUtils.isNotEmpty(type.nullValue())) {
			nullValue = Long.valueOf(type.nullValue());
		}
		
		FieldModel<Long> model = FieldModel.Builder.newInstance(Long.class, DocType.LONG)
														.setBoost(type.boost())
														.setDocValues(type.docValues())
														.setIndexType(type.index())
														.setNullValue(nullValue)
														.build();
		
		FieldLoggingUtil.debug(model, field, logger);
		
		return model;
	}

}

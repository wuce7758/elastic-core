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
import com.gerald.elastic.core.annotations.types.numeric.ShortType;

public class ShortExtractor implements FieldExtractor<Short> {
	private static final Logger logger = LogManager.getLogger(ShortExtractor.class);

	@Override
	public FieldModel<Short> extract(Annotation annotation, Class<?> javaType,
			Field field) {
		if(Short.class != javaType) {
			throw new TypeMismatchException(field);
		}
		
		ShortType type = (ShortType)annotation;
		
		Short nullValue = null;
		if(StringUtils.isNotEmpty(type.nullValue())) {
			nullValue = Short.valueOf(type.nullValue());
		}
		
		FieldModel<Short> model = FieldModel.Builder.newInstance(Short.class, DocType.SHORT)
														.setBoost(type.boost())
														.setDocValues(type.docValues())
														.setIndexType(type.index())
														.setNullValue(nullValue)
														.build();
		
		FieldLoggingUtil.debug(model, field, logger);
		
		return model;
	}

}

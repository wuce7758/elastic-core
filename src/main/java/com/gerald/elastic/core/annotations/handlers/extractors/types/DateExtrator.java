package com.gerald.elastic.core.annotations.handlers.extractors.types;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gerald.elastic.core.annotations.handlers.exceptions.TypeMismatchException;
import com.gerald.elastic.core.annotations.handlers.extractors.types.util.FieldLoggingUtil;
import com.gerald.elastic.core.annotations.handlers.models.DocType;
import com.gerald.elastic.core.annotations.handlers.models.FieldModel;
import com.gerald.elastic.core.annotations.types.DateType;

public class DateExtrator implements FieldExtractor<Date> {
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static final Logger logger = LogManager.getLogger(DateExtrator.class);

	@SuppressWarnings("unchecked")
	@Override
	public FieldModel<Date> extract(Annotation annotation, Class<?> javaType, Field field) {
		if(!Date.class.isAssignableFrom(javaType)) {
			throw new TypeMismatchException(field);
		}
		
		DateType type = (DateType)annotation;
		
		Date nullValue = null;
		try {
			if(!StringUtils.isEmpty(type.nullValue())) {
				nullValue = FORMAT.parse(type.nullValue());
			}
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		
		FieldModel<Date> model = FieldModel.Builder.<Date>newInstance((Class<? extends Date>)javaType, DocType.DATE)
															 .setBoost(type.boost())
															 .setDocValues(type.docValues())
															 .setIndexType(type.index())
															 .setNullValue(nullValue)
															 .build();
		
		FieldLoggingUtil.debug(model, field, logger);
		
		return model;
	}
}

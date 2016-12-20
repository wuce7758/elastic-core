package com.gerald.elastic.core.annotations.handlers.extractors.types;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gerald.elastic.core.annotations.handlers.exceptions.TypeMismatchException;
import com.gerald.elastic.core.annotations.handlers.extractors.types.util.FieldLoggingUtil;
import com.gerald.elastic.core.annotations.handlers.models.DocType;
import com.gerald.elastic.core.annotations.handlers.models.FieldModel;
import com.gerald.elastic.core.annotations.types.BooleanType;

public class BooleanExtractor implements FieldExtractor<Boolean> {
	private static final Logger logger = LogManager.getLogger(BooleanExtractor.class);

	@Override
	public FieldModel<Boolean> extract(Annotation annotation, Class<?> javaType, Field field) {
		if(javaType != Boolean.class) {
			throw new TypeMismatchException(field);
		}
		
		BooleanType booleanType = (BooleanType)annotation;
		
		FieldModel<Boolean> model = FieldModel.Builder.newInstance(Boolean.class, DocType.BOOLEAN)
															.setBoost(booleanType.boost())
															.setIndexType(booleanType.index())
															.setDocValues(booleanType.docValues())
															.setNullValue(booleanType.nullValue().getValue())
															.build();
		
		FieldLoggingUtil.debug(model, field, logger);
		
		return model;
	}
}

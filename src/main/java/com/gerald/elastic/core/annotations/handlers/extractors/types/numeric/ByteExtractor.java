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
import com.gerald.elastic.core.annotations.types.numeric.ByteType;

public class ByteExtractor implements FieldExtractor<Byte> {
	private static final Logger logger = LogManager.getLogger(ByteExtractor.class);

	@Override
	public FieldModel<Byte> extract(Annotation annotation, Class<?> javaType,
			Field field) {
		if(Byte.class != javaType) {
			throw new TypeMismatchException(field);
		}
		
		ByteType type = (ByteType)annotation;
		
		Byte nullValue = null;
		if(StringUtils.isNotEmpty(type.nullValue())) {
			nullValue = Byte.valueOf(type.nullValue());
		}
		
		FieldModel<Byte> model = FieldModel.Builder.newInstance(Byte.class, DocType.BYTE)
														.setBoost(type.boost())
														.setDocValues(type.docValues())
														.setIndexType(type.index())
														.setNullValue(nullValue)
														.build();
		FieldLoggingUtil.debug(model, field, logger);
		
		return model;
	}

}

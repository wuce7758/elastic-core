package com.gerald.elastic.core.annotations.handlers.extractors.types.numeric;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.commons.lang.StringUtils;

import com.gerald.elastic.core.annotations.handlers.exceptions.TypeMismatchException;
import com.gerald.elastic.core.annotations.handlers.extractors.types.FieldExtractor;
import com.gerald.elastic.core.annotations.handlers.models.DocType;
import com.gerald.elastic.core.annotations.handlers.models.FieldModel;
import com.gerald.elastic.core.annotations.types.numeric.ByteType;

public class ByteExtractor implements FieldExtractor<Byte> {

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
		
		return FieldModel.Builder.newInstance(Byte.class, DocType.BYTE)
									.setBoost(type.boost())
									.setDocValues(type.docValues())
									.setIndexType(type.index())
									.setNullValue(nullValue)
									.build();
	}

}

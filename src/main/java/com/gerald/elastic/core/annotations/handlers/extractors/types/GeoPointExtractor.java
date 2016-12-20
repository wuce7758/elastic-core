package com.gerald.elastic.core.annotations.handlers.extractors.types;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gerald.elastic.core.annotations.handlers.exceptions.TypeMismatchException;
import com.gerald.elastic.core.annotations.handlers.extractors.types.util.FieldLoggingUtil;
import com.gerald.elastic.core.annotations.handlers.models.DocType;
import com.gerald.elastic.core.annotations.handlers.models.FieldModel;
import com.gerald.elastic.core.annotations.types.GeoPointType;
import com.gerald.elastic.core.type.GeoPoint;

public class GeoPointExtractor implements FieldExtractor<GeoPoint> {
	private static final Logger logger = LogManager.getLogger(GeoPointExtractor.class);

	@SuppressWarnings("unchecked")
	@Override
	public FieldModel<GeoPoint> extract(Annotation annotation,
			Class<?> javaType, Field field) {
		if(!GeoPoint.class.isAssignableFrom(javaType)) {
			throw new TypeMismatchException(field);
		}
		
		GeoPointType type = (GeoPointType)annotation;
		
		FieldModel<GeoPoint> model = FieldModel.Builder.<GeoPoint>newInstance((Class<? extends GeoPoint>)javaType, DocType.GEO_POINT)
																	.setCoerce(type.coerce())
																	.setDocValues(type.docValues())
																	.build();
		FieldLoggingUtil.debug(model, field, logger);
		
		return model;
	}

}

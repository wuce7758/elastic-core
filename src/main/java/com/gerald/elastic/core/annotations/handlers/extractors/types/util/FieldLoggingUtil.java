package com.gerald.elastic.core.annotations.handlers.extractors.types.util;

import java.lang.reflect.Field;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gerald.elastic.core.annotations.handlers.models.FieldModel;
import com.gerald.elastic.core.annotations.handlers.models.TypeWrapper;
import com.gerald.elastic.core.util.ReflectionUtil;

public class FieldLoggingUtil {	
	private static final Logger logger = LogManager.getLogger(FieldLoggingUtil.class);
	
	private FieldLoggingUtil() {
		throw new AssertionError();
	}
	
	private static String logMsg(FieldModel<?> fieldModel, Field field) {		
		StringBuilder builder = new StringBuilder();
		
		builder.append("field = " + field.getName());
		builder.append(", java_type = " + fieldModel.getJavaType());
		builder.append(", doc_type = " + fieldModel.getDocType());
		for(Field f : ReflectionUtil.getAllFields(fieldModel.getClass())) {
			f.setAccessible(true);
			if(f.getType() == TypeWrapper.class) {
				try {
					TypeWrapper<?> wrapper = (TypeWrapper<?>)f.get(fieldModel);
					if((wrapper != null) && !wrapper.isIgnored()) {
						builder.append(", " + f.getName() + " = " + wrapper.value());
					}
				} catch(Exception e) {
					logger.error(e);
				}
			}
		}
		
		return builder.toString();
	}
	
	public static void debug(FieldModel<?> fieldModel, Field field, Logger logger) {
		if(logger.getLevel().compareTo(Level.DEBUG) > 0) {
			return;
		}
		
		logger.debug(logMsg(fieldModel, field));
	}
}

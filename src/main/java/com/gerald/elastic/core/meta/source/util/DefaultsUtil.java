package com.gerald.elastic.core.meta.source.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.gerald.elastic.core.annotations.types.BooleanType;
import com.gerald.elastic.core.annotations.types.DateType;
import com.gerald.elastic.core.annotations.types.Embedded;
import com.gerald.elastic.core.annotations.types.GeoPointType;
import com.gerald.elastic.core.annotations.types.StringType;
import com.gerald.elastic.core.annotations.types.numeric.ByteType;
import com.gerald.elastic.core.annotations.types.numeric.DoubleType;
import com.gerald.elastic.core.annotations.types.numeric.FloatType;
import com.gerald.elastic.core.annotations.types.numeric.IntegerType;
import com.gerald.elastic.core.annotations.types.numeric.LongType;
import com.gerald.elastic.core.annotations.types.numeric.ShortType;
import com.gerald.elastic.core.type.GeoPoint;
import com.gerald.elastic.core.util.ReflectionUtil;

public class DefaultsUtil {
	private DefaultsUtil() {
		throw new AssertionError("cannot instantiate");
	}
	
	private static class Defaults {
		@BooleanType
		private Boolean booleanDefault;
		
		@DateType
		private Date dateDefault;
		
		@GeoPointType
		private GeoPoint geoPointDefault;

		@StringType
		private String stringDefault;
		
		@ByteType
		private Byte byteDefault;
		
		@DoubleType
		private Double doubleDefault;
		
		@FloatType
		private Float floatDefault;
		
		@IntegerType
		private Integer integerDefault;
		
		@LongType
		private Long longDefault;
		
		@ShortType
		private Short shortDefault;
		
		@Embedded
		private static Object objectDefault;
	}
	
	private static final Map<Class<?>, Annotation> DEFAULTS_MAP = new HashMap<Class<?>, Annotation>();
	
	private static Annotation objDefault;
	
	static {
		Field[] fields = ReflectionUtil.getAllFields(Defaults.class);
		
		for(Field field : fields) {
			Annotation annotation = field.getAnnotations()[0];
			DEFAULTS_MAP.put(field.getType(), annotation);
		}
		
		objDefault = DEFAULTS_MAP.get(Object.class);
		DEFAULTS_MAP.remove(Object.class);
	}
	
	public static Annotation getDefault(Class<?> clazz) {
		Annotation annotation = DEFAULTS_MAP.get(clazz);
		
		if(annotation == null) {
			return objDefault;
		} else {
			return annotation;
		}
	}
}

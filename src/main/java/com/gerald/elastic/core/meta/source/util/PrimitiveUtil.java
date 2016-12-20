package com.gerald.elastic.core.meta.source.util;

import java.util.HashMap;
import java.util.Map;

public class PrimitiveUtil {
	private PrimitiveUtil() {
		throw new AssertionError();
	}
	
	private static final Map<Class<?>, Class<?>> PRIMITIVE_MAP = new HashMap<Class<?>, Class<?>>();
	
	static {
		PRIMITIVE_MAP.put(boolean.class, Boolean.class);
		PRIMITIVE_MAP.put(byte.class, Byte.class);
		PRIMITIVE_MAP.put(short.class, Short.class);
		PRIMITIVE_MAP.put(int.class, Integer.class);
		PRIMITIVE_MAP.put(long.class, Long.class);
		PRIMITIVE_MAP.put(float.class, Float.class);
		PRIMITIVE_MAP.put(double.class, Double.class);
	}
	
	public static Class<?> convertPrimitive(Class<?> clazz) {
		if(clazz.isPrimitive()) {
			return PRIMITIVE_MAP.get(clazz);
		} else {
			return clazz;
		}
	}
}

package com.gerald.elastic.core.annotations.handlers.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ReflectionUtil {
	public static Annotation[] getAnnotations(Class<?> clazz, Class<? extends Annotation> annotation) {
		return clazz.getAnnotationsByType(annotation);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Annotation> T getAnnotation(Class<?> clazz, Class<T> annotation) {
		T[] annotations = (T[])getAnnotations(clazz, annotation);
		if(annotations.length == 0) {
			return null;
		}
		
		return annotations[0];
	}
	
	public static <T extends Annotation> T getAnnotation(Field field, Class<T> annotation) {
		T[] annotations = (T[])field.getAnnotationsByType(annotation);
		
		if(annotations.length == 0) {
			return null;
		}
		
		return annotations[0];
	}
	
	public static Annotation[] getOnesAnnotatedBy(Field field, Class<? extends Annotation> annotation) {
		List<Annotation> list = new ArrayList<Annotation>();
		
		Annotation[] all = field.getAnnotations();
		for(Annotation a : all) {
			if(a.getClass().getAnnotation(annotation) != null) {
				list.add(a);
			}
		}
		
		return list.toArray(new Annotation[] {});
	}
	
	public static Method[] getMethodsByName(Class<?> clazz, String name) {
		List<Method> list = new ArrayList<Method>();
		
		for(Method method : clazz.getMethods()) {
			if(method.getName().equals(name)) {
				list.add(method);
			}
		}
		
		return list.toArray(new Method[] {});
	}
}

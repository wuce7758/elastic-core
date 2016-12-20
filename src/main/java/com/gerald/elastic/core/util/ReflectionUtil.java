package com.gerald.elastic.core.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReflectionUtil {	
	public static <T extends Annotation> T getAnnotation(Class<?> clazz, Class<T> annotation) {
		return clazz.getAnnotation(annotation);
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
			System.out.print(method.getName());
			if(method.getName().equals(name)) {
				list.add(method);
			}
		}
		
		return list.toArray(new Method[] {});
	}
	
	public static Field[] getAllFields(Class<?> clazz) {
		List<Field> all = new ArrayList<Field>();
		
		addFields(clazz, all);
		
		return all.toArray(new Field[] {});
	}
	
	private static void addFields(Class<?> clazz, List<Field> all) {
		Collections.addAll(all, clazz.getDeclaredFields());
		
		if(clazz.getSuperclass() == Object.class) {
			return;
		}
		
		addFields(clazz.getSuperclass(), all);
	}
	
	public static <T> T newInstanceByDefaultConstructor(Class<T> clazz) {
		try {
			return clazz.getConstructor().newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String getFieldFullName(Field field) {
		return field.getDeclaringClass().getName() + "." + field.getName();
	}
}

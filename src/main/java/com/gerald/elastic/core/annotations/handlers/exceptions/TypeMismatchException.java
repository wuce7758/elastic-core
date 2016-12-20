package com.gerald.elastic.core.annotations.handlers.exceptions;

import java.lang.reflect.Field;

public class TypeMismatchException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5607568364637966080L;
	
	private Field field;

	public TypeMismatchException(Field field) {
		super("field = " + field.getDeclaringClass().getName() + field.getName());
		this.field = field;
	}
	
	public Field getField() {
		return field;
	}
}

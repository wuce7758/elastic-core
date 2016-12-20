package com.gerald.elastic.core.annotations.handlers.exceptions;

import java.lang.reflect.Field;

import com.gerald.elastic.core.util.ReflectionUtil;

public class MultipleTypeMappingException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4983342873817561380L;
	
	private Field field;

	public MultipleTypeMappingException(Field field) {
		super("field = " + ReflectionUtil.getFieldFullName(field));
		
		this.field = field;
	}
	
	public Field getField() {
		return field;
	}
}

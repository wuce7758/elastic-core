package com.gerald.elastic.core.annotations.handlers.exceptions;

import java.lang.reflect.Field;

import com.gerald.elastic.core.util.ReflectionUtil;

public class DuplicatedSubField extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5814595132162433850L;
	
	private Field field;

	public DuplicatedSubField(Field field) {
		super("field = " + ReflectionUtil.getFieldFullName(field));
		this.field = field;
	}
	
	public Field getField() {
		return field;
	}
}

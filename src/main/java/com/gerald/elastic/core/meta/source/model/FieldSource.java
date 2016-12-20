package com.gerald.elastic.core.meta.source.model;

import java.lang.reflect.Field;

import com.gerald.elastic.core.annotations.bridge.DataBridge;
import com.gerald.elastic.core.annotations.handlers.models.FieldModel;

public class FieldSource<T> {
	private FieldModel<T> model;
	
	private DataBridge<T,?> bridge; 
	
	private Field field;
	
	public FieldSource(FieldModel<T> model, DataBridge<T,?> bridge, Field field) {
		this.model = model;
		this.bridge = bridge;
		this.field = field;
	}

	public FieldModel<T> getModel() {
		return model;
	}

	public DataBridge<T, ?> getBridge() {
		return bridge;
	}

	public Field getField() {
		return field;
	}
}

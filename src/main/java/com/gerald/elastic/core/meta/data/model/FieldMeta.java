package com.gerald.elastic.core.meta.data.model;

import java.lang.reflect.Field;

import com.gerald.elastic.core.annotations.bridge.DataBridge;
import com.gerald.elastic.core.annotations.handlers.models.DocType;
import com.gerald.elastic.core.meta.source.model.FieldSource;

public class FieldMeta<T> {
	private FieldSource<T> source;
	
	private MappingMeta mapping;
	
	public FieldMeta(FieldSource<T> source, MappingMeta mapping) {
		this.source = source;
		this.mapping = mapping;
	}
	
	public MappingMeta getMapping() {
		return mapping;
	}
	
	public Field getField() {
		return source.getField();
	}
	
	public String getFieldName() {
		return getField().getName();
	}
	
	public DataBridge<T,?> getBridge() {
		return source.getBridge();
	}
	
	public Class<?> getJavaType() {
		return source.getModel().getJavaType();
	}
	
	DocType getDocType() {
		return source.getModel().getDocType();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof FieldMeta)) {
			return false;
		}
		
		FieldMeta<?> another = (FieldMeta<?>)obj;
		
		return getField().equals(another.getField());
	}
	
	@Override
	public int hashCode() {
		return getField().hashCode();
	}
	
	@Override
	public String toString() {
		return "[" + getFieldName() + "]" + "java type" + getJavaType() + ", mapped as " + getDocType().getDocType();
	}
}

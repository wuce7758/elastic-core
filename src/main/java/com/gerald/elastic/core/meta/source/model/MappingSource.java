package com.gerald.elastic.core.meta.source.model;

import java.util.ArrayList;
import java.util.List;

public class MappingSource {
	private TypeSource typeSource;
	
	private List<FieldSource<?>> fields =  new ArrayList<FieldSource<?>>();
	
	public MappingSource(TypeSource typeSource) {
		if(typeSource == null) {
			throw new NullPointerException();
		}
		
		this.typeSource = typeSource;
	}
	
	public List<FieldSource<?>> getFields() {
		return fields;
	}

	public TypeSource getTypeSource() {
		return typeSource;
	}
}

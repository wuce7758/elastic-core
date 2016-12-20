package com.gerald.elastic.core.meta.source.model;

import com.gerald.elastic.core.annotations.handlers.models.TypeModel;

public class TypeSource {
	private TypeModel model;
	
	private Class<?> source;
	
	public TypeSource(TypeModel model, Class<?> typeSource) {
		if((model == null) || (typeSource == null)) {
			throw new NullPointerException();
		}
		
		this.model = model;
		
		this.source = typeSource;
	}

	public TypeModel getModel() {
		return model;
	}

	public Class<?> getSource() {
		return source;
	}
}

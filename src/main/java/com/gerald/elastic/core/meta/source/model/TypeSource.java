package com.gerald.elastic.core.meta.source.model;

import com.gerald.elastic.core.annotations.datasource.DataSource;
import com.gerald.elastic.core.annotations.handlers.models.TypeModel;
import com.gerald.elastic.core.util.ReflectionUtil;

public class TypeSource {
	private TypeModel model;
	
	private Class<?> source;
	
	private DataSource<?, ?> dataSource;
	
	public TypeSource(TypeModel model, Class<?> typeSource) {
		if((model == null) || (typeSource == null)) {
			throw new NullPointerException();
		}
		
		this.model = model;
		
		dataSource = ReflectionUtil.newInstanceByDefaultConstructor(model.getDatasourceClazz());
		
		this.source = typeSource;
	}

	public TypeModel getModel() {
		return model;
	}

	public Class<?> getSource() {
		return source;
	}

	public DataSource<?, ?> getDataSource() {
		return dataSource;
	}
}

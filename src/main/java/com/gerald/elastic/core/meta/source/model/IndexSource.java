package com.gerald.elastic.core.meta.source.model;

import com.gerald.elastic.core.annotations.handlers.models.IndexModel;

public class IndexSource {	
	private IndexModel model;
	
	private Class<?> configureSource;
	
	public IndexSource(IndexModel indexModel, Class<?> configureSource) {
		this.model = indexModel;
		this.configureSource = configureSource;
	}

	public IndexModel getModel() {
		return model;
	}

	public Class<?> getConfigureSource() {
		return configureSource;
	}
}

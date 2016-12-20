package com.gerald.elastic.core.meta.data.exception;

import com.gerald.elastic.core.meta.data.model.MappingMeta;

public class IndexNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6860617925834868099L;
	
	private MappingMeta mapping;

	public IndexNotFoundException(MappingMeta mapping) {
		super("entity = " + mapping.getEntity());
		this.mapping = mapping;
	}
	
	public MappingMeta getMapping() {
		return mapping;
	}
}

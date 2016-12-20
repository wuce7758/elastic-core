package com.gerald.elastic.core.meta.data.exception;

import com.gerald.elastic.core.meta.data.model.MappingMeta;

public class ParentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8525120140222836379L;
	
	private MappingMeta meta;
	
	public ParentNotFoundException(MappingMeta meta) {
		super("entity = " + meta.getEntity());
		this.meta = meta;
	}

	public MappingMeta getMeta() {
		return meta;
	}
}

package com.gerald.elastic.core.apis;

import java.util.List;

public class SyncDatasourceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5096850122910897420L;
	
	private List<Object> ids;
	
	public SyncDatasourceException(List<Object> ids) {
		this.ids = ids;
	}
	
	public List<Object> getIds() {
		return ids;
	}
}

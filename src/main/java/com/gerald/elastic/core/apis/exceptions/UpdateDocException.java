package com.gerald.elastic.core.apis.exceptions;

import java.util.Map;

import com.gerald.elastic.core.apis.type.SearchModel;

public class UpdateDocException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1025025795705248385L;
	
	private Object id;
	
	private SearchModel<?> model;
	
	private Map<String, Object> map;

	public UpdateDocException(Object id, Exception e) {
		super("id = " + id, e);
		this.id = id;
	}
	
	public UpdateDocException(SearchModel<?> model, Exception e) {
		super("model = [" + model.toString() + "]", e);
		this.model = model;
	}
	
	public UpdateDocException(Map<String, Object> map, Exception e) {
		super("map = " + map.toString(), e);
		this.map = map;
	}
	
	public Object getId() {
		return id;
	}
	
	public SearchModel<?> getModel() {
		return model;
	}
	
	public Map<String, Object> getMap() {
		return map;
	}
}

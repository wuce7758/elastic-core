package com.gerald.elastic.core.annotations.handlers.models;

import org.apache.commons.lang.StringUtils;

public class TypeModel implements Model {
	private String type;
	
	private String index;
	
	private String parent;
	
	public static class Builder {
		private String type;
		
		private String index;
		
		private String parent;

		public String getType() {
			return type;
		}

		public Builder setType(String type) {
			this.type = type;
			return this;
		}

		public String getIndex() {
			return index;
		}

		public Builder setIndex(String index) {
			this.index = index;
			return this;
		}

		public String getParent() {
			return parent;
		}

		public Builder setParent(String parent) {
			this.parent = parent;
			return this;
		}
		
		public TypeModel build() {
			return new TypeModel(this);
		}
	}
	
	private TypeModel(Builder builder) {
		if(StringUtils.isEmpty(builder.getType()) || StringUtils.isEmpty(builder.getIndex())) {
			throw new IllegalArgumentException("index = [" + builder.getIndex() + "]" 
											 + "type = [" + builder.getType() + "]");
		}
		
		this.type = builder.type;
		this.index = builder.index;
		
		if(StringUtils.isEmpty(builder.parent)) {
			this.parent = null;
		} else {
			this.parent = builder.parent;
		}
	}

	/**
	 * type名字，不会为空
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * index名字。不会为空
	 * 
	 * @return
	 */
	public String getIndex() {
		return index;
	}

	/**
	 * parent名字。null表示没有parent
	 * 
	 * @return
	 */
	public String getParent() {
		return parent;
	}
}

package com.gerald.elastic.core.annotations.handlers.models;

import org.apache.commons.lang.StringUtils;

public class IndexModel implements Model {		
	private String name;
	
	private int numberOfShards;
	
	private int numberOfReplicas;
	
	public static class Builder {
		private String name;
		
		private int numberOfShards;
		
		private int numberOfReplicas;

		public String getName() {
			return name;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public int getNumberOfShards() {
			return numberOfShards;
		}

		public Builder setNumberOfShards(int numberOfShards) {
			this.numberOfShards = numberOfShards;
			return this;
		}

		public int getNumberOfReplicas() {
			return numberOfReplicas;
		}

		public Builder setNumberOfReplicas(int numberOfReplicas) {
			this.numberOfReplicas = numberOfReplicas;
			return this;
		}
		
		public IndexModel build() {
			return new IndexModel(this);
		}
	}
	
	private IndexModel(Builder builder) {
		if(StringUtils.isEmpty(builder.getName()) 
		|| (builder.getNumberOfShards() < 1)
		|| (builder.getNumberOfReplicas() < 0)) {
			throw new IllegalArgumentException("index name = [" + builder.getName() + "]" 
					 						 + ", numberOfShards = " + builder.getNumberOfShards() 
					 						 + ", numberOfReplicas = " + builder.getNumberOfReplicas());
		}
		
		this.name = builder.getName();
		this.numberOfShards = builder.numberOfShards;
		this.numberOfReplicas = builder.numberOfReplicas;
	}

	public String getName() {
		return name;
	}

	public int getNumberOfShards() {
		return numberOfShards;
	}

	public int getNumberOfReplicas() {
		return numberOfReplicas;
	}
}

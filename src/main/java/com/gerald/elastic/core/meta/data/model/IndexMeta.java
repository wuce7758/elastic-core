package com.gerald.elastic.core.meta.data.model;

import java.util.HashSet;
import java.util.Set;

import org.elasticsearch.common.settings.Settings;

import com.gerald.elastic.core.meta.source.model.IndexSource;

public class IndexMeta {
	public static final String NUMBER_OF_SHARDS = "index.number_of_shards";
	
	public static final String NUMBER_OF_REPLICAS = "index.number_of_replicas";
	
	private IndexSource source;
	
	private Settings settings;
	
	private Set<MappingMeta> mappings = new HashSet<MappingMeta>();
	
	public IndexMeta(IndexSource indexSource) {
		this.source = indexSource;
		
		settings = Settings.builder().put(NUMBER_OF_SHARDS, indexSource.getModel().getNumberOfShards())
									 .put(NUMBER_OF_REPLICAS, indexSource.getModel().getNumberOfReplicas())
									 .build();
	}
	
	public String getName() {
		return source.getModel().getName();
	}
	
	public Class<?> getConfigClazz() {
		return source.getConfigureSource();
	}
	
	public Set<MappingMeta> getMappings() {
		return mappings;
	}

	public Settings getSettings() {
		return settings;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		if(!(obj instanceof IndexMeta)) {
			return false;
		}
		
		IndexMeta another = (IndexMeta)obj;
		
		return another.getName().equals(getName());
	}
	
	@Override
	public int hashCode() {
		return getName().hashCode();
	}
	
	@Override
	public String toString() {
		return "{" + "name = " + getName() + ", " 
				   + NUMBER_OF_SHARDS + " = " + getSettings().get(NUMBER_OF_SHARDS)  + ", "
				   +  NUMBER_OF_REPLICAS + " = " + getSettings().get(NUMBER_OF_REPLICAS)
			 + "}";
	}
}

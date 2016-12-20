package com.gerald.elastic.core.meta.source.model;

import java.util.ArrayList;
import java.util.List;

public class MetaSource {
	private List<IndexSource> indices = new ArrayList<IndexSource>();
	
	private List<MappingSource> mappings = new ArrayList<MappingSource>();

	public List<IndexSource> getIndices() {
		return indices;
	}

	public List<MappingSource> getMappings() {
		return mappings;
	}	
}

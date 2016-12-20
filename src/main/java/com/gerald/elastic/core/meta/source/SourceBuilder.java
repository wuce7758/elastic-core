package com.gerald.elastic.core.meta.source;

import com.gerald.elastic.core.meta.ConfigSource;
import com.gerald.elastic.core.meta.source.model.MetaSource;

public class SourceBuilder {
	public static MetaSource build(ConfigSource source) {
		MetaSource metaSource = new MetaSource();
		
		for(Class<?> indexConfig : source.indices()) {
			metaSource.getIndices().add(IndexSourceParser.parse(indexConfig));
		}
		
		for(Class<?> entity : source.entitys()) {
			metaSource.getMappings().add(MappingSourceParser.parse(entity));
		}
		
		return metaSource;
	}
}

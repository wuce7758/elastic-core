package com.gerald.elastic.core.meta;

import com.gerald.elastic.core.meta.data.model.MetaData;
import com.gerald.elastic.core.meta.source.SourceBuilder;
import com.gerald.elastic.core.meta.source.model.MetaSource;

public class MetaBuilder {
	public static MetaData build(ConfigSource source) {
		MetaSource metaSource = SourceBuilder.build(source);
		
		return new MetaData(metaSource);
	}
}

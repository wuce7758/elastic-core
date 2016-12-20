package com.gerald.elastic.core.annotations.handlers.extractors;

import com.gerald.elastic.core.annotations.handlers.models.IndexModel;
import com.gerald.elastic.core.annotations.handlers.util.ReflectionUtil;
import com.gerald.elastic.core.annotations.model.Index;

public class IndexExtractor implements Extractor {

	public IndexModel extract(Class<?> obj) {
		if(obj == null) {
			throw new NullPointerException();
		}
		
		Index index = ReflectionUtil.getAnnotation(obj, Index.class);
		
		if(index == null) {
			return null;
		}
		
		IndexModel.Builder builder = new IndexModel.Builder().setName(index.name())
															 .setNumberOfReplicas(index.settings().numberOfReplicas())
															 .setNumberOfShards(index.settings().numberOfShards());
		
		return builder.build();
	}
}

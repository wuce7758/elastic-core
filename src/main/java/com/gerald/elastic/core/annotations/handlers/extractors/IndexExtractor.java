package com.gerald.elastic.core.annotations.handlers.extractors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gerald.elastic.core.annotations.handlers.models.IndexModel;
import com.gerald.elastic.core.annotations.model.Index;
import com.gerald.elastic.core.util.ReflectionUtil;

public class IndexExtractor implements Extractor {
	private static final Logger logger = LogManager.getLogger(IndexExtractor.class);

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
		
		IndexModel model = builder.build();
		
		logger.info("config_source = " + obj.getName() + ", index_name = " + model.getName()
				  + ", number_of_replicas = " + model.getNumberOfReplicas() 
				  + ", number_of_shards = " + model.getNumberOfShards());
		
		return model;
	}
}

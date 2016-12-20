package com.gerald.elastic.core.annotations.handlers.extractors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gerald.elastic.core.annotations.handlers.models.TypeModel;
import com.gerald.elastic.core.annotations.model.Mapping;
import com.gerald.elastic.core.util.ReflectionUtil;

public class TypeExtractor implements Extractor {
	private static final Logger logger = LogManager.getLogger(TypeExtractor.class);
	
	@Override
	public TypeModel extract(Class<?> clazz) {		
		if(clazz == null) {
			throw new NullPointerException();
		}
		
		Mapping mapping = ReflectionUtil.getAnnotation(clazz, Mapping.class);
		
		TypeModel.Builder builder = new TypeModel.Builder().setIndex(mapping.index())
														   .setParent(mapping.parent())
														   .setType(mapping.type());
		
		TypeModel model = builder.build();
		
		logger.info(String.format("entity = %s, index = %s, type = %s, parent = %s", 
				clazz.getName(), model.getIndex(), model.getType(), model.getParent()));
		
		return model;
	}
}

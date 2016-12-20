package com.gerald.elastic.core.annotations.handlers.extractors;

import com.gerald.elastic.core.annotations.handlers.models.TypeModel;
import com.gerald.elastic.core.annotations.handlers.util.ReflectionUtil;
import com.gerald.elastic.core.annotations.model.Mapping;

public class TypeExtractor implements Extractor {

	@Override
	public TypeModel extract(Class<?> clazz) {
		if(clazz == null) {
			throw new NullPointerException();
		}
		
		Mapping mapping = ReflectionUtil.getAnnotation(clazz, Mapping.class);
		
		TypeModel.Builder builder = new TypeModel.Builder().setIndex(mapping.index())
														   .setParent(mapping.parent())
														   .setType(mapping.type());
		
		return builder.build();
	}
}

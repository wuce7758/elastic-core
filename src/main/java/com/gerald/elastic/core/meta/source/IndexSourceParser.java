package com.gerald.elastic.core.meta.source;

import com.gerald.elastic.core.annotations.handlers.extractors.IndexExtractor;
import com.gerald.elastic.core.annotations.handlers.models.IndexModel;
import com.gerald.elastic.core.meta.source.model.IndexSource;

class IndexSourceParser {
	private static final IndexExtractor extractor = new IndexExtractor();
	
	public static IndexSource parse(Class<?> clazz) {
		IndexModel model = extractor.extract(clazz);
		
		return new IndexSource(model, clazz);
	}
}

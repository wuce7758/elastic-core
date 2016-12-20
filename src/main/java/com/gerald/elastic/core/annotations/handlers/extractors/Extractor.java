package com.gerald.elastic.core.annotations.handlers.extractors;

import com.gerald.elastic.core.annotations.handlers.models.Model;

public interface Extractor {
	Model extract(Class<?> clazz);
}

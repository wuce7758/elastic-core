package com.gerald.elastic.core.meta;

import java.util.List;

public interface ConfigSource {
	List<Class<?>> indices();
	
	List<Class<?>> entitys();
}
package com.gerald.elastic.core.debug.index;

import java.util.ArrayList;
import java.util.List;

import com.gerald.elastic.core.meta.ConfigSource;

public class MySource implements ConfigSource {

	@Override
	public List<Class<?>> indices() {
		List<Class<?>> list = new ArrayList<Class<?>>();
		
		list.add(Goods.class);
		
		return list;
	}

	@Override
	public List<Class<?>> entitys() {
		List<Class<?>> list = new ArrayList<Class<?>>();
		
		list.add(Goods.class);
		
		return list;
	}

}

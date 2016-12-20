package com.gerald.elastic.core.debug;

import java.util.Map;

import com.gerald.elastic.core.meta.data.model.IndexMeta;
import com.gerald.elastic.core.meta.data.model.MappingMeta;
import com.gerald.elastic.core.meta.data.model.MetaData;

public class PrintUtil {
	public static void print(MetaData metaData) {
		System.out.println("=======================basic mapping info=======================");
		
		for(Map.Entry<String, IndexMeta> entry : metaData.getIndicies().entrySet()) {
			System.out.println("key_name = " + entry.getKey());
			System.out.println("index = " + entry.getValue());
		}
		
		System.out.println();
		
		for(Map.Entry<Class<?>, MappingMeta> entry : metaData.getMappings().entrySet()) {
			System.out.println("class = " + entry.getKey());
			System.out.println("mapping = {" + entry.getValue() + "}");
		}
	}
}

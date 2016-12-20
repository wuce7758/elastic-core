package com.gerald.elastic.core.debug;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gerald.elastic.core.annotations.bridge.BigDecimalStringBridge;
import com.gerald.elastic.core.annotations.bridge.Bridge;
import com.gerald.elastic.core.annotations.model.Index;
import com.gerald.elastic.core.annotations.model.Mapping;
import com.gerald.elastic.core.meta.ConfigSource;
import com.gerald.elastic.core.meta.MetaBuilder;
import com.gerald.elastic.core.meta.data.model.MetaData;

@Index(name = "test")
@Mapping(index = "test", type = "basic_mapping")
public class BasicMapping {
	private boolean boolField;
	
	private byte byteField;
	
	private short shortField;
	
	private int intField;
	
	private long longField;
	
	private float floatField;
	
	private double doubleField;
	
	private String stringField;
	
	@Bridge(bridge = BigDecimalStringBridge.class)
	private BigDecimal bigDecimalField;
	
	public static void main(String[] args) {
		MetaData meta = MetaBuilder.build(new ConfigSource() {

			@Override
			public List<Class<?>> indices() {
				List<Class<?>> list = new ArrayList<Class<?>>();
				
				list.add(BasicMapping.class);
				
				return list;
			}

			@Override
			public List<Class<?>> entitys() {
				List<Class<?>> list = new ArrayList<Class<?>>();
				
				list.add(BasicMapping.class);
				
				return list;
			}
			
		});
		
//		PrintUtil.print(meta);
	}
}

package com.gerald.elastic.core.meta.data.model;

import java.util.HashMap;
import java.util.Map;

import com.gerald.elastic.core.meta.data.exception.ConflictIndexConfig;
import com.gerald.elastic.core.meta.data.exception.ConflictTypeConfig;
import com.gerald.elastic.core.meta.data.exception.IndexNotFoundException;
import com.gerald.elastic.core.meta.data.exception.ParentChildInDiffIndex;
import com.gerald.elastic.core.meta.data.exception.ParentNotFoundException;
import com.gerald.elastic.core.meta.source.model.FieldSource;
import com.gerald.elastic.core.meta.source.model.IndexSource;
import com.gerald.elastic.core.meta.source.model.MappingSource;
import com.gerald.elastic.core.meta.source.model.MetaSource;

public class MetaData {
	private Map<String, IndexMeta> indicies = new HashMap<String, IndexMeta>();
	
	private Map<Class<?>, MappingMeta> mappings = new HashMap<Class<?>, MappingMeta>();
	
	public MetaData(MetaSource source) {
		for(IndexSource index : source.getIndices()) {
			IndexMeta meta = new IndexMeta(index);
			
			if(indicies.containsKey(meta.getName())) {
				//index的配置只能出现在一个地方，避免配置冲突
				throw new ConflictIndexConfig(indicies.get(meta.getName()).getConfigClazz(), meta.getConfigClazz());
			}
			
			indicies.put(meta.getName(), meta);
		}
		
		for(MappingSource mapping : source.getMappings()) {
			MappingMeta meta = new MappingMeta(mapping);
			
			mappings.put(meta.getEntity(), meta);
			
			//关联mapping和index
			meta.setIndex(indicies.get(meta.getIndexName()));
			if(meta.getIndex() == null) {
				throw new IndexNotFoundException(meta);
			}
			
			if(meta.getIndex().getMappings().contains(meta)) {
				//一个mapping由index和type确定，不允许出现重名的type
				for(MappingMeta existed : meta.getIndex().getMappings()) {
					if(existed.equals(meta)) {
						throw new ConflictTypeConfig(existed.getEntity(), meta.getEntity());
					}
				}
			}
			
			meta.getIndex().getMappings().add(meta);
			
			//关联mapping和fields
			for(FieldSource<?> field : mapping.getFields()) {
				FieldMeta<?> fieldMeta = new FieldMeta<>(field, meta);
				meta.addField(fieldMeta);
			}
		}
		
		for(MappingMeta meta : mappings.values()) {
			String parent = meta.getParentName();
			
			if(parent != null) {
				MappingMeta parentMeta = mappings.get(parent);
				
				if(parentMeta == null) {
					//找不到parent定义
					throw new ParentNotFoundException(parentMeta);
				}
				
				if(parentMeta.getIndex() != meta.getIndex()) {
					//parent和child必须在同一个index中
					throw new ParentChildInDiffIndex(parentMeta, meta);
				}
				
				meta.setParent(parentMeta);
				parentMeta.getChildren().add(meta);
			}
		}
	}

	public Map<String, IndexMeta> getIndicies() {
		return indicies;
	}

	public Map<Class<?>, MappingMeta> getMappings() {
		return mappings;
	}
	
	@Override
	public String toString() {
		return "indicies = " + getIndicies().toString() + "\nmappings = " + getMappings().toString();
	}
}

package com.gerald.elastic.core.meta.data.model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.gerald.elastic.core.meta.source.model.MappingSource;

public class MappingMeta {
	private IndexMeta index;
	
	private MappingSource source;
	
	private MappingMeta parent;
	
	private Set<MappingMeta> children;
	
	private Set<FieldMeta<?>> fields = new HashSet<FieldMeta<?>>();
	
	private Map<Field, FieldMeta<?>> fieldToMeta = new HashMap<Field, FieldMeta<?>>();
	
	private Map<String, FieldMeta<?>> nameToMeta = new HashMap<String, FieldMeta<?>>();

	public MappingMeta(MappingSource source) {
		this.source = source;
	}
	
	public Class<?> getEntity() {
		return source.getTypeSource().getSource();
	}
	
	String getIndexName() {
		return source.getTypeSource().getModel().getIndex();
	}

	public IndexMeta getIndex() {
		return index;
	}

	void setIndex(IndexMeta index) {
		this.index = index;
	}

	public String getType() {
		return source.getTypeSource().getModel().getType();
	}
	
	String getParentName() {
		return source.getTypeSource().getModel().getParent();
	}

	public MappingMeta getParent() {
		return parent;
	}

	void setParent(MappingMeta parent) {
		this.parent = parent;
	}

	public Set<MappingMeta> getChildren() {
		return children;
	}
	
	void addField(FieldMeta<?> field) {
		fields.add(field);
		fieldToMeta.put(field.getField(), field);
		nameToMeta.put(field.getFieldName(), field);
	}

	public Set<FieldMeta<?>> getFields() {
		return fields;
	}
	
	public FieldMeta<?> getByField(Field field) {
		return fieldToMeta.get(field);
	}
	
	public FieldMeta<?> getByName(String fieldName) {
		return nameToMeta.get(fieldName);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		if(!(obj instanceof MappingMeta)) {
			return false;
		}
		
		MappingMeta another = (MappingMeta)obj;
		
		return new EqualsBuilder().append(getIndexName(), another.getIndexName())
								  .append(getType(), another.getType())
								  .isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getIndexName()).append(getType()).toHashCode();
	}
	
	@Override
	public String toString() {
		return getEntity() + " mapped as " + getIndexName() + "." + getType();
	} 
}

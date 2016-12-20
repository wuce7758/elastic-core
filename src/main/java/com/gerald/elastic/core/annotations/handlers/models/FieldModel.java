package com.gerald.elastic.core.annotations.handlers.models;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.gerald.elastic.core.annotations.mapping.parameter.IndexType;

public class FieldModel<T> implements Model {
	private Class<? extends T> javaType;
	
	private DocType docType;
	
	private TypeWrapper<String> analyzer;
	
	private TypeWrapper<Double> boost;
	
	private TypeWrapper<Boolean> docValues;
	
	private TypeWrapper<IndexType> indexType;
	
	private TypeWrapper<Map<String, FieldModel<T>>> fields;
	
	private TypeWrapper<T> nullValue;
	
	private TypeWrapper<Integer> positionIncrementGap;
	
	private TypeWrapper<String> searchAnalyzer;
	
	private TypeWrapper<Boolean> coerce;
	
	public static class Builder<T> {
		private Class<? extends T> javaType;
		
		private DocType docType;
		
		private TypeWrapper<String> analyzer = TypeWrapper.ignored();
		
		private TypeWrapper<Double> boost = TypeWrapper.ignored();
		
		private TypeWrapper<Boolean> docValues;
		
		private TypeWrapper<IndexType> indexType = TypeWrapper.ignored();
		
		private TypeWrapper<Map<String, FieldModel<T>>> fields = TypeWrapper.ignored();
		
		private TypeWrapper<T> nullValue = TypeWrapper.ignored();
		
		private TypeWrapper<Integer> positionIncrementGap = TypeWrapper.ignored();
		
		private TypeWrapper<String> searchAnalyzer = TypeWrapper.ignored();
		
		private TypeWrapper<Boolean> coerce = TypeWrapper.ignored();
		
		private Builder(Class<? extends T> javaType, DocType docType) {
			this.javaType = javaType;
			this.docType = docType;
		}
		
		public Class<? extends T> getJavaType() {
			return javaType;
		}

		public DocType getDocType() {
			return docType;
		}

		public String getAnalyzer() {
			return analyzer.value();
		}

		public Builder<T> setAnalyzer(String analyzer) {			
			this.analyzer = TypeWrapper.valueOf(analyzer);
			return this;
		}

		public Double getBoost() {
			return boost.value();
		}

		public Builder<T> setBoost(double boost) {
			this.boost = TypeWrapper.valueOf(boost);
			return this;
		}
		
		public Boolean getDocValues() {
			return docValues.value();
		}
		
		public Builder<T> setDocValues(boolean docValues) {
			this.docValues = TypeWrapper.valueOf(docValues);
			return this;
		}

		public IndexType getIndexType() {
			return indexType.value();
		}

		public Builder<T> setIndexType(IndexType indexType) {
			this.indexType = TypeWrapper.valueOf(indexType);
			return this;
		}

		public Map<String, FieldModel<T>> getFields() {
			return fields.value();
		}

		public Builder<T> setFields(Map<String, FieldModel<T>> fields) {
			this.fields = TypeWrapper.valueOf(fields);
			return this;
		}

		public T getNullValue() {
			return nullValue.value();
		}

		public Builder<T> setNullValue(T nullValue) {
			this.nullValue = TypeWrapper.valueOf(nullValue);
			return this;
		}

		public Integer getPositionIncrementGap() {
			return positionIncrementGap.value();
		}

		public Builder<T> setPositionIncrementGap(int positionIncrementGap) {
			this.positionIncrementGap = TypeWrapper.valueOf(positionIncrementGap);
			return this;
		}

		public String getSearchAnalyzer() {
			return searchAnalyzer.value();
		}

		public Builder<T> setSearchAnalyzer(String searchAnalyzer) {
			this.searchAnalyzer = TypeWrapper.valueOf(searchAnalyzer);
			return this;
		}

		public Boolean getCoerce() {
			return coerce.value();
		}

		public Builder<T> setCoerce(boolean coerce) {
			this.coerce = TypeWrapper.valueOf(coerce);
			return this;
		}
		
		public FieldModel<T> build() {
			return new FieldModel<T>(this);
		}
		
		public static <U> Builder<U> newInstance(Class<? extends U> javaType, DocType docType) {
			return new Builder<U>(javaType, docType);
		}
	}
	
	private FieldModel(Builder<T> builder) {
		if((builder.getJavaType() == null) || (builder.getDocType() == null)) {
			throw new IllegalArgumentException("java type = " + builder.getJavaType() + ", doc type = " + builder.getDocType());
		}
		
		if(!builder.analyzer.isIgnored() && !StringUtils.isEmpty(builder.analyzer.value())) {
			this.analyzer = builder.analyzer;
		} else {
			//空串表示使用默认配置，不需要该字段
			this.analyzer = TypeWrapper.ignored();
		}
		
		this.boost = builder.boost;
		this.coerce = builder.coerce;
		this.docType = builder.docType;
		this.docValues = builder.docValues;		
		this.fields = builder.fields;
		this.indexType = builder.indexType;
		this.javaType = builder.javaType;
		
		if(!builder.nullValue.isIgnored() && builder.nullValue.value() != null) {
			this.nullValue = builder.nullValue;
		} else {
			this.nullValue = TypeWrapper.ignored();
		}		
		
		this.positionIncrementGap = builder.positionIncrementGap;
		
		
		if(!builder.searchAnalyzer.isIgnored() && !StringUtils.isEmpty(builder.searchAnalyzer.value())) {
			this.searchAnalyzer = builder.searchAnalyzer;
		} else {
			//空串表示使用默认配置，不需要该字段
			this.searchAnalyzer = TypeWrapper.ignored();
		}
	}

	public Class<? extends T> getJavaType() {
		return javaType;
	}

	public DocType getDocType() {
		return docType;
	}

	public TypeWrapper<Map<String, FieldModel<T>>> getFields() {
		return fields;
	}
	
	public Map<String, Object> params() {
		Map<String, Object> params = new HashMap<String, Object>();
		
		if(!analyzer.isIgnored()) {
			params.put("analyzer", analyzer.value());
		}
		
		if(!boost.isIgnored()) {
			params.put("boost", boost.value());
		}
		
		if(!docValues.isIgnored()) {
			params.put("doc_values", docValues.value());
		}
		
		if(!indexType.isIgnored()) {
			params.put("index", indexType.value().getType());
		}
		
		if(!nullValue.isIgnored()) {
			params.put("null_value", nullValue.value());
		}
		
		if(!positionIncrementGap.isIgnored()) {
			params.put("position_increment_gap", positionIncrementGap.value());
		}
		
		if(!searchAnalyzer.isIgnored()) {
			params.put("search_analyzer", searchAnalyzer.value());
		}
		
		if(!coerce.isIgnored()) {
			params.put("coerce", coerce.value());
		}
		
		return params;
	}
}

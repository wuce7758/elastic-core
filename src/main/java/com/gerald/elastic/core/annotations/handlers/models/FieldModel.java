package com.gerald.elastic.core.annotations.handlers.models;

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
		
		this.analyzer = builder.analyzer;
		if(!this.analyzer.isIgnored() && StringUtils.isEmpty(analyzer.value())) {
			analyzer = TypeWrapper.valueOf((String)null);
		}
		
		this.boost = builder.boost;
		this.coerce = builder.coerce;
		this.docType = builder.docType;
		this.fields = builder.fields;
		this.indexType = builder.indexType;
		this.javaType = builder.javaType;
		this.nullValue = builder.nullValue;
		this.positionIncrementGap = builder.positionIncrementGap;
		
		this.searchAnalyzer = builder.searchAnalyzer;
		if(!searchAnalyzer.isIgnored() && StringUtils.isEmpty(searchAnalyzer.value())) {
			searchAnalyzer = TypeWrapper.valueOf((String)null);
		}
	}

	public Class<? extends T> getJavaType() {
		return javaType;
	}

	public DocType getDocType() {
		return docType;
	}

	public TypeWrapper<String> getAnalyzer() {
		return analyzer;
	}

	public TypeWrapper<Double> getBoost() {
		return boost;
	}

	public TypeWrapper<IndexType> getIndexType() {
		return indexType;
	}

	public TypeWrapper<Map<String, FieldModel<T>>> getFields() {
		return fields;
	}

	public TypeWrapper<T> getNullValue() {
		return nullValue;
	}

	public TypeWrapper<Integer> getPositionIncrementGap() {
		return positionIncrementGap;
	}

	public TypeWrapper<String> getSearchAnalyzer() {
		return searchAnalyzer;
	}

	public TypeWrapper<Boolean> getCoerce() {
		return coerce;
	}

	public TypeWrapper<Boolean> getDocValues() {
		return docValues;
	}
}

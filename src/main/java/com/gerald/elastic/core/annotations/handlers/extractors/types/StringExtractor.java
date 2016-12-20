package com.gerald.elastic.core.annotations.handlers.extractors.types;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gerald.elastic.core.annotations.handlers.exceptions.DuplicatedSubField;
import com.gerald.elastic.core.annotations.handlers.exceptions.TypeMismatchException;
import com.gerald.elastic.core.annotations.handlers.extractors.types.util.FieldLoggingUtil;
import com.gerald.elastic.core.annotations.handlers.models.DocType;
import com.gerald.elastic.core.annotations.handlers.models.FieldModel;
import com.gerald.elastic.core.annotations.mapping.parameter.FieldItem;
import com.gerald.elastic.core.annotations.mapping.parameter.IndexType;
import com.gerald.elastic.core.annotations.mapping.parameter.SubStringType;
import com.gerald.elastic.core.annotations.types.StringType;

public class StringExtractor implements FieldExtractor<String> {
	private static final Logger logger = LogManager.getLogger(StringExtractor.class);

	@Override
	public FieldModel<String> extract(Annotation annotation, Class<?> javaType,
			Field field) {
		if(javaType != String.class) {
			throw new TypeMismatchException(field);
		}

		StringType type = (StringType)annotation;
		
		Map<String, FieldModel<String>> subFields = new HashMap<String, FieldModel<String>>();
		
		for(FieldItem item : type.fields().value()) {
			if(subFields.containsKey(item.subName())) {
				throw new DuplicatedSubField(field);
			}
			
			SubStringType subType = item.mappingInfo();
			
			FieldModel<String> subField = FieldModel.Builder.newInstance(String.class, DocType.STRING)
																.setAnalyzer(subType.analyzer())
																.setBoost(subType.boost())
																.setDocValues(subType.docValues())
																.setIndexType(subType.index())
																.setNullValue(subType.nullValue().getValue())
																.setPositionIncrementGap(subType.positionIncrementGap())
																.setSearchAnalyzer(subType.searchAnalyzer())
																.build();
			
			subFields.put(item.subName(), subField);
		}
		
		FieldModel<String> model = FieldModel.Builder.newInstance(String.class, DocType.STRING)
														.setAnalyzer(type.analyzer())
														.setBoost(type.boost())
														.setDocValues(type.docValues())
														.setFields(subFields)
														.setIndexType(type.index())
														.setNullValue(type.nullValue().getValue())
														.setPositionIncrementGap(type.positionIncrementGap())
														.setSearchAnalyzer(type.searchAnalyzer())
														.build();
		
		FieldLoggingUtil.debug(model, field, logger);
		
		return model;
	}

}

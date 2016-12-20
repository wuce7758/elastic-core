package com.gerald.elastic.core.meta.source;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.gerald.elastic.core.annotations.bridge.Bridge;
import com.gerald.elastic.core.annotations.bridge.DataBridge;
import com.gerald.elastic.core.annotations.handlers.exceptions.MultipleTypeMappingException;
import com.gerald.elastic.core.annotations.handlers.extractors.TypeExtractor;
import com.gerald.elastic.core.annotations.handlers.extractors.types.FieldExtractor;
import com.gerald.elastic.core.annotations.handlers.models.FieldModel;
import com.gerald.elastic.core.annotations.handlers.models.TypeModel;
import com.gerald.elastic.core.annotations.types.TypeMapping;
import com.gerald.elastic.core.meta.source.model.FieldSource;
import com.gerald.elastic.core.meta.source.model.MappingSource;
import com.gerald.elastic.core.meta.source.model.TypeSource;
import com.gerald.elastic.core.meta.source.util.DefaultsUtil;
import com.gerald.elastic.core.meta.source.util.PrimitiveUtil;
import com.gerald.elastic.core.util.ReflectionUtil;

class MappingSourceParser {
	private static final Map<Class<?>, FieldExtractor<?>> EXTRACTORS = new HashMap<Class<?>, FieldExtractor<?>>();
	
	private static final TypeExtractor typeExtractor = new TypeExtractor();
	
	public static MappingSource parse(Class<?> entityClazz) {
		TypeModel typeModel = typeExtractor.extract(entityClazz);
		TypeSource typeSource = new TypeSource(typeModel, entityClazz);
		
		MappingSource mappingSource = new MappingSource(typeSource);
		parseFields(mappingSource, entityClazz);
		
		return mappingSource;
	}
	
	private static void parseFields(MappingSource source, Class<?> entityClazz) {
		Field[] fields = ReflectionUtil.getAllFields(entityClazz);
		
		for(Field field : fields) {
			source.getFields().add(parseSingleField(field));
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static FieldSource<?> parseSingleField(Field field) {
		DataBridge<?,?> bridge  = findDataBridge(field);
		Class<?> javaType = PrimitiveUtil.convertPrimitive(getJavaType(bridge, field));
		
		Annotation annotation = determineAnnotation(findTypeAnnotation(field), javaType);
		
		TypeMapping typeMapping = getTypeMapping(annotation);
		
		Class<? extends FieldExtractor<?>> extractorClazz = typeMapping.extractor();
		FieldExtractor<?> extractor = getExtractor(extractorClazz);
		
		FieldModel<?> model = extractor.extract(annotation, javaType, field);
		
		return new FieldSource(model, bridge, field);
	}
	
	private static FieldExtractor<?> getExtractor(Class<? extends FieldExtractor<?>> extractorClazz) {
		FieldExtractor<?> extractor = EXTRACTORS.get(extractorClazz);
		
		if(extractor == null) {
			extractor = ReflectionUtil.newInstanceByDefaultConstructor(extractorClazz);
			EXTRACTORS.put(extractorClazz, extractor);
		}
		
		return extractor;
	}
	
	private static Annotation determineAnnotation(Annotation annotation, Class<?> javaType) {
		if(annotation == null) {
			return DefaultsUtil.getDefault(javaType);
		} else {			
			return annotation;
		}
	}
	
	private static TypeMapping getTypeMapping(Annotation annotation) {
		return ReflectionUtil.getAnnotation(annotation.annotationType(), TypeMapping.class);
	}
	
	private static Class<?> getJavaType(DataBridge<?,?> bridge, Field field) {
		if(bridge != null) {
			Class<?> bridgeDocType = getBridgeDocType(bridge);
			
			return bridgeDocType;
		} else {
			return field.getType();
		}
	}
	
//	private static Class<?> getBridgeJavaType(DataBridge<?,?> bridge) {
//		Method[] methods = ReflectionUtil.getMethodsByName(bridge.getClass(), "fromDoc");
//		if(methods.length != 1) {
//			throw new DataBridgeChangedException();
//		}
//		
//		return methods[0].getReturnType();
//	}
	
	private static Class<?> getBridgeDocType(DataBridge<?,?> bridge) {
		Type[] types = bridge.getClass().getGenericInterfaces();
		Class<?> docType = null;
		for(Type type : types) {
			ParameterizedType p = (ParameterizedType)type;
			if(p.getRawType() == DataBridge.class) {
				docType = (Class<?>)p.getActualTypeArguments()[0];
			}
		}
		
		return docType;
	}
	
	private static Annotation findTypeAnnotation(Field field) {
		Annotation[] annotations = ReflectionUtil.getOnesAnnotatedBy(field, TypeMapping.class);
		
		if(annotations.length > 1) {
			throw new MultipleTypeMappingException(field);
		}
		
		if(annotations.length == 0) {
			return null;
		}
		
		return annotations[0];
	}
	
	private static DataBridge<?,?> findDataBridge(Field field) {
		Bridge bridge = ReflectionUtil.getAnnotation(field, Bridge.class);
		
		if(bridge == null) {
			return null;
		} else {
			Class<? extends DataBridge<?,?>> bridgeClass = bridge.bridge();
			return ReflectionUtil.newInstanceByDefaultConstructor(bridgeClass);
		}
	}
}

package com.gerald.elastic.core.annotations.bridge;

/**
 * 用于不兼容类型的转换，例如BigDecimal不能存储为Object/Nested类型。
 * 使用DataBridge可以转换为Integer/Long/String类型存储
 *
 * @param <T>
 * 			目标类型
 * @param <D>
 * 			源类型
 */
public interface DataBridge<T,D> {
	T toDoc(D obj);
	
	D fromDoc(T obj);
}

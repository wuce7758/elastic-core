package com.gerald.elastic.core.annotations.handlers.models;

public class TypeWrapper<T> {
	public static <U> TypeWrapper<U> ignored() {
		return new TypeWrapper<U>();
	}
	
	public static <U> TypeWrapper<U> valueOf(U value) {
		return new TypeWrapper<U>(value);
	}
	
	private boolean isIgnored;
	
	private T value;
	
	private TypeWrapper() {
		this.isIgnored = true;
	}
	
	private TypeWrapper(T value) {
		this.value = value;
		this.isIgnored = false;
	}
	
	public boolean isIgnored() {
		return isIgnored;
	}
	
	public T value() {
		return value;
	}
}

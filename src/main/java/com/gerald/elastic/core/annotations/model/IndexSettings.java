package com.gerald.elastic.core.annotations.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface IndexSettings {
	 int numberOfShards() default 5;
	 
	 int numberOfReplicas() default 1;
}

package com.gerald.elastic.core.annotations.handlers.models;

public enum DocType {
	STRING("string"),
	BOOLEAN("boolean"),
	DATE("date"),
	OBJECT("object"),
	NESTED("nested"),
	GEO_POINT("geo_point"),
	BYTE("byte"),
	SHORT("short"),
	INTEGER("integer"),
	LONG("long"),
	DOUBLE("double"),
	FLOAT("float")
	;
	
	private String docType;
	
	private DocType(String docType) {
		this.docType = docType;
	}

	public String getDocType() {
		return docType;
	}
}

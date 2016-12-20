package com.gerald.elastic.core.annotations.bridge;

import java.math.BigDecimal;

public class BigDecimalStringBridge implements DataBridge<String, BigDecimal> {

	public String toDoc(BigDecimal obj) {
		return obj.toString();
	}

	public BigDecimal fromDoc(String obj) {
		return new BigDecimal(obj);
	}

}

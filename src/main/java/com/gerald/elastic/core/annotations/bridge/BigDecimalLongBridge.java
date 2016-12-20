package com.gerald.elastic.core.annotations.bridge;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalLongBridge implements DataBridge<Long, BigDecimal> {
	public static final int SCALE = 1000;

	public Long toDoc(BigDecimal obj) {
		return obj.multiply(BigDecimal.valueOf(SCALE)).longValue();
	}

	public BigDecimal fromDoc(Long obj) {
		return BigDecimal.valueOf(obj).divide(BigDecimal.valueOf(SCALE), 3, RoundingMode.HALF_UP);
	}
}

package com.gerald.elastic.core.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public class LogUtil {
	private LogUtil() {
		throw new AssertionError();
	}
	
	/**
	 * 判断logger在指定Level下，是否有效
	 * 
	 * @param logger
	 * @param level
	 * @return
	 */
	public static boolean isActive(Logger logger, Level level) {
		return logger.getLevel().compareTo(level) <= 0;
	}
}

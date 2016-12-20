package com.gerald.elastic.core.debug.index;

import com.gerald.elastic.core.apis.ManagerFactory;
import com.gerald.elastic.core.apis.ManagerFactoryBuilder;

public class ManagerFactoryFactory {
	private static ManagerFactory managerFactory;
	
	static {
		managerFactory = new ManagerFactoryBuilder(ClientFactory.getClient(), new MySource()).build();
	}
	
	public static ManagerFactory getManagerFactory() {
		return managerFactory;
	}
}

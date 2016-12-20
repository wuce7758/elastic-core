package com.gerald.elastic.core.debug.index;

import com.gerald.elastic.core.apis.ManagerFactory;
import com.gerald.elastic.core.apis.index.IndexManager;

public class App {
	public static void main(String[] args) {
		ManagerFactory factory = ManagerFactoryFactory.getManagerFactory();
		
		IndexManager indexManager = factory.indexManager();
		
		indexManager.createIndex("test_index");
		
		System.out.println(indexManager.allIndices());
	}
}

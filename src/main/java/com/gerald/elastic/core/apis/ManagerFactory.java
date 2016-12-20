package com.gerald.elastic.core.apis;

import com.gerald.elastic.core.apis.doc.DocManager;
import com.gerald.elastic.core.apis.index.IndexManager;

public interface ManagerFactory {
	IndexManager indexManager();
	
	DocManager docManager();
}

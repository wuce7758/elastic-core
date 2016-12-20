package com.gerald.elastic.core.apis;

import com.gerald.elastic.core.apis.client.ElasticClient;
import com.gerald.elastic.core.apis.doc.DocManager;
import com.gerald.elastic.core.apis.doc.DocManagerImpl;
import com.gerald.elastic.core.apis.index.IndexManager;
import com.gerald.elastic.core.apis.index.IndexManagerImpl;
import com.gerald.elastic.core.meta.data.model.MetaData;

class ManagerFactoryImpl implements ManagerFactory {
	private IndexManager indexManager;
	
	private DocManager docManager;
	
	public ManagerFactoryImpl(ElasticClient client, MetaData meta) {
		indexManager = new IndexManagerImpl(client, meta);
		docManager = new DocManagerImpl(client, meta);
	}

	@Override
	public IndexManager indexManager() {
		return indexManager;
	}

	@Override
	public DocManager docManager() {
		return docManager;
	}
}

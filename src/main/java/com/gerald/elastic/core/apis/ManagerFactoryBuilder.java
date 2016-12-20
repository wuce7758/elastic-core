package com.gerald.elastic.core.apis;

import org.elasticsearch.client.transport.TransportClient;

import com.gerald.elastic.core.apis.client.ElasticClient;
import com.gerald.elastic.core.apis.client.ElasticClientImpl;
import com.gerald.elastic.core.meta.ConfigSource;
import com.gerald.elastic.core.meta.MetaBuilder;
import com.gerald.elastic.core.meta.data.model.MetaData;

public class ManagerFactoryBuilder {
	private TransportClient client;
	
	private ConfigSource source;
	
	public ManagerFactoryBuilder(TransportClient client, ConfigSource source) {
		this.client = client;
		this.source = source;
	}
	
	public ManagerFactory build() {
		MetaData meta = MetaBuilder.build(source);
		ElasticClient eClient = new ElasticClientImpl(client);
		
		return new ManagerFactoryImpl(eClient, meta);
	}
}

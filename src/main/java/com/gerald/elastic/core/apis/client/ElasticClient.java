package com.gerald.elastic.core.apis.client;

import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.client.transport.TransportClient;

public interface ElasticClient {
	TransportClient client();
	
	BulkProcessor bulk();
}

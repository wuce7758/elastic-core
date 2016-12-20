package com.gerald.elastic.core.apis.client;

import java.util.Arrays;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.IndicesRequest;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkProcessor.Listener;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.transport.TransportClient;

import com.gerald.elastic.core.util.LogUtil;

public class ElasticClientImpl implements ElasticClient {
	private static final Logger logger = LogManager.getLogger(ElasticClientImpl.class);
	
	private TransportClient client;
	
	public ElasticClientImpl(TransportClient client) {
		this.client = client;
	}

	@Override
	public TransportClient client() {
		return client;
	}

	@Override
	public BulkProcessor bulk() {
		return BulkProcessor.builder(client, new Listener() {

			@Override
			public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
				logResponse(executionId, response);
			}

			@Override
			public void afterBulk(long executionId, BulkRequest request, Throwable response) {
				logger.error("bulk = " + executionId, response);
			}

			@Override
			public void beforeBulk(long executionId, BulkRequest request) {
				logRequest(executionId, request);				
			}
			
		}).build();
	}
	
	private void debug(long executionId, BulkRequest request) {
		StringBuilder builder = new StringBuilder("bulk = " + executionId);
		
		for(IndicesRequest req : request.subRequests()) {
			if(req instanceof UpdateRequest) {
				UpdateRequest update = (UpdateRequest)req;
				builder.append("\nupdate, index = " + update.index() + ", type = " + update.type() + ", id = " + update.id() + ", source = " + update.doc().sourceAsMap());
			} else if(req instanceof DeleteRequest) {
				DeleteRequest delete = (DeleteRequest)req;
				builder.append("\nudelete, index = " + delete.index() + ", type = " + delete.type() + ", id = " + delete.id());
			} else {
				builder.append("\nunkown operation, related indices = " + Arrays.toString(req.indices()));
			}			
		}
		
		logger.debug(builder.toString());
	}
	
	private void info(long executionId, BulkRequest request) {
		StringBuilder builder = new StringBuilder("bulk = " + executionId);
		
		for(IndicesRequest req : request.subRequests()) {
			builder.append("\nrelated indices = " + Arrays.toString(req.indices()));			
		}
		
		logger.info(builder.toString());
	}
	
	private void logRequest(long executionId, BulkRequest request) {
		if(LogUtil.isActive(logger, Level.DEBUG)) {
			debug(executionId, request);
		} else if(LogUtil.isActive(logger, Level.INFO)) {
			info(executionId, request);
		}
	}
	
	private void logResponse(long executionId, BulkResponse response) {
		if(response.hasFailures()) {
			StringBuilder builder = new StringBuilder();
			
			builder.append("bulk = " + executionId);
			
			for(BulkItemResponse item : response.getItems()) {
				if(item.isFailed()) {
					builder.append("\nindex = " + item.getIndex() + ", type = " + item.getType() + ", id = " + item.getId() + ", " + item.getFailureMessage());
				}
			}
			logger.error(builder.toString());
		} else {
			logger.info("bulk = " + executionId + " DONE");
		}
	}
}

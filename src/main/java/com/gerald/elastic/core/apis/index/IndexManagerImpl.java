package com.gerald.elastic.core.apis.index;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContent;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import com.gerald.elastic.core.annotations.handlers.models.DocType;
import com.gerald.elastic.core.annotations.handlers.models.FieldModel;
import com.gerald.elastic.core.apis.client.ElasticClient;
import com.gerald.elastic.core.apis.exceptions.CreateIndexException;
import com.gerald.elastic.core.meta.data.model.FieldMeta;
import com.gerald.elastic.core.meta.data.model.IndexMeta;
import com.gerald.elastic.core.meta.data.model.MappingMeta;
import com.gerald.elastic.core.meta.data.model.MetaData;

public class IndexManagerImpl implements IndexManager {
	private static final Logger logger = LogManager.getLogger(IndexManagerImpl.class);
	
	private ElasticClient client;
	
	private  MetaData meta;
	
	public IndexManagerImpl(ElasticClient client, MetaData meta) {
		this.client = client;
		this.meta = meta;
	}

	@Override
	public Collection<String> allIndices() {
		return Collections.unmodifiableCollection(meta.getIndicies().keySet());
	}

	@Override
	public void isIndexCreated(String index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isIndexMappingMatching(String index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createIndex(String index) {
		IndexMeta indexMeta = meta.getIndicies().get(index);
		
		CreateIndexRequestBuilder builder = client.client().admin().indices()
				.prepareCreate(indexMeta.getName()).setSettings(indexMeta.getSettings());
		
		try {
			for(MappingMeta mapping : indexMeta.getMappings()) {
				XContentBuilder contentBuilder = XContentFactory.jsonBuilder();
				mappingsBuilder(mapping.getFields(), contentBuilder, mapping.getType());
				builder.addMapping(mapping.getType(), contentBuilder);
			}
			
			CreateIndexResponse response = builder.get();
			
			if(!response.isAcknowledged()) {
				throw new CreateIndexException(index, response.toString());
			}
			
			logger.info("creating index[" + index + "] DONE");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void mappingsBuilder(Set<FieldMeta<?>> mappings, XContentBuilder builder, String objectName) throws IOException {
		builder.startObject().startObject(objectName).startObject("properties");
		
		for(FieldMeta<?> field : mappings) {
			logger.debug(field.getFieldName());
			
			builder.startObject(field.getFieldName());
			
			FieldModel<?> model = field.getSource().getModel();
			addFieldParams(builder, model);
			
			if((model.getDocType() == DocType.OBJECT) || (model.getDocType() == DocType.NESTED)) {
				
			} else if(model.getDocType() == DocType.STRING) {
				
			}
			
			builder.endObject();
		}
		
		builder.endObject().endObject().endObject();	
		
		logger.debug(builder.string());
	}
	
	private void addFieldParams(XContentBuilder builder, FieldModel<?> model) throws IOException {
		if(model.getDocType() != DocType.OBJECT) {
			builder.field("type", model.getDocType().getDocType());
		}
		
		for(Map.Entry<String, Object> entry : model.params().entrySet()) {
			builder.field(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public void dropIndex(String index) {
		// TODO Auto-generated method stub
		
	}

}

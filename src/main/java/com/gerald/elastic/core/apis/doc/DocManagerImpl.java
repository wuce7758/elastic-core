package com.gerald.elastic.core.apis.doc;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import com.gerald.elastic.core.apis.client.ElasticClient;
import com.gerald.elastic.core.apis.type.SearchModel;
import com.gerald.elastic.core.meta.data.model.MetaData;

public class DocManagerImpl implements DocManager {
	public DocManagerImpl(ElasticClient client, MetaData meta) {
		
	}

	@Override
	public void update(Class<? extends SearchModel<?>> clazz, Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SearchModel<?> model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partialUpdate(Class<? extends SearchModel<?>> clazz,
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partialUpdate(SearchModel<?> model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Class<? extends SearchModel<?>> clazz, Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batchUpdate(Class<? extends SearchModel<?>> clazz,
			Object... ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batchUpdate(Collection<SearchModel<?>> models) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batchPartialUpdate(Class<? extends SearchModel<?>> clazz,
			Collection<Map<String, Object>> maps) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batchPartialUpdate(Collection<SearchModel<?>> models) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batchDelete(Class<? extends SearchModel<?>> clazz,
			Object... ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sync(Class<? extends SearchModel<?>> clazz, Date start, Date end) {
		// TODO Auto-generated method stub
		
	}

}

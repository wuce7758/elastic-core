package com.gerald.elastic.core.debug;

import java.util.Date;
import java.util.Iterator;

import com.gerald.elastic.core.annotations.datasource.DataSource;

public class MyDataSource implements DataSource<BasicMapping, Long> {

	@Override
	public BasicMapping getItem(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<BasicMapping> getItems(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<BasicMapping> getItems(Long... ids) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.gerald.elastic.core.debug.index;

import java.util.Date;
import java.util.Iterator;

import com.gerald.elastic.core.annotations.datasource.DataSource;

public class GoodsDatasource implements DataSource<Goods, Long> {

	@Override
	public Goods getItem(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Goods> getItems(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Goods> getItems(Long... ids) {
		// TODO Auto-generated method stub
		return null;
	}

}

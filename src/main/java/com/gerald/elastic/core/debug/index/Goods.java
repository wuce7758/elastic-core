package com.gerald.elastic.core.debug.index;

import com.gerald.elastic.core.annotations.model.Index;
import com.gerald.elastic.core.annotations.model.Mapping;

@Index(name = "test_index")
@Mapping(index = "test_index", type = "test_goods", datasource = GoodsDatasource.class)
public class Goods {
	private String name;
	
	private Double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}

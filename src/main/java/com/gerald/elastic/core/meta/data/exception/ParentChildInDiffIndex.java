package com.gerald.elastic.core.meta.data.exception;

import com.gerald.elastic.core.meta.data.model.MappingMeta;

public class ParentChildInDiffIndex extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8592239253691340966L;

	private MappingMeta parent;
	
	private MappingMeta child;
	
	public ParentChildInDiffIndex(MappingMeta parent, MappingMeta child) {
		super("parent = " + parent.getEntity() + ", child = " + child.getEntity());
		this.parent = parent;
		this.child = child;
	}

	public MappingMeta getParent() {
		return parent;
	}

	public MappingMeta getChild() {
		return child;
	}
}

package com.f2f.entity.common;

import com.f2f.dbc.persistence.entity.BaseEntity;

public class EmailWrapper extends BaseEntity {

	private Email data;

	public Email getData() {
		return data;
	}

	public void setData(Email data) {
		this.data = data;
	}
	
}

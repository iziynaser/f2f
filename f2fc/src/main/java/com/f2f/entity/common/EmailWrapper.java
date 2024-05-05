package com.f2f.entity.common;

//import com.revengemission.sso.oauth2.server.persistence.entity.BaseEntity;
import com.f2f.persistance.entity.BaseEntity;

public class EmailWrapper extends BaseEntity {

	private Email data;

	public Email getData() {
		return data;
	}

	public void setData(Email data) {
		this.data = data;
	}
	
}

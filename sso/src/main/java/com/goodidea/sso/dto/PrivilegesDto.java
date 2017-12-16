package com.goodidea.sso.dto;

import java.io.Serializable;

public class PrivilegesDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4412252447972935203L;

	/***
	 * 权限名称
	 * 
	 * 
	 */
	
	private String id;
	private String name;
	
	private String alias;
	
	/** 描述*/
	private String description;
	
	/** 是否启用 */
	private int isEnabled;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(int isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	
	
}

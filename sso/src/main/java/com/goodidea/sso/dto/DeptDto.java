package com.goodidea.sso.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class DeptDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1833757229191247553L;
	
	private String id;
	
	/** 部门名称*/
	private String name;
	
	/** 上级部门*/
	private String parentId;
	
	/** 部门类型*/
	private String deptType;
	
	/** 部门等级*/
	private String deptLevel;
	
	private Set<DeptDto> childSet = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDeptType() {
		return deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	public String getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<DeptDto> getChildSet() {
		return childSet;
	}

	public void setChildSet(Set<DeptDto> childSet) {
		this.childSet = childSet;
	}
	
	
	
	
	
}

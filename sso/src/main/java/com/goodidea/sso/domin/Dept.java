package com.goodidea.sso.domin;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.goodidea.sso.core.BaseEntity;

@Entity
@Table(name = "sso_dept")
@GenericGenerator(name = "sequenceGenerator", strategy = "uuid")
public class Dept extends BaseEntity<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9129732888079113779L;

	/** 部门名称*/
	private String name;
	
	/** 上级部门*/
	private String parentId;
	
	/** 部门类型*/
	private String deptType;
	
	/** 部门等级*/
	private String deptLevel;
	
	private Set<User> users =new HashSet<>();
	
	@Column(name = "t_name",nullable=false,length=200)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "t_parent_id",nullable=false,length=32)
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	@Column(name = "t_dept_type",nullable=true,length=200)
	public String getDeptType() {
		return deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}
	
	@Column(name = "t_dept_level",nullable=true,length=200)
	public String getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
	}
	
	@OneToMany(mappedBy = "dept", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
	
	
	
}

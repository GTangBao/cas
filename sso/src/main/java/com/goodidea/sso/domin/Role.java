/*
 * Copyright 2005-2015 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.goodidea.sso.domin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeConverter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.goodidea.sso.core.BaseEntity;

/**
 * 
* @ClassName: Role 
* @Description:  角色
* @author lsg
* @date 2017年8月14日 上午11:15:10 
*
 */
@Entity
@Table(name = "sso_role")
@GenericGenerator(name = "sequenceGenerator", strategy = "uuid")
public class Role extends BaseEntity<Long> {

	private static final long serialVersionUID = -5785023385306172131L;

	/** 名称 */
	private String name;

	
	/** 别名标识 */
	private String alias;

	/** 描述 */
	private String description;
	
	/** 是否能启用*/
	private int enabled;

	/** 用户*/
	private Set<User> users = new HashSet<User>();
	
	/** 资源*/
	private Set<Resources> resources = new HashSet<Resources>();
	

	/**
	 * 获取名称
	 * 
	 * @return 名称
	 */
	@Column(nullable = false,name="t_name",length=100)
	public String getName() {
		return name;
	}

	/**
	 * 设置名称
	 * 
	 * @param name
	 *            名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "t_alias",nullable=false,length=100)
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * 获取描述
	 * 
	 * @return 描述
	 */
	@Column(name="t_description",nullable=true,length=200)
	public String getDescription() {
		return description;
	}

	/**
	 * 设置描述
	 * 
	 * @param description
	 *            描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	@Column(name="t_enable",nullable=false,length=5)
	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "sso_role_resource",
			joinColumns=@JoinColumn(name="t_role_id"),
			inverseJoinColumns=@JoinColumn(name="t_resource_id"))
	public Set<Resources> getResources() {
		return resources;
	}

	public void setResources(Set<Resources> resources) {
		this.resources = resources;
	}

	
	
	
	

}

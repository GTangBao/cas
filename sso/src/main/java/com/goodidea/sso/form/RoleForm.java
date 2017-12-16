/*
 * Copyright 2005-2015 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.goodidea.sso.form;

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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.goodidea.sso.core.BaseEntity;

/**
 * 
* @ClassName: Role 
* @Description:  角色Form
* @author lsg
* @date 2017年8月14日 上午11:15:10 
*
 */
public class RoleForm extends BaseForm {

	private static final long serialVersionUID = -5785023385346172131L;

	/** 名称 */
	private String name;

	
	/** 别名标识 */
	private String alias;

	
	/** 是否能启用*/
	private int enabled;
	
	/** 描述 */
	private String description;
	
	private String[] resourceIds;
	

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

	
	@Column(name="t_enable",nullable=false,length=5)
	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String[] resourceIds) {
		this.resourceIds = resourceIds;
	}
	
	

}

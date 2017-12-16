package com.goodidea.sso.domin;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.goodidea.sso.core.BaseEntity;

/**
 * 
* @ClassName: Privileges 
* @Description:  权限
* @author lsg
* @date 2017年8月15日 上午10:42:45 
*
 */
@Entity
@Table(name = "sso_privileges")
@GenericGenerator(name = "sequenceGenerator", strategy = "uuid")
public class Privileges extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2398441911362935147L;
	
	/***
	 * 权限名称
	 */
	private String name;
	
	private String alias;
	
	/** 描述*/
	private String description;
	
	/** 是否启用 */
	private int isEnabled;
	
/*	*//** 资源*//*
	private Set<Resources> resources = new HashSet<Resources>();
*/	
	@Column(name = "t_name",nullable=false,length=100)
	public String getName() {
		return name;
	}

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
	
	@Column(name = "t_description",nullable=false,length=200)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="t_isable",nullable=false,length=5)
	public int getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(int isEnabled) {
		this.isEnabled = isEnabled;
	}
	
/*	@ManyToMany(mappedBy = "privileges", fetch = FetchType.LAZY)
	public Set<Resources> getResources() {
		return resources;
	}

	public void setResources(Set<Resources> resources) {
		this.resources = resources;
	}*/
	
}

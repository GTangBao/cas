package com.goodidea.sso.form;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.goodidea.sso.core.BaseEntity;

/**
 * 
* @ClassName: Resource 
* @Description:  资源
* @author lsg
* @date 2017年8月15日 上午10:29:02 
*
 */
public class ResourceForm extends BaseForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 资源名称*/
	private String name;
	
	/** 资源别称*/
	private String alias;
	
	/** 资源路径*/
	private String url;
	
	/** 资源上级*/
	private String parentId;
	
	/** 描述 */
	private String description;
	
	private String[] privilegeIds;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(String[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
	
	
	
	
}

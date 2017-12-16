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
* @ClassName: Menu 
* @Description:  菜单
* @author lsg
* @date 2017年9月5日 下午6:32:14 
*
 */
public class MenuForm extends BaseForm{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7759280417779173685L;

	/** 菜单名称*/
	private String name;
	
	/** 菜单别称*/
	private String alias;
	
	/** 菜单路径*/
	private String url;
	
	/** 菜单上级*/
	private String parentId;
	
	/** 描述 */
	private String description;
	
	private String[] privilegeIds;
	
	private String systemId;

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

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	
	
	
	
	
}

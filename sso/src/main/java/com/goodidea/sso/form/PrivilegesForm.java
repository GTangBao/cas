package com.goodidea.sso.form;

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
public class PrivilegesForm extends BaseForm{

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

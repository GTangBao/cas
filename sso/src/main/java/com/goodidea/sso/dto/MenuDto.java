package com.goodidea.sso.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.goodidea.sso.domin.Privileges;
import com.goodidea.sso.domin.Role;
import com.goodidea.sso.domin.Systems;

public class MenuDto implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5669576931197311813L;
	
	private String id;

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
	
	Set<MenuDto>  childSet= new  HashSet<MenuDto>();
	
	/** 权限*/
	Set<Privileges>  privileges= new  HashSet<Privileges>();

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


	public Set<Privileges> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privileges> privileges) {
		this.privileges = privileges;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

	public Set<MenuDto> getChildSet() {
		return childSet;
	}

	public void setChildSet(Set<MenuDto> childSet) {
		this.childSet = childSet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuDto other = (MenuDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	


	
	
	
}

package com.goodidea.sso.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.goodidea.sso.domin.Privileges;
import com.goodidea.sso.domin.Role;
import com.goodidea.sso.domin.Systems;

public class ResourcesDto implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5569576931197311813L;
	
	private String id;

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
	
	Set<ResourcesDto>  childSet= new  HashSet<ResourcesDto>();
	
	/** 权限*/
	Set<PrivilegesDto>  privileges= new  HashSet<PrivilegesDto>();

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




	public Set<PrivilegesDto> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<PrivilegesDto> privileges) {
		this.privileges = privileges;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

	public Set<ResourcesDto> getChildSet() {
		return childSet;
	}

	public void setChildSet(Set<ResourcesDto> childSet) {
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
		ResourcesDto other = (ResourcesDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	


	
	
	
}

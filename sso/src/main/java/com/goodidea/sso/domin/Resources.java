package com.goodidea.sso.domin;

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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.goodidea.sso.core.BaseEntity;

/**
 * 
* @ClassName: Resource 
* @Description:  
* @author lsg
* @date 2017年8月15日 上午10:29:02 
*
 */
@Entity
@Table(name = "sso_resource")
@GenericGenerator(name = "sequenceGenerator", strategy = "uuid")
public class Resources extends BaseEntity<Long>{
	
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
	
	/** 角色*/
	Set<Role> roles = new  HashSet<Role>();
	
	/** 权限*/
	Set<Privileges>  privileges= new  HashSet<Privileges>();
	
	/** 系统应用*/
	private Systems systems;
	
	
	
	@Column(name="t_name",nullable=false,length=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="t_alias",nullable=false,length=100)
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	@Column(name="t_url",nullable=false,length=100)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name="t_parent_id",nullable=true,length=32)
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	@Column(name="t_description",nullable=true,length=200)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToMany(mappedBy = "resources", fetch = FetchType.LAZY)
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_system_id",nullable = true, updatable = true)
	public Systems getSystems() {
		return systems;
	}

	public void setSystems(Systems systems) {
		this.systems = systems;
	}
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="sso_resource_privileges",
			joinColumns=@JoinColumn(name="t_resource_id"),
			inverseJoinColumns=@JoinColumn(name="t_privileges_id"))
	public Set<Privileges> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privileges> privileges) {
		this.privileges = privileges;
	}
	
	
	
	
	
}

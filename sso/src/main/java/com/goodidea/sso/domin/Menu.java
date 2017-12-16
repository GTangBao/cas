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
@Entity
@Table(name = "sso_menu")
@GenericGenerator(name = "sequenceGenerator", strategy = "uuid")
public class Menu extends BaseEntity<Long> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2689749190212991805L;

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
	
	private Systems systems;
	
	/** 权限*/
	Set<Privileges>  privileges= new  HashSet<Privileges>();
	
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
	
	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.MERGE)
	@JoinTable(name="sso_menu_privileges",
			joinColumns=@JoinColumn(name="t_menu_id"),
			inverseJoinColumns=@JoinColumn(name="t_privileges_id"))
	public Set<Privileges> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privileges> privileges) {
		this.privileges = privileges;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_system_id",nullable = true, updatable = true)
	public Systems getSystems() {
		return systems;
	}

	public void setSystems(Systems systems) {
		this.systems = systems;
	}
}

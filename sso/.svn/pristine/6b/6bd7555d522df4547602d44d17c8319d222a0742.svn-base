package com.goodidea.sso.domin;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.goodidea.sso.core.BaseEntity;

/**
 * 
* @ClassName: System 
* @Description:  应用系统实体
* @author lsg
* @date 2017年8月11日 下午3:04:39 
*
 */
@Entity
@Table(name="sso_system")
@GenericGenerator(name = "sequenceGenerator", strategy = "uuid")
public class Systems extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4734545880715090494L;
	
	/**系统名称*/
	private String name;
	
	/** 域名*/
	private String url;
	
	/** 端口*/
	private String port;
	
	/** 是否启用 */
	private int isEnabled;
	
	/** 系统标识*/ 
	private String code;
	
	/** 系统别称*/
	private String alias;
	
	/** 资源*/
	private Set<Menu> menus = new HashSet<Menu>();
	
	
	@Column(name="t_name",nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="t_url",nullable=false)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name="t_port",nullable=false)
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
	@Column(name="t_isable",nullable=false)
	public int getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(int isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	
	@Column(name="t_code",nullable=false,unique=true)
	public String getCode() {
		return code;
	}
	


	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="t_alias",nullable=false)
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	@OneToMany(mappedBy = "systems", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	
	
	
	

	
	
	
	
	

}

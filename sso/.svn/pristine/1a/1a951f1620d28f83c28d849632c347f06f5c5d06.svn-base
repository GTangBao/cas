package com.goodidea.sso.domin;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import com.goodidea.sso.core.BaseEntity;


/**
 * 
* @ClassName: User 
* @Description: 用户实体 
* @author lsg
* @date 2017年7月31日 下午6:57:25 
*
 */
@Entity
@Table(name = "sso_users")
@GenericGenerator(name = "sequenceGenerator", strategy = "uuid")
public class User extends BaseEntity<Long> {
	

	private static final long serialVersionUID = 1L;
	
	/** 用户名*/
	private String username;
	
	/** 密码*/
	private String password;
	
	/** 是否启用 */
	private int enabled; //1是启动,0是禁止

	/** 是否锁定 */
	private int isLocked;//1是未锁定,0是锁定

	/** 锁定日期 */
	private Date lockedDate;
	
	/** 可以访问路径*/
	private String requestUrl;
	
	/** 角色 */
	private Set<Role> roles = new HashSet<Role>();
	
	/** 部门*/
	private Dept dept;
	

	@Column(name = "t_username",unique=true,nullable=false,length=100)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "t_password",nullable=false,length=100)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "t_locked_date",nullable=true)
	public Date getLockedDate() {
		return lockedDate;
	}
	public void setLockedDate(Date lockedDate) {
		this.lockedDate = lockedDate;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "sso_user_role",
			joinColumns=@JoinColumn(name="t_user_id"),
			inverseJoinColumns=@JoinColumn(name="t_role_id"))
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	@Column(name = "t_enable",nullable=false,length=5)
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	@Column(name = "t_locked",nullable=false,length=5)
	public int getIsLocked() {
		return isLocked;
	}
	public void setIsLocked(int isLocked) {
		this.isLocked = isLocked;
	}
	
	@Column(name = "t_request_url",nullable=true,length=250)
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_dept_id",nullable = true, updatable = true)
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	
	
	
	
}

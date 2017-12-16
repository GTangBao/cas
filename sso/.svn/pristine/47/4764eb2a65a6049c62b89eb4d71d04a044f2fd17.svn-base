package com.goodidea.sso.form;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
* @ClassName: UserForm 
* @Description:  用户Form
* @author lsg
* @date 2017年8月1日 下午3:59:15 
*
 */
public class UserForm extends BaseForm implements Serializable  {
	

	private static final long serialVersionUID = 1L;
	


	private String username;
	

	private String password;
	

	private String nick;
	

	private String email;
	

	private String phone;
	
	/** 是否启用 */
	private int enabled; //1是启动,0是禁止

	/** 是否锁定 */
	private int isLocked;//1是未锁定,0是锁定
	
	private String[] roleIds;
	/** 可以访问路径*/
	private String requestUrl;
	
	private String deptId;
	

	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public int getIsLocked() {
		return isLocked;
	}
	public void setIsLocked(int isLocked) {
		this.isLocked = isLocked;
	}
	public String[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	
	
	
	
	
	
	
	
	
}

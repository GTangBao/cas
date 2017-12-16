package com.goodidea.sso.form;

public class SystemsForm extends BaseForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2942859809691580144L;
	
	
	/**系统名称*/
	private String name;
	
	/** 域名*/
	private String url;
	
	/** 端口*/
	private String port;
	
	/** 是否启用 */
	private int isEnabled;
	
	/** 系统代码*/
	private String code;
	
	/** 系统别称*/
	private String alias;
	
	private String[] resourceIds;
	
	private String[] menuIds;
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public int getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(int isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String[] getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String[] resourceIds) {
		this.resourceIds = resourceIds;
	}

	public String[] getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String[] menuIds) {
		this.menuIds = menuIds;
	}

	
	

	

}

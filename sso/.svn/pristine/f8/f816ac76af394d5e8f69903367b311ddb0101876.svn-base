/*
 * Copyright 2005-2015 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.goodidea.sso.domin;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.ScriptAssert;

/**
 * 
* @ClassName: Setting 
* @Description: 系统配置 
* @author lsg
* @date 2017年9月14日 下午6:06:40 
*
 */
@ScriptAssert(lang = "javascript", script = "_this.usernameMaxLength >= _this.usernameMinLength && _this.passwordMaxLength >= _this.passwordMinLength")
public class Setting implements Serializable {

	private static final long serialVersionUID = -1478999889661796840L;

	/** 网站网址 */
	private String siteUrl;
	
	/** cas域名 */
	private String casUrl;
	/**
	 * 获取网站网址
	 * 
	 * @return 网站网址
	 */
	@NotEmpty
	@Length(max = 200)
	public String getSiteUrl() {
		return siteUrl;
	}

	/**
	 * 设置网站网址
	 * 
	 * @param siteUrl
	 *            网站网址
	 */
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = StringUtils.removeEnd(siteUrl, "/");
	}
	
	@NotEmpty
	@Length(max = 200)
	public String getCasUrl() {
		return casUrl;
	}

	public void setCasUrl(String casUrl) {
		this.casUrl = StringUtils.removeEnd(casUrl, "/");
	}
	
	
}
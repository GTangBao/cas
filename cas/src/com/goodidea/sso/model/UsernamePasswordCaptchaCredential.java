package com.goodidea.sso.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jasig.cas.authentication.UsernamePasswordCredential;

public class UsernamePasswordCaptchaCredential  extends UsernamePasswordCredential {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1166977121924358947L;
	
	/** 验证码*/
	 @NotNull
	 @Size(min=1, message = "required.captcha")
	private String captcha;
	
	/** 记住我*/
	private String rememberMe;
	
	

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}
	
	
	
	

}

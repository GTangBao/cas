package com.goodidea.sso.domin;

import java.io.Serializable;

/**
 * 
* @ClassName: UserDetail 
* @Description:  用户详情
* @author lsg
* @date 2017年8月15日 下午1:42:45 
*
 */
public class UserDetail implements Serializable{
	
	/** 是否过期*/
	private int isExpires;//false未过期,true是已过期
	
	/** 是否过期标识*/
	private String expiresIdent;
	
	/** 连续登录失败次数 */
	private Integer loginFailureCount;

	public int getIsExpires() {
		return isExpires;
	}

	public void setIsExpires(int isExpires) {
		this.isExpires = isExpires;
	}

	public String getExpiresIdent() {
		return expiresIdent;
	}

	public void setExpiresIdent(String expiresIdent) {
		this.expiresIdent = expiresIdent;
	}

	public Integer getLoginFailureCount() {
		return loginFailureCount;
	}

	public void setLoginFailureCount(Integer loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}
	
	
}

package com.goodidea.sso.exception;

import javax.security.auth.login.LoginException;

public class CaptchaException  extends LoginException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8416970238098388683L;
	
	 public CaptchaException() {  
	        super();  
	    }  
	  
	      
	    public CaptchaException(String msg) {  
	        super(msg);  
	    }  

}

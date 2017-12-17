package com.goodidea.sso.exception;

import javax.security.auth.login.LoginException;

public class DisableAccountException  extends LoginException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8416970298098388653L;
	
	 public DisableAccountException() {  
	        super();  
	    }  
	  
	      
	    public DisableAccountException(String msg) {  
	        super(msg);  
	    }  

}

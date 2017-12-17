package com.goodidea.sso.exception;

import javax.security.auth.login.LoginException;

public class LockedException  extends LoginException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8416970998098388683L;
	
	 public LockedException() {  
	        super();  
	    }  
	  
	      
	    public LockedException(String msg) {  
	        super(msg);  
	    }  

}

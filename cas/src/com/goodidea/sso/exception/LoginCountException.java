package com.goodidea.sso.exception;

import javax.security.auth.login.LoginException;

public class LoginCountException  extends LoginException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8416970298798388683L;
	
	 public LoginCountException() {  
	        super();  
	    }  
	  
	      
	    public LoginCountException(String msg) {  
	        super(msg);  
	    }  

}

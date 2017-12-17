package com.goodidea.sso.exception;

import javax.security.auth.login.LoginException;

public class RequestUrlException extends LoginException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -837771622848299046L;
	
	public RequestUrlException() {  
        super();  
    }  
  
      
    public RequestUrlException(String msg) {  
        super(msg);  
    }  

}

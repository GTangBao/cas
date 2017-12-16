package com.goodidea.sso.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.goodidea.sso.domin.Log;
import com.goodidea.sso.form.LogForm;
import com.goodidea.sso.form.UserForm;

public interface LogService {
	
	 Map<String, Object> findPagebyConn(final LogForm form) throws Exception;
	 /**
	  * 保存日志信息
	  * @param request
	  * @param string
	 * @throws IOException 
	  */
	void saveInfo(HttpServletRequest request, String name) throws IOException;
}

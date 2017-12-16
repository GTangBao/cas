/*
 * Copyright 2005-2015 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.goodidea.sso.controller;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goodidea.sso.domin.User;
import com.goodidea.sso.util.SpringUtils;

/**
 * 
* @ClassName: BaseController 
* @Description: 基类controller 
* @author lsg
* @date 2017年9月11日 上午9:24:52 
*
 */
public class BaseController {

	/** Logger */
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/** "验证结果"属性名称 */
	private static final String CONSTRAINT_VIOLATIONS_ATTRIBUTE_NAME = "constraintViolations";
	
	protected String getUser(HttpServletRequest request) {
		AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
		 Map<String, Object> attributes = principal.getAttributes();
		return (String)attributes.get("username");
	}

	
	protected void setSession(String key, Object value, HttpServletRequest request) {
		request.getSession().setAttribute(key, value);
	}
	



	
	/***
	 * 获取项目物理路径
	 * @author WangTang
	 * @date 2016-5-20
	 * @param request
	 * @return
	 */
	public String getProjectMirPath(HttpServletRequest request){
		return request.getServletContext().getRealPath("/");
	}
	



	/**
	 * 获取国际化消息
	 * 
	 * @param code
	 *            代码
	 * @param args
	 *            参数
	 * @return 国际化消息
	 */
	protected String message(String code, Object... args) {
		return SpringUtils.getMessage(code, args);
	}
	/***
	 * 获取项目相对路径
	 * @author WangTang
	 * @date 2016-4-27
	 * @param request
	 * @return
	 */
	public String getProjectPath(HttpServletRequest request){
		return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	}
	
	
}
package com.goodidea.sso.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.goodidea.sso.aop.SystemLog;
import com.goodidea.sso.domin.User;
import com.goodidea.sso.form.LogForm;
import com.goodidea.sso.service.LogService;
import com.goodidea.sso.service.SystemsLogService;

@Controller()
@RequestMapping("/systemslog")
public class SystemsLogController  extends BaseController{
	
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Resource
	private SystemsLogService systemsLogService;
	
	@SystemLog(operatorType="访问系统日志列表页面",isSaveRequestData=true)
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String findPage(LogForm form,Model model,HttpServletRequest request,HttpServletResponse response){
		    try { 
		    	String username = getUser(request);
		    	form.setCreateBy(username );
		    	Map<String,Object> pages  = systemsLogService.findPagebyConn(form);
		        model.addAttribute("pages",pages); 
		      
		    } catch (Exception e) { 
		    	logger.info(e.getMessage());
		      e.printStackTrace(); 
		    } 
		    
		return "systemslog/list";
		
		
	}
}

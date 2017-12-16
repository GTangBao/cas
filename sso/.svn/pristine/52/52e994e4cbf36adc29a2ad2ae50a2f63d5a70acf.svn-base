package com.goodidea.sso.controller;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AssertionHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.goodidea.sso.aop.SystemLog;
import com.goodidea.sso.service.UserService;

/**
 * 
* @ClassName: IndexController 
* @Description:  首页controller
* @author lsg
* @date 2017年7月5日 下午5:01:31 
*
 */
@Controller
public class IndexController extends BaseController {
	
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * 跳转首页
	 * @return
	 */
	@RequestMapping("/home")
	@SystemLog(operatorType="系统管理首页",isSaveRequestData=true)
	public String main(Model model,HttpServletRequest request){
		 try {
			AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
			 Map<String, Object> attributes = principal.getAttributes();
			 setSession("user",userService.findUserByUsername((String)attributes.get("username")),request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return "main";
	}
	
	
}

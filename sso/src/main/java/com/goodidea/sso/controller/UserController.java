package com.goodidea.sso.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.goodidea.sso.aop.SystemLog;
import com.goodidea.sso.core.JsonVo;
import com.goodidea.sso.domin.Dept;
import com.goodidea.sso.domin.Role;
import com.goodidea.sso.domin.Setting;
import com.goodidea.sso.domin.Systems;
import com.goodidea.sso.domin.User;
import com.goodidea.sso.form.DeptForm;
import com.goodidea.sso.form.RoleForm;
import com.goodidea.sso.form.SystemsForm;
import com.goodidea.sso.form.UserForm;
import com.goodidea.sso.service.DeptService;
import com.goodidea.sso.service.RoleService;
import com.goodidea.sso.service.SystemsService;
import com.goodidea.sso.service.UserService;
import com.goodidea.sso.util.PageUtils;
import com.goodidea.sso.util.SystemUtils;

/**
 * 
* @ClassName: UserController 
* @Description:  用户controller
* @author lsg
* @date 2017年7月5日 下午5:02:32 
*
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	@Resource
	private SystemsService systemsService;
	@Resource
	private DeptService deptService;
	
	
	/**
	 * 获取请求拦截路径
	 * @param id
	 * @return
	 */
	@SystemLog(operatorType="获取拦截系统路径",isSaveRequestData=true)
	@RequestMapping(value="/getRequestUrl/{username}",method=RequestMethod.GET)
	@ResponseBody
	public JsonVo getRequestUrl(@PathVariable String username){
		JsonVo vo = new JsonVo();
		try {
			if(StringUtils.isNotBlank(username)){
				User user = userService.findUserByUsername(username);
				if(StringUtils.isNotBlank(user.getRequestUrl())){
					vo.setObj(user.getRequestUrl());
					vo.setSuccess(true);
				}else{
					vo.setSuccess(false);
				}
				
			}else{
				vo.setSuccess(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
		
	}
	
	/**
	 * 用户列表
	 * @param form
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@SystemLog(operatorType="访问用户列表",isSaveRequestData=true)
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String findPage(UserForm form,Model model,HttpServletRequest request,HttpServletResponse response){
		    try { 
		    	 Map<String,Object>	pages  = userService.findPagebyConn(form);
			      model.addAttribute("pages",pages); 
			      model.addAttribute("username",form.getUsername()); 
		    } catch (Exception e) { 
		      logger.info(e.getMessage());
		      e.printStackTrace(); 
		    } 
		    
		return "/user/list";
		
		
	}
	
	@RequestMapping(value="/jssdk",method=RequestMethod.GET)
	public String jsdk(UserForm form,Model model,HttpServletRequest request,HttpServletResponse response){
		    
		return "/user/jssdk";
		
		
	}
	
	
	
	/**
	 * 删除会员
	 * @param id
	 * @return
	 */
	@SystemLog(operatorType="进行删除用户",isSaveRequestData=true)
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	@ResponseBody
	public JsonVo deleteUser(String id){
		JsonVo vo = new JsonVo();
		try {
			if(StringUtils.isNotBlank(id)){
				userService.delete(id);
				vo.setSuccess(true);
			}else{
				vo.setSuccess(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
		
	}
	
	/**
	 * 跳转会员添加页面
	 * @return
	 */
	@RequestMapping("/add")
	@SystemLog(operatorType="跳转会员添加页面",isSaveRequestData=true)
	public String  add( Model model, RoleForm form){
		try {
			List<Role> roles = roleService.findAllByConn(form);
			model.addAttribute("roles", roles);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "user/add";
		
	}
	
	/**
	 * 保存用户信息
	 * @param form
	 * @return
	 */
	@SystemLog(operatorType="进行保存用户信息",isSaveRequestData=true)
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(UserForm form){
	
		try {
			userService.saveUserInfo(form);
	
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return "redirect:list";
		
		
	}
	
	/**
	 * 跳转会员编辑页面
	 * @return
	 */
	@SystemLog(operatorType="访问用户编辑页面",isSaveRequestData=true)
	@RequestMapping("/edit")
	public String  edit( String id,Model model, RoleForm form,SystemsForm forms){
		try {
			List<Role> roles = roleService.findAllByConn(form);
			User user = userService.findEntityById(id);
			forms.setIsEnabled(2);
			List<Systems> systems = systemsService.findSystemsByConn(forms);
			model.addAttribute("user", user);
			model.addAttribute("systems", systems);
			model.addAttribute("roles", roles);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "user/edit";
		
	}
	
	/**
	 * 更新用户信息
	 * @param form
	 * @return
	 */
	@SystemLog(operatorType="进行更新用户信息",isSaveRequestData=true)
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(UserForm form){
	
		try {
			userService.updateUserInfo(form);
	
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return "redirect:list";
		
		
	}
	
	
	
	
	
}

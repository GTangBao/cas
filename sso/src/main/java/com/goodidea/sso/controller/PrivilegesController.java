package com.goodidea.sso.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodidea.sso.aop.SystemLog;
import com.goodidea.sso.core.JsonVo;
import com.goodidea.sso.domin.Menu;
import com.goodidea.sso.domin.Privileges;
import com.goodidea.sso.domin.Resources;
import com.goodidea.sso.domin.Role;
import com.goodidea.sso.domin.Systems;
import com.goodidea.sso.dto.ResourcesDto;
import com.goodidea.sso.form.PrivilegesForm;
import com.goodidea.sso.form.ResourceForm;
import com.goodidea.sso.form.RoleForm;
import com.goodidea.sso.form.SystemsForm;
import com.goodidea.sso.service.PrivilegesService;
import com.goodidea.sso.service.RedisService;
import com.goodidea.sso.service.ResourceService;
import com.goodidea.sso.service.RoleService;
import com.goodidea.sso.service.SystemsService;

/**
 * 
* @ClassName: PrivilegesController 
* @Description:  权限
* @author lsg
* @date 2017年8月15日 下午4:31:48 
*
 */
@Controller
@RequestMapping("/privileges")
public class PrivilegesController extends BaseController{
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private PrivilegesService privilegesService;
	@Autowired
	private RedisService redisService;
	
	
	/**
	 * 权限别称校验
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/checkAlias")
	@ResponseBody
	public JsonVo tree(String  alias){
		JsonVo vo = new JsonVo();
		try {
		Privileges privileges = privilegesService.findPrivilegesByAlias(alias);
			if(privileges ==null){
				vo.setSuccess(true);
			}else{
				vo.setSuccess(false);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			vo.setSuccess(false);
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return vo;
		
	}
	
	
	/**
	 * 根据用户名和系统辨识查找用户权限
	 * @param username
	 * @param system
	 * @return
	 */
	@SystemLog(operatorType="获取用户权限",isSaveRequestData=true)
	@RequestMapping(value="/getPrivileges/{code}/{username}")
	@ResponseBody
	public JsonVo getPrivilges(@PathVariable String code,@PathVariable String username){
		JsonVo vo = new JsonVo();
		try {
			Set dtos = privilegesService.findPrivilegesByCodeAndUsername(code,username);
			if(dtos.isEmpty()){
				vo.setSuccess(false);
			}else{
				vo.setObjs(dtos);
				vo.setSuccess(true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			vo.setSuccess(false);
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return vo;
		
	}
	
	/**
	 * 通过用户名获取资源权限
	 * @param username
	 * @return
	 */
	@SystemLog(operatorType="获取用户权限",isSaveRequestData=true)
	@RequestMapping(value="/getResources/{username}")
	@ResponseBody
	public Map<String,Object> getResourcesByUserName(@PathVariable String username){
		Map<String,Object> data = new HashMap();
		try {
			
			Set dtos = privilegesService.findResourcesByUsername(username);
			if(dtos.isEmpty()){
				data.put("success",false);
			}else{
				data.put("objs", dtos);
				data.put("success",true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			data.put("success",false);
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return data;
		
	}
	
	
	/**
	 * 权限列表
	 * @param form
	 * @param model
	 * @return
	 */
	@SystemLog(operatorType="访问用户权限列表",isSaveRequestData=true)
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String findPage(PrivilegesForm form,Model model){
		try {
			Map<String, Object> pages = privilegesService.findPagebyConn(form);
			model.addAttribute("pages", pages);
			model.addAttribute("entity", form);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return "privileges/list";
		
	}
	
	/**
	 * 跳转添加页面
	 * @return
	 */
	@SystemLog(operatorType="访问权限添加页面",isSaveRequestData=true)
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(){
		
		return "privileges/add";
		
		
	}
	/**
	 * 保存权限信息
	 * @param role
	 * @return
	 */
	@SystemLog(operatorType="进行权限保存",isSaveRequestData=true)
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Privileges privileges){
		try {
			privilegesService.save(privileges);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return "redirect:list";
		
	}
	
	/**
	 * 跳转编辑页面
	 * @return
	 */
	@SystemLog(operatorType="访问权限编辑页面",isSaveRequestData=true)
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(Model model,String id){
		try {
			Privileges privileges = privilegesService.findEntityById(id);
			model.addAttribute("entity", privileges);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return "privileges/edit";
		
		
	}
	
	/**
	 * 更新权限信息
	 * @param form
	 * @return
	 */
	@SystemLog(operatorType="进行权限更新",isSaveRequestData=true)
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(PrivilegesForm form){
		try {
			privilegesService.updateInfo(form);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return "redirect:list";
		
	}
	
	/**
	 * 删除权限信息
	 * @param form
	 * @return
	 */
	@SystemLog(operatorType="删除用户权限",isSaveRequestData=true)
	@RequestMapping(value="/delete")
	@ResponseBody
	public JsonVo delete(PrivilegesForm form){
		JsonVo vo = new JsonVo();
		try {
			Privileges privileges = privilegesService.findEntityById(form.getId());
			privilegesService.delete(privileges);
			redisService.deletes("privileges");
			vo.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			vo.setSuccess(false);
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return vo;
		
	}
	
}

package com.goodidea.sso.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.client.authentication.AttributePrincipal;
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
import com.goodidea.sso.domin.Resources;
import com.goodidea.sso.domin.Role;
import com.goodidea.sso.domin.Systems;
import com.goodidea.sso.dto.ResourcesDto;
import com.goodidea.sso.form.ResourceForm;
import com.goodidea.sso.form.RoleForm;
import com.goodidea.sso.form.SystemsForm;
import com.goodidea.sso.service.RedisService;
import com.goodidea.sso.service.ResourceService;
import com.goodidea.sso.service.RoleService;
import com.goodidea.sso.service.SystemsService;

/**
 * 
* @ClassName: SystemsController 
* @Description:  角色管理
* @author lsg
* @date 2017年8月11日 下午3:35:44 
*
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController{
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private RoleService roleService;
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private RedisService redisService;
	/**
	 * 绑定权限
	 * @param rid
	 * @param pid
	 * @return
	 */
	@SystemLog(operatorType="进行资权限绑定",isSaveRequestData=true)
	@RequestMapping(value = "/bingingPrivilege",method=RequestMethod.POST)
	@ResponseBody
	public JsonVo bingingPrivilege(HttpServletRequest request,String rid,String...pid){
		JsonVo vo = new JsonVo();
		vo.setSuccess(false);
		try {
			roleService.bingingPrivileges(rid, pid);
			vo.setSuccess(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return vo;
}

	
	
	/**
	 * 根据角色ID获取资源权限信息
	 * @param id
	 * @return
	 */
	@SystemLog(operatorType="获取资源权限信息",isSaveRequestData=true)
	@RequestMapping(value="/getPrivilegeByRoleId" ,method=RequestMethod.POST)
	@ResponseBody
	public JsonVo getPrivilege(String id){
		JsonVo vo = new JsonVo();
		try {
			Set<ResourcesDto> dtos = roleService.getPrivilegeByRoleId(id);
			if(dtos.isEmpty()){
				vo.setSuccess(false);
			}else{
				vo.setObj(dtos);
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
	 * 跳转绑定角色
	 * @param form
	 * @param model
	 * @return
	 */
	@SystemLog(operatorType="进行绑定角色",isSaveRequestData=true)
	@RequestMapping(value="/bind",method=RequestMethod.GET)
	public String bindPrivilege(RoleForm form,Model model){
		try {
			List<Role> roles = roleService.findAllByConn(form);
			model.addAttribute("roles", roles);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return "role/bindPrivileges";
		
	}
	
	
	/**
	 * 角色列表
	 * @param form
	 * @param model
	 * @return
	 */
	@SystemLog(operatorType="访问角色列表",isSaveRequestData=true)
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String findPage(RoleForm form,Model model){
		try {
			Map<String, Object> pages = roleService.findPagebyConn(form);
			model.addAttribute("pages", pages);
			model.addAttribute("form", form);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return "role/list";
		
	}
	
	/**
	 * 跳转添加页面
	 * @return
	 */
	@SystemLog(operatorType="访问角色添加页面",isSaveRequestData=true)
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model,ResourceForm form){
		/*try {
			List<Resources> resources = resourceService.findResourcesByConn(form);
			model.addAttribute("resources", resources);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			e.printStackTrace();
		}*/
		return "role/add";
		
		
	}
	/**
	 * 保存角色信息
	 * @param role
	 * @return
	 */
	@SystemLog(operatorType="进行角色保存",isSaveRequestData=true)
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(RoleForm form){
		try {
			roleService.saveInfo(form);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return "redirect:list";
		
	}
	
	/**
	 * 跳转编辑页面
	 * @return
	 */
	@SystemLog(operatorType="访问角色编辑页面",isSaveRequestData=true)
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(Model model,String id,ResourceForm form){
		try {
//			List<Resources> resources = resourceService.findResourcesByConn(form);
			Role role = roleService.findEntityById(id);
//			model.addAttribute("resources", resources);
			model.addAttribute("role", role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return "role/edit";
		
		
	}
	
	/**
	 * 更新角色信息
	 * @param form
	 * @return
	 */
	@SystemLog(operatorType="进行资源更新",isSaveRequestData=true)
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(RoleForm form){
		try {
			roleService.updateInfo(form);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return "redirect:list";
		
	}
	
	/**
	 * 删除角色信息
	 * @param form
	 * @return
	 */
	@SystemLog(operatorType="进行资源删除",isSaveRequestData=true)
	@RequestMapping(value="/delete")
	@ResponseBody
	public JsonVo delete(RoleForm form){
		JsonVo vo = new JsonVo();
		try {
			Role role = roleService.findEntityById(form.getId());
			roleService.delete(role);
			redisService.deletes("privileges");
			vo.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			vo.setSuccess(false);
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return vo;
		
	}
	
}

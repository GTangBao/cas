package com.goodidea.sso.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodidea.sso.aop.SystemLog;
import com.goodidea.sso.core.JsonVo;
import com.goodidea.sso.domin.Privileges;
import com.goodidea.sso.domin.Resources;
import com.goodidea.sso.domin.Role;
import com.goodidea.sso.domin.Systems;
import com.goodidea.sso.dto.TreeDto;
import com.goodidea.sso.form.PrivilegesForm;
import com.goodidea.sso.form.ResourceForm;
import com.goodidea.sso.form.RoleForm;
import com.goodidea.sso.form.SystemsForm;
import com.goodidea.sso.service.PrivilegesService;
import com.goodidea.sso.service.ResourceService;
import com.goodidea.sso.service.RoleService;
import com.goodidea.sso.service.SystemsService;

/**
 * 
* @ClassName: SystemsController 
* @Description:  资源管理
* @author lsg
* @date 2017年8月11日 下午3:35:44 
*
 */
@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController{
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private PrivilegesService privilegesService;
	
	/**
	 * 资源列表
	 * @param form
	 * @param model
	 * @return
	 */
	@SystemLog(operatorType="获取资源数列表",isSaveRequestData=true)
	@RequestMapping(value="/getTree",method=RequestMethod.POST)
	@ResponseBody
	public JsonVo tree(ResourceForm form){
		JsonVo vo = new JsonVo();
		try {
			Set tree = resourceService.getTree(form);
			vo.setSuccess(true);
			vo.setObjs(tree);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			vo.setSuccess(false);
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return vo;
		
	}
	
	/**
	 * 跳转列表页面
	 * @return
	 */
	@SystemLog(operatorType="获取资源列表",isSaveRequestData=true)
	@RequestMapping(value="/listShow",method=RequestMethod.GET)
	public String show(Model model){
		return "resource/list";
		
	}
	
	
	/**
	 * 资源列表
	 * @param form
	 * @param model
	 * @return
	 */
	@SystemLog(operatorType="获取资源列表",isSaveRequestData=true)
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public JsonVo findPage(ResourceForm form,Model model){
		JsonVo vo = new JsonVo();
		try {
			vo.setObj(resourceService.getTreeGird());
			vo.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			vo.setSuccess(false);
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return vo;
		
	}
	
	/**
	 * 跳转添加页面
	 * @return
	 */
	@SystemLog(operatorType="访问资源添加页面",isSaveRequestData=true)
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(PrivilegesForm form,Model model){
		try {
			List<Privileges> privileges =  privilegesService.findPrivilegesByConn(form);
			model.addAttribute("privileges", privileges);
		} catch (Exception e) {
			logger.info(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "resource/add";
		
		
	}


	/**
	 * 保存资源信息
	 * @param role
	 * @return
	 */
	@SystemLog(operatorType="进行资源保存",isSaveRequestData=true)
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(ResourceForm form){
		try {
			resourceService.saveInfo(form);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return "redirect:listShow";
		
	}
	
	/**
	 * 跳转编辑页面
	 * @return
	 */
	@SystemLog(operatorType="访问资源编辑页面",isSaveRequestData=true)
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(Model model,String id,ResourceForm form,PrivilegesForm forms){
		try {
			Resources resource = resourceService.findEntityById(id);
			Resources  entity = resourceService.findEntityById(resource.getParentId());
			List<Privileges> privileges =  privilegesService.findPrivilegesByConn(forms);
			model.addAttribute("privileges", privileges);
			model.addAttribute("resource", resource);
			model.addAttribute("entity", entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return "resource/edit";
		
		
	}
	
	/**
	 * 更新资源信息
	 * @param form
	 * @return
	 */
	@SystemLog(operatorType="进行资源更新",isSaveRequestData=true)
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(ResourceForm form){
		try {
			resourceService.updateInfo(form);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return "redirect:listShow";
		
	}
	
	/**
	 * 删除角色信息
	 * @param form
	 * @return
	 */
	@SystemLog(operatorType="进行资源删除",isSaveRequestData=true)
	@RequestMapping(value="/delete")
	@ResponseBody
	public JsonVo delete(ResourceForm form){
		JsonVo vo = new JsonVo();
		try {
			Resources resource = resourceService.findEntityById(form.getId());
			resourceService.delete(resource);
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

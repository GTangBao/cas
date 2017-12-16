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
import com.goodidea.sso.domin.Menu;
import com.goodidea.sso.domin.Privileges;
import com.goodidea.sso.domin.Resources;
import com.goodidea.sso.domin.Role;
import com.goodidea.sso.domin.Systems;
import com.goodidea.sso.dto.MenuDto;
import com.goodidea.sso.dto.TreeDto;
import com.goodidea.sso.form.PrivilegesForm;
import com.goodidea.sso.form.MenuForm;
import com.goodidea.sso.form.RoleForm;
import com.goodidea.sso.form.SystemsForm;
import com.goodidea.sso.service.MenuService;
import com.goodidea.sso.service.PrivilegesService;
import com.goodidea.sso.service.RedisService;
import com.goodidea.sso.service.RoleService;
import com.goodidea.sso.service.SystemsService;

/**
 * 
* @ClassName: MenuController 
* @Description:  菜单管理
* @author lsg
* @date 2017年8月11日 下午3:35:44 
*
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController{
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private PrivilegesService privilegesService;
	
	@Autowired
	private RedisService redisService;
	@Autowired
	private SystemsService  systemsService;
	
	
	/**
	 * 菜单别称校验
	 * @return
	 */
	@RequestMapping(value="/checkAlias")
	@ResponseBody
	public JsonVo tree(String  alias){
		JsonVo vo = new JsonVo();
		try {
			Menu menu = menuService.findMenuByAlias(alias);
			if(menu ==null){
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
	 * 菜单列表
	 * @param form
	 * @return
	 */
	@SystemLog(operatorType="获取菜单树列表",isSaveRequestData=true)
	@RequestMapping(value="/getTree",method=RequestMethod.POST)
	@ResponseBody
	public JsonVo tree(MenuForm form){
		JsonVo vo = new JsonVo();
		try {
			TreeDto dto = new TreeDto();
			dto.setId("TOP");
			dto.setName("根目录");
			Set tree = menuService.getTree(form);
			tree.add(dto);
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
	@SystemLog(operatorType="访问菜单列表页面",isSaveRequestData=true)
	@RequestMapping(value="/listShow",method=RequestMethod.GET)
	public String show(Model model){
		try {

			List<MenuDto> dtos = menuService.getTreeGird();
			model.addAttribute("menus", dtos);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "menu/list";
		
	}
	
	
	/**
	 * 菜单列表
	 * @param form
	 * @param model
	 * @return
	 */
	@SystemLog(operatorType="获取菜单列表",isSaveRequestData=true)
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public JsonVo findPage(MenuForm form,Model model){
		JsonVo vo = new JsonVo();
		try {
			vo.setObj(menuService.getTreeGird());
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
	@SystemLog(operatorType="访问菜单添加页面",isSaveRequestData=true)
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(PrivilegesForm form, SystemsForm forms,Model model){
		try {
			
			List<Privileges> privileges =  privilegesService.findPrivilegesByConn(form);
			model.addAttribute("privileges", privileges);
			 List<Systems> systems = systemsService.findSystemsByConn(forms);
			 model.addAttribute("systems", systems);
		} catch (Exception e) {
			logger.info(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "menu/add";
		
		
	}


	/**
	 * 保存菜单信息
	 * @return
	 */
	@SystemLog(operatorType="进行菜单保存",isSaveRequestData=true)
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(MenuForm form){
		try {
			menuService.saveInfo(form);
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
	@SystemLog(operatorType="访问菜单编辑页面",isSaveRequestData=true)
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(Model model,String id,MenuForm form, SystemsForm forms,PrivilegesForm formp){
		try {
			Menu menu = menuService.findEntityById(id);
			Menu  entity = menuService.findEntityById(menu.getParentId());
			List<Privileges> privileges =  privilegesService.findPrivilegesByConn(formp);
			model.addAttribute("privileges", privileges);
			model.addAttribute("menu", menu);
			model.addAttribute("entity", entity);
			List<Systems> systems = systemsService.findSystemsByConn(forms);
			 model.addAttribute("systems", systems);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return "menu/edit";
		
		
	}
	
	/**
	 * 更新菜单信息
	 * @param form
	 * @return
	 */
	@SystemLog(operatorType="进行菜单更新",isSaveRequestData=true)
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(MenuForm form){
		try {
			menuService.updateInfo(form);
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
	@SystemLog(operatorType="删除菜单信息",isSaveRequestData=true)
	@RequestMapping(value="/delete")
	@ResponseBody
	public JsonVo delete(MenuForm form){
		JsonVo vo = new JsonVo();
		try {
			Menu menu = menuService.findEntityById(form.getId());
			menuService.delete(menu);
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

package com.goodidea.sso.controller;

import java.util.List;
import java.util.Map;

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
import com.goodidea.sso.domin.Resources;
import com.goodidea.sso.domin.Systems;
import com.goodidea.sso.form.MenuForm;
import com.goodidea.sso.form.ResourceForm;
import com.goodidea.sso.form.SystemsForm;
import com.goodidea.sso.service.MenuService;
import com.goodidea.sso.service.ResourceService;
import com.goodidea.sso.service.SystemsService;

/**
 * 
* @ClassName: SystemsController 
* @Description:  系统应用实现层
* @author lsg
* @date 2017年8月11日 下午3:35:44 
*
 */
@Controller
@RequestMapping("/systems")
public class SystemsController extends BaseController{
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private SystemsService systemsService;
//	@Autowired
//	private ResourceService resourceService;
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/verifiCode")
	@ResponseBody
	public JsonVo verifiCode(String code){
		JsonVo vo = new JsonVo();
		try {
			Systems systems = systemsService.verifiCodeUnique(code);
			if(systems==null){
				vo.setSuccess(true);
			}else{
				vo.setSuccess(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return vo;
		
		
	}
	
	/**
	 * 应用系统列表
	 * @param form
	 * @param model
	 * @return
	 */
	@SystemLog(operatorType="访问应用系统列表页面",isSaveRequestData=true)
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String findPage(SystemsForm form,Model model){
		try {
			Map<String, Object> pages = systemsService.findPagebyConn(form);
			model.addAttribute("pages", pages);
			model.addAttribute("form", form);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return "system/list";
		
	}
	
	/**
	 * 跳转添加页面
	 * @return
	 */
	@SystemLog(operatorType="访问应用系统添加页面",isSaveRequestData=true)
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model,MenuForm  form){
		try {
			List<Menu> menus = menuService.findMenuByConn(form);
			model.addAttribute("menus", menus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return "system/add";
		
		
	}
	/**
	 * 保存应用系统信息
	 * @param systems
	 * @return
	 */
	@SystemLog(operatorType="进行应用系统保存",isSaveRequestData=true)
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(SystemsForm form){
		try {
			systemsService.saveInfo(form);
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
	@SystemLog(operatorType="访问应用系统编辑页面",isSaveRequestData=true)
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit( Model model,String systemId,MenuForm form){
		try {
			List<Menu> menus = menuService.findMenuByConn(form);
			Systems systems = systemsService.findEntityById(systemId);
			model.addAttribute("menus", menus);
			model.addAttribute("system", systems);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "system/edit";
		
		
	}
	
	/**
	 * 更新应用系统信息
	 * @param systems
	 * @return
	 */
	@SystemLog(operatorType="进行应用系统更新",isSaveRequestData=true)
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(SystemsForm form){
		try {
			systemsService.updateSystemsInfo(form);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return "redirect:list";
		
	}
	
	/**
	 * 删除应用系统信息
	 * @param systems
	 * @return
	 */
	@SystemLog(operatorType="进行应用系统删除",isSaveRequestData=true)
	@RequestMapping(value="/delete")
	@ResponseBody
	public JsonVo delete(SystemsForm form){
		JsonVo vo = new JsonVo();
		try {
			Systems systems = systemsService.findEntityById(form.getId());
			systemsService.delete(systems);
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

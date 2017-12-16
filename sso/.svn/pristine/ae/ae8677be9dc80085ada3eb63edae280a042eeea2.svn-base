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
import com.goodidea.sso.domin.Dept;
import com.goodidea.sso.domin.Privileges;
import com.goodidea.sso.domin.Resources;
import com.goodidea.sso.domin.Role;
import com.goodidea.sso.domin.Systems;
import com.goodidea.sso.dto.DeptDto;
import com.goodidea.sso.dto.TreeDto;
import com.goodidea.sso.form.PrivilegesForm;
import com.goodidea.sso.form.DeptForm;
import com.goodidea.sso.form.RoleForm;
import com.goodidea.sso.form.SystemsForm;
import com.goodidea.sso.service.DeptService;
import com.goodidea.sso.service.PrivilegesService;
import com.goodidea.sso.service.RoleService;
import com.goodidea.sso.service.SystemsService;

/**
 * 
* @ClassName: DeptController 
* @Description:  部门管理
* @author lsg
* @date 2017年8月11日 下午3:35:44 
*
 */
@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController {
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private DeptService deptService;
	
	
	
	
	/**
	 * 部门列表
	 * @param form
	 * @param
	 * @return
	 */
	@SystemLog(operatorType="访问部门树列表",isSaveRequestData=true)
	@RequestMapping(value="/getTree",method=RequestMethod.POST)
	@ResponseBody
	public JsonVo tree(DeptForm form){
		JsonVo vo = new JsonVo();
		DeptDto dto = new DeptDto();
		dto.setId("TOP");
		dto.setName("根目录");
		try {
			Set tree = deptService.getTree(form);
			new Dept();
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
	@SystemLog(operatorType="访问本部列表",isSaveRequestData=true)
	@RequestMapping(value="/listShow",method=RequestMethod.GET)
	public String show(Model model,DeptForm form){
		try {
			model.addAttribute("depts",deptService.getTreeGird());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "dept/list";
		
	}
	
	
	/**
	 * 部门列表
	 * @param form
	 * @param model
	 * @return
	 */
	@SystemLog(operatorType="返回部门树列表",isSaveRequestData=true)
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public JsonVo findPage(DeptForm form,Model model){
		JsonVo vo = new JsonVo();
		
		try {
			
			List<DeptDto> dtos = deptService.getTreeGird();
			vo.setObj(dtos);
			
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
	@SystemLog(operatorType="访问部门添加页面",isSaveRequestData=true)
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(PrivilegesForm form,Model model){
		try {
		} catch (Exception e) {
			logger.info(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "dept/add";
		
		
	}


	/**
	 * 保存部门信息
	 * @param
	 * @return
	 */
	@SystemLog(operatorType="进行部门信息保存",isSaveRequestData=true)
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(DeptForm form){
		try {
			deptService.saveInfo(form);
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
	@SystemLog(operatorType="访问部门编辑页面",isSaveRequestData=true)
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(Model model,String id,DeptForm form,PrivilegesForm forms){
		try {
			Dept dept = deptService.findEntityById(id);
			Dept entity = deptService.findEntityById(dept.getParentId());
			model.addAttribute("dept", dept);
			model.addAttribute("entity", entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		return "dept/edit";
		
		
	}
	
	/**
	 * 更新部门信息
	 * @param form
	 * @return
	 */
	@SystemLog(operatorType="进行部门信息更新",isSaveRequestData=true)
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(DeptForm form){
		try {
			deptService.updateInfo(form);
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
	@SystemLog(operatorType="进行删除部门信息",isSaveRequestData=true)
	@RequestMapping(value="/delete")
	@ResponseBody
	public JsonVo delete(DeptForm form){
		JsonVo vo = new JsonVo();
		try {
			Dept dept = deptService.findEntityById(form.getId());
			deptService.delete(dept);
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

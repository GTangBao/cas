package com.goodidea.sso.service;

import java.util.List;
import java.util.Map;

import com.goodidea.sso.domin.Systems;
import com.goodidea.sso.domin.User;
import com.goodidea.sso.form.SystemsForm;
import com.goodidea.sso.form.UserForm;

/**
 * 
* @ClassName: SystemsService 
* @Description:  应用系统service
* @author lsg
* @date 2017年8月11日 下午3:09:09 
*
 */
public interface SystemsService extends BaseService<Systems, Long> {
	
	/**
	 * 根据应用系统名称查找应用
	 * @param name
	 * @return
	 * @throws Exception
	 */
	Systems findSystemsByName(String name) throws Exception;
	
	/**
	 * 应用系统分页
	 * @param form
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> findPagebyConn(SystemsForm form) throws Exception;
	
	
	
	/**
	 * 更新应用系统
	 * @param form
	 * @throws Exception
	 */
	void updateSystemsInfo(SystemsForm form) throws Exception;
	
	/**
	 * 验证编码的唯一性
	 * @param code
	 * @return
	 */
	Systems verifiCodeUnique(String code) throws Exception;
	
	/**
	 *  保存应用系统信息
	 * @param form
	 */
	void saveInfo(SystemsForm form)throws Exception;
	
	/**
	 * 根据条件查找系统
	 * @param forms
	 * @return
	 */
	List<Systems> findSystemsByConn(SystemsForm forms)throws Exception;
	
}

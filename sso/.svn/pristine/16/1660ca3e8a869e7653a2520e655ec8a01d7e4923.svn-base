package com.goodidea.sso.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.goodidea.sso.domin.Menu;
import com.goodidea.sso.domin.Resources;
import com.goodidea.sso.domin.Role;
import com.goodidea.sso.dto.MenuDto;
import com.goodidea.sso.dto.ResourcesDto;
import com.goodidea.sso.dto.TreeDto;
import com.goodidea.sso.form.MenuForm;
import com.goodidea.sso.form.RoleForm;
import com.goodidea.sso.form.SystemsForm;

/**
 * 
* @ClassName: MenuService 
* @Description:  菜单service
* @author lsg
* @date 2017年8月15日 下午3:51:40 
*
 */
public interface MenuService  extends BaseService<Menu, Long>{
	
	
	/**
	 * 更新菜单信息
	 * @param form
	 */
	void updateInfo(MenuForm form) throws Exception;
	
	
	/**
	 *  根据条件获取菜单
	 * @param form
	 * @return
	 * @throws Exception
	 */
	List<Menu> findMenuByConn(MenuForm form)throws Exception;
	
	/**
	 * 获取树
	 * @param resources
	 * @return
	 * @throws Exception
	 */
	Set getTree(MenuForm form) throws Exception;
	
	/**
	 * 保存菜单信息
	 * @param form
	 * @throws Exception 
	 */
	void saveInfo(MenuForm form) throws Exception;

	/**
	 * 封装树形列表
	 * @return
	 * @throws Exception
	 */
	List<MenuDto> getTreeGird() throws Exception;
	
	/**
	 * 根据别称查找菜单
	 * @param alias
	 * @return
	 * @throws Exception
	 */
	Menu findMenuByAlias(String alias)throws Exception;



}

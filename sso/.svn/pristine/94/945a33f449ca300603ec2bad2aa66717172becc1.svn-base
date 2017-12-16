package com.goodidea.sso.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.goodidea.sso.domin.Role;
import com.goodidea.sso.domin.User;
import com.goodidea.sso.dto.ResourcesDto;
import com.goodidea.sso.form.RoleForm;
import com.goodidea.sso.form.SystemsForm;

/**
 * 
* @ClassName: RoleService 
* @Description:  角色service
* @author lsg
* @date 2017年8月15日 下午3:53:11 
*
 */
public interface RoleService  extends BaseService<Role, Long>{
	
	/**
	 * 根据条件搜索
	 * @param form
	 * @return
	 */
	Map<String, Object> findPagebyConn(RoleForm form) throws Exception;
	
	
	/**
	 * 更新角色信息
	 * @param form
	 */
	void updateInfo(RoleForm form) throws Exception;
	
	
	/**
	 * 查找角色集合
	 * @return
	 * @throws Exception 
	 */
	List<Role> findAllByConn(RoleForm form) throws Exception;
	
	/**
	 * 保存角色信息
	 * @param form
	 */
	void saveInfo(RoleForm form) throws Exception;
	
	/**
	 * 根据角色Id 获取资源权限信息
	 * @param id
	 * @return
	 */
	Set<ResourcesDto> getPrivilegeByRoleId(String id) throws Exception;
	
	
	/**
	 * 绑定数据
	 * @param rid
	 * @param pid
	 */
	void bingingPrivileges(String rid, String[] pid) throws Exception;
	


}

package com.goodidea.sso.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.goodidea.sso.domin.Privileges;
import com.goodidea.sso.domin.Resources;
import com.goodidea.sso.domin.Role;
import com.goodidea.sso.dto.ResourcesDto;
import com.goodidea.sso.form.PrivilegesForm;
import com.goodidea.sso.form.ResourceForm;
import com.goodidea.sso.form.RoleForm;
import com.goodidea.sso.form.SystemsForm;

/**
 * 
* @ClassName: PrivilegesService 
* @Description:  权限
* @author lsg
* @date 2017年8月15日 下午4:33:25 
*
 */
public interface PrivilegesService extends BaseService<Privileges, Long> {
	
	/**
	 * 根据条件搜索
	 * @param form
	 * @return
	 */
	Map<String, Object> findPagebyConn(PrivilegesForm form) throws Exception;
	
	
	/**
	 * 更新权限信息
	 * @param form
	 */
	void updateInfo(PrivilegesForm form) throws Exception;
	
	
	/**
	 * 根据条件查找权限
	 * @param form
	 * @return
	 */
	List<Privileges> findPrivilegesByConn(PrivilegesForm form) throws Exception;
	
	/**
	 * 根据用户名查找资源权限集合
	 * @param username
	 * @return
	 */
	Set<ResourcesDto> findResourcesByUsername(String username)throws Exception;
	
	/**
	 * 根据系统标识和用户名查找权限
	 * @param code
	 * @return
	 */
	Set<ResourcesDto> findPrivilegesByCodeAndUsername(String code,String username)throws Exception;
	
	/**
	 * 根据权限别称查找权限
	 * @param alias
	 * @return
	 */
	Privileges findPrivilegesByAlias(String alias);

}

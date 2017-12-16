package com.goodidea.sso.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.goodidea.sso.domin.Resources;
import com.goodidea.sso.domin.Role;
import com.goodidea.sso.dto.ResourcesDto;
import com.goodidea.sso.dto.TreeDto;
import com.goodidea.sso.form.ResourceForm;
import com.goodidea.sso.form.RoleForm;
import com.goodidea.sso.form.SystemsForm;

/**
 * 
* @ClassName: ResourceService 
* @Description:  资源service
* @author lsg
* @date 2017年8月15日 下午3:51:40 
*
 */
public interface ResourceService extends BaseService<Resources, Long>{
	
	/**
	 * 根据条件搜索
	 * @param form
	 * @return
	 */
	Map<String, Object> findPagebyConn(ResourceForm form) throws Exception;
	
	
	/**
	 * 更新资源信息
	 * @param form
	 */
	void updateInfo(ResourceForm form) throws Exception;
	
	
	/**
	 *  根据条件获取资源
	 * @param form
	 * @return
	 * @throws Exception
	 */
	List<Resources> findResourcesByConn(ResourceForm form)throws Exception;
	
	/**
	 * 获取树
	 * @param resources
	 * @return
	 * @throws Exception
	 */
	Set getTree(ResourceForm form) throws Exception;
	
	/**
	 * 保存资源信息
	 * @param form
	 * @throws Exception 
	 */
	void saveInfo(ResourceForm form) throws Exception;

	/**
	 * 封装树形列表
	 * @return
	 * @throws Exception
	 */
	List<ResourcesDto> getTreeGird() throws Exception;

}

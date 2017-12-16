package com.goodidea.sso.service;

import java.util.List;
import java.util.Set;

import com.goodidea.sso.domin.Dept;
import com.goodidea.sso.dto.DeptDto;
import com.goodidea.sso.form.DeptForm;

/**
 * 
* @ClassName: DeptService 
* @Description:  部门service
* @author lsg
* @date 2017年9月4日 下午3:01:58 
*
 */
public interface DeptService extends BaseService<Dept, Long>{
	
	/**
	 * 获取部门树
	 * @param form
	 * @return
	 */
	Set getTree(DeptForm form) throws Exception;
	
	/**
	 * 获取部门树列表
	 * @return
	 */
	List<DeptDto> getTreeGird()throws Exception;
	
	/**
	 *  保存部门信息
	 * @param form
	 * @throws Exception
	 */
	void saveInfo(DeptForm form)throws Exception;
	
	/**
	 *  更新部门信息
	 * @param form
	 */
	void updateInfo(DeptForm form)throws Exception;
	
	
	/**
	 * 获取部门列表
	 * @param form
	 * @return
	 * @throws Exception
	 */
	List<Dept> findAllByConn(DeptForm form)throws Exception;

}

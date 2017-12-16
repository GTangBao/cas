package com.goodidea.sso.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.goodidea.sso.core.BaseEntity;
import com.goodidea.sso.domin.Resources;
import com.goodidea.sso.dto.ResourcesDto;
import com.goodidea.sso.form.BaseForm;
import com.goodidea.sso.form.DeptForm;
import com.goodidea.sso.form.ResourceForm;
import com.goodidea.sso.form.UserForm;

/**
 * 
* @ClassName: BaseService 
* @Description:  基类
* @author lsg
* @date 2017年10月11日 下午5:52:37 
*
 */
public interface BaseService<T extends BaseEntity<ID>, ID extends Serializable>  {
	
	/**
	 * 根据条件查找实体分页
	 * @param spec
	 * @param pageable
	 * @return
	 */
	Page<T> findAll(Specification<T> spec, Pageable pageable);
	/**
	 * 根据条件查找实体集合
	 * @param spec
	 * @return
	 */
	List<T> findAll(Specification<T> spec);
	/**
	 * 查找实体集合
	 * @return
	 * @throws Exception
	 */
	List<T> findAll() throws Exception;
	
	/**
	 * 根据ID查找实体信息
	 * @param id
	 * @return
	 */
	T findEntityById(String id) throws Exception;
	

	
	
	/**
	 * 保存实体信息
	 * @param form
	 */
	void save(T t)throws Exception;
	
	/**
	 * 保存实体信息
	 * @param form
	 */
	void update(T t)throws Exception;
	
	/**
	 * 删除实体对象
	 * 
	 * @param id
	 *            ID
	 */
	void delete(String id)throws Exception;

	/**
	 * 删除实体对象
	 * 
	 * @param ids
	 *            ID
	 * @throws Exception 
	 */
	void delete(String... ids) throws Exception;

	/**
	 * 删除实体对象
	 * 
	 * @param entity
	 *            实体对象
	 */
	void delete(T entity)throws Exception;
	
	/**
	 * 查找实体个数
	 * @return
	 * @throws Exception
	 */
	Long count () throws Exception;
	
	
}

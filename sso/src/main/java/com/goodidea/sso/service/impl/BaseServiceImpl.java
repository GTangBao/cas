package com.goodidea.sso.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import com.goodidea.sso.core.BaseEntity;
import com.goodidea.sso.dao.BaseRepository;
import com.goodidea.sso.domin.Resources;
import com.goodidea.sso.form.ResourceForm;
import com.goodidea.sso.service.BaseService;
import com.goodidea.sso.util.PageUtils;

/**
 * 
* @ClassName: BaseServiceImpl 
* @Description:  service实现层基类
* @author lsg
* @date 2017年10月11日 下午6:16:43 
*
 */
@Transactional
public abstract class BaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable> implements BaseService<T, ID>{
	
	@Autowired
	private BaseRepository<T, ID> baseRepository;
	
	

	@Override
	public Page<T> findAll(Specification<T> spec, Pageable pageable) {
		// TODO Auto-generated method stub
		return baseRepository.findAll(spec, pageable);
	}

	@Override
	public List<T> findAll(Specification<T> spec) {
		// TODO Auto-generated method stub
		return baseRepository.findAll(spec);
	}

	@Override
	public List<T> findAll()  {
		// TODO Auto-generated method stub
		return (List<T>) baseRepository.findAll();
	}

	@Override
	public void save(T entity) throws Exception{
		// TODO Auto-generated method stub
		baseRepository.save(entity);
	}
	
	@Override
	public void update(T entity) throws Exception{
		// TODO Auto-generated method stub
		baseRepository.save(entity);
	}


	@Override
	public T findEntityById(String id) throws Exception {
		// TODO Auto-generated method stub
		return baseRepository.findOne(new Specification<T>() {

			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate p = cb.equal(root.get("id").as(String.class), id);  
				query.where(cb.and(p)); 
				return query.getRestriction();
			}
		});
	}

	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		T t = findEntityById(id);
		t.setIsdel("1");
		save(t);
	}

	@Override
	public void delete(String... ids) throws Exception {
		// TODO Auto-generated method stub
		for (String id : ids) {
			T t = findEntityById(id);
			t.setIsdel("1");
			save(t);
		}
		
	}
	
	@Override
	public void delete(T entity) throws Exception{
		// TODO Auto-generated method stub
		entity.setIsdel("1");
		baseRepository.save(entity);
	}
	
	@Override
	public Long count (){
		return baseRepository.count();
		
	}

	
}

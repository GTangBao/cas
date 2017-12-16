package com.goodidea.sso.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.goodidea.sso.dao.MenuRepository;
import com.goodidea.sso.dao.ResourceRepository;
import com.goodidea.sso.dao.SystemRepository;
import com.goodidea.sso.domin.Menu;
import com.goodidea.sso.domin.Resources;
import com.goodidea.sso.domin.Systems;
import com.goodidea.sso.domin.User;
import com.goodidea.sso.form.SystemsForm;
import com.goodidea.sso.service.SystemsService;
import com.goodidea.sso.util.PageUtils;

import freemarker.template.utility.StringUtil;

/**
 * 
* @ClassName: SystemsServiceImpl 
* @Description:  应用系统serviceImpl
* @author lsg
* @date 2017年8月11日 下午3:16:29 
*
 */
@Service
public class SystemsServiceImpl extends BaseServiceImpl<Systems, Long> implements SystemsService{
	
	@Resource
	private SystemRepository systemRepository;
	@Resource
	private MenuRepository menuRepository;

	@Override
	public Systems findSystemsByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return systemRepository.findSystemsByName(name);
	}

	@Override
	public Map<String, Object> findPagebyConn(SystemsForm form) throws Exception {
	    Pageable pageable = new PageRequest(form.getPageNumber(), form.getPageSize(), Sort.Direction.DESC, "createDate");
	    Page<Systems> page = systemRepository.findAll(new Specification<Systems>(){  
            @Override  
            public Predicate toPredicate(Root<Systems> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) { 
            		List<Predicate> predicates = new ArrayList<>(); 
            	  if(StringUtils.isNotBlank(form.getName())){
            		  Predicate p1  = criteriaBuilder.like(root.get("name").as(String.class), "%"+(form.getName()!=null?form.getName():"")+"%"); 
            		  predicates.add(p1);
            	  }
            	  if(form.getIsEnabled()>0){
            		  Predicate p2 = criteriaBuilder.equal(root.get("isEnabled").as(int.class), form.getIsEnabled()); 
            		  predicates.add(p2);
            	  }
            	  Predicate p3 = criteriaBuilder.equal(root.get("isdel").as(String.class), "0");  
            	  predicates.add(p3);
            	  Predicate[] pre = new Predicate[predicates.size()]; 
            	  query.where(predicates.toArray(pre)); 
           
                  return query.getRestriction(); 
            }  
        },pageable);  
        return PageUtils.getPageMap(page); 
	}





	@Override
	@Transactional
	public void updateSystemsInfo(SystemsForm form) throws Exception {
		// TODO Auto-generated method stub
		Systems systems = findEntityById(form.getId());
		systems.setIsdel(form.getIsdel()!= null?form.getIsdel():"0");
		systems.setName(form.getName());
		systems.setUrl(form.getUrl());
		systems.setPort(form.getPort());
		systems.setAlias(form.getAlias());
		systems.setCode(form.getCode());
		systems.setIsEnabled(form.getIsEnabled());
		/*	systems.getMenus().clear();
	if(form.getMenuIds()!=null){
			for (String id : form.getMenuIds()) {
				Menu menu = menuRepository.findMenuById(id);
				menu.setSystems(systems);
				systems.getMenus().add(menu);
			}
		}*/
		systemRepository.save(systems);
	}

	@Override
	public Systems verifiCodeUnique(String code) throws Exception {
		// TODO Auto-generated method stub
		return systemRepository.findSystemsByCode(code);
	}

	@Override
	public void saveInfo(SystemsForm form) throws Exception {
		// TODO Auto-generated method stub
		Systems systems = new Systems();
		systems.setIsdel(form.getIsdel()!= null?form.getIsdel():"0");
		systems.setName(form.getName());
		systems.setUrl(form.getUrl());
		systems.setPort(form.getPort());
		systems.setAlias(form.getAlias());
		systems.setCode(form.getCode());
		systems.setIsEnabled(form.getIsEnabled());
	/*	for (String id : form.getMenuIds()) {
			Menu menu = menuRepository.findMenuById(id);
			menu.setSystems(systems);
			systems.getMenus().add(menu);
		}*/
		systemRepository.save(systems);
		
	}

	@Override
	public List<Systems> findSystemsByConn(SystemsForm forms) throws Exception {
		List<Systems> systems = systemRepository.findAll(new Specification<Systems>(){  
	            @Override  
	            public Predicate toPredicate(Root<Systems> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) { 
	            		List<Predicate> predicates = new ArrayList<>(); 
	            	  if(StringUtils.isNotBlank(forms.getName())){
	            		  Predicate p1  = criteriaBuilder.like(root.get("name").as(String.class), "%"+(forms.getName()!=null?forms.getName():"")+"%"); 
	            		  predicates.add(p1);
	            	  }
	            	  if(forms.getIsEnabled()>0){
	            		  Predicate p2 = criteriaBuilder.equal(root.get("isEnabled").as(int.class), forms.getIsEnabled()); 
	            		  predicates.add(p2);
	            	  }
	            	  Predicate p3 = criteriaBuilder.equal(root.get("isdel").as(String.class), "0");  
	            	  predicates.add(p3);
	            	  Predicate[] pre = new Predicate[predicates.size()]; 
	            	  query.where(predicates.toArray(pre)); 
	           
	                  return query.getRestriction(); 
	            }  
	        });  
	        return systems; 
	}

}

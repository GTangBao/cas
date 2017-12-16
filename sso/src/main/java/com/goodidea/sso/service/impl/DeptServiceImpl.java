package com.goodidea.sso.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.goodidea.sso.dao.DeptRepository;
import com.goodidea.sso.domin.Dept;
import com.goodidea.sso.domin.Privileges;
import com.goodidea.sso.domin.Resources;
import com.goodidea.sso.dto.DeptDto;
import com.goodidea.sso.dto.PrivilegesDto;
import com.goodidea.sso.dto.ResourcesDto;
import com.goodidea.sso.dto.TreeDto;
import com.goodidea.sso.form.DeptForm;
import com.goodidea.sso.form.ResourceForm;
import com.goodidea.sso.service.DeptService;
import com.goodidea.sso.service.RedisService;

@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept, Long> implements DeptService {
	
	@Resource
	private RedisService redisService;
	@Resource
	private DeptRepository deptRepository;
	
	@Override
	public Set getTree(DeptForm form) throws Exception {
		Set<TreeDto> dtos = new HashSet<>();
		TreeDto dto = null;
		for (Dept dept : findAllByConn(form)) {
			dto = new TreeDto();
			dto.setId(dept.getId());
			dto.setName(dept.getName());
			dto.setpId(dept.getParentId());
			dto.setIsParent("TOP".equals(dept.getParentId())?true:false);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<DeptDto> getTreeGird() throws Exception {
		// TODO Auto-generated method stub
		DeptForm form = new DeptForm();
		List<DeptDto> dtos = new ArrayList<>();
		List<Dept> depts = findAllByConn(form);
		for (Dept dept : depts) {
			if("TOP".equals(dept.getParentId())){
				DeptDto dto = new DeptDto();
				dto.setId(dept.getId());
				dto.setName(dept.getName());
				dto.setDeptLevel(dept.getDeptLevel());
				dto.setDeptType(dept.getDeptType());
				dto.setParentId(dept.getParentId());
				dto.getChildSet().addAll(getChild(depts,dto,dept.getId()));
				dtos.add(dto);
			}
		}
		
		return dtos;
	}
	

	private List<DeptDto> getChild(List<Dept> sons,DeptDto deptDto,String id) throws Exception {
		// TODO Auto-generated method stub
		List<DeptDto> dtos = new ArrayList<>();
		DeptDto dto  = null;
		for (Dept dept : sons) {
			 	if(id.equals(dept.getParentId())){
			 		dto = new DeptDto();
			 		dto.setId(dept.getId());
					dto.setName(dept.getName());
					dto.setDeptLevel(dept.getDeptLevel());
					dto.setDeptType(dept.getDeptType());
					dto.setParentId(dept.getParentId());
			 		getChild(sons,dto,dept.getId());
			 		dto.getChildSet().addAll(getChild(sons,dto,dept.getId()));
			 		dtos.add(dto);
			 	}
		}
		return dtos;
	}

	@Override
	public void saveInfo(DeptForm form) throws Exception {
		// TODO Auto-generated method stub
		 Dept dept = new Dept();
		dept.setName(form.getName());
		dept.setDeptType(form.getDeptType());
		dept.setDeptLevel(form.getDeptLevel());
		dept.setParentId(StringUtils.isNotBlank(form.getParentId())?form.getParentId():"TOP");
		save(dept);
		
	}


	@Override
	public void updateInfo(DeptForm form)throws Exception {
		// TODO Auto-generated method stub
		Dept dept = findEntityById(form.getId());
		dept.setName(form.getName());
		dept.setDeptType(form.getDeptType());
		dept.setDeptLevel(form.getDeptLevel());
		dept.setParentId(StringUtils.isNotBlank(form.getParentId())?form.getParentId():"TOP");
		deptRepository.save(dept);
		
	}


	@Override
	public List<Dept> findAllByConn(DeptForm form) throws Exception {
		List<Dept> depts = findAll(new Specification<Dept>(){  
            @Override  
            public Predicate toPredicate(Root<Dept> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) { 
            	  Predicate p1  = criteriaBuilder.like(root.get("name").as(String.class), "%"+(form.getName()!=null?form.getName():"")+"%"); 
            	  Predicate p2 = criteriaBuilder.equal(root.get("isdel").as(String.class), "0"); 
            	  query.where(criteriaBuilder.and(p1,p2)); 
           
                  return query.getRestriction(); 
            }  
        });
		return depts;  
	}




}

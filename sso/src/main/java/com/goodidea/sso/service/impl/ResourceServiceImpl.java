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

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.goodidea.sso.dao.PrivilegesRepository;
import com.goodidea.sso.dao.ResourceRepository;
import com.goodidea.sso.dao.RoleRepository;
import com.goodidea.sso.domin.Privileges;
import com.goodidea.sso.domin.Resources;
import com.goodidea.sso.domin.Role;
import com.goodidea.sso.domin.User;
import com.goodidea.sso.dto.PrivilegesDto;
import com.goodidea.sso.dto.ResourcesDto;
import com.goodidea.sso.dto.TreeDto;
import com.goodidea.sso.form.ResourceForm;
import com.goodidea.sso.form.RoleForm;
import com.goodidea.sso.service.PrivilegesService;
import com.goodidea.sso.service.RedisService;
import com.goodidea.sso.service.ResourceService;
import com.goodidea.sso.service.RoleService;
import com.goodidea.sso.util.PageUtils;

@Service
public class ResourceServiceImpl extends BaseServiceImpl<Resources, Long> implements ResourceService{
	
	@Autowired
	private ResourceRepository resourceRepository;
	@Autowired
	private PrivilegesService privilegesService;
	@Resource
	private RedisService redisService;


	@Override
	public Map<String, Object> findPagebyConn(ResourceForm form) {
	    Pageable pageable = new PageRequest(form.getPageNumber(), form.getPageSize(), Sort.Direction.DESC, "createDate");
	    Page<Resources> page = resourceRepository.findAll(new Specification<Resources>(){  
            @Override  
            public Predicate toPredicate(Root<Resources> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) { 
            	  Predicate p1  = criteriaBuilder.like(root.get("name").as(String.class), "%"+(form.getName()!=null?form.getName():"")+"%"); 
            	  Predicate p2 = criteriaBuilder.equal(root.get("isdel").as(String.class), "0");  
            	  query.where(criteriaBuilder.and(p1,p2)); 
           
                  return query.getRestriction(); 
            }  
        },pageable);  
        return PageUtils.getPageMap(page); 
	}

	@Override
	public void save(Resources resource) {
		// TODO Auto-generated method stub
		if(resource.getParentId()==null){
			resource.setParentId("TOP");
		}
		resourceRepository.save(resource);
	}

	@Override
	public void updateInfo(ResourceForm form) throws Exception {
		Resources resource = findEntityById(form.getId());
		resource.setName(form.getName());
		resource.setAlias(form.getAlias());
		resource.setUrl(form.getUrl());
		resource.setParentId(StringUtils.isNotBlank(form.getParentId())?form.getParentId():"TOP");
		resource.getPrivileges().clear();
		for (String id : form.getPrivilegeIds()) {
			Privileges privileges = privilegesService.findEntityById(id);
			resource.getPrivileges().add(privileges);
		}
		redisService.deletes("privileges");
		resourceRepository.save(resource);
	}

	@Override
	public List<Resources> findResourcesByConn(ResourceForm form) throws Exception {
		// TODO Auto-generated method stub
		List<Resources> resources = resourceRepository.findAll(new Specification<Resources>(){  
	            @Override  
	            public Predicate toPredicate(Root<Resources> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) { 
	            	  Predicate p1  = criteriaBuilder.like(root.get("name").as(String.class), "%"+(form.getName()!=null?form.getName():"")+"%"); 
	            	  Predicate p2 = criteriaBuilder.equal(root.get("isdel").as(String.class), "0"); 
	            	  Predicate p3 = criteriaBuilder.equal(root.get("parentId").as(String.class), form.getParentId());
	            	  query.where(criteriaBuilder.and(p1,p2)); 
	           
	                  return query.getRestriction(); 
	            }  
	        });
		return resources;  
	}

	@Override
	public Set<TreeDto> getTree(ResourceForm form) throws Exception {
		Set<TreeDto> dtos = new HashSet<>();
		TreeDto dto = null;
		for (Resources resource : findResourcesByConn(form)) {
			dto = new TreeDto();
			dto.setId(resource.getId());
			dto.setName(resource.getName());
			dto.setpId(resource.getParentId());
			dto.setIsParent("TOP".equals(resource.getParentId())?true:false);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void saveInfo(ResourceForm form) throws Exception {
		// TODO Auto-generated method stub
		Resources resources = new Resources();
		resources.setName(form.getName());
		resources.setAlias(form.getAlias());
		resources.setUrl(form.getUrl());
		resources.setParentId(StringUtils.isNotBlank(form.getParentId())?form.getParentId():"TOP");
		for (String id : form.getPrivilegeIds()) {
			Privileges privileges = privilegesService.findEntityById(id);
			resources.getPrivileges().add(privileges);
		}
		resourceRepository.save(resources);
	}

	@Override
	public List<ResourcesDto> getTreeGird() throws Exception {
		// TODO Auto-generated method stub
		ResourceForm form = new ResourceForm();
		List<ResourcesDto> dtos = new ArrayList<>();
		List<Resources> resources = findResourcesByConn(form);
		for (Resources resource : resources) {
			if("TOP".equals(resource.getParentId())){
				ResourcesDto dto = new ResourcesDto();
				dto.setId(resource.getId());
				dto.setName(resource.getName());
				dto.setAlias(resource.getAlias());
				dto.setParentId(resource.getParentId());
				PrivilegesDto pdto = null;
				 for (Privileges p : resource.getPrivileges()) {
					 pdto= new PrivilegesDto();
					pdto.setName(p.getName());
					pdto.setAlias(p.getAlias());
					pdto.setDescription(p.getDescription());
					pdto.setIsEnabled(p.getIsEnabled());
					dto.getPrivileges().add(pdto);
				}
				
				dto.getChildSet().addAll(getChild(resources,dto,resource.getId()));
				dtos.add(dto);
			}
		}
		
		return dtos;
	}
	

	private List<ResourcesDto> getChild(List<Resources> sons,ResourcesDto resourcesDto,String id) throws Exception {
		// TODO Auto-generated method stub
		List<ResourcesDto> dtos = new ArrayList<>();
		ResourcesDto dto  = null;
		for (Resources resource : sons) {
			 	if(id.equals(resource.getParentId())){
			 		dto = new ResourcesDto();
					dto.setId(resource.getId());
					dto.setName(resource.getName());
					dto.setAlias(resource.getAlias());
					dto.setParentId(resource.getParentId());
					PrivilegesDto pdto = null;
					 for (Privileges p : resource.getPrivileges()) {
						 pdto= new PrivilegesDto();
						pdto.setName(p.getName());
						pdto.setAlias(p.getAlias());
						pdto.setDescription(p.getDescription());
						pdto.setIsEnabled(p.getIsEnabled());
						dto.getPrivileges().add(pdto);
					}
			 		getChild(sons,dto,resource.getId());
			 		dto.getChildSet().addAll(getChild(sons,dto,resource.getId()));
			 		dtos.add(dto);
			 	}
		}
		return dtos;
	}
	
}
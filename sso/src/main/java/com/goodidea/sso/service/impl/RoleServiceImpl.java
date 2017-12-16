package com.goodidea.sso.service.impl;

import java.util.HashMap;
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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.goodidea.sso.dao.ResourceRepository;
import com.goodidea.sso.dao.RoleRepository;
import com.goodidea.sso.domin.Menu;
import com.goodidea.sso.domin.Privileges;
import com.goodidea.sso.domin.Resources;
import com.goodidea.sso.domin.Role;
import com.goodidea.sso.domin.User;
import com.goodidea.sso.dto.PrivilegesDto;
import com.goodidea.sso.dto.ResourcesDto;
import com.goodidea.sso.form.RoleForm;
import com.goodidea.sso.service.MenuService;
import com.goodidea.sso.service.PrivilegesService;
import com.goodidea.sso.service.RedisService;
import com.goodidea.sso.service.RoleService;
import com.goodidea.sso.util.PageUtils;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Long> implements RoleService{
	
	@Resource
	private RoleRepository roleRepository;
	@Resource
	private ResourceRepository resourceRepository;
	@Resource
	private RedisService redisService;
	@Resource
	private MenuService menuService;
	@Resource
	private PrivilegesService privilegesService;

	@Override
	public Map<String, Object> findPagebyConn(RoleForm form) throws Exception {
	    Pageable pageable = new PageRequest(form.getPageNumber(), form.getPageSize(), Sort.Direction.DESC, "createDate");
	    Page<Role> page = roleRepository.findAll(new Specification<Role>(){  
            @Override  
            public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) { 
            	  Predicate p1  = criteriaBuilder.like(root.get("name").as(String.class), "%"+(form.getName()!=null?form.getName():"")+"%"); 
            	  Predicate p2 = criteriaBuilder.equal(root.get("isdel").as(String.class), "0");  
            	  query.where(criteriaBuilder.and(p1,p2)); 
           
                  return query.getRestriction(); 
            }  
        },pageable);  
        return PageUtils.getPageMap(page); 
	}

	@Override
	public void save(Role role) throws Exception{
		// TODO Auto-generated method stub
		roleRepository.save(role);
	}

	@Override
	public void updateInfo(RoleForm form)  throws Exception{
		// TODO Auto-generated method stub
		Role role = findEntityById(form.getId());
		role.setName(form.getName());
		role.setAlias(form.getAlias());
		role.setDescription(form.getDescription());
		role.setEnabled(form.getEnabled());
		role.getResources().clear();
		/*for (String id : form.getResourceIds()) {
			Resources resource = resourceRepository.findResourceById(id);
			role.getResources().add(resource);
		}*/
		redisService.deletes("privileges");
		roleRepository.save(role);
	}


	@Override
	public List<Role> findAllByConn( RoleForm form) throws Exception{
		 List<Role> roles = roleRepository.findAll(new Specification<Role>(){

			@Override
			public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				  Predicate p1 = cb.equal(root.get("enabled").as(int.class), 1);  
            	  Predicate p2 = cb.equal(root.get("isdel").as(String.class), "0");  
            	  query.where(cb.and(p1,p2)); 
                  return query.getRestriction(); 
			}
			 
		 });
		return roles;
	}

	@Override
	@Transactional
	public void saveInfo(RoleForm form) {
		// TODO Auto-generated method stub
		Role role = new Role();
		role.setName(form.getName());
		role.setAlias(form.getAlias());
		role.setDescription(form.getDescription());
		role.setEnabled(form.getEnabled());
		/*for (String id : form.getResourceIds()) {
			Resources resource = resourceRepository.findResourceById(id);
			role.getResources().add(resource);
		}*/
		roleRepository.save(role);
		
	}

	@Override
	public Set<ResourcesDto> getPrivilegeByRoleId(String id) throws Exception {
		Role role = findEntityById(id);
		Set<ResourcesDto> dtos = new HashSet<>();
		if(role == null){
			return dtos;
		}
		ResourcesDto dto = null;
		PrivilegesDto pdto = null;
		for (Resources resource : role.getResources()) {
			 dto = new ResourcesDto();
			 dto.setId(resource.getId());
			 dto.setName(resource.getName());
			 dto.setAlias(resource.getAlias());
			 dto.setParentId(resource.getParentId());
			 dto.setUrl(resource.getUrl());
			 for (Privileges p : resource.getPrivileges()) {
				 pdto= new PrivilegesDto();
				 pdto.setId(p.getId());
				pdto.setName(p.getName());
				pdto.setAlias(p.getAlias());
				pdto.setDescription(p.getDescription());
				pdto.setIsEnabled(p.getIsEnabled());
				dto.getPrivileges().add(pdto);
			}
			
			 dtos.add(dto);
		}
		return dtos;
	}

	@Override
	@Transactional
	public void bingingPrivileges(String rid,  String... pid) throws Exception {
		// TODO Auto-generated method stub
		if(pid.length>0){
			Role role = findEntityById(rid);
			for (Resources resource : role.getResources()) {
				resourceRepository.delete(resource);
			}
			Set<Resources> resources = new HashSet<>();
			Resources resource = null;
			String mid ="";
			for (String string : pid) {
				String[] str = string.split("/");
				if(mid.equals(str[0])){
					resource.getPrivileges().add(privilegesService.findEntityById(str[1]));
				}else{
					mid = str[0];
					resource =  new Resources();
					Menu menu = menuService.findMenuByAlias(str[0]);
					resource.setName(menu.getName());
					resource.setAlias(menu.getAlias());
					resource.setParentId(menu.getParentId());
					resource.setUrl(menu.getUrl());
					resource.getPrivileges().add(privilegesService.findEntityById(str[1]));
					resourceRepository.save(resource);
					resources.add(resource);
				}
			}
			role.setResources(resources);
			roleRepository.save(role);
			redisService.deletes("privileges");
		}
	}
	
}

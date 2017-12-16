package com.goodidea.sso.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.springframework.stereotype.Service;

import com.goodidea.sso.dao.PrivilegesRepository;
import com.goodidea.sso.dao.ResourceRepository;
import com.goodidea.sso.dao.RoleRepository;
import com.goodidea.sso.dao.SystemRepository;
import com.goodidea.sso.dao.UserRepository;
import com.goodidea.sso.domin.Privileges;
import com.goodidea.sso.domin.Resources;
import com.goodidea.sso.domin.Role;
import com.goodidea.sso.domin.Systems;
import com.goodidea.sso.domin.User;
import com.goodidea.sso.dto.PrivilegesDto;
import com.goodidea.sso.dto.ResourcesDto;
import com.goodidea.sso.form.PrivilegesForm;
import com.goodidea.sso.form.ResourceForm;
import com.goodidea.sso.form.RoleForm;
import com.goodidea.sso.service.PrivilegesService;
import com.goodidea.sso.service.RedisService;
import com.goodidea.sso.service.ResourceService;
import com.goodidea.sso.service.RoleService;
import com.goodidea.sso.service.SystemsService;
import com.goodidea.sso.util.PageUtils;

@Service
public class PrivilegesServiceImpl extends BaseServiceImpl<Privileges, Long> implements PrivilegesService{
	
	@Autowired
	private PrivilegesRepository privilegesRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RedisService redisService;
	@Autowired
	private SystemRepository systemRepository;

	@Override
	public Map<String, Object> findPagebyConn(PrivilegesForm form) {
	    Pageable pageable = new PageRequest(form.getPageNumber(), form.getPageSize(), Sort.Direction.DESC, "createDate");
	    Page<Privileges> page = privilegesRepository.findAll(new Specification<Privileges>(){  
            @Override  
            public Predicate toPredicate(Root<Privileges> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) { 
            	  Predicate p1  = criteriaBuilder.like(root.get("name").as(String.class), "%"+(form.getName()!=null?form.getName():"")+"%"); 
            	  Predicate p2 = criteriaBuilder.equal(root.get("isdel").as(String.class), "0");  
            	  query.where(criteriaBuilder.and(p1,p2)); 
           
                  return query.getRestriction(); 
            }  
        },pageable);  
        return PageUtils.getPageMap(page); 
	}

	@Override
	public void save(Privileges privileges) {
		// TODO Auto-generated method stub
		privilegesRepository.save(privileges);
	}

	@Override
	public void updateInfo(PrivilegesForm form) throws Exception {
		// TODO Auto-generated method stub
		Privileges privileges = findEntityById(form.getId());
		privileges.setName(form.getName());
		privileges.setAlias(form.getAlias());
		privileges.setDescription(form.getDescription());
		privileges.setIsEnabled(form.getIsEnabled());
		privilegesRepository.save(privileges);
	}


	@Override
	public List<Privileges> findPrivilegesByConn(PrivilegesForm form) throws Exception {
		// TODO Auto-generated method stub
		List<Privileges> privileges = privilegesRepository.findAll(new Specification<Privileges>(){  
	            @Override  
	            public Predicate toPredicate(Root<Privileges> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) { 
	            	  Predicate p1  = criteriaBuilder.like(root.get("name").as(String.class), "%"+(form.getName()!=null?form.getName():"")+"%"); 
	            	  Predicate p2 = criteriaBuilder.equal(root.get("isdel").as(String.class), "0");  
	            	  query.where(criteriaBuilder.and(p1,p2)); 
	           
	                  return query.getRestriction(); 
	            }  
	        }); 
		return privileges;
	}

	@Override
	public Set<ResourcesDto> findResourcesByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		if(redisService.exists("privileges"+username)){
			Set<ResourcesDto> set = redisService.getSet("privileges"+username);
			return set;
		}
		Set<ResourcesDto> dtos = new HashSet<>();
		User user = userRepository.findUserByUsername(username);
		if(user == null){
			return dtos;
		}
		Set<Role> roles = user.getRoles();
		ResourcesDto dto = null;
		PrivilegesDto pdto = null;
		if(roles.isEmpty()){ //角色如果为空返回
			return dtos;
		}
		for (Role role : roles) {
			if(role.getEnabled()==1){ //判断角色已启用
				for (Resources resource : role.getResources()) {
					 dto = new ResourcesDto();
					 dto.setId(resource.getId());
					 dto.setName(resource.getName());
					 dto.setAlias(resource.getAlias());
					 dto.setParentId(resource.getParentId());
					 dto.setUrl(resource.getUrl());
					 for (Privileges p : resource.getPrivileges()) {
						 pdto= new PrivilegesDto();
						pdto.setName(p.getName());
						pdto.setAlias(p.getAlias());
						pdto.setDescription(p.getDescription());
						pdto.setIsEnabled(p.getIsEnabled());
						dto.getPrivileges().add(pdto);
					}
					
					 dtos.add(dto);
					 redisService.add("privileges"+username, dto);//资源权限不等于空,放入redis缓存
				}
			}
		}
		return dtos;
	}

	@Override
	public Set<ResourcesDto> findPrivilegesByCodeAndUsername(String code,String username) throws Exception {

			//redis 缓存
		if(redisService.exists("privileges_"+username)){
			System.out.println("redis");
			Set set = redisService.getSet("privileges_"+username);
			return set;
		}
		
		Set<ResourcesDto> dtos = new HashSet<>();
		Systems systems = systemRepository.findSystemsByCode(code);
		User user = userRepository.findUserByUsername(username);
		if (systems == null || user == null) {
			return dtos;
		}
		if (systems.getMenus().isEmpty()) {
			return dtos;
		}
		if(user.getRoles().isEmpty()){ //角色如果为空返回
			return dtos;
		}
		ResourcesDto dto = null;
		PrivilegesDto pdto = null;
		for (Role role : user.getRoles()) {
			if(role.getEnabled()==1){ //判断角色已启用
				for (Resources resource : role.getResources()) {
					 if(systems.getMenus().contains(resource)){
						 dto = new ResourcesDto();
						 dto.setId(resource.getId());
						 dto.setName(resource.getName());
						 dto.setAlias(resource.getAlias());
						 dto.setParentId(resource.getParentId());
						 dto.setUrl(resource.getUrl());
						 for (Privileges p : resource.getPrivileges()) {
							 pdto= new PrivilegesDto();
							pdto.setName(p.getName());
							pdto.setAlias(p.getAlias());
							pdto.setDescription(p.getDescription());
							pdto.setIsEnabled(p.getIsEnabled());
							dto.getPrivileges().add(pdto);
						}
						 
						 dtos.add(dto);
					 }
				}
			}
		}
		if(!dtos.isEmpty()){ //资源权限不等于空,放入redis缓存
			redisService.add("privileges_"+username, dtos);
		}
		return dtos;
	}

	@Override
	public Privileges findPrivilegesByAlias(String alias) {
		// TODO Auto-generated method stub
		return privilegesRepository.findPrivilegesByAlias(alias);
	}
	
	
}

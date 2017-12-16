package com.goodidea.sso.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.goodidea.sso.dao.RoleRepository;
import com.goodidea.sso.dao.UserRepository;
import com.goodidea.sso.domin.Role;
import com.goodidea.sso.domin.User;
import com.goodidea.sso.form.UserForm;
import com.goodidea.sso.service.DeptService;
import com.goodidea.sso.service.RedisService;
import com.goodidea.sso.service.RoleService;
import com.goodidea.sso.service.UserService;
import com.goodidea.sso.util.PageUtils;


/**
 * 
* @ClassName: UserServiceImpl 
* @Description:  用户service实现层
* @author lsg
* @date 2017年8月1日 上午9:28:12 
*
 */
@Service	
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService{
	
	@Resource
	private UserRepository userRepository;
	@Resource
	private RoleService roleService;
	@Resource
	private RedisService redisService;
	@Resource
	private DeptService deptService;

	@Override
	@Transactional
	public void saveUserInfo(UserForm form) throws Exception {
		User user = new User();
		user.setUsername(form.getUsername());
		user.setPassword(DigestUtils.md5Hex(form.getPassword()));
		user.setEnabled(form.getEnabled());
		user.setIsLocked(form.getIsLocked());
		if(StringUtils.isNotBlank(form.getDeptId())){
			user.setDept(deptService.findEntityById(form.getDeptId()));
		}
		if(form.getRoleIds()!=null && form.getRoleIds().length>0){
			Set<Role> roles = user.getRoles();
			for ( String id : form.getRoleIds()) {
				roles.add(roleService.findEntityById(id));
			};
		}
		save(user);
	}

	@Override
	public User findUserByUsername(String username)  throws Exception{
		// TODO Auto-generated method stub
		return userRepository.findUserByUsername(username);
		
	}

	@Override
	public Map<String, Object> findPagebyConn(final UserForm form) throws Exception {
		// 获得分页对象pageable，并且在pageable中页码是从0开始，设定按照sortType升序排列 
		Pageable pageable = new PageRequest(form.getPageNumber(), form.getPageSize(), Sort.Direction.DESC, "createDate");
	    Page<User> page = findAll(new Specification<User>(){  
            @Override  
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) { 
            	  Predicate p1  = criteriaBuilder.like(root.get("username").as(String.class), "%"+(form.getUsername()!=null?form.getUsername():"")+"%"); 
            	  Predicate p2 = criteriaBuilder.equal(root.get("isdel").as(String.class), "0");  
            	  query.where(criteriaBuilder.and(p1,p2)); 
           
                  return query.getRestriction(); 
            }  
        },pageable);  
        return PageUtils.getPageMap(page); 
	  }


	@Override
	@Transactional
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		User user = findEntityById(id);
		delete(user);
		redisService.remove("privileges_"+user.getUsername());
	}


	@Override
	@Transactional
	public void updateUserInfo(UserForm form) throws Exception {
		// TODO Auto-generated method stub
		User user = findEntityById(form.getId());
		user.setUsername(form.getUsername());
		if(StringUtils.isNotBlank(form.getPassword())&&!form.getPassword().equals(user.getPassword())){
			user.setPassword(DigestUtils.md5Hex(form.getPassword()));
		}
		user.setEnabled(form.getEnabled());
		user.setRequestUrl(form.getRequestUrl());
		user.setIsLocked(form.getIsLocked());
		if(StringUtils.isNotBlank(form.getDeptId())){
			user.setDept(deptService.findEntityById(form.getDeptId()));
		}
		Set<Role> roles = user.getRoles();
		roles.clear();
		for ( String id : form.getRoleIds()) {
			roles.add(roleService.findEntityById(id));
		};
		redisService.remove("privileges_"+user.getUsername());
		save(user);
		
	}


	


}

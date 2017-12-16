package com.goodidea.sso.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.goodidea.sso.dao.LogRepository;
import com.goodidea.sso.domin.Log;
import com.goodidea.sso.domin.User;
import com.goodidea.sso.form.LogForm;
import com.goodidea.sso.service.LogService;
import com.goodidea.sso.service.RedisService;
import com.goodidea.sso.util.PageUtils;
import com.goodidea.sso.util.SystemUtils;

@Service
public class LogServiceImpl implements LogService {
	
	@Resource
	private LogRepository logRepository;
	@Resource
	private RedisService redisService;
	
	@Override
	@Transactional
	@Cacheable(value="logcache")
	public Map<String, Object> findPagebyConn(LogForm form) throws Exception {
		Pageable pageable = new PageRequest(form.getPageNumber(), form.getPageSize(), Sort.Direction.DESC, "createDate");
		    Page<Log> page = logRepository.findAll(new Specification<Log>(){  
	            @Override  
	            public Predicate toPredicate(Root<Log> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) { 
	            	 List<Predicate> predicates = new ArrayList<>();   
	            	  Predicate p = criteriaBuilder.equal(root.get("createBy").as(String.class), form.getCreateBy());  
	            	  predicates.add(p);
	            	  Predicate[] pre = new Predicate[predicates.size()]; 
	            	  query.where(predicates.toArray(pre)); 
	                  return query.getRestriction();  
	            }  
	        },pageable);  
	        return PageUtils.getPageMap(page); 
	}

	@Override
	public void saveInfo(HttpServletRequest request, String name) throws IOException {
		// TODO Auto-generated method stub
		Log log = new Log();
		log.setDescription("用户退出");
		log.setCreateBy(name);
		log.setCreateDate(new Date());
		log.setRequestIp(SystemUtils.getIpAddress(request));
		logRepository.save(log);
	}


}

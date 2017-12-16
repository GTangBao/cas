package com.goodidea.sso.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.goodidea.sso.aop.SystemLog;
import com.goodidea.sso.dao.SystemsLogRepository;
import com.goodidea.sso.domin.Log;
import com.goodidea.sso.domin.SystemsLog;
import com.goodidea.sso.form.LogForm;
import com.goodidea.sso.service.SystemsLogService;
import com.goodidea.sso.util.PageUtils;

/**
 * 
* @ClassName: SystemsLogServiceImpl 
* @Description:  系统日志实现
* @author lsg
* @date 2017年9月21日 上午11:47:11 
*
 */
@Service
public class SystemsLogServiceImpl extends BaseServiceImpl<SystemsLog, Long>implements SystemsLogService{
	
	@Resource
	private SystemsLogRepository systemsLogRepository;
	@Override
	public void save(SystemsLog log) {
		systemsLogRepository.save(log);
	}
	
	@Transactional
	public Map<String, Object> findPagebyConn(LogForm form) throws Exception {
		Pageable pageable = new PageRequest(form.getPageNumber(), form.getPageSize(), Sort.Direction.DESC, "createDate");
		Page<SystemsLog> page = findAll(new Specification<SystemsLog>() {
			
			@Override
			public Predicate toPredicate(Root<SystemsLog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				return query.getRestriction();
			}
		}, pageable);
		return PageUtils.getPageMap(page); 
	        
	}
}

package com.goodidea.sso.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.goodidea.sso.core.BaseEntity;
import com.goodidea.sso.domin.Log;

public interface BaseRepository<T extends BaseEntity<ID>, ID extends Serializable> extends JpaSpecificationExecutor<T>,PagingAndSortingRepository<T, Long>{ 
	
}

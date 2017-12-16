package com.goodidea.sso.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.goodidea.sso.domin.Log;
import com.goodidea.sso.domin.Menu;

/**
 * 
* @ClassName: LogRepository 
* @Description:  日志dao
* @author lsg
* @date 2017年10月12日 上午11:00:36 
*
 */
public interface LogRepository extends  JpaSpecificationExecutor<Log>,PagingAndSortingRepository<Log, Long>{

}

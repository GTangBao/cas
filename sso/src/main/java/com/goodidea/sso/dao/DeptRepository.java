package com.goodidea.sso.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.goodidea.sso.domin.Dept;
import com.goodidea.sso.domin.User;

/**
 * 
* @ClassName: DeptRepository 
* @Description:  部门Dao
* @author lsg
* @date 2017年9月4日 下午3:01:12 
*
 */
public interface DeptRepository extends BaseRepository<Dept, Long>{
	

}

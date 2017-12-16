package com.goodidea.sso.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.goodidea.sso.domin.Resources;
import com.goodidea.sso.domin.Role;

/**
 * 
* @ClassName: ResourceRepository 
* @Description:  资源Dao
* @author lsg
* @date 2017年8月15日 上午10:46:41 
*
 */
public interface ResourceRepository extends BaseRepository<Resources, Long>{
	

	List<Resources> findResourcesByParentId(String id);


}

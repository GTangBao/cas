package com.goodidea.sso.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.goodidea.sso.domin.Systems;
import com.goodidea.sso.domin.User;
import com.goodidea.sso.form.UserForm;

/**
 * 
* @ClassName: SystemRepository 
* @Description:  应用系统dao
* @author lsg
* @date 2017年8月11日 下午3:05:05 
*
 */
public interface SystemRepository  extends BaseRepository<Systems,Long>{
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	Systems findSystemsByName(String name);
	
	Systems findSystemsByCode(String code);
	


	



	
	
	
	
	
}

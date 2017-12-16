package com.goodidea.sso.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.goodidea.sso.domin.Dept;
import com.goodidea.sso.domin.User;
import com.goodidea.sso.form.UserForm;

/**
 * 
* @ClassName: UserRepository 
* @Description:  用户Repository
* @author lsg
* @date 2017年8月1日 下午6:28:36 
*
 */
public interface UserRepository   extends BaseRepository<User, Long>{
	
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username);
	
	
	
	
	
}

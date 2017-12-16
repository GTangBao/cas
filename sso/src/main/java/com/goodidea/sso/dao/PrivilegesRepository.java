package com.goodidea.sso.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.goodidea.sso.domin.Privileges;
import com.goodidea.sso.domin.Resources;

/**
 * 
* @ClassName: PrivilegersRepository 
* @Description:  权限Dao
* @author lsg
* @date 2017年8月15日 上午10:48:54 
*
 */
public interface PrivilegesRepository extends BaseRepository<Privileges, Long> {
	
	
	Privileges findPrivilegesByAlias(String alias);

}

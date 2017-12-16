package com.goodidea.sso.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.goodidea.sso.domin.Log;
import com.goodidea.sso.domin.Menu;

/**
 * 
* @ClassName: MenuRepository 
* @Description:  菜单Dao
* @author lsg
* @date 2017年9月5日 下午6:36:12 
*
 */
public interface MenuRepository extends BaseRepository<Menu, Long>{
	
	Menu findMenuByAlias(String alias);
}

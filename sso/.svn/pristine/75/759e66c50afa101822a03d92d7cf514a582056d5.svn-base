package com.goodidea.sso.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.goodidea.sso.domin.User;
import com.goodidea.sso.form.UserForm;

/**
 * 
* @ClassName: UserService 
* @Description:  用户service接口
* @author lsg
* @date 2017年8月1日 下午5:29:22 
*
 */
public interface UserService extends BaseService<User, Long> {
	
	/**
	 * 保存用户信息
	 * @param form
	 */
	void saveUserInfo (UserForm form) throws Exception;
	
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	User findUserByUsername(String username) throws Exception;
	
	/**
	 * 根据条件查找用户分页
	 * @param form
	 * @return
	 */
	Map<String, Object> findPagebyConn(UserForm form) throws Exception;
	
	
	/**
	 * 更新用户信息
	 * @param form
	 * @throws Exception 
	 */
	void updateUserInfo(UserForm form) throws Exception;
}

package com.goodidea.sso.service;

import java.util.Map;

import com.goodidea.sso.domin.SystemsLog;
import com.goodidea.sso.form.LogForm;

/**
 * 
* @ClassName: SystemsLogService 
* @Description:  系统日志service
* @author lsg
* @date 2017年9月21日 上午11:45:52 
*
 */
public interface SystemsLogService extends BaseService<SystemsLog, Long>{
	/**
	 * 保存系统日志信息
	 * @param log
	 */
	void save(SystemsLog log);
	
	/**
	 * 系统日志分页
	 * @param form
	 * @return
	 * @throws Exception 
	 */
	Map<String, Object> findPagebyConn(LogForm form) throws Exception;
}

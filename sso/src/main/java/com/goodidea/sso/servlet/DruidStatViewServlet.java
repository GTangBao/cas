package com.goodidea.sso.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * 
* @ClassName: DruidStatViewServlet 
* @Description:  druid数据状态监控
* @author lsg
* @date 2017年7月31日 下午6:39:02 
*
 */

@WebServlet(urlPatterns="/druid/*",initParams={
		@WebInitParam(name="allow",value="127.0.0.1"), //IP白名单
		@WebInitParam(name="deny",value="192.168.1.73"), //IP黑名单
		@WebInitParam(name="loginUsername",value=""), //用户名
		@WebInitParam(name="loginPassword",value=""), //密码
		@WebInitParam(name="resetEnable",value="false")})//禁止页面上reset all功能
public class DruidStatViewServlet extends StatViewServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1499427871182679912L;

}

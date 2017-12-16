package com.goodidea.sso.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

/**
 * 
* @ClassName: DruidStatFilter 
* @Description:  druid过滤器
* @author lsg
* @date 2017年7月31日 下午6:45:32 
*
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
			initParams={@WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")}) //忽的资源	
public class DruidStatFilter  extends WebStatFilter{

}

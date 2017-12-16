package com.goodidea.sso.listerer;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.util.ClassUtils;

/**
 * 
* @ClassName: BasePathListerer 
* @Description: 初始化绝对路径 
* @author lsg
* @date 2017年8月10日 下午3:38:43 
*
 */
@WebListener
public class BasePathListerer implements ServletContextListener {
	

    private static Map<String, String> conf = new HashMap<>();

    public static Map<String, String> getConf() {
        return conf;
    }

    
	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		ServletContext servletContext = event.getServletContext();
		String realPath = servletContext.getRealPath("/").replaceFirst("/", "");
		String contextPath = servletContext.getContextPath();
		 conf.put("realPath", realPath);
	     conf.put("contextPath", contextPath);
	    servletContext.setAttribute("base", contextPath);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		conf.clear();
		
	}

}

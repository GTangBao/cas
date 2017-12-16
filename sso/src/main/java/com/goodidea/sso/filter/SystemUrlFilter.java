package com.goodidea.sso.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.goodidea.sso.domin.Setting;
import com.goodidea.sso.domin.User;
import com.goodidea.sso.service.UserService;
import com.goodidea.sso.util.SystemUtils;

public class SystemUrlFilter implements Filter {
	
	@Autowired
	private UserService userService;
	
	 private String[] prefixIignores ;
	 private String ignoresParam;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		ignoresParam = config.getInitParameter("exclusions");  
		if (StringUtils.isNotEmpty(ignoresParam)) {  
			prefixIignores = ignoresParam.split(",");  
		}  
			return;  
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletRequest request = (HttpServletRequest) req;
		 HttpServletResponse response = (HttpServletResponse) res;
		 AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
		 Setting setting = SystemUtils.getSetting();
		 if (canIgnore(request)) {  
			 chain.doFilter(request, response);
	            return;  
	        } 
		if(principal !=null){
			Map<String, Object> attributes = principal.getAttributes();
			String username = (String) attributes.get("username");
			String path = request.getServerName();
			User user = null;
			boolean temp = false;
			try {
				user = userService.findUserByUsername(username);
				if (StringUtils.isNotBlank(user.getRequestUrl())) {
					String[] urls = user.getRequestUrl().split(",");
					for (String url : urls) {
						if(path.equals(url.toLowerCase())){
							temp =true;
						}
					}
				}
				
				if(!temp){
					request.getSession().invalidate();
					response.sendRedirect(setting.getCasUrl()+"/cas-server/logout?service="+setting.getSiteUrl()+"/sso/home");
				}else{
					chain.doFilter(request, response);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void destroy() {
		 //sTODO Auto-generated method stub
		 prefixIignores=null;  
	}
	
	 private boolean canIgnore(HttpServletRequest request) {  
		boolean isExcludedPage = false;
		for (String page : prefixIignores) {// 判断是否在过滤url之外
			if (((HttpServletRequest) request).getServletPath().contains(page)) {
				isExcludedPage = true;
				break;
			}
		}
		return isExcludedPage;
	}
}

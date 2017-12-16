package com.goodidea.sso.core;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import com.goodidea.sso.dto.PrivilegesDto;
import com.goodidea.sso.dto.ResourcesDto;
import com.goodidea.sso.service.PrivilegesService;

/**
 * 
* @ClassName: PrivilegeTag 
* @Description: 权限标签类 
* @author lsg
* @date 2017年9月12日 下午5:36:01 
*
 */
public class PrivilegeTag extends RequestContextAwareTag{


	private static final long serialVersionUID = 534416848523276042L;
	
	private String menuAlias;
	
	private String priAlias;

	public String getMenuAlias() {
		return menuAlias;
	}

	public void setMenuAlias(String menuAlias) {
		this.menuAlias = menuAlias;
	}


	public String getPriAlias() {
		return priAlias;
	}

	public void setPriAlias(String priAlias) {
		this.priAlias = priAlias;
	}

	@Override
	protected int doStartTagInternal()  {
		// TODO Auto-generated method stub
		boolean result = false;
		 try {
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			 AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
			 Map<String, Object> attributes = principal.getAttributes();
			String username=(String) attributes.get("username");
			PrivilegesService  privilegesService= (PrivilegesService)this.getRequestContext().getWebApplicationContext().getBean("privilegesServiceImpl");
			Set<ResourcesDto> dto = privilegesService.findResourcesByUsername(username);
			for (ResourcesDto resourcesDto : dto) {
				if(this.menuAlias.equals(resourcesDto.getAlias())){
					for (PrivilegesDto pdto : resourcesDto.getPrivileges()) {
						if(this.priAlias.equals(pdto.getAlias())){
							 result = true;
						}
					}
				}
			}
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result =false;
		}
		return result? EVAL_BODY_INCLUDE : SKIP_BODY;
	}
}


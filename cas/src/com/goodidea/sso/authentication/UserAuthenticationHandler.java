package com.goodidea.sso.authentication;

import java.security.GeneralSecurityException;
import java.util.Date;

import javax.annotation.Resource;
import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.CredentialExpiredException;
import javax.security.auth.login.FailedLoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.jasig.cas.authentication.AccountDisabledException;
import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.inspektr.common.web.ClientInfo;
import com.github.inspektr.common.web.ClientInfoHolder;
import com.goodidea.sso.entity.User;
import com.goodidea.sso.exception.CaptchaException;
import com.goodidea.sso.exception.DisableAccountException;
import com.goodidea.sso.exception.LockedException;
import com.goodidea.sso.exception.LoginCountException;
import com.goodidea.sso.exception.RequestUrlException;
import com.goodidea.sso.jdbc.UserDaoJdbc;
import com.goodidea.sso.model.UsernamePasswordCaptchaCredential;

@Component(value="primaryAuthenticationHandler")
public class UserAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {
	
    @Resource
    private UserDaoJdbc userDaoJdbc;
    
    @Override 
    protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential transformedCredential) throws GeneralSecurityException, PreventedException {
		// UsernamePasswordCredential参数包含了前台页面输入的用户信息
		String username = transformedCredential.getUsername();
		String password = transformedCredential.getPassword();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		if (!getCaptcha(request, transformedCredential)) {
			throw new CaptchaException();
		}

		User user = userDaoJdbc.verifyAccount(username);
		//用户为空
		if (user == null) {
			throw new AccountNotFoundException();
		}
		
		//是否启用
		if (user.getEnabled()==0) {
			throw new DisableAccountException();
		}
		//是否锁定
		if (user.getIsLocked()==1) {
			throw new LockedException();
		}
		
		//连续登录失败次数
		if (!user.getPassword().equals(DigestUtils.md5Hex(password))) {
			throw new FailedLoginException();
		}
		
        return createHandlerResult(transformedCredential, new SimplePrincipal(username), null);
      
    }
    
    private boolean getCaptcha(HttpServletRequest request,UsernamePasswordCredential transformedCredential){
    	  HttpSession session = request.getSession();
          String rand = (String)session.getAttribute("rand");
          session.removeAttribute("rand");
          UsernamePasswordCaptchaCredential upc = (UsernamePasswordCaptchaCredential)transformedCredential;
          String captcha = upc.getCaptcha();
          if(!rand.toLowerCase().equals(captcha.toLowerCase())){
        	  return false;
          }
		return true;
    }
}
package com.goodidea.sso.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goodidea.sso.aop.SystemLog;

/**
 * 
* @ClassName: CertificateController 
* @Description:  生成证书
* @author lsg
* @date 2017年8月24日 下午2:04:24 
*
 */
@Controller
public class CertificateController extends BaseController{
	
	private final static Logger logger = LoggerFactory.getLogger(CertificateController.class);
	
	/**
	 * 生成证书方法
	 */
	@SystemLog(operatorType="访问生成证书",isSaveRequestData=true)
	@RequestMapping("/getCertificate")
	public String getCertificate(){
		try {
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("cmd /c start cmd");
		} catch (IOException e) {
			logger.error(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "certificate/keytool";
	}
}

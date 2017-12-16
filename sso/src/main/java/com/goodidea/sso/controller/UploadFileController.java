/*
 * Copyright 2005-2015 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.goodidea.sso.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;


import javax.servlet.http.HttpServletRequest;



import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goodidea.sso.core.JsonVo;
import com.goodidea.sso.domin.UploadFile;
import com.goodidea.sso.service.UploadFileService;

/**
 * 
* @ClassName: UploadFileController 
* @Description: 上传文件 
* @author lsg
* @date 2017年8月14日 上午10:20:08 
*
 */
@Controller
@RequestMapping("/file")
public class UploadFileController extends BaseController{

	@Resource(name = "uploadFileServiceImpl")
	private UploadFileService uploadFileService;
	/**
	 * 上传
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody
	JsonVo upload(String fileType, MultipartFile file) {
		JsonVo vo = new JsonVo();
		if(StringUtils.isNotBlank(fileType) && file != null){
			UploadFile uploadFile = uploadFileService.uploadLocal(fileType, file);
			vo.setSuccess(true);
		}else{
			vo.setSuccess(false);
		}
		return vo;
		
		
	}
	
	
}
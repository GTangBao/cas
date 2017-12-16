/*
 * Copyright 2005-2015 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.goodidea.sso.controller;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goodidea.sso.aop.SystemLog;
import com.goodidea.sso.domin.Setting;
import com.goodidea.sso.util.SystemUtils;


/**
 * 
* @ClassName: SettingController 
* @Description:  系统配置
* @author lsg
* @date 2017年9月14日 下午6:59:09 
*
 */
@Controller
@RequestMapping("/setting")
public class SettingController extends BaseController {


	
	/**
	 * 编辑
	 */
	@SystemLog(operatorType="访问系统设置页面",isSaveRequestData=true)
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(ModelMap model) {
		model.addAttribute("setting", SystemUtils.getSetting());
		return "/setting/edit";
	}

	/**
	 * 更新
	 */
	@SystemLog(operatorType="进行系统设置更新",isSaveRequestData=true)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Setting setting, MultipartFile watermarkImageFile, RedirectAttributes redirectAttributes) {
		Setting srcSetting = SystemUtils.getSetting();
		SystemUtils.setSetting(setting);
		return "redirect:edit.jhtml";
	}

}
package com.goodidea.sso.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.goodidea.sso.core.JsonVo;
import com.goodidea.sso.domin.User;
import com.goodidea.sso.form.UserForm;
import com.goodidea.sso.service.UserService;
import com.google.code.kaptcha.impl.DefaultKaptcha;

/**
 * 
* @ClassName: RegisterController 
* @Description:  注册用户
* @author lsg
* @date 2017年8月1日 下午3:49:38 
*
 */
@Controller
public class RegisterController extends BaseController{
	
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private DefaultKaptcha defaultKaptcha;
	
	@Autowired
	private UserService userService;
	
	
	/**
	 * 验证码验证
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws Exception
	 */
	@RequestMapping("/defaultKaptcha")  
    public void defaultKaptcha(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception{  
            byte[] captchaChallengeAsJpeg = null;    
             ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();    
             try {    
             //生产验证码字符串并保存到session中  
             String createText = defaultKaptcha.createText();  
             httpServletRequest.getSession().setAttribute("vrifyCode", createText);  
             //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中  
             BufferedImage challenge = defaultKaptcha.createImage(createText);  
             ImageIO.write(challenge, "jpg", jpegOutputStream);  
             } catch (IllegalArgumentException e) {    
                 httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);    
                 return;    
             }   
         
             //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组  
             captchaChallengeAsJpeg = jpegOutputStream.toByteArray();    
             httpServletResponse.setHeader("Cache-Control", "no-store");    
             httpServletResponse.setHeader("Pragma", "no-cache");    
             httpServletResponse.setDateHeader("Expires", 0);    
             httpServletResponse.setContentType("image/jpeg");    
             ServletOutputStream responseOutputStream =    
                     httpServletResponse.getOutputStream();    
             responseOutputStream.write(captchaChallengeAsJpeg);    
             responseOutputStream.flush();    
             responseOutputStream.close();    
    }  
	
	
	/**
	 * 注册用户
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	@ResponseBody
	public JsonVo register(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			UserForm form) {
		JsonVo vo = new JsonVo();
		try {
			/*String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
			String parameter = httpServletRequest.getParameter("vrifyCode");
			if(!captchaId.equals(parameter)){
				vo.setSuccess(false);
				vo.setMsg("验证码不正常");
				return vo;
			}*/
			userService.saveUserInfo(form);
			vo.setSuccess(true);
			vo.setMsg("注册成功");
		} catch (Exception e) {
			vo.setSuccess(false);
			logger.error(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;

	}

	
	/**
	 * 跳转到注册页面
	 * @return
	 */
	@RequestMapping(value="/reg",method=RequestMethod.GET)
	public  String reg() {
		return "register/reg";
		
	}
	
	/**
	 * 验证用户唯一性
	 * @param username
	 * @return
	 */
	@RequestMapping("/verifiUser")
	@ResponseBody
	public  JsonVo verifiUser(String username) {
		JsonVo vo = new JsonVo();
		try {
			
			User user  =  userService.findUserByUsername(username);
			if(user == null){
				vo.setSuccess(true);
			}else{
				vo.setSuccess(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
		
		
	}
}

package com.goodidea.sso.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.goodidea.sso.dao.UploadFileRepository;
import com.goodidea.sso.domin.UploadFile;
import com.goodidea.sso.service.UploadFileService;

import freemarker.template.TemplateException;

/**
 * 
* @ClassName: UploadFileServiceImpl 
* @Description:  上传文件service
* @author lsg
* @date 2017年8月14日 上午10:18:07 
*
 */
@Service
public class UploadFileServiceImpl implements UploadFileService{
	
	DateFormat fmt =new SimpleDateFormat("yyyyMM");
	
	@Resource
	private UploadFileRepository uploadFileRepository;
	
	private ServletContext servletContext;
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	

	public UploadFile uploadLocal(String fileType, MultipartFile multipartFile) {
	

		String uploadPath;
		switch (fileType) {
		case "media":
			uploadPath = "/upload/media";
			break;
		case "file":
			uploadPath = "/upload/files";
			break;
		default:
			uploadPath = "/upload/images";
			break;
		}
		
			try {
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("uuid", UUID.randomUUID().toString());
				String path = "";
				String destPath = path + UUID.randomUUID() + "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
				File destFile = new File(servletContext.getRealPath(destPath));
				new File(path).mkdirs();
				multipartFile.transferTo(destFile);
				UploadFile uploadFile = new UploadFile();
				uploadFile.setName(multipartFile.getOriginalFilename());
				uploadFile.setUrl(destPath);
				uploadFile.setType(fileType);
				UploadFile file = uploadFileRepository.save(uploadFile);
				return file;
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
	}



 }



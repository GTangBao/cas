/*
 * Copyright 2005-2015 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.goodidea.sso.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.ArrayConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;

import com.goodidea.sso.domin.CommonAttributes;
import com.goodidea.sso.domin.EnumConverter;
import com.goodidea.sso.domin.Setting;
import com.goodidea.sso.interceptor.LogAspect;



/**
 * 
* @ClassName: SystemUtils 
* @Description:  系统配置工具类
* @author lsg
* @date 2017年9月14日 下午6:06:08 
*
 */
public final class SystemUtils {

	/** BeanUtilsBean */
	private static final BeanUtilsBean BEAN_UTILS;
	protected static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	/** 
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址; 
     *  
     * @param request 
     * @return 
     * @throws IOException 
     */  
    public static String getIpAddress(HttpServletRequest request) throws IOException {  
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址  
  
        String ip = request.getHeader("X-Forwarded-For");  
        if (logger.isInfoEnabled()) {  
            logger.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);  
        }  
  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("Proxy-Client-IP");  
                if (logger.isInfoEnabled()) {  
                    logger.info("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);  
                }  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("WL-Proxy-Client-IP");  
                if (logger.isInfoEnabled()) {  
                    logger.info("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);  
                }  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("HTTP_CLIENT_IP");  
                if (logger.isInfoEnabled()) {  
                    logger.info("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);  
                }  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
                if (logger.isInfoEnabled()) {  
                    logger.info("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);  
                }  
            }  
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
                ip = request.getRemoteAddr();  
                if (logger.isInfoEnabled()) {  
                    logger.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);  
                }  
            }  
        } else if (ip.length() > 15) {  
            String[] ips = ip.split(",");  
            for (int index = 0; index < ips.length; index++) {  
                String strIp = (String) ips[index];  
                if (!("unknown".equalsIgnoreCase(strIp))) {  
                    ip = strIp;  
                    break;  
                }  
            }  
        }  
        return ip;  
    }  

	static {
		ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean() {
			@Override
			public String convert(Object value) {
				if (value != null) {
					Class<?> type = value.getClass();
					if (type.isEnum() && super.lookup(type) == null) {
						super.register(new EnumConverter(type), type);
					} else if (type.isArray() && type.getComponentType().isEnum()) {
						if (super.lookup(type) == null) {
							ArrayConverter arrayConverter = new ArrayConverter(type, new EnumConverter(type.getComponentType()), 0);
							arrayConverter.setOnlyFirstToString(false);
							super.register(arrayConverter, type);
						}
						Converter converter = super.lookup(type);
						return ((String) converter.convert(String.class, value));
					}
				}
				return super.convert(value);
			}

			@SuppressWarnings("rawtypes")
			@Override
			public Object convert(String value, Class clazz) {
				if (clazz.isEnum() && super.lookup(clazz) == null) {
					super.register(new EnumConverter(clazz), clazz);
				}
				return super.convert(value, clazz);
			}

			@SuppressWarnings("rawtypes")
			@Override
			public Object convert(String[] values, Class clazz) {
				if (clazz.isArray() && clazz.getComponentType().isEnum() && super.lookup(clazz.getComponentType()) == null) {
					super.register(new EnumConverter(clazz.getComponentType()), clazz.getComponentType());
				}
				return super.convert(values, clazz);
			}

			@SuppressWarnings("rawtypes")
			@Override
			public Object convert(Object value, Class targetType) {
				if (super.lookup(targetType) == null) {
					if (targetType.isEnum()) {
						super.register(new EnumConverter(targetType), targetType);
					} else if (targetType.isArray() && targetType.getComponentType().isEnum()) {
						ArrayConverter arrayConverter = new ArrayConverter(targetType, new EnumConverter(targetType.getComponentType()), 0);
						arrayConverter.setOnlyFirstToString(false);
						super.register(arrayConverter, targetType);
					}
				}
				return super.convert(value, targetType);
			}
		};

		DateConverter dateConverter = new DateConverter();
		dateConverter.setPatterns(CommonAttributes.DATE_PATTERNS);
		convertUtilsBean.register(dateConverter, Date.class);
		BEAN_UTILS = new BeanUtilsBean(convertUtilsBean);
	}

	/**
	 * 不可实例化
	 */
	private SystemUtils() {
	}

	/**
	 * 获取系统设置
	 * 
	 * @return 系统设置
	 */
	@SuppressWarnings("unchecked")
	@Cacheable(value = "setting")
	public static Setting getSetting() {
		Setting setting = new Setting();
		try {
			File ssoXmlFile = new ClassPathResource(CommonAttributes.SSO_XML_PATH).getFile();
			Document document = new SAXReader().read(ssoXmlFile);
			List<Element> elements = document.selectNodes("/sso/setting");
			for (Element element : elements) {
				try {
					String name = element.attributeValue("name");
					String value = element.attributeValue("value");
					BEAN_UTILS.setProperty(setting, name, value);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e.getMessage(), e);
				} catch (InvocationTargetException e) {
					throw new RuntimeException(e.getMessage(), e);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (DocumentException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return setting;
	}

	/**
	 * 设置系统设置
	 * 
	 * @param setting
	 *            系统设置
	 */
	@SuppressWarnings("unchecked")
	@CacheEvict(value = "setting", allEntries = true)
	public static void setSetting(Setting setting) {
		Assert.notNull(setting);

		try {
			File ssoXmlFile = new ClassPathResource(CommonAttributes.SSO_XML_PATH).getFile();
			Document document = new SAXReader().read(ssoXmlFile);
			List<Element> elements = document.selectNodes("/sso/setting");
			for (Element element : elements) {
				try {
					String name = element.attributeValue("name");
					String value = BEAN_UTILS.getProperty(setting, name);
					Attribute attribute = element.attribute("value");
					attribute.setValue(value);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e.getMessage(), e);
				} catch (InvocationTargetException e) {
					throw new RuntimeException(e.getMessage(), e);
				} catch (NoSuchMethodException e) {
					throw new RuntimeException(e.getMessage(), e);
				}
			}

			XMLWriter xmlWriter = null;
			try {
				OutputFormat outputFormat = OutputFormat.createPrettyPrint();
				outputFormat.setEncoding("UTF-8");
				outputFormat.setIndent(true);
				outputFormat.setIndent("	");
				outputFormat.setNewlines(true);
				xmlWriter = new XMLWriter(new FileOutputStream(ssoXmlFile), outputFormat);
				xmlWriter.write(document);
				xmlWriter.flush();
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e.getMessage(), e);
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e.getMessage(), e);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			} finally {
				try {
					if (xmlWriter != null) {
						xmlWriter.close();
					}
				} catch (IOException e) {
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} catch (DocumentException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
}
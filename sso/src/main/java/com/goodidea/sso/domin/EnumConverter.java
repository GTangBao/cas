/*
 * Copyright 2005-2015 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.goodidea.sso.domin;

import org.apache.commons.beanutils.converters.AbstractConverter;

/**
 * 
* @ClassName: EnumConverter 
* @Description:  枚举类型转换
* @author lsg
* @date 2017年9月14日 下午6:38:15 
*
 */
public class EnumConverter extends AbstractConverter {

	/** 枚举类型 */
	private final Class<?> enumClass;

	/**
	 * 构造方法
	 * 
	 * @param enumClass
	 *            枚举类型
	 */
	public EnumConverter(Class<?> enumClass) {
		this(enumClass, null);
	}

	/**
	 * 构造方法
	 * 
	 * @param enumClass
	 *            枚举类型
	 * @param defaultValue
	 *            默认值
	 */
	public EnumConverter(Class<?> enumClass, Object defaultValue) {
		super(defaultValue);
		this.enumClass = enumClass;
	}

	/**
	 * 获取默认类型
	 * 
	 * @return 默认类型
	 */
	@Override
	protected Class<?> getDefaultType() {
		return this.enumClass;
	}

	/**
	 * 转换为枚举对象
	 * 
	 * @param type
	 *            类型
	 * @param value
	 *            值
	 * @return 枚举对象
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Object convertToType(Class type, Object value) {
		String stringValue = value.toString().trim();
		return Enum.valueOf(type, stringValue);
	}

	/**
	 * 转换为字符串
	 * 
	 * @param value
	 *            值
	 * @return 字符串
	 */
	protected String convertToString(Object value) {
		return value.toString();
	}

}
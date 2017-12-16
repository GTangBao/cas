/*
 * Copyright 2005-2015 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.goodidea.sso.core;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.goodidea.sso.listerer.EntityListener;

/**
 * Entity - 基类
 * 
 * @author SHOP++ Team
 * @version 4.0
 */
@EntityListeners(EntityListener.class)
@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

	 private static final long serialVersionUID = -4226656537647700397L;

	/** "ID"属性名称 */
	public static final String ID_PROPERTY_NAME = "id";

	/** "创建日期"属性名称 */
	public static final String CREATE_DATE_PROPERTY_NAME = "createDate";

	/** "修改日期"属性名称 */
	public static final String MODIFY_DATE_PROPERTY_NAME = "modifyDate";

	/** "版本"属性名称 */
	public static final String VERSION_PROPERTY_NAME = "version";

	/**
	 * 保存验证组
	 */
	public interface Save extends Default {

	}

	/**
	 * 更新验证组
	 */
	public interface Update extends Default {

	}

	/** ID */
	
	private String id;

	/** 创建日期 */
	
	private Date createDate;

	/** 修改日期 */
	
	private Date modifyDate;

	/** 版本 */
	
	private Long version;
	
	/** 删除标记*/
	
	private String isdel;

	/**
	 * 获取ID
	 * 
	 * @return ID
	 */
	/*@DocumentId*/
	@Id
	/*@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator")*/
	@GeneratedValue(generator = "sequenceGenerator")
	@Column(name = "id", length = 32, nullable = false)
	public String getId() {
		return id;
	}

	/**
	 * 设置ID
	 * 
	 * @param id
	 *            ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取创建日期
	 * 
	 * @return 创建日期
	 */
	@Column(name = "t_createtime",nullable=false)
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置创建日期
	 * 
	 * @param createDate
	 *            创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获取修改日期
	 * 
	 * @return 修改日期
	 */
	@Column(name = "t_modifytime",nullable=false)
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * 设置修改日期
	 * 
	 * @param modifyDate
	 *            修改日期
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * 获取版本
	 * 
	 * @return 版本
	 */
	@Version
	@Column(name = "t_version",nullable = false,length = 4)
	public Long getVersion() {
		return version;
	}

	/**
	 * 设置版本
	 * 
	 * @param version
	 *            版本
	 */
	public void setVersion(Long version) {
		this.version = version;
	}
	
	/**
	 * 获取删除标记
	 * 
	 * @param isdel
	 *            删除标记
	 */
	@Column(name = "t_isdel",nullable = true,length =4)
	public String getIsdel() {
		return isdel;
	}

	/**
	 * 设置删除标记
	 * 
	 * @param isdel
	 *            删除标记
	 */
	public void setIsdel(String isdel) {
		if(isdel==null||"".equals(isdel)){
			this.isdel = "0";
		}else{
			this.isdel = isdel;
		}		
	}

	/**
	 * 判断是否为新建对象
	 * 
	 * @return 是否为新建对象
	 */
	@Transient
	public boolean isNew() {
		return getId() == null;
	}

	/**
	 * 重写toString方法
	 * 
	 * @return 字符串
	 */
	@Override
	public String toString() {
		return String.format("Entity of type %s with id: %s", getClass().getName(), getId());
	}

	/**
	 * 重写equals方法
	 * 
	 * @param obj
	 *            对象
	 * @return 是否相等
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!BaseEntity.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		BaseEntity<?> other = (BaseEntity<?>) obj;
		return getId() != null ? getId().equals(other.getId()) : false;
	}

	/**
	 * 重写hashCode方法
	 * 
	 * @return HashCode
	 */
	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode += getId() != null ? getId().hashCode() * 31 : 0;
		return hashCode;
	}

}

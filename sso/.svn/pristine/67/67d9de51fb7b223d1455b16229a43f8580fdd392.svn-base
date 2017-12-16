/*
 * Copyright 2005-2015 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 */
package com.goodidea.sso.listerer;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.servlet.annotation.WebListener;

import com.goodidea.sso.core.BaseEntity;



/**
 * 
* @ClassName: EntityListener 
* @Description:  修改创建时间,修改时间,版本
* @author lsg
* @date 2017年8月1日 下午4:58:33 
*
 */
public class EntityListener {

	/**
	 * 保存前处理
	 * 
	 * @param entity
	 *            实体对象
	 */
	@PrePersist
	public void prePersist(BaseEntity<?> entity) {
		entity.setCreateDate(new Date());
		entity.setModifyDate(new Date());
		entity.setVersion((long)1);
		entity.setIsdel("0");
	}

	/**
	 * 更新前处理
	 * 
	 * @param entity
	 *            实体对象
	 */
	@PreUpdate
	public void preUpdate(BaseEntity<?> entity) {
		entity.setModifyDate(new Date());
		entity.setVersion(entity.getVersion()+(long)1);
	}

}
package com.goodidea.sso.domin;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.goodidea.sso.core.BaseEntity;

/***
 * 上次文件资源
 * @author WangTang
 * @date 2016-4-21
 */
@Entity
@Table(name = "sso_upload_file")
@GenericGenerator(name = "sequenceGenerator", strategy = "uuid")
public class UploadFile extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8391729553126598891L;
	
	/***
	 * 外键
	 */
	private String fkId;
	
	/***
	 * 类型
	 */
	private String type;
	
	/***
	 * 描述
	 */
	private String desc;
	
	/***
	 * 路径
	 */
	private String url;
	
	/***
	 * 名称
	 */
	private String name;
	
	/***
	 * 文件大小  单位：byte
	 */
	private Long fileSize;
	
	
	/** 排序*/
	private Long sort;
	

	@Column(name = "fk_id", length = 32, nullable = true)
	public String getFkId() {
		return fkId;
	}

	public void setFkId(String fkId) {
		this.fkId = fkId;
	}

	@Column(name = "t_type", length = 32, nullable = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "t_desc", length = 255, nullable = true)
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "t_url", length = 255, nullable = false)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "t_name", length = 100, nullable = true)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "t_file_size", nullable = true)
	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	
	@Column(name = "t_sort", length = 32, nullable = true)
	public Long getSort() {
		return sort;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}


}

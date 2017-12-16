package com.goodidea.sso.form;

import java.io.Serializable;
import java.util.Date;

/**
 * 
* @ClassName: BaseForm 
* @Description:  基类Form
* @author lsg
* @date 2017年8月2日 下午4:05:29 
*
 */
public class BaseForm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6998531925516498331L;

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
	
	private int pageNumber;
	
	private int pageSize;
	
	private String  sortType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getIsdel() {
		return isdel;
	}

	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

	public int getPageNumber() {
		return (pageNumber>0?pageNumber-1:0);
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber ;
	}

	public int getPageSize() {
		return (pageSize>=1?pageSize:10) ;
	}

	public void setPageSize(int pageSize) {
		this.pageSize =pageSize;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	
	
	

}

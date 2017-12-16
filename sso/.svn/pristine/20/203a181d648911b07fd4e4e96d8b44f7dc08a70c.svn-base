package com.goodidea.sso.form;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class LogForm  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6494906385806772150L;
	
	
	private Long id;
	
	private String description;
	
	private String method;
	
	private String type;
	
	private String requestIp;
	
	private String exceptionCode;
	
	private String exceptionDetail;
	
	private String params;
	
	private String createBy;
	
	private Date createDate;
	
	private int pageNumber;
	
	private int pageSize;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRequestIp() {
		return requestIp;
	}

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionDetail() {
		return exceptionDetail;
	}

	public void setExceptionDetail(String exceptionDetail) {
		this.exceptionDetail = exceptionDetail;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getPageNumber() {
		return (pageNumber>0?pageNumber-1:0);
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return (pageSize>=1?pageSize:10) ;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	

}

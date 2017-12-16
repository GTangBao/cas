package com.goodidea.sso.domin;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
* @ClassName: Log 
* @Description:  日志实体
* @author lsg
* @date 2017年7月31日 下午6:57:06 
*
 */
@Entity
@Table(name = "sso_log")
public class Log implements Serializable{

	private static final long serialVersionUID = 3097101285012272632L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="method")
	private String method;
	
	@Column(name="type")
	private String type;
	
	@Column(name="request_ip")
	private String requestIp;
	
	@Column(name="exception_code")
	private String exceptionCode;
	
	@Column(name="exception_detail")
	private String exceptionDetail;
	
	@Column(name="params")
	private String params;
	
	@Column(name="create_by")
	private String createBy;
	
	@Column(name="create_date")
	private Date createDate;
	
	

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
	
	
	
	

}

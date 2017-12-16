package com.goodidea.sso.core;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/***
 * JSON封装
 * @author WangTang
 * @date 2016-4-23
 */
@JsonInclude(Include.NON_EMPTY)
public class JsonVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6200365283862813084L;
	
	/**
	 * ajax请求成功与否
	 */
	private boolean success;
	/**
	 * 业务逻辑操作成功与否
	 */
	private String messagecode;
	/**
	 * 存储返回信息
	 */
	private Object obj;	
	/**
	 * 返回文件名
	 */
	private String filename;
	
	private Set<Object> objs;
	
	/***
	 * 状态标识码
	 */
	private int status;
	
	/***
	 * 操作信息
	 */
	private String msg;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessagecode() {
		return messagecode;
	}

	public void setMessagecode(String messagecode) {
		this.messagecode = messagecode;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Set<Object> getObjs() {
		return objs;
	}

	public void setObjs(Set<Object> objs) {
		this.objs = objs;
	}
	
	
	
}

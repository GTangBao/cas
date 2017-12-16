package com.goodidea.sso.util;


import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class APIUtil {

	/**
	 * 连接Liferay Portal工具类
	 * 
	 * @param serviceName
	 * @param project
	 * @return
	 * @throws MalformedURLException
	 */
	public static URL getURL(String serviceName, String project) {
		String url = "http://192.168.2.120:8080";
		String email = "316887802@qq.com";
		String password = "123456";

		int pos = url.indexOf("://");
		String protocol = url.substring(0, pos + 3);
		String host = url.substring(pos + 3, url.length());

		StringBuilder sb = new StringBuilder();
		sb.append(protocol);
		try {
			sb.append(URLEncoder.encode(email, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		sb.append(":");
		sb.append(password);
		sb.append("@");
		sb.append(host);
		if (null != project && !"".equals(project)) {
			sb.append("/" + project);
		}
		sb.append("/api/axis/");
		sb.append(serviceName);
		System.out.println(sb.toString());
		try {
			return new URL(sb.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static URL getPortalURL(String serviceName) {
		String url = "http://192.168.2.120:8080";

		int pos = url.indexOf("://");
		String protocol = url.substring(0, pos + 3);
		String host = url.substring(pos + 3, url.length());

		StringBuilder sb = new StringBuilder();
		sb.append(protocol);
		sb.append(host);
		sb.append("/api/axis/");
		sb.append(serviceName);
		System.out.println(sb.toString());
		try {
			return new URL(sb.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据服务路径获取URL
	 * @param serviceAddress
	 * @return
	 */
	public static URL getPortalURLForAddress(String serviceAddress) {
		try {
			return new URL(serviceAddress);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

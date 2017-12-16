package com.goodidea.sso.controller;


import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Stub;

import com.goodidea.sso.util.APIUtil;
import com.liferay.client.soap.portal.model.PortletPreferencesIds;
import com.liferay.client.soap.portal.model.UserSoap;
import com.liferay.client.soap.portal.service.ServiceContext;
import com.liferay.client.soap.portal.service.http.PortletServiceSoap;
import com.liferay.client.soap.portal.service.http.PortletServiceSoapService;
import com.liferay.client.soap.portal.service.http.PortletServiceSoapServiceLocator;
import com.liferay.client.soap.portal.service.http.ResourcePermissionServiceSoap;
import com.liferay.client.soap.portal.service.http.ResourcePermissionServiceSoapService;
import com.liferay.client.soap.portal.service.http.ResourcePermissionServiceSoapServiceLocator;
import com.liferay.client.soap.portal.service.http.RoleServiceSoap;
import com.liferay.client.soap.portal.service.http.RoleServiceSoapService;
import com.liferay.client.soap.portal.service.http.RoleServiceSoapServiceLocator;
import com.liferay.client.soap.portal.service.http.UserServiceSoap;
import com.liferay.client.soap.portal.service.http.UserServiceSoapService;
import com.liferay.client.soap.portal.service.http.UserServiceSoapServiceLocator;

import jdk.nashorn.internal.parser.JSONParser;

public class Test {

	public static final String USERNAME = "316887802@qq.com";
	public static final String PASSWORD = "123456";
	
	public static final long GROUPID = 20435;
	public static final long COMPANYID = 20154;
	public static final String NAME = "chatroom_WAR_ChatRoomportlet";
	public static final int SCOPE = 1;
	public static final String PRIMKEY = "20154";
	public static final long ROLEID = 20162;
	public static final String ACTIONID = "VIEW";

	/**
	 * 添加权限
	 * 
	 * @param groupId
	 * @param companyId
	 * @param name
	 * @param scope
	 * @param primKey
	 * @param roleId
	 * @param actionId
	 * @return
	 */
	public boolean addResourcePermission(long groupId, long companyId, String name, int scope, String primKey,
			long roleId, String actionId) {

		try {

			ResourcePermissionServiceSoapService localtor = new ResourcePermissionServiceSoapServiceLocator();
			ResourcePermissionServiceSoap service = localtor.getPortal_ResourcePermissionService(
					APIUtil.getPortalURLForAddress(localtor.getPortal_ResourcePermissionServiceAddress()));

			((Stub) service)._setProperty(Call.USERNAME_PROPERTY, USERNAME);
			((Stub) service)._setProperty(Call.PASSWORD_PROPERTY, PASSWORD);

			// System.out.println("serviceAddress：" +
			// localtor.getPortal_ResourcePermissionServiceAddress());

			service.addResourcePermission(groupId, companyId, name, scope, primKey, roleId, actionId);

			return true;
		} catch (ServiceException | RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除权限
	 * 
	 * @param groupId
	 * @param companyId
	 * @param name
	 * @param scope
	 * @param primKey
	 * @param roleId
	 * @param actionId
	 * @return
	 */
	public boolean removeResourcePermission(long groupId, long companyId, String name, int scope, String primKey,
			long roleId, String actionId) {

		try {
			ResourcePermissionServiceSoapService localtor = new ResourcePermissionServiceSoapServiceLocator();
			ResourcePermissionServiceSoap service = localtor
					.getPortal_ResourcePermissionService(APIUtil.getPortalURL("Portal_ResourcePermissionService"));

			((Stub) service)._setProperty(Call.USERNAME_PROPERTY, USERNAME);
			((Stub) service)._setProperty(Call.PASSWORD_PROPERTY, PASSWORD);

			service.removeResourcePermission(groupId, companyId, name, scope, primKey, roleId, actionId);

			return true;
		} catch (ServiceException | RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 更新权限
	 * 
	 * @param groupId
	 * @param companyId
	 * @param name
	 * @param primKey
	 * @param roleId
	 * @param actionIds
	 * @return
	 */
	public boolean setIndividualResourcePermissions(long groupId, long companyId, String name, String primKey,
			long roleId, String[] actionIds) {

		try {
			ResourcePermissionServiceSoapService localtor = new ResourcePermissionServiceSoapServiceLocator();
			ResourcePermissionServiceSoap service = localtor
					.getPortal_ResourcePermissionService(APIUtil.getPortalURL("Portal_ResourcePermissionService"));

			((Stub) service)._setProperty(Call.USERNAME_PROPERTY, USERNAME);
			((Stub) service)._setProperty(Call.PASSWORD_PROPERTY, PASSWORD);
			service.setIndividualResourcePermissions(groupId, companyId, name, primKey, roleId, actionIds);

			return true;
		} catch (ServiceException | RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 获取用户
	 * @param companyId
	 * @param userName
	 */
	public void getLiferayUser(long companyId) {

		try {
			UserServiceSoapService userLocaltor = new UserServiceSoapServiceLocator();
			UserServiceSoap userService = userLocaltor
					.getPortal_UserService(APIUtil.getPortalURLForAddress(userLocaltor.getPortal_UserServiceAddress()));
			
			((Stub) userService)._setProperty(Call.USERNAME_PROPERTY, USERNAME);
			((Stub) userService)._setProperty(Call.PASSWORD_PROPERTY, PASSWORD);
			
			UserSoap user = userService.getUserByEmailAddress(companyId, USERNAME);
			
			System.out.println("primaryKey：" + user.getPrimaryKey());
			System.out.println("companyID：" + user.getCompanyId());
			
			System.out.println("user：" + user);
			
		} catch (ServiceException | RemoteException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * 获取portlet列表
	 */
	public void getPortletList() {

		try {
			PortletServiceSoapService portletLocaltor = new PortletServiceSoapServiceLocator();
			PortletServiceSoap portletService = portletLocaltor.getPortal_PortletService(
					APIUtil.getPortalURLForAddress(portletLocaltor.getPortal_PortletServiceAddress()));
			
			// System.out.println(portletLocaltor.getPorts());
			
			((Stub) portletService)._setProperty(Call.USERNAME_PROPERTY, USERNAME);
			((Stub) portletService)._setProperty(Call.PASSWORD_PROPERTY, PASSWORD);
			String portlets = portletService.getWARPortlets();
			System.out.println("portlets：" + portlets);
			
			Iterator iterator = portletLocaltor.getPorts();
			
			
		} catch (ServiceException | RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加角色
	 * @param userId
	 * @param roleIds
	 * @param subtype
	 * @param serviceContext
	 * @param className
	 * @param classPK
	 * @param name
	 * @param titleMapLanguageIds
	 * @param titleMapValues
	 * @param descriptionMapLanguageIds
	 * @param descriptionMapValues
	 * @param type
	 */
	public void addRole(long userId, long[] roleIds, String subtype, ServiceContext serviceContext, String className,
			long classPK, String name, String[] titleMapLanguageIds, String[] titleMapValues,
			String[] descriptionMapLanguageIds, String[] descriptionMapValues, int type) {

		try {
			RoleServiceSoapService roletLocaltor = new RoleServiceSoapServiceLocator();
			RoleServiceSoap roleService = roletLocaltor.getPortal_RoleService(
					APIUtil.getPortalURLForAddress(roletLocaltor.getPortal_RoleServiceAddress()));

			((Stub) roleService)._setProperty(Call.USERNAME_PROPERTY, USERNAME);
			((Stub) roleService)._setProperty(Call.PASSWORD_PROPERTY, PASSWORD);

//			roleService.addRole(name, titleMapLanguageIds, titleMapValues, descriptionMapLanguageIds,
//					descriptionMapValues, type);
			roleService.addRole(className, classPK, name, titleMapLanguageIds, titleMapValues,
					descriptionMapLanguageIds, descriptionMapValues, type, subtype, serviceContext);
//			roleService.addUserRoles(userId, roleIds);

		} catch (ServiceException | RemoteException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {

		/*
		 * System.out.println("serviceName：" + localtor.getServiceName());
		 * System.out.println("serviceAddress：" +
		 * localtor.getPortal_ResourcePermissionServiceAddress());
		 */

		Test test = new Test();
		// test.addResourcePermission(GROUPID, COMPANYID, NAME, SCOPE, PRIMKEY, ROLEID, ACTIONID);
		test.removeResourcePermission(GROUPID, COMPANYID, NAME, SCOPE, PRIMKEY, ROLEID, ACTIONID);
		// test.getLiferayUser(20154);
		// test.getPortletList();
	}

}

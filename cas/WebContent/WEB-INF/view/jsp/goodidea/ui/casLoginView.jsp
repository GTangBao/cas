
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" scope="session"/>
<html>
<head>
 <meta charset="UTF-8"/>
    <title>单点登录</title>
    <link rel="icon" type="image/x-icon" href="${ctx}/favicon.ico"/>
    <script type="text/javascript" src="${ctx}/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery-ui-1.10.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/cas.js"></script>
<style>
.mask{position:fixed;left:0px;right:0px;top:0px;bottom:0px;background:#444;}
.login{width:360px;height:300px;background:#fff;border-radius:3px;border:1px solid #000;position:fixed;margin-top:-150px;margin-left:-180px;top:50%;left:50%;z-index:1;}
.login .title{overflow:hidden;margin-top:10px;font-size:20px;text-align:center;height:35px;line-height:35px;}
.login .close{position:absolute;right:4px;top:4px;font-size:14px;cursor:pointer;}
.login .main{width:90%;margin:0 auto;overflow:hidden;margin-top:20px;}
.login .main .line{height:30px;line-height:30px;margin-bottom:12px;}
.login .main .line .left{width:20%;float:left;font-size:14px;}
.login .main .line .right{width:80%;float:left;font-size:14px;}
.login .main .line .right input{border:1px solid #000;height:30px;line-height:30px;font-size:14px;box-sizing: border-box;width: 100%;border-left:2px solid #34ab46;}
.login .main .line .yzm_input{    margin-left: 64px;margin-left:width:40%;float:left;border:1px solid #000;height:30px;line-height:30px;font-size:14px;box-sizing: border-box;border-left:2px solid #34ab46;}
.login .main .line .yzm{width:32%;float:left;height:30px;margin-left:5%;}
.login .main .line .remember , .login .main .line .forget{width:50%;float:left;font-size:12px;}
.login .main .line .sign ,.login .main .line .reg{width:50%;text-align:center;float:left;}
.login .main .line .sign .btn ,.login .main .line .reg .btn{margin: 0 auto;display: block;width:80%;height:30px;box-sizing: border-box;border:0px;color:#fff;cursor:pointer;}
.login .main .line .reg .btn{background:#4c91ff;}
.login .main .line .sign .btn{background:#34ab46;}
#msg {padding:20px; margin-bottom:10px;}
#msg.errors {border:1px dotted #BB0000; color:#BB0000; padding-left:100px; background:url(${ctx}/images/error.gif) no-repeat 20px center;}
</style>
</head>
<body>

<form:form method="post" commandName="${commandName}" htmlEscape="true">
    <input type="hidden" name="lt" value="${loginTicket}"/>
    <input type="hidden" name="execution" value="${flowExecutionKey}"/>
    <input type="hidden" name="_eventId" value="submit"/>
<div class="mask">
<div class="login">
	<div class="title">统一登录认证中心</div>
	<div class="main">
	<form:errors path="*" id="msg" cssClass="errors" element="div" htmlEscape="false"/>
		<div class="line">
			 <c:if test="${not empty sessionScope.openIdLocalId}">
                    <strong>${sessionScope.openIdLocalId}</strong>
                    <input type="hidden" name="username" value="${sessionScope.openIdLocalId}"/>
                </c:if>
			<div class="left">用户名:</div>
			<c:if test="${empty sessionScope.openIdLocalId}">
			<div class="right"><form:input tabindex="1" path="username" placeholder="帐号" htmlEscape="true" maxlength="16" size="25"/></div>
			</c:if>
		</div>
		<div class="line">
			<div class="left">密码:</div>
			<div class="right"> <form:password tabindex="2" path="password" placeholder="密码" htmlEscape="true" maxlength="16" size="25"/></div>
		</div>
		<div class="line">
			<form:input tabindex="3" class="yzm_input" path="captcha" placeholder="验证码" htmlEscape="true" maxlength="4" size="15"/>
			<img class="yzm" src="captcha.jsp" onClick="this.src='captcha.jsp?time'+Math.random();">
		</div>
		<!--  <div class="line">
			 <div class="remember" style="margin-left:64px;"><input type="checkbox" tabindex="4" name="rememberMe" value="true"/>记住我(2周)</div>
		</div>-->
		<div class="line">
			<div class="sign"><input type="submit" tabindex="5" class="btn" value="登录"/></div>
			<div class="reg"><input type="reset" tabindex="6" class="btn" value="重置"/></div>
			
		</div>
	</div>
</div>
</div>
</form:form>
</body>
<script type="text/javascript" src="${ctx}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	if($('#msg').is(':visible')) {
		setTimeout('myrefresh()',1000);
	}
})
function myrefresh() 
{ 	
	
	window.location.reload(); 
}
</script>
</html>
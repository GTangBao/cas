<!Doctype html>
<html>
<head>
<meta charset="utf-8" name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0">
<#include "/inc/resources.ftl"/>
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
</style>
</style>
</head>

<script type="text/javascript">
$(document).ready(function(){
	

});

//校验用户唯一性
function checkUsername(username){
	$.ajax({
		url:"${base}/verifiUser",
		type:"GET",
		data:{username:username},
		dataType:"json",
		success:function(data){
			if(!data.success){
				alert("用户名已存在");
				$("#username").val("");
				return false;
			}
			
		}
	});
}

//检验form表单信息
function checkUser(){
	var username = $("#username").val();
	if(username==""){
		alert("用户名不能为空");
		return false;
	}
	
	
	var pass = $("#password").val();
	if(pass ==""){
		alert("密码不能为空");
		return false;
	}
	var regPassword = $("#regPassword").val();
	if(regPassword != pass){
		alert("密码不一致");
		return false;
	}
		$.ajax({
		url:"${base}/registerUser",
		type:"POST",
		data:$("#form1").serialize(),
		dataType:"json",
		success:function(data){
			if(data.success){
				alert("注册成功");
				return false;
			}
			
		}
	});
	
}


</script>
<body>
<div class="mask">
	<div class="login">
		<div class="title">用户统一认证中心(注册)</div>
		<!--<div class="close">X</div>-->
		<form action="save" method="post" name="form1" id="form1"  >
		<div class="main">
			<div class="line">
				<div class="left">用户名:</div>
				<div class="right"><input type="text" placeholder="用户名" id="username" name="username" onblur="checkUsername(this.value)"/></div>
			</div>
			<div class="line">
				<div class="left">密码:</div>
				<div class="right"><input type="password" placeholder="密码" id="password"  name="password"/></div>
			</div>
			<div class="line">
				<div class="left">确认密码:</div>
				<div class="right"><input type="password" placeholder="确认密码" id="regPassword"/></div>
			</div>
		<div class="line">
			<div class="sign"><a onclick="checkUser()" class="btn">确认注册</a></div>
			<div class="reg"><a href ="#" class="btn">重置</a></div>
		</div>
		</form>
		</div>
	</div>
</div>

</body>
</html>
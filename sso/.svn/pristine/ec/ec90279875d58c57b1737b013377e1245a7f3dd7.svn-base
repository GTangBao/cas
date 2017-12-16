<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>统一用户管理</title>
<#include "/inc/resources.ftl"/>
<script type="text/javascript">
	$(document).ready(function(){
});

function back(){
	window.history.back(); 
}

		
}
</script>
<style>
.topji{position:relative;}
.zTreeDemoBackground{width:300px;height:200px;position:absolute;left:80px;top:42px;border:1px solid #999;background:#fff;z-index:1;}
</style>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<a href="#">部门管理</a>&nbsp;-</span>&nbsp;部门人员列表
			</div>
		</div>
		
		<div class="page ">
			<!-- 上传广告页面样式 -->
			<form action="${base}/dept/save" method="post" id="form1">
			<div class="banneradd bor">
				<div class="baBody">
					<div class="bbD">
						部门名称：<input type="text" class="input3"  name="name" id="name" maxlength="100"  placeholder="输入部门名称"/><span id="nameTip" class="onshow"></span>
					</div>
					<div class="bbD">
						部门类型：<input type="text" class="input3"  name="deptType" id="deptType" maxlength="100"  placeholder="输入部门类型"/><span id="deptTypeTip" class="onshow"></span>
					</div>
					<div class="bbD">
						部门等级：<input type="text" class="input3"  name="deptLevel" id="deptLevel" maxlength="100"  placeholder="输入部门等级"/><span id="deptLevelTip" class="onshow"></span>
					</div>
					<div class="bbD topji">
						上级部门：<select class="input3" onclick="getTree()" id="parentId" name="parentId">
									<option value="TOP">请选择上级部门</option>
								</select> <span id="parentIdTip" class="onshow"></span>
						<div class="zTreeDemoBackground left">
							<ul id="tree" class="ztree"></ul>
						</div>
					</div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" type="submit">提交</button>
							<a class="btn_ok btn_no" href="#" onclick="back();">取消</a>
						</p>
					</div>
				</div>
			</div>
			</form>
		</div>
	</div>
</body>
</html>
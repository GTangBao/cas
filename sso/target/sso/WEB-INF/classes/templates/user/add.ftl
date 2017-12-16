<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>统一用户管理</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<!-- basic styles -->

		<link href="${base}/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${base}/css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->

		<link rel="stylesheet" href="${base}/css/jquery-ui-1.10.3.custom.min.css" />
		<link rel="stylesheet" href="${base}/css/chosen.css" />
		<link rel="stylesheet" href="${base}/css/datepicker.css" />
		<link rel="stylesheet" href="${base}/css/bootstrap-timepicker.css" />
		<link rel="stylesheet" href="${base}/css/daterangepicker.css" />
		<link rel="stylesheet" href="${base}/css/colorpicker.css" />
		<link rel="stylesheet" type="text/css" href="${base}/css/zTreeStyle.css" />

		<!-- fonts -->

		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

		<!-- ace styles -->

		<link rel="stylesheet" href="${base}/css/ace.min.css" />
		<link rel="stylesheet" href="${base}/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${base}/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${base}/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->

		<script src="${base}/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="${base}/js/html5shiv.js"></script>
		<script src="${base}/js/respond.min.js"></script>
		<![endif]-->
		<style>
		.topji{position:relative;}
		.zTreeDemoBackground{width:300px;height:200px;position:absolute;left:14px;top:42px;border:1px solid #999;background:#fff;z-index:1;}
		</style>
	</head>

	<body>
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="page-content">
						<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="<a href="${base}/home"">首页</a>
							</li>

							<li>
								<a href="<a href="${base}/user/list"">用户管理</a>
							</li>
							<li class="active">用户添加</li>
						</ul><!-- .breadcrumb -->

					</div>
					<div class="space-4"></div>

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<form class="form-horizontal" role="form" action="save" method="post" name="form1" id="form1" >
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 用户名 </label>
										<div class="col-sm-9">
											<input type="text" id="username" name="username" placeholder="请输入用户名" maxlength="100" class="col-xs-10 col-sm-5"  onblur="checkUsername(this.value)"/>
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 密码 </label>
										<div class="col-sm-9">
											<input type="password" id="password" name="password" placeholder="请输入密码" maxlength="100" class="col-xs-10 col-sm-5" />
										</div>
									</div>

									<div class="space-4"></div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-3">所属角色 </label>
										<div class="col-sm-9">
											<select class="col-xs-10 col-sm-5" id="roleIds" name="roleIds">
												<option value="">请选择角色</option>
												<#list roles as role>
													<option value="${role.id}" >${role.name}</option>
												</#list>
											</select>
										</div>
									</div>
									
									<div class="space-4"></div>
									
									<div class="form-group ">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-3">所属部门</label>
										<div class="col-sm-9">
											<select class="col-xs-10 col-sm-5" id="deptId" onclick="getTree();"  name="deptId">
											</select>
											<div class="zTreeDemoBackground left">
												<ul id="tree" class="ztree"></ul>
											</div>
										</div>
										
									</div>
										
									<div class="space-4"></div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-3">是否启用</label>
										<div class="col-sm-9">
											<label>
												<input name="enabled" value="1" type="radio" class="ace" />
												<span class="lbl"> 是</span>
											</label>
											
											<label>
												<input name="enabled" value="0" type="radio" class="ace"  checked="checked"/>
												<span class="lbl"> 否</span>
											</label>
										</div>
									</div>
									

									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button class="btn btn-info" type="button" onclick="checkUser();" >
												<i class="icon-ok bigger-110"></i>
												提交
											</button>

											&nbsp; &nbsp; &nbsp;
											<button class="btn" type="reset">
												<i class="icon-undo bigger-110"></i>
												重置
											</button>
										</div>
									</div>
								</form>
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->
		</div><!-- /.main-container --
				


		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='${base}/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>


		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='${base}/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${base}/js/bootstrap.min.js"></script>
		<script src="${base}/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<!--[if lte IE 8]>
		  <script src="${base}/js/excanvas.min.js"></script>
		<![endif]-->

		<script src="${base}/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="${base}/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${base}/js/chosen.jquery.min.js"></script>
		<script src="${base}/js/bootstrap-colorpicker.min.js"></script>
		<script src="${base}/js/jquery.knob.min.js"></script>
		<script src="${base}/js/jquery.autosize.min.js"></script>
		<script src="${base}/js/jquery.inputlimiter.1.3.1.min.js"></script>
		<script src="${base}/js/jquery.maskedinput.min.js"></script>
		<script src="${base}/js/bootstrap-tag.min.js"></script>
		<script src="${base}/js/fuelux/data/fuelux.tree-sampledata.js"></script>
		<!-- ace scripts -->

		<script src="${base}/js/ace-elements.min.js"></script>
		<script src="${base}/js/ace.min.js"></script>
		<script src="${base}/js/jquery.ztree.core-3.5.js"></script>
		<script src="${base}/js/bootbox.min.js"></script>
		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($) {
				$(".zTreeDemoBackground").hide();
			});
			
			//检验form表单信息
			function checkUser(){
				var username = $("#username").val();
				if(username ==""){
					bootbox.alert("用户名不能为空");
					return false;
				}
				
				var pass = $("#password").val();
				if(pass ==""){
					bootbox.alert("密码不能为空");
					return false;
				}
				var roleIds = $("#roleIds").val();
				if(roleIds ==""){
					bootbox.alert("角色不能为空");
					return false;
				}
				
				var deptId = $("#deptId").val();
				if(deptId ==""){
					bootbox.alert("部门不能为空");
					return false;
				}
				$("#form1").submit();
				
			}
			
	//获取部门树
	function getTree(){
	
		var setting = {
				check:{
	                enable:true
	            },
				data: {
					simpleData: {
						enable: true
					}
				},
	            callback:{
	                onMouseDown: onMouseDown
	            }
			};
			
		if($(".left").is(":hidden")){
			$(".left").show();
			$.ajax({
				url:"${base}/dept/getTree",
				type:"POST",
				success:function(data){
					$.fn.zTree.init($("#tree"), setting, data.objs);
				}
		
			});
		}else{
			$(".left").hide();
		}
	}	
	
	//下拉树点击事件
	function onMouseDown(event, treeId, treeNode) {
		$("#deptId").empty();
		if(treeNode != null){
			$("#deptId").append("<option value='"+treeNode.id+"'>"+treeNode.name+"</option>");  
		}
	}
		
		//校验用户唯一性
function checkUsername(username){
	$.ajax({
		url:"${base}/verifiUser",
		type:"GET",
		data:{username:username},
		dataType:"json",
		success:function(data){
			if(!data.success){
				bootbox.alert(username+"已存在");
				$("#username").val("");
				return false;
			}
			
		}
	});
}	
		</script>
</body>
</html>

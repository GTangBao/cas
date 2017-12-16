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
		.zTreeDemoBackground{width:300px;height:200px;position:absolute;left:14px;top:30px;border:1px solid #999;background:#fff;z-index:1;}
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
								<a href="<a href="${base}/dept/listShow"">部门管理</a>
							</li>
							<li class="active">部门编辑</li>
						</ul><!-- .breadcrumb -->

					</div>
					<div class="space-4"></div>

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<form class="form-horizontal" role="form" action="update" method="post" name="form1" id="form1" >
									<input type="hidden" name="id" value="${dept.id}" />
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 部门名称 </label>
										<div class="col-sm-9">
											<input type="text" id="name" name="name" placeholder="请输入部门名称" value="${dept.name}" maxlength="100" class="col-xs-10 col-sm-5" />
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 部门类型</label>
										<div class="col-sm-9">
											<input type="text" id="deptType" name="deptType" placeholder="请输入部门类型"  value="${dept.deptType}" maxlength="100" class="col-xs-10 col-sm-5"  />
										</div>
									</div>


									
									<div class="space-4"></div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 部门等级</label>
										<div class="col-sm-9">
											<input type="text" id="deptLevel" name="deptLevel" placeholder="请输入部门等级"  value="${dept.deptLevel}" maxlength="100" class="col-xs-10 col-sm-5"  />
										</div>
									</div>


									
									<div class="space-4"></div>
									
									<div class="form-group ">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-3">上级部门</label>
										<div class="col-sm-9">
											<select class="col-xs-10 col-sm-5"  onclick="getTree();"  id="parentId" name="parentId" >
											<#if entity??>
												<option value="${entity.id}">${entity.name}</option>
											</#if>
											</select>
											<div class="zTreeDemoBackground left">
												<ul id="tree" class="ztree"></ul>
											</div>
										</div>
										
									</div>
										
									<div class="space-4"></div>
									
									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button class="btn btn-info" type="button" onclick="checkDept();" >
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
			function checkDept(){
				var name = $("#name").val();
				if(name==""){
					alert("部门名称不能为空");
					return false;
				}
				
				var deptType = $("#deptType").val();
				if(deptType ==""){
					alert("部门类型不能为空");
					return false;
				}
				var deptLevel = $("#deptLevel").val();
				if(deptLevel ==""){
					alert("部门等级不能为空");
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
					console.log(data.objs);
				}
		
			});
		}else{
			$(".left").hide();
		}
	}	
	
	//下拉树点击事件
	function onMouseDown(event, treeId, treeNode) {
		$("#parentId").empty();
		if(treeNode != null){
			$("#parentId").append("<option value='"+treeNode.id+"'>"+treeNode.name+"</option>");  
		}
	}
		</script>
</body>
</html>

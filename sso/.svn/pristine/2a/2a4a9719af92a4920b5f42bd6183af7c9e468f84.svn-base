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
								<a href="${base}/home">首页</a>
							</li>
							<li class="active">系统权限</li>
							<li>
								<a href="${base}/privileges/list">权限管理</a>
							</li>
							<li class="active">权限编辑</li>
						</ul><!-- .breadcrumb -->

					</div>
					<div class="space-4"></div>

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<form class="form-horizontal" role="form" action="update" method="post" name="form1" id="form1" >
									<input type="hidden" name="id" value="${entity.id}" />
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 权限名称 </label>
										<div class="col-sm-9">
											<input type="text" name="name" id="name"  placeholder="请输入权限名称"  value="${entity.name}" maxlength="100" class="col-xs-10 col-sm-5" />
										</div>
									</div>

									<div class="space-4"></div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 权限别称</label>
										<div class="col-sm-9">
											<input type="text" name="alias" id="alias"   placeholder="请输入权限别称" value="${entity.alias}" maxlength="100" class="col-xs-10 col-sm-5" <#--onblur="checkAlias(this.value)"-->  readonly="readonly"/>
										</div>
									</div>
						
									<div class="space-4"></div>
									
										<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 描述</label>
											<div class="col-sm-9">
												<textarea class="col-xs-10 col-sm-5 " name="description" maxlength="200" placeholder="请输入角色描述">${entity.alias}</textarea>
											</div>
										</div>
										
									<div class="space-4"></div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-3">是否启用</label>
										<div class="col-sm-9">
											<label>
												<input name="isEnabled" value="1" type="radio" class="ace" <#if entity.isEnabled ==1>checked="checked" </#if>/>
												<span class="lbl"> 是</span>
											</label>
											
											<label>
												<input name="isEnabled" value="0" type="radio" class="ace" <#if entity.isEnabled ==0>checked="checked" </#if>/>
												<span class="lbl"> 否</span>
											</label>
										</div>
									</div>
									
									<div class="space-4"></div>
									
									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button class="btn btn-info" type="button" onclick="checkPrivilege();" >
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
			});
			
			//检验form表单信息
			function checkPrivilege(){
				var name = $("#name").val();
				if(name==""){
					bootbox.alert("权限名称不能为空");
					return false;
				}
				
				var alias = $("#alias").val();
				if(alias ==""){
					bootbox.alert("权限别称不能为空");
					return false;
				}
				$("#form1").submit();
				
			}
			
					
					//校验权限别称唯一性
		function checkAlias(alias){
			$.ajax({
				url:"${base}/privileges/checkAlias",
				type:"GET",
				data:{alias:alias},
				dataType:"json",
				success:function(data){
					if(!data.success){
						bootbox.alert("权限别称已存在");
						$("#alias").val("");
						return false;
					}
					
				}
			});
		}
		
		</script>
</body>
</html>
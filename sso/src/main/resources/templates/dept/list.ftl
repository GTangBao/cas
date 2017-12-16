<#assign p=JspTaglibs["/WEB-INF/tld/privilege.tld"] />
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>统一用户管理</title>

		<link href="${base}/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${base}/css/font-awesome.min.css" />


		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
		<link rel="stylesheet" type="text/css" href="${base}/css/kkpager_blue.css"/>

		<link rel="stylesheet" href="${base}/css/ace.min.css" />
		<link rel="stylesheet" href="${base}/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="${base}/css/ace-skins.min.css" />
		<link rel="stylesheet" href="${base}/css/jquery.treegrid.css"/>

		<script src="${base}/js/ace-extra.min.js"></script>
	</head>

	<body>
		
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="${base}/home">首页</a>
							</li>

							<li>
								<a href="${base}/dept/listShow">部门管理</a>
							</li>
							<li class="active">部门列表</li>
						</ul><!-- .breadcrumb -->

					</div>

					<div class="page-content">
						<form action="${base}/user/list" method="get">
						<div class="page-header">
							<div class="form-group">
							<@p.privilege menuAlias="dept_sys"  priAlias="add">
								<a href="${base}/dept/add" class="btn btn-purple">添加部门+</a>
							</@p.privilege>
							</div>
							
						</div><!-- /.page-header -->
						</form>
						<div class="row">
							<div class="col-xs-12">

								<div class="row">
									<div class="col-xs-12">

										<div class="table-responsive">
											<table id="sample-table-2" class="table table-striped table-bordered table-hover table tree">
												<thead>
													<tr>
														<#--<th class="center">
															<label>
																<input type="checkbox" class="ace" />
																<span class="lbl"></span>
															</label>
														</th>-->
														<th>部门名称</th>
														<th>部门类型</th>
														<th>部门等级</th>
														<th>上级部门</th>
														<th>操作</th>
													</tr>
												</thead>
												<tbody>
													
													<#list depts as dept >
													<tr id="${dept.id}"  class="treegrid-${dept.id} "  >
														<td>${dept.name}</td>
														<td>${dept.deptType}</td>
														<td>${dept.deptLevel}</td>
														<td>TOP</td>
														<td>
															<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
																<@p.privilege menuAlias="dept_sys"  priAlias="update">
																<a href="${base}/dept/edit?id=${dept.id}" class="btn btn-xs btn-info" role="button">
																<i class="icon-edit bigger-120"></i>
																</a>
																</@p.privilege>
																<@p.privilege menuAlias="dept_sys"  priAlias="del">
																<a href="#" onclick="del('${dept.name}','${dept.id}')" class="btn btn-xs btn-danger" role="button">
																<i class="icon-trash bigger-120"></i>
																</a>
																</@p.privilege>
															</div>
														</td>
													</tr>
														<#list dept.childSet as son>
															<tr id="${son.id}" class="treegrid-${son.id} treegrid-parent-${son.parentId} " >
															<td>${son.name}</td>
															<td>${son.deptType}</td>
															<td>${son.deptLevel}</td>
															<td>${dept.name}</td>
															<td>
																<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
																	<@p.privilege menuAlias="dept_sys"  priAlias="update">
																	<a href="${base}/dept/edit?id=${son.id}" class="btn btn-xs btn-info" role="button">
																	<i class="icon-edit bigger-120"></i>
																	</a>
																	</@p.privilege>
																	<@p.privilege menuAlias="dept_sys"  priAlias="update">
																	<a href="#" onclick="del('${son.name}','${son.id}')" class="btn btn-xs btn-danger" role="button">
																	<i class="icon-trash bigger-120"></i>
																	</a>
																	</@p.privilege>
																</div>
															</td>
														</tr>
															<#list son.childSet as grandson>
																<tr id="${grandson.id}" class="treegrid-${grandson.id} treegrid-parent-${grandson.parentId} " >
																<td>${grandson.name}</td>
																<td>${grandson.deptType}</td>
																<td>${grandson.deptLevel}</td>
																<td>${son.name}</td>
																<td>
																	<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
																		<@p.privilege menuAlias="dept_sys"  priAlias="update">
																		<a href="${base}/dept/edit?id=${grandson.id}" class="btn btn-xs btn-info" role="button">
																		<i class="icon-edit bigger-120"></i>
																		</a>
																		</@p.privilege>
																		<@p.privilege menuAlias="dept_sys"  priAlias="update">
																		<a href="#" onclick="del('${grandson.name}','${grandson.id}')" class="btn btn-xs btn-danger" role="button">
																		<i class="icon-trash bigger-120"></i>
																		</a>
																		</@p.privilege>
																	</div>
																</td>
															</tr>
															</#list>
														</#list>
													</#list>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
					
		</div><!-- /.main-container -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='${base}/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>
		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='${base}/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="${base}/js/bootstrap.min.js"></script>
		<script src="${base}/js/typeahead-bs2.min.js"></script>

		<script src="${base}/js/ace-elements.min.js"></script>
		<script src="${base}/js/ace.min.js"></script>
		<script type="text/javascript" src="${base}/js/jquery.treegrid.js"></script>
        <script type="text/javascript" src="${base}/js/jquery.treegrid.bootstrap2.js"></script>
		<!-- inline scripts related to this page -->
		<script src="${base}/js/bootbox.min.js"></script>
		<script type="text/javascript">
			
			jQuery(function($) {
				
				
				$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
				});
				
				 $("#sample-table-2").treegrid();
			
			})
			
            
			
			
			function del(username,id){
				var dept = ".treegrid-parent-"+id;
				console.log(dept);
				if($(dept).length>0){
					bootbox.alert("存在子部门,无法删除");
					return false;
				}
				
				bootbox.confirm({
				        buttons: {
				            confirm: {
				                label: '确认',
				                className: 'btn btn-primary'
				            },
				            cancel: {
				                label: '取消',
				                className: 'btn-default'
				            }
				        },
				        message: "是否删除"+username+"信息?",
				        callback: function(result) {
				            if(result) {
				                $.ajax({
									url:"${base}/dept/delete",
									type:"get",
									data:{id:id},
									success:function(data){
										if(data.success){
											$('#'+id+'').remove();
											$(".banDel").hide();
											bootbox.alert("删除成功");
										}else{
											bootbox.alert("删除失败");
										}
									}
								})
							
				            } 
				        },
				        });
			}

			
		</script>
</body>
</html>

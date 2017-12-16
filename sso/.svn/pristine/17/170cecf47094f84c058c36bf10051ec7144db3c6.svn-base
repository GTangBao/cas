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
								<a href="#">首页</a>
							</li>

							<li>
								<a href="#">用户管理</a>
							</li>
							<li class="active">用户列表</li>
						</ul><!-- .breadcrumb -->

					</div>

					<div class="page-content">
						<form action="${base}/user/list" method="get">
						<div class="page-header">
							<div class="form-group">
								<label class="col-sm-1 control-label " > 用户名 </label>
								<span class="input-icon">
									<input type="text" placeholder="请输入用户名" name="username" <#if username??>value="${username}"</#if> class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="icon-search nav-search-icon"></i>
								</span>
								<@p.privilege menuAlias="user_sys"  priAlias="selete">
								<button class="btn btn-sm btn-primary ">提交</button>
								</@p.privilege>
								<button class="btn btn-sm btn-pink" type="reset" value="Reset">重置</button>
								<@p.privilege menuAlias="user_sys"  priAlias="add">
								<a href="${base}/user/add" class="btn btn-purple">添加用户+</a>
								</@p.privilege>
							</div>
							
						</div><!-- /.page-header -->
						</form>
						<div class="row">
							<div class="col-xs-12">

								<div class="row">
									<div class="col-xs-12">

										<div class="table-responsive">
											<table id="sample-table-2" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<#--<th class="center">
															<label>
																<input type="checkbox" class="ace" />
																<span class="lbl"></span>
															</label>
														</th>-->
														<th>创建时间</th>
														<th>用户名</th>
														<th >启用状态</th>
														<th>锁定状态</th>
														<th >锁定日期</th>
														<th>所属部门</th>
														<th>所属角色</th>
														<th>操作</th>
													</tr>
												</thead>

												<tbody>
												<#list pages.resultList as user >
													<tr id="${user.id}">
														<#--<td class="center">
															<label>
																<input type="checkbox" class="ace" value="${user.id}"/>
																<span class="lbl"></span>
															</label>
														</td>-->
														<td> ${user.createDate}</td>
														<td>${user.username}</td>
														<td><#if user.enabled ==1><span class="label label-sm label-success">启用</span><#else><span class="label label-sm label-warning">禁止</span></#if></td>
														<td><#if user.isLocked==1><span class="label label-sm label-success">锁定</span><#else><span class="label label-sm label-warning">未锁定</span></#if></td>
														<td><#if user.lockedDate??>${user.lockedDate}<#else>-</#if></td>
														<td><#if user.dept ??>
															${user.dept.name}
															<#else>
															-
															</#if>
														</td>
														<td><#if user.roles ??>
															<#list user.roles as role >
																${role.name}
															</#list>
															<#else>
															-
															</#if>
														</td>
														<td>
															<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
																<@p.privilege menuAlias="user_sys"  priAlias="update">
																<a href="${base}/user/edit?id=${user.id}" class="btn btn-xs btn-info" role="button">
																<i class="icon-edit bigger-120"></i>
																</a>
																</@p.privilege>
																<@p.privilege menuAlias="user_sys"  priAlias="del">
																<a href="#" onclick="del('${user.username}','${user.id}')" class="btn btn-xs btn-danger" role="button">
																<i class="icon-trash bigger-120"></i>
																</@p.privilege>
																</a>
															</div>
														</td>
													</tr>
													</#list>
												</tbody>
											</table>
											<div style="width:800px;margin:0 auto;">  
          
						        			<div id="kkpager"></div>  
						          
						       				</div> 
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
		<script type="text/javascript" src="${base}/js/kkpager.min.js"></script>
		<script type="text/javascript" src="${base}/js/common.js"></script>
		<!-- inline scripts related to this page -->
		<script src="${base}/js/bootbox.min.js"></script>
		<script type="text/javascript">
			var totalPage = parseInt(${pages.totalPage});
			var totalRecords = parseInt(${pages.totalNum});
			var pageSize =parseInt(${pages.pageSize}) ;
			var pageNum = parseInt(${pages.pageNum})+1;	
			
			jQuery(function($) {
			
				
				$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
				});
			
				loadInfor(pageNum,totalPage,totalRecords,pageSize);
			})
			
			
			//自定义方法，获取数据并加载
			/*
			    nowPage:当前页
			    rows：每页显示的数据条数
			*/
			function loadInfor(nowPage,totalPage,totalRecords,rows){
			   	var url = "${base}/user/list.html";
			   	
			    initPage(nowPage,totalPage,totalRecords,rows,loadInfor,url);
			   	
			}
			
			function del(username,id){
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
									url:"${base}/user/delete",
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

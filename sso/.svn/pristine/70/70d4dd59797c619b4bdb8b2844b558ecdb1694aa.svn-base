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
								<a href="${base}/home">首页</a>
							</li>
								<li class="active">日志管理</li>		
							<li>
								<a href="${base}/log/list">登录日志</a>
							</li>
							<li class="active">日志列表</li>
						</ul><!-- .breadcrumb -->

					</div>

					<div class="page-content">
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
														<th>请求IP</th>
														<th>操作日志</th>
													</tr>
												</thead>

												<tbody>
												<#list pages.resultList as log>
													<tr>
														<td>${log.createDate}</td>
														<td>${log.createBy}</td>
														<td>${log.requestIp}</td>
														<td>${log.description}</td>
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
			   	var url = "${base}/log/list.html";
			   	
			    initPage(nowPage,totalPage,totalRecords,rows,loadInfor,url);
			   	
			}
			
			

			
		</script>
</body>
</html>

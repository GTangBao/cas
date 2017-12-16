<#assign p=JspTaglibs["/WEB-INF/tld/privilege.tld"] />
<!DOCTYPE html>  
<html >  
	<head>
		<meta charset="utf-8" />
		<title>统一用户管理</title>
	</head>
<body>
	
	<#include "/inc/head.ftl" />
	
	<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					</div><!-- #sidebar-shortcuts -->
				<ul class="nav nav-list">
					<@p.privilege menuAlias="user_sys"  priAlias="see">
						<li >
							<a href="${base}/user/list" class="menu">
								<i class=" icon-group" ></i>
								<span class="menu-text">用户管理 </span>
							</a>
						</li>
					</@p.privilege>
					<@p.privilege menuAlias="dept_sys"  priAlias="see">	
						<li >
							<a href="${base}/dept/listShow" class="menu">
								<i class=" icon-laptop" ></i>
								<span class="menu-text">部门管理  </span>
							</a>
						</li>
					</@p.privilege>
					<@p.privilege menuAlias="power_sys"  priAlias="see">	
						<li >
							<a href="#" class="dropdown-toggle">
								<i class=" icon-lock"></i>
								<span class="menu-text">系统权限 </span>

								<b class="arrow icon-angle-down"></b>
							</a>
					<@p.privilege menuAlias="role_sys"  priAlias="see">
							<ul class="submenu">
								<li >
									<a href="${base}/role/list" class="menu">
										<i class="icon-double-angle-right"></i>
										角色管理
									</a>
								</li>
					</@p.privilege>
					<@p.privilege menuAlias="menu_sys"  priAlias="see">
								<li>
									<a href="${base}/menu/listShow" class="menu">
										<i class="icon-double-angle-right"></i>
										菜单管理
									</a>
								</li>
						</@p.privilege>
						<@p.privilege menuAlias="privilege_sys"  priAlias="see">
								<li>
									<a href="${base}/privileges/list" class="menu">
										<i class="icon-double-angle-right"></i>
										权限管理
									</a>
								</li>
							</@p.privilege>
							</ul>
						</li>
					</@p.privilege>
					<@p.privilege menuAlias="systems_sys"  priAlias="see">
						<li>
							<a href="${base}/systems/list" class="menu">
								<i class="icon-cog"></i>
								<span class="menu-text">应用管理</span>
							</a>
						</li>
					</@p.privilege>
					<@p.privilege menuAlias="log_sys"  priAlias="see">
						<li >
							<a href="#" class="dropdown-toggle">
								<i class=" icon-lock"></i>
								<span class="menu-text">日志管理 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<@p.privilege menuAlias="login_log"  priAlias="see">
								<li>
									<a href="${base}/log/list" class="menu">
										<i class="icon-double-angle-right"></i>
										登录日志
									</a>
								</li>
								</@p.privilege>
								<@p.privilege menuAlias="system_log"  priAlias="see">
								<li>
									<a href="${base}/systemslog/list" class="menu">
										<i class="icon-double-angle-right"></i>
										系统日志
									</a>
								</li>
								</@p.privilege>
							</ul>
						</li>
						</@p.privilege>
						<@p.privilege menuAlias="data"  priAlias="see">
						<li >
							<a href="${base}/druid/index.html" class="menu">
								<i class=" icon-facetime-video"></i>
								<span class="menu-text">数据监控 </span>
							</a>
						</li>
						</@p.privilege>
						<@p.privilege menuAlias="application_sys"  priAlias="see">
						<li >
							<a href="${base}/getCertificate" class="menu">
								<i class="icon-cogs"></i>
								<span class="menu-text">系统管理  </span>
							</a>
						</li>
						</@p.privilege>

					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>
				<iframe src=""  frameborder="0" id="iframe"></iframe>
				<#include "/inc/foot.ftl" />
			</div>	
</body>


<script type="text/javascript">
		if (self != top) {
			top.location = self.location;
		}
		$(".menu").click(function(){
  			var path = $(this).attr("href");
			$("#iframe").attr("src",path);
			return false; 
		});
	var c = $("#sidebar-collapse i").hasClass("icon-double-angle-left");
	if (!c) {
			 var pageheight =  window.screen.availHeight*1-150*1;
			  var pagewidth =  window.screen.availWidth*1-60*1;
			  document.getElementById("iframe").style.height=pageheight+"px";
			  document.getElementById("iframe").style.width=pagewidth+"px"
		} else {
			var pageheight =  window.screen.availHeight*1-150*1;
			  var pagewidth =  window.screen.availWidth*1-207*1;
			  document.getElementById("iframe").style.height=pageheight+"px";
			  document.getElementById("iframe").style.width=pagewidth+"px"
		}
		
		$("a").click(function(){
			$(this).parent().parent().parent().removeClass("active open");
			$("li").removeClass("active");
			$("a").removeClass("active");
			$(this).addClass("active");
			$(this).parent().addClass("active");
			$(this).parent().parent().parent().addClass("active open");
		})
		
		</script>
</script>
</html>
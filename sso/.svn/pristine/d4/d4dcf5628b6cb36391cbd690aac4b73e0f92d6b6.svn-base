<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>应用系统添加-有点</title>
<script type="text/javascript">
			window.jQuery || document.write("<script src='${base}/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>
<script type="text/javascript" src="${base}/js/treeTable/jquery.treeTable.js"></script>
<script src="${base}/js/bootbox.min.js"></script>
<style>
.main_jur{width:100%;overflow:hidden;}
.main_jur .jur_left{width:25%;overflow:hidden;float:left;border-right:1px solid #ebebeb;box-sizing: border-box;}
.main_jur .jur_left .jur_title{width:95%;margin:0 auto;margin-top:10px;font-size:16px;height:30px;line-height:30px;color:#000;overflow: hidden;text-overflow:ellipsis;white-space: nowrap;}
.main_jur .jur_right{width:74%;overflow:hidden;float:right;}
.main_jur .jur_right .right_top{height:60px;border-bottom:1px solid #ebebeb;overflow:hidden;}
.main_jur .jur_right .right_top .btn{padding:10px;border-radius:3px;border:0px;color:#fff;margin-top:10px;cursor:pointer;}
.main_jur .jur_right .right_top .bluebtn{background:#5bbce8;}
.main_jur .jur_right .right_top .redbtn{background:#d5544a;}
.main_jur .jur_right .right_bottom{overflow:hidden;}

.pageTop {
	width: 100%;
	height: 45px;
	line-height: 45px;
	background-color: #f2f2f2;
}

.pageTop span {
	margin-left: 15px;
}


</style>
<script type="text/javascript">
var showContent = "";//添加内容变量

$(document).ready(function(){
	
	 //保存
	$('#add').click(function(){
		savePrivileges();
	});
  			
	function ajaxSubmitMenu() {
                $.ajax({
                    type: "post",
                    url: "${base}/menu/list", 
                    dataType: "json",
                    success: function (data) {
                        var con = data.obj;//获取json中的list列表
                        $.each(con,function(i,item){
                            showContent += "<tr id='" +item.id + "' ><td><span controller='true'> "+ item.name + "</span></td>";
                            var set = item.privileges
                            var ptext = "";
                            $.each(set,function(j,setp){
                            	ptext +='<input type="checkbox" name="privilegeId" value="'+item.alias+'/'+setp.id+'">' + setp.name;
                            })
                            showContent += "<td>"+ptext+"</td></tr>";
                            
                          	 if(item.childSet.length != 0 ){
                            	  getChildData(item.childSet,item.name,item.id);
                            }
                          	 
                        })
                        
                        $("#treeTable1").append(showContent);
                        var option = {
                            theme: 'default',
                            expandLevel: 2
                           
                        };
                        $('#treeTable1').treeTable(option);
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                    }
                });
            }
            
            ajaxSubmitMenu(); //调用ajax初始化内容
});

//获取子节点数据
function getChildData(data,pNanme,pId){
	$.each(data,function(i,citem){
                showContent += "<tr id='" +citem.id + "' pid='"+pId+"' ><td> "+ citem.name + "</td>";
                var set = citem.privileges
                var ptext = "";
                $.each(set,function(j,setp){
                	ptext +='<input type="checkbox" name="privilegeId" value="'+citem.alias+'/'+setp.id+'">' + setp.name;
                })
                showContent += "<td>"+ptext+"</td></tr>";
            })
}


//返回上一页
function back(){
	window.history.back(); 
}

//点击角色
function changeRole(id){
	$("#roleId").val(id);
	$.ajax({
            type: "post",
            url: "${base}/role/getPrivilegeByRoleId",
            data:{id:id}, 
            dataType: "json",
            success: function (data) {
                $('input[name="privilegeId"]').prop("checked",false);
                if(data.obj != null){
	                $.each(data.obj, function(i,item){
						$.each(item.privileges, function(j,pItem){
							var pValue=item.alias+"/"+pItem.id;
							$("input:checkbox[value='"+pValue+"']").prop('checked','true');
						})
					})
				}	
                
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            	alert("操作出错");
            }
        });
}

//保存权限
 //保存权限
        function savePrivileges(){
        	if($('#roleId').val()==''){
        		alert("请选择角色");
			    return;
        	}
        	
        	var chk_value = []; 
  		    $('input[name="privilegeId"]:checked').each(function(){ 
  		        chk_value.push($(this).val()); 
  		    });
  		    if(chk_value.length==0){
  		    	alert("请选择要绑定的权限!");
  			    return;
  		    }
  		    console.log(chk_value);
  		    $.ajax({
  			    type: 'POST',
  			    url: '${base}/role/bingingPrivilege',
  			    dataType:'json',
  			    traditional: true,
  			    data:{
  			    	rid:$('#roleId').val(),
  			    	pid:chk_value
  			    },
  				success:function(data) {  
  					bootbox.alert("操作成功");
  					window.location.href="${base}/role/list";
  				},error:function(){
  					//alert('数据接收出错');
  				}
  		    });
        }
        
    //重置
    function reset(){
    	$("#roleId").val("");
    	$("input[name='privilegeId']").prop('checked',false);
    }
        
</script>
</head>
<body>
		<div class="pageTop">
			<div class="page">
				<a href="${base}/privileges/list">权限管理</a>&nbsp;-</span>&nbsp;角色管理&nbsp;-</span>&nbsp;绑定权限
			</div>
		</div>
	<input type="hidden" id="roleId"/>
	<div class="main_jur">
		<div class="jur_left">
			<#list roles as role>
			<div class="jur_title" onclick="changeRole('${role.id}')">${role.name}</div>
			</#list>
		</div>
		<div class="jur_right">
			<div class="right_top">
				<button class="btn redbtn"  onclick="reset()" >重置</button>
				<button class="btn bluebtn" id="add">保存</button>
			</div>
			<div class="right_bottom">
					<table id="treeTable1" style="width: 100%">
					  <tr>
						<td style="width: 200px;"> 名称</td><td> 权限</td>
					  </tr>
					</table>
			</div>
		</div>
	</div>
</body>
</html>
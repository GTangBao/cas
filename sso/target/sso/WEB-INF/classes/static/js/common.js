/**
 * 生成分页控件
   nowPage:当前页
   totalPage:总页数
   totalRows：总记录条数
   rows:每页显示多少条
   fun：要调用的函数  一般写填充表格数据的逻辑
 */

function initPage(nowPage,totalPage,totalRows,rows,fun,url){
        //生成分页控件  
kkpager.generPageHtml({
    pno : nowPage,
    mode : 'click', //设置为click模式
    //总页码  
    total : totalPage,  
    //总数据条数  
    totalRecords : totalRows,
    //点击页码、页码输入框跳转、以及首页、下一页等按钮都会调用click
    //适用于不刷新页面，比如ajax
    click : function(n){	
    	//console.log(url);
    	location.href =url+"?pageNumber=" + n + "&pageSize=" + rows;
        //处理完后可以手动条用selectPage进行页码选中切换
        this.selectPage(n);
    },
    //getHref是在click模式下链接算法，一般不需要配置，默认代码如下
    getHref : function(n){
        return '#';
    }
});
}	
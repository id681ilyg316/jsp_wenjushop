<%@page import="com.zhy.beans.Category"%>
<%@page import="com.zhy.factory.DaoFactory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.zhy.beans.Wenju"%>
<%@page import="java.util.List"%>
<%@page import="com.zhy.tools.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
<meta name="renderer" content="webkit">
<!--国产浏览器高速模式-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="精品文具" />
<!-- 生产商 -->
<meta name="revised" content="精品文具.v3, 2019/05/01" />
<!-- 定义页面的最新版本 -->
<meta name="description" content="网站简介" />
<!-- 网站简介 -->
<meta name="keywords" content="搜索关键字，以半角英文逗号隔开" />
<title>精品文具出品</title>

<!-- 公共样式 开始 -->
<link rel="stylesheet" type="text/css" href="../../css/base.css">
<link rel="stylesheet" type="text/css" href="../../css/iconfont.css">
<script type="text/javascript"
	src="../../framework/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../layui/css/layui.css">
<script type="text/javascript" src="../../layui/layui.js"></script>
<!-- 滚动条插件 -->
<link rel="stylesheet" type="text/css"
	href="../../css/jquery.mCustomScrollbar.css">
<script src="../../framework/jquery-ui-1.10.4.min.js"></script>
<script src="../../framework/jquery.mousewheel.min.js"></script>
<script src="../../framework/jquery.mCustomScrollbar.min.js"></script>
<script src="../../framework/cframe.js"></script>
<!-- 仅供所有子页面使用 -->
<!-- 公共样式 结束 -->

<style>
.layui-table img {
	max-width: none;
}

ul.pagination {
	display: inline-block;
	padding: 0;
	margin: 0;
}

ul.pagination li {
	display: inline;
}

ul.pagination li a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
}

ul.pagination li a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}
ul


 


.pagination


 


li


 


a




:hover




:not


 


(
.active


 


)
{
background-color




:


 


#ddd




;
}
</style>

</head>
<%

	
	List<Wenju> wenjus = new ArrayList<>();
	wenjus = DaoFactory.getWenjuDao().getAllWenjus();
	int pagesize = PageUtils.getWenjuPageSize(wenjus);
	if(request.getParameter("page") == null){
		wenjus = PageUtils.getWenjuList(wenjus, 1,request);
	}else{
		wenjus = PageUtils.getWenjuList(wenjus, request.getParameter("page"),request);
	}
	
	 
	request.setAttribute("nowpage", request.getParameter("page"));
	request.setAttribute("wenjus", wenjus);
%>
<body>
	<div class="cBody">
		<div class="console">


			<script>
				layui.use('form', function() {
					var form = layui.form;

					//监听提交
					form.on('submit(formDemo)', function(data) {
						layer.msg(JSON.stringify(data.field));
						return false;
					});
				});
			</script>
		</div>

		<table class="layui-table">
			<thead>
				<tr>
					<th>文具编号</th>
					<th>文具名称</th>
					<th>文具图片</th>
					<th>文具价格</th>
					<th>分类</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${wenjus }" var="wenju">
					<tr>
						<td>${wenju.id }</td>
						<td>${wenju.name }</td>
						<td><img src="/${wenju.cover}"
							width="20" height="20" onmouseenter="imgBig(this)"
							onmouseleave="imgSmall(this)" /></td>
						<td>${wenju.price }</td>
						<td>${wenju.category }</td>
						<td><a class="layui-btn layui-btn-xs" id="${wenju.id }"
							href="goods_update.jsp?id=${wenju.id }">修改</a> <a
							class="layui-btn layui-btn-xs"
							href="${pageContext.request.contextPath }/WenjuServlet?method=delete&id=${wenju.id}">删除</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
<ul class="pagination">
 		 
			<c:forEach var="i" begin="1" end="${ pagesize }">
				<c:if test="${nowpage eq i}">
					<li><a class="active"
						href="/wenjushop/tgls/goodsManage/goods_list.jsp?page=${nowpage}&size=9">${i}</a></li>
				</c:if>
				<c:if test="${nowpage ne i}">
					<li><a
						href="/wenjushop/tgls/goodsManage/goods_list.jsp?page=${i}&size=9">${i}</a></li>
				</c:if>
			</c:forEach>
			 
		</ul>
	 
		<script>
			layui.use('laypage', function() {
				var laypage = layui.laypage;

				//总页数大于页码总数
				laypage
						.render({
							elem : 'pages',
							count : 100,
							layout : [ 'count', 'prev', 'page', 'next',
									'limit', 'skip' ],
							jump : function(obj) {
								//					      console.log(obj)
							}
						});
			});

			//删除
			function delCustomList(_this) {
				layui.use([ 'form', 'laydate' ], function() {
					layer.confirm('确定要删除么？', {
						btn : [ '确定', '取消' ]
					//按钮
					}, function() {
						$(_this).parent().parent().remove();
						layer.msg('删除成功', {
							icon : 1
						});
					}, function() {
						layer.msg('取消删除', {
							time : 2000
						//20s后自动关闭
						});
					});
				});
			}
		</script>
	</div>
</body>

</html>
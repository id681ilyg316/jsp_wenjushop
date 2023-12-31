<%@page import="com.zhy.factory.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="../../framework/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../layui/css/layui.css">
<script type="text/javascript" src="../../layui/layui.js"></script>
<!-- 滚动条插件 -->
<link rel="stylesheet" type="text/css" href="../../css/jquery.mCustomScrollbar.css">
<script src="../../framework/jquery-ui-1.10.4.min.js"></script>
<script src="../../framework/jquery.mousewheel.min.js"></script>
<script src="../../framework/jquery.mCustomScrollbar.min.js"></script>
<script src="../../framework/cframe.js"></script>
<!-- 仅供所有子页面使用 -->
<!-- 公共样式 结束 -->

<style>
.layui-form-label {
	width: 100px;
}

.layui-input-block {
	margin-left: 130px;
}

.layui-form {
	margin-right: 30%;
}
</style>

</head>

<body>
	<div class="cBody">
		<form id="addForm" class="layui-form" action="${pageContext.request.contextPath}/WenjuServlet?method=add" enctype="multipart/form-data">
			<div class="layui-form-item">
				<label class="layui-form-label">文具名称</label>
				<div class="layui-input-block">
					<input type="text" name="name" required lay-verify="required" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">文具图片</label>
				<div class="layui-upload-drag" id="cover">
					<i class="layui-icon"></i>
					<p>点击上传</p>
					<input type="file" name="cover" />
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">价格</label>
				<div class="layui-input-block">
					<input type="text" name="price" required lay-verify="required|number" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">生产商</label>
				<div class="layui-input-block">
					<input type="text" name="author" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">库存</label>
				<div class="layui-input-block">
					<input type="number" name="stock" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">简介</label>
				<div class="layui-input-block">
					<textarea name="introduction" class="layui-textarea"></textarea>
				</div>
			</div>
			
			<%
				request.setAttribute("sc", DaoFactory.getCategoryDao().getCategoryByGrade(2));
			%>
			<div class="layui-form-item">
				<label class="layui-form-label">分类</label>
				<div class="layui-input-inline">
					<select name="provid" id="provid" lay-filter="provid">
						<c:forEach items="${sc }" var="c">


							<option>${c.name }</option>

						</c:forEach>

					</select>
				</div>

			</div>


			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="submitBut">立即提交</button>
				</div>
			</div>
		</form>

		<script>
			layui.use([ 'upload', 'form' ], function() {
				var form = layui.form;
				var upload = layui.upload;
				var layer = layui.layer;
				//监听提交
				form.on('submit(submitBut)', function(data) {
					return true;
				});
				form.verify({
					//数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
					ZHCheck : [ /^[\u0391-\uFFE5]+$/, '只允许输入中文' ]
				});
				//拖拽上传
				upload.render({
					elem : '#goodsPic',
					url : '/upload/',
					done : function(res) {
						console.log(res)
					}
				});
			});
		</script>

	</div>
</body>

</html>
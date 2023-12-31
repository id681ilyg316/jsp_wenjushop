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
	<script src="../../framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
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
		<form id="addForm" class="layui-form" action="${pageContext.request.contextPath }/CategoryServlet?method=add" method="post">
			<div class="layui-form-item">
				<label class="layui-form-label">分类名称</label>
				<div class="layui-input-block">
					<input type="text" name="name" required lay-verify="required" autocomplete="off"
						class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">分类等级</label>
				<div class="layui-input-block">
					<input type="text" name="grade" required lay-verify="required" autocomplete="off"
						class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
					<label class="layui-form-label">上级分类ID</label>
					<div class="layui-input-block">
						<input type="text" name="parent" required lay-verify="required" autocomplete="off" class="layui-input" placeholder="上级分类为0表示无上级">
					</div>
				</div>



			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="submitBut" >立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>


		

	</div>
</body>

</html>
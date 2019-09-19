<%@ page import="com.erp.model.*,java.util.List" language="java"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
</head>
<link href="css/main.css" rel="stylesheet" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<body>
	<div class="left-body">
		<div class="search">
			<div>客户管理系统</div>
		</div>
		<div>
			<ul class="nav nav-pills nav-stacked">
				<%
					List<MenuBar> list = (List<MenuBar>) session.getAttribute("menu");
					for (MenuBar menu : list) {
				%>
				<li role="presentation"><a href="<%=menu.getMenu_Url()%>"><%=menu.getMenu_Name()%></a></li>
				<%
					}
				%>
			</ul>
		</div>
	</div>


	<div class="right-body">
		<div class="title">
			<div class="dropdown">
				<button class="btn btn-default dropdown-toggle" type="button"
					id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true"
					style="background: none; color: #fff; border: none; font-size: 20px; line-height: 4;">
					欢迎：<%=((Admin) session.getAttribute("admin")).getUserName()%>
					<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu"
					aria-labelledby="dropdownMenu1">
					<li role="presentation"><a role="menuitem" tabindex="-1"
						data-toggle="modal" data-target="#myModal" href="#">个人资料</a></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="over.action">退出</a></li>

				</ul>
			</div>
		</div>
		<div class="main-body">
			<ol class="breadcrumb">
				<li><a href="index.action">首页</a></li>
				<li><a href="goodsList.action">订单类型列表</a></li>
				<li><a href="#">修改商品类型信息</a></li>
			</ol>
			<table style="width:45%;margin: auto;margin-top: 15px;line-height: 3;">
				<tr>
					<td>商品编号</td>
					<td class="goodsId01">${goodsInfo.goodsId}</td>
				</tr>
				<tr>
					<td>商品类型</td>
					<td>${goodsInfo.goodsName}</td>
				</tr>
				<tr>
					<td>商品价格</td>
					<td><input type="text" class="form-control goodsPrice01" value="${goodsInfo.goodsPrice}"/></td>
				</tr>
				<tr>
					<td>商品产地</td>
					<td><input type="text" class="form-control goodsAddress01" value="${goodsInfo.goodsAddress}"/></td>
				</tr>
				<tr>
				   <td></td>
				   <td><a class="btn btn-primary" onclick="commit();">确认修改</a></td>
				</tr>
			</table>

		</div>
	</div>


	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">个人资料</h4>
				</div>
				<div class="modal-body">
					<table style="width: 60%; line-height: 3;">
						<tr>
							<td>ID：</td>
							<td><%=((Admin) session.getAttribute("admin")).getId()%></td>
							<td></td>
						</tr>
						<tr style="margin-top: 5px;">
							<td>用户名：</td>
							<td class="name"><%=((Admin) session.getAttribute("admin")).getUserName()%></td>
							<td></td>
						</tr>
						<tr style="margin-top: 15px;">
							<td>密码：</td>
							<td><%=((Admin) session.getAttribute("admin")).getPassword()%></td>
							<td><a class="update">修改</a></td>
						</tr>
						<tr class="udt">
							<td>修改为：</td>
							<td>
								<form action="updatePassword.action" method="post">
									<input type="password" class="form-control updatePwd"
										placeholder="新密码...." style="line-height: 1;" />
								</form>
							</td>
							<td></td>
						</tr>

					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary conf">保存</button>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</html>
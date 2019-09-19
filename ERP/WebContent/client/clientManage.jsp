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
			       List<MenuBar> list = (List<MenuBar>)session.getAttribute("menu");
			       for(MenuBar menu:list){
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
				<li><a href="#">客户管理</a></li>
			</ol>
			<div class="infor">
				<div class="form-group clientId">
					<div class="input-group" style="margin-left: 40px;">
						<label for="exampleInputName2"><em style="color: red;">*
								客户编号</em></label> <input type="text" onblur="check();" class="form-control"
							id="clientId" placeholder="用户编号..">
					</div>
				</div>
				<div class="form-group  cli_info">
					<label for="exampleInputName2">姓名</label> <input type="text"
						class="form-control clientName">
				</div>
				<div class="form-group  cli_info">
					<label for="exampleInputName2">性别</label> <select
						class="form-control clientSex">
						<option>男</option>
						<option>女</option>
					</select>
				</div>

				<div class="form-group  cli_info">
					<label for="exampleInputName2">手机号</label> <input type="text"
						class="form-control clientPhone">
				</div>

				<div class="form-group  cli_info">
					<label for="exampleInputName2">地址</label> <input type="text"
						class="form-control clientAddress">
				</div>
				<div class="form-group  cli_info">
					<label for="exampleInputName2 ">年龄</label> <input type="text"
						class="form-control clientAge">
				</div>
			</div>
			<div class="btnArray">
				<button type="button" class="btn btn-danger deleteClient"
					style="margin-left: 40px;">删 除</button>
				<button type="button" class="btn btn-warning updateClient">
					修 改</button>
				<button type="button" class="btn btn-info add">添加客户/订单</button>
			</div>
			<div class="alert alert-danger alert-dismissible massage"
				style="width: 50%; margin: auto; margin-top: 15px; text-align: center; display: none;"
				role="alert">
				<strong class="print"></strong> <a class="alert-link">
					&nbsp;&nbsp;关闭</a>
			</div>
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


	<!-- 添加客户/订单框 -->
	<div class="addClientOrOrder" style="height: 100%;">
		<div class="addClientOrOrderBody">
			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#home"
					aria-controls="home" role="tab" data-toggle="tab">添加客户</a></li>
				<li role="presentation"><a href="#profile"
					aria-controls="profile" role="tab" data-toggle="tab">添加订单</a></li>
			</ul>

			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="home"
					style="text-align: center;">
					<table
						style="width: 60%; margin: auto; margin-top: 10px; line-height: 4;">
						<tr>
							<td>姓名</td>
							<td><input type="text" class="form-control name_client"
								placeholder="客户姓名"></td>
						</tr>
						<tr>
							<td>性别</td>
							<td><select class="form-control sex_client">
									<option>男</option>
									<option>女</option>
							</select></td>
						</tr>
						<tr>
							<td>年龄</td>
							<td><input type="text" class="form-control age_client" placeholder="年龄"></td>
						</tr>
						<tr>
							<td>地址</td>
							<td><input type="text" class="form-control address_client" placeholder="地址"></td>
						</tr>
						<tr>
							<td>联系方式</td>
							<td><input type="text" class="form-control phone_client"
								placeholder="联系方式"></td>
						</tr>
					</table>
					<button type="button" class="btn btn-primary  addClient"
						style="width: 130px; margin-top: 15px;">添加</button>
					<br>
					<button type="button" class="btn btn-default canel"
						style="width: 130px; margin-top: 15px;">取消</button>
				</div>
				<div role="tabpanel" class="tab-pane" id="profile" style="text-align: center;">
				
				  <table
						style="width: 60%; margin: auto; margin-top: 10px; line-height: 4;">
						<tr>
							<td>订单类型</td>
							<td><select class="form-control orderType" onchange="chose();">
									<option></option>
									<c:forEach items="${goodsType}" var="goodsType">
									  <option>${goodsType.goodsName}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td>单价</td>
							<td class="goodsprice"></td>
						</tr>
						<tr>
							<td>数量</td>
							<td><input type="number" onblur="getBalance();" class="form-control orderNumber" min="1" placeholder="数量"></td>
						</tr>
						<tr>
							<td>客户编号</td>
							<td><input type="text" class="form-control order_clientId" placeholder="编号"></td>
						</tr>
						<tr>
							<td>金额</td>
							<td><input type="text" class="form-control orderBalance" placeholder="金额"></td>
						</tr>
						
					</table>
					<button type="button" class="btn btn-primary addOrders"
						style="width: 130px; margin-top: 15px;">添加</button>
					<br>
					<button type="button" class="btn btn-default canel"
						style="width: 130px; margin-top: 15px;">取消</button>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
function chose(){
	if($('.orderType').val()==""){
		alert("请选择类型...！");
	}
	else{
		$.ajax({
			type : "post",
			url : "getOrderTypeBalance.action",
			data : {
				'orderType': $('.orderType').val()
			},
			dataType : "json",
			success : function(data) {
				var msg = JSON.parse(data);
                $('.goodsprice').text(msg);
			},
			error : function() {
				alert("ERROR");
			}
		});
	}
}
function getBalance(){
	var price= parseFloat($('.goodsprice').text());
	if(parseInt($('.orderNumber').val())<=0){		
		alert("数量必须≥1");
		return;
	}
	var count=parseInt($('.orderNumber').val());
    $('.orderBalance').val(price*count);
}
</script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</html>
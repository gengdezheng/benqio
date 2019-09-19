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
<link href="css/Chart.min.css" rel="stylesheet" />
<script src="js/jquery.min.js"></script>
<script src="js/Chart.min.js"></script>
<body>
	<div class="left-body" style="position: fixed;">
		<div class="search">
			<div>企业客户管理系统</div>
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


	<div class="right-body" style="margin-left:20%;">
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
				<li><a href="#">首页</a></li>
				<li><a href="#">HOME</a></li>
			</ol>
			<div class="main-count">
				<div class="orderCount">
					<img src="imgs/order.png" style="margin-top: 5px;" /> <br>
					<h4>订单数</h4>
					<h2>${orderCount}</h2>
				</div>
				<div class="peopleCount">
					<img src="imgs/people.png" style="margin-top: 5px;" /> <br>
					<h4>客户人数</h4>
					<h2>${clientCount}</h2>
				</div>
				<div class="factoryCount">
					<img src="imgs/log.png" style="margin-top: 5px; width: 48px;" /> <br>
					<h4>日志数</h4>
					<h2>${logCount}</h2>
				</div>
			</div>

			<div class="bar"
				style="width: 42%; margin-top: 10px; margin-left: 15px; background: #FAFAFA; float: left;">
				<canvas id="myChart" width="200" height="200"></canvas>
			</div>
			<div
				style="width: 50%; margin-top: 10px; margin-left: 3%; float: left; text-align: center;height: 450px;">
				<table class="table">
					<tr>
						<td>登录日志</td>
					</tr>
					<tr>
						<td>
							<table class="table table-bordered table-striped">
								<tr>
									<td>登录名</td>
									<td>登录密码</td>
									<td>登录时间</td>
									<td>登录地址</td>
									<td>登录结果</td>
								</tr>
								<c:forEach items="${logList}" var="log">
									<tr>
										<td>${log.log_name}</td>
										<td>${log.log_pass}</td>
										<td>${log.log_time}</td>
										<td>${log.log_IP}</td>
										<td class="icon">
										<c:set var="status" 
												value="${log.log_status}" /> 
										   <c:if test="${status == 1}">		
                                               <span style="color:#00C5CD;"class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
											</c:if>
											  <c:if test="${status == 0}">		
                                               <span style="color:#8B3E2F;"class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
											</c:if>
								     </td>
								  </tr>
						
							</c:forEach>
							</table>
						</td>
					</tr>

				</table>
			</div>
			
			<div class="url-content" style="width:45%;float:left;">
			   <table class="table">
			     <tr style="text-align: center;">
			       <td>导航管理</td>
			     </tr>
			     <tr>
			       <td>
			         <table class="table table-hover table-striped">
			            <tr>
			             <td>
			              <input type="text" class="form-control menu_Name" placeholder="导航名">
			              </td>
			              <td>
			              <input type="text" class="form-control menu_Url" placeholder="路径">
			              </td>
			               <td>
			                <button class="btn addMenu">添加</button>
			              </td>
			            </tr>
			            <tr>
			              <td>导航名</td>
			               <td>URL</td>
			                <td></td>
			            </tr>
			           <c:forEach items="${menu}" var="menu">
			             <tr>
			                <td>
			                   ${menu.menu_Name}
			                </td>
			                  <td>
			                   ${menu.menu_Url}
			                </td>
			                <td>
			                  <a href="deleteUrl.action?menu_Id=${menu.menu_Id }" class="btn btn-link">删除</a>
			                </td>
			             </tr>
			           </c:forEach>
			         </table>
			       </td>
			     </tr>
			   </table>
			</div>
			
		</div>
		<div class="bar"
				style="width: 30%; margin-top: 10px; margin-left:15px;  float: left;margin:auto;">
				<canvas id="myChart02" width="50" height="50" style="margin-left:30%;"></canvas>
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
<script>
	var data = {
		labels : [ "上衣", "裤子", "棉布", "麻布", "染料", "其他" ],
		datasets : [ {
			label : "商品销量",
			fillColor : "rgba(220,220,220,0.6)",
			strokeColor : "rgba(220,220,220,0.8)",
			highlightFill : "rgba(220,220,220,0.75)",
			highlightStroke : "rgba(220,220,220,1)",
			data : [
                   <%=session.getAttribute("shangyiCount")%>, 
                   <%=session.getAttribute("kuziCount")%>,
                   <%=session.getAttribute("mianCount")%>, 
                   <%=session.getAttribute("maCount")%>, 
                   <%=session.getAttribute("ranCount")%>, 5 ]
		} ]
	};
	var ctx = document.getElementById("myChart").getContext("2d");
	var myBarChart = new Chart(ctx, {
		type : 'bar',
		data : data,
		responsive : true
	});
	
	
	   var ctx02 = document.getElementById("myChart02").getContext("2d");
	   var myBarChart= new Chart(ctx02, {
		type : 'pie',
		data : {
			  labels : ["上衣销售额","裤子销售额","棉布销售额","麻布销售额","染料销售额"],
		     datasets: [{
		      data: [<%=session.getAttribute("shangyi")%>, 
		    	  <%=session.getAttribute("kuzi")%>,
		    	  <%=session.getAttribute("mianbu")%>,
		    	  <%=session.getAttribute("mabu")%>,
		    	  <%=session.getAttribute("ranliao")%>],
		      backgroundColor: ['#debd5a', '#ff6d4a', '#3cc9bf', '#7599e9','#999']
		     }]
		}
	});

</script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</html>
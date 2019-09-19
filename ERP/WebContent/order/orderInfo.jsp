<%@ page import="com.erp.model.*,java.util.List" language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
					style="background: none;color:#fff;border:none;
	                     font-size: 20px;
	                      line-height: 4;">
					欢迎：<%=((Admin)session.getAttribute("admin")).getUserName() %> <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu"
					aria-labelledby="dropdownMenu1">
					<li role="presentation"><a role="menuitem" tabindex="-1"  data-toggle="modal" data-target="#myModal"
						href="#">个人资料</a></li>
					<li role="presentation"><a role="menuitem" tabindex="-1"
						href="over.action">退出</a></li>

				</ul>
			</div>
		</div>
		<div class="main-body">
			<ol class="breadcrumb">
				<li><a href="index.action">首页</a></li>
				<li><a href="orderList.action">订单列表</a></li>
				<li><a href="#">订单详情</a></li>
			</ol>

          <table class="table table-hover table-bordered" style="width:70%;text-align: center;margin: auto;">
              <tr>
                 <td><strong>单号</strong></td>
                 <td>${orderInfo.id}</td>
              </tr>
               <tr>
                 <td><strong>下单时间</strong></td>
                 <td>${orderInfo.orderTime}</td>
              </tr> 
               <tr>
                 <td><strong>订单类型</strong></td>
                 <td>${orderInfo.orderType}</td>
              </tr>  
               <tr>
                 <td><strong>订单数量</strong></td>
                 <td>${orderInfo.orderNumber}</td>
              </tr>  
              <tr>
                 <td><strong>客户ID</strong></td>
                 <td>${orderInfo.clientId}</td>
              </tr>  
              <tr>
                 <td><strong>客户姓名</strong></td>
                 <td>${orderInfo.client.name}</td>
              </tr> 
              <tr>
                 <td><strong>联系方式</strong></td>
                 <td>${orderInfo.client.phone}</td>
              </tr> 
               <tr>
                 <td><strong>地址</strong></td>
                 <td>${orderInfo.client.address}</td>
              </tr>     
               <tr>
                 <td><strong>总金额</strong></td>
                 <td>${orderInfo.orderBalance}</td>
              </tr>   
          </table>
          <div  style="text-align: center;margin-top: 15px;">
          <a href="orderList.action" class="btn btn-primary"> 
            <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                               &nbsp; 返   回</a>
          </div>
		</div>
	</div>
	
</body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</html>
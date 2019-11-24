<%@ page import="com.java.news.model.User" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
</head>
<body>



<!-- 头部导航栏  -->
<nav class="navbar navbar-default" style="">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/index">新闻</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/index">首页 <span class="sr-only">(current)</span></a></li>
                <li><a href="/article/lookToday">今日</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">分类 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">军事</a></li>
                        <li><a href="#">生活</a></li>
                        <li><a href="#">科技</a></li>
                        <li><a href="#">其他</a></li>
                    </ul>
                </li>
            </ul>
            <div class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text"  class="form-control keyword" placeholder="关键字">
                </div>
                <button  class="btn btn-default searchByKey">查询</button>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="">后台管理</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">我的 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li class="checkLogin"><a>个人信息</a></li>
                        <li class="checkLogin"><a>历史</a></li>
                        <li class="checkLogin"><a>审核状态</a></li>
                        <li class="divider"></li>
                        <li class="checkLogin"><a href="#">退出</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


<div class="new_body">

    <!-- left -->
    <div class="new_body_left">

        <ul class="nav nav-pills nav-stacked">
            <li role="presentation" class="active"><a href="#">全部</a></li>
            <li role="presentation"><a href="#">科技</a></li>
            <li role="presentation"><a href="#">军事</a></li>
            <li role="presentation"><a href="#">生活</a></li>
            <li role="presentation"><a href="#">娱乐</a></li>
        </ul>
        <hr/>
        <ul class="nav nav-pills nav-stacked">
            <li role="presentation" class="active"><a href="#">我的</a></li>
            <li role="presentation" class="checkLogin"><a href="#">发布</a></li>
            <li role="presentation" class="checkLogin"><a href="#">历史</a></li>
            <li role="presentation" class="checkLogin"><a href="#">个人信息</a></li>
        </ul>
    </div>

    <!-- center -->
    <div class="new_body_center">
        <ol class="breadcrumb">
            <li><a href="/index">首页</a></li>
            <li class="active">个人信息</li>
        </ol>
        <%
            User userInfo = (User) session.getAttribute("user");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        %>
        <div class="panel panel-default article-body">
            <div class="panel-body">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">头像</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">
                                <img src="../img/headImg/<%=userInfo.getHeadImg()%>" width="80" height="80" class="img-rounded">
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">编号</label>
                        <div class="col-sm-10">
                            <p class="form-control-static userId"><%=userInfo.getUserId()%></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control userName" id="inputPassword3" placeholder="用户名" value="<%=userInfo.getUserName()%>">
                        </div>
                    </div>
                    <div class="form-group" style="visibility: hidden;">
                        <label for="inputPassword3" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control getpass" id="inputPassword" placeholder="用户名" value="<%=userInfo.getPassword()%>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">联系方式</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control userPhone"  placeholder="联系方式" value="<%=userInfo.getPhoneNumber()%>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">出生日期</label>
                        <div class="col-sm-10">
                            <input type="date" class="form-control userBirth" value="<%=userInfo.getBirthday()%>"  placeholder="出生日期">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">注册时间</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">
                            <%=simpleDateFormat.format(userInfo.getRegistTime())%>
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">最后修改</label>
                        <div class="col-sm-10">
                            <p class="form-control-static">
                                    <%=simpleDateFormat.format(userInfo.getUpdateTime())%>
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button  class="btn btn-info saveInfo">保存信息</button>
                            <button  class="btn btn-warning up_pw">修改密码</button>
                        </div>
                    </div>


                    <div class="form-group pw">
                        <label for="inputPassword3" class="col-sm-2 control-label">原密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control oldpass"  placeholder="原密码">
                        </div>
                    </div>

                    <div class="form-group pw">
                        <label for="inputPassword3" class="col-sm-2 control-label ">新密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control userPass"  placeholder="确认密码">
                        </div>
                    </div>
                    <div class="form-group pw">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button  class="btn btn-info saveInfoAll">修改</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

    <!-- right -->
    <div class="new_body_right">
        <% User user = (User) session.getAttribute("user");
            if(user!=null){
        %>
        <div class="login_success">
            <div class="new_body_right_img">
                <img src="../img/<%=user.getHeadImg()%>" class="img-rounded" width="80" height="80">
            </div>

            <table class="table info" style="width: 70%;margin:auto;margin-top:20px;text-align: center;">
                <tr>
                    <td><span class="glyphicon glyphicon-user" aria-hidden="true"></span></td>
                    <td><%=user.getUserName()%>
                    </td>
                </tr>
                <tr>
                    <td><span class="glyphicon glyphicon-phone" aria-hidden="true"></span></td>
                    <td><%=user.getPhoneNumber()%>
                    </td>
                </tr>
                <tr>
                    <td><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></td>
                    <td><%=simpleDateFormat.format(user.getRegistTime())%>
                    </td>
                </tr>
                <tr>
                    <td><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></td>
                    <td>已发布${allNumber}条
                    </td>
                </tr>
                <tr>
                    <td><span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span></td>
                    <td>${unPass}条待审核
                    </td>
                </tr>
            </table>
        </div>
        <%
        }
        else{
        %>
        <div class="unlogin">
            <span>你尚未登录，请先<a href="/user/login" >登录</a>！<i>&nbsp;<a href="#" onclick="redist()" data-toggle="modal" data-target="#myModal">点击注册</a></i></span>
        </div>
        <%
            }
        %>
    </div>

</div>




<div class="alert alert-danger goLogin" role="alert" style="width: 100%;
      height: 150px;
	text-align: center;
	position: absolute;
	z-index: 1001;
	top: 0;
display: none;">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span></button>
    你尚未登录，请先<a href="/user/login" class="alert-link">登录。</a>
</div>


<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/json.js"></script>
</body>
</html>

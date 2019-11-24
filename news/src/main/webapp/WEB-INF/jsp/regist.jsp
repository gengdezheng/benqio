
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">分类
                        <span class="caret"></span></a>
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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">我的
                        <span class="caret"></span></a>
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
            <li role="presentation" class="active"><a href="#">分类</a></li>
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
            <li class="active">用户注册</li>
        </ol>

                <h3 class="form-signin-heading">用户注册</h3>
                <div class="panel panel-default article-body">
                    <div class="panel-body">
                        <div class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">用户名</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control r_userName" placeholder="用户名" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">密码</label>
                                <div class="col-sm-10">
                                    <input type="password" class="form-control r_password" placeholder="密码" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">联系方式</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control r_phone" placeholder="联系方式" required>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">出生日期</label>
                                <div class="col-sm-10">
                                    <input type="date" class="form-control r_birthday" placeholder="出生日期" required>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">头像</label>
                                <div class="col-xs-12 col-sm-4 col-md-4">
                                    <input id="head_file" name="file" class="btn btn-default" type="file"  style="">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit"  class="btn btn-primary regist_commit" >注 册</button>
                                    <button  class="btn btn-success canael" >取 消</button>
                                </div>
                            </div>

                        </div>

                        <div class="r_success" style="width: 100%;display:none;text-align: center;margin-top: 15px;">
                            <img src="../img/success.png" style="width: 40px;">
                            <small>注册成功！&nbsp;<a href="/user/login">立即登录</a></small>
                        </div>
                    </div>
        </div>
    </div>

</div>



<div class="alert alert-danger goLogin" role="alert" style="width: 100%;
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

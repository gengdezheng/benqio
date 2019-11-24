<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>用户登录</title>
</head>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
<style>
    .container{
        width:30%;
        margin: auto;

    }
    button,input,alert{
        margin-top:15px;
    }
</style>
<body>

<div class="container">

        <h2 class="form-signin-heading">请登录</h2>
        <label for="inputEmail" class="sr-only">用户名：</label>
        <input type="text" id="inputEmail" class="form-control login_userName" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only ">密码</label>
        <input type="password" id="inputPassword" class="form-control login_password" placeholder="密码" required>

        <button class="btn btn-lg btn-primary btn-block btn_login" >登 录</button>
        <button type="button" class="btn btn-link btn-block btn-lg">点我注册！</button>


    <div class="alert alert-danger alert-dismissible" role="alert" style="display: none;">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <strong>Warning!</strong> 用户名或密码错误.
    </div>
</div>

<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/json.js"></script>
</body>
</html>

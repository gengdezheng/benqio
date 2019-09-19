<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<style>
body{
  background-image: url("imgs/bg.jfif");
  background-size: cover;
}
 .container{
   width:30%;
   background: rgba(255,255,255,0.7);
   height: 400px;
   margin-top:100px;
 }
 .msg{
   color:red;
   text-align: center;
   margin-top: 15px;
 }
</style>
<body>
   <div class="container" >

      <form class="form-signin" action="login.action" method="post">
        <h3 class="form-signin-heading">请登录</h3>
        <label for="inputEmail" class="sr-only">用户名</label>
        <input type="text" id="inputEmail" name="userName" class="form-control" placeholder="username" required autofocus>
        <br>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password"  name="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <br>
        <input class="btn btn-lg btn-primary btn-block" type="submit" value="登 录"/>
      </form>
     <div class="msg"> ${msg}</div>
    </div> 
        <script>
        //防止页面后退
        history.pushState(null, null, document.URL);
        window.addEventListener('popstate', function () {
            history.pushState(null, null, document.URL);
        });
    </script>
</body>
</html>
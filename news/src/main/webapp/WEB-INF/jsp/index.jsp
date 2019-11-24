<%@ page import="com.java.news.model.User" %>
<%@ page import="com.java.news.model.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.github.pagehelper.PageInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
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
                <li><a href="../G:/desktop/news_admin/loginPage/index.html">后台管理</a></li>
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
            <li class="active">全部新闻</li>
        </ol>
        <%
            PageInfo<Article> articleList = (PageInfo<Article>) session.getAttribute("articles");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            if (articleList.getList() != null || articleList.getList().size() > 0) {
                for (Article a : articleList.getList()) {

        %>
        <div class="article-body">
            <div class="panel-body" style="color:#666;">
                <div class="article-title">
                       <img src="../img/headImg/<%=a.getUser().getHeadImg()%>" class="img-circle" width="40" height="40">
                       &nbsp;<small><%=a.getUser().getUserName()%></small>
                </div>
                <div class="article-time">
                    <span class="glyphicon glyphicon-time" aria-hidden="true"></span>
                    &nbsp;<%=simpleDateFormat.format(a.getTime())%><br>
                    <span class="glyphicon glyphicon-tags" aria-hidden="true"></span>
                    &nbsp;<%=a.getClassify().getName()%><br>
                </div>
            </div>
            <div class="article-content">
                <h4><%=a.getTitle()%></h4>
                <a href="/article/look?articleId=<%=a.getArticleId()%>">
                    <%=a.getContent()%>
                </a>
            </div>
            <div class="article-img">
                <%
                        String imgs[] = a.getImgs().split("::");
                        for (String img : imgs) {
                            if(!img.equals(""))
                            out.print("<img src='../img/"+img+"' class='img-rounded' style='width:220px;height:200px;margin-left:5px;'>");
                        }
                %>
            </div>
        </div>
        <%
                    out.print("<hr>");
                }


            }
        %>

       <div class="pageH" style="width: 100%;height: 50px;text-align: center;">
           <%
              if(!articleList.isIsFirstPage()){
                  out.print("<a href='/index?pageNum="+(articleList.getPageNum()-1)+"' style='margin-right:20px;border-radius:0px;' class='btn btn-primary'>上一页</a>");
               }
              else {
                  out.print("<a href='' class='btn disabled' style='margin-right:20px;border-radius:0px;'>上一页</a>");
              }
              if(!articleList.isIsLastPage()){
                  out.print("<a href='/index?pageNum="+(articleList.getPageNum()+1)+"' style='margin-left:20px;border-radius:0px;' class='btn btn-primary'>下一页</a>");
              }
              else{
                  out.print("<a href='' class='btn disabled' style='margin-left:20px;border-radius:0px;'>下一页</a>");
              }
           %>
           <select style="width: 100px;height: 34px;margin-left:20px;" class="getPage">
               <% int i = articleList.getPages();
                  for(int s=1;s<=i;s++){
                      out.print("<option>"+s+"</option>");
                  }
               %>
           </select>
           <button class="btn btn-primary jump" style="border-radius:0px;">跳转</button>
       </div>

    </div>

    <!-- right -->
    <div class="new_body_right">
        <% User user = (User) session.getAttribute("user");
            if (user != null) {
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
        } else {
        %>
        <div class="unlogin">
            <span>你尚未登录，请先<a href="/user/login">登录</a>！<i>&nbsp;<a href="/user/goRegist">点击注册</a></i></span>
        </div>
        <%
            }
        %>
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
<script>
    $(".jump").click(function(){
        var page = $(".getPage").val();
        window.location.href="/index?pageNum="+page;
    });
</script>

<script src="../js/json.js"></script>
</body>
</html>

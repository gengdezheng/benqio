window.history.forward(-1);
$('.pageClick').click(function(){
	            var text = $(this).text();
	            switch(text){
	            	case "首页" :  window.location.href="file:///G:/desktop/news_admin/page/index.html";break;
	            	case "用户管理" :  window.location.href="file:///G:/desktop/news_admin/page/user.html";break;
	            	case "新闻管理" :  window.location.href="file:///G:/desktop/news_admin/page/article.html";break;
	            	case "登录日志" :  window.location.href="file:///G:/desktop/news_admin/page/login_record.html";break;
	            	case "操作日志" :  window.location.href="file:///G:/desktop/news_admin/page/log_record.html";break;
	            	case "系统接口" :  window.location.href="file:///G:/desktop/news_admin/page/api.html";break;
	            	case "新建管理员" :  window.location.href="file:///G:/desktop/news_admin/page/adminRegist.html";break;
	            }
             });

$('.tuichu').click(function(){
	window.location.href="../loginPage/index.html";
});
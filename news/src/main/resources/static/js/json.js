//用户登录
var path = "http://127.0.0.1:8080";
$(".btn_login").click(function () {
    var user_data = {
        'userName': $('.login_userName').val(),
        'password': $('.login_password').val()
    };
    $.ajax({
        type: "post",
        url: "/login/userLogin",
        data: user_data,
        dataType: "json",
        success: function (data) {
            if (data === 1) {
                $(".alert-dismissible").slideDown();
            }
            else {
                window.location.href = "/index";
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status + "," + XMLHttpRequest.readyState + "," + textStatus);
        }
    });
});

//是否登录
$(".checkLogin").click(function () {
    var title = $(this).text();
    $.ajax({
        type: "post",
        url: "/user/islogin",
        dataType: "json",
        success: function (data) {
            if (data === '1') {
                switch (title) {
                    case "发布":
                        window.location.href = "/article/goArticlePage";
                        break;
                    case "历史":
                        window.location.href = "/article/histry";
                        break;
                    case "个人信息":
                        window.location.href = "/user/goUserInfo";
                        break;
                    case "审核状态":
                        window.location.href = "/article/goUnPass";
                        break;
                    case "退出":
                        window.location.href = "/user/logout";
                        break;
                }
            }
            else {
                $(".goLogin").slideDown();
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status + "," + XMLHttpRequest.readyState + "," + textStatus);
        }
    });
});

$(".up_pw").click(function () {
    $(".pw").slideToggle();
});

//修改信息
function updateInfo() {

    var getpass = $('.getpass').val();
    var oldpass =$(".oldpass").val();
    if(oldpass!=getpass){
        alert("密码错误！");
        return;
    }
    var data_user = {
        'userId': $(".userId").text(),
        'userName': $(".userName").val(),
        'password': $(".userPass").val(),
        'phoneNumber': $(".userPhone").val(),
        'birthday': $(".userBirth").val(),
    };
    $.ajax({
        type: "post",
        url: "/user/updateInfo",
        data: data_user,
        dataType: "json",
        success: function (data) {
            alert(data);

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status + "," + XMLHttpRequest.readyState + "," + textStatus);
        }
    });
}

$(".saveInfo").click(function () {
    updateInfo();
});
$(".saveInfoAll").click(function () {
    updateInfo();
});

/**
 * 新闻/文件上传
 */
var length;//图片个数
var classId = 1;//分类Id
$("#file").change(function () {
    length = this.files.length;
});
$(".a_classify").bind("change", function () {

    classId = $(this).find("option:selected").attr("ids");
});

function push() {
    var formData = new FormData();
    var i = 0;
    for (var i = 0; i < length; i++) {
        formData.append('file', $('#file')[0].files[i]);
    }
    formData.append("title", $('.a_title').val());
    formData.append("content", $(".a_content").val());
    formData.append("classId", classId);
    $.ajax({
        url: '/article/insertArticle',
        type: 'POST',
        dataType: "json",
        data: formData,
        cache: false,//上传文件无需缓存
        processData: false, // 不处理数据
        contentType: false, // 不设置内容类型
        success: function (data) {
            alert(data);
        },
        error: function (res) {
            alert("失败");
        }
    });
}

$(".searchByKey").click(function(){
    if($(".keyword").val()==='')
        alert("输入关键词");
    else {
        window.location.href = "/article/searchByKey?key=" + $(".keyword").val();
    }

});

$(".canael").click(function(){
    window.location.href="/index";
});

//注册用户
$(".regist_commit").click(function () {
    var formData = new FormData();
    formData.append('headfile', $('#head_file')[0].files[0]);
    formData.append('userName', $(".r_userName").val());
    formData.append('password', $(".r_password").val());
    formData.append('phoneNumber', $(".r_phone").val());
    formData.append('birthday', $(".r_birthday").val());
    $.ajax({
        url: '/user/insertUser',
        type: 'POST',
        dataType: "json",
        data: formData,
        cache: false,//上传文件无需缓存
        processData: false, // 不处理数据
        contentType: false, // 不设置内容类型
        success: function (data) {
            $(".r_success").slideDown();
        },
        error: function (res) {
            alert("失败");
        }
    });
});
              var path = "http://127.0.0.1:8080";
              var pages; //页数
              var pageNum;
              var nextpage; //下一页数
              var hasNextPage;//是否有下一页
              var isFirstPage;//是否首页
                //日期处理
                function getDate(param){
                  var getTime = new Date(param);
                  var time = getTime.getFullYear()+"-"
                  +(getTime.getMonth() + 1)+"-"
                  +getTime.getDate()+" "
                  +getTime.getHours()+":"
                  +getTime.getMinutes()+":"+getTime.getSeconds();
                  return time;
                }
                function reload(URL){
                 $.ajax({
                  type: "get",
                  url: URL,
                  success:function(data){
                     $('.pageCount').text("共"+data.pages+"页");
                  $('.nowPage').text("当前第"+data.pageNum+"页");
                    pages = data.pages;
                    pageNum=data.pageNum;
                    nextpage = data.nextPage;
                    hasNextPage = data.hasNextPage;
                    isFirstPage=data.isFirstPage;
                    $("tbody").remove();
                    var msg = JSON.stringify(data.list);
                    var result = JSON.parse(msg);                          
                    for(var i=0;i<result.length;i++){
                      var log; var role;
                      if(result[i].loginState===0){
                       log="<span class='glyphicon glyphicon-ok-circle' style='color:rgb(82, 156, 82)' aria-hidden='true'></span>";
                     }
                     else{
                      log="<span class='glyphicon glyphicon-remove-circle' style='color:rgb(215, 80, 76)' aria-hidden='true'></span>";
                    }
                    if(result[i].role===1){
                       role="普通用户";
                    }
                    else{
                      role="管理员";
                    }
                    $(".table").append("<tbody><tr><td>"+result[i].id+"</td><td>"+result[i].loginName+"</td><td>"
                      +result[i].loginIP+"</td><td>"
                      +role+"</td><td>"
                      +log+"</td><td style='color:rgb(201, 48, 44);'>"
                      +result[i].reason+"</td><td>"
                      +getDate(result[i].time)+"</td><td><button  class='btn btn-danger l_del'  l_id='"+result[i].id+"'>删除</button></td></tr></tbody>"
                      );
                  }
                },
                error:function(){
                  alert("服务器异常");
                }
              });
               }        
               reload(path+"/admin/loginlist?pageNum=1");

            var loginState = -1; var loginRole = -1;
            $(".login_state").bind("change", function () {
               loginState = $(this).find("option:selected").attr("state");
             });
            $(".login_role").bind("change", function () {
               loginRole = $(this).find("option:selected").attr("state");
             });
             $(".search").click(function(){
              string = "pageNum=1&state="+loginState+"&role="+loginRole+"&loginName="+$('.login_name').val();     
              reload(path+"/admin/loginlist?"+string);
            });

            


            $('.del_all').click(function(){
                 $.ajax({
                      type: "get",
                      url: path+"/admin/clearLoginInfo",
                      success:function(data){
                        alert(data);
                        reload();
                      },
                      error:function(){
                        alert("服务器异常");
                      }
                      });
            });
                

            $(document).on('click','.l_del',function(){
                 var id = $(this).attr("l_id");
                 $.ajax({
                  type:"get",
                  url:path+"/admin/deleteLoginInfoById?getId="+id,
                  success:function(data){alert(data);reload(path+"/admin/loginlist?pageNum=1");},
                  error:function(){
                     alert("服务器异常");
                  }
                 });
            });

             //上一页
           $('.uppage').click(function(){
                if(!isFirstPage){
                pageNum = pageNum-1;
                reload(path+"/admin/loginlist?pageNum="+pageNum);
                }
           });
            //下一页
            $('.nextpage').click(function(){
              if(hasNextPage)
                reload(path+"/admin/loginlist?pageNum="+nextpage);
              else
                alert("已是最后一页");
            });
            //首页
            $('.firstpage').click(function(){
              reload(path+"/admin/loginlist?pageNum=1");
            });
            //尾页
            $('.lastpage').click(function(){
               reload(path+"/admin/loginlist?pageNum="+pages);
            });
           
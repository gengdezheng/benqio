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
                  +getTime.getMinutes();
                  return time;
                }
                function reload(URL){
                 $.ajax({
                  type: "get",
                  url: URL,
                  success:function(data){
                     $('.pageCount').text("共"+data.pages+"页");
                  $('.nowPage').text("当前第"+data.pageNum+"页");
                  pageNum =data.pageNum;
                    pages = data.pages;
                    nextpage = data.nextPage;
                    hasNextPage = data.hasNextPage;
                    isFirstPage=data.isFirstPage;
                    $("tbody").remove();
                    var msg = JSON.stringify(data.list);
                    var result = JSON.parse(msg);                          
                    for(var i=0;i<result.length;i++){
                      var log;
                      if(result[i].state===1){
                       log="<span class='glyphicon glyphicon-ok-circle' style='color:rgb(73, 160, 73)' aria-hidden='true'></span>";
                     }
                     else{
                      log="<span class='glyphicon glyphicon-question-sign' style='color:rgb(215, 80, 76)' aria-hidden='true'></span>";
                    }
                    $(".table").append("<tbody><tr><td><input class='boxdelete' type='checkbox' value='"+result[i].articleId+"'></td><td style='text-overflow :ellipsis; white-space :nowrap;overflow : hidden;'>"+result[i].articleId+"</td><td>"
                      +result[i].title+"</td><td style='text-overflow :ellipsis; white-space :nowrap;overflow : hidden;'>"
                      +result[i].content+"</td><td>"
                      +result[i].classify.name+"</td><td>"
                      +getDate(result[i].time)+"</td><td>"
                      +result[i].user.userName+"</td><td>"
                      +log+"</td><td><button  class='btn btn-success lookArticle'  articleid='"+result[i].articleId+"'>查看</button></td></tr></tbody>"
                      );
                  }
                },
                error:function(){
                  alert("服务器异常");
                }
              });
               }        
               reload(path+"/admin/articlelist?pageNum=1");


             //批量删除(删除)

             $('.more_del_a').click(function(){

               var ids="";
               $('.boxdelete:checked').each(function(){
                 ids+=$(this).val()+",";
               });
               if(ids===''){
                alert("至少选择一项");
              }
              else{
               $.ajax({
                type: "get",
                url: path+"/admin/batchDeleteArticle?articleIds="+ids,
                dataType:'json',
                success:function(data){
                 alert(data+"条数据被删除");
                 reload(path+"/admin/articlelist?pageNum=1");
               },
               error:function(){
                alert("服务器异常");
              }
            });
             }
           });

              //查看新闻
             $(document).on('click','.cancel',function(){$(".mask").hide();});
             var a_id;
             $(document).on("click",
               '.lookArticle', 
               function(){
                 var id = $(this).attr('articleid');   
                 a_id = id;                            
                 $.ajax({
                  type: "get",
                  url: path+"/admin/lookArticle?articleId="+id,
                  success:function(data){
                   var msg = JSON.stringify(data);
                   var result = JSON.parse(msg); 

                   $('.mask_img img').remove(); 
                   $('.mask_img br').remove(); 
                   $('.buts button').remove(); 
                   $('.buts img').remove(); 
                   $('.mask_title').text(result.title);
                   $('.mask_content').text(result.content);

                   if(result.state===1){
                     $('.buts').append("<button type='button' class='btn btn-warning save_pass'>保存</button> <button type='button' class='btn btn-danger del_a'>删 &nbsp;&nbsp;  除</button><img src='../img/cancel.png' style='margin-left:60%;'' width='15' class='cancel'>");
                   }
                   else
                   {
                    $('.buts').append("<button type='button' class='btn btn-success a_pass'>审核通过</button> <button type='button' class='btn btn-warning save_pass'>保存/通过</button> <button type='button' class='btn btn-danger del_a'>删 &nbsp;&nbsp;  除</button><img src='../img/cancel.png' style='margin-left:60%;'' width='15' class='cancel'>");
                  }
                  var imgs = result.imgs.split("::");
                  for(var i=0;i<imgs.length-1;i++){
                    $('.mask_img').append("<img src='E:/IntelliJSpace/news/src/main/resources/static/img/"+imgs[i]+"' width='200' hight='200'><br><br>");
                  }

                  $(".mask").show();
                },
                error:function(){
                  alert("服务器异常");
                }
              });
               }
               );
             
             //审核通过
             $(document).on('click','.a_pass',function(){
               $.ajax({
                type: "get",
                url: path+"/admin/setPass?articleId="+a_id,
                success:function(data){
                  alert(data);
                  $(".mask").hide();
                  reload(path+"/admin/articlelist?pageNum=1");
                },
                error:function(){alert("系统异常");}
              });
             });

              //修改（通过审核）新闻
             $(document).on('click','.save_pass',function(){
               var string = "articleId="+a_id+"&title="+$('.mask_title').text()+"&content="+$('.mask_content').text();
       
               $.ajax({
                type: "get",
                url: path+"/admin/updateArticle?"+string,
                success:function(data){
                  alert(data+"条被修改");
                  $(".mask").hide();
                  reload(path+"/admin/articlelist?pageNum=1");
                },
                error:function(){alert("系统异常");}
              });
             });
             //删除
              $(document).on('click','.del_a',function(){
               $.ajax({
                type: "get",
                url: path+"/admin/batchDeleteArticle?articleIds="+a_id+",",
                success:function(data){
                  alert(data+"条被删除");
                  $(".mask").hide();
                   reload(path+"/admin/articlelist?pageNum=1");
                },
                error:function(){alert("系统异常");}
              });
             });

             //条件查询
             var state = -1;
             $(".a_state").bind("change", function () {
               state = $(this).find("option:selected").attr("state");
             });
             $(".search").click(function(){
              string = "pageNum=1&state="+state+"&title="+$('.a_title').val()+"&userName="+$('.a_user').val(); 
              reload(path+"/admin/articlelist?"+string);
             /* alert(string);     
              $.ajax({
                type: "get",
                url: path+"/admin/articlelist?"+string,
                success:function(data){
                  $("tbody").remove();
                    var msg = JSON.stringify(data);
                    var result = JSON.parse(msg);                          
                    for(var i=0;i<result.length;i++){
                      var log;
                      if(result[i].state===1){
                       log="<span class='glyphicon glyphicon-ok-circle' style='color:rgb(73, 160, 73)' aria-hidden='true'></span>";
                     }
                     else{
                      log="<span class='glyphicon glyphicon-question-sign' style='color:rgb(215, 80, 76)' aria-hidden='true'></span>";
                    }
                    $(".table").append("<tbody><tr><td><input class='boxdelete' type='checkbox' value='"+result[i].articleId+"'></td><td style='text-overflow :ellipsis; white-space :nowrap;overflow : hidden;'>"+result[i].articleId+"</td><td>"
                      +result[i].title+"</td><td style='text-overflow :ellipsis; white-space :nowrap;overflow : hidden;'>"
                      +result[i].content+"</td><td>"
                      +result[i].classify.name+"</td><td>"
                      +getDate(result[i].time)+"</td><td>"
                      +result[i].user.userName+"</td><td>"
                      +log+"</td><td><button  class='btn btn-success lookArticle'  articleid='"+result[i].articleId+"'>查看</button></td></tr></tbody>"
                      );
                  }
                },
                error:function(){
                  alert("服务器异常");
                }
              });*/
            });


 $('.uppage').click(function(){
                if(!isFirstPage){
                pageNum = pageNum-1;
                reload(path+"/admin/articlelist?pageNum="+pageNum);
                }
           });

            $('.nextpage').click(function(){
              if(hasNextPage)
                reload(path+"/admin/articlelist?pageNum="+nextpage);
              else
                alert("已是最后一页");
            });

             //首页
            $('.firstpage').click(function(){
              reload(path+"/admin/articlelist?pageNum=1");
            });
            //尾页
            $('.lastpage').click(function(){
               reload(path+"/admin/articlelist?pageNum="+pages);
            });
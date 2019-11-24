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
                   pageNum = data.pageNum;
                    pages = data.pages;
                    nextpage = data.nextPage;
                    hasNextPage = data.hasNextPage;
                    isFirstPage=data.isFirstPage;
                    $("tbody").remove();
                    var msg = JSON.stringify(data.list);
                    var result = JSON.parse(msg);                          
                    for(var i=0;i<result.length;i++){
            
                    $(".table").append("<tbody><tr><td style='text-overflow :ellipsis; white-space :nowrap;overflow : hidden;'>"+result[i].logId+"</td><td>"+result[i].descr+"</td><td style='text-overflow :ellipsis; white-space :nowrap;overflow : hidden;'>"
                      +result[i].logUrl+"</td><td style='text-overflow :ellipsis; white-space :nowrap;overflow : hidden;'>"
                      +result[i].logParam+"</td><td style='color:rgb(201, 48, 44);text-overflow :ellipsis; white-space :nowrap;overflow : hidden;'>"
                      +result[i].logClassName+"</td><td>"
                      +getDate(result[i].logTime)+"</td><td>"+result[i].userName+"</td><td><button  class='btn btn-danger l_del'  l_id='"+result[i].logId+"'>删除</button>&nbsp;<button  class='btn  btn-success l_det'  l_id='"+result[i].logId+"'>详情</button></td></tr></tbody>"
                      );
                  }
                },
                error:function(){
                  alert("服务器异常");
                }
              });
               }        
               reload(path+"/admin/loglist?pageNum=1");



               $(".search").click(function(){
                reload(path+"/admin/loglist?pageNum=1&logId="+$('.logId').val());                 
               });

              $(document).on('click','.l_del',function(){
                var id = $(this).attr("l_id");
                $.ajax({
                      type:"get",
                      url:path+"/admin/deleteLogInfoById?logId="+id,
                      success:function(data){
                        alert(data);
                        reload(path+"/admin/loglist?pageNum=1");
                      },
                      error:function(){
                        alert("服务器异常");
                      }
                });
              });

              $(".del_all").click(function(){
                $.ajax({
                      type:"get",
                      url:path+"/admin/clearLog",
                      success:function(data){
                        alert(data);
                        reload(path+"/admin/loglist?pageNum=1");
                      },
                      error:function(){
                        alert("服务器异常");
                      }
                });
              });

                 //上一页
           $('.uppage').click(function(){
                if(!isFirstPage){
                pageNum = pageNum-1;
                reload(path+"/admin/loglist?pageNum="+pageNum);
                }
           });
            //下一页
            $('.nextpage').click(function(){
              if(hasNextPage)
                reload(path+"/admin/loglist?pageNum="+nextpage);
              else
                alert("已是最后一页");
            });
            //首页
            $('.firstpage').click(function(){
              reload(path+"/admin/loglist?pageNum=1");
            });
            //尾页
            $('.lastpage').click(function(){
               reload(path+"/admin/loglist?pageNum="+pages);
            });
           


$(".m_close").click(function(){
  $(".log_mask").fadeOut();
});
$(document).on('click','.l_det',function(){

   var id =$(this).attr("l_id");
            $.ajax({
                      type:"get",
                      url:path+"/admin/logdetail?id="+id,
                      success:function(data){
                        
                       $(".log_id").text(data.logId);
                        $(".log_descr").text(data.descr);
                        $(".log_url").text(data.logUrl);
                        $(".log_param").text(data.logParam);
                         $(".log_className").text(data.logClassName);
                         $(".log_user").text(data.userName);
                       $(".log_mask").fadeIn();
                      },
                      error:function(){
                        alert("服务器异常");
                      }
                });
});
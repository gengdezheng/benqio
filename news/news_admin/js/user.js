              var path = "http://127.0.0.1:8080";
              var pages; //页数
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
                  +getTime.getMinutes()+":"
                  +getTime.getSeconds();
                  return time;
               }

               //加载用户列表

               function reload(URL){
               $.ajax({
                type: "get",
                url: URL,
                success:function(data){
                  $('.pageCount').text("共"+data.pages+"页");
                  $('.nowPage').text("当前第"+data.pageNum+"页");
                    pages = data.pages;
                    nextpage = data.nextPage;
                    hasNextPage = data.hasNextPage;
                    isFirstPage=data.isFirstPage;
                  $("tbody tr").remove();
                  var msg = JSON.stringify(data.list);
                 
                  var result = JSON.parse(msg);
                  for(var i=0;i<result.length;i++){
                    
                        $(".table tbody").append("<tr><td><input class='boxdelete' type='checkbox' value='"+result[i].userId+"'></td><td><img class='himg' src='E:/IntelliJSpace/news/src/main/resources/static/img/headImg/"+result[i].headImg+"'></td><td>"
                          +result[i].userId+"</td><td>"
                          +result[i].userName+"</td><td>"
                            +result[i].phoneNumber+"</td><td>"
                             +getDate(result[i].registTime)+"</td><td>"
                             +getDate(result[i].updateTime)+"</td><td><span  class='glyphicon glyphicon-trash del_u' aria-hidden='true' userid='"+result[i].userId+"'></span></td></tr>"
                             );
                  }
                },
                error:function(){
                    alert("服务器异常");
                }
               });
                }        
             reload(path+"/admin/userlist?pageNum=1");

           //上一页
           $('.uppage').click(function(){
                if(!isFirstPage){
                nextpage = nextpage+1;
                reload(path+"/admin/userlist?pageNum="+nextpage);
                }
           });
            //下一页
            $('.nextpage').click(function(){
              if(hasNextPage)
                reload(path+"/admin/userlist?pageNum="+nextpage);
              else
                alert("已是最后一页");
            });
            //首页
            $('.firstpage').click(function(){
              reload(path+"/admin/userlist?pageNum=1");
            });
            //尾页
            $('.lastpage').click(function(){
               reload(path+"/admin/userlist?pageNum="+pages);
            });

             //条件查找

              $(".search").click(function(){
                var string ;
                string = "pageNum=1&userId="+$('.u_id').val()+"&userName="+$('.u_name').val()+"&phoneNumber="+$('.u_phone').val();   
                 reload(path+"/admin/userlist?"+string);
              });

             //批量删除（删除）

              $(document).on("click",
                             '.del_u', 
                              function(){
                             var id = $(this).attr('userid');

                              $.ajax({
                                  type: "get",
                                  url: path+"/admin/batchDelete?ids="+id,
                                  success:function(data){
                                     alert(data+"条数据被删除");
                                     reload(path+"/admin/userlist?pageNum=1");
                                  },
                                  error:function(){
                                    alert("服务器异常");
                                  }
                             });
                            }
                             );

            $('.more_del_u').click(function(){

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
                      url: path+"/admin/batchDelete?ids="+ids,
                      data: ids,
                      dataType:'json',
                      success:function(data){
                         alert(data+"条数据被删除");
                         reload(path+"/admin/userlist?pageNum=1");
                      },
                      error:function(){
                        alert("服务器异常");
                      }
                    });
              }
            });
            
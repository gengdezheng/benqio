              var path = "http://127.0.0.1:8080";
              var classifyArray = new Array();
              var classifyCount=new Array(100,50,200,150,300);
                
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


               function reload(){
               $.ajax({
                type: "get",
                url: path+"/admin/index",
                success:function(data){
                  $("tbody tr").remove();
                  
                   $('.userCount').text(data.userCount);
                   $('.passCount').text(data.passCountForArti);
                   $('.unPassCount').text(data.unPassCountForArti);
                  var classifyList = JSON.stringify(data.classifyList);         
                  var classify = JSON.parse(classifyList);
                  for(var i=0;i<classify.length;i++){
                        classifyArray[i] = classify[i].name;
                        $("tbody").append("<tr><td>"+classify[i].id+"</td><td>"+classify[i].name+"</td><td><span classifyId='"+classify[i].id+"' class='glyphicon glyphicon-trash del_class' style='color:rgb(213, 77, 73);' aria-hidden='true'></span></td></tr>");
                  }
                  
                },
                error:function(){
                    alert("服务器异常");
                }
               });
                }        
             reload();

       
       $(document).on('click','.del_class',function(){
             var id = $(this).attr("classifyId");
          
            $.ajax({
                type: "get",
                url: path+"/admin/deleteClassify?id="+id,
                success:function(data){
                 alert(data);
                  reload();
                },
                error:function(){
                    alert("服务器异常");
                }
               });
       });

       $('.in_add').click(function(){
          var name= $('.in_class').val();
          if(name==='')return;
            $.ajax({
                type: "get",
                url: path+"/admin/addClassify?name="+name,
                success:function(data){
                 alert(data);
                  reload();
                },
                error:function(){
                    alert("服务器异常");
                }
               });
       });
           
  var data = {
    labels : classifyArray,
    datasets : [ {
      label : "分类统计",
      data : classifyCount
    } ]
  };
  var ctx = document.getElementById("myChart").getContext("2d");
  var myBarChart = new Chart(ctx, {
    type : 'bar',
    data : data,
    responsive : true
  });
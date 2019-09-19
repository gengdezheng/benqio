$(".update").click(function() {
	$(".udt").slideToggle();
});

/**
 * excel导入导出
 * @returns
 */

$('.output').click(function(){
	
	$.ajax({
		
		type : "post",
		url : "exportFile.action",
		success:function(){
			alert("ok");
		},
		error:function(){
			alert("error");
		}
	});
});
$('.Input').click(function(){
	if($('.url').val()==""){
		alert("请输入路径。。。");
		return;
	}
	else
	$.ajax({		
		type : "post",
		url : "input.action",
		data : {'url':$('.url').val()},
		dataType : "json",
		success:function(data){
			alert(data);
			window.location.href="orderList.action";
		},
		error:function(){
			alert("ERROR!");
		}
	});
});

/**
 * 用户修改密码
 * 
 * @returns
 */
$(".conf").click(function() {
	var value = {
		'userName' : $(".name").text(),
		'password' : $(".updatePwd").val()	
	};
	$.ajax({
		type : "post",
		url : "updatePassword.action",
		data : value,
		dataType : "json",
		success : function(data) {
			// var msg=eval(data);
			var msg = JSON.parse(data);
			alert(msg.msg);
			window.location.href = "over.action";
		},
		error : function() {
			alert("ERROR");
		}
	});

});
/**
 * 根据单号查询订单
 * 
 * @returns
 */
$(".byOrderId")
		.click(
				function() {
					$(".newRow").remove();
					$
							.ajax({
								type : "post",
								url : "orderManageByOrderId.action",
								data : {
									'orderId' : $('.orderId').val()
								},
								dataType : "json",
								success : function(data) {
					
									var msg = JSON.stringify(data);
            
									var result = eval(msg);
									for (var i = 0; i < result.length; i++) {
										var date = new Date(result[i].orderTime);

										$(".table")
												.append(
														"<tr class='newRow'><td><input type='checkbox'></td><td>"
																+ result[i].id
																+ "</td><td>"
																+ date
																		.getFullYear() // 日期转换
																+ "-"
																+ (date
																		.getMonth() + 1)
																+ "-"
																+ date
																		.getDate()
																+ "  "
																+ date
																		.getHours()
																+ ":"
																+ date
																		.getMinutes()
																+ ":"
																+ date
																		.getSeconds()
																+ "</td><td>"
																+ result[i].orderType
																+ "</td><td>"
																+ result[i].orderNumber
																+ "</td><td>"
																+ result[i].clientId
																+ "</td><td>"
																+ result[i].orderBalance
																+ "</td><td><a href='deleteOrderById.action?orderId="
																+ result[i].id
																+ "' class='btn btn-danger'>删除</button></td></tr>");
									}
								},
								error : function() {
									alert("ERROR");
								}
							});

				});
/**
 * 根据客户编号查询订单
 * 
 * @returns
 */

$(".byClientId")
		.click(
				function() {
					$(".newRow").remove();
					$
							.ajax({
								type : "post",
								url : "orderManageByClientId.action",
								data : {
									'clientId' : $('.clientId').val()
								},
								dataType : "json",
								success : function(data) {
									var msg = JSON.stringify(data);
									var result = eval(msg);
									for (var i = 0; i < result.length; i++) {
										var date = new Date(result[i].orderTime);

										$(".table")
												.append(
														"<tr class='newRow'><td><input type='checkbox'></td><td>"
																+ result[i].id
																+ "</td><td>"
																+ date
																		.getFullYear()
																+ "-"
																+ (date
																		.getMonth() + 1)
																+ "-"
																+ date
																		.getDate()
																+ "  "
																+ date
																		.getHours()
																+ ":"
																+ date
																		.getMinutes()
																+ ":"
																+ date
																		.getSeconds()
																+ "</td><td>"
																+ result[i].orderType
																+ "</td><td>"
																+ result[i].orderNumber
																+ "</td><td>"
																+ result[i].clientId
																+ "</td><td>"
																+ result[i].orderBalance
																+ "</td><td><a href='deleteOrderById.action?orderId="
																+ result[i].id
																+ "' class='btn btn-danger'>删除</button></td></tr>");
									}
								},
								error : function() {
									alert("ERROR");
								}
							});
				});

/**
 * 根据类型查询订单
 * 
 * @returns
 */

$(".byType")
		.click(
				function() {
					$(".newRow").remove();
					$
							.ajax({
								type : "post",
								url : "orderManageByType.action",
								data : {
									'content' : $('.content').val()
								},
								dataType : "json",
								success : function(data) {
									var msg = JSON.stringify(data);
									var result = eval(msg);
									for (var i = 0; i < result.length; i++) {
										var date = new Date(result[i].orderTime);

										$(".table")
												.append(
														"<tr class='newRow'><td><input type='checkbox'></td><td>"
																+ result[i].id
																+ "</td><td>"
																+ date
																		.getFullYear()
																+ "-"
																+ (date
																		.getMonth() + 1)
																+ "-"
																+ date
																		.getDate()
																+ "  "
																+ date
																		.getHours()
																+ ":"
																+ date
																		.getMinutes()
																+ ":"
																+ date
																		.getSeconds()
																+ "</td><td>"
																+ result[i].orderType
																+ "</td><td>"
																+ result[i].orderNumber
																+ "</td><td>"
																+ result[i].clientId
																+ "</td><td>"
																+ result[i].orderBalance
																+ "</td><td><a href='deleteOrderById.action?orderId="
																+ result[i].id
																+ "' class='btn btn-danger'>删除</button></td></tr>");
									}
								},
								error : function() {
									alert("ERROR");
								}
							});

				});
/**
 * 查询客户
 * 
 * @returns
 */
function check() {
	if ($('#clientId').val() == "") {
		alert("编号不能为空！");
	} else {
		$.ajax({
			type : "post",
			url : "findClientById.action",
			data : {
				'clientId' : $('#clientId').val()
			},
			dataType : "json",
			success : function(data) {
				var client = JSON.parse(data);
				$('.clientName').val(client.name);
				$('.clientAge').val(client.age);
				$('.clientPhone').val(client.phone);
				$('.clientAddress').val(client.address);
				$('.clientSex').val(client.sex);
			},
			error : function() {
				alert("ERROR");
			}
		});
	}
}
/**
 * 删除客户
 * 
 * @returns
 */
$(".deleteClient").click(function() {
	if ($('#clientId').val() == "") {
		alert("编号不能为空！");
		return;
	}
	$.ajax({
		type : "post",
		url : "deleteClient.action",
		data : {
			'id' : $('#clientId').val()
		},
		dataType : "json",
		success : function(data) {
			var client = JSON.parse(data);
			$('.massage').slideDown();
			$('.print').text(client + "...");
			$('.clientName').val("");
			$('.clientAge').val("");
			$('.clientPhone').val("");
			$('.clientAddress').val("");
			$('.clientSex').val("");
		},
		error : function() {
			alert("ERROR");
		}
	});
});

/**
 * 修改客户信息
 */
$(".updateClient").click(
		function() {
			if ($('#clientId').val() == "") {
				alert("编号不能为空！");
				return;
			}
			if ($('.clientName').val() == "" || $('.clientAge').val() == ""
					|| $('.clientPhone').val() == ""
					|| $('.clientAddress').val() == "") {
				alert("填写完整信息");
				return;
			}
			$.ajax({
				type : "post",
				url : "updateClient.action",
				data : {
					'id' : $('#clientId').val(),
					'name' : $('.clientName').val(),
					'age' : $('.clientAge').val(),
					'phone' : $('.clientPhone').val(),
					'address' : $('.clientAddress').val(),
					'sex' : $('.clientSex').val()
				},
				dataType : "json",
				success : function(data) {
					var client = JSON.parse(data);
					$('.massage').slideDown();
					$('.print').text(client + "...");
				},
				error : function() {
					alert("ERROR");
				}
			});
		});
$('.alert-link').click(function() {
	$('.massage').slideUp();
});

$('.add').click(function() {
	$('.addClientOrOrder').slideDown();
});
$('.canel').click(function() {
	$('.addClientOrOrder').slideUp();
});

/**
 * 添加客户
 * @returns
 */
$('.addClient').click(
		function() {
			if ($('.name_client').val() == "" || $(".sex_client").val() == ""
					|| $(".age_client").val() == "") {
				alert("填写完整信息！");
				return;
			}
			else if ($(".address_client").val() == ""
					|| $(".phone_client").val() == "") {
				alert("填写完整信息！");
				return;
			}
			else{
				$.ajax({
					type : "post",
					url : "addClient.action",
					data : {
						'name' : $('.name_client').val(),
						'age' : $(".age_client").val() ,
						'phone' : $(".phone_client").val(),
						'address' : $(".address_client").val(),
						'sex' : $(".sex_client").val() 
					},
					dataType : "json",
					success : function(data) {
						var client = JSON.parse(data);
                        alert(client);
                 
					},
					error : function() {
						alert("ERROR");
					}
				});
			}
		});

/**
 * 添加订单
 * @returns
 */

$('.addOrders').click(
		function() {
			if ($('.orderType').val() == "" || $(".orderNumber").val() == ""
					|| $(".order_clientId").val() == "") {
				alert("填写完整信息！");
				return;
			}
			else if ($(".orderBalance").val() == "") {
				alert("填写完整信息！");
				return;
			}
			else{
				$.ajax({
					type : "post",
					url : "addOrder.action",
					data : {
						'orderType': $('.orderType').val(),
						'orderNumber':$(".orderNumber").val() ,
						'clientId': $(".order_clientId").val(),
						'orderBalance' : $(".orderBalance").val()
					},
					dataType : "json",
					success : function(data) {
						var client = JSON.parse(data);
                        alert(client);
					},
					error : function() {
						alert("ERROR");
					}
				});
			}
		});
/**
 * 添加导航菜单项
 * @returns
 */

$('.addMenu').click(function(){
	if($('.menu_Name').val()==""||$('.menu_Url').val()==""){
		alert("填写完整信息！");
	}
	else{
		$.ajax({
			type : "post",
			url : "addMenuBar.action",
			data : {
				'menu_Name': $('.menu_Name').val(),
				'menu_Url':$(".menu_Url").val() ,
			},
			dataType : "json",
			success : function(data) {
				var msg = JSON.parse(data);
                alert(msg);
                $('.nav').append("<li class='nav nav-pills nav-stacked'><a href='"+$(".menu_Url").val()+"'>"+$('.menu_Name').val()+"</a></li>");
			},
			error : function() {
				alert("ERROR");
			}
		});
	}
});

/**
 * 批量删除客户信息
*/
function deleteMore(){
	   var ids="";
	   $('.boxdelete:checked').each(function(){
		   ids+=$(this).val()+",";
	   });
	   if(ids==""){
		   alert("尚未选择！");
	   }
	   else{
		   $.ajax({		
				type : "post",
				url : "deleteClientMore.action",
				data : {'ids':ids},
				dataType : "json",
				success:function(data){
					window.location.href="clientList.action";
				},
				error:function(){
					alert("ERROR!");
				}
			});
	   }
}

/**
 * 提交修改商品信息
 * @returns
 */
function commit(){
	   if($('.goodsPrice01').val()=="" || $('.goodsAddress01').val()==""){
		   alert("填写完整信息...!");
	   }
	   else{
		   $.ajax({
			    type : "post",
				url : "commitUpdate.action",
				data : {
					'goodsId':$('.goodsId01').text(),
					'goodsPrice':$('.goodsPrice01').val(),
					'goodsAddress':$('.goodsAddress01').val(),
				},
				dataType : "json",
				success : function(data) {
					var msg = JSON.parse(data);
					alert(msg);
					window.location.href = "goodsList.action";
				},
				error : function() {
					alert("ERROR");
				}
		   });
	   }
}

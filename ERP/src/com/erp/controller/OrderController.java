package com.erp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.erp.model.Orders;
import com.erp.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@RequestMapping("/look.action")
	public String orderInfo(int id,Model model) {
		Orders order = orderService.orderInfo(id);
		model.addAttribute("orderInfo", order);
		return "order/orderInfo.jsp";
	}
	
	@RequestMapping("/addOrder.action")
	@ResponseBody
	public String addOrder(Orders order) {
		order.setOrderTime(new Date());
		String msg="添加失败！";
		if(orderService.addOrder(order))
			msg="添加成功！";
		return JSON.toJSONString(msg);
	}

}

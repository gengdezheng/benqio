package com.erp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.erp.dao.GoodsDao;
import com.erp.model.Admin;
import com.erp.model.Log4;
import com.erp.model.Orders;
import com.erp.service.AdminService;
import com.erp.service.Log4Service;
import com.erp.service.MenuBarService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	Log4Service log;
	
	@Autowired
	MenuBarService menu;
	
	@Autowired
	GoodsDao goodsDao;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@RequestMapping("/adminLogin.action")
	public String adminLogin() {
		return "adminLogin.jsp";
	}

	/**
	 * 登录并统计数据
	 * 
	 * @param admin
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/login.action")
	public String test(Admin admin, Model model, HttpSession session,HttpServletRequest request) {
		List<Admin> list = adminService.adminLogin(admin);		
		Log4 log4 = new Log4();
		log4.setLog_name(admin.getUserName());
		log4.setLog_pass(admin.getPassword());
		log4.setLog_time(sdf.format(new Date()));
		log4.setLog_IP(request.getRemoteAddr());
		if (list.size() != 0) {
			log4.setLog_status(1);
			log.insertLog(log4);
			session.setAttribute("admin", admin);
			return "index.action";
		}
		model.addAttribute("msg", "用户名或密码错误");
		log4.setLog_status(0);
		log.insertLog(log4);
		return "adminLogin.jsp";
	}
	
	/**
	 * 发送数据到前台
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("/index.action")
	public String index(Model model, HttpSession session) {
		
		//三个方块统计
		model.addAttribute("orderCount", adminService.orderCount());
		model.addAttribute("clientCount", adminService.clientCount());
		model.addAttribute("logCount", adminService.logCount());
		//近10条日志记录信息
		model.addAttribute("logList", adminService.logList());
		//柱状图信息统计
		session.setAttribute("shangyiCount", adminService.shangyiCount());
		session.setAttribute("kuziCount", adminService.kuziCount());
		session.setAttribute("mianCount", adminService.mianCount());
		session.setAttribute("maCount", adminService.maCount());
		session.setAttribute("ranCount", adminService.ranCount());
		//菜单导航列表
		session.setAttribute("menu", menu.menuList());		
		//商品类型的下拉框选项
		session.setAttribute("goodsType", goodsDao.goodsList());
		//饼状图信息统计
		session.setAttribute("shangyi", adminService.sumShangyi());
		session.setAttribute("kuzi", adminService.sumKuzi());
		session.setAttribute("mianbu", adminService.sumMianBu());
		session.setAttribute("mabu", adminService.sumMaBu());
		session.setAttribute("ranliao", adminService.sumRanliao());
		
		return "index.jsp";
	}

	/**
	 * 退出
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/over.action")
	public String over(HttpSession session) {
		session.removeAttribute("admin");
		return "adminLogin.jsp";
	}

	/**
	 * 修改密码
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping("/updatePassword.action")
	@ResponseBody
	public String updatePassword(@Param("userName") String userName, @Param("password") String password) {
		Admin admin = new Admin();
		Map<String, String> map = new HashMap<String, String>();
		admin.setUserName(userName);
		admin.setPassword(password);

		if (adminService.updatePassword(admin)) {
			map.put("msg", "修改成功！");
			// JSONObject jo = JSONObject.parseObject(JSON.toJSONString(map));
		} else {
			map.put("msg", "修改失败！");
		}
		return JSON.toJSONString(map);
	}

	/**
	 * 订单列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/orderList.action")
	public String orderList(Model model) {
		List<Orders> list = adminService.orderList();
		model.addAttribute("orderlist", list);
		return "order/orderList.jsp";
	}

	@RequestMapping("/orderManage.action")
	public String orderManage() {
		return "order/orderManage.jsp";
	}

	/**
	 * 根据单号查找
	 * 
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/orderManageByOrderId.action")
	@ResponseBody
	public JSONArray orderManageByOrderId(@Param("orderId") int orderId) {
		List<Orders> list = adminService.findOrderById(orderId);
		JSONArray ja = JSONArray.parseArray(JSON.toJSONString(list));
		return ja;
	}

	/**
	 * 根据客户ID查找
	 * 
	 * @param clientId
	 * @return
	 */
	@RequestMapping("/orderManageByClientId.action")
	@ResponseBody
	public JSONArray orderManageByClientId(@Param("clientId") int clientId) {
		List<Orders> list = adminService.findOrderByClientId(clientId);
		JSONArray ja = JSONArray.parseArray(JSON.toJSONString(list));
		return ja;
	}

	/**
	 * 类型查询
	 * 
	 * @param content
	 * @return
	 */
	@RequestMapping("/orderManageByType.action")
	@ResponseBody
	public JSONArray orderManageByType(@Param("content") String content) {
		List<Orders> list = adminService.findOrderByOrderType(content);
		JSONArray ja = JSONArray.parseArray(JSON.toJSONString(list));
		return ja;
	}

	@RequestMapping("/deleteOrderById.action")
	public String deleteOrderById(int orderId) {
		adminService.deleteByOrderId(orderId);

		return "order/success.jsp";
	}

}

package com.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.erp.dao.MenuDao;
import com.erp.model.MenuBar;

@Controller
public class MenuBarController {

	@Autowired
	MenuDao menuDao;
	
	@RequestMapping("/addMenuBar.action")
	@ResponseBody
	public String addMenu(MenuBar menu) {
		String msg="添加失败！";
		if(menuDao.addMenu(menu)) {
			msg="添加成功！";
		}
		return JSON.toJSONString(msg);
	}
	
	@RequestMapping("/deleteUrl.action")
	public String deleteMenu(int menu_Id) {
		menuDao.deleteMenu(menu_Id);
		return "index.action";
	}
}

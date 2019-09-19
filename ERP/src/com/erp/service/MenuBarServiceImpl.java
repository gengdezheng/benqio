package com.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.dao.MenuDao;
import com.erp.model.MenuBar;

@Service
public class MenuBarServiceImpl implements MenuBarService{

	@Autowired
	MenuDao menuDao;
	
	@Override
	public List<MenuBar> menuList() {
		// TODO Auto-generated method stub
		return menuDao.menuList();
	}

	@Override
	public boolean addMenu(MenuBar menu) {
		// TODO Auto-generated method stub
		return menuDao.addMenu(menu);
	}

	@Override
	public boolean deleteMenu(Integer menu_id) {
		// TODO Auto-generated method stub
		return menuDao.deleteMenu(menu_id);
	}

}

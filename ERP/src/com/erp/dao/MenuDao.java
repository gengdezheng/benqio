package com.erp.dao;

import java.util.List;

import com.erp.model.MenuBar;

public interface MenuDao {
   public List<MenuBar> menuList(); //获取导航栏
   public boolean addMenu(MenuBar menu); //添加导航菜单
   public boolean deleteMenu(Integer menu_id); //删除导航菜单
}

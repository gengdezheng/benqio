package com.erp.dao;

import java.util.List;

import com.erp.model.MenuBar;

public interface MenuDao {
   public List<MenuBar> menuList(); //��ȡ������
   public boolean addMenu(MenuBar menu); //��ӵ����˵�
   public boolean deleteMenu(Integer menu_id); //ɾ�������˵�
}

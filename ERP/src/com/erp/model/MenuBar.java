package com.erp.model;

import org.springframework.stereotype.Component;

@Component
public class MenuBar {
   private int menu_Id;
   private String menu_Name;
   private String menu_Url;
public int getMenu_Id() {
	return menu_Id;
}
public void setMenu_Id(int menu_Id) {
	this.menu_Id = menu_Id;
}
public String getMenu_Name() {
	return menu_Name;
}
public void setMenu_Name(String menu_Name) {
	this.menu_Name = menu_Name;
}
public String getMenu_Url() {
	return menu_Url;
}
public void setMenu_Url(String menu_Url) {
	this.menu_Url = menu_Url;
}
   
}

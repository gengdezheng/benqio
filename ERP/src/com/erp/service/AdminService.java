package com.erp.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.erp.model.Admin;
import com.erp.model.Log4;
import com.erp.model.Orders;

public interface AdminService {
	
	public List<Admin> adminLogin(Admin admin);
	public boolean updatePassword(Admin admin);
	public int orderCount();  //订单数
	
	public int clientCount();//客户人数
	public Integer logCount();//日志数
	
	public List<Orders> orderList();
	
	public List<Orders> findOrderById(Integer orderId);
	
	public List<Orders> findOrderByClientId(Integer orderId);
	
	public List<Orders> findOrderByOrderType(@Param("content")String content);
	
	public boolean deleteByOrderId(Integer orderId);
	
	public List<Log4> logList();
	public Integer shangyiCount();//统计上衣销量
	public Integer kuziCount();//统计裤子销量
	public Integer mianCount();//统计棉布销量
	public Integer maCount();//统计麻布销量
	public Integer ranCount();//统计染料销量
	public Integer sumShangyi();
	public Integer sumKuzi();
	public Integer sumMianBu();
	public Integer sumMaBu();	
	public Integer sumRanliao();
}

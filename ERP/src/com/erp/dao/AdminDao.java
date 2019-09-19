package com.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.erp.model.Admin;
import com.erp.model.Log4;
import com.erp.model.Orders;


public interface AdminDao {

	public List<Admin> adminLogin(Admin admin);
	
	public boolean updatePassword(Admin admin);
	
	public Integer orderCount();  //订单数
	
	public Integer clientCount();//客户人数
	
	public Integer logCount();//日志数
	
	public Integer shangyiCount();//统计上衣销量
	public Integer kuziCount();//统计裤子销量
	public Integer mianCount();//统计棉布销量
	public Integer maCount();//统计麻布销量
	public Integer ranCount();//统计染料销量
	public List<Orders> orderList();//订单列表
	
	public List<Orders> findOrderById(Integer orderId); //根据单号查找
	
	public List<Orders> findOrderByClientId(Integer orderId);//根据客户ID查找
	
	public List<Orders> findOrderByOrderType(@Param("content")String content);//根据类型查找
	
	public boolean deleteByOrderId(Integer orderId); //删除订单
	
	public List<Log4> logList();
	
	public Integer sumShangyi();
	public Integer sumKuzi();
	public Integer sumMianBu();
	public Integer sumMaBu();
	
	public Integer sumRanliao();
	
}

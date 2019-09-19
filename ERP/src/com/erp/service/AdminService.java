package com.erp.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.erp.model.Admin;
import com.erp.model.Log4;
import com.erp.model.Orders;

public interface AdminService {
	
	public List<Admin> adminLogin(Admin admin);
	public boolean updatePassword(Admin admin);
	public int orderCount();  //������
	
	public int clientCount();//�ͻ�����
	public Integer logCount();//��־��
	
	public List<Orders> orderList();
	
	public List<Orders> findOrderById(Integer orderId);
	
	public List<Orders> findOrderByClientId(Integer orderId);
	
	public List<Orders> findOrderByOrderType(@Param("content")String content);
	
	public boolean deleteByOrderId(Integer orderId);
	
	public List<Log4> logList();
	public Integer shangyiCount();//ͳ����������
	public Integer kuziCount();//ͳ�ƿ�������
	public Integer mianCount();//ͳ���޲�����
	public Integer maCount();//ͳ���鲼����
	public Integer ranCount();//ͳ��Ⱦ������
	public Integer sumShangyi();
	public Integer sumKuzi();
	public Integer sumMianBu();
	public Integer sumMaBu();	
	public Integer sumRanliao();
}

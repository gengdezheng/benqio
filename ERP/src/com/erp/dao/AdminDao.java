package com.erp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.erp.model.Admin;
import com.erp.model.Log4;
import com.erp.model.Orders;


public interface AdminDao {

	public List<Admin> adminLogin(Admin admin);
	
	public boolean updatePassword(Admin admin);
	
	public Integer orderCount();  //������
	
	public Integer clientCount();//�ͻ�����
	
	public Integer logCount();//��־��
	
	public Integer shangyiCount();//ͳ����������
	public Integer kuziCount();//ͳ�ƿ�������
	public Integer mianCount();//ͳ���޲�����
	public Integer maCount();//ͳ���鲼����
	public Integer ranCount();//ͳ��Ⱦ������
	public List<Orders> orderList();//�����б�
	
	public List<Orders> findOrderById(Integer orderId); //���ݵ��Ų���
	
	public List<Orders> findOrderByClientId(Integer orderId);//���ݿͻ�ID����
	
	public List<Orders> findOrderByOrderType(@Param("content")String content);//�������Ͳ���
	
	public boolean deleteByOrderId(Integer orderId); //ɾ������
	
	public List<Log4> logList();
	
	public Integer sumShangyi();
	public Integer sumKuzi();
	public Integer sumMianBu();
	public Integer sumMaBu();
	
	public Integer sumRanliao();
	
}

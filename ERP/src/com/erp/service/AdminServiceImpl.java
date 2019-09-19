package com.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.dao.AdminDao;
import com.erp.dao.Log4Dao;
import com.erp.model.Admin;
import com.erp.model.Log4;
import com.erp.model.Orders;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao adminDao;
	

	@Override
	public List<Admin> adminLogin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.adminLogin(admin);
	}



	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}



	@Override
	public boolean updatePassword(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.updatePassword(admin);
	}



	@Override
	public int orderCount() {
		// TODO Auto-generated method stub
		return adminDao.orderCount();
	}



	@Override
	public int clientCount() {
		// TODO Auto-generated method stub
		return adminDao.clientCount();
	}



	@Override
	public List<Orders> orderList() {
		// TODO Auto-generated method stub
		return adminDao.orderList();
	}



	@Override
	public List<Orders> findOrderById(Integer orderId) {
		// TODO Auto-generated method stub
		return adminDao.findOrderById(orderId);
	}



	@Override
	public List<Orders> findOrderByClientId(Integer orderId) {
		// TODO Auto-generated method stub
		return adminDao.findOrderByClientId(orderId);
	}



	@Override
	public List<Orders> findOrderByOrderType(String content) {
		// TODO Auto-generated method stub
		return adminDao.findOrderByOrderType(content);
	}



	@Override
	public boolean deleteByOrderId(Integer orderId) {
		// TODO Auto-generated method stub
		return adminDao.deleteByOrderId(orderId);
	}



	@Override
	public Integer logCount() {
		// TODO Auto-generated method stub
		return adminDao.logCount();
	}



	@Override
	public List<Log4> logList() {
		// TODO Auto-generated method stub
		return adminDao.logList();
	}



	@Override
	public Integer shangyiCount() {
		// TODO Auto-generated method stub
		return adminDao.shangyiCount();
	}



	@Override
	public Integer kuziCount() {
		// TODO Auto-generated method stub
		return adminDao.kuziCount();
	}



	@Override
	public Integer mianCount() {
		// TODO Auto-generated method stub
		return adminDao.mianCount();
	}



	@Override
	public Integer maCount() {
		// TODO Auto-generated method stub
		return adminDao.maCount();
	}



	@Override
	public Integer ranCount() {
		// TODO Auto-generated method stub
		return adminDao.ranCount();
	}



	@Override
	public Integer sumShangyi() {
		// TODO Auto-generated method stub
		return adminDao.sumShangyi();
	}



	@Override
	public Integer sumKuzi() {
		// TODO Auto-generated method stub
		return adminDao.sumKuzi();
	}



	@Override
	public Integer sumMianBu() {
		// TODO Auto-generated method stub
		return adminDao.sumMaBu();
	}



	@Override
	public Integer sumMaBu() {
		// TODO Auto-generated method stub
		return adminDao.sumMaBu();
	}



	@Override
	public Integer sumRanliao() {
		// TODO Auto-generated method stub
		return adminDao.sumRanliao();
	}

}

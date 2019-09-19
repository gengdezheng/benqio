package com.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.dao.OrderDao;
import com.erp.model.Orders;

@Service
public class OrderServiceImpl  implements OrderService{

	@Autowired
	OrderDao orderDao;
	
	@Override
	public Orders orderInfo(Integer id) {
		// TODO Auto-generated method stub
		return orderDao.orderInfo(id);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return orderDao.delete(id);
	}

	@Override
	public boolean addOrder(Orders order) {
		// TODO Auto-generated method stub
		return orderDao.addOrder(order);
	}

}

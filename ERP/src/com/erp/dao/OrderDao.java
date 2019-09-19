package com.erp.dao;

import com.erp.model.Orders;

public interface OrderDao {
	
	 public Orders orderInfo(Integer id);
	 
	 public boolean addOrder(Orders order);
	 public boolean delete(int id);
}

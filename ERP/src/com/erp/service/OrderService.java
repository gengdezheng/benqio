package com.erp.service;

import com.erp.model.Orders;

public interface OrderService {
	public Orders orderInfo(Integer id);
	public boolean delete(int id);
	 public boolean addOrder(Orders order);
}

package com.erp.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.erp.dao.ClientDao;
import com.erp.model.Client;

public interface ClientService {
	public List<ClientDao> clientList();
	public Client clientInfo(Integer id);
    public Client getClientById(@Param("id")Integer id);
    public boolean deleteClient(Integer id);//删除客户
    public void deleteClientOrders(Integer id);//删除客户时同时删除该客户的所有订单信息
    public boolean updateClient(Client client);//修改客户信息
    public boolean addClient(@Param("clientName")String clientName,@Param("clientSex")String clientSex,@Param("clientAddress")String clientAddress,@Param("clientPhone")String clientPhone,@Param("clientAge")Integer clientAge);//添加客户
}

package com.erp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.erp.model.Client;


public interface ClientDao {
    public List<ClientDao> clientList();//客户列表
    
    public Client clientInfo(@Param("id")Integer id);//客户详细信息
    
    public Client getClientById(@Param("id")Integer id);//根据Id获取客户信息
    
    public boolean deleteClient(Integer id);//删除客户
    
    public void deleteClientOrders(Integer id);//删除客户时同时删除该客户的所有订单信息
    
    public boolean updateClient(Client client);//修改客户信息
    
    public boolean addClient(@Param("clientName")String clientName,@Param("clientSex")String clientSex,@Param("clientAddress")String clientAddress,@Param("clientPhone")String clientPhone,@Param("clientAge")Integer clientAge);//添加客户
   
}

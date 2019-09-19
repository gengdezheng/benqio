package com.erp.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.erp.dao.ClientDao;
import com.erp.model.Client;

public interface ClientService {
	public List<ClientDao> clientList();
	public Client clientInfo(Integer id);
    public Client getClientById(@Param("id")Integer id);
    public boolean deleteClient(Integer id);//ɾ���ͻ�
    public void deleteClientOrders(Integer id);//ɾ���ͻ�ʱͬʱɾ���ÿͻ������ж�����Ϣ
    public boolean updateClient(Client client);//�޸Ŀͻ���Ϣ
    public boolean addClient(@Param("clientName")String clientName,@Param("clientSex")String clientSex,@Param("clientAddress")String clientAddress,@Param("clientPhone")String clientPhone,@Param("clientAge")Integer clientAge);//��ӿͻ�
}

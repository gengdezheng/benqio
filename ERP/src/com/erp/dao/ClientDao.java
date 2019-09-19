package com.erp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.erp.model.Client;


public interface ClientDao {
    public List<ClientDao> clientList();//�ͻ��б�
    
    public Client clientInfo(@Param("id")Integer id);//�ͻ���ϸ��Ϣ
    
    public Client getClientById(@Param("id")Integer id);//����Id��ȡ�ͻ���Ϣ
    
    public boolean deleteClient(Integer id);//ɾ���ͻ�
    
    public void deleteClientOrders(Integer id);//ɾ���ͻ�ʱͬʱɾ���ÿͻ������ж�����Ϣ
    
    public boolean updateClient(Client client);//�޸Ŀͻ���Ϣ
    
    public boolean addClient(@Param("clientName")String clientName,@Param("clientSex")String clientSex,@Param("clientAddress")String clientAddress,@Param("clientPhone")String clientPhone,@Param("clientAge")Integer clientAge);//��ӿͻ�
   
}

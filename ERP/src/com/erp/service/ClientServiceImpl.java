package com.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.erp.dao.ClientDao;
import com.erp.model.Client;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	ClientDao clientDao;
	@Override
	public List<ClientDao> clientList() {
		// TODO Auto-generated method stub
		return clientDao.clientList();
	}
	
	
	@Override
	public Client clientInfo(Integer id) {
		// TODO Auto-generated method stub
		return clientDao.clientInfo(id);
	}


	@Override
	public Client getClientById(Integer id) {
		// TODO Auto-generated method stub
		return clientDao.getClientById(id);
	}


	@Override
	public boolean deleteClient(Integer id) {
		// TODO Auto-generated method stub
		return clientDao.deleteClient(id);
	}


	@Override
	public void deleteClientOrders(Integer id) {
		// TODO Auto-generated method stub
		clientDao.deleteClientOrders(id);
	}


	@Override
	public boolean updateClient(Client client) {
		// TODO Auto-generated method stub
		return clientDao.updateClient(client);
	}


	@Override
	public boolean addClient(String clientName, String clientSex, String clientAddress, String clientPhone,
			Integer clientAge) {
		// TODO Auto-generated method stub
		return clientDao.addClient(clientName, clientSex, clientAddress, clientPhone, clientAge);
	}




}

package com.erp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.erp.dao.GoodsDao;
import com.erp.model.Client;
import com.erp.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	ClientService clientService;
	@Autowired
	GoodsDao goodsDao;
	/**
	 * �ͻ��б�
	 * @param model
	 * @return
	 */
	@RequestMapping("/clientList.action")
	public String clientList(Model model) {
		model.addAttribute("clientList",clientService.clientList());
		return "client/clientList.jsp";
	}
	
	/**
	 * �鿴�ͻ���Ϣ
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/lookClientInfo.action")
	public String clientInfo(int id,Model model) {
		model.addAttribute("clientInfo", clientService.clientInfo(id));
		return "client/clientInfo.jsp";
	}
	
	@RequestMapping("/clientManage.action")
	public String clientManage(HttpSession session) {
		session.removeAttribute("goodsType");
		session.setAttribute("goodsType", goodsDao.goodsList());
		return "client/clientManage.jsp";
	}
	
	/**
	 * ͨ����Ż�ȡ�ͻ���Ϣ
	 * @param clientId
	 * @return
	 */
	@RequestMapping("/findClientById.action")
	@ResponseBody
	public String getClientById(int clientId) {
		//JSONObject jo = JSONObject.parseObject(JSON.toJSONString(clientService.getClientById(clientId)));
		return JSON.toJSONString(clientService.getClientById(clientId));
	}
	/**
	 * ɾ���ͻ���ͬʱɾ���ÿͻ������ж�����Ϣ
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteClient.action")
	@ResponseBody
	public String deleteClient(int id) {
		String msg="ɾ��ʧ��";
		if(clientService.deleteClient(id))
		{
			msg="ɾ���ɹ�";
			clientService.deleteClientOrders(id);
		}
		return JSON.toJSONString(msg);
	}
	
	/**
	 * �޸Ŀͻ���Ϣ
	 * @param client
	 * @return
	 */
	@RequestMapping("/updateClient.action")
	@ResponseBody
	public String updateClient(Client client) {
		String msg="�޸�ʧ��";
		if(clientService.updateClient(client))
		{
			msg="�޸ĳɹ�";
		}
		return JSON.toJSONString(msg);
	}
	
	/**
	 * ��ӿͻ�
	 * @param name
	 * @param sex
	 * @param address
	 * @param phone
	 * @param age
	 * @return
	 */
	@RequestMapping("/addClient.action")
	@ResponseBody
	public String addClient(String name, String sex, String address, String phone,
			Integer age) {
		
		String msg="���ʧ��";
		if(clientService.addClient(name, sex, address, phone, age))
		{
			msg="��ӳɹ�";
		}
		return JSON.toJSONString(msg);
	}
	
	/**
	 * ����ɾ��
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteClientMore.action")
	@ResponseBody
	public String deleteClientMore(String ids) {

		String id[]=ids.split(",");
		for(int i=0;i<id.length;i++) {
			clientService.deleteClient(Integer.parseInt(id[i]));
		}
		System.out.println("123");
		return "";
	}
	
}

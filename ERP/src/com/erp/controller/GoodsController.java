package com.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.erp.model.Goods;
import com.erp.service.GoodsService;

@Controller
public class GoodsController {

	  @Autowired
	  GoodsService goodsService;
	  
	  /**
	        * ��ȡ��Ʒ�б�
	   * @param model
	   * @return
	   */
	  @RequestMapping("/goodsList.action")
	  public String goodsList(Model model) {
		  model.addAttribute("goodsList",goodsService.goodsList());
		  return "goods/goodsList.jsp";
	  }
	  
	  /**
	   * ��ȡ ָ���������͵���
	   * @param orderType
	   * @return
	   */
	  @RequestMapping("/getOrderTypeBalance.action")
	  @ResponseBody
	  public String getOrderTypeBalance(String orderType) {
		  
		  return JSON.toJSONString(goodsService.getOrderTypeBalance(orderType));
	  }
	  
	  /**
	   * ɾ����Ʒ����
	   * @param goodsId
	   * @return
	   */
	  @RequestMapping("/deleteGoods.action")
	  public String deleteGoods(int goodsId) {
		  goodsService.deleteGoodsById(goodsId);
		  return "goodsList.action";
	  }
	  
	  /**
	   * �޸���Ʒ��Ϣ
	   * @param goodsId
	   * @param model
	   * @return
	   */
	  @RequestMapping("/updateGoods.action")
	  public String getUpdateGoodsId(int goodsId,Model model) {
		  model.addAttribute("goodsInfo", goodsService.updateGoodsById(goodsId));
		  return "goods/updateGoods.jsp";
	  }
	  
	  @RequestMapping("/commitUpdate.action")
	  @ResponseBody
	  public String commitUpdate(Goods goods) {
		  goodsService.commitUpdate(goods);
		  return JSON.toJSONString("�޸ĳɹ���");
	  }
	  
	  /**
	   * �����Ʒ���ж��Ƿ�����
	   * @param goodsName
	   * @return
	   */
	  @RequestMapping("/checkGoodsType.action")
	  @ResponseBody
	  public String checkGoodsType(String goodsName) {
		  List<Goods> list=goodsService.goodsList();
		  String msg="";
		  for(Goods goods:list) {
			  if(goodsName.equals(goods.getGoodsName())) {
				  msg="��Ʒ���ظ���";
				  break;
			  }
		  }
		  return JSON.toJSONString(msg);
	  }
	  
	  @RequestMapping("/addGoods.action")
	  @ResponseBody
	  public String addGoods(Goods goods) {
		  String msg="���ʧ�ܣ�";
		  if(goodsService.addGoods(goods)) {
			  msg="��ӳɹ���";
		  }
		  return JSON.toJSONString(msg);
	  }
 }

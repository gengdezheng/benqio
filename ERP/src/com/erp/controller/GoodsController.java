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
	        * 获取商品列表
	   * @param model
	   * @return
	   */
	  @RequestMapping("/goodsList.action")
	  public String goodsList(Model model) {
		  model.addAttribute("goodsList",goodsService.goodsList());
		  return "goods/goodsList.jsp";
	  }
	  
	  /**
	   * 获取 指定订单类型单价
	   * @param orderType
	   * @return
	   */
	  @RequestMapping("/getOrderTypeBalance.action")
	  @ResponseBody
	  public String getOrderTypeBalance(String orderType) {
		  
		  return JSON.toJSONString(goodsService.getOrderTypeBalance(orderType));
	  }
	  
	  /**
	   * 删除商品类型
	   * @param goodsId
	   * @return
	   */
	  @RequestMapping("/deleteGoods.action")
	  public String deleteGoods(int goodsId) {
		  goodsService.deleteGoodsById(goodsId);
		  return "goodsList.action";
	  }
	  
	  /**
	   * 修改商品信息
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
		  return JSON.toJSONString("修改成功！");
	  }
	  
	  /**
	   * 添加商品是判断是否重名
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
				  msg="商品名重复！";
				  break;
			  }
		  }
		  return JSON.toJSONString(msg);
	  }
	  
	  @RequestMapping("/addGoods.action")
	  @ResponseBody
	  public String addGoods(Goods goods) {
		  String msg="添加失败！";
		  if(goodsService.addGoods(goods)) {
			  msg="添加成功！";
		  }
		  return JSON.toJSONString(msg);
	  }
 }

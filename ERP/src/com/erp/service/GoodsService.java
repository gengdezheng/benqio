package com.erp.service;

import java.util.List;

import com.erp.model.Goods;

public interface GoodsService {
	 public List<Goods> goodsList(); //���������б�
	 public double getOrderTypeBalance(String orderType); //��ȡ�ƶ���Ʒ���͵ĵ���
	 public void deleteGoodsById(Integer goodsId);
	 public Goods updateGoodsById(Integer goodsId);
	 public void commitUpdate(Goods goods);
	 public boolean addGoods(Goods goods);
}

package com.erp.dao;

import java.util.List;

import com.erp.model.Goods;

public interface GoodsDao {
   public List<Goods> goodsList(); //订单类型列表
   public double getOrderTypeBalance(String orderType); //获取制定商品类型的单价
   public void deleteGoodsById(Integer goodsId);
   public Goods updateGoodsById(Integer goodsId);
   public void commitUpdate(Goods goods);
   public boolean addGoods(Goods goods);
  
}

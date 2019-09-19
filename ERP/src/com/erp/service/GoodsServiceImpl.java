package com.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.dao.GoodsDao;
import com.erp.model.Goods;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	GoodsDao goodsDao;
	
	@Override
	public List<Goods> goodsList() {
		// TODO Auto-generated method stub
		return goodsDao.goodsList();
	}

	@Override
	public double getOrderTypeBalance(String orderType) {
		// TODO Auto-generated method stub
		return goodsDao.getOrderTypeBalance(orderType);
	}

	@Override
	public void deleteGoodsById(Integer goodsId) {
		// TODO Auto-generated method stub
		goodsDao.deleteGoodsById(goodsId);
	}

	@Override
	public Goods updateGoodsById(Integer goodsId) {
		// TODO Auto-generated method stub
		return goodsDao.updateGoodsById(goodsId);
	}

	@Override
	public void commitUpdate(Goods goods) {
		// TODO Auto-generated method stub
		goodsDao.commitUpdate(goods);
	}

	@Override
	public boolean addGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.addGoods(goods);
	}

}

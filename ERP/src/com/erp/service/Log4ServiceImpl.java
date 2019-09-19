package com.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.dao.Log4Dao;
import com.erp.model.Log4;

@Service
public class Log4ServiceImpl implements Log4Service{

	@Autowired
	Log4Dao log4;
	@Override
	public boolean insertLog(Log4 log) {
		// TODO Auto-generated method stub
		return log4.insertLog(log);
	}

}

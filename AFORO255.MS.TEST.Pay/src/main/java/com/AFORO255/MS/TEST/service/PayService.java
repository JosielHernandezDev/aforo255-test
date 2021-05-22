package com.AFORO255.MS.TEST.service;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AFORO255.MS.TEST.dao.IPayDao;
import com.AFORO255.MS.TEST.dao.IPayRedis;
import com.AFORO255.MS.TEST.model.Pay;
import com.AFORO255.MS.TEST.model.PayRedis;

@Service
public class PayService implements IPayService {
	@Autowired
	private IPayDao _payDao;
	
	@Autowired
	private IPayRedis  payRedis;
	
	@Override
	@Transactional
	public Pay save(Pay transaction) {
		// TODO Auto-generated method stub
		return _payDao.save(transaction);
	}

	@Override
	public PayRedis findByIdRedis(String id) {
		// TODO Auto-generated method stub
		return payRedis.findById(id);
	}

	@Override
	public void save(PayRedis transaction) {
		// TODO Auto-generated method stub
		payRedis.save(transaction);
	}

	@Override
	public Map<String, PayRedis> findAll() {
		// TODO Auto-generated method stub		
		return payRedis.findAll();

	}
}

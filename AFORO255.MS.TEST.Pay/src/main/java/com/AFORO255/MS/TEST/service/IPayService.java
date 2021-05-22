package com.AFORO255.MS.TEST.service;

import java.util.Map;

import com.AFORO255.MS.TEST.model.Pay;
import com.AFORO255.MS.TEST.model.PayRedis;

public interface IPayService {
	public Pay save(Pay transaction);

	// Metodos-Redis
	public PayRedis findByIdRedis(String id);

	public void save(PayRedis transaction);

	public Map<String, PayRedis> findAll();
}

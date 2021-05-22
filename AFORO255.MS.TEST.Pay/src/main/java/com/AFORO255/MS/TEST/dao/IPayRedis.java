package com.AFORO255.MS.TEST.dao;

import java.util.Map;

import com.AFORO255.MS.TEST.model.PayRedis;

public interface IPayRedis {
	void save (PayRedis transaction);
	 Map<String, PayRedis> findAll();
	 PayRedis findById(String id );
	 void update (PayRedis transaction);
	 void delete (String id );
}

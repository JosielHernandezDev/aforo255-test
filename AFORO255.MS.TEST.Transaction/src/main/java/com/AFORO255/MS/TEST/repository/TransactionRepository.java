package com.AFORO255.MS.TEST.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.AFORO255.MS.TEST.domain.Transaction;

public interface TransactionRepository  extends MongoRepository<Transaction, String> {
	//@Query("{'accountId':?0}")
	//public Iterable<Transaction> findByAccountId(Integer accountId);

}

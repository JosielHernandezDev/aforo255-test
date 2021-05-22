package com.AFORO255.MS.TEST.dao;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.AFORO255.MS.TEST.model.PayRedis;
@Repository
public class PayRedisDao implements IPayRedis{
	@Autowired
	private RedisTemplate<String , PayRedis> redisTemplate ; 

  private HashOperations hashOperations;
    String key = "TRANSACTION";
    @PostConstruct
    private void init () {
    	hashOperations= redisTemplate.opsForHash();
    	
    }
	@Override
	public void save(PayRedis transaction) {
		// TODO Auto-generated method stub
		hashOperations.put(key ,transaction.getId_operation(), transaction);
	}

	@Override
	public Map<String, PayRedis> findAll() {
		// TODO Auto-generated method stub
		return hashOperations.entries(key);
	}

	@Override
	public PayRedis findById(String id) {
		// TODO Auto-generated method stub
		return (PayRedis) hashOperations.get(key, id);
	}

	@Override
	public void update(PayRedis transaction) {
		// TODO Auto-generated method stub
		save (transaction);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		hashOperations.delete(key, id);
	}
}

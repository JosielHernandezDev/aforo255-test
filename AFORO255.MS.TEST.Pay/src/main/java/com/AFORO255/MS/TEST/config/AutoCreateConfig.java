package com.AFORO255.MS.TEST.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import com.AFORO255.MS.TEST.producer.PayEvent;
import com.AFORO255.MS.TEST.service.PayService;

@Configuration
public class AutoCreateConfig {
	
	@Bean
	public NewTopic payEvents() {
		
		return TopicBuilder.name("transaction-events")
				.partitions(3)
				.replicas(1)
				.build();
	}
}

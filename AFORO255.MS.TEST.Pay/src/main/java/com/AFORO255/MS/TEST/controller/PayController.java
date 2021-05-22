package com.AFORO255.MS.TEST.controller;

import org.springframework.beans.factory.annotation.Autowired;

//import io.micrometer.core.annotation.Timed;

import com.AFORO255.MS.TEST.model.Pay;
import com.AFORO255.MS.TEST.model.PayRedis;
import com.AFORO255.MS.TEST.producer.PayEvent;
import com.AFORO255.MS.TEST.service.IPayService;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PayController {
	@Autowired
	private IPayService service;
	@Autowired
	PayEvent eventProducer;
	private Logger log = LoggerFactory.getLogger(PayController.class);

	@PostMapping("/v1/payevent")
	/*@Timed(value = "postPayEvent", histogram = true, percentiles = { 0.95, 0.99 }, extraTags = { "app",
			"postPayEvent" })*/
	public ResponseEntity<Pay> postPayEvent(@RequestBody Pay transaction) throws JsonProcessingException {
		log.info("antes de transql");
		Pay transql = service.save(transaction);
		log.info("despues de transql");
		log.info("antes de sendPayEvent");
		eventProducer.sendPayEvent(transql);
		log.info("despues de sendPayEvent");
		return ResponseEntity.status(HttpStatus.CREATED).body(transql);
	}

	@GetMapping("/all")
	public Map<String, PayRedis> getAll() {
		return service.findAll();
	}

	@GetMapping("/")
	public String homeInit() {
		return "home";
	}
}

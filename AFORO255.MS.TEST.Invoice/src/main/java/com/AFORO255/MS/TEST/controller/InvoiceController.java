package com.AFORO255.MS.TEST.controller;

import com.AFORO255.MS.TEST.domain.Invoice;
import com.AFORO255.MS.TEST.producer.InvoiceEvent;
import com.AFORO255.MS.TEST.service.IInvoiceService;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

import javax.transaction.Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class InvoiceController {
	@Autowired
	private IInvoiceService service;
	@Autowired
	InvoiceEvent eventProducer;
	private Logger log = LoggerFactory.getLogger(InvoiceController.class);
	@PostMapping("/v1/invoicetevent")
	/*@Timed(value = "postDepositEvent", histogram = true , percentiles = {0.95,0.99}
	,extraTags = {"app","postDepositEvent"})*/
	public ResponseEntity<Invoice> postDepositEvent(@RequestBody Invoice transaction) throws JsonProcessingException {
		log.info("antes de transql");
		Invoice transql = service.save(transaction);
		log.info("despues de transql");
		log.info("antes de sendDepositEvent");
		eventProducer.sendDepositEvent(transql);
		log.info("despues de sendDepositEvent");
		return ResponseEntity.status(HttpStatus.CREATED).body(transql);
	}
	
	/*@GetMapping("/all")
	public Map<String , TransactionRedis> getAll(){		
		return service.findAll();
	}*/	

}

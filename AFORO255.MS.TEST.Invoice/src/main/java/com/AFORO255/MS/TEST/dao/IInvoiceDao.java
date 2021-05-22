package com.AFORO255.MS.TEST.dao;

import org.springframework.data.repository.CrudRepository;

import com.AFORO255.MS.TEST.domain.Invoice;

public interface IInvoiceDao extends CrudRepository<Invoice, Integer>{

}

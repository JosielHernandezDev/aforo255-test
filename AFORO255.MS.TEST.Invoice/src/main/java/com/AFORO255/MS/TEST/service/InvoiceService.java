package com.AFORO255.MS.TEST.service;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AFORO255.MS.TEST.dao.IInvoiceDao;
import com.AFORO255.MS.TEST.domain.Invoice;

@Service
public class InvoiceService implements IInvoiceService{
	@Autowired
	private IInvoiceDao _invoiceDao;
	
	@Override
	@Transactional
	public Invoice save(Invoice transaction) {
		// TODO Auto-generated method stub
		return _invoiceDao.save(transaction);
	}
}

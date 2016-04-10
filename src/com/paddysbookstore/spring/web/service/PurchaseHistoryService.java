package com.paddysbookstore.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paddysbookstore.spring.web.dao.PurchaseHistory;
import com.paddysbookstore.spring.web.dao.PurchaseHistoryDao;

@Service("purchaseHistoryService")
public class PurchaseHistoryService {
	
private PurchaseHistoryDao purchaseHistoryDao;
	
	@Autowired
	public void setPurchaseHistoryDao(PurchaseHistoryDao purchaseHistoryDao) {
		this.purchaseHistoryDao = purchaseHistoryDao;
	}

	public void create(PurchaseHistory purchaseHitory) {
		// TODO Auto-generated method stub
		purchaseHistoryDao.create(purchaseHitory);
	}
}


package com.paddysbookstore.spring.web.service;

import java.util.List;

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
		purchaseHistoryDao.create(purchaseHitory);
	}

	public List<PurchaseHistory> displayPurchaseHistory() {
		return purchaseHistoryDao.displayPurchaseHistory();
	}
}


package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.Transaction;
import com.mypackage.gestion2.service.TransactionService;
import com.mypackage.gestion2.repo.TransactionRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class TransactionServiceImpl extends BaseServiceImpl<Transaction> implements TransactionService
{
	@Resource
	private TransactionRepository transactionRepository;

	@Override
	protected BaseRepository<Transaction> getRepository() {
		return transactionRepository;
	}
	
	
}

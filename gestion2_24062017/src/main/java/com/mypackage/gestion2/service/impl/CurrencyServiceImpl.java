package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.Currency;
import com.mypackage.gestion2.service.CurrencyService;
import com.mypackage.gestion2.repo.CurrencyRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class CurrencyServiceImpl extends BaseServiceImpl<Currency> implements CurrencyService
{
	@Resource
	private CurrencyRepository currencyRepository;

	@Override
	protected BaseRepository<Currency> getRepository() {
		return currencyRepository;
	}
	
	
}

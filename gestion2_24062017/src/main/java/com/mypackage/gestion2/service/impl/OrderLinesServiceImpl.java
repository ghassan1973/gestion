package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.OrderLines;
import com.mypackage.gestion2.service.OrderLinesService;
import com.mypackage.gestion2.repo.OrderLinesRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class OrderLinesServiceImpl extends BaseServiceImpl<OrderLines> implements OrderLinesService
{
	@Resource
	private OrderLinesRepository orderLinesRepository;

	@Override
	protected BaseRepository<OrderLines> getRepository() {
		return orderLinesRepository;
	}
	
	
}

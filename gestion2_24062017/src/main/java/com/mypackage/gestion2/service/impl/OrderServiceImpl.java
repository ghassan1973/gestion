package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.Order;
import com.mypackage.gestion2.service.OrderService;
import com.mypackage.gestion2.repo.OrderRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService
{
	@Resource
	private OrderRepository orderRepository;

	@Override
	protected BaseRepository<Order> getRepository() {
		return orderRepository;
	}
	
	
}

package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.ModePayment;
import com.mypackage.gestion2.service.ModePaymentService;
import com.mypackage.gestion2.repo.ModePaymentRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class ModePaymentServiceImpl extends BaseServiceImpl<ModePayment> implements ModePaymentService
{
	@Resource
	private ModePaymentRepository modePaymentRepository;

	@Override
	protected BaseRepository<ModePayment> getRepository() {
		return modePaymentRepository;
	}
	
	
}

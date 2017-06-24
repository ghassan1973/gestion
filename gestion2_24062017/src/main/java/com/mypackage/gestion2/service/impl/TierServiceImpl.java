package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.Tier;
import com.mypackage.gestion2.service.TierService;
import com.mypackage.gestion2.repo.TierRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class TierServiceImpl extends BaseServiceImpl<Tier> implements TierService
{
	@Resource
	private TierRepository tierRepository;

	@Override
	protected BaseRepository<Tier> getRepository() {
		return tierRepository;
	}
	
	
}

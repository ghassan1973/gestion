package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.Region;
import com.mypackage.gestion2.service.RegionService;
import com.mypackage.gestion2.repo.RegionRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class RegionServiceImpl extends BaseServiceImpl<Region> implements RegionService
{
	@Resource
	private RegionRepository regionRepository;

	@Override
	protected BaseRepository<Region> getRepository() {
		return regionRepository;
	}
	
	
}

package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.FamilyTier;
import com.mypackage.gestion2.service.FamilyTierService;
import com.mypackage.gestion2.repo.FamilyTierRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class FamilyTierServiceImpl extends BaseServiceImpl<FamilyTier> implements FamilyTierService
{
	@Resource
	private FamilyTierRepository familyTierRepository;

	@Override
	protected BaseRepository<FamilyTier> getRepository() {
		return familyTierRepository;
	}
	
	
}

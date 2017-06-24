package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.Family;
import com.mypackage.gestion2.service.FamilyService;
import com.mypackage.gestion2.repo.FamilyRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class FamilyServiceImpl extends BaseServiceImpl<Family> implements FamilyService
{
	@Resource
	private FamilyRepository familyRepository;

	@Override
	protected BaseRepository<Family> getRepository() {
		return familyRepository;
	}
	
	
}

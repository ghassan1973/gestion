package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.Reportprojectsupplierout;
import com.mypackage.gestion2.service.ReportprojectsupplieroutService;
import com.mypackage.gestion2.repo.ReportprojectsupplieroutRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class ReportprojectsupplieroutServiceImpl extends BaseServiceImpl<Reportprojectsupplierout> implements ReportprojectsupplieroutService
{
	@Resource
	private ReportprojectsupplieroutRepository ReportprojectsupplieroutRepository;

	@Override
	protected BaseRepository<Reportprojectsupplierout> getRepository() {
		return ReportprojectsupplieroutRepository;
	}
	
	
}

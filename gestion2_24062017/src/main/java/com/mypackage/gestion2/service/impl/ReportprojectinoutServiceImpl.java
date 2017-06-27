package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.Reportprojectinout;
import com.mypackage.gestion2.service.ReportprojectinoutService;
import com.mypackage.gestion2.repo.ReportprojectinoutRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class ReportprojectinoutServiceImpl extends BaseServiceImpl<Reportprojectinout> implements ReportprojectinoutService
{
	@Resource
	private ReportprojectinoutRepository ReportprojectinoutRepository;

	@Override
	protected BaseRepository<Reportprojectinout> getRepository() {
		return ReportprojectinoutRepository;
	}
	
	
}

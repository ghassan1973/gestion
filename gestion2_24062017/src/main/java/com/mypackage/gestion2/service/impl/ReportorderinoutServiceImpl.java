package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.Reportorderinout;
import com.mypackage.gestion2.service.ReportorderinoutService;
import com.mypackage.gestion2.repo.ReportorderinoutRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class ReportorderinoutServiceImpl extends BaseServiceImpl<Reportorderinout> implements ReportorderinoutService
{
	@Resource
	private ReportorderinoutRepository ReportorderinoutRepository;

	@Override
	protected BaseRepository<Reportorderinout> getRepository() {
		return ReportorderinoutRepository;
	}
	
	
}

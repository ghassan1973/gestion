package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.Reportcustomerin;
import com.mypackage.gestion2.service.ReportcustomerinService;
import com.mypackage.gestion2.repo.ReportcustomerinRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class ReportcustomerinServiceImpl extends BaseServiceImpl<Reportcustomerin> implements ReportcustomerinService
{
	@Resource
	private ReportcustomerinRepository ReportcustomerinRepository;

	@Override
	protected BaseRepository<Reportcustomerin> getRepository() {
		return ReportcustomerinRepository;
	}
	
	
}

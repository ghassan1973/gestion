package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.ProjectStatus;
import com.mypackage.gestion2.service.ProjectStatusService;
import com.mypackage.gestion2.repo.ProjectStatusRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class ProjectStatusServiceImpl extends BaseServiceImpl<ProjectStatus> implements ProjectStatusService
{
	@Resource
	private ProjectStatusRepository projectStatusRepository;

	@Override
	protected BaseRepository<ProjectStatus> getRepository() {
		return projectStatusRepository;
	}
	
	
}

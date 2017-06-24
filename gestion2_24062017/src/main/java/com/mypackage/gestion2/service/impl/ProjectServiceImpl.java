package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.Project;
import com.mypackage.gestion2.service.ProjectService;
import com.mypackage.gestion2.repo.ProjectRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class ProjectServiceImpl extends BaseServiceImpl<Project> implements ProjectService
{
	@Resource
	private ProjectRepository projectRepository;

	@Override
	protected BaseRepository<Project> getRepository() {
		return projectRepository;
	}
	
	
}

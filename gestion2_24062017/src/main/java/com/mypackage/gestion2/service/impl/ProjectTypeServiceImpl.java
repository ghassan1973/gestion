package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.ProjectType;
import com.mypackage.gestion2.service.ProjectTypeService;
import com.mypackage.gestion2.repo.ProjectTypeRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class ProjectTypeServiceImpl extends BaseServiceImpl<ProjectType> implements ProjectTypeService
{
	@Resource
	private ProjectTypeRepository projectTypeRepository;

	@Override
	protected BaseRepository<ProjectType> getRepository() {
		return projectTypeRepository;
	}
	
	
}

package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.Permission;
import com.mypackage.gestion2.service.PermissionService;
import com.mypackage.gestion2.repo.PermissionRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService
{
	@Resource
	private PermissionRepository permissionRepository;

	@Override
	protected BaseRepository<Permission> getRepository() {
		return permissionRepository;
	}
	
	
}

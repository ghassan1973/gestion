package com.mypackage.gestion2.service.impl;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.mypackage.gestion2.model.Role;
import com.mypackage.gestion2.service.RoleService;
import com.mypackage.gestion2.repo.RoleRepository;
import com.mypackage.gestion2.repo.BaseRepository;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService
{
	@Resource
	private RoleRepository roleRepository;

	@Override
	protected BaseRepository<Role> getRepository() {
		return roleRepository;
	}
	
	
}

package com.mypackage.gestion2.service.impl;

import com.mypackage.gestion2.service.BaseService;
import com.mypackage.gestion2.repo.BaseRepository;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.web.command.SearchCommand;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	protected abstract BaseRepository<T> getRepository();
	
	@Transactional
	@Override
	public T saveDomain(T command) {
		return getRepository().saveDomain(command);
	}
	
	@Transactional
	@Override
	public Page<T> getAll(int page, int size) {
		return getRepository().getAll(page, size);
	}

	@Transactional
	@Override
	public List<T> listAll() {
		return getRepository().listAll();
	}
	
	@Transactional
	@Override
	public T getOne(Long id) {
		return getRepository().getOne(id);
	}

	@Transactional
	@Override
	public void deleteDomain(Long id) {
		getRepository().deleteDomain(id);
	}

	@Transactional
	@Override
	public Page<T> search(SearchCommand searchCommand) {
		return getRepository().search(searchCommand);
	}

	@Override
	public Long countAll() {
		return getRepository().countAll();
	}
}

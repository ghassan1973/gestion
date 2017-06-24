package com.mypackage.gestion2.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypackage.gestion2.service.BaseService;
import com.mypackage.gestion2.paging.Page;

public abstract class BaseRestController<T> {

	public Page<T> getAll(int page, int size) {
		return getService().getAll(page, size);
	}

	public T getOne(Long id) {
		return getService().getOne(id);
	}

	public T createDomain(T command, HttpServletRequest httpRequest, HttpServletResponse response) {
		return getService().saveDomain(command);
	}

	protected abstract BaseService<T> getService();

}

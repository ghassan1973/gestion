package com.mypackage.gestion2.repo.impl;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.mypackage.gestion2.paging.Page;

import com.mypackage.gestion2.repo.BaseRepository;
import com.mypackage.gestion2.web.command.SearchCommand;

import java.util.List;

public abstract class BaseRepositoryImpl<T> implements BaseRepository<T> {

	@Resource
	protected SessionFactory sessionFactory;

	@Override
	public T saveDomain(T command) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(command);
		return command;
	}

	public Long countAll(){
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());
		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		return rowCount;
	}

	@Override
	public List<T> listAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		return criteria.list();
	}
	
	@Override
	public Page<T> getAll(int page, int size) {
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		int startRow = page * size;
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(size);

		Criteria countCriteria = currentSession.createCriteria(getEntityClass());
		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<T> pageImpl = new Page<T>(page,criteria.list(), rowCount.intValue(),size);
		return pageImpl;
	}

	@Override
	public T getOne(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Object object = currentSession.get(getEntityClass(), (Long) id);
		return (T) object;
	}

	@Override
	public void deleteDomain(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Object object = currentSession.get(getEntityClass(), (Long) id);
		currentSession.delete(object);
	}
	
	@Override
	public Page<T> search(SearchCommand searchCommand) {
		return getAll(searchCommand.getPage(), searchCommand.getSize());
	}
	
	protected abstract Class getEntityClass();

}

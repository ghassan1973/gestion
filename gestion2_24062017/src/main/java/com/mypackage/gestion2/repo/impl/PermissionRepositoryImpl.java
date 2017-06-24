package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.Permission;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.PermissionRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.PermissionSearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class PermissionRepositoryImpl extends BaseRepositoryImpl<Permission> implements PermissionRepository 
{
	@Override
	protected Class getEntityClass() {
		return Permission.class;
	}	

	@Override
	public Page<Permission> search(SearchCommand searchCommand) {
		PermissionSearchCommand command = (PermissionSearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getPermissionName() != null){
			criteria.add(Restrictions.like("permissionName","%" + command.getPermissionName() + "%"));
		}

		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<Permission> pageImpl = new Page<Permission>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

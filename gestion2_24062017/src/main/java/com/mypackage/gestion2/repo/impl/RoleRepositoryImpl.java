package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.Role;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.RoleRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.RoleSearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl extends BaseRepositoryImpl<Role> implements RoleRepository 
{
	@Override
	protected Class getEntityClass() {
		return Role.class;
	}	

	@Override
	public Page<Role> search(SearchCommand searchCommand) {
		RoleSearchCommand command = (RoleSearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getRoleName() != null){
			criteria.add(Restrictions.like("roleName","%" + command.getRoleName() + "%"));
		}

		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<Role> pageImpl = new Page<Role>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

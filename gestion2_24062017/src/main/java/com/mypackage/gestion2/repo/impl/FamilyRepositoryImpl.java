package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.Family;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.FamilyRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.FamilySearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class FamilyRepositoryImpl extends BaseRepositoryImpl<Family> implements FamilyRepository 
{
	@Override
	protected Class getEntityClass() {
		return Family.class;
	}	

	@Override
	public Page<Family> search(SearchCommand searchCommand) {
		FamilySearchCommand command = (FamilySearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getFamilyName() != null){
			criteria.add(Restrictions.like("familyName","%" + command.getFamilyName() + "%"));
		}

		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<Family> pageImpl = new Page<Family>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.FamilyTier;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.FamilyTierRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.FamilyTierSearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class FamilyTierRepositoryImpl extends BaseRepositoryImpl<FamilyTier> implements FamilyTierRepository 
{
	@Override
	protected Class getEntityClass() {
		return FamilyTier.class;
	}	

	@Override
	public Page<FamilyTier> search(SearchCommand searchCommand) {
		FamilyTierSearchCommand command = (FamilyTierSearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getFamilyTierName() != null){
			criteria.add(Restrictions.like("familyTierName","%" + command.getFamilyTierName() + "%"));
		}

		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<FamilyTier> pageImpl = new Page<FamilyTier>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

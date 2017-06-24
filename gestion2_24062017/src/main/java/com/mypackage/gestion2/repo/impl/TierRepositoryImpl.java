package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.Tier;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.TierRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.TierSearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class TierRepositoryImpl extends BaseRepositoryImpl<Tier> implements TierRepository 
{
	@Override
	protected Class getEntityClass() {
		return Tier.class;
	}	

	@Override
	public Page<Tier> search(SearchCommand searchCommand) {
		TierSearchCommand command = (TierSearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getTierName() != null){
			criteria.add(Restrictions.like("tierName","%" + command.getTierName() + "%"));
		}
		if (command.getType() != null){
			criteria.add(Restrictions.like("type","%" + command.getType() + "%"));
		}

		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<Tier> pageImpl = new Page<Tier>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

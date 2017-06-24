package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.Region;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.RegionRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.RegionSearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class RegionRepositoryImpl extends BaseRepositoryImpl<Region> implements RegionRepository 
{
	@Override
	protected Class getEntityClass() {
		return Region.class;
	}	

	@Override
	public Page<Region> search(SearchCommand searchCommand) {
		RegionSearchCommand command = (RegionSearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getRegionName() != null){
			criteria.add(Restrictions.like("regionName","%" + command.getRegionName() + "%"));
		}

		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<Region> pageImpl = new Page<Region>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

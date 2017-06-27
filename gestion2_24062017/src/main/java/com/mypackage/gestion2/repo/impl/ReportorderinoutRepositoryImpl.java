package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.Reportorderinout;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.ReportorderinoutRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.ReportorderinoutSearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ReportorderinoutRepositoryImpl extends BaseRepositoryImpl<Reportorderinout> implements ReportorderinoutRepository 
{
	@Override
	protected Class getEntityClass() {
		return Reportorderinout.class;
	}	

	@Override
	public Page<Reportorderinout> search(SearchCommand searchCommand) {
		ReportorderinoutSearchCommand command = (ReportorderinoutSearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getProjectName() != null){
			criteria.add(Restrictions.like("projectName","%" + command.getProjectName() + "%"));
		}
		if (command.getInOut() != null){
			criteria.add(Restrictions.like("inOut","%" + command.getInOut() + "%"));
		}
		if (command.getTierName() != null){
			criteria.add(Restrictions.like("tierName","%" + command.getTierName() + "%"));
		}
		if (command.getOrderName() != null){
			criteria.add(Restrictions.like("orderName","%" + command.getOrderName() + "%"));
		}

		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<Reportorderinout> pageImpl = new Page<Reportorderinout>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

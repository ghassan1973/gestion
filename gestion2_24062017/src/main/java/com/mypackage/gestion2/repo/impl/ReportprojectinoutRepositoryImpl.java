package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.Reportprojectinout;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.ReportprojectinoutRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.ReportprojectinoutSearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ReportprojectinoutRepositoryImpl extends BaseRepositoryImpl<Reportprojectinout> implements ReportprojectinoutRepository 
{
	@Override
	protected Class getEntityClass() {
		return Reportprojectinout.class;
	}	

	@Override
	public Page<Reportprojectinout> search(SearchCommand searchCommand) {
		ReportprojectinoutSearchCommand command = (ReportprojectinoutSearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getProjectName() != null){
			criteria.add(Restrictions.like("projectName","%" + command.getProjectName() + "%"));
		}
		if (command.getInOut() != null){
			criteria.add(Restrictions.like("inOut","%" + command.getInOut() + "%"));
		}


		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<Reportprojectinout> pageImpl = new Page<Reportprojectinout>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.Reportprojectsupplierout;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.ReportprojectsupplieroutRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.ReportprojectsupplieroutSearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ReportprojectsupplieroutRepositoryImpl extends BaseRepositoryImpl<Reportprojectsupplierout> implements ReportprojectsupplieroutRepository 
{
	@Override
	protected Class getEntityClass() {
		return Reportprojectsupplierout.class;
	}	

	@Override
	public Page<Reportprojectsupplierout> search(SearchCommand searchCommand) {
		ReportprojectsupplieroutSearchCommand command = (ReportprojectsupplieroutSearchCommand) searchCommand;

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
		Page<Reportprojectsupplierout> pageImpl = new Page<Reportprojectsupplierout>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

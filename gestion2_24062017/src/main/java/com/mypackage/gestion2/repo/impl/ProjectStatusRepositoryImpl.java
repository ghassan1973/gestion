package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.ProjectStatus;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.ProjectStatusRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.ProjectStatusSearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectStatusRepositoryImpl extends BaseRepositoryImpl<ProjectStatus> implements ProjectStatusRepository 
{
	@Override
	protected Class getEntityClass() {
		return ProjectStatus.class;
	}	

	@Override
	public Page<ProjectStatus> search(SearchCommand searchCommand) {
		ProjectStatusSearchCommand command = (ProjectStatusSearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getProjectStatusName() != null){
			criteria.add(Restrictions.like("projectStatusName","%" + command.getProjectStatusName() + "%"));
		}

		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<ProjectStatus> pageImpl = new Page<ProjectStatus>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

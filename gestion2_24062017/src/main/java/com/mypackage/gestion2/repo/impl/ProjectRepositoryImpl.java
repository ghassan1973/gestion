package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.Project;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.ProjectRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.ProjectSearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepositoryImpl extends BaseRepositoryImpl<Project> implements ProjectRepository 
{
	@Override
	protected Class getEntityClass() {
		return Project.class;
	}	

	@Override
	public Page<Project> search(SearchCommand searchCommand) {
		ProjectSearchCommand command = (ProjectSearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getProjectName() != null){
			criteria.add(Restrictions.like("projectName","%" + command.getProjectName() + "%"));
		}

		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<Project> pageImpl = new Page<Project>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.ProjectType;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.ProjectTypeRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.ProjectTypeSearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectTypeRepositoryImpl extends BaseRepositoryImpl<ProjectType> implements ProjectTypeRepository 
{
	@Override
	protected Class getEntityClass() {
		return ProjectType.class;
	}	

	@Override
	public Page<ProjectType> search(SearchCommand searchCommand) {
		ProjectTypeSearchCommand command = (ProjectTypeSearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getProjectTypeName() != null){
			criteria.add(Restrictions.like("projectTypeName","%" + command.getProjectTypeName() + "%"));
		}

		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<ProjectType> pageImpl = new Page<ProjectType>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

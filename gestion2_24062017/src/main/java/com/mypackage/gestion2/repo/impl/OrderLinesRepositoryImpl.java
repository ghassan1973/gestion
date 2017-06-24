package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.OrderLines;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.OrderLinesRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.OrderLinesSearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class OrderLinesRepositoryImpl extends BaseRepositoryImpl<OrderLines> implements OrderLinesRepository 
{
	@Override
	protected Class getEntityClass() {
		return OrderLines.class;
	}	

	@Override
	public Page<OrderLines> search(SearchCommand searchCommand) {
		OrderLinesSearchCommand command = (OrderLinesSearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getOrderLinesName() != null){
			criteria.add(Restrictions.like("orderLinesName","%" + command.getOrderLinesName() + "%"));
		}

		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<OrderLines> pageImpl = new Page<OrderLines>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

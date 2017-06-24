package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.Order;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.OrderRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.OrderSearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl extends BaseRepositoryImpl<Order> implements OrderRepository 
{
	@Override
	protected Class getEntityClass() {
		return Order.class;
	}	

	@Override
	public Page<Order> search(SearchCommand searchCommand) {
		OrderSearchCommand command = (OrderSearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getOrderName() != null){
			criteria.add(Restrictions.like("orderName","%" + command.getOrderName() + "%"));
		}

		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<Order> pageImpl = new Page<Order>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

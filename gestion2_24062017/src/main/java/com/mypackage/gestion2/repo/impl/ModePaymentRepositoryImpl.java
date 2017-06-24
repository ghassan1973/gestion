package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.ModePayment;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.ModePaymentRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.ModePaymentSearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ModePaymentRepositoryImpl extends BaseRepositoryImpl<ModePayment> implements ModePaymentRepository 
{
	@Override
	protected Class getEntityClass() {
		return ModePayment.class;
	}	

	@Override
	public Page<ModePayment> search(SearchCommand searchCommand) {
		ModePaymentSearchCommand command = (ModePaymentSearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getModePaymentName() != null){
			criteria.add(Restrictions.like("modePaymentName","%" + command.getModePaymentName() + "%"));
		}

		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<ModePayment> pageImpl = new Page<ModePayment>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

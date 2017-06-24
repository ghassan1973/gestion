package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.Transaction;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.TransactionRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.TransactionSearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepositoryImpl extends BaseRepositoryImpl<Transaction> implements TransactionRepository 
{
	@Override
	protected Class getEntityClass() {
		return Transaction.class;
	}	

	@Override
	public Page<Transaction> search(SearchCommand searchCommand) {
		TransactionSearchCommand command = (TransactionSearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getTransactionName() != null){
			criteria.add(Restrictions.like("transactionName","%" + command.getTransactionName() + "%"));
		}

		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<Transaction> pageImpl = new Page<Transaction>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.Currency;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.CurrencyRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.CurrencySearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CurrencyRepositoryImpl extends BaseRepositoryImpl<Currency> implements CurrencyRepository 
{
	@Override
	protected Class getEntityClass() {
		return Currency.class;
	}	

	@Override
	public Page<Currency> search(SearchCommand searchCommand) {
		CurrencySearchCommand command = (CurrencySearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getCurrencyName() != null){
			criteria.add(Restrictions.like("currencyName","%" + command.getCurrencyName() + "%"));
		}

		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<Currency> pageImpl = new Page<Currency>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

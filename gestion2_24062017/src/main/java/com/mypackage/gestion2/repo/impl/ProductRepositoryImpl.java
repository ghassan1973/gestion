package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.Product;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.ProductRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.ProductSearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl extends BaseRepositoryImpl<Product> implements ProductRepository 
{
	@Override
	protected Class getEntityClass() {
		return Product.class;
	}	

	@Override
	public Page<Product> search(SearchCommand searchCommand) {
		ProductSearchCommand command = (ProductSearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getProductName() != null){
			criteria.add(Restrictions.like("productName","%" + command.getProductName() + "%"));
		}

		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<Product> pageImpl = new Page<Product>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}
}

package com.mypackage.gestion2.repo.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mypackage.gestion2.model.ForgotPasswordRequest;
import com.mypackage.gestion2.model.User;
import com.mypackage.gestion2.repo.ForgotPasswordRequestRepository;

@Repository
public class ForgotPasswordRequestRepositoryImpl extends BaseRepositoryImpl<ForgotPasswordRequest>
		implements ForgotPasswordRequestRepository {
	@Override
	protected Class<ForgotPasswordRequest> getEntityClass() {
		return ForgotPasswordRequest.class;
	}

	public ForgotPasswordRequest findByToken(String token){
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		criteria.add(Restrictions.eq("token", token));
		List list = criteria.list();
		if (list == null || list.isEmpty())
			throw new RuntimeException("Invalid token");

		if (list.size() > 1) {
			throw new RuntimeException("Too may matches");
		}
		
		return ((ForgotPasswordRequest) list.get(0));
	}
	

}

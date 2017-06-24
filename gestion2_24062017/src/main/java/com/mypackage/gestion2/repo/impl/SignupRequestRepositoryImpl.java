package com.mypackage.gestion2.repo.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mypackage.gestion2.model.SignupRequest;
import com.mypackage.gestion2.repo.SignupRequestRepository;

@Repository
public class SignupRequestRepositoryImpl extends BaseRepositoryImpl<SignupRequest> implements SignupRequestRepository {
	@Override
	protected Class<SignupRequest> getEntityClass() {
		return SignupRequest.class;
	}

	@Override
	public SignupRequest findByToken(String token) {
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		criteria.add(Restrictions.eq("token", token));
		List list = criteria.list();
		if (list == null || list.isEmpty())
			throw new RuntimeException("Invalid token");

		if (list.size() > 1) {
			throw new RuntimeException("Too may matches");
		}

		return ((SignupRequest) list.get(0));
	}
}

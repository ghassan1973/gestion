package com.mypackage.gestion2.repo.impl;

import com.mypackage.gestion2.model.User;
import com.mypackage.gestion2.paging.Page;
import com.mypackage.gestion2.repo.UserRepository;
import com.mypackage.gestion2.web.command.SearchCommand;
import com.mypackage.gestion2.web.command.UserSearchCommand;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@Repository("userDetailsService")
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository,UserDetailsService
{
	@Override
	protected Class getEntityClass() {
		return User.class;
	}	

	@Override
	public Page<User> search(SearchCommand searchCommand) {
		UserSearchCommand command = (UserSearchCommand) searchCommand;

		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		Criteria countCriteria = currentSession.createCriteria(getEntityClass());

		if (command.getFirstName() != null){
			criteria.add(Restrictions.like("firstName","%" + command.getFirstName() + "%"));
		}
		if (command.getLastName() != null){
			criteria.add(Restrictions.like("lastName","%" + command.getLastName() + "%"));
		}
		if (command.getEmail() != null){
			criteria.add(Restrictions.like("email","%" + command.getEmail() + "%"));
		}

		int startRow = command.getPage() * command.getSize();
		criteria.setFirstResult(startRow);
		criteria.setMaxResults(command.getSize());

		countCriteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) countCriteria.uniqueResult();
		Page<User> pageImpl = new Page<User>(command.getPage(), criteria.list(), rowCount.intValue(),
				command.getSize());
		return pageImpl;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(getEntityClass());
		criteria.add(Restrictions.eq("email", username));
		List list = criteria.list();
		if(list.isEmpty())
			throw new UsernameNotFoundException("User not found");
		if(list.size() >1 )
			throw new UsernameNotFoundException("Multiple user found");
		return (UserDetails) list.get(0);
	}

    @Override
    public User findByEmail(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        Criteria criteria = currentSession.createCriteria(getEntityClass());
        criteria.add(Restrictions.eq("email", email));
        List list = criteria.list();

        if(list.isEmpty())
            return null;
        if(list.size() >1 )
            return null;

        return (User) list.get(0);
    }
}

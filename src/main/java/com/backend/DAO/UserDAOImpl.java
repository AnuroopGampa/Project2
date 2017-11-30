package com.backend.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.backend.model.UserDetails;

public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserDAO userDAO;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

@Transactional
	
	public boolean addUserDetails(UserDetails user) {
		// TODO Auto-generated method stub

		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:" +e);
			return false;
		}	
	}

	@Override
	public boolean updateOnlineStatus(String status, UserDetails user) {
		// TODO Auto-generated method stub
		try
		{
			user.setIsOnine(status);
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured:" +e);
			return false;
		}
	}

	@Override
	public List<UserDetails> getAllUserDetails() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		List<UserDetails> user=(List<UserDetails>)session.createQuery("from UserDetails").list();
		session.close();
		return user;
	}

	@Override
	public UserDetails getUserDetails(String username) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		UserDetails user=(UserDetails)session.get(UserDetails.class,username);
		session.close();
		return user;
	}

}

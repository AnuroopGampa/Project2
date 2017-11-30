package com.backend.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.backend.model.Forum;

public class ForumDAOImpl implements ForumDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	ForumDAO forumDAO;
	
	public ForumDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public boolean addForum(Forum forum) {
		// TODO Auto-generated method stub
		 Session session=sessionFactory.openSession();
         session.save(forum);
/*		session.flush();*/	
	session.close();
		try
		{
		sessionFactory.getCurrentSession().save(forum);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}	
	}

	public boolean updateForum(Forum forum) {
		// TODO Auto-generated method stub
	
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}
	}

	public boolean deleteForum(Forum forum) {
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().delete(forum);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}	
	}

	public Forum getForum(int ForumId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Forum forum=(Forum)session.get(Forum.class, ForumId);
		session.close();
		return forum;
	}

	public List<Forum> getAllForums() {
		// TODO Auto-generated method stub
		  Session session=sessionFactory.openSession();
			
			List<Forum> forumList=(List<Forum>)session.createQuery("from Forum").list();
			session.close();
			return forumList;
	}

	public boolean approveForum(Forum forum) {
		// TODO Auto-generated method stub
		try{
		       forum.setStatus("A");
					sessionFactory.getCurrentSession().saveOrUpdate(forum);
					return true;
					}
					catch(Exception e)
					{
					System.out.println("Exception occured:"+e);
					return false;
					}	
	}

	public boolean rejectForum(Forum forum) {
		// TODO Auto-generated method stub
		try{
			forum.setStatus("N");
			sessionFactory.getCurrentSession().update(forum);
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception occured:"+e);
			return false;
			}	
	}
	}



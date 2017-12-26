package com.backend.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	BlogDAO blogDAO;
	
	public BlogDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean addBlog(Blog blog) {
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().save(blog);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

	@Transactional
	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		try
  		{
 		sessionFactory.getCurrentSession().update(blog);

  		return true;
  		}
  		catch(Exception e)
  		{

 		System.out.println("Exception occured:"+e);
  		return false;
  		}
	}

	@Transactional
	public boolean deleteBlog(Blog blog) {
		// TODO Auto-generated method stub
		try
  		{
 		sessionFactory.getCurrentSession().update(blog);

  		return true;
  		}
  		catch(Exception e)
  		{

 		System.out.println("Exception occured:"+e);
  		return false;
  		}	
	}

	@Transactional
	public Blog getBlog(int blogId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
	 	Blog blog=(Blog)session.get(Blog.class, blogId);
			session.close();
	 		return blog;
	}

	@Transactional
	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
Session session=sessionFactory.openSession();
		
		List<Blog> blogList=session.createQuery("from Blog where status != 'PENDING'").list();
		session.close();
		return blogList;
	}

	@Transactional
	public boolean approveBlog(Blog blog) {
		// TODO Auto-generated method stub
		try{
			blog.setStatus("A");
 				sessionFactory.getCurrentSession().saveOrUpdate(blog);
 				return true;
 		}
 				catch(Exception e)
 				{
 				System.out.println("Exception occured:"+e);
 				return false;
 				}
	}

	@Transactional
	public boolean rejectBlog(Blog blog) {
		// TODO Auto-generated method stub
		try{
			blog.setStatus("N");
 				sessionFactory.getCurrentSession().saveOrUpdate(blog);
 				return true;
 		}
 				catch(Exception e)
 				{
 				System.out.println("Exception occured:"+e);
 				return false;
 				}
	}

	@Transactional
	public List<Blog> getAllBlogs(int userId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		List<Blog> blogList= session.createQuery("from Blog where userId = :userId")
				.setParameter("userId", userId).list();
		
		session.close();
		
		return blogList;
	}

	@Transactional
	public List<Blog> getAllPendingBlogs() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		List<Blog> blogList= session.createQuery("from Blog where status = 'PENDING'").list();
		
		session.close();
		
		return blogList;
	}

	@Transactional
	public List<Blog> getAllApprovedBlog() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		List<Blog> blogList= session.createQuery("from Blog where status = 'APPROVED'").list();
		
		session.close();
		
		return blogList;
	}

	
	}

	

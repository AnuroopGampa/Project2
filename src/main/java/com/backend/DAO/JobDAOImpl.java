package com.backend.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.backend.model.Job;


@Repository("jobDAO")
public class JobDAOImpl implements JobDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	JobDAO jobDAO;
	
	public JobDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean addJob(Job job) {
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().save(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception arised:"+e);
		return false;
		}
	}

	@Override
	public boolean updateJob(Job job) {
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().update(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception arised:"+e);
		return false;
		}	
	}

	@Override
	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		
		@SuppressWarnings("unchecked")
		List<Job> jobList=(List<Job>)session.createQuery("from Job").list();
		session.close();
		return jobList;
	}

	@Override
	public Job getJob(int jobId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Job job=(Job)session.get(Job.class, jobId);
		session.close();
		return job;
	}

	@Override
	public boolean deleteJob(Job job) {
		// TODO Auto-generated method stub
	
		try
		{
		sessionFactory.getCurrentSession().delete(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception arised:"+e);
		return false;
		}
	}

}

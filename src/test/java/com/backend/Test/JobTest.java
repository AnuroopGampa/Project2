package com.backend.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.backend.DAO.JobDAO;
import com.backend.config.DbConfig;
import com.backend.model.Job;

@ComponentScan("com.backend")
@Ignore
public class JobTest {

static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DbConfig.class);
		context.scan("com.backend");
         context.refresh();
		
		jobDAO=(JobDAO)context.getBean("jobDAO");
	}
	
@Ignore
	@Test
	public void addJobTest(){
		Job job=new Job();
		job.setJobId(12);
		job.setJobProfile("Software");
		job.setJobDesc("Process ASsociate");
		job.setQualification("M.SC/M.E");
		job.setStatus("Eligible");
		job.setPostDate(new java.util.Date());
		
		assertTrue("Problems in Inserting Job",jobDAO.addJob(job));
	}
	

@Test
public void getAllJobTest(){
	List<Job> jobList=(List<Job>)jobDAO.getAllJobs();
	assertNotNull("Job list not found ",jobList.get(0));
	for(Job job:jobList)
	{
		System.out.println("JobID:"+ job.getJobId() + "JobProfile:"+ job.getJobProfile());
	}
}
@Test
public void getJobTest(){

	Job job=(Job)jobDAO.getJob(11);
	
	System.out.println("JobProfile:" + job.getJobProfile());
	System.out.println("JobDescription:" + job.getJobDesc());
	
	assertNotNull("Job not found", job);
}
	
}
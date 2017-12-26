package com.backend.restcontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.DAO.JobDAO;
import com.backend.model.Job;

@RestController
public class JobController {
	@Autowired 
	JobDAO jobDAO;
	
	@PostMapping(value="/insertJob")
	public ResponseEntity<String> insertJob(@RequestBody Job job)
	{
		if(jobDAO.addJob(job))
		{
			return new ResponseEntity<String>("Job Added",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
		}

	
	
	
	@RequestMapping(value="/getAllJobs")
	public ResponseEntity<ArrayList<Job>> getAllJobs()
	{
		ArrayList listJobs = (ArrayList)jobDAO.getAllJobs();
		return new ResponseEntity<ArrayList<Job>>(listJobs,HttpStatus.OK);
	}
	
	@RequestMapping(value = "deleteJob")
	public ResponseEntity<String> deleteJob(@RequestBody Job job)
	{
		Job tempjob=jobDAO.getJob(job.getJobId());
		if(jobDAO.deleteJob(tempjob))
		{
			return new ResponseEntity<String>("Job Deleted",HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>("Error in Job deletion",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}


	@PostMapping(value="/updateJob")
	public ResponseEntity<String> updateJob(@RequestBody Job job)
	{
		Job tempJob=jobDAO.getJob(job.getJobId());
		
		tempJob.setJobDesc(job.getJobDesc());
		tempJob.setJobProfile(job.getJobProfile());
		
		if(jobDAO.updateJob(tempJob))
		{
			return new ResponseEntity<String>("JOb Added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("problem in updating job",HttpStatus.SERVICE_UNAVAILABLE);
		}
		
	}

	
}
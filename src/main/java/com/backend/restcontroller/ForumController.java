/*package com.backend.restcontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.DAO.ForumDAO;
import com.backend.model.Forum;

@RestController
public class ForumController {
	@Autowired 
	ForumDAO forumDAO;
	
	@PostMapping(value="/insertForum")
	public ResponseEntity<String> insertBlog(@RequestBody Forum forum)
	{
		if(forumDAO.addForum(forum))
		{
			return new ResponseEntity<String>("Forum Added",HttpStatus.OK);
		
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
		}
	
	@PostMapping(value="/updateForum")
	public ResponseEntity<String> updateBlog(@RequestBody Forum forum)
	{
		if(forumDAO.updateForum(forum))
		{
			return new ResponseEntity<String>("Forum Added",HttpStatus.OK);
		
		}
		else
		{
			return new ResponseEntity<String>("Error in Response Entity",HttpStatus.SERVICE_UNAVAILABLE);
		}
		}

	@GetMapping(value="/getAllForums")
	public ResponseEntity<ArrayList<Forum>> getAllForums()
	{
		ArrayList listForums=(ArrayList)forumDAO.getAllForums();
		return new ResponseEntity<ArrayList<Forum>>(listForums,HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@PostMapping(value="/deleteForum")
	public ResponseEntity<String> deleteForum(@RequestBody Forum forum)
	{
		Forum tempforum=forumDAO.getForum(forum.getForumId());
		
		if(forumDAO.deleteForum(tempforum))
		{
			return new ResponseEntity<String>("Forum deleted",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error in Forum deletion",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
}
*/
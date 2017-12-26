package com.backend.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.DAO.UserDAO;
import com.backend.model.UserDetails;

@RestController

public class UserDetailController {
	@Autowired 
	UserDAO userDAO;
	
	
	@RequestMapping(value="/getAllUsers",method=RequestMethod.GET,headers="Accept=application/json")
	public List <UserDetails> getAllUser(){
		return userDAO.getAllUsers();
	}
	
	@PostMapping(value="/register")
	public ResponseEntity<?> registerUser(@RequestBody UserDetails userDetail){

		userDetail.setRole("user");
		if(userDAO.saveUser(userDetail))
		{
			
			return new ResponseEntity<UserDetails>(userDetail,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in registration",HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	@PostMapping("/login")
	public ResponseEntity<UserDetails> loginStatus(@RequestBody UserDetails userDetail)
	{
		userDetail=userDAO.getUserByEmail(userDetail.getEmail());
		if((userDetail==null))
		{
			userDetail=new UserDetails();
			System.out.println("user email invalid");
		}
		else
		{
			System.out.println("login user");
		}
		return new ResponseEntity<UserDetails>(userDetail,HttpStatus.OK);
	}
}
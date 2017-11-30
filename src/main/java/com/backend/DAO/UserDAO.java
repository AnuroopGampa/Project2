package com.backend.DAO;

import java.util.List;

import com.backend.model.UserDetails;

public interface UserDAO {
	public boolean addUserDetails(UserDetails user);
	public boolean updateOnlineStatus(String status, UserDetails user);
/*	public UserDetail getUserDetail(String username);*/
	public List<UserDetails> getAllUserDetails();
	public UserDetails getUserDetails(String username);
}

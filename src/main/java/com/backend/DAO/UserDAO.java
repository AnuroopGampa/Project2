package com.backend.DAO;

import java.util.List;

import com.backend.model.UserDetails;

public interface UserDAO {
	
public boolean saveUser(UserDetails user);
	
	public boolean updateUser(UserDetails user);
	
	public boolean deleteUser(int id);
	
	public UserDetails getUserById(int userId);
	
	public UserDetails getUserByEmail(String email);
	
	public UserDetails getUserByName(String name);
	
	public List<UserDetails> getAllUsers();

	public boolean checkIfExistingUser(UserDetails user);

	public boolean checkIfValidUser(String username, String password);

}

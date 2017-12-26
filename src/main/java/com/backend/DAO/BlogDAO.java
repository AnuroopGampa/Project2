package com.backend.DAO;

import java.util.List;

import com.backend.model.Blog;

public interface BlogDAO {
   
public boolean addBlog(Blog blog);
	
	public boolean updateBlog(Blog blog);
	
	public boolean deleteBlog(Blog blog);
	
	public Blog getBlog(int blogId);
	
	public List<Blog> getAllBlogs();
	
	public boolean approveBlog(Blog blog);
	
	public boolean rejectBlog(Blog blog);
	
	public List<Blog> getAllBlogs(int userId);
    
	public List<Blog> getAllPendingBlogs();
	
	public List<Blog> getAllApprovedBlog();
}

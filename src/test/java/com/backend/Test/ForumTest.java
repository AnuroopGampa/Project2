package com.backend.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.backend.DAO.ForumDAO;
import com.backend.config.DbConfig;
import com.backend.model.Forum;


@ComponentScan("com.backend")
@Ignore
public class ForumTest {

	@Autowired
	private static ForumDAO  forumDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DbConfig.class);
		context.scan("com.backend.*");
		context.refresh();
		
		forumDAO=(ForumDAO)context.getBean("forumDAO");
	}
	
	@Ignore
	@Test
	public void addForumTest()
	{
		Forum forum=new Forum();
		//forum.setForumId(104);
		forum.setForumName("Quora");
		forum.setForumContent("Everthing You need");
		forum.setUserId(8);
		forum.setStatus("A");
		forum.setCreateDate(new java.util.Date());
		
		assertTrue("Problem in Inserting forum", forumDAO.addForum(forum));
	}
	
	@Ignore
	@Test
 	public void getForumTest()
 	{
 		Forum forum=(Forum)forumDAO.getForum(3);
		System.out.println("ForumName:" + forum.getForumName());
		System.out.println("ForumContent:" + forum.getForumContent());
		assertNotNull("forum not found", forum);
 	}
	
	@Ignore
	@Test
 	public void updateForumTest()
 	{
		Forum forum=(Forum)forumDAO.getForum(3);
		forum.setForumName("StackOverflow");
 		forum.setUserId(5);
 		assertTrue("Problem in updating Forum",forumDAO.updateForum(forum));
 	}
	
	@Ignore
	@Test
	public void deleteForumTest()
 	{
		Forum forum=(Forum)forumDAO.getForum(3);
		assertTrue("Problem in deletion",forumDAO.deleteForum(forum));
	}
	
	@Ignore
	@Test
	public void approveForumTest()
	{
		Forum forum=(Forum)forumDAO.getForum(4);
		assertTrue("Problem in approving",forumDAO.approveForum(forum));
	}
	
	@Ignore
	@Test
	public void getAllForumsTest()
	{
		List<Forum> forumList=(List<Forum>)forumDAO.getAllForums();
		assertNotNull("Forum list not found ",forumList.get(0));
		for(Forum forum:forumList)
		{
			System.out.println("ForumID:"+forum.getForumId() + "ForumName:"+forum.getForumName());
		}
	}
}

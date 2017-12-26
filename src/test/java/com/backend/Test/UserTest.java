package com.backend.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.backend.DAO.UserDAO;
import com.backend.config.DbConfig;
import com.backend.model.UserDetails;

@ComponentScan("com.backend")
@Ignore
public class UserTest {

	@Autowired
	private static UserDAO  userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DbConfig.class);
		context.scan("com.backend.*");
		context.refresh();

		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	
	@Test
	public void addUserTest()
	{
		UserDetails user=new UserDetails();
		user.setUserdId(14);
		user.setFirstName("Anuroop");
		user.setLastName("Gampa");
		user.setEmailId("anurop@gmail.com");
		user.setPassword("12345");
		user.setRole("User");
		user.setStatus("P");
		user.setIsOnine("O");
		assertTrue("Problem in Inserting user", userDAO.addUserDetails(user));

	}

	@Ignore
	@Test
	public void getAllUserTest()
	{
		List<UserDetails> userList=(List<UserDetails>)userDAO.getAllUserDetails();
		assertNotNull("Job list not found ",userList.get(0));
		for(UserDetails user:userList)
		{
			System.out.println("EmailID:"+ user.getEmailId() + "Status:"+ user.getStatus());
		}
	}
}

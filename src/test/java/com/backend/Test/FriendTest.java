package com.backend.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.backend.DAO.FriendDAO;
import com.backend.config.DbConfig;
import com.backend.model.Friend;

@ComponentScan("com.backend")

public class FriendTest {

    static FriendDAO  friendDAO;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DbConfig.class);
		context.scan("com.backend.*");
		context.refresh();

	    friendDAO=(FriendDAO)context.getBean("friendDAO");
	}

	
	@Test
	public void saveFriend() {
		Friend friend = new Friend();
		//friend.setFriendId(3);
		friend.setFriendname("anuroop");
		friend.setUsername("roop");
		friend.setStatus("R");
		assertTrue("problem in friend", friendDAO.createFriend(friend));
	}

	@Ignore
	@Test
	public void getAllFriendRequest() {
		List<Friend> listFriends = friendDAO.getAllFriendRequest("anuroop");
		assertNotNull("problem in list friends", listFriends);
		for (Friend friend : listFriends) {
			System.out.println("current username:::" + friend.getUsername());
			System.out.println("friend name::::" + friend.getFriendname());
			System.out.println("status::::" + friend.getStatus());
		}

	}

	@Ignore
	@Test
	public void getFriendId() {
		Friend friend = (Friend) friendDAO.getFriend(3);
		assertNotNull("error", friend);
		System.out.println("friend status::::" + friend.getStatus());
	}
	@Ignore
	@Test
	public void getAllApprovedFriendTest() {
		List<Friend> listFriends = friendDAO.getApprovedFriends("Anuroop");
		assertNotNull("problem in listFriends", listFriends);
		for (Friend friend : listFriends) {
			System.out.println("current user name:::" + friend.getUsername());
			System.out.println("current friend name:" + friend.getFriendname());
			System.out.println("status:::" + friend.getStatus());
		}
	}
	@Ignore
	@Test
	public void approveFriendRequest()
	{
		Friend friend=friendDAO.getFriend(1);
		assertTrue("problem in approving",friendDAO.approveFriendRequest(friend));
	}
	@Ignore
	@Test
	public void rejectFriendRequest()
	{
		Friend friend=friendDAO.getFriend(5);
		assertTrue("problem in approving",friendDAO.rejectFriendRequest(friend));
	}
}

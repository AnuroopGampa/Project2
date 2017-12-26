package com.backend.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.backend.model.Friend;
@Repository("friendDAO")
public class FriendDAOImpl implements FriendDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	FriendDAO friendDAO;
	
	public FriendDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Transactional
	//@Override
	public boolean createFriend(Friend friend) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised " + e);
			return false;
		}
	}

	@Transactional
	@Override
	public List<Friend> getAllFriendRequest(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Friend where username=:username");
		query.setParameter("username", username);
		List<Friend> listFriends = query.list();
		return listFriends;
	}

	@Transactional
	@Override
	public List<Friend> getApprovedFriends(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Friend where username=:username and status='A'");
		query.setParameter("username", username);
		List<Friend> listFriends = query.list();
		return listFriends;
	}

	@Transactional
	@Override
	public Friend getFriend(int friendId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Friend friend = (Friend) session.get(Friend.class, friendId);
		return friend;
	}

	@Transactional
	@Override
	public boolean rejectFriendRequest(Friend friend) {
		// TODO Auto-generated method stub
		try {
			friend.setStatus("R");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
			return false;
		}
	}

	@Transactional
	@Override
	public boolean approveFriendRequest(Friend friend) {
		// TODO Auto-generated method stub
		try {
			friend.setStatus("A");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		} catch (Exception e) {
			System.out.println("exception arised" + e);
			return false;
		}
	}
	}



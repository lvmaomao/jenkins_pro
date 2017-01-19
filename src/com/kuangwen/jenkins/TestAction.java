package com.kuangwen.jenkins;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.kuangwen.jenkins.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	
	public String add(){
		System.out.println("add.....");
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = new User();
		user.setAddress("中国");
		user.setPassword("123");
		user.setUsername("匡文");
		session.save(user);
		
//		User userResult = session.get(User.class, "ff80808159b608b20159b608b5f00000");
//		System.out.println(userResult.toString());
//		userResult.setUsername("小框框");
//		session.update(userResult);
//		
//		session.delete(userResult);
		
		 Query query = session.createQuery("from User");
		 List<User> list = query.list();
		 for (User item : list) {
			System.out.println(item);
		}
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		return NONE;
	}
	public String update(){
		System.out.println("update.....");
		return NONE;
	}
}

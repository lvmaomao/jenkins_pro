package com.kuangwen.jenkins;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

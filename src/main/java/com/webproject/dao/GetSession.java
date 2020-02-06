package com.webproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webproject.entity.Student;

public class GetSession {
	private static Session session;
	
	private GetSession() {
		
	}
	
	public static Session get() {
		if ( session == null || !session.isOpen()) {
			SessionFactory factory = new Configuration().
					configure("hibernate.cfg.xml").
					addAnnotatedClass(Student.class).
					buildSessionFactory();
			
			session = factory.getCurrentSession();
			
		}
		
		return session;
	}
}


package com.webproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webproject.entity.Student;


@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class StudentDao implements Dao<Student> {
	
	public StudentDao() {}
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Student get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public List<Student> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		ArrayList<Student> students = new ArrayList<Student>( session.createQuery("FROM Student", Student.class).getResultList() );
		return students;
	}

	@Transactional
	public void persist(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(student);
	}

	@Transactional
	public void update(Student t, String... params) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void delete(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(student);
		
	}
	
}

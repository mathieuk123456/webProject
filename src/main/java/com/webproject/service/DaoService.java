package com.webproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webproject.dao.Dao;

@Service
public class DaoService<T> {
	@Autowired
	private Dao<T> dao;

	public Dao get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> getAll() {
		return this.dao.getAll();
	}

	public void persist(T t) {
		this.dao.persist(t);	
	}

	public void update(Dao dao, String... params) {
		// TODO Auto-generated method stub
	}

	public void delete(T t) {
		this.dao.delete(t);		
	}


	
}



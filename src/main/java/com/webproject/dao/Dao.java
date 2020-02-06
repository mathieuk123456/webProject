package com.webproject.dao;

import java.util.List;

public interface Dao<T> {
	T get(long id);
    
    List<T> getAll();
     
    void persist(T t);
     
    void update(T t, String...params);
     
    void delete(T t);
}

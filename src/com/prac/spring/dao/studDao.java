package com.prac.spring.dao;

import java.util.List;


import com.prac.spring.model.student;

public interface studDao {

	int insert(student s);
	int update(student s);
	int delete(int id);
	List<student> listAll();
  student getbyid(int id);

	
}


package com.prac.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.prac.spring.model.student;

public class studDaoImpl implements studDao{

	String sql;
	JdbcTemplate template;
	

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int insert(student s) {
		// TODO Auto-generated method stub
		
		sql= "insert into stud1(name,city,mobile,email)values(?,?,?,?)";
       return template.update(sql, s.getName(),s.getCity(),s.getMobile(),s.getEmail());
		
	}

	@Override
	public int update(student s) {
		// TODO Auto-generated method stub
		sql="update stud1 set name = ?, city= ?, mobile=?, email =? where id = ?" ;
	return template.update(sql ,s.getName(),s.getCity(),s.getMobile(),s.getEmail(),s.getId());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		
		sql = "delete from stud1 where id = ?";
		
		return template.update(sql, id);
	}

	@Override
	public List<student> listAll() {
		// TODO Auto-generated method stub
		sql = "select * from stud1";
	
		return template.query(sql, new RowMapper<student>() {

			@Override
			public student mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				student st = new student();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setCity(rs.getString(3));
				st.setMobile(rs.getString(4));
				st.setEmail(rs.getString(5));
				
				
				return st;
			}
		});
	}

	@Override
	public student getbyid(int id) {
		sql= "select * from stud1 where id = ?";
		
		
		return template.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<student>(student.class));
		
		
	
		 
		 
	}

	
	
	
}

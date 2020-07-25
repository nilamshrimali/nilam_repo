package com.prac.spring.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import com.prac.spring.dao.studDao;
import com.prac.spring.dao.studDaoImpl;




@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.prac.spring")


public class springMVCconfig implements WebMvcConfigurer{

@Bean
public ViewResolver getviewresolver() {
	
	InternalResourceViewResolver r = new InternalResourceViewResolver();
	r.setPrefix("/WEB-INF/jsp/");
	r.setSuffix(".jsp");
	return r;
	
	
}

	
	  @Bean 
	  public DataSource getDataSource() {
	  
	  DriverManagerDataSource ds = new DriverManagerDataSource();
	  ds.setDriverClassName("com.mysql.jdbc.Driver");
	  ds.setUrl("jdbc:mysql://localhost:3306/student_db?serverTimezone=UTC");
	  ds.setUsername("root"); 
	  ds.setPassword("");
	  return ds; 
	  }
	 


	
	  @Bean 
	  public JdbcTemplate getJdbcTemplate() 
	  { 
		  JdbcTemplate jdbctemplate = new JdbcTemplate();
	  
	  //DataSource ds = getDataSource(); //jdbctemplate.setDataSource(ds);
	                         //or
	  jdbctemplate.setDataSource(getDataSource()); 
	  
	  return jdbctemplate;
	  
	   }
	 
	
	  @Bean 
	  public studDao getstudDao() {
	  
	  studDaoImpl s = new studDaoImpl(); 
	  s.setTemplate(getJdbcTemplate());
	  
	  return s;
	  
	  
	  }
	 

}

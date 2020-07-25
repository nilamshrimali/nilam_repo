package com.prac.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;



public class webAppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		
		
		  AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		  context.register(springMVCconfig.class); 
		  ServletRegistration.Dynamic
		  dispatcher = servletContext.addServlet("SpringDispatcher", new DispatcherServlet(context)); 
		  dispatcher.setLoadOnStartup(1);
		  dispatcher.addMapping("/");
	
		 
		

}
}
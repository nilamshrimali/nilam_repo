
package com.prac.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.protobuf.Method;

import com.prac.spring.dao.studDao;
import com.prac.spring.model.student;

@Controller
public class studController {

	@Autowired
	studDao d;
	
	@RequestMapping("/viewstud")
	public String studdata(Model m) {
	List<student>l = d.listAll();
	m.addAttribute("list" , l);
		return "s_list";
		
		
		
	}
	@RequestMapping("/new")
	public String studnew(Model m) {
		m.addAttribute("command",new student());
		
		return "s_entry";
		
		
	}
	
	@RequestMapping(value ="/edit/{id}", method = RequestMethod.GET)
	public String studedit(@PathVariable int id, Model m) {
		student s = d.getbyid(id);
		m.addAttribute("command" , s);
		
		return "s_entry";
		
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String studdel(@PathVariable int id , Method m) {
		
		 d.delete(id);
		return "redirect:/viewstud";
		
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveform(student s) {
		if(s.getId()==0) {
			
			d.insert(s);
		
	}
		else {
			d.update(s);
		}
	
	return "redirect:/viewstud";
		
		

}
}

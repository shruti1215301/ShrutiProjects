package com.tshirtkart.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.tshirtkart.entities.User;
@Component
public class Authentication {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Transactional(readOnly= false)
	public boolean search(User u1)
	
	{	
		
		
		User u2=(User)hibernateTemplate.get(User.class,u1.getUsername());
			if(u2!=null&& u1.getPassword().equals(u2.getPassword()))
			{
				return true;
			
			}else {
				return false;
			}
			
			
	}
}

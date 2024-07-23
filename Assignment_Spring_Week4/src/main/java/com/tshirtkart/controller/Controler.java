package com.tshirtkart.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tshirtkart.dao.OutputDao;
import com.tshirtkart.entities.User;
import com.tshirtkart.service.Authentication;
import com.tshirtkart.thread.ReadDetails;



@Controller
public class Controler {
@Autowired
Authentication authenticate;
@Autowired
private HibernateTemplate hibernateTemplate;
//	@Autowired
//	private HibernateTemplate hibernateTemplate;
//	@Transactional(readOnly= false)
	@RequestMapping("/check")
	public String validate(HttpServletRequest request,HttpServletResponse response)
	{
		String username=request.getParameter("user");
		String password=request.getParameter("pass");
		System.out.println(username+"user");
		User u1=new User(username,password);
		Session sess=hibernateTemplate.getSessionFactory().openSession();
		HttpSession session=request.getSession();
		session.setAttribute("session", sess);
		if(authenticate.search(u1))
			return("display.jsp");
		
		else
			return("login.jsp");
				
	}
	
	@Autowired
	ReadDetails readDetails;
	@Autowired
	OutputDao outputDao;
	@RequestMapping("/fetch")
	
	public String details(HttpServletRequest request,HttpServletResponse response) 
	{
		String color=request.getParameter("color");
		String size=request.getParameter("size");
		
		String gender=request.getParameter("gender");
		String output=request.getParameter("output");
		String [] data=new String[4];

		
		data[0]=color;data[1]=size;data[2]=gender;data[3]=output;
		readDetails.setData(data);

		Thread th = new Thread(readDetails);
		th.start();
		outputDao.display();
		return "display.jsp";
	}
	
	@RequestMapping("/logout")
	public void log(HttpServletRequest request,HttpServletResponse response) throws IOException  {
		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("login.jsp");
	}
	
	
}

package com.tshirtkart.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tshirtkart.entities.ProductDetails;
import com.tshirtkart.thread.ReadDetails;

@Component
public class OutputDao {
	private static List<ProductDetails> matched;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
	ReadDetails readDetails;
	@Transactional(readOnly= false)
	public  void display() 
	{
		System.out.println("hiiii");
//		ReadDetails readDetails=new ReadDetails();
		String [] data=readDetails.getData();
//		
		SessionFactory sessionFactory = hibernateTemplate.getSessionFactory();
		Session session=sessionFactory.openSession();
//		String color=getParameter("color");
	
		System.out.println("hii"+session+" "+data[0]);


		TypedQuery<ProductDetails> q1 = null;
		if(data[3].contains("price")&&!data[3].contains("rating"))
		q1=session.createQuery("from ProductDetails as t where t.color=:col and t.size=:siz and t.genderRecommendation=:gend order by t.price asc");

		else if(!data[3].contains("price")&&data[3].contains("rating"))
		q1=session.createQuery("from ProductDetails as t where t.color=:col and t.size=:siz and t.genderRecommendation=:gend order by t.rating desc");
		
		else if(data[3].contains("price")&&data[3].contains("rating"))
		q1=session.createQuery("from ProductDetails as t where t.color=:col and t.size=:siz and t.genderRecommendation=:gend order by t.price asc,t.rating desc");
		
		q1.setParameter("col", data[0]);
		q1.setParameter("siz", data[1]);
		q1.setParameter("gend", data[2]);
		 matched=q1.getResultList();
		
//		System.out.println(matched.get(1).getId());
		
	}
	
	public static List<ProductDetails> getList()
	{
		return matched;
	}
	
	
	
}
	



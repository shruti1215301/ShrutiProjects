package com.tshirtkart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tshirtkart.entities.ProductDetails;

@Component
public class ProductDetailsDao {
@Autowired
private HibernateTemplate hibernateTemplate;

@Transactional(readOnly = false)
public void save(ProductDetails value)
{	
//	System.out.println(hibernateTemplate);
	this.hibernateTemplate.save(value);
}


}

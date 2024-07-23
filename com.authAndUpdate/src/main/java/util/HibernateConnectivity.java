package util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import product.MyProduct;
import user.AppUsers;


public class HibernateConnectivity {
	
	public static boolean userVerification(String username, String password) {
		Configuration con=new Configuration().configure().addAnnotatedClass(user.AppUsers.class);
		SessionFactory sf=con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Query q=session.createQuery("from AppUsers where userName=:username and userPassword=:password");
		q.setParameter("username", username);
		q.setParameter("password", password);
		
		AppUsers user=(AppUsers)q.uniqueResult();
		
		tx.commit();
		
		if(user!=null) {
			return true;
		}
		
		
		return false;
	}
	
	public static MyProduct getProduct(String id) {
		int pid=Integer.parseInt(id);
		Configuration con=new Configuration().configure().addAnnotatedClass(MyProduct.class);
		SessionFactory sf=con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Query q=session.createQuery("from MyProduct where Pid=:pid");
		q.setParameter("pid", pid);
		
		MyProduct p=(MyProduct)q.uniqueResult();
		
		tx.commit();
		
		return p;
	}
	
	public static void addProduct(MyProduct p) {
		Configuration con=new Configuration().configure().addAnnotatedClass(MyProduct.class);
		SessionFactory sf=con.buildSessionFactory();
		Session session = sf.openSession();
		
		try {
			Transaction tx=session.beginTransaction();
			
			session.save(p);
			tx.commit();
			
		}
		catch(Exception e) {
			System.out.println("Some error occured "+ e);
		}
		
	}
	
	public static void updateProduct(String id,String title, String size, String quantity,String imgsrc ,String uploader) {
		Configuration con=new Configuration().configure().addAnnotatedClass(MyProduct.class);
		SessionFactory sf=con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx=session.beginTransaction();
		MyProduct p=getProduct(id);
		p.setPid(Integer.parseInt(id));
		p.setImagesrc(imgsrc);
		p.setUploader(uploader);
		p.setTitle(title);
		p.setSize(size);
		p.setQuantity(quantity);
		session.update(p);
		tx.commit();
		
	}
	
	public static ArrayList<MyProduct> getUserProducts(String currentUser){
		Configuration con=new Configuration().configure().addAnnotatedClass(MyProduct.class);
		SessionFactory sf=con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Query q=session.createQuery("from MyProduct where uploader=:uploader");
		q.setParameter("uploader", currentUser);
		
		List<MyProduct> ls=q.list();
		System.out.println("User products are " + ls.size());
		
		tx.commit();
		for(MyProduct p:ls) {
			System.out.println(p);
		}
		return (ArrayList<MyProduct>) ls;
		
	}
	
	public static boolean deleteProduct(String id) {
		int pid=Integer.parseInt(id);
		Configuration con=new Configuration().configure().addAnnotatedClass(MyProduct.class);
		SessionFactory sf=con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("delete from MyProduct where Pid=:prodid");
		q.setParameter("prodid", pid);
		int result =q.executeUpdate();
		if(result>0) {
			System.out.println(result + " rows affected");
			return true;
		}
//		Query q=session.createQuery("from MyProduct where uploader=:uploader");
//		q.setParameter("uploader", currentUser);
//		
//		List<MyProduct> ls=q.list();
		
		tx.commit();
		return false;
//		for(MyProduct p:ls) {
//			System.out.println(p);
//		}
//		return (ArrayList<MyProduct>) ls;
		
	}
	
	public static void main(String[] args) {
		

		boolean ans=userVerification("Rythm123","qwerty1");
		System.out.println(ans);
	}
}

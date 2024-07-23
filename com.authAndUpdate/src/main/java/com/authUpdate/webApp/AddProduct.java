package com.authUpdate.webApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.MyProduct;
import util.HibernateConnectivity;

/**
 * Servlet implementation class AddProduct
 */
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session !=null) {
		MyProduct p = new MyProduct(request.getParameter("ptitle"),request.getParameter("pquantity"),request.getParameter("psize"),request.getParameter("pimage"),session.getAttribute("currentUser").toString());
		HibernateConnectivity.addProduct(p);
		System.out.println("Product added");
		session.removeAttribute("userProducts");
		
		ArrayList<MyProduct> ls=HibernateConnectivity.getUserProducts(session.getAttribute("currentUser").toString());
		session.setAttribute("userProducts", ls);
		
		response.sendRedirect("productpage.jsp");
		}
		else {
			PrintWriter out=response.getWriter();
			out.print("Invalid session");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}

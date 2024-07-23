package com.authUpdate.webApp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.MyProduct;
import util.HibernateConnectivity;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String id=request.getParameter("updateButton");
		System.out.println(id);
		
		HibernateConnectivity.updateProduct(id, request.getParameter("ptitle"), request.getParameter("psize"), request.getParameter("pquantity"), request.getParameter("pimage"),session.getAttribute("currentUser").toString());
//		HibernateConnectivity.deleteProduct(id);
//		MyProduct p = new MyProduct(request.getParameter("ptitle"),request.getParameter("pquantity"),request.getParameter("psize"),request.getParameter("pimage"),session.getAttribute("currentUser").toString());
//		HibernateConnectivity.addProduct(p);
//		MyProduct p=HibernateConnectivity.getProduct(id);
//		HibernateConnectivity.addProduct(p);
		session.removeAttribute("userProducts");
		
		ArrayList<MyProduct> ls=HibernateConnectivity.getUserProducts(session.getAttribute("currentUser").toString());
		session.setAttribute("userProducts", ls);
		response.sendRedirect("productpage.jsp");
		
	}

}

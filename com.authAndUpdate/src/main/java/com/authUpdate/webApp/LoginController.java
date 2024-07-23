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
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		String userName=request.getParameter("userName");
		String userPass=request.getParameter("userPass");
		
		boolean userVerified=HibernateConnectivity.userVerification(userName, userPass);
		if(userVerified) {
			HttpSession session=request.getSession();
			ArrayList<MyProduct> userProducts=HibernateConnectivity.getUserProducts(userName);
			session.setAttribute("currentUser", userName);
			session.setAttribute("userProducts", userProducts);
			response.sendRedirect("productpage.jsp");
		}
		else {
			response.sendRedirect("index.jsp");
		}
	}

}

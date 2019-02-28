package com.Demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DataPojo.IMDBRegisterPojo;
import com.RegistrationDAO.RegistrationDAO;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//		String i=request.getParameter("star");
//		String s=request.getParameter("comments");
//		out.println("hello world "+i+"Comments: "+s);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String reenterpassword=request.getParameter("reenterpassword");
//		PrintWriter out=response.getWriter();
		//System.out.println("hi"+firstname+lastname+phonenumber+emailid+password+reenterpassword);
		RegistrationDAO obj=new RegistrationDAO();
	
		IMDBRegisterPojo IRP=new IMDBRegisterPojo(username,password,reenterpassword);
		try {
			obj.insert(IRP);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("movie1.jsp");
		
	}

}

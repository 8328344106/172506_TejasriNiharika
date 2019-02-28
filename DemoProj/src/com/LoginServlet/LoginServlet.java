package com.LoginServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LoginDAO.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginDAO LD=new LoginDAO();
			if(LD.validate(username, password))
			{
				response.sendRedirect("movie1.jsp");
				session.setAttribute("user", username);
				session.setAttribute("username", username);
				session.setAttribute("password",password);
			}
			else
				response.sendRedirect("login.jsp");
		
		
	}

}

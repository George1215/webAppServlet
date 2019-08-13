package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Mysql database connections
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.PreparedStatement;



/**
 * Servlet implementation class LoginWebServlet
 */
public class LoginWebServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginWebServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("userName");
        String pass = request.getParameter("password");
        String email = request.getParameter("email");
 
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mavenweb", "root", "root1215");
 
            PreparedStatement ps = con
                    .prepareStatement("insert into USERDETAILS values(?,?,?,?)");
 
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.setString(3, email);

 
            int i = ps.executeUpdate();
            if (i > 0)
                System.out.println("You are successfully registered...");
 
        } catch (Exception e2) {
            System.out.println(e2);
        }
 
        out.close();
    
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

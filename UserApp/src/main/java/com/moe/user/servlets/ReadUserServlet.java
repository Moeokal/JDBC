package com.moe.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
public class ReadUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection ;
	
	public void init(ServletConfig config) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(config.getInitParameter("dbUrl"), config.getInitParameter("dbUser")
					, config.getInitParameter("dbPass"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		try(Statement statement = connection.createStatement();
				ResultSet result= statement.executeQuery("select * from user");
				PrintWriter out = response.getWriter();
				){
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>");
			out.println("<first name>");
			out.println("</th>");
			out.println("<th>");
			out.println("<last name>");
			out.println("</th>");
			out.println("<th>");
			out.println("email");
			out.println("</th>");
			out.println("</tr>");
			while(result.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.println(result.getString(1));
				out.println("</td>");
				out.println("<td>");
				out.println(result.getString(2));
				out.println("</td>");
				out.println("<td>");
				out.println(result.getString(3));
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

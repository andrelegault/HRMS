package main;

import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

@WebServlet(name="AddEmployeeServlet", urlPatterns="/add-employee")
public class AddEmployeeServlet extends HttpServlet {
	/*
	 * TODO: fix the bug saying the connector isn't found.
	 * To make the driver findable
	 * 1. add the jar file to your tomcat's /lib folder
	 * 2. right click the project -> Build Path -> Configure Build Path -> Add external JARs -> Add the jar from step 1
	 */

	public AddEmployeeServlet() {
		super();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/add-employee.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/add-employee.jsp");

			Connection con = AttendanceServlet.connect();

			String id = request.getParameter("id");
			String first = request.getParameter("first");
			String last = request.getParameter("last");
			String dob = request.getParameter("dob");
			String role = request.getParameter("role");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String icon = request.getParameter("icon") == ""? "NULL": request.getParameter("icon");
			String details = request.getParameter("details") == ""? "NULL": request.getParameter("details");
			
			if (id != "" &&
					first != "" &&
					last != "" &&
					role != "" &&
					dob != "" &&
					role != "" &&
					address != "" &&
					email != "" &&
					phone != "") { // no empty field
				PreparedStatement ps = con.prepareStatement("INSERT INTO employee VALUES(?, ?, ?, ?, ?, ?, ?, ?, DEFAULT, DEFAULT, ?, ?)");
				
				ps.setString(1, id);
				ps.setString(2, first);
				ps.setString(3, last);
				ps.setString(4, dob);
				ps.setString(5, role);
				ps.setString(6, address);
				ps.setString(7, email);
				ps.setString(8, phone);
				ps.setString(9, icon);
				ps.setString(10, details);
				
				ps.executeUpdate();
				

			    request.setAttribute("success", "1");
				
				ps.close();
				con.close();
			} else { // something wrong
			    request.setAttribute("error", "1");
			}
			
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/add-employee.jsp");
		    request.setAttribute("format", "1");
			dispatcher.forward(request, response);
		}
	}
}

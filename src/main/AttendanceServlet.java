package main;

import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

@WebServlet(name="EmployeeServlet", urlPatterns="/attendance")
public class AttendanceServlet extends HttpServlet {
	/*
	 * TODO: fix the bug saying the connector isn't found.
	 * To make the driver findable
	 * 1. add the jar file to your tomcat's /lib folder
	 * 2. right click the project -> Build Path -> Configure Build Path -> Add external JARs -> Add the jar from step 1
	 */
	protected static Connection connect() throws ClassNotFoundException, SQLException {
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/";
		
		String dbName = "hrms";
		String dbUser = "root";
		String dbPass = "";
		
		Class.forName(dbDriver);
		Connection con = DriverManager.getConnection(dbUrl + dbName, dbUser, dbPass);
		
		return con;
	}

	public AttendanceServlet() {
		super();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			Connection con = AttendanceServlet.connect();
			
			String first = request.getParameter("name");
			String last = request.getParameter("last");
			String role = request.getParameter("role");
			
			if (first != null && last != null && role != null) { // add an employee
				Employee e = new Employee(first, last, role);
				
				PreparedStatement ps = con.prepareStatement("INSERT INTO employees VALUES(?, ?, ?)");
				
				ps.setString(1, request.getParameter("first"));
				ps.setString(2, request.getParameter("last"));
				ps.setString(3, request.getParameter("role"));
				
				ps.executeUpdate();
				
				ps.close();
				con.close();
			} else { // something wrong
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection con = AttendanceServlet.connect();
			
			Statement st = con.createStatement();
			st.execute("SELECT employee.first, employee.last, schedule.start, schedule.end, schedule.day FROM employee, schedule WHERE employee.id = schedule.employee_id");
			ResultSet rs = st.getResultSet();
			ArrayList<ArrayList<String>> container = new ArrayList<ArrayList<String>>();
			
			while (rs.next()) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(rs.getString(4));
				row.add(rs.getString(5));

				container.add(row);
			}
			request.setAttribute("container", container);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/attendance.jsp");
		    dispatcher.forward(request, response);
			
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

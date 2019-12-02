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
		//String dbUrl = "jdbc:mysql://localhost:3306/";
		String dbUrl = "jdbc:mysql://SG-hrms-1622-master.servers.mongodirector.com:3306/";
		
		String dbName = "hrms";
		String dbUser = "sgroot";
		String dbPass = "oC_ZmVdxqQ6HJPzy";
		
		Class.forName(dbDriver);
		Connection con = DriverManager.getConnection(dbUrl + dbName, dbUser, dbPass);
		
		return con;
	}

	public AttendanceServlet() {
		super();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection con = AttendanceServlet.connect();
			
			Statement stmt1 = con.createStatement();
			stmt1.execute("SELECT * FROM employee");
			ResultSet rs1 = stmt1.getResultSet();
			
			Statement stmt2 = con.createStatement();
			stmt2.execute("SELECT attendance.employee_id, employee.first, employee.last, attendance.start, attendance.end, attendance.day FROM employee, attendance WHERE employee.id = attendance.employee_id");
			ResultSet rs2 = stmt2.getResultSet();
			
			ArrayList<ArrayList<String>> container1 = new ArrayList<ArrayList<String>>();
			while (rs1.next()) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(rs1.getString(1));
				row.add(rs1.getString(2));
				row.add(rs1.getString(3));
				row.add(rs1.getString(4));
				row.add(rs1.getString(5));
				row.add(rs1.getString(6));
				row.add(rs1.getString(7));
				row.add(rs1.getString(8));
				row.add(rs1.getString(9));
				row.add(rs1.getString(10));
				row.add(rs1.getString(11));
				row.add(rs1.getString(12));
				container1.add(row);
			}
			
			ArrayList<ArrayList<String>> container2 = new ArrayList<ArrayList<String>>();
			while (rs2.next()) {
				ArrayList<String> row = new ArrayList<String>();
				row.add(rs2.getString(1));
				row.add(rs2.getString(2));
				row.add(rs2.getString(3));
				row.add(rs2.getString(4));
				row.add(rs2.getString(5));
				row.add(rs2.getString(6));
				container2.add(row);
			}
			
			request.setAttribute("employees", container1);
			request.setAttribute("attendances", container2);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/attendance.jsp");
		    dispatcher.forward(request, response);
			
		    stmt1.close();
		    stmt2.close();
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

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

@WebServlet(name="ClockServlet", urlPatterns="/clock")
public class ClockServlet extends HttpServlet {

	public ClockServlet() {
		super();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/clock.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/clock.jsp");
		try {
			Connection con = AttendanceServlet.connect();

			String id = request.getParameter("id");
			String clock = request.getParameter("clock");
			
			if (!id.equals("")) { // no empty field
				if (clock.contentEquals("clockIn")) {
					PreparedStatement psIn = con.prepareStatement("UPDATE attendance SET start = NOW() WHERE day = CURDATE() AND employee_id = ?");
					psIn.setString(1, id);
					psIn.executeUpdate();
					psIn.close();
					request.setAttribute("clockIn", "1");
				} else if (clock.equals("clockOut")) {
					PreparedStatement psOut = con.prepareStatement("UPDATE attendance SET end = NOW() WHERE day = CURDATE() AND employee_id = ?");
					psOut.setString(1, id);
					psOut.executeUpdate();
					psOut.close();
					request.setAttribute("clockOut", "1");
				} else {
					request.setAttribute("error", "1");
				}
			} else { // something wrong
			    request.setAttribute("error", "1");
			}
			con.close();
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
		    /*request.setAttribute("error", "1");
			dispatcher.forward(request, response);*/
		}
	}
}

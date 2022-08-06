package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.databaseconnection;

/**
 * Servlet implementation class servlett
 */
public class deposit extends HttpServlet {
       

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int deposit = Integer.valueOf(request.getParameter("deposit"));  // get the data using request object
		 // Get a writer pointer 
        // to display the successful result
		PrintWriter out =response.getWriter();
		
		try {
			 // Initialize the database
			Connection conn= databaseconnection.initializeDatabase();
			Statement s=  conn.createStatement();
			ResultSet r=s.executeQuery("select bal from bank1 where acc=\""+servlett.u_name+"\";");//perform selection operation
			//System.out.println("select bal from bank1 where acc=\""+servlett.u_name+"\";");
			
			r.next();
			int bal=r.getInt("bal");
			int fin=bal+deposit;//final balance
			
			s.executeUpdate("update bank1 set bal="+fin+" where acc=\""+servlett.u_name+"\";");//perform update operation
			conn.close();  // Close all the connections
			System.out.println(request.getParameter("deposit"));
			out.println("\r\n"
					+ "<html>\r\n"
					+ "<body>\r\n"
					+ "<b>\r\n"
					+ "deposited successfully\r\n"
					+ "<br/>\r\n"
					+ deposit
					+ "</b>\r\n"
					+ "</body>\r\n"
					+ "</html>");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		}
	
	}

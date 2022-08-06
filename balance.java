package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import connection.databaseconnection;

/**
 * Servlet implementation class servlett
 */
public class balance extends HttpServlet {
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          
			try {
				 // Initialize the database
				Connection conn= databaseconnection.initializeDatabase();
				Statement s=  conn.createStatement();
				ResultSet r=s.executeQuery("select bal from bank1 where acc=\""+servlett.u_name+"\";");
				//System.out.println("select bal from bank1 where acc=\""+servlett.u_name+"\";");
				PrintWriter out =response.getWriter();//get the stream to write the data
				r.next();
				out.println("<html>\r\n"
						+ "<body>\r\n"
						+ "<b>\r\n"
						+ " your balance amount: \r\n"
						+  r.getInt(1)
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
package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.databaseconnection;

/**
 * Servlet implementation class servlett
 */
public class withdrawl extends HttpServlet {
       

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int withdrawl=Integer.valueOf(request.getParameter("withdrawl"));
		try {
            // Initialize the database

			Connection conn= databaseconnection.initializeDatabase();
			Statement s=  conn.createStatement();

			ResultSet r=s.executeQuery("select bal from bank1 where acc=\""+servlett.u_name+"\";");//select query
			r.next();
			int bal=r.getInt("bal");
			int fin=bal-withdrawl;//performing balance
			s.executeUpdate("update bank1 set bal="+fin+" where acc=\""+servlett.u_name+"\";");//update query
			conn.close();//closing the connection

		
			// Get a writer pointer 
            // to display the successful result
		PrintWriter out =response.getWriter();
		if(fin<0) {
			out.println("insufficient balance");
		}else {
		out.println("<html>\r\n"
				+ "<body>\r\n"
				+ "<b>\r\n"
				+ "withdrawl   Successfully\r\n"
				+ "<br/>\r\n"
				+withdrawl
				+ "</b>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		}
		}
		catch(Exception e) {
			e.printStackTrace();

		}
	}
}
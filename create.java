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
 * Servlet implementation class signuppage
 */
public class create extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		       String u_name= request.getParameter("u_name");
		       String pwd=request.getParameter("pwd");

				
				try {
					Connection con = databaseconnection.initializeDatabase();
					System.out.println(con);
					
		        Statement st=con.createStatement();
		        String u_name1 = request.getParameter("acc");
				String pwd1 = request.getParameter("password");
			   
		        int excuteUpdate=st.executeUpdate("insert into bank1(acc,password) values(\""+u_name1+"\",\""+pwd1+"\");");

                con.close();
		  
				 PrintWriter out =response.getWriter();//get the stream to write the data
				 out.println("created successfully");
	}
				catch(Exception e) {
		                  System.out.println(e);
	}
			}
		}
			


	

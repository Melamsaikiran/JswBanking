package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * Servlet implementation class servlett
 */
public class exit extends HttpServlet {
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();//get the stream to write the data
		servlett.u_name="";//undo the function
	out.println("<html>\r\n"
			+ "<body>\r\n"
			+ "<b>\r\n"
			+ "exit\r\n"
			+ "</b>\r\n"
			+ "</body>\r\n"
			+ "</html>");
		
	}
}
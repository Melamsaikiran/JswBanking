package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


//Import Database Connection Class file
import connection.databaseconnection;

/**
 * Servlet implementation class servlett
 */
public class servlett extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public static String u_name="";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

            // Initialize the database
			Connection con = databaseconnection.initializeDatabase();
			System.out.println(con);
			
        Statement st=con.createStatement();//the statement is a interface and it is used to sending a SQL query to the database
        //con is a variable of connection
		String u_name = request.getParameter("acc");   // get the data using request object
		String pwd = request.getParameter("password");            // Same for second parameter

		ResultSet rs= st.executeQuery("select * from bank1 where acc=\""+u_name+"\" and password=\""+pwd+"\";");
		 // Get a writer pointer 
        // to display the successful result
		 PrintWriter out =response.getWriter();
		
		 
		 //if else condition
		  if(rs.next()) {
			  System.out.println(  rs.getString(1));
			  servlett.u_name=rs.getString(1);
			  //html code
				out.println("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Home</title>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <img src=\"https://zeevector.com/wp-content/uploads/JSW-Logo-PNG-HD.png\" height=\"120\" width=\"400\">\r\n"
						+ "    <a href=\"index.html\">Back</a>\r\n"
						+ "    <br/>\r\n"
						+ "  <center>  \r\n"
						+ "   <fieldset> \r\n"
						+ "<div id=deposit>\r\n"
						+ "<form action= \"./deposit\" method=\"post\">\r\n"   //calling deposit servlet
						+ "Deposit:\r\n"
						+ "           <input type=\"numbers\" name=\"deposit\">\r\n"
						+ "			<input type=\"submit\" value=\"deposit\">\r\n"
						+ "               </div></form><br/>\r\n"
						+ "  \r\n"
						+ "  \r\n"
						+ "  <div id=withdrawl>\r\n"
						+ "\r\n"
						+ "  <form action=\"./withdrawl\" method=\"post\">\r\n"    //calling withdrawl servlet
						+ "  Withdraw:\r\n"
						+ " <input type=\"numbers\" name =\"withdrawl\">\r\n"
						+ "<input type=\"submit\" value=\"withdraw\">\r\n"
						+ " </form>\r\n"
						+ " </div>\r\n"
						+ " <br/>\r\n"
						+ " \r\n"
						+ " <div id = balance>\r\n"
						+ " <form action =\"./balance\" method = \"post\">\r\n"     //calling balance servlet
						+ " \r\n"
						+ "          <input type=\"submit\" value=\"balance\">\r\n"
						+ "          \r\n"
						+ "            </form>\r\n"
						+ "            </div>\r\n"
						+ "            <br/>\r\n"
						+ "  <div id =exit>\r\n"
						+ "  <form action=\"./exit\" method =\"post\">\r\n"    //calling exit servlet
						+ "  <input type=\"submit\" value=\"exit\">\r\n"
						+ "  </br>\r\n"
						+ "  </form>\r\n"
						+ "  </div>\r\n"
						+ "  \r\n"
						+ "  </fieldset>\r\n"
						+ "  </center>\r\n"
						+ "  \r\n"
						+ "  \r\n"
						+ "\r\n"
						+ "    <style>\r\n"
						+ "    a{\r\n"
						+ "    padding-left:30px;\r\n"
						+ " font-family: \"Lucida Console\", \"Courier New\", monospace;\r\n"
						+ " display:block;\r\n"
						+ " font-size:30px;\r\n"
						+ " background-color:grey;\r\n"
						+ "   border-radius: 25px;\r\n"
						+ "   border-left-style: solid;\r\n"
						+ "  border-left-color: red;\r\n"
						+ "    border-top-color: coral;\r\n"
						+ "    text-decoration:none;\r\n"
						+ "  block-size: auto;\r\n"
						+ "  \r\n"
						+ "  }\r\n"
						+ "  fieldset{\r\n"
						+ "  padding:50px;\r\n"
						+ "  font-size:25px;\r\n"
						+ "  }\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "    \r\n"
						+ "    </style>\r\n"
						+ "    </body>\r\n"
						+ "</html>");
		  }else {
			  out.println("<!DOCTYPE html>\r\n"
			  		+ "<html>\r\n"
			  		+ "<head>\r\n"
			  		+ "<meta charset=\"ISO-8859-1\">\r\n"
			  		+ "<title>signup</title>\r\n"
			  		+ "</head>\r\n"
			  		+ "<body>\r\n"
			  		+ "<img src=\"https://zeevector.com/wp-content/uploads/JSW-Logo-PNG-HD.png\" height=\"120\" width=\"400\">\r\n"
			  		+ "<h1><strong>Welcome To JSW Banks</strong></h1>\r\n"
			  		+ "<center>\r\n"
			  		+ "<form  id =register action=\"./create\" method=\"post\">\r\n"
			  		+ "<div>\r\n"
			  		+ "SIGN UP PAGE\r\n"
			  		+ "<fieldset>\r\n"
			  		+ "        <p>Create username:</p> \r\n"
			  		+ "    \r\n"
			  		+ "        <input type=\"text\" name=\"acc\"/>\r\n"
			  		+ "        <br/>\r\n"
			  		+ "        <p> create password:</p> \r\n"
			  		+ "        <input type=\"password\" name=\"password\"/>\r\n"
			  		+ "        <br/><br/><br/>\r\n"
			  		+ "        <input type=\"submit\" value=\"submit\"/>\r\n"
			  		+ "        </fieldset>\r\n"
			  		+ "        </div>\r\n"
			  		+ "    </form>\r\n"
			  		+ "    </center>\r\n"
			  		+ "    <style>\r\n"
			  		+ "    body{\r\n"
			  		+ "    text-align:center;}\r\n"
			  		+ "    p{\r\n"
			  		+ " font-family: \"Lucida Console\", \"Courier New\", monospace;\r\n"
			  		+ " font-size:30pxs;\r\n"
			  		+ "    color:black;\r\n"
			  		+ "    }\r\n"
			  		+ "    #register {\r\n"
			  		+ "  width: 400px;\r\n"
			  		+ "}\r\n"
			  		+ "\r\n"
			  		+ "input {\r\n"
			  		+ "  padding: 4px;\r\n"
			  		+ "  box-shadow: 3px 3px 5px grey;\r\n"
			  		+ "  font-size: 14px;\r\n"
			  		+ "  font-weight: 600;\r\n"
			  		+ "  width: 300px;\r\n"
			  		+ "}\r\n"
			  		+ "h1{\r\n"
			  		+ "padding-left:100px;\r\n"
			  		+ " font-family: \"Lucida Console\", \"Courier New\", monospace;\r\n"
			  		+ " display:block;\r\n"
			  		+ " font-size:60px;\r\n"
			  		+ " background-color:grey;\r\n"
			  		+ "   border-radius: 25px;\r\n"
			  		+ "   border-left-style: solid;\r\n"
			  		+ "  border-left-color: red;\r\n"
			  		+ "    border-top-color: coral;\r\n"
			  		+ "  \r\n"
			  		+ " \r\n"
			  		+ "}\r\n"
			  		+ "  \r\n"
			  		+ "    </style>\r\n"
			  		+ "</body>\r\n"
			  		+ "</html>");
		  }
		
		}  catch(Exception e) {
            e.printStackTrace();
		  }
	}
				
}



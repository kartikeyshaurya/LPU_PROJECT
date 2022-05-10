package Highradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class searchData
 */
@WebServlet("/searchData")
public class searchData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
try {
			
			String value = request.getParameter("cust_number");
			Class.forName("com.mysql.jdbc.Driver");
			//connection
			String url = "jdbc:mysql://localhost:3306/highradius_dummy";
			String username = "root"; 
			String pass = "Aman9431" ;
			Connection conn = DriverManager.getConnection(url, username, pass);
			
			// statement 
	
			
			String SearchQuery = "select  * from customers where cust_number=? ";
			
			PreparedStatement st2 = conn.prepareStatement(SearchQuery);
		    
			st2.setString(1, value);
			
			
			// setting up the content-type error 
		
		
		}
			catch (Exception e) {
			//System.out.println(e); 
		}
		
		
		System.out.println("helloo");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		

	}

}

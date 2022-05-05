package Highradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddData")
public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddData() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			System.out.println("helloo");
			String customerName = request.getParameter("cust_number");
			String customerNumber = request.getParameter("name_customer");
			
			// making connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connection
			String url = "jdbc:mysql://localhost:3306/highradius_dummy";
			String username = "root"; 
			String pass = "Aman9431" ;
			Connection conn = DriverManager.getConnection(url, username, pass);
	
			System.out.println("Database is connected to AddData");
			
		
			String query = "insert into customers (name_customer,cust_number) values (?,?)";
			
			PreparedStatement st= conn.prepareStatement(query);
			st.setString(1, customerName);
			st.setString(2, customerNumber);
			
			st.executeUpdate();
			System.out.println(st);
			// console log for the information 
			
			
			conn.close(); 
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

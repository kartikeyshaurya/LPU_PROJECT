package Highradius;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteData
 */
@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
			
			String value = request.getParameter("cust_number");
			System.out.println(value);
			//int intvalue = Integer.parseInt(value);
			
			//making a connection 
			Class.forName("com.mysql.jdbc.Driver");
			//connection
			String url = "jdbc:mysql://localhost:3306/highradius_dummy";
			String username = "root"; 
			String pass = "Aman9431" ;
			Connection conn = DriverManager.getConnection(url, username, pass);
	
			System.out.println("Database is connected to Delete");
			
			
			//DELETE FROM customers where invoice_id=1929497308 ;
			String deleteQuery = "DELETE FROM customers where cust_number=?";
			
			PreparedStatement st= conn.prepareStatement(deleteQuery);
			
			st.setString(1, value);
			
			st.executeUpdate(); 
			System.out.println(st);
			
			
			
			System.out.println("executed");
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

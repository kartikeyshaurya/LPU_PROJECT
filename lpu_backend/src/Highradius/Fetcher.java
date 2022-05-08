package Highradius;
import java.sql.Connection ;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/Fetcher")
public class Fetcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Fetcher() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// jdbc process    ** load -> connect -> makeStatement -> executeStatement -> close
		
		try {
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connection
			String url = "jdbc:mysql://localhost:3306/highradius_dummy";
			String username = "root"; 
			String pass = "Aman9431" ;
			Connection conn = DriverManager.getConnection(url, username, pass);
			
			// statement 
			Statement st = conn.createStatement();
			
			String query = "select  cust_number, name_customer from customers limit 200 ";
			
			ResultSet result = st.executeQuery(query); 
			
		    //ArrayList<ClassDetails> data = new ArrayList<ClassDetails>(); 
		    
		    
			
			while(result.next()) {
				
			
			System.out.println("Customer number : " + result.getString("cust_number"));
			System.out.println("Customer name : " + result.getString("name_customer"));
			
			//ClassDetails classDetails = new ClassDetails();
			//classDetails.setCust_number(result.getString("cust_number"));
			//classDetails.setName_customer(result.getString("name_customer"));
			//data.add(classDetails); 
		} 
			// setting up the content-type error 
		//String resJson = new Gson().toJson(data); 
				
		 //response.setContentType("application/json"); 
		
		 // seeting up the status code 200-0k 
		 //response.setStatus(200);
		 //response.getWriter().write(resJson);
		 
		 
		}
			catch (Exception e) {
			System.out.println(e); 
		}
		
		
		System.out.println("helloo");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// setting up the content-type error 
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

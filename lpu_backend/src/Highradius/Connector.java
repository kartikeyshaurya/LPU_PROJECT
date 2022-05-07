package Highradius;


import java.sql.*;
import java.util.ArrayList;

import com.google.gson.Gson;
 
class Connector{  
public static void main(String args[]){  
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/highradius_dummy","root","Aman9431");  

Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select  cust_number, name_customer from customers limit 200");  
ArrayList<ClassDetails> data = new ArrayList<ClassDetails>(); 

while(rs.next())  
{

	System.out.println("Customer number : " + rs.getString("cust_number"));
	System.out.println("Customer name : " + rs.getString("name_customer"));
	
	ClassDetails classDetails = new ClassDetails();
	classDetails.setCust_number(rs.getString("cust_number"));
	classDetails.setName_customer(rs.getString("name_customer"));
	data.add(classDetails);
}

String resJson = new Gson().toJson(data); 


 
con.close();  
}catch(Exception e){ System.out.println(e);}  
}  
}  
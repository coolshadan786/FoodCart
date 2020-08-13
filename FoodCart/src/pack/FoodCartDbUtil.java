package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//It is a helper Class for FoodCaert_Servlet to fetch data from the mysql db and give to it.
public class FoodCartDbUtil {
	
	public static List<Food> getFoodList() throws ClassNotFoundException , SQLException{
		
		String url="jdbc:mysql://localhost:3306/Food";
		String userName="root";
		String password="Umair@786";
		 
		ArrayList<Food> food=new ArrayList<>();
		
		//load the mysql driver;
		Class.forName("com.mysql.jdbc.Driver");
		
		//get the connection
		Connection con=DriverManager.getConnection(url,userName,password);
	
		//create a statement
		Statement stmt=con.createStatement();
		
		//execute the statement and loop over result set
		ResultSet rs=stmt.executeQuery("select * from foodcart");
	
		while(rs.next()) {
			int id=rs.getInt(1);	//here 1,2,3 is order of data to be fetch as like save in mysql database
			String item=rs.getString(2);
			float price=rs.getFloat(3);
			Food f=new Food(id,item,price);		//here create a Food Class object and pass data in Constructor parameter  to store data from db to cclasss Food to return data or set data as per need by the user query. 
			food.add(f);			//here add the reference var of Food to the reference of ArrayList<Food>
		}	
		return food;
	}

}

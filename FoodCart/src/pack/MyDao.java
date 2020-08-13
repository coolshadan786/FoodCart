package pack;

import java.sql.*;

public class MyDao {
	Connection con=null;
	Statement st=null;
	static MyDao md=null;
	
	
	private MyDao() {}
	
	static MyDao getObject() {
		if(md==null) {
			md=new MyDao();
		}
		return md;
	}
	
	public Statement getConnection() throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/Food";
		Connection con=DriverManager.getConnection(url,"root","Umair@786");
		st=con.createStatement();
		return st;
	}
}


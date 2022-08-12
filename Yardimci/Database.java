package Yardimci;

import java.sql.*;


public class Database {
	
	Connection c=null;
	
	public Database(){}
	
	public Connection connDb() {
		
		try {
			

			this.c= DriverManager.getConnection("jdbc:mysql://ns40.kebirhost.com/wwwajan_barkod","***","***");
			//Güvenlik amacıyla database bilgileri gizlenmiştir...
			 
			//jdbc:mysql://192.168.15.25:3306/yourdatabase
			//?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=UTF-8


			 
			return c;
		} 
		
		
		catch (SQLException e)
		
		{
			 
			e.printStackTrace();
		}
		
		return  c;
	}
	

}

package DaoImplements;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Dao.UserDao;
import Siniflar.User;
import Yardimci.Database;



public class UserDaoImplements implements UserDao {

	
	
	//Veritabanı için gerekli
	Database conn= new Database();
	Statement st=null;
	ResultSet rs=null;
	Connection con=conn.connDb();
	PreparedStatement preparedStatement= null;
	
	//list veritabanı olarak çalışıyor
	List<User> list;
	
	// constructor metodumuz
	public UserDaoImplements(){ 	

	list = new ArrayList<User>();
		      
	User user;
		
	try {
		st =(Statement) con.createStatement();
		rs=st.executeQuery("SELECT c_id,c_tc,c_isim,c_sifre,c_bilgi,c_ist_id FROM calisan");
		while(rs.next()) {
		user=new User(rs.getInt("c_id"),rs.getString("c_tc"),rs.getString("c_isim"),rs.getString("c_sifre"),rs.getString("c_bilgi"),rs.getInt("c_ist_id"));
		list.add(user); } } 
	catch (SQLException e) {e.printStackTrace();} 
				
		}
		
	 
	
	@Override
	public List<User> getAllUsers() {

		list = new ArrayList<User>();
	      
		User user;
			
		try {
			st =(Statement) con.createStatement();
			rs=st.executeQuery("SELECT c_id,c_tc,c_isim,c_sifre,c_bilgi,c_ist_id FROM calisan");
			while(rs.next()) {
			user=new User(rs.getInt("c_id"),rs.getString("c_tc"),rs.getString("c_isim"),rs.getString("c_sifre"),rs.getString("c_bilgi"),rs.getInt("c_ist_id"));
			list.add(user); } } 
		catch (SQLException e) {e.printStackTrace();} 
				
		return list;
	}

	@Override
	public User getUser(int u_id) {
		

		User get_user=null;
		
		try {
			st =(Statement) con.createStatement();
			rs=st.executeQuery("SELECT c_id,c_tc,c_isim,c_sifre,c_bilgi,c_ist_id FROM calisan WHERE c_id="+u_id);
			if(rs.next()) {
			get_user=new User(rs.getInt("c_id"),rs.getString("c_tc"),rs.getString("c_isim"),rs.getString("c_sifre"),rs.getString("c_bilgi"),rs.getInt("c_ist_id")); } } 
		
		catch (SQLException e) {e.printStackTrace();} 
		
		return get_user;
	}

	@Override
	public void updateUser(User user) {

	String query = "UPDATE calisan SET c_tc=?, c_isim=?, c_sifre=?, c_ist_id=? WHERE c_id=?";
	
	int ist_yeni=Integer.parseInt(user.getType());
		
	try {
		st=(Statement) con.createStatement();
		preparedStatement=(PreparedStatement) con.prepareStatement(query);
		preparedStatement.setString(1,user.getTcno());
		preparedStatement.setString(2,user.getName());
		preparedStatement.setString(3,user.getPassword());
		preparedStatement.setInt(4,ist_yeni);
		preparedStatement.setInt(5,user.getId());
		 
		preparedStatement.executeUpdate();
		 
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}

	@Override
	public void deleteUser(User user) {


		String query = "DELETE FROM calisan WHERE c_id=?";
		
		try {
			st=(Statement) con.createStatement();
			preparedStatement=(PreparedStatement) con.prepareStatement(query);
			preparedStatement.setInt(1,user.getId());
			 
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}

	@Override
	public void addUser(String tc, String isim, String sifre, int ist_id) {
		
		
		String sorguEkleme = " INSERT INTO calisan (c_tc,c_isim,c_sifre,c_ist_id,c_bilgi,c_yil)  VALUES (?, ?, ?, ?,'bilgiGelecek','Yil Gelecek')";
		
		try {
			st=(Statement) con.createStatement();
			preparedStatement=(PreparedStatement) con.prepareStatement(sorguEkleme);
			 
			preparedStatement.setString (1, tc);
			preparedStatement.setString (2, isim);
			preparedStatement.setString   (3, sifre);
			preparedStatement.setInt(4, ist_id);
			 
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}

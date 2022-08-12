package DaoImplements;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Dao.ClinicDao;
import Siniflar.Clinic;
import Yardimci.Database;

public class ClinicDaoImplements implements ClinicDao {
	
	
	Statement st=null;
	ResultSet rs=null;
	PreparedStatement preparedStatement= null;
	Database db=new Database();
	Connection con=(Connection) db.connDb();
	
	List<Clinic> list;
	
	Clinic clinic;
	
	
	@Override
	public List<Clinic> getAllClinic() {
		
		list=new ArrayList<Clinic>();
		
		try {
			st=(Statement) con.createStatement();
			
			rs=st.executeQuery("SELECT * FROM clinic");
			
			while(rs.next()) {
				
				clinic= new Clinic(rs.getInt("c_id"), rs.getString("c_isim"));
				
				list.add(clinic);
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return list;
	}

	@Override
	public Clinic getClinic(int c_id) {
		try {
			st=(Statement) con.createStatement();
			
			rs=st.executeQuery("SELECT * FROM clinic WHERE=" + c_id);
			
			if(rs.next()) {
				
				clinic= new Clinic(rs.getInt("c_id"), rs.getString("c_isim"));
				
				 
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clinic;
	}

	@Override
	public void updateClinic(Clinic user) {


		String query = "UPDATE clinic SET c_isim=? WHERE c_id=?";
		
	 
			
		try {
			st=(Statement) con.createStatement();
			
			preparedStatement=(PreparedStatement) con.prepareStatement(query);
			
			preparedStatement.setString(1,user.getIsim());
			 
			preparedStatement.setInt(2,user.getId());
			 
			preparedStatement.executeUpdate();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteClinic(Clinic cli) {
		
	String query = "DELETE FROM clinic WHERE c_id=?";
		
		try {
			st=(Statement) con.createStatement();
			preparedStatement=(PreparedStatement) con.prepareStatement(query);
			preparedStatement.setInt(1,cli.getId());
			 
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addClinic(String isim) {

		String sorgu="INSERT INTO clinic(c_isim) VALUES(?)";
		
		try {
			preparedStatement=(PreparedStatement) con.prepareStatement(sorgu);
			preparedStatement.setString(1, isim);
			
			preparedStatement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}

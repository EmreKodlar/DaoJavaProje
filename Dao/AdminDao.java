package Dao;

import java.util.List;

import Siniflar.Admin;
import Siniflar.User;


public interface AdminDao {
	
	 public List<User> getAllUsers();
	   public User getUser(int u_id);
	   public void updateUser(User user);
	   public void deleteUser(User user);
	   public void addUser(String tc, String isim, String sifre, int ist_id, String tip);
	 

}

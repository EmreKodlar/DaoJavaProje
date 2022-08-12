package Dao;

import java.util.List;

import Siniflar.Clinic;

 

public interface ClinicDao {
	
	 public List<Clinic> getAllClinic();
	   public Clinic getClinic(int c_id);
	   public void updateClinic(Clinic user);
	   public void deleteClinic(Clinic user);
	   public void addClinic(String isim);

}

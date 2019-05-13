package model_files;

import java.io.*;
import java.util.ArrayList;

import controller_files.Controller_secretary;
import files.Department_data;
import files.Login_data;
import view_files.GUI_admin;
import view_files.GUI_admin_login;


public class Model_Admin {
	Department_data logger;
	
	protected ArrayList<Department_data> department = new ArrayList<Department_data>();
	public Model_Admin() {
		
	}
	public boolean check_login(String username,String password) {
		boolean flag = false;		
		if(username.equals("admin") && password.equals("admin"))
		flag = true;
		
		return flag;
	}
	
	public void setLogin(Department_data d) {
		logger = d;
	}
	public Department_data getLogin() {
		return logger;
	}
	public boolean check_department(String username, String password) {
		boolean flag = false;
		try {
			FileInputStream fis = new FileInputStream("departments.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o= ois.readObject();
			department = (ArrayList<Department_data>)o;
			
			ois.close();
			for (Department_data department_data : department) { //for each loop to get the department data
				if(username.equals(department_data.getUsername()) && password.equals(department_data.getPassword())) {
					flag = true;
					setLogin(department_data);
				}
			}
			
			} catch (EOFException ex) { 
			 
			 } catch (ClassNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (FileNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (IOException ex) {
			 ex.printStackTrace();
			 }
		return flag;
	}
	
	
}

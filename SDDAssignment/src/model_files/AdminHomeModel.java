package model_files;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

import controller_files.AdminHomeController;
import controller_files.Controller_admin;
import files.Department_data;
import files.Lecturer_data;
import files.contract_data;
import files.fulltime_data;
import files.parttime_data;
import view_files.GUI_admin;


public class AdminHomeModel {
     
	GUI_admin ga;

	public AdminHomeModel(){
		
	}
	protected ArrayList<Department_data> department = new ArrayList<Department_data>();
	protected  ArrayList<Lecturer_data> Lecturer = new ArrayList<Lecturer_data>();
	protected ArrayList<fulltime_data> fulltime = new ArrayList<fulltime_data>();
	protected ArrayList<parttime_data> parttime = new ArrayList<parttime_data>();
	protected ArrayList<contract_data> contract = new ArrayList<contract_data>();
	Department_data depart;
	Lecturer_data lecture;
	fulltime_data full;
	parttime_data part;
	contract_data cont;
	
	
	public ArrayList<Department_data> getArrays()
	{
		ArrayList<Department_data> data = null;
		try{
			FileInputStream file = new FileInputStream("departments.dat");
			ObjectInputStream output = new ObjectInputStream(file);
			Object o= output.readObject();
			data = (ArrayList<Department_data>)o;
			output.close();
			
			
		}
		catch (FileNotFoundException e){
			
			e.printStackTrace();
		}
		catch (IOException e){
			
		}
		catch (ClassNotFoundException e){
			
			e.printStackTrace();
		}
		return data;
	}
	
	public void addEntry() 
	{
		try {
			 	FileOutputStream file = new FileOutputStream("departments.dat");
				ObjectOutputStream output = new ObjectOutputStream(file);
				output.writeObject(department);
				output.close();
				
		 }catch (Exception e) { }	
	}
	
	public void addArray(GUI_admin ga)
	{
		depart = new Department_data(ga.getDeparmentName(), ga.getDeparmentType(), ga.getDepartmentUname(), ga.getDpartmentpassword());
		if(getArrays()!=null) {
			department= getArrays();
			department.add(depart);
			 addEntry(); 
		}
		else {
			department.add(depart);
			 addEntry(); 
		}
	}
	
	public void editDepartment(GUI_admin ga , int i) throws FileNotFoundException, IOException {
		department = getArrays();
		depart = new Department_data(ga.getDeparmentName(),ga.getDeparmentType(),ga.getDepartmentUname(),ga.getDpartmentpassword());
		department.set(i,depart);
		addEntry();
		JOptionPane.showMessageDialog(null, "Department Edited. login again to see the data");
	}
	
	public void deleteDept(int i) {
		department =  getArrays();
		department.remove(i);
		addEntry();
		
	}
	
	
	
	//Lecturer part
	
	public ArrayList<Lecturer_data> getlectArrays()
	{
		ArrayList<Lecturer_data> data = null;
		try{
			FileInputStream file = new FileInputStream("Lecturer.dat");
			ObjectInputStream output = new ObjectInputStream(file);
			Object o= output.readObject();
			data = (ArrayList<Lecturer_data>)o;
			output.close();
			
			
		}
		catch (FileNotFoundException e){
			
			e.printStackTrace();
		}
		catch (IOException e){
		
		}
		catch (ClassNotFoundException e){
			
			e.printStackTrace();
		}
		return data;
	}
		
	public void addlectEntry() 
	{
		try {
			 	FileOutputStream file = new FileOutputStream("Lecturer.dat");
				ObjectOutputStream output = new ObjectOutputStream(file);
				output.writeObject(Lecturer);
				output.close();
				
		 }catch (Exception e) { }	
	}
	
	public void addlectArray(GUI_admin ga)
	{
		lecture = new Lecturer_data(ga.getLecturerName(), ga.getLecturerType(), ga.getLecturerdepart(), ga.getLectureraddress(), ga.getLectureremail(), ga.getLecturerphnum());
		if(getlectArrays()!=null) {
			Lecturer= getlectArrays();
			Lecturer.add(lecture);
			 addlectEntry(); 
		}
		else {
			Lecturer.add(lecture);
			 addlectEntry();
		}
	}
	
	public void deletelect(int i) {
		Lecturer =  getlectArrays();
		Lecturer.remove(i);
		addlectEntry();
		
	}
	
	public void editLecturer(GUI_admin ga , int i) throws FileNotFoundException, IOException {
		Lecturer = getlectArrays();
		lecture = new Lecturer_data(ga.getLecturerName(), ga.getLecturerType(), ga.getLecturerdepart(), ga.getLectureraddress(), ga.getLectureremail(), ga.getLecturerphnum());
		Lecturer.set(i,lecture);
		addlectEntry();
		JOptionPane.showMessageDialog(null, "Lecturer Edited. login again to see the data");
	}
	
	
	//full-time lecturer
	
	public ArrayList<fulltime_data> getfullArrays()
	{
		ArrayList<fulltime_data> data = null;
		try{
			FileInputStream file = new FileInputStream("fulltime.dat");
			ObjectInputStream output = new ObjectInputStream(file);
			Object open= output.readObject();
			data = (ArrayList<fulltime_data>)open;
			output.close();
			
			
		}
		catch (FileNotFoundException e){
			
			e.printStackTrace();
		}
		catch (IOException e){
			
		}
		catch (ClassNotFoundException e){
			
			e.printStackTrace();
		}
		return data;
	}
	
	
	public void addfullEntry() 
	{
		try {
			 	FileOutputStream file = new FileOutputStream("fulltime.dat");
				ObjectOutputStream open = new ObjectOutputStream(file);
				open.writeObject(fulltime);
				open.close();
				
		 }catch (Exception e) { }	
	}
	
	public void addfullArray(GUI_admin ga)
	{
		full = new fulltime_data(ga.getfullName(), ga.getfullType(), ga.getfulldepart(), ga.getfulladdress(), ga.getfullemail(), ga.getfullphnum());
		if(getfullArrays()!=null) {
			fulltime= getfullArrays();
			fulltime.add(full);
			 addfullEntry(); 
		}
		else {
			fulltime.add(full);
			 addfullEntry();
		}
	}
	
	public void deletefull(int i) {
		fulltime =  getfullArrays();
		fulltime.remove(i);
		addfullEntry();	
	}
	
	public void editfull(GUI_admin ga , int i) throws FileNotFoundException, IOException {
		fulltime = getfullArrays();
		full = new fulltime_data(ga.getfullName(), ga.getfullType(), ga.getfulldepart(), ga.getfulladdress(), ga.getfullemail(), ga.getfullphnum());
		fulltime.set(i,full);
		addfullEntry();
		JOptionPane.showMessageDialog(null, "Lecturer Edited. login again to see the data");
	}
	
	
	//part time  lecturer
	
	public ArrayList<parttime_data> getpartArrays()
	{
		ArrayList<parttime_data> data = null;
		try{
			FileInputStream file = new FileInputStream("parttime.dat");
			ObjectInputStream output = new ObjectInputStream(file);
			Object open= output.readObject();
			data = (ArrayList<parttime_data>)open;
			output.close();
			
			
		}
		catch (FileNotFoundException e){
			
			e.printStackTrace();
		}
		catch (IOException e){
		
		}
		catch (ClassNotFoundException e){
			
			e.printStackTrace();
		}
		return data;
	}
	
	public void addpartEntry() 
	{
		try {
			 	FileOutputStream fout = new FileOutputStream("parttime.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fout);
				oos.writeObject(parttime);
				oos.close();
				
		 }catch (Exception e) { }	
	}
	
	public void addpartArray(GUI_admin ga)
	{
		part = new parttime_data(ga.getpartName(), ga.getpartType(), ga.getpartdepart(), ga.getpartaddress(), ga.getpartemail(), ga.getpartphnum());
		if(getpartArrays()!=null) {
			parttime= getpartArrays();
			parttime.add(part);
			 addpartEntry(); 
		}
		else {
			parttime.add(part);
			 addpartEntry();
		}
	}
	
	public void deletepart(int i) {
		parttime =  getpartArrays();
		parttime.remove(i);
		addpartEntry();	
	}
	
	public void editpart(GUI_admin ga , int i) throws FileNotFoundException, IOException {
		parttime = getpartArrays();
		part = new parttime_data(ga.getpartName(), ga.getpartType(), ga.getpartdepart(), ga.getpartaddress(), ga.getpartemail(), ga.getpartphnum());
		parttime.set(i,part);
		addpartEntry();
		JOptionPane.showMessageDialog(null, "Lecturer Edited. login again to see the data");
	}
	
	// contract Lecturer
	
	public ArrayList<contract_data> getcontArrays()
	{
		ArrayList<contract_data> data = null;
		try{
			FileInputStream file = new FileInputStream("contract.dat");
			ObjectInputStream output = new ObjectInputStream(file);
			Object open = output.readObject();
			data = (ArrayList<contract_data>)open;
			output.close();
			
			
		}
		catch (FileNotFoundException e){
			
			e.printStackTrace();
		}
		catch (IOException e){
			
		}
		catch (ClassNotFoundException e){
			
			e.printStackTrace();
		}
		return data;
	}
	
	
	public void addcontEntry() 
	{
		try {
			 	FileOutputStream file = new FileOutputStream("contract.dat");
				ObjectOutputStream open = new ObjectOutputStream(file);
				open.writeObject(contract);
				open.close();
				
		 }catch (Exception e) { }	
	}
	
	
	public void addcontArray(GUI_admin ga)
	{
		cont = new contract_data(ga.getcontName(), ga.getcontType(), ga.getcontdepart(), ga.getcontaddress(), ga.getcontemail(), ga.getcontphnum());
		if(getcontArrays()!=null) {
			contract = getcontArrays();
			contract.add(cont);
			 addcontEntry(); 
		}
		else {
			contract.add(cont);
			 addcontEntry();
		}
	}
	
	
	public void deletecont(int i) {
		contract =  getcontArrays();
		contract.remove(i);
		addcontEntry();	
	}
	
	public void editcont(GUI_admin ga , int i) throws FileNotFoundException, IOException {
		contract = getcontArrays();
		cont = new contract_data(ga.getcontName(), ga.getcontType(), ga.getcontdepart(), ga.getcontaddress(), ga.getcontemail(), ga.getcontphnum());
		contract.set(i,cont);
		addcontEntry();
		JOptionPane.showMessageDialog(null, "Lecturer Edited. login again to see the data");
	}
	
	
	
}
	
	


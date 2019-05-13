package model_files;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import files.Department_data;
import files.Lecturer_data;
import files.contract_data;
import files.fulltime_data;
import files.parttime_data;
import view_files.GUI_admin;



public class Model_secretary {
	
	 
	protected ArrayList<Department_data> department = new ArrayList<Department_data>();
	protected ArrayList<Lecturer_data> lecturer = new ArrayList<Lecturer_data>();
	protected ArrayList<fulltime_data> fulltime = new ArrayList<fulltime_data>();
	protected ArrayList<parttime_data> parttime = new ArrayList<parttime_data>();
	protected ArrayList<contract_data> contract = new ArrayList<contract_data>();

	 public Model_secretary( ) {
			
		}
	 
	 public ArrayList<Department_data> getArrays()
		{
			ArrayList<Department_data> data = null;
			try{
				FileInputStream fis = new FileInputStream("departments.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object o= ois.readObject();
				data = (ArrayList<Department_data>)o;
				ois.close();
				
				
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
	 
	 
	 public ArrayList<Lecturer_data> getlectArrays()
		{
			ArrayList<Lecturer_data> data = null;
			try{
				FileInputStream fis = new FileInputStream("Lecturer.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object o= ois.readObject();
				data = (ArrayList<Lecturer_data>)o;
				ois.close();
				
				
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
	 
	 public ArrayList<fulltime_data> getfullArrays()
		{
			ArrayList<fulltime_data> data = null;
			try{
				FileInputStream fis = new FileInputStream("fulltime.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object o= ois.readObject();
				data = (ArrayList<fulltime_data>)o;
				ois.close();
				
				
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
	 
	 public ArrayList<parttime_data> getpartArrays()
		{
			ArrayList<parttime_data> data = null;
			try{
				FileInputStream fis = new FileInputStream("parttime.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object o= ois.readObject();
				data = (ArrayList<parttime_data>)o;
				ois.close();
				
				
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
	 
	 
	 public ArrayList<contract_data> getcontArrays()
		{
			ArrayList<contract_data> data = null;
			try{
				FileInputStream fis = new FileInputStream("contract.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object o= ois.readObject();
				data = (ArrayList<contract_data>)o;
				ois.close();
				
				
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
	 
}

package controller_files;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle.Control;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.security.auth.x500.X500Principal;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import files.Department_data;
import files.Lecturer_data;
import files.contract_data;
import files.fulltime_data;
import files.parttime_data;
import model_files.AdminHomeModel;
import model_files.Model_Admin;
import view_files.GUI_admin;
import view_files.GUI_admin_login;

public class AdminHomeController {
	 AdminHomeModel model;
	 GUI_admin view; 
	 ArrayList<Department_data> depart = new ArrayList<Department_data>();
	 ArrayList<Lecturer_data> lecture = new ArrayList<Lecturer_data>();
	 ArrayList<fulltime_data> fulltime = new ArrayList<fulltime_data>();
	 ArrayList<parttime_data> parttime = new ArrayList<parttime_data>();
	 ArrayList<contract_data> contract = new ArrayList<contract_data>();
	 
	public AdminHomeController(AdminHomeModel model, GUI_admin view) {
		this.model = model;
		this.view = view;
	}	
	
	
	public void logout() {
		view.logoutButton(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.dispose();
				GUI_admin_login GUI1=new GUI_admin_login(); 
				Model_Admin ma = new Model_Admin();
				Controller_admin ca=new Controller_admin(GUI1,ma);
				ca.clickAction();
			}
		});
	}
	
	
	public void Adddepartment() {
		view.AddButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.addArray(view);
				displayinrow();
				JOptionPane.showMessageDialog(null, "Department Added");
			}
		});
	}
	
	public void displayinrow() {
		if(model.getArrays()!=null) {
			
			Object col[]= {"Department Name", "Department Type", "Username", "Password"};
			view.getdepartdata().setColumnIdentifiers(col);
			view.getdepartdisplay().setRowHeight(25);
			TableColumnModel tabel_model = view.getdepartdisplay().getColumnModel();

			depart = model.getArrays();
			Department_data obj = new Department_data(null, null, null, null);
			
				obj=depart.get(depart.size()-1);
				Object[] data= {obj.getName(),obj.getType(),obj.getUsername(),obj.getPassword()};
				view.getdepartdata().addRow(data);
			tabel_model.getColumn(0).setPreferredWidth(100); // setting the preferred width
			tabel_model.getColumn(1).setPreferredWidth(100);// setting the preferred width
			tabel_model.getColumn(2).setPreferredWidth(80); // setting the preferred width
			tabel_model.getColumn(3).setPreferredWidth(80); //setting the preferred width
			
			}
	}
	public void display() {
		if(model.getArrays()!=null) {
		
		Object col[]= {"Department Name", "Department Type", "Username", "Password"};
		view.getdepartdata().setColumnIdentifiers(col);
		view.getdepartdisplay().setRowHeight(25);
		TableColumnModel table_model = view.getdepartdisplay().getColumnModel();

		depart = model.getArrays();
		Department_data obj = new Department_data(null, null, null, null);
		for(int i=0;i<depart.size();i++) {
			obj=depart.get(i);
			Object[] data= {obj.getName(),obj.getType(),obj.getUsername(),obj.getPassword()};
			view.getdepartdata().addRow(data);
		}
		table_model.getColumn(0).setPreferredWidth(100); // setting the preferred width
		table_model.getColumn(1).setPreferredWidth(100);// setting the preferred width
		table_model.getColumn(2).setPreferredWidth(80); // setting the preferred width
		table_model.getColumn(3).setPreferredWidth(80); //setting the preferred width
		
		
		}
	}
	private int indexArray;
	public void setIndex(int i) {
		indexArray= i;
	}
	
	public int getIndex() { return indexArray;}
	public String getName() { return view.getDeparmentName();}
	public String getType() { return view.getDeparmentType();}
	public String getPassword() { return view.getDepartmentUname();}
	public String  getUser(){ return view.getDpartmentpassword();}
	
	
	public void DeleteDepart() {
		view.DeleteButton(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = view.getdepartdisplay().getSelectedRow();
			((DefaultTableModel) view.getdepartdisplay().getModel()).removeRow(row);
			    model.deleteDept(getIndex());
			    JOptionPane.showMessageDialog(null, "Row deleted");
				
			}
		});
	}
	
	public void DepartrowSelected()
	{
		view.getdepartdisplay().addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseClicked(java.awt.event.MouseEvent e)
		 {
				 int row;
			
			String name, type, username, password;
			DefaultTableModel	table_model = (DefaultTableModel) view.getdepartdisplay().getModel();
		    row = view.getdepartdisplay().getSelectedRow();
			
			name= table_model.getValueAt(row,0).toString();
		    type= table_model.getValueAt(row,1).toString();
			username= table_model.getValueAt(row,2).toString();
			password= table_model.getValueAt(row,3).toString();
			view.adddepart_table(name, type, username, password);
			setIndex(view.getdepartdisplay().getSelectedRow());
			 }
		});
		
		
	}
	
	public void EditDepart()
	{
		view.UpdateButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.editDepartment(view, getIndex());
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	
	
	//Lecturer 
	
	
	public void Addlecturer() {
		view.AddlectButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.addlectArray(view);
				displaylectinrow();
				JOptionPane.showMessageDialog(null, "Lecturer Added");
			}
		});
	}
	
	public void displaylectinrow() {
		if(model.getlectArrays()!=null) {
			
			Object col[]= {"Lecturer Name", "Lecturer type", "Department", "Address", "Email", "Phone number"};
			view.getlectdata().setColumnIdentifiers(col);
			view.getlectdisplay().setRowHeight(25);
			TableColumnModel table_Model = view.getlectdisplay().getColumnModel();

			lecture = model.getlectArrays();
		    Lecturer_data obj = new Lecturer_data(null, null, null, null, null, null);
			
				obj=lecture.get(lecture.size()-1);
				Object[] data= {obj.getName(),obj.getType(),obj.getDepartment(),obj.getAddress(),obj.getEmail(), obj.getPhnumber()};
				view.getlectdata().addRow(data);
			table_Model.getColumn(0).setPreferredWidth(100);
			table_Model.getColumn(1).setPreferredWidth(100);
			table_Model.getColumn(2).setPreferredWidth(80);
			table_Model.getColumn(3).setPreferredWidth(80);
			table_Model.getColumn(4).setPreferredWidth(80);
			table_Model.getColumn(5).setPreferredWidth(80);
			}
	}
	
	
	public void displaylect() {
		if(model.getlectArrays()!=null) {
		
		Object col[]= {"Lecturer Name", "Lecturer type", "Department", "Address", "Email", "Phone number"};
		view.getlectdata().setColumnIdentifiers(col);
		view.getlectdisplay().setRowHeight(25);
		TableColumnModel table_Model = view.getlectdisplay().getColumnModel();

		lecture = model.getlectArrays();
		Lecturer_data obj = new Lecturer_data(null, null, null, null, null, null);
		for(int i=0;i<lecture.size();i++) {
			obj=lecture.get(i);
			Object[] data= {obj.getName(),obj.getType(),obj.getDepartment(),obj.getAddress(),obj.getEmail(), obj.getPhnumber()};
			view.getlectdata().addRow(data);
		}
		table_Model.getColumn(0).setPreferredWidth(100);
		table_Model.getColumn(1).setPreferredWidth(100);
		table_Model.getColumn(2).setPreferredWidth(80);
		table_Model.getColumn(3).setPreferredWidth(80);
		table_Model.getColumn(4).setPreferredWidth(80);
		table_Model.getColumn(5).setPreferredWidth(80);
		
		}
	}
	

	
	public void DeleteLect() {
		view.DeletelectButton(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = view.getlectdisplay().getSelectedRow();
			    ((DefaultTableModel) view.getlectdisplay().getModel()).removeRow(row);
			    model.deletelect(row);
			    
			    JOptionPane.showMessageDialog(null, "Row deleted");
				
			}
		});
	}
	
	
	public void LecturerowSelected()
	{
	 //getting current table 
		view.getlectdisplay().addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseClicked(java.awt.event.MouseEvent e)
		 {
				 int row;
			// getting all values from selected row, store them and send those values to fill the form
			String name, type, department, address, email, phnumber;
			DefaultTableModel	m = (DefaultTableModel) view.getlectdisplay().getModel();
		    row = view.getlectdisplay().getSelectedRow();
			
			name= m.getValueAt(row,0).toString();
		    type= m.getValueAt(row,1).toString();
			department= m.getValueAt(row,2).toString();
			address= m.getValueAt(row,3).toString();
			email= m.getValueAt(row,4).toString();
			phnumber= m.getValueAt(row,5).toString();
			view.addlect_table(name, type, department, address, email, phnumber);
			setIndex(view.getlectdisplay().getSelectedRow());
			 }
		});	
	}
	public void EditLect()
	{
		view.UpdatelectButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.editLecturer(view, getIndex());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	
	
	//fulltime lecturer
	
	public void Addfulltime() {
		view.AddfullButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.addfullArray(view);
				displayfullinrow();
				JOptionPane.showMessageDialog(null, "Lecturer Added");
			}
		});
	}
	
	public void displayfullinrow() {
		if(model.getfullArrays()!=null) {
			
			Object col[]= {"Lecturer Name", "Lecturer type", "Salary", "Address", "Email", "Phone number"};
			view.getfulldata().setColumnIdentifiers(col);
			view.getfulldisplay().setRowHeight(25);
			TableColumnModel table_model = view.getfulldisplay().getColumnModel();

			fulltime = model.getfullArrays();
		    fulltime_data obj = new fulltime_data(null, null, null, null, null, null);
			
				obj=fulltime.get(fulltime.size()-1);
				Object[] data= {obj.getName(),obj.getType(),obj.getSalary(),obj.getAddress(),obj.getEmail(), obj.getPhnumber()};
				view.getfulldata().addRow(data);
			table_model.getColumn(0).setPreferredWidth(100);
			table_model.getColumn(1).setPreferredWidth(100);
			table_model.getColumn(2).setPreferredWidth(80);
			table_model.getColumn(3).setPreferredWidth(80);
			table_model.getColumn(4).setPreferredWidth(80);
			table_model.getColumn(5).setPreferredWidth(80);
			}
	}
	
	
	public void displayfull() {
		if(model.getfullArrays()!=null) {
		
		Object col[]= {"Lecturer Name", "Lecturer type", "Salary", "Address", "Email", "Phone number"};
		view.getfulldata().setColumnIdentifiers(col);
		view.getfulldisplay().setRowHeight(25);
		TableColumnModel table_Model = view.getfulldisplay().getColumnModel();

		fulltime = model.getfullArrays();
		fulltime_data obj = new fulltime_data(null, null, null, null, null, null);
		for(int i=0;i<fulltime.size();i++) {
			obj=fulltime.get(i);
			Object[] data= {obj.getName(),obj.getType(),obj.getSalary(),obj.getAddress(),obj.getEmail(), obj.getPhnumber()};
			view.getfulldata().addRow(data);
		}
		table_Model.getColumn(0).setPreferredWidth(100);
		table_Model.getColumn(1).setPreferredWidth(100);
		table_Model.getColumn(2).setPreferredWidth(80);
		table_Model.getColumn(3).setPreferredWidth(80);
		table_Model.getColumn(4).setPreferredWidth(80);
		table_Model.getColumn(5).setPreferredWidth(80);
		
		}
	}
	
	public void Deletefull() {
		view.DeletefullButton(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = view.getfulldisplay().getSelectedRow();
			    ((DefaultTableModel) view.getfulldisplay().getModel()).removeRow(row);
			    model.deletefull(row);
			    
			    JOptionPane.showMessageDialog(null, "Row deleted");
				
			}
		});
	}
	
	public void fullrowSelected()
	{
	 //getting current table 
		view.getfulldisplay().addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseClicked(java.awt.event.MouseEvent e)
		 {
				 int row;
			// getting all values from selected row, store them and send those values to fill the form
			String name, type, salary, address, email, phnumber;
			DefaultTableModel	m = (DefaultTableModel) view.getfulldisplay().getModel();
		    row = view.getfulldisplay().getSelectedRow();
			
			name= m.getValueAt(row,0).toString();
		    type= m.getValueAt(row,1).toString();
			salary= m.getValueAt(row,2).toString();
			address= m.getValueAt(row,3).toString();
			email= m.getValueAt(row,4).toString();
			phnumber= m.getValueAt(row,5).toString();
			view.addfull_table(name, type, salary, address, email, phnumber);
			setIndex(view.getfulldisplay().getSelectedRow());
			 }
		});
		
		
	}
	
	public void Editfull()
	{
		view.UpdatefullButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.editfull(view, getIndex());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	
	//part time lecturer
	
	public void Addparttime() {
		view.AddpartButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.addpartArray(view);
				displaypartinrow();
				JOptionPane.showMessageDialog(null, "Lecturer Added");
			}
		});
	}
	
	
	public void displaypartinrow() {
		if(model.getpartArrays()!=null) {
			
			Object col[]= {"Lecturer Name", "Lecturer type", "pay-rate", "Address", "Email", "Phone number"};
			view.getpartdata().setColumnIdentifiers(col);
			view.getpartdisplay().setRowHeight(25);
			TableColumnModel table_Model = view.getpartdisplay().getColumnModel();

			parttime = model.getpartArrays();
		    parttime_data obj = new parttime_data(null, null, null, null, null, null);
			
				obj=parttime.get(parttime.size()-1);
				Object[] data= {obj.getName(),obj.getType(),obj.getpayrate(),obj.getAddress(),obj.getEmail(), obj.getPhnumber()};
				view.getpartdata().addRow(data);
			table_Model.getColumn(0).setPreferredWidth(100);
			table_Model.getColumn(1).setPreferredWidth(100);
			table_Model.getColumn(2).setPreferredWidth(80);
			table_Model.getColumn(3).setPreferredWidth(80);
			table_Model.getColumn(4).setPreferredWidth(80);
			table_Model.getColumn(5).setPreferredWidth(80);
			}
	}
	
	public void displaypart() {
		if(model.getpartArrays()!=null) {
		
		Object col[]= {"Lecturer Name", "Lecturer type", "pay-rate", "Address", "Email", "Phone number"};
		view.getpartdata().setColumnIdentifiers(col);
		view.getpartdisplay().setRowHeight(25);
		TableColumnModel table_Model = view.getpartdisplay().getColumnModel();

		parttime = model.getpartArrays();
		parttime_data obj = new parttime_data(null, null, null, null, null, null);
		for(int i=0;i<parttime.size();i++) {
			obj=parttime.get(i);
			Object[] data= {obj.getName(),obj.getType(),obj.getpayrate(),obj.getAddress(),obj.getEmail(), obj.getPhnumber()};
			view.getpartdata().addRow(data);
		}
		table_Model.getColumn(0).setPreferredWidth(100);
		table_Model.getColumn(1).setPreferredWidth(100);
		table_Model.getColumn(2).setPreferredWidth(80);
		table_Model.getColumn(3).setPreferredWidth(80);
		table_Model.getColumn(4).setPreferredWidth(80);
		table_Model.getColumn(5).setPreferredWidth(80);
		
		}
	}
	
	public void Deletepart() {
		view.DeletepartButton(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = view.getpartdisplay().getSelectedRow();
			    ((DefaultTableModel) view.getpartdisplay().getModel()).removeRow(row);
			    model.deletepart(row);
			    
			    JOptionPane.showMessageDialog(null, "Row deleted");
				
			}
		});
	}
	
	
	public void partrowSelected()
	{
	 //getting current table 
		view.getpartdisplay().addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseClicked(java.awt.event.MouseEvent e)
		 {
				 int row;
			// getting all values from selected row, store them and send those values to fill the form
			String name, type, salary, address, email, phnumber;
			DefaultTableModel	m = (DefaultTableModel) view.getpartdisplay().getModel();
		    row = view.getpartdisplay().getSelectedRow();
			
			name= m.getValueAt(row,0).toString();
		    type= m.getValueAt(row,1).toString();
			salary= m.getValueAt(row,2).toString();
			address= m.getValueAt(row,3).toString();
			email= m.getValueAt(row,4).toString();
			phnumber= m.getValueAt(row,5).toString();
			view.addpart_table(name, type, salary, address, email, phnumber);
			setIndex(view.getpartdisplay().getSelectedRow());
			 }
		});
		
		
	}
	
	
	public void Editpart()
	{
		view.UpdatepartButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.editpart(view, getIndex());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	
	
	// contract part
    
	public void Addconttime() {
		view.AddcontButton(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.addcontArray(view);
				displaycontinrow();
				JOptionPane.showMessageDialog(null, "Lecturer Added");
			}
		});
	}
	
	public void displaycontinrow() {
		if(model.getcontArrays()!=null) {
			
			Object col[]= {"Lecturer Name", "Lecturer type", "pay-rate", "Address", "Email", "Phone number"};
			view.getcontdata().setColumnIdentifiers(col);
			view.getcontdisplay().setRowHeight(25);
			TableColumnModel table_Model = view.getcontdisplay().getColumnModel();

			contract = model.getcontArrays();
		    contract_data obj = new contract_data(null, null, null, null, null, null);
			
				obj=contract.get(contract.size()-1);
				Object[] data= {obj.getName(),obj.getType(),obj.getpayrate(),obj.getAddress(),obj.getEmail(), obj.getPhnumber()};
				view.getcontdata().addRow(data);
			table_Model.getColumn(0).setPreferredWidth(100);
			table_Model.getColumn(1).setPreferredWidth(100);
			table_Model.getColumn(2).setPreferredWidth(80);
			table_Model.getColumn(3).setPreferredWidth(80);
			table_Model.getColumn(4).setPreferredWidth(80);
			table_Model.getColumn(5).setPreferredWidth(80);
			}
	}
	
	public void displaycont() {
		if(model.getcontArrays()!=null) {
		
		Object col[]= {"Lecturer Name", "Lecturer type", "pay-rate", "Address", "Email", "Phone number"};
		view.getcontdata().setColumnIdentifiers(col);
		view.getcontdisplay().setRowHeight(25);
		TableColumnModel table_Model = view.getcontdisplay().getColumnModel();

		contract = model.getcontArrays();
		contract_data obj = new contract_data(null, null, null, null, null, null);
		for(int i=0;i<contract.size();i++) {
			obj=contract.get(i);
			Object[] data= {obj.getName(),obj.getType(),obj.getpayrate(),obj.getAddress(),obj.getEmail(), obj.getPhnumber()};
			view.getcontdata().addRow(data);
		}
		table_Model.getColumn(0).setPreferredWidth(100);
		table_Model.getColumn(1).setPreferredWidth(100);
		table_Model.getColumn(2).setPreferredWidth(80);
		table_Model.getColumn(3).setPreferredWidth(80);
		table_Model.getColumn(4).setPreferredWidth(80);
		table_Model.getColumn(5).setPreferredWidth(80);
		
		}
	}
	
	public void Deletecont() {
		view.DeletecontButton(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = view.getcontdisplay().getSelectedRow();
			    ((DefaultTableModel) view.getcontdisplay().getModel()).removeRow(row);
			    model.deletecont(row);
			    
			    JOptionPane.showMessageDialog(null, "Row deleted");
				
			}
		});
	}
	
	public void controwSelected()
	{
	 //getting current table 
		view.getcontdisplay().addMouseListener(new java.awt.event.MouseAdapter() {
			 public void mouseClicked(java.awt.event.MouseEvent e)
		 {
				 int row;
			// getting all values from selected row, store them and send those values to fill the form
			String name, type, salary, address, email, phnumber;
			DefaultTableModel	m = (DefaultTableModel) view.getcontdisplay().getModel();
		    row = view.getcontdisplay().getSelectedRow();
			
			name= m.getValueAt(row,0).toString();
		    type= m.getValueAt(row,1).toString();
			salary= m.getValueAt(row,2).toString();
			address= m.getValueAt(row,3).toString();
			email= m.getValueAt(row,4).toString();
			phnumber= m.getValueAt(row,5).toString();
			view.addcont_table(name, type, salary, address, email, phnumber);
			setIndex(view.getcontdisplay().getSelectedRow());
			 }
		});
		
		
	}
	
	public void Editcont()
	{
		view.UpdatecontButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					model.editcont(view, getIndex());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}
	
}

	


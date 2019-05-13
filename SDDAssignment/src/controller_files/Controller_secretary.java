package controller_files;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.TableColumnModel;

import files.Department_data;
import files.Lecturer_data;
import files.contract_data;
import files.fulltime_data;
import files.parttime_data;
import model_files.Model_Admin;
import model_files.Model_secretary;
import view_files.GUI_admin_login;
import view_files.GUI_secreatary;

public class Controller_secretary {
Model_secretary model;	
GUI_secreatary view;


    ArrayList<Department_data> depart = new ArrayList<Department_data>();
    ArrayList<Lecturer_data> lecture = new ArrayList<Lecturer_data>();
    ArrayList<fulltime_data> full = new ArrayList<fulltime_data>();
    ArrayList<parttime_data> part = new ArrayList<parttime_data>();
    ArrayList<contract_data> contract = new ArrayList<contract_data>();
    
    public Department_data data;
    public Lecturer_data ldata;
    public fulltime_data fulldata;
    public parttime_data partdata;
    public contract_data contdata;
    
	private Object department;
	private Object lecturer;
	private Object fulltime;
	private Object parttime;
	private Object cont;
    
public Controller_secretary(Model_secretary ma, GUI_secreatary secreatary){
	this.model = ma;
	this.view = secreatary;
}

public void logout() {
	view.logoutButton(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			view.dispose();
			GUI_admin_login GUI1=new GUI_admin_login(); 
			Model_Admin ma = new Model_Admin();
			Controller_admin cs=new Controller_admin(GUI1,ma);
			cs.clickAction();
		}
	});
}





public void displayinrow() {
	ArrayList<Department_data> department = new ArrayList<Department_data>();
     department = model.getArrays();
     view.getdepartdisplay().setRowHeight(25);
     TableColumnModel tabel_model = view.getdepartdisplay().getColumnModel();
		Department_data obj = new Department_data(null, null, null, null);
		System.out.println(data.getName());
		tabel_model.getColumn(0).setPreferredWidth(100);
		tabel_model.getColumn(1).setPreferredWidth(100);
		tabel_model.getColumn(2).setPreferredWidth(80);
		tabel_model.getColumn(3).setPreferredWidth(80);
		for (Department_data department_data : department) {
		if (department_data.getUsername().equals(data.getUsername())) {
			Object[] data= {department_data.getName(),department_data.getType(),department_data.getUsername(),department_data.getPassword()};
			view.getdepartdata().addRow(data);
			
		}
		}
		}


public void displaylectrow() {
	ArrayList<Lecturer_data> lecturer = new ArrayList<Lecturer_data>();
     lecturer = model.getlectArrays();
     view.getlectdisplay().setRowHeight(25);
     TableColumnModel tabel_model = view.getlectdisplay().getColumnModel();
		Lecturer_data obj = new Lecturer_data(null, null, null, null, null, null);

		tabel_model.getColumn(0).setPreferredWidth(100);
		tabel_model.getColumn(1).setPreferredWidth(100);
		tabel_model.getColumn(2).setPreferredWidth(80);
		tabel_model.getColumn(3).setPreferredWidth(80);
		tabel_model.getColumn(4).setPreferredWidth(80);
		tabel_model.getColumn(5).setPreferredWidth(80);
		for (Lecturer_data lecturer_data : lecturer) {
		if (lecturer_data.getDepartment().equals(data.getType())) {
			Object[] data= {lecturer_data.getName(),lecturer_data.getType(),lecturer_data.getDepartment(),lecturer_data.getAddress(),lecturer_data.getEmail(),lecturer_data.getPhnumber()};
			view.getlectdata().addRow(data);
			
		}
		}
		}

public void displayfullrow() {
	ArrayList<fulltime_data> fulltime = new ArrayList<fulltime_data>();
     fulltime = model.getfullArrays();
     view.getfulldisplay().setRowHeight(25);
     TableColumnModel tabel_model = view.getfulldisplay().getColumnModel();
		fulltime_data obj = new fulltime_data(null, null, null, null, null, null);

		tabel_model.getColumn(0).setPreferredWidth(100);
		tabel_model.getColumn(1).setPreferredWidth(100);
		tabel_model.getColumn(2).setPreferredWidth(80);
		tabel_model.getColumn(3).setPreferredWidth(80);
		tabel_model.getColumn(4).setPreferredWidth(80);
		tabel_model.getColumn(5).setPreferredWidth(80);
		for (fulltime_data cont_data : fulltime) {
		if (cont_data.getType().equals(data.getType())) {
			Object[] data= {cont_data.getName(),cont_data.getType(),cont_data.getSalary(),cont_data.getAddress(),cont_data.getEmail(),cont_data.getPhnumber()};
			view.getfulldata().addRow(data);
			
		}
		}
		}

public void displaypartrow() {
	ArrayList<parttime_data> parttime = new ArrayList<parttime_data>();
     parttime = model.getpartArrays();
     view.getpartdisplay().setRowHeight(25);
     TableColumnModel tabel_model = view.getpartdisplay().getColumnModel();
		parttime_data obj = new parttime_data(null, null, null, null, null, null);

		tabel_model.getColumn(0).setPreferredWidth(100);
		tabel_model.getColumn(1).setPreferredWidth(100);
		tabel_model.getColumn(2).setPreferredWidth(80);
		tabel_model.getColumn(3).setPreferredWidth(80);
		tabel_model.getColumn(4).setPreferredWidth(80);
		tabel_model.getColumn(5).setPreferredWidth(80);
		for (parttime_data cont_data : parttime) {
		if (cont_data.getType().equals(data.getType())) {
			Object[] data= {cont_data.getName(),cont_data.getType(),cont_data.getpayrate(),cont_data.getAddress(),cont_data.getEmail(),cont_data.getPhnumber()};
			view.getpartdata().addRow(data);
			
		}
		}
		}

public void displaycontrow() {
	ArrayList<contract_data> contract = new ArrayList<contract_data>();
     contract = model.getcontArrays();
     view.getcontdisplay().setRowHeight(25);
     TableColumnModel tabel_model = view.getcontdisplay().getColumnModel();
		contract_data obj = new contract_data(null, null, null, null, null, null);

		tabel_model.getColumn(0).setPreferredWidth(100);
		tabel_model.getColumn(1).setPreferredWidth(100);
		tabel_model.getColumn(2).setPreferredWidth(80);
		tabel_model.getColumn(3).setPreferredWidth(80);
		tabel_model.getColumn(4).setPreferredWidth(80);
		tabel_model.getColumn(5).setPreferredWidth(80);
		for (contract_data cont_data : contract) {
		if (cont_data.getType().equals(data.getType())) {
			Object[] data= {cont_data.getName(),cont_data.getType(),cont_data.getpayrate(),cont_data.getAddress(),cont_data.getEmail(),cont_data.getPhnumber()};
			view.getcontdata().addRow(data);
			
		}
		}
		}






}


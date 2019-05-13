package view_files;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import controller_files.AdminHomeController;
import files.Department_data;
import model_files.AdminHomeModel;


public class GUI_admin extends JFrame {
	private JButton homePanel, logout, logout1, Department, addLecturer, fullTime, PartTime, Contract, Add, Update,
			Delete, lecadd, lecup, lecdel, fulladd, fullup, fulldel, partadd, partup, partdel, contadd, contup, contdel;
	private JPanel mainPanel, lectPanel, departPanel, fullPanel, partPanel, contPanel;
	private JLabel lname, lusername, ldepart, lmodule, ltype, ldepartment, llect, lfull, lpart, lcontract, llogout,
			ldepname, ldeptype, ldepno, ldepuname, ldeppassword, llecname, llecdep, llectype, lfullname, lfulldep, lfulltype, lpartname, lpartdep, lparttype, lcontname, lcontdep, lconttype, lfulladd, lfullemail, lfullnum, lpartadd, lpartemail, lpartnum, lcontadd, lcontemail, lcontnum, llecadd, llecemail, llecnum ;
	private JTextField tname, tusername, tdepart, tmodule, ttype, tdepname, tdeptype, tdepno, tdepuname, tdeppassword, tlecname, tlecdep, tlectype, tfullname, tfulldep, tfulltype, tpartname, tpartdep, tparttype, tcontname, tcontdep, tconttype , tfulladd, tfullemail, tfullnum, tpartadd, tpartemail, tpartnum, tcontadd, tcontemail, tcontnum, tlecadd, tlecemail, tlecnum ;
	private JTable Deptable, lecttable, fulltable, parttable, conttable;
	private DefaultTableModel departtab, lecttab, fulltab, parttab, conttab;
	private JScrollPane scroll, lectscroll, fullscroll, contscroll, partscroll;
	private JComboBox depbox, box, typebox, fullbox, partbox, contbox;
    
	private AdminHomeModel model;
	private AdminHomeController control;

	ImageIcon department = new ImageIcon("images/department.png");
	ImageIcon secreatary = new ImageIcon("images/secreatary.png");
	ImageIcon full_time = new ImageIcon("images/full_time.png");
	ImageIcon part_time = new ImageIcon("images/part_time.jpg");
	ImageIcon cont = new ImageIcon("images/contract.png");

	ImageIcon out1 = new ImageIcon("images/logout.png");
	ImageIcon out2 = new ImageIcon("images/logout1.png");
    
	public GUI_admin(AdminHomeModel model, AdminHomeController control) {
		this.control = control;
		this.model = model;
	}
	public GUI_admin() {
		setSize(1000, 870);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener((WindowListener) control);
		mainPanel = new JPanel();
		mainPanel.setLayout(new CardLayout());
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mainPanel.setBounds(20, 170, 930, 620);

		Department = new JButton(department);
		ldepartment = new JLabel("Department");
		ldepartment.setFont(new Font("Times new roman", Font.ITALIC, 25));
		Department.setBounds(30, 20, 95, 100);
		ldepartment.setBounds(20, 90, 140, 100);

		addLecturer = new JButton(secreatary);
		llect = new JLabel("Lecturer");
		llect.setFont(new Font("Times new roman", Font.ITALIC, 25));
		addLecturer.setBounds(180, 20, 100, 100);
		llect.setBounds(180, 90, 100, 100);

		fullTime = new JButton(full_time);
		lfull = new JLabel("Full Time");
		lfull.setFont(new Font("Times new roman", Font.ITALIC, 25));
		fullTime.setBounds(330, 20, 100, 100);
		lfull.setBounds(330, 90, 100, 100);

		PartTime = new JButton(part_time);
		lpart = new JLabel("Part Time");
		lpart.setFont(new Font("Times new roman", Font.ITALIC, 25));
		PartTime.setBounds(490, 20, 100, 100);
		lpart.setBounds(490, 90, 120, 100);

		Contract = new JButton(cont);
		lcontract = new JLabel("Contract");
		lcontract.setFont(new Font("Times new roman", Font.ITALIC, 25));
		Contract.setBounds(640, 20, 100, 100);
		lcontract.setBounds(640, 90, 100, 100);

		ImageIcon home = new ImageIcon("images/home.png");
		homePanel = new JButton(home);

		homePanel.setLayout(null);
		homePanel.setVisible(true);
		mainPanel.add(homePanel);

		departPanel = new JPanel();
		departPanel.setLayout(null);
		Deptable = new JTable();
		scroll = new JScrollPane(Deptable);
		departPanel.add(scroll);
		scroll.setBounds(12, 10, 900, 300);
		
		
		Deptable = new JTable();
		scroll.setViewportView(Deptable);
		Deptable.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		departtab = (DefaultTableModel) Deptable.getModel();
		departtab.setColumnIdentifiers(new String[] {"Department Name", "Department Type", "Username", "Password"});
		Deptable.setModel(departtab);

	    Add = new JButton("Add");
		Update = new JButton("Update");
		Delete = new JButton("Delete");
		ldepname = new JLabel("Department Name: ");
		ldepname.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tdepname = new JTextField(40);
		ldeptype = new JLabel("Department Type");
		ldeptype.setFont(new Font("Times New Roman", Font.BOLD, 15));
		depbox = new JComboBox();
		depbox.setBackground(SystemColor.text);
		depbox.setModel(new DefaultComboBoxModel(new String[] {"SCIENCE", "MANAGEMENT", "ARTS", "HUMANITIES", "BSC. COMPUTIING"}));
		
		
		ldepuname = new JLabel("Username: ");
		ldepuname.setFont(new Font("Times New Roman", Font.BOLD, 17));
		tdepuname = new JTextField(40);
		ldeppassword = new JLabel("Password: ");
		ldeppassword.setFont(new Font("Times New Roman", Font.BOLD, 17));
		tdeppassword = new JTextField(40);
	
		ldepname.setBounds(20, 340, 140, 30);
		ldeptype.setBounds(20, 380, 140, 30);
		tdepname.setBounds(150, 340, 100, 30);
		depbox.setBounds(150, 380, 100, 30);
		ldepuname.setBounds(30, 420, 140, 30);
		tdepuname.setBounds(150, 420, 100, 30);
		ldeppassword.setBounds(30, 460, 140, 30);
		tdeppassword.setBounds(150, 460, 100, 30);
		Add.setBounds(320, 467, 120, 40);
		Update.setBounds(460, 467, 120, 40);
		Delete.setBounds(600, 467, 120, 40);
		Add.setBackground(Color.green);
		Update.setBackground(Color.cyan);
		Delete.setBackground(Color.red);
		departPanel.setBackground(Color.white);
		departPanel.add(ldepname);
		departPanel.add(ldeptype);
		departPanel.add(tdepname);
		departPanel.add(depbox);
		departPanel.add(ldepuname);
		departPanel.add(tdepuname);
		departPanel.add(ldeppassword);
		departPanel.add(tdeppassword);
		departPanel.add(Add);
		departPanel.add(Update);
		departPanel.add(Delete);
		departPanel.setVisible(false);
		mainPanel.add(departPanel);

		lectPanel = new JPanel();
		lectPanel.setLayout(null);
		lectPanel.setBackground(Color.white);
		lectscroll = new JScrollPane(lecttable);
		lectPanel.add(lectscroll);
		lectscroll.setBounds(12, 10, 900, 300);
		
		
		lecttable = new JTable();
		lectscroll.setViewportView(lecttable);
		lecttable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lecttab = (DefaultTableModel) lecttable.getModel();
		lecttab.setColumnIdentifiers(new String[] {"Lecturer Name", "Lecturer type", "Department", "Address", "Email", "Phone number"});
		lecttable.setModel(lecttab);
		
		lecadd = new JButton("Add");
		lecup = new JButton("Update");
		lecdel = new JButton("Delete");
		llecname = new JLabel("Lecturer Name: ");
		llecname.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tlecname = new JTextField(40);
		llectype = new JLabel("Lecturer Type");
		llectype.setFont(new Font("Times New Roman", Font.BOLD, 15));
		typebox = new JComboBox();
		typebox.setBackground(SystemColor.text);
		typebox.setModel(new DefaultComboBoxModel(new String[] {"Full-time","Part-time", "contract"}));
		
		
		llecdep = new JLabel("Depratment: ");
		llecdep.setFont(new Font("Times New Roman", Font.BOLD, 17));
		box = new JComboBox();
		box.setBackground(SystemColor.text);
		box.setModel(new DefaultComboBoxModel(new String[] {"SCIENCE", "MANAGEMENT", "ARTS", "HUMANITIES", "BSC. COMPUTIING"}));
		
		
		
		llecadd = new JLabel("Address :");
		llecadd.setFont(new Font("Times New Roman", Font.BOLD, 17));
		tlecadd = new JTextField(40);
		llecemail = new JLabel("Email :");
		llecemail.setFont(new Font("Times New Roman", Font.BOLD, 17));
		tlecemail = new JTextField(40);
		llecnum = new JLabel("Phone number: ");
		llecnum.setFont(new Font("Times New Roman", Font.BOLD, 17));
		tlecnum = new JTextField(40);
	
		llecname.setBounds(20, 340, 140, 30);
		llectype.setBounds(20, 380, 140, 30);
		tlecname.setBounds(150, 340, 100, 30);
		typebox.setBounds(150, 380, 100, 30);
		llecdep.setBounds(30, 420, 140, 30);
		box.setBounds(150, 420, 100, 30);
		lecadd.setBounds(320, 467, 120, 40);
		lecup.setBounds(460, 467, 120, 40);
		lecdel.setBounds(600, 467, 120, 40);
		llecadd.setBounds(30, 460, 140, 30);
		tlecadd.setBounds(150, 460, 100, 30);
		llecemail.setBounds(30, 500, 140, 30);
		tlecemail.setBounds(150, 500, 100, 30);
		llecnum.setBounds(30, 540, 140, 30);
		tlecnum.setBounds(150, 540, 100, 30);
		lecadd.setBackground(Color.green);
		lecup.setBackground(Color.cyan);
		lecdel.setBackground(Color.red);
		lectPanel.setBackground(Color.white);
		lectPanel.add(llecname);
		lectPanel.add(llectype);
		lectPanel.add(tlecname);
		lectPanel.add(typebox);
		lectPanel.add(llecdep);
		lectPanel.add(box);
		lectPanel.add(lecadd);
		lectPanel.add(lecup);
		lectPanel.add(lecdel);
		lectPanel.add(llecadd);
		lectPanel.add(tlecadd);
		lectPanel.add(llecemail);
		lectPanel.add(tlecemail);
		lectPanel.add(llecnum);
		lectPanel.add(tlecnum);
		
		lectPanel.setVisible(false);
		mainPanel.add(lectPanel);
        
		fullPanel = new JPanel();
		fullPanel.setLayout(null);
		fullPanel.setBackground(Color.white);
		fullscroll = new JScrollPane(fulltable);
		fullPanel.add(fullscroll);
		fullscroll.setBounds(12, 10, 900, 300);
		fulltable = new JTable();
		
		fullscroll.setViewportView(fulltable);
		fulltable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		fulltab = (DefaultTableModel) fulltable.getModel();
		fulltab.setColumnIdentifiers(new String[] {"Lecturer Name", "Department", "Salary", "Address", "Email", "Phone number"});
		fulltable.setModel(fulltab);
		
		fulladd = new JButton("Add");
		fullup = new JButton("Update");
		fulldel = new JButton("Delete");
		lfullname = new JLabel("Lecturer Name: ");
		lfullname.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tfullname = new JTextField(40);
		lfulltype = new JLabel("Department: ");
		lfulltype.setFont(new Font("Times New Roman", Font.BOLD, 15));
		fullbox = new JComboBox();
		fullbox.setModel(new DefaultComboBoxModel(new String[] {"SCIENCE", "MANAGEMENT", "ARTS", "HUMANITIES", "BSC. COMPUTIING"}));
		
		
		lfulldep = new JLabel("Salary: ");
		lfulldep.setFont(new Font("Times New Roman", Font.BOLD, 17));
		tfulldep = new JTextField(40);
		lfulladd = new JLabel("Address :");
		lfulladd.setFont(new Font("Times New Roman", Font.BOLD, 17));
		tfulladd = new JTextField(40);
		lfullemail = new JLabel("Email :");
		lfullemail.setFont(new Font("Times New Roman", Font.BOLD, 17));
		tfullemail = new JTextField(40);
		lfullnum = new JLabel("Phone number: ");
		lfullnum.setFont(new Font("Times New Roman", Font.BOLD, 17));
		tfullnum = new JTextField(40);
	
		lfullname.setBounds(20, 340, 140, 30);
		lfulltype.setBounds(20, 380, 140, 30);
		tfullname.setBounds(150, 340, 100, 30);
		fullbox.setBounds(150, 380, 100, 30);
		lfulldep.setBounds(30, 420, 140, 30);
		tfulldep.setBounds(150, 420, 100, 30);
		lfulladd.setBounds(30, 460, 140, 30);
		tfulladd.setBounds(150, 460, 100, 30);
		lfullemail.setBounds(30, 500, 140, 30);
		tfullemail.setBounds(150, 500, 100, 30);
		lfullnum.setBounds(30, 540, 140, 30);
		tfullnum.setBounds(150, 540, 100, 30);
		
		
		fulladd.setBounds(320, 467, 120, 40);
		fullup.setBounds(460, 467, 120, 40);
		fulldel.setBounds(600, 467, 120, 40);
		fulladd.setBackground(Color.green);
		fullup.setBackground(Color.cyan);
		fulldel.setBackground(Color.red);
		fullPanel.setBackground(Color.white);
		fullPanel.add(lfullname);
		fullPanel.add(lfulltype);
		fullPanel.add(tfullname);
		fullPanel.add(fullbox);
		fullPanel.add(lfulldep);
		fullPanel.add(tfulldep);
		fullPanel.add(fulladd);
		fullPanel.add(fullup);
		fullPanel.add(fulldel);
		fullPanel.add(lfulladd);
		fullPanel.add(tfulladd);
		fullPanel.add(lfullemail);
		fullPanel.add(tfullemail);
		fullPanel.add(lfullnum);
		fullPanel.add(tfullnum);
		
		
		
		fullPanel.setVisible(false);
		mainPanel.add(fullPanel);

		partPanel = new JPanel();
		partPanel.setLayout(null);
		partPanel.setBackground(Color.white);
		partscroll = new JScrollPane(parttable);
		
		partPanel.add(partscroll);
		partscroll.setBounds(12, 10, 900, 300);
        parttable = new JTable();
		partscroll.setViewportView(parttable);
		parttable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		parttab = (DefaultTableModel) parttable.getModel();
		parttab.setColumnIdentifiers(new String[] {"Lecturer Name", "Department", "hourly par rate", "Address", "Email", "Phone number"});
		parttable.setModel(parttab);
		
		partadd = new JButton("Add");
		partup = new JButton("Update");
		partdel = new JButton("Delete");
		lpartname = new JLabel("Lecturer Name: ");
		lpartname.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tpartname = new JTextField(40);
		lparttype = new JLabel("Department: ");
		lparttype.setFont(new Font("Times New Roman", Font.BOLD, 15));
		partbox = new JComboBox();
		partbox.setModel(new DefaultComboBoxModel(new String[] {"SCIENCE", "MANAGEMENT", "ARTS", "HUMANITIES", "BSC. COMPUTIING"}));
		
		
		lpartdep = new JLabel("hourly pay rate: ");
		lpartdep.setFont(new Font("Times New Roman", Font.BOLD, 17));
		tpartdep = new JTextField(40);
		lpartadd = new JLabel("Address :");
		lpartadd.setFont(new Font("Times New Roman", Font.BOLD, 17));
		tpartadd = new JTextField(40);
		lpartemail = new JLabel("Email :");
		lpartemail.setFont(new Font("Times New Roman", Font.BOLD, 17));
		tpartemail = new JTextField(40);
		lpartnum = new JLabel("Phone number: ");
		lpartnum.setFont(new Font("Times New Roman", Font.BOLD, 17));
		tpartnum = new JTextField(40);
		
	
		lpartname.setBounds(20, 340, 140, 30);
		lparttype.setBounds(20, 380, 140, 30);
		tpartname.setBounds(150, 340, 100, 30);
		partbox.setBounds(150, 380, 100, 30);
		lpartdep.setBounds(20, 420, 140, 30);
		tpartdep.setBounds(150, 420, 100, 30);
		partadd.setBounds(320, 467, 120, 40);
		partup.setBounds(460, 467, 120, 40);
		partdel.setBounds(600, 467, 120, 40);
		lpartadd.setBounds(30, 460, 140, 30);
		tpartadd.setBounds(150, 460, 100, 30);
		lpartemail.setBounds(30, 500, 140, 30);
		tpartemail.setBounds(150, 500, 100, 30);
		lpartnum.setBounds(30, 540, 140, 30);
		tpartnum.setBounds(150, 540, 100, 30);
		
		partadd.setBackground(Color.green);
		partup.setBackground(Color.cyan);
		partdel.setBackground(Color.red);
		partPanel.setBackground(Color.white);
		partPanel.add(lpartname);
		partPanel.add(lparttype);
		partPanel.add(tpartname);
		partPanel.add(partbox);
		partPanel.add(lpartdep);
		partPanel.add(tpartdep);
		partPanel.add(partadd);
		partPanel.add(partup);
		partPanel.add(partdel);
		partPanel.add(lpartadd);
		partPanel.add(tpartadd);
		partPanel.add(lpartemail);
		partPanel.add(tpartemail);
		partPanel.add(lpartnum);
		partPanel.add(tpartnum);
		
		partPanel.setVisible(false);
		mainPanel.add(partPanel);

		contPanel = new JPanel();
		contPanel.setLayout(null);
		
		
		contPanel.setBackground(Color.white);
		contscroll = new JScrollPane(conttable);
		contPanel.add(contscroll);
		contscroll.setBounds(12, 10, 900, 300);
        conttable = new JTable();
		contscroll.setViewportView(conttable);
		conttable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		conttab = (DefaultTableModel) conttable.getModel();
		conttab.setColumnIdentifiers(new String[] {"Lecturer Name", "Department", "hourly Pay Rate", "Address", "Email", "Phone number"});
		conttable.setModel(conttab);
		
		contadd = new JButton("Add");
		contup = new JButton("Update");
		contdel = new JButton("Delete");
		lcontname = new JLabel("Lecturer Name: ");
		lcontname.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tcontname = new JTextField(40);
		lconttype = new JLabel("Department: ");
		lconttype.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contbox = new JComboBox();
		contbox.setModel(new DefaultComboBoxModel(new String[] {"SCIENCE", "MANAGEMENT", "ARTS", "HUMANITIES", "BSC. COMPUTIING"}));
		
		lcontdep = new JLabel("hourly pay rate: ");
		lcontdep.setFont(new Font("Times New Roman", Font.BOLD, 17));
		tcontdep = new JTextField(40);
		lcontadd = new JLabel("Address :");
		lcontadd.setFont(new Font("Times New Roman", Font.BOLD, 17));
		tcontadd = new JTextField(40);
		lcontemail = new JLabel("Email :");
		lcontemail.setFont(new Font("Times New Roman", Font.BOLD, 17));
		tcontemail = new JTextField(40);
		lcontnum = new JLabel("Phone number: ");
		lcontnum.setFont(new Font("Times New Roman", Font.BOLD, 17));
		tcontnum = new JTextField(40);
		
	
		lcontname.setBounds(20, 340, 140, 30);
		lconttype.setBounds(20, 380, 140, 30);
		tcontname.setBounds(150, 340, 100, 30);
		contbox.setBounds(150, 380, 100, 30);
		lcontdep.setBounds(20, 420, 140, 30);
		tcontdep.setBounds(150, 420, 100, 30);
		contadd.setBounds(320, 467, 120, 40);
		contup.setBounds(460, 467, 120, 40);
		contdel.setBounds(600, 467, 120, 40);
		lcontadd.setBounds(30, 460, 140, 30);
		tcontadd.setBounds(150, 460, 100, 30);
		lcontemail.setBounds(30, 500, 140, 30);
		tcontemail.setBounds(150, 500, 100, 30);
		lcontnum.setBounds(30, 540, 140, 30);
		tcontnum.setBounds(150, 540, 100, 30);
		
		contadd.setBackground(Color.green);
		contup.setBackground(Color.cyan);
		contdel.setBackground(Color.red);
		contPanel.setBackground(Color.white);
		contPanel.add(lcontname);
		contPanel.add(lconttype);
		contPanel.add(tcontname);
		contPanel.add(contbox);
		contPanel.add(lcontdep);
		contPanel.add(tcontdep);
		contPanel.add(contadd);
		contPanel.add(contup);
		contPanel.add(contdel);
		contPanel.add(lcontadd);
		contPanel.add(tcontadd);
		contPanel.add(lcontemail);
		contPanel.add(tcontemail);
		contPanel.add(lcontnum);
		contPanel.add(tcontnum);
		
		contPanel.setVisible(false);
		mainPanel.add(contPanel);
		
		
		
		
		
		Department.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
				homePanel.setVisible(false);
				departPanel.setVisible(true);
 				
			}
		});

		addLecturer.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent arg0) {
				homePanel.setVisible(false);
				departPanel.setVisible(false);
				lectPanel.setVisible(true);
			}
		});
		fullTime.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent e) {
				homePanel.setVisible(false);
				departPanel.setVisible(false);
				lectPanel.setVisible(false);
				fullPanel.setVisible(true);
			}
		});

		PartTime.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent e) {
				homePanel.setVisible(false);
				departPanel.setVisible(false);
				lectPanel.setVisible(false);
				fullPanel.setVisible(false);
				partPanel.setVisible(true);
			}
		});

		Contract.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseClicked(MouseEvent e) {
				homePanel.setVisible(false);
				departPanel.setVisible(false);
				lectPanel.setVisible(false);
				fullPanel.setVisible(false);
				partPanel.setVisible(false);
				contPanel.setVisible(true);
				
			}
		});

		add(Department);
		add(ldepartment);
		add(addLecturer);
		add(llect);
		add(fullTime);
		add(lfull);
		add(PartTime);
		add(lpart);
		add(Contract);
		add(lcontract);
		add(mainPanel);

		setVisible(true);
		logout = new JButton(out1);
		logout1 = new JButton(out2);
		llogout = new JLabel("Logout");
		llogout.setFont(new Font("Times new roman", Font.ITALIC, 25));
		logout.setBounds(850, 10, 70, 70);
		logout1.setBounds(850, 10, 70, 70);
		llogout.setBounds(850, 70, 100, 70);
		getContentPane().add(logout);
		getContentPane().add(logout1);
		getContentPane().add(llogout);

		logout.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent arg0) {
				logout.setVisible(false);
				logout1.setVisible(true);
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
				logout.setVisible(true);
				logout1.setVisible(false);
			}

			public void mouseClicked(MouseEvent e) {
			}
		});
	}


	
	public void logoutButton(ActionListener acl) {
		logout.addActionListener(acl);
	}
	
	public void AddButton(ActionListener Ab) {
		Add.addActionListener(Ab);	
	}
	
	public void DepartButton(ActionListener Da) {
		Department.addActionListener(Da);
	}
     
	public void UpdateButton(ActionListener Ub) {
		Update.addActionListener(Ub);
	}
     
	public void DeleteButton(ActionListener Db) {
		Delete.addActionListener(Db);
	}
	
	//for department
   
	public String getDeparmentName() {
		return tdepname.getText().toString();
	}
     
	public String getDeparmentType() {
		return depbox.getSelectedItem().toString();
	}
	
	public String getDepartmentUname() {
		return tdepuname.getText().toString();
	}
	public String getDpartmentpassword() {
		return tdeppassword.getText().toString();
	}
	
	public void SuccMsg() {
		 JOptionPane.showMessageDialog(null, "Is Added");
	 }
	public JTable getdepartdisplay() {
		return Deptable;
	}
	public DefaultTableModel getdepartdata() {
		return departtab;
	}
	
	public void adddepart_table(String n, String t, String u, String p) {
		tdepname.setText(n);
		depbox.setSelectedItem(t);
		tdepuname.setText(u);
		tdeppassword.setText(p);
	}
	
	
	
	
	//for lecturer
	public String getLecturerName() {
		return tlecname.getText().toString();
	}
     
	public String getLecturerType() {
		return typebox.getSelectedItem().toString();
	}
	
	public String getLecturerdepart() {
		return box.getSelectedItem().toString();
	}
	public String getLectureraddress() {
		return tlecadd.getText().toString();
	}
	
	public String getLectureremail() {
		return tlecemail.getText().toString();
	}
	public String getLecturerphnum() {
		return tlecnum.getText().toString();
	}
	
	public JTable getlectdisplay() {
		return lecttable;
	}
	public DefaultTableModel getlectdata() {
		return lecttab;
	}
	
	public void addlect_table(String n, String t, String d, String ad, String e, String ph) {
		tlecname.setText(n);
		typebox.setSelectedItem(t);
		box.setSelectedItem(d);
		tlecadd.setText(ad);
		tlecemail.setText(e);
		tlecnum.setText(ph);
	}
	
	public void AddlectButton(ActionListener Al) {
		lecadd.addActionListener(Al);	
	}
	
	public void DeletelectButton(ActionListener db) {
		lecdel.addActionListener(db);
	}
	
	public void UpdatelectButton(ActionListener ub) {
		lecup.addActionListener(ub);
	}
	
	
	//for full time lecturer
	
	public String getfullName() {
		return tfullname.getText().toString();
	}
     
	public String getfullType() {
		return fullbox.getSelectedItem().toString();
	}
	
	public String getfulldepart() {
		return tfulldep.getText().toString();
	}
	public String getfulladdress() {
		return tfulladd.getText().toString();
	}
	
	public String getfullemail() {
		return tfullemail.getText().toString();
	}
	public String getfullphnum() {
		return tfullnum.getText().toString();
	}
	
	public JTable getfulldisplay() {
		return fulltable;
	}
	public DefaultTableModel getfulldata() {
		return fulltab;
	}
	
	public void addfull_table(String n, String t, String s, String ad, String e, String ph) {
		tfullname.setText(n);
		fullbox.setSelectedItem(t);
		tfulldep.setText(s);
		tfulladd.setText(ad);
		tfullemail.setText(e);
		tfullnum.setText(ph);
	}
	
	public void AddfullButton(ActionListener Al) {
		fulladd.addActionListener(Al);	
	}
	
	public void DeletefullButton(ActionListener Al) {
		fulldel.addActionListener(Al);
	}
	
	public void UpdatefullButton(ActionListener al) {
		fullup.addActionListener(al);
		
	}
	
	
	
	//for part time lecturer
	
	public String getpartName() {
		return tpartname.getText().toString();
	}
     
	public String getpartType() {
		return partbox.getSelectedItem().toString();
	}
	
	public String getpartdepart() {
		return tpartdep.getText().toString();
	}
	public String getpartaddress() {
		return tpartadd.getText().toString();
	}
	
	public String getpartemail() {
		return tpartemail.getText().toString();
	}
	public String getpartphnum() {
		return tpartnum.getText().toString();
	}
	
	public JTable getpartdisplay() {
		return parttable;
	}
	public DefaultTableModel getpartdata() {
		return parttab;
	}
	
	public void addpart_table(String n, String t, String p, String ad, String e, String ph) {
		tpartname.setText(n);
		partbox.setSelectedItem(t);
		tpartdep.setText(p);
		tpartadd.setText(ad);
		tpartemail.setText(e);
		tpartnum.setText(ph);
	}
	
	public void AddpartButton(ActionListener Al) {
		partadd.addActionListener(Al);	
	}
	
	public void DeletepartButton(ActionListener Dp) {
		partdel.addActionListener(Dp);
	}
	
	public void UpdatepartButton(ActionListener Up) {
	     partup.addActionListener(Up);	
	}
	
	//for contract lecturer
	public String getcontName() {
		return tcontname.getText().toString();
	}
     
	public String getcontType() {
		return contbox.getSelectedItem().toString();
	}
	
	public String getcontdepart() {
		return tcontdep.getText().toString();
	}
	public String getcontaddress() {
		return tcontadd.getText().toString();
	}
	
	public String getcontemail() {
		return tcontemail.getText().toString();
	}
	public String getcontphnum() {
		return tcontnum.getText().toString();
	}
	
	public JTable getcontdisplay() {
		return conttable;
	}
	public DefaultTableModel getcontdata() {
		return conttab;
	}
	
	public void addcont_table(String n, String t, String p, String ad, String e, String ph) {
		tcontname.setText(n);
		contbox.setSelectedItem(t);
		tcontdep.setText(p);
		tcontadd.setText(ad);
		tcontemail.setText(e);
		tcontnum.setText(ph);
	}
	
	public void AddcontButton(ActionListener Al) {
		contadd.addActionListener(Al);	
	}
	
	public void DeletecontButton(ActionListener Ad) {
		contdel.addActionListener(Ad);	
	}
	
	public void UpdatecontButton(ActionListener Ap) {
		contup.addActionListener(Ap);	
	}
	
}

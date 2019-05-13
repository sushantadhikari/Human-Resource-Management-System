package view_files;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUI_secreatary extends JFrame{
	
	private JButton Department, addLecturer, fullTime, PartTime, Contract, homePanel, logout, logout1; 
	private JPanel  mainPanel, lectPanel, departPanel, fullPanel, partPanel, contPanel;
	private JLabel lname, lusername, ldepart, lmodule, ltype, ldepartment, llect, lfull, lpart, lcontract, llogout,
			ldepname, ldeptype, ldepno, ldepuname, ldeppassword, llecname, llecdep, llectype, lfullname, lfulldep, lfulltype, lpartname, lpartdep, lparttype, lcontname, lcontdep, lconttype, lfulladd, lfullemail, lfullnum, lpartadd, lpartemail, lpartnum, lcontadd, lcontemail, lcontnum, llecadd, llecemail, llecnum ;
	private JTable Deptable, lecttable, fulltable, parttable, conttable;
	private DefaultTableModel departtab, lecttab, fulltab, parttab, conttab;
	private JScrollPane scroll, lectscroll, fullscroll, contscroll, partscroll;
	
	ImageIcon department = new ImageIcon("images/department.png");
	ImageIcon secreatary = new ImageIcon("images/secreatary.png");
	ImageIcon full_time = new ImageIcon("images/full_time.png");
	ImageIcon part_time = new ImageIcon("images/part_time.jpg");
	ImageIcon cont = new ImageIcon("images/contract.png");

	ImageIcon out1 = new ImageIcon("images/logout.png");
	ImageIcon out2 = new ImageIcon("images/logout1.png");
	
	public GUI_secreatary() {
		
		setSize(1000, 870);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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

//		logout.addMouseListener(new MouseListener() {
//
//			public void mouseReleased(MouseEvent arg0) {
//				logout.setVisible(false);
//				logout1.setVisible(true);
//			}
//
//			public void mousePressed(MouseEvent arg0) {
//			}
//
//			public void mouseExited(MouseEvent arg0) {
//			}
//
//			public void mouseEntered(MouseEvent arg0) {
//				logout.setVisible(true);
//				logout1.setVisible(false);
//			}
//
//			public void mouseClicked(MouseEvent e) {
//			}
//		});
	}


	
	public void logoutButton(ActionListener acl) {
		logout.addActionListener(acl);
	}

	public JTable getdepartdisplay() {
		return Deptable;
	}
	public DefaultTableModel getdepartdata() {
		return departtab;
	}
	
	public JTable getlectdisplay() {
		return lecttable;
	}
	public DefaultTableModel getlectdata() {
		return lecttab;
	}
	
	public JTable getfulldisplay() {
		return fulltable;
	}
	public DefaultTableModel getfulldata() {
		return fulltab;
	}
	
	public JTable getpartdisplay() {
		return parttable;
	}
	public DefaultTableModel getpartdata() {
		return parttab;
	}
	
	public JTable getcontdisplay() {
		return conttable;
	}
	public DefaultTableModel getcontdata() {
		return conttab;
	}
	
	}



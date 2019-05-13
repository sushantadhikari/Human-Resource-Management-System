package view_files;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUI_admin_login extends JFrame {
	
	private JButton click = new JButton("Login");
	private JLabel  luser, lpassword, login, human;
	private JComboBox combo ;
	private JPasswordField tpassword = new JPasswordField(20);
	private JTextField tuser = new JTextField(20);
public GUI_admin_login(){

	super("Login Page");
	setSize(700, 600);
	setLocationRelativeTo(null);
	getContentPane();
    setVisible(true);
    JPanel panel1 = new JPanel();
    panel1.setBackground(Color.green);
    add(panel1);
    
    human= new JLabel("Human Resource  Management System");
    login = new JLabel("Login Here");
    human.setBounds(30,5,600,100);
    login.setBounds(250,100,300,100);
    login.setFont(new Font("Times new roman", Font.BOLD, 35));
    human.setFont(new Font("Times new roman", Font.BOLD, 35));
    JLabel luser=new JLabel("Enter the username :");
    luser.setFont(new Font("Times new roman", Font.BOLD, 25));
    JLabel lpassword=new JLabel("Enter the password :");
    lpassword.setFont(new Font("Times new roman", Font.BOLD, 25));
    
//    combo = new JComboBox();
////    combo.setForeground(Color.WHITE);
////	combo.setBackground(Color.light);
//	combo.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Department Secretary"}));
//	combo.setBounds(10, 265, 200, 50);
//    panel1.add(combo);
    
    panel1.setLayout(null);
    panel1.add(luser);
    luser.setBounds(40,180,300,100);
    panel1.add(tuser);
    tuser.setBounds(270, 220,300,28);
    panel1.add(lpassword);
    lpassword.setBounds(40,250,300,100);
    panel1.add(tpassword);
    tpassword.setBounds(270,290,300,28);
    panel1.add(human);
    panel1.add(login);
    panel1.add(click);
    click.setBounds(320, 370, 100, 50);
    
   
    setVisible(true);
    
}

public void ActionClick(ActionListener ae) {
	click.addActionListener(ae);
}

public void loginFail() {
	JOptionPane.showMessageDialog(null, "**** Incorrect Username or password*****");
}
public String getUname() {
	return tuser.getText();
}
public String getUpassword() {
	return tpassword.getText();
}

public JComboBox getChoice() {
	return combo;
}

}

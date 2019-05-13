package files;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import controller_files.Controller_admin;
import model_files.AdminHomeModel;
import model_files.Model_Admin;
import view_files.GUI_admin;
import view_files.GUI_admin_login;

public class Test_page {
	public static void main(String []args){
		GUI_admin_login GUI1=new GUI_admin_login(); 
		Model_Admin ma = new Model_Admin();
		Controller_admin ca=new Controller_admin(GUI1,ma);
		ca.clickAction();
			
	}
}

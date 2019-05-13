package controller_files;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model_files.AdminHomeModel;
import model_files.Model_Admin;
import model_files.Model_secretary;
import view_files.GUI_admin;
import view_files.GUI_admin_login;
import view_files.GUI_secreatary;

public class Controller_admin {
private GUI_admin_login login_view;
private Model_Admin login_model;
private GUI_secreatary secretary;

public Controller_admin(GUI_admin_login login_view, Model_Admin login_model) {
	this.login_view= login_view;
	this.login_model = login_model;
}

public void clickAction() {
	login_view.ActionClick(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent a) {
		
			if(login_model.check_login(login_view.getUname(),login_view.getUpassword())==true) {
				GUI_admin adminHome= new GUI_admin();
				AdminHomeModel model = new AdminHomeModel();
				AdminHomeController controller = new AdminHomeController(model, adminHome);
				controller.logout();
				controller.Adddepartment();
				controller.display();
				controller.DeleteDepart();
				controller.EditDepart();
				controller.DepartrowSelected();
				
				
				controller.Addlecturer();
				controller.displaylect();
      			controller.DeleteLect();
				controller.EditLect();
				controller.LecturerowSelected();
				
				
				controller.Addfulltime();
				controller.displayfull();
				controller.Deletefull();
				controller.Editfull();
				controller.fullrowSelected();
				
				controller.Addparttime();
				controller.displaypart();
				controller.Deletepart();
				controller.Editpart();
				controller.partrowSelected();
				
				
				controller.Addconttime();
				controller.displaycont();
				controller.Deletecont();
				controller.Editcont();
				controller.controwSelected();
				login_view.dispose();
				
				
			}
			else if(login_model.check_department(login_view.getUname(),login_view.getUpassword())) {
				GUI_secreatary secreatary = new GUI_secreatary();
				Model_secretary ma = new Model_secretary();
				Controller_secretary cs = new Controller_secretary(ma , secreatary);
				cs.data = login_model.getLogin();
			    cs.logout();
				cs.displayinrow();
				cs.displaylectrow();
				cs.displayfullrow();
				cs.displaypartrow();
				cs.displaycontrow();
			}
	
			else {
				login_view.loginFail();
			}
			
		}
	});
}


}


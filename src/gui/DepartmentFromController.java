package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFromController implements Initializable{
	
	private Department entity;
	
	@FXML
	private Label erroLabel;
	
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtName;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btName;
	
	@FXML
	public void onButtonSave() {
		System.out.println("onButtonSave");
	}
	
	public void setDepartment(Department entity) {
		this.entity=entity;
	}
	
	@FXML
	public void onButtonCancel() {
		System.out.println("onButtonName");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
			
		initializeNodes();
	}
    
	private void initializeNodes() {
		gui.util.Constraints.setTextFieldInteger(txtId);
		gui.util.Constraints.setTextFieldMaxLength(txtName, 30);
	}
	
	public void updateFormData() {
		if(entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

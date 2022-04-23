package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFromController implements Initializable{
	
	private Department entity;
	
	private DepartmentService service;
	
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
	public void onButtonSave(ActionEvent event) {
		if(entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		if(service == null) {
			throw new IllegalStateException("Service was null");
		}
		entity = getFormatDate();
		service.saveOrUpdata(entity);
		Utils.currentStage(event).close();
	}
	
	private Department getFormatDate() {
		Department obj = new Department();
		
		obj.setId(Utils.tryParseInt(txtId.getText()));
		obj.setName(txtName.getText());
		
		return obj;
	}
	
	public void setDepartment(Department entity) {
		this.entity=entity;
	}
	public void setDepartmentService(DepartmentService service) {
		this.service=service;
	}
	
	@FXML
	public void onButtonCancel(ActionEvent event) {
		Utils.currentStage(event).close();
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

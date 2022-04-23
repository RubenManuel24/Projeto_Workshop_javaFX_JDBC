package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import db.DbException;
import gui.listeners.DataChangeListener;
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
	
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();
	
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
		try {
			
		entity = getFormatDate();
		service.saveOrUpdata(entity);
		notifyDataChangeListerners();
		Utils.currentStage(event).close();
		
		}
		catch(DbException e){
			e.getMessage();
		}
		
	}
	
	private void notifyDataChangeListerners() {
		for(DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged();
		}
		
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
	
	public void subscribeDataChangeListeners(DataChangeListener listener) {
		dataChangeListeners.add(listener);
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

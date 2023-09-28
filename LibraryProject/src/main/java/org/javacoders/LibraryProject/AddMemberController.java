package org.javacoders.LibraryProject;

import org.javacoders.dao.Dao;
import org.javacoders.entity.Member;
import org.javacoders.error.ErrorHandler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddMemberController {

    @FXML
    private Button cancelButton;

    @FXML
    private TextField email;

    @FXML
    private TextField id;

    @FXML
    private TextField mobile;

    @FXML
    private TextField name;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button saveButton;
    
    Dao dao;

    @FXML
    void addMember(ActionEvent event) {
    	ErrorHandler errorHandler = 
    			new ErrorHandler(id.getText(), name.getText(), mobile.getText(), email.getText(), "AdditionalString");
    	
    	Member member = new Member(id.getText(), name.getText(), mobile.getText(), email.getText());
    	
    	dao = new Dao(member);
    	
    	if(dao.addMember(member)) {
    		errorHandler.success();
    	} else {
    		errorHandler.failed();
    	}
    }

    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage)rootPane.getScene().getWindow();
    	stage.close();
    }

}

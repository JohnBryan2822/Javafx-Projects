package org.javacoders.LibraryProject;

import org.javacoders.dao.Dao;
import org.javacoders.error.ErrorHandler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddBookController {
	
	@FXML
    private AnchorPane rootPane;
	@FXML
    private TextField id;
	@FXML
    private TextField title;
    @FXML
    private TextField author;
    @FXML
    private TextField publisher;
    @FXML
    private TextField quantity;
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;

    Dao dao;
    ErrorHandler errorHandler;

    @FXML
    void addBook(ActionEvent event) {
    	errorHandler = new ErrorHandler(id.getText(), title.getText(), author.getText(),
    			publisher.getText(), quantity.getText());
    	
    	Book book = new Book(Integer.parseInt(id.getText()), title.getText(), author.getText(),
    			publisher.getText(), Integer.parseInt(quantity.getText()));
    	
    	dao = new Dao(book);
    	
    	if(dao.addBook(book)) {
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

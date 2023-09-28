package org.javacoders.LibraryProject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController implements Initializable {
	
	@FXML
    void loadAddBook(ActionEvent event) {
		loadWindow("addBookScene.fxml", "New Book");
    }

    @FXML
    void loadAddMember(ActionEvent event) {
    	loadWindow("addMemberScene.fxml", "New Member");
    }

    @FXML
    void loadBookTable(ActionEvent event) {
    	loadWindow("listBooks.fxml", "Book List");
    }

    @FXML
    void loadMemberTable(ActionEvent event) {
    	loadWindow("listMembersScene.fxml", "Member List");
    }
    
    void loadWindow(String loc, String title) {
    	try {
			Parent parent = FXMLLoader.load(getClass().getResource(loc));
			Stage stage = new Stage(StageStyle.DECORATED);
			stage.setTitle(title);
			stage.setScene(new Scene(parent));
			stage.show();
		} catch (IOException e) {
			Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, e);
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}




























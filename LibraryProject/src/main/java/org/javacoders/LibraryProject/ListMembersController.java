package org.javacoders.LibraryProject;

import java.net.URL;
import java.util.ResourceBundle;

import org.javacoders.dao.Dao;
import org.javacoders.entity.Member;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ListMembersController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<Member> tableView;
    @FXML
    private TableColumn<Member, String> nameCol;
    @FXML
    private TableColumn<Member, String> idCol;
    @FXML
    private TableColumn<Member, String> mobileCol;
    @FXML
    private TableColumn<Member, String> emailCol;
    
    Dao dao = new Dao(new Member());

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initCol();
		
		tableView.setItems(dao.getAllMembers());
	}
	
	private void initCol() {
		nameCol.setCellValueFactory(new PropertyValueFactory<Member, String>("name"));
		idCol.setCellValueFactory(new PropertyValueFactory<Member, String>("id"));
		mobileCol.setCellValueFactory(new PropertyValueFactory<Member, String>("mobile"));
		emailCol.setCellValueFactory(new PropertyValueFactory<Member, String>("email"));
	}

}

package org.javacoders.LibraryProject;

import java.net.URL;
import java.util.ResourceBundle;

import org.javacoders.dao.Dao;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ListBooksController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<Book> tableView;
	@FXML
    private TableColumn<Book, Integer> idCol;
    @FXML
    private TableColumn<Book, String> titleCol;
    @FXML
    private TableColumn<Book, String> authorCol;
    @FXML
    private TableColumn<Book, String> publisherCol;
    @FXML
    private TableColumn<Book, Integer> quantityCol;
    
    Dao dao = new Dao(new Book());
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initCol();
		
		tableView.setItems(dao.getAllBooks());
	}

	private void initCol() {
		idCol.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
		titleCol.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		authorCol.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
		publisherCol.setCellValueFactory(new PropertyValueFactory<Book, String>("publisher"));
		quantityCol.setCellValueFactory(new PropertyValueFactory<Book, Integer>("quantity"));
	}


}










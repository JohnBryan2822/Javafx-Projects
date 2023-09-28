package org.javacoders.error;

import javafx.scene.control.Alert;

public class ErrorHandler {
	
	private String bookId;
	private String bookTitle;
	private String bookAuthor;
	private String bookPublisher;
	private String bookQuantity;

	public ErrorHandler(String bookId, String bookTitle, String bookAuthor, String bookPublisher, String bookQuantity) {
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookQuantity = bookQuantity;
		
		checkAllFieldsIfEmpty();
	}



	private void checkAllFieldsIfEmpty() {
		if(bookId.isEmpty() || bookTitle.isEmpty() || bookAuthor.isEmpty() || bookPublisher.isEmpty() || bookQuantity.isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Please fill the form!!!");
			alert.showAndWait();
			return;
		}
	}
	
	public void failed() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setContentText("Failed");
		alert.showAndWait();
		return;
	}
	
	public void success() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setContentText("Success");
		alert.showAndWait();
		return;
	}

}

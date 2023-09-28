module covid05 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires retrofit2;
	requires retrofit2.converter.gson;
	requires gson;
	requires unirest.java;
	
	opens application to javafx.graphics, javafx.fxml;
}

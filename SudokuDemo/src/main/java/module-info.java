module org.javacoders.SudokuDemo {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens org.javacoders.SudokuDemo to javafx.fxml;
    exports org.javacoders.SudokuDemo;
}

module application {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires javafx.graphics;

    opens application.gui to javafx.fxml;
    exports application.gui;
}

module org.javacoders.CovidWidgetFX {
    requires javafx.controls;
    requires javafx.fxml;
	requires retrofit2;
	requires retrofit2.converter.gson;
	requires gson;
	requires javafx.graphics;

    opens org.javacoders.CovidWidgetFX to javafx.fxml;
    exports org.javacoders.CovidWidgetFX;
    opens org.javacoders.CovidWidgetFX.gui.widget to javafx.fxml;
}

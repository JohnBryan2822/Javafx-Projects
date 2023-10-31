package application.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	@SuppressWarnings("exports")
	@Override
    public void start(Stage stage) throws IOException {
		URL location = this.getClass().getResource("gameLayout.fxml");
		ResourceBundle resource = null;
		FXMLLoader loader = new FXMLLoader(location, resource);
    	Parent root = loader.load();
    	GuiController guiController = loader.getController();
    	
        Scene scene = new Scene(root, 400, 510);
        stage.setTitle("TetrisFX");
        stage.setScene(scene);
        stage.show();
        
        new GameController(guiController);
    }

    public static void main(String[] args) {
        launch();
    }
}

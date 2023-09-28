package org.javacoders.CovidWidgetFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import org.javacoders.CovidWidgetFX.gui.widget.CallingFXML;

public class App extends Application {
	
	private double xOffset;
	private double yOffset;

    @Override
    public void start(Stage stage) throws IOException {
    	stage.initStyle(StageStyle.UTILITY);
    	stage.setOpacity(0);
    	stage.show();
    	
    	Stage secondaryStage = new Stage();
    	secondaryStage.initStyle(StageStyle.UNDECORATED);
    	secondaryStage.initOwner(stage);
    	System.out.println("before");
    	Parent root = new CallingFXML().getFXML();
    	System.out.println("after");
        Scene scene = new Scene(root);
        secondaryStage.setScene(scene);
        secondaryStage.show();
        // Make it right-top aligned
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        secondaryStage.setX(visualBounds.getMaxX() - 25 - scene.getWidth());
        secondaryStage.setY(visualBounds.getMinY() + 25);
        
        // Add support for drage and move
        // Drag = mouse click + drag
        scene.setOnMousePressed(event -> {
        	xOffset = secondaryStage.getX() - event.getScreenX();
        	yOffset = secondaryStage.getY() - event.getScreenY();
        });
        scene.setOnMouseDragged(event -> {
        	secondaryStage.setX(event.getScreenX() + xOffset);
        	secondaryStage.setY(event.getScreenY() + yOffset);
        });
    }

    public static void main(String[] args) {
        launch();
    }

}
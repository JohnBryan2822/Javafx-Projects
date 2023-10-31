package org.javacoders.webcamtutorial;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String[] args) throws IOException {
		
//		Webcam webcam = Webcam.getDefault();
//		
//		for(Dimension supportedSize: webcam.getViewSizes()) {
//			System.out.println(supportedSize.toString());
//		}
//		
//		webcam.setViewSize(WebcamResolution.VGA.getSize());
//		
//		webcam.open();
//		
//		webcam.close();
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(this.getClass().getResource("CamGUI.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
















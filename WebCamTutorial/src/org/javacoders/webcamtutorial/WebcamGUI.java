package org.javacoders.webcamtutorial;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WebcamGUI {
	
	private Webcam webcam;
	
	public WebcamGUI() {
//		initComponents();
		webcam = Webcam.getDefault();
		webcam.setViewSize(new Dimension(640, 480));
		webcam.open();
	}
	
	@FXML
    private ImageView imageView;
	
    @FXML
    void captureButtonOnPressed(ActionEvent event) throws IOException {
    	ImageIO.write(webcam.getImage(), "JPG", new File("firstCapture.jpg"));
    	
    	Image image = new Image("firstCapture.jpg");
    	
    	imageView.setImage(image);
    }

	
}

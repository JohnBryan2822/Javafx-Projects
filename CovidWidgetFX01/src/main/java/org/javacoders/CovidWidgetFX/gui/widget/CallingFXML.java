package org.javacoders.CovidWidgetFX.gui.widget;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class CallingFXML {
	
	public Parent getFXML() {
		try {
			return FXMLLoader.load(getClass().getResource("Widget.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

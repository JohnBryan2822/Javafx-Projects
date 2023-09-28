package application;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterConfig {
	
	FileWriter fileWriter = null;
	
	public FileWriterConfig() {
		try {
			this.fileWriter = new FileWriter("Settings.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeToFile(ConfigModel configModel) {
		try {
			fileWriter.close();
			fileWriter.write("Refresh_Interval_In_Seconds: "
						+ Integer.toString(configModel.getRefreshIntervalInSeconds()) + "\n");
			fileWriter.write("Country_Name: " + configModel.getCountryName() + "\n");
			fileWriter.write("Country_Code: " + configModel.getCountryCode()); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

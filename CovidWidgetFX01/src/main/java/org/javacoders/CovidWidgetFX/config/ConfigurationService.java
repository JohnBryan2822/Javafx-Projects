package org.javacoders.CovidWidgetFX.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConfigurationService {
	private final File SETTINGS_FILE = new File("settings.json");
	private Gson gson = null;
	
	public ConfigModel getConfiguration() {
		System.out.println("Hello 3");
		gson = new GsonBuilder().create();
		System.out.println("Hello 3");
		if(!SETTINGS_FILE.exists()) {
			createSettingSFile();
		}
		
		return getConfigurationFromFile();
	}
	
	private ConfigModel getConfigurationFromFile() {
		try (Reader reader = new FileReader(SETTINGS_FILE)){
			
			return gson.fromJson(reader, ConfigModel.class);
			
	 	} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void createSettingSFile() {
		System.out.println("Hello 1");
		ConfigModel configModel = new ConfigModel();
		try (Writer writer = new FileWriter(SETTINGS_FILE, false)){
			System.out.println("Hello 2");
			gson.toJson(configModel, writer);
			System.out.println("Hello 3");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package application;

import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConfigurationService {
    private final File SETTTINGS_FILE = new File("settings.json");
    
    
    // THIS LINE IS GIVING ERROR
    private Gson gson = new GsonBuilder().create();
//    ObjectMapper objectMapper = new ObjectMapper();
    
    
    
    public ConfigModel getConfiguration() throws Exception {
    	
        if (!SETTTINGS_FILE.exists()) {
            createSettingsFile();
        }
        return getConfigurationFromFile();
    }

    private ConfigModel getConfigurationFromFile() {
        try (Reader reader = new FileReader(SETTTINGS_FILE)) {
            // Serialize the ConfigModel to JSON and write it to the file
//            objectMapper.writeValue(SETTTINGS_FILE, configModel);
        	return gson.fromJson(reader, ConfigModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
    }

    private void createSettingsFile() throws IOException {
        ConfigModel configModel = new ConfigModel();
        try (Writer writer = new FileWriter(SETTTINGS_FILE, false)) {
            gson.toJson(configModel, writer);
        }
    }
}

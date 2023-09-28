package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Window;

public class SampleController implements Initializable {
	
	private ScheduledExecutorService executorService;
    private ConfigModel configModel;
	
	@FXML
    private AnchorPane rootPane;

    @FXML
    private Text textCountryReport;

    @FXML
    private Text textCoutryCode;

    @FXML
    private Text textGlobalReport;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
            configModel = new ConfigModel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        initializeScheduler();
        initializeContextMenu();
        textCoutryCode.setText(configModel.getCountryCode());
	}

	private void initializeContextMenu() {
		MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(event -> {
            System.exit(0);
        });

        MenuItem refreshItem = new MenuItem("Refresh now");
        refreshItem.setOnAction(event -> {
            executorService.schedule(this::loadData, 0, TimeUnit.SECONDS);
        });

        final ContextMenu contextMenu = new ContextMenu(exitItem, refreshItem);
        rootPane.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            if (event.isSecondaryButtonDown()) {
                contextMenu.show(rootPane, event.getScreenX(), event.getScreenY());
            } else {
                if (contextMenu.isShowing()) {
                    contextMenu.hide();
                }
            }
        });
	}

	private void initializeScheduler() {
		executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(this::loadData, 0, configModel.getRefreshIntervalInSeconds(), TimeUnit.SECONDS);
	}
	
	private void loadData() {
        System.out.println("Refreshing data...1");

        DataProviderService dataProviderService = new DataProviderService();
        CovidDataModel covidDataModel = dataProviderService.getData2(configModel.getCountryName());
        System.out.println(covidDataModel.getCountryData());
        System.out.println(covidDataModel.getGlobalData());

        Platform.runLater(() -> {
            inflateData(covidDataModel);
        });
    }
	
	private void inflateData(CovidDataModel covidDataModel) {
        GlobalData globalData = covidDataModel.getGlobalData();
        textGlobalReport.setText(getFormattedData(globalData.getCases(), globalData.getRecovered(), globalData.getDeaths()));

        CountryData countryData = covidDataModel.getCountryData();
        textCountryReport.setText(getFormattedData(countryData.getCases(), countryData.getRecovered(), countryData.getDeaths()));

        readjustStage(textCoutryCode.getScene().getWindow());
    }
	
	private String getFormattedData(long totalCases, long recoveredCases, long totalDeaths) {
        return String.format("Cases: %-8d | Recovered: %-6d | Deaths: %-6d", totalCases, recoveredCases, totalDeaths);
    }
	
	private void readjustStage(Window stage) {
        stage.sizeToScene();

        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        stage.setX(visualBounds.getMaxX() - 25 - textCoutryCode.getScene().getWidth());
        stage.setY(visualBounds.getMinY() + 25);
    }

}

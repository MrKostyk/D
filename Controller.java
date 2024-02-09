package com.example.weatherbroadcast.Controllers;

import com.example.weatherbroadcast.Modules.APIModule;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Platform;

public class Controller {
    public Controller(){
        APIModule apiModule = new APIModule(this);
    }

    @FXML
    public ComboBox<String> citySelector;

    @FXML
    public Label cityName;

    @FXML
    public Label cityTemp;

    @FXML
    public ImageView weatherImg;

    @FXML
    private Button todayButton;

    @FXML
    private Button tomorrowButton;

    @FXML
    private Button dayAfterTomorrowButton;

    @FXML
    private void showTodayTemperature() {

        System.out.println("Today's temperature button clicked");
    }

    @FXML
    private void showTomorrowTemperature() {

        System.out.println("Tomorrow's temperature button clicked");
    }

    @FXML
    private void showDayAfterTomorrowTemperature() {

        System.out.println("Day after tomorrow's temperature button clicked");
    }

    public void setWeatherImage(String icon) {
        String imageUrl = "http://openweathermap.org/img/wn/" + icon + ".png";
        Image image = new Image(imageUrl);
        weatherImg.setImage(image);
    }
}
package com.example.weatherbroadcast.Modules;

import com.example.weatherbroadcast.Controllers.Controller;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.application.Platform;

public class Parser {
    private final Controller controller;
    private final String jsonResponse;

    public Parser(String jsonResponse, Controller controller) {
        this.jsonResponse = jsonResponse;
        this.controller = controller;
    }

    public void parseJSON() {
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        String cityName = jsonObject.getAsJsonObject("city").get("name").getAsString();
        JsonObject main = jsonObject.getAsJsonArray("list").get(0).getAsJsonObject().getAsJsonObject("main");
        double temperature = main.get("temp").getAsDouble();
        String weatherIcon = jsonObject.getAsJsonArray("list").get(0).getAsJsonObject()
                .getAsJsonArray("weather").get(0).getAsJsonObject().get("icon").getAsString();

        Platform.runLater(() -> {
            controller.cityName.setText(cityName);
            controller.cityTemp.setText(String.valueOf(temperature));
            controller.setWeatherImage(weatherIcon);
        });
    }
}
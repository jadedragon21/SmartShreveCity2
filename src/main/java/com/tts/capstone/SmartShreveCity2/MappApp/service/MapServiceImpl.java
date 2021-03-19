package com.tts.capstone.SmartShreveCity2.MappApp.service;

import com.tts.capstone.SmartShreveCity2.MappApp.model.GeocodingResponse;
import com.tts.capstone.SmartShreveCity2.MappApp.model.Location;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MapServiceImpl implements MapService{

    @Value("${API_KEY}")
    private String apiKey;


    @Override
    public void addCoordinates(Location location) {
        System.out.println("Here is my key: " + apiKey);
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" +
                location.getCity() + "," + location.getState() + "&key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
        Location coordinates = response.getResults().get(0).getGeometry().getLocation();

        location.setLat(coordinates.getLat());
        location.setLng(coordinates.getLng());

    }
}